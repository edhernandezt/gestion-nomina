/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte a caja de compensación familiar (4% del sub_total).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_aporte_caja_compensacion(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * 0.04, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte patronal al sistema de salud (8.5% del sub_total).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_aporte_salud_patronal(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * 0.085, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte patronal al sistema de pensión (12% del sub_total).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_aporte_pension_patronal(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * 0.12, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte patronal al SENA (2% del sub_total).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_aporte_sena(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * 0.02, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte patronal al ICBF (3% del sub_total).
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_aporte_icbf(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * 0.03, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el aporte por riesgo laboral con base en el porcentaje del factor de riesgo.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER FUNCTION fn_aporte_riesgo_laboral(
	@pn_sub_total DECIMAL(18,2), 
	@pn_porcentaje DECIMAL(5,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * (@pn_porcentaje / 100.0), 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula los aportes patronales por empleado, incluyendo caja, salud, pensión, SENA, ICBF y riesgo laboral.
             Consulta el sub_total del devengado y el porcentaje del factor de riesgo para calcular el total y registrar los datos.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_calcular_aporte_patronal
    @pn_id_empleado INT,
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE 
        @vn_sub_total DECIMAL(18,2),
        @vn_id_factor INT,
        @vn_porcentaje_riesgo DECIMAL(5,4),
        @vn_caja DECIMAL(18,2),
        @vn_salud DECIMAL(18,2),
        @vn_pension DECIMAL(18,2),
        @vn_sena DECIMAL(18,2),
        @vn_icbf DECIMAL(18,2),
        @vn_riesgo DECIMAL(18,2),
        @vn_total_aportes DECIMAL(18,2);

    -- Obtener subtotal y factor de riesgo
    SELECT 
        @vn_sub_total = d.sub_total,
        @vn_id_factor = e.riesgo_id
    FROM devengado d
    INNER JOIN empleado e ON d.id_empleado = e.id_empleado
    WHERE d.id_empleado = @pn_id_empleado
      AND d.fecha_inicio = @pd_fecha_inicio
      AND d.fecha_fin = @pd_fecha_fin;

    -- Porcentaje de riesgo
    SELECT @vn_porcentaje_riesgo = porcentaje
    FROM factor_riesgo
    WHERE id_factor = @vn_id_factor;

    -- Calcular aportes
    SET @vn_caja = dbo.fn_aporte_caja_compensacion(@vn_sub_total);
    SET @vn_salud = dbo.fn_aporte_salud_patronal(@vn_sub_total);
    SET @vn_pension = dbo.fn_aporte_pension_patronal(@vn_sub_total);
    SET @vn_sena = dbo.fn_aporte_sena(@vn_sub_total);
    SET @vn_icbf = dbo.fn_aporte_icbf(@vn_sub_total);
    SET @vn_riesgo = dbo.fn_aporte_riesgo_laboral(@vn_sub_total, @vn_porcentaje_riesgo);
    SET @vn_total_aportes =
        @vn_caja + @vn_salud + @vn_pension + @vn_sena + @vn_icbf + @vn_riesgo;

    -- Insertar en tabla
    INSERT INTO aportes_patronales (
        id_empleado, factor_riesgo_id,
        caja_compensacion, salud, pension, sena, icbf, riesgo_laboral, total_aportes,
        fecha_inicio, fecha_fin
    ) VALUES (
        @pn_id_empleado, @vn_id_factor,
        @vn_caja, @vn_salud, @vn_pension, @vn_sena, @vn_icbf, @vn_riesgo, @vn_total_aportes,
        @pd_fecha_inicio, @pd_fecha_fin
    );
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera los aportes patronales para todos los empleados activos en un periodo determinado.
             Recorre los devengados mensuales y aplica el cálculo de aportes uno a uno.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_aportes_patronales_mensual
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE @vn_id_empleado INT;

    DECLARE cur_empleados CURSOR FOR
        SELECT DISTINCT d.id_empleado
        FROM devengado d
        INNER JOIN empleado e ON d.id_empleado = e.id_empleado
        WHERE d.fecha_inicio = @pd_fecha_inicio
          AND d.fecha_fin = @pd_fecha_fin
          AND e.estado_id = 1;

    OPEN cur_empleados;

    FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;
    WHILE @@FETCH_STATUS = 0
    BEGIN
        EXEC sp_calcular_aporte_patronal @vn_id_empleado, @pd_fecha_inicio, @pd_fecha_fin;
        FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;
    END;

    CLOSE cur_empleados;
    DEALLOCATE cur_empleados;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Consulta los aportes patronales por empleado, filtrando por nombre y periodo.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_aportes_patronales_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        a.id_aporte,
        a.id_empleado,
        a.factor_riesgo_id, 
        a.caja_compensacion,
        a.salud,
        a.pension,
        a.sena,
        a.icbf,
        a.riesgo_laboral,
        a.total_aportes,
        a.fecha_inicio,
        a.fecha_fin,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido
    FROM aportes_patronales a
    INNER JOIN empleado e ON a.id_empleado = e.id_empleado
    WHERE a.fecha_inicio >= @pd_fecha_inicio 
      AND a.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END;
GO
