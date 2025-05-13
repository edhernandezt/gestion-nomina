/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula la cantidad de días afectados entre dos fechas, incluyendo ambas.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_dias_afectados (
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
)
RETURNS INT
AS
BEGIN
    DECLARE @vn_dias INT;

    IF @pd_fecha_inicio IS NULL OR @pd_fecha_fin IS NULL
        RETURN 0;

    SET @vn_dias = DATEDIFF(DAY, @pd_fecha_inicio, @pd_fecha_fin) + 1;
    RETURN @vn_dias;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Registra una novedad para un empleado, validando fechas y calculando días afectados.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_registrar_novedad
    @pn_id_empleado INT,
    @pn_id_tipo_novedad INT,
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_observaciones TEXT = NULL
AS
BEGIN
    DECLARE @vn_dias_afectados INT;

    -- Validaciones básicas
    IF @pd_fecha_fin < @pd_fecha_inicio
    BEGIN
        RAISERROR('La fecha de fin no puede ser anterior a la fecha de inicio.', 16, 1);
        RETURN;
    END

    -- Calcular los días afectados usando la función
    SET @vn_dias_afectados = dbo.fn_calcular_dias_afectados(@pd_fecha_inicio, @pd_fecha_fin);

    -- Insertar la novedad
    INSERT INTO novedad (
        id_empleado,
        id_tipo_novedad,
        fecha_inicio,
        fecha_fin,
        observaciones,
        dias_afectados
    )
    VALUES (
        @pn_id_empleado,
        @pn_id_tipo_novedad,
        @pd_fecha_inicio,
        @pd_fecha_fin,
        @pv_observaciones,
        @vn_dias_afectados
    );
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Busca las novedades registradas para empleados filtrando por nombre y rango de fechas.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_novedades_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT n.*
    FROM novedad n
    INNER JOIN empleado e ON n.id_empleado = e.id_empleado
    INNER JOIN tipo_novedad t ON n.id_tipo_novedad = t.id_tipo_novedad
    WHERE n.fecha_inicio >= @pd_fecha_inicio
      AND n.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%';
END;
GO
