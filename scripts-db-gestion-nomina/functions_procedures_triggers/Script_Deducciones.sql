/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte obligatorio del empleado al sistema de salud (4% del sueldo).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_salud_empleado (
    @pn_sueldo DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN @pn_sueldo * 0.04;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte obligatorio del empleado al sistema de pensión (4% del sueldo).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_pension_empleado (
    @pn_sueldo DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN @pn_sueldo * 0.04;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el fondo de solidaridad pensional (1%) si el salario es mayor a 4 SMLV.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_fondo_solidaridad (
    @pn_salario DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    IF @pn_salario > (1423500 * 4)
        RETURN ROUND(@pn_salario * 0.01, 2);
    RETURN 0;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula la retención en la fuente mensual según el procedimiento del artículo 383 del Estatuto Tributario.
             Aplica descuentos por salud, pensión, fondo de solidaridad y la renta exenta del 25% limitada a 240 UVT. 
             Calcula la base gravable en UVT y aplica la tarifa correspondiente según el rango.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_retefuente (
    @pn_salario DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE 
        @vn_uvt DECIMAL(18,2) = 49799,
        @vn_aporte_salud DECIMAL(18,2),
        @vn_aporte_pension DECIMAL(18,2),
        @vn_fondo_solidaridad DECIMAL(18,2),
        @vn_ingreso_neto DECIMAL(18,2),
        @vn_renta_exenta DECIMAL(18,2),
        @vn_base_retencion DECIMAL(18,2),
        @vn_base_uvt DECIMAL(18,2),
        @vn_tarifa DECIMAL(5,2),
        @vn_limite_inf_uvt DECIMAL(18,2),
        @vn_uvt_adicionales DECIMAL(18,2),
        @vn_rete_pesos DECIMAL(18,2);

    SET @vn_aporte_salud = dbo.fn_salud_empleado(@pn_salario);
    SET @vn_aporte_pension = dbo.fn_pension_empleado(@pn_salario);
    SET @vn_fondo_solidaridad = dbo.fn_fondo_solidaridad(@pn_salario);

    SET @vn_ingreso_neto = @pn_salario 
                         - @vn_aporte_salud 
                         - @vn_aporte_pension 
                         - @vn_fondo_solidaridad;

    SET @vn_renta_exenta = @vn_ingreso_neto * 0.25;
    IF @vn_renta_exenta > (@vn_uvt * 240)
        SET @vn_renta_exenta = @vn_uvt * 240;

    SET @vn_base_retencion = @vn_ingreso_neto - @vn_renta_exenta;
    SET @vn_base_uvt = @vn_base_retencion / @vn_uvt;

    IF @vn_base_uvt <= 95 RETURN 0;
    ELSE IF @vn_base_uvt <= 150 BEGIN
        SET @vn_tarifa = 0.19;
        SET @vn_limite_inf_uvt = 95;
        SET @vn_uvt_adicionales = 0;
    END
    ELSE IF @vn_base_uvt <= 360 BEGIN
        SET @vn_tarifa = 0.28;
        SET @vn_limite_inf_uvt = 150;
        SET @vn_uvt_adicionales = 10;
    END
    ELSE IF @vn_base_uvt <= 640 BEGIN
        SET @vn_tarifa = 0.33;
        SET @vn_limite_inf_uvt = 360;
        SET @vn_uvt_adicionales = 69;
    END
    ELSE IF @vn_base_uvt <= 945 BEGIN
        SET @vn_tarifa = 0.35;
        SET @vn_limite_inf_uvt = 640;
        SET @vn_uvt_adicionales = 162;
    END
    ELSE IF @vn_base_uvt <= 2300 BEGIN
        SET @vn_tarifa = 0.37;
        SET @vn_limite_inf_uvt = 945;
        SET @vn_uvt_adicionales = 268;
    END
    ELSE BEGIN
        SET @vn_tarifa = 0.39;
        SET @vn_limite_inf_uvt = 2300;
        SET @vn_uvt_adicionales = 770;
    END

    SET @vn_rete_pesos = ((@vn_base_uvt - @vn_limite_inf_uvt) * @vn_tarifa + @vn_uvt_adicionales) * @vn_uvt;

    IF @vn_rete_pesos < 0 SET @vn_rete_pesos = 0;

    RETURN ROUND(@vn_rete_pesos, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula las deducciones aplicables a un devengado específico.
             Incluye salud, pensión, fondo de solidaridad, retención en la fuente y descuentos por días no laborados (permisos no remunerados).
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_calcular_deducciones
    @pn_id_devengado INT
AS
BEGIN
    DECLARE 
        @vn_salario DECIMAL(18,2),
        @vn_salud DECIMAL(18,2),
        @vn_pension DECIMAL(18,2),
        @vn_fondo_solidaridad DECIMAL(18,2),
        @vn_descuento_dias DECIMAL(18,2),
        @vn_rete_fuente DECIMAL(18,2),
        @vn_total DECIMAL(18,2),
        @vd_inicio DATE,
        @vd_fin DATE;

    SELECT 
        @vn_salario = sueldo, 
        @vd_inicio = fecha_inicio,
        @vd_fin = fecha_fin
    FROM devengado
    WHERE id_devengado = @pn_id_devengado;

    SET @vn_salud = dbo.fn_salud_empleado(@vn_salario);
    SET @vn_pension = dbo.fn_pension_empleado(@vn_salario);
    SET @vn_fondo_solidaridad = dbo.fn_fondo_solidaridad(@vn_salario);

    SELECT @vn_descuento_dias = ISNULL(SUM(n.dias_afectados * 8 * (@vn_salario / 230.0)), 0)
    FROM novedad n
    WHERE n.id_empleado = (SELECT id_empleado FROM devengado WHERE id_devengado = @pn_id_devengado)
      AND n.id_tipo_novedad = 7
      AND n.fecha_inicio >= @vd_inicio AND n.fecha_fin <= @vd_fin;

    SET @vn_rete_fuente = dbo.fn_calcular_retefuente(@vn_salario);

    SET @vn_total = @vn_salud + @vn_pension + @vn_fondo_solidaridad + @vn_rete_fuente + ISNULL(@vn_descuento_dias, 0);

    INSERT INTO deducciones (
        id_devengado, salud, pension, fondo_solidaridad, rete_fuente, descuentos_dias,
        total_deducciones, fecha_inicio, fecha_fin
    )
    VALUES (
        @pn_id_devengado, @vn_salud, @vn_pension, @vn_fondo_solidaridad, @vn_rete_fuente, ISNULL(@vn_descuento_dias, 0),
        @vn_total, @vd_inicio, @vd_fin
    );
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera las deducciones para todos los empleados activos en un rango de fechas, evitando duplicados.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_deducciones_mensual
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE @vn_id_devengado INT;

    DECLARE cursor_devengados CURSOR FOR
        SELECT id_devengado
        FROM devengado d
        INNER JOIN empleado e ON d.id_empleado = e.id_empleado
        WHERE d.fecha_inicio = @pd_fecha_inicio AND d.fecha_fin = @pd_fecha_fin
          AND e.estado_id = 1
          AND NOT EXISTS (
              SELECT 1 FROM deducciones ded WHERE ded.id_devengado = d.id_devengado
          );

    OPEN cursor_devengados;
    FETCH NEXT FROM cursor_devengados INTO @vn_id_devengado;

    WHILE @@FETCH_STATUS = 0
    BEGIN
        EXEC sp_calcular_deducciones @pn_id_devengado = @vn_id_devengado;
        FETCH NEXT FROM cursor_devengados INTO @vn_id_devengado;
    END;

    CLOSE cursor_devengados;
    DEALLOCATE cursor_devengados;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Consulta las deducciones aplicadas a empleados filtrando por nombre y fechas.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_deducciones_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        d.id_deduccion,
        d.id_devengado,
        d.salud,
        d.pension,
        d.fondo_solidaridad,
        d.rete_fuente,
        d.descuentos_dias,
        d.total_deducciones,
        d.fecha_inicio,
        d.fecha_fin,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido
    FROM deducciones d
    INNER JOIN devengado dv ON d.id_devengado = dv.id_devengado
    INNER JOIN empleado e ON dv.id_empleado = e.id_empleado
    WHERE d.fecha_inicio >= @pd_fecha_inicio 
      AND d.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END;
GO
