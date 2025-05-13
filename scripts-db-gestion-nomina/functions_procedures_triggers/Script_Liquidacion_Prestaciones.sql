/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Genera la liquidación semestral de prestaciones sociales (cesantías, intereses, prima y vacaciones) 
             para todos los empleados con registros en el semestre indicado. Calcula el total y lo inserta 
             en la tabla `liquidacion_prestacion`.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_generar_liquidacion_prestaciones_semestre
    @pn_anio INT,
    @pn_semestre INT  -- 1 para enero-junio, 2 para julio-diciembre
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE 
        @vn_id_empleado INT,
        @vn_cesantias DECIMAL(18,2),
        @vn_intereses DECIMAL(18,2),
        @vn_prima DECIMAL(18,2),
        @vn_vacaciones DECIMAL(18,2),
        @vn_total DECIMAL(18,2),
        @fecha_inicio DATE,
        @fecha_fin DATE;

    -- Definir rango de fechas según semestre
    IF @pn_semestre = 1
    BEGIN
        SET @fecha_inicio = DATEFROMPARTS(@pn_anio, 1, 1);
        SET @fecha_fin = DATEFROMPARTS(@pn_anio, 6, 30);
    END
    ELSE IF @pn_semestre = 2
    BEGIN
        SET @fecha_inicio = DATEFROMPARTS(@pn_anio, 7, 1);
        SET @fecha_fin = DATEFROMPARTS(@pn_anio, 12, 31);
    END
    ELSE
    BEGIN
        RAISERROR('El semestre debe ser 1 o 2.', 16, 1);
        RETURN;
    END
	-- Cursor para recorrer empleados con prestaciones en el rango de fechas
    DECLARE cur_empleados CURSOR FOR
        SELECT DISTINCT id_empleado
        FROM prestaciones_sociales
        WHERE fecha_inicio BETWEEN @fecha_inicio AND @fecha_fin;

    OPEN cur_empleados;
    FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;

    WHILE @@FETCH_STATUS = 0
    BEGIN
		-- Sumar valores por empleado
        SELECT
            @vn_cesantias = SUM(cesantias),
            @vn_intereses = SUM(intereses),
            @vn_prima = SUM(prima),
            @vn_vacaciones = SUM(vacaciones)
        FROM prestaciones_sociales
        WHERE id_empleado = @vn_id_empleado
          AND fecha_inicio BETWEEN @fecha_inicio AND @fecha_fin;

        SET @vn_total = ISNULL(@vn_cesantias, 0) + ISNULL(@vn_intereses, 0) + ISNULL(@vn_prima, 0) + ISNULL(@vn_vacaciones, 0);

        -- Insertar en tabla liquidación
        INSERT INTO liquidacion_prestacion (
            id_empleado, anio, semestre, cesantias, intereses, prima, vacaciones, total_liquidacion, fecha_generacion
        )
        VALUES (
            @vn_id_empleado, @pn_anio, @pn_semestre, 
            @vn_cesantias, @vn_intereses, @vn_prima, @vn_vacaciones, 
            @vn_total, GETDATE()
        );

        FETCH NEXT FROM cur_empleados INTO @vn_id_empleado;
    END;

    CLOSE cur_empleados;
    DEALLOCATE cur_empleados;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Permite buscar las liquidaciones de prestaciones sociales generadas en un semestre específico 
             filtrando por nombre del empleado. Devuelve detalles completos de cada liquidación encontrada.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_liquidaciones_prestaciones
    @pn_anio INT,
    @pn_semestre INT,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SET NOCOUNT ON;

    DECLARE @fecha_inicio DATE, @fecha_fin DATE;

    -- Rango de fechas según semestre
    IF @pn_semestre = 1
    BEGIN
        SET @fecha_inicio = DATEFROMPARTS(@pn_anio, 1, 1);
        SET @fecha_fin = DATEFROMPARTS(@pn_anio, 6, 30);
    END
    ELSE IF @pn_semestre = 2
    BEGIN
        SET @fecha_inicio = DATEFROMPARTS(@pn_anio, 7, 1);
        SET @fecha_fin = DATEFROMPARTS(@pn_anio, 12, 31);
    END
    ELSE
    BEGIN
        RAISERROR('El semestre debe ser 1 o 2.', 16, 1);
        RETURN;
    END

    SELECT 
        lp.id_liquidacion,
        lp.id_empleado,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido,
        lp.anio,
		lp.semestre,
        lp.cesantias,
        lp.intereses,
        lp.prima,
        lp.vacaciones,
        lp.total_liquidacion,
        lp.fecha_generacion
    FROM liquidacion_prestacion lp
    INNER JOIN empleado e ON lp.id_empleado = e.id_empleado
    WHERE lp.anio = @pn_anio
      AND lp.fecha_generacion BETWEEN @fecha_inicio AND @fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%';
END;
GO
