/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera la nómina mensual consolidada para todos los empleados activos en un periodo.
             Verifica si ya existe una nómina para el rango, calcula devengados, deducciones, prestaciones y aportes,
             y luego consolida toda la información en la tabla de nómina.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_nomina_mensual
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    -- Verificar si ya existe una nómina para ese rango de fechas
    IF EXISTS (
        SELECT 1 FROM nomina
        WHERE fecha_inicio = @pd_fecha_inicio AND fecha_fin = @pd_fecha_fin
    )
    BEGIN
        THROW 50001, 'Ya existe una nómina generada para ese rango de fechas.', 1;
    END;

    DECLARE 
        @vn_id_empleado INT,
        @vn_id_devengado INT,
        @vn_id_deduccion INT,
        @vn_id_prestacion INT,
        @vn_id_aporte INT,
        @vn_total_devengado DECIMAL(18,2),
        @vn_total_deducciones DECIMAL(18,2),
        @vn_total_prestaciones DECIMAL(18,2),
        @vn_total_aportes DECIMAL(18,2),
        @vn_total_a_pagar_empleado DECIMAL(18,2),
        @vn_total_nomina DECIMAL(18,2);

    -- Paso 1: Generar datos necesarios
    EXEC sp_generar_devengados_mensual @pd_fecha_inicio, @pd_fecha_fin;
    EXEC sp_generar_deducciones_mensual @pd_fecha_inicio, @pd_fecha_fin;
    EXEC sp_generar_prestaciones_sociales_mensual @pd_fecha_inicio, @pd_fecha_fin;
    EXEC sp_generar_aportes_patronales_mensual @pd_fecha_inicio, @pd_fecha_fin;

    -- Paso 2: Recorrer empleados activos y consolidar nómina
    DECLARE cur_empleados CURSOR FOR
        SELECT e.id_empleado
        FROM empleado e
        WHERE e.estado_id = 1;

    OPEN cur_empleados;
    FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;

    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Obtener devengado
        SELECT 
            @vn_id_devengado = d.id_devengado, 
            @vn_total_devengado = d.total_devengado
        FROM devengado d
        WHERE d.id_empleado = @vn_id_empleado 
          AND d.fecha_inicio = @pd_fecha_inicio 
          AND d.fecha_fin = @pd_fecha_fin;

        -- Obtener deducción
        SELECT 
            @vn_id_deduccion = ded.id_deduccion, 
            @vn_total_deducciones = ded.total_deducciones
        FROM deducciones ded
        WHERE ded.id_devengado = @vn_id_devengado;

        -- Obtener prestación
        SELECT 
            @vn_id_prestacion = p.id_prestacion, 
            @vn_total_prestaciones = p.total_prestaciones
        FROM prestaciones_sociales p
        WHERE p.id_empleado = @vn_id_empleado 
          AND p.fecha_inicio = @pd_fecha_inicio 
          AND p.fecha_fin = @pd_fecha_fin;

        -- Obtener aporte
        SELECT 
            @vn_id_aporte = a.id_aporte, 
            @vn_total_aportes = a.total_aportes
        FROM aportes_patronales a
        WHERE a.id_empleado = @vn_id_empleado 
          AND a.fecha_inicio = @pd_fecha_inicio 
          AND a.fecha_fin = @pd_fecha_fin;

        -- Validar que existan todos los registros
        IF @vn_id_devengado IS NOT NULL 
           AND @vn_id_deduccion IS NOT NULL 
           AND @vn_id_prestacion IS NOT NULL 
           AND @vn_id_aporte IS NOT NULL
        BEGIN
            SET @vn_total_a_pagar_empleado = @vn_total_devengado - @vn_total_deducciones;
            SET @vn_total_nomina = @vn_total_devengado + @vn_total_prestaciones + @vn_total_aportes;

            -- Insertar en tabla nómina
            INSERT INTO nomina (
                id_empleado, id_devengado, id_deduccion, id_prestacion, id_aporte,
                fecha_inicio, fecha_fin,
                total_a_pagar_empleado, total_nomina
            ) VALUES (
                @vn_id_empleado, @vn_id_devengado, @vn_id_deduccion, @vn_id_prestacion, @vn_id_aporte,
                @pd_fecha_inicio, @pd_fecha_fin,
                @vn_total_a_pagar_empleado, @vn_total_nomina
            );
        END;

        FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;
    END;

    CLOSE cur_empleados;
    DEALLOCATE cur_empleados;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Consulta la nómina generada filtrando por nombre completo del empleado y rango de fechas.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_nominas_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        n.id_nomina, 
        n.id_empleado, 
        n.id_devengado, 
        n.id_deduccion,
        n.id_prestacion, 
        n.id_aporte,
        n.total_a_pagar_empleado,
        n.total_nomina,
        n.fecha_inicio, 
        n.fecha_fin,
        e.primer_nombre, 
        e.segundo_nombre, 
        e.primer_apellido, 
        e.segundo_apellido
    FROM nomina n
    INNER JOIN empleado e ON n.id_empleado = e.id_empleado
    WHERE n.fecha_inicio >= @pd_fecha_inicio 
      AND n.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END;
GO
