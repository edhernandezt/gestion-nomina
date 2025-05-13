/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Retorna el porcentaje asociado a un tipo de hora extra según su ID.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_obtener_porcentaje_hora_extra (
    @pn_id_tipo_hora_extra INT
)
RETURNS DECIMAL(5,2)
AS
BEGIN
    DECLARE @vn_porcentaje DECIMAL(5,2);
    
    SELECT @vn_porcentaje = porcentaje
    FROM tipo_hora_extra
    WHERE id_tipo_hora_extra = @pn_id_tipo_hora_extra;

    RETURN @vn_porcentaje;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Calcula el valor base de una hora de trabajo a partir del sueldo mensual.
Fecha de creación: 25/04/2025
*/
CREATE FUNCTION fn_calcular_valor_hora_base (
    @pn_sueldo DECIMAL(18,2)
)
RETURNS DECIMAL(18,2)
AS
BEGIN
    RETURN @pn_sueldo / 230.0;
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Registra horas extras trabajadas por un empleado, calculando el valor total pagado.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_registrar_horas_extras_empleado
    @pn_id_empleado INT,
    @pn_id_tipo_hora_extra INT,
    @pn_cantidad_horas DECIMAL(10,2),
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE
AS
BEGIN
    DECLARE @vn_sueldo_base DECIMAL(18,2),
            @vn_valor_hora_base DECIMAL(18,2),
            @vn_porcentaje DECIMAL(5,2),
            @vn_valor_hora DECIMAL(18,2),
            @vn_total_pagado DECIMAL(18,2);

    -- Obtener sueldo base del empleado
    SELECT @vn_sueldo_base = salario_basico
    FROM empleado
    WHERE id_empleado = @pn_id_empleado;

    -- Validación de existencia
    IF @vn_sueldo_base IS NULL
    BEGIN
        RAISERROR('Empleado no encontrado.', 16, 1);
        RETURN;
    END;

    -- Obtener porcentaje del tipo de hora extra usando función
    SET @vn_porcentaje = dbo.fn_obtener_porcentaje_hora_extra(@pn_id_tipo_hora_extra);

    -- Calcular valor base de la hora usando función
    SET @vn_valor_hora_base = dbo.fn_calcular_valor_hora_base(@vn_sueldo_base);

    -- Calcular valor hora extra y total a pagar
    SET @vn_valor_hora = @vn_valor_hora_base * @vn_porcentaje;
    SET @vn_total_pagado = @vn_valor_hora * @pn_cantidad_horas;

    -- Insertar en horas_extras
    INSERT INTO horas_extras (
        id_empleado, id_tipo_hora_extra, cantidad_horas,
        valor_hora, total_pagado, fecha_inicio, fecha_fin
    )
    VALUES (
        @pn_id_empleado, @pn_id_tipo_hora_extra, @pn_cantidad_horas,
        @vn_valor_hora, @vn_total_pagado, @pd_fecha_inicio, @pd_fecha_fin
    );
END
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Busca las horas extras registradas para empleados, filtrando por nombre y periodo.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_horas_extras_por_nombre
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_nombre NVARCHAR(100)
AS
BEGIN
    SELECT 
        h.id_hora_extra,
        h.id_empleado,
        h.id_tipo_hora_extra,
        h.cantidad_horas,
        h.valor_hora,
        h.total_pagado,
        h.fecha_inicio,
        h.fecha_fin,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido,
        t.descripcion AS descripcion_tipo
    FROM horas_extras h
    INNER JOIN empleado e ON h.id_empleado = e.id_empleado
    INNER JOIN tipo_hora_extra t ON h.id_tipo_hora_extra = t.id_tipo_hora_extra
    WHERE h.fecha_inicio >= @pd_fecha_inicio 
      AND h.fecha_fin <= @pd_fecha_fin
      AND LOWER(CONCAT(e.primer_nombre, ' ', e.segundo_nombre, ' ', e.primer_apellido, ' ', e.segundo_apellido))
          LIKE '%' + LOWER(@pv_nombre) + '%'
END;
GO
