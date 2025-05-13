/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el valor de cesantías como el 8.33% del total devengado.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_cesantias(
	@pn_total_devengado DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_total_devengado * 0.0833, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula los intereses sobre cesantías como el 12% del valor de las cesantías.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_intereses_cesantias(
	@pn_cesantias DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_cesantias * 0.12, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula la prima de servicios como el 8.33% del total devengado.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_prima(
	@pn_total_devengado DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_total_devengado * 0.0833, 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el valor de las vacaciones como 15 días sobre 360 del sub_total devengado.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_vacaciones(
	@pn_sub_total DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN ROUND(@pn_sub_total * (15.0 / 360.0), 2);
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula las prestaciones sociales de un empleado en un periodo determinado. 
             Incluye cesantías, intereses, prima y vacaciones.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_calcular_prestaciones_sociales
    @pn_id_empleado INT,
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE 
        @vn_total_devengado DECIMAL(18,2),
        @vn_sub_total DECIMAL(18,2),
        @vn_cesantias DECIMAL(18,2),
        @vn_intereses DECIMAL(18,2),
        @vn_prima DECIMAL(18,2),
        @vn_vacaciones DECIMAL(18,2),
        @vn_total_prestaciones DECIMAL(18,2);

    -- Obtener el total devengado y sub_total en el período
    SELECT 
        @vn_total_devengado = ISNULL(SUM(total_devengado), 0),
        @vn_sub_total = ISNULL(SUM(sub_total), 0)
    FROM devengado
    WHERE id_empleado = @pn_id_empleado
      AND fecha_inicio >= @pd_fecha_inicio
      AND fecha_fin <= @pd_fecha_fin;

    -- Calcular prestaciones
    SET @vn_cesantias = dbo.fn_calcular_cesantias(@vn_total_devengado);
    SET @vn_intereses = dbo.fn_calcular_intereses_cesantias(@vn_cesantias);
    SET @vn_prima = dbo.fn_calcular_prima(@vn_total_devengado);
    SET @vn_vacaciones = dbo.fn_calcular_vacaciones(@vn_sub_total);
    SET @vn_total_prestaciones = 
        @vn_cesantias + @vn_intereses + @vn_prima + @vn_vacaciones;

    -- Insertar en tabla
    INSERT INTO prestaciones_sociales (
        id_empleado, cesantias, intereses, prima, vacaciones, total_prestaciones,
        fecha_inicio, fecha_fin
    )
    VALUES (
        @pn_id_empleado, @vn_cesantias, @vn_intereses, @vn_prima, @vn_vacaciones, @vn_total_prestaciones,
        @pd_fecha_inicio, @pd_fecha_fin
    );
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera las prestaciones sociales para todos los empleados activos en un período.
             Ejecuta el cálculo individual por empleado usando sp_calcular_prestaciones_sociales.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_prestaciones_sociales_mensual
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
        EXEC sp_calcular_prestaciones_sociales @vn_id_empleado, @pd_fecha_inicio, @pd_fecha_fin;
        FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;
    END;

    CLOSE cur_empleados;
    DEALLOCATE cur_empleados;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Busca las prestaciones sociales registradas para empleados, filtrando por nombre y fechas.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_prestaciones_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        p.id_prestacion,
        p.id_empleado,
        p.cesantias,
        p.intereses,
        p.prima,
        p.vacaciones, 
        p.total_prestaciones,
        p.fecha_inicio,
        p.fecha_fin,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido
    FROM prestaciones_sociales p
    INNER JOIN empleado e ON p.id_empleado = e.id_empleado
    WHERE p.fecha_inicio >= @pd_fecha_inicio 
      AND p.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END;
GO
