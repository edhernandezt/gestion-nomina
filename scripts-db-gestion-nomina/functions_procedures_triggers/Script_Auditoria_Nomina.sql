/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Trigger que registra automáticamente una auditoría al insertarse 
             un nuevo registro en la tabla de nómina. Captura los datos clave 
             del periodo, montos y el usuario que ejecutó la operación.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER TRIGGER trg_auditar_nomina_insercion
ON nomina
AFTER INSERT
AS
BEGIN
    INSERT INTO auditoria_nomina (
        id_empleado, fecha_inicio, fecha_fin, total_pagado_empleado, total_nomina, usuario
    )
    SELECT 
        id_empleado, fecha_inicio, fecha_fin, total_a_pagar_empleado, total_nomina, SYSTEM_USER
    FROM inserted;
END;
GO

/*
Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera
Descripción: Procedimiento para buscar auditorías de nómina por nombre de usuario y fechas.
Fecha de creación: 25/04/2025
*/
CREATE OR ALTER PROCEDURE sp_buscar_auditoria_nomina_por_usuario
    @pd_fecha_inicio DATE,
    @pd_fecha_fin DATE,
    @pv_usuario NVARCHAR(100)
AS
BEGIN
    SELECT 
        a.id_auditoria,
        a.id_empleado,
        e.primer_nombre,
        e.segundo_nombre,
        e.primer_apellido,
        e.segundo_apellido,
        a.fecha_inicio,
        a.fecha_fin,
        a.total_pagado_empleado,
        a.total_nomina,
        a.fecha_operacion,
        a.usuario
    FROM auditoria_nomina a
    INNER JOIN empleado e ON a.id_empleado = e.id_empleado
    WHERE a.fecha_operacion BETWEEN @pd_fecha_inicio AND @pd_fecha_fin
      AND LOWER(a.usuario) LIKE '%' + LOWER(@pv_usuario) + '%';
END;
GO

