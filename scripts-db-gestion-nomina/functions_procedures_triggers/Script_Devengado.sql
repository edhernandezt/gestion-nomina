/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el sueldo proporcional de un empleado con base en su salario.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_sueldo_proporcional (
    @pn_salario_base DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @vn_sub_total DECIMAL(18,2);
    SET @vn_sub_total = (@pn_salario_base / 230.0) * 230;
    RETURN @vn_sub_total;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el auxilio de transporte proporcional, si el salario base está dentro del límite legal.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_auxilio_proporcional (
    @pn_salario_base DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @vn_auxilio DECIMAL(18,2);
    IF (@pn_salario_base <= 2847000)
        SET @vn_auxilio = (200000.0 / 230.0) * 230;
    ELSE
        SET @vn_auxilio = 0;
    RETURN @vn_auxilio;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el total pagado por horas extras a un empleado dentro de un periodo específico.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_total_horas_extras_pagadas (
    @pn_id_empleado INT,
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    DECLARE @vn_total DECIMAL(18,2);

    SELECT @vn_total = ISNULL(SUM(total_pagado), 0)
    FROM horas_extras
    WHERE id_empleado = @pn_id_empleado
      AND fecha_inicio >= @pd_fecha_inicio
      AND fecha_fin <= @pd_fecha_fin;

    RETURN @vn_total;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera los devengados mensuales de todos los empleados activos, incluyendo sueldo, auxilio y horas extras.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_devengados_mensual
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE @vn_id_empleado INT;
    DECLARE @vn_salario_base DECIMAL(18,2);
    DECLARE @vn_sub_total DECIMAL(18,2);
    DECLARE @vn_auxilio DECIMAL(18,2);
    DECLARE @vn_total DECIMAL(18,2);
    DECLARE @vn_horas_extras DECIMAL(18,2);

    DECLARE cur_empleados CURSOR FOR
        SELECT id_empleado, salario_basico
        FROM empleado
        WHERE estado_id = 1;

    OPEN cur_empleados;

    FETCH NEXT FROM cur_empleados INTO @vn_id_empleado, @vn_salario_base;

    WHILE @@FETCH_STATUS = 0
    BEGIN
        SET @vn_sub_total = dbo.fn_calcular_sueldo_proporcional(@vn_salario_base);
        SET @vn_auxilio = dbo.fn_calcular_auxilio_proporcional(@vn_salario_base);
        SET @vn_horas_extras = dbo.fn_total_horas_extras_pagadas(@vn_id_empleado, @pd_fecha_inicio, @pd_fecha_fin);

        SET @vn_total = @vn_sub_total + @vn_auxilio + @vn_horas_extras;

        INSERT INTO devengado (
            id_empleado, horas_trabajadas, sueldo, sub_total,
            auxilio_transporte, total_horas_extras, total_devengado,
            fecha_inicio, fecha_fin
        )
        VALUES (
            @vn_id_empleado, 230, @vn_salario_base, @vn_sub_total,
            @vn_auxilio, @vn_horas_extras, @vn_total,
            @pd_fecha_inicio, @pd_fecha_fin
        );

        FETCH NEXT FROM cur_empleados INTO @vn_id_empleado, @vn_salario_base;
    END

    CLOSE cur_empleados;
    DEALLOCATE cur_empleados;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Busca los devengados de empleados filtrando por nombre y periodo.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_devengados_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        d.id_devengado,
        d.id_empleado,
        d.horas_trabajadas,
        d.sueldo,
        d.sub_total,
        d.auxilio_transporte,
        d.total_horas_extras,
        d.total_devengado,
        d.fecha_inicio,
        d.fecha_fin,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido
    FROM devengado d
    INNER JOIN empleado e ON d.id_empleado = e.id_empleado
    WHERE d.fecha_inicio >= @pd_fecha_inicio 
      AND d.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END
GO
