README - Scripts del Sistema de Gestión de Nómina
=================================================

Autores: Eliecer Hernández, Viviana Hincapié, Juan Rivera  
Fecha de elaboración: abril de 2025

Este proyecto implementa un sistema completo de gestión de nómina para una organización, cumpliendo con las normativas colombianas en materia de seguridad social, retención, aportes y prestaciones sociales. El conjunto de scripts SQL está dividido en componentes modulares que permiten la creación, inserción y procesamiento automático de datos, incluyendo lógica de negocio y auditoría.

--------------------------------------------------
ORDEN DE EJECUCIÓN RECOMENDADO
--------------------------------------------------

1. DB_Gestion_Nomina.sql (Creación de tablas y relaciones)
2. Insert_Tablas.sql (Carga de datos auxiliares y empleados)
3. Script_Horas_Extras.sql
4. Script_Novedades.sql
5. Script_Devengado.sql
6. Script_Deducciones.sql
7. Script_Prestaciones_Sociales.sql
8. Script_Aportes_Patronales.sql
9. Script_Liquidacion_Prestaciones.sql
10. Script_Nomina.sql
11. Script_Auditoria_Nomina.sql

--------------------------------------------------
1. Script: DB_Gestion_Nomina.sql
--------------------------------------------------
Este script crea toda la estructura base del sistema de nómina, incluyendo:

- Tablas Auxiliares: cargo, departamento, estado_civil, arl, eps, fondo_pension, tipo_contrato, factor_riesgo, entidad_bancaria, estado, tipo_hora_extra, tipo_novedad.
- Tabla principal: empleado con claves foráneas a las tablas auxiliares.
- Tablas funcionales:
  - devengado: ingresos mensuales por empleado.
  - horas_extras: horas adicionales por tipo.
  - novedad: incapacidades, licencias, permisos.
  - deducciones: descuentos legales y personalizados.
  - prestaciones_sociales: cesantías, intereses, prima, vacaciones.
  - aportes_patronales: salud, pensión, riesgos, parafiscales.
  - nomina: consolidado mensual por empleado.
  - liquidacion_prestacion: liquidación semestral por empleado.
  - auditoria_nomina: historial con trazabilidad.

--------------------------------------------------
2. Script: Insert_Tablas.sql
--------------------------------------------------
Contiene datos precargados esenciales para pruebas y despliegue inicial. Incluye:

- Cargos, departamentos, estados civiles, EPS, ARL, fondos de pensión, contratos, entidades bancarias, estados.
- Tipos de horas extra y novedades.
- Más de 60 empleados con datos completos (nombre, salario, área, riesgos, entidad bancaria, etc.).

--------------------------------------------------
3. Script: Script_Horas_Extras.sql
--------------------------------------------------
- Funciones:
  - `fn_obtener_porcentaje_hora_extra`
  - `fn_calcular_valor_hora_base`
- Procedimientos:
  - `sp_registrar_horas_extras_empleado`
  - `sp_buscar_horas_extras_por_nombre`

--------------------------------------------------
4. Script: Script_Novedades.sql
--------------------------------------------------
- Función:
  - `fn_calcular_dias_afectados`
- Procedimientos:
  - `sp_registrar_novedad`
  - `sp_buscar_novedades_por_nombre`

--------------------------------------------------
5. Script: Script_Devengado.sql
--------------------------------------------------
- Funciones:
  - `fn_calcular_sueldo_proporcional`
  - `fn_calcular_auxilio_proporcional`
  - `fn_total_horas_extras_pagadas`
- Procedimientos:
  - `sp_generar_devengados_mensual`
  - `sp_buscar_devengados_por_nombre`

--------------------------------------------------
6. Script: Script_Deducciones.sql
--------------------------------------------------
- Funciones:
  - `fn_salud_empleado`, `fn_pension_empleado`, `fn_fondo_solidaridad`, `fn_calcular_retefuente`
- Procedimientos:
  - `sp_calcular_deducciones`
  - `sp_generar_deducciones_mensual`
  - `sp_buscar_deducciones_por_nombre`

--------------------------------------------------
7. Script: Script_Prestaciones_Sociales.sql
--------------------------------------------------
- Funciones:
  - `fn_calcular_cesantias`, `fn_calcular_intereses_cesantias`, `fn_calcular_prima`, `fn_calcular_vacaciones`
- Procedimientos:
  - `sp_calcular_prestaciones_sociales`
  - `sp_generar_prestaciones_sociales_mensual`
  - `sp_buscar_prestaciones_por_nombre`

--------------------------------------------------
8. Script: Script_Aportes_Patronales.sql
--------------------------------------------------
- Funciones:
  - `fn_aporte_caja_compensacion`, `fn_aporte_salud_patronal`, `fn_aporte_pension_patronal`, `fn_aporte_sena`, `fn_aporte_icbf`, `fn_aporte_riesgo_laboral`
- Procedimientos:
  - `sp_calcular_aporte_patronal`
  - `sp_generar_aportes_patronales_mensual`
  - `sp_buscar_aportes_patronales_por_nombre`

--------------------------------------------------
9. Script: Script_Liquidacion_Prestaciones.sql
--------------------------------------------------
- Procedimientos:
  - `sp_generar_liquidacion_prestaciones_semestre`
  - `sp_buscar_liquidaciones_prestaciones`

--------------------------------------------------
10. Script: Script_Nomina.sql
--------------------------------------------------
- Procedimientos:
  - `sp_generar_nomina_mensual`: ejecuta los módulos de devengados, deducciones, prestaciones y aportes en orden.
  - `sp_buscar_nominas_por_nombre`: consulta por empleado.

--------------------------------------------------
11. Script: Script_Auditoria_Nomina.sql
--------------------------------------------------
- Trigger:
  - `trg_auditar_nomina_insercion`: se activa automáticamente al insertar una nueva nómina y guarda un registro en `auditoria_nomina` incluyendo el usuario y los montos.
- Procedimiento:
  - `sp_buscar_auditoria_nomina_por_usuario`: permite consultar trazabilidad por usuario y rango de fechas.

--------------------------------------------------
Consideraciones Finales
--------------------------------------------------
- El sistema permite trazabilidad completa de cada componente de nómina.
- Las funciones encapsulan lógica aritmética y legal para facilitar mantenimiento.
- Los procedimientos están diseñados para ejecuciones mensuales o semestrales.
- Cumple con normativa laboral colombiana respecto a seguridad social y prestaciones.