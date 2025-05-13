-- Elimina la base de datos 'gestion_nomina' si existe previamente.
DROP DATABASE gestion_nomina;

-- Crea la base de datos para el sistema de gestión de nómina.
CREATE DATABASE gestion_nomina;
GO

-- Establece el contexto de trabajo dentro de la base de datos recién creada.
USE gestion_nomina;
GO

/* 
  =====================================================
  Sección 1: Tablas Auxiliares
  Estas tablas funcionan como catálogos de referencia 
  que normalizan los valores utilizados en otras tablas 
  del sistema, principalmente en la tabla 'empleado' 
  y otras tablas relacionadas como 'horas_extras', 
  'novedad', y 'aportes_patronales'.
  =====================================================
*/

CREATE TABLE cargo (
    id_cargo INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE departamento (
    id_departamento INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE estado_civil (
    id_estado_civil INT PRIMARY KEY IDENTITY(1,1),
    estado VARCHAR(50) NOT NULL
);

CREATE TABLE arl (
    id_arl INT PRIMARY KEY IDENTITY(1,1),
    nombre_arl VARCHAR(100) NOT NULL
);

CREATE TABLE eps (
    id_eps INT PRIMARY KEY IDENTITY(1,1),
    nombre_eps VARCHAR(100) NOT NULL
);

CREATE TABLE fondo_pension (
    id_fondo_pension INT PRIMARY KEY IDENTITY(1,1),
    nombre_fondo VARCHAR(100) NOT NULL
);

CREATE TABLE tipo_contrato (
    id_tipo_contrato INT PRIMARY KEY IDENTITY(1,1),
    tipo_contrato VARCHAR(100) NOT NULL
);

CREATE TABLE factor_riesgo (
    id_factor INT PRIMARY KEY IDENTITY(1,1),
    nombre VARCHAR(50) NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL
);

CREATE TABLE entidad_bancaria (
    id_banco INT PRIMARY KEY IDENTITY(1,1),
    nombre_banco VARCHAR(100) NOT NULL
);

CREATE TABLE estado (
    id_estado INT PRIMARY KEY IDENTITY(1,1),
    nombre_estado VARCHAR(50) NOT NULL
);

CREATE TABLE tipo_hora_extra (
    id_tipo_hora_extra INT PRIMARY KEY IDENTITY(1,1),
    descripcion VARCHAR(100) NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL
);

CREATE TABLE tipo_novedad (
    id_tipo_novedad INT PRIMARY KEY IDENTITY(1,1),
    descripcion VARCHAR(100) NOT NULL
);

/* 
  =====================================================
  Sección 2: Tabla Principal - Empleado
  Contiene la información personal, laboral y contractual
  de cada empleado registrado en la empresa.
  =====================================================
*/

CREATE TABLE empleado (
    id_empleado INT PRIMARY KEY IDENTITY(1,1),

    tipo_documento VARCHAR(30) NOT NULL,
    numero_documento VARCHAR(20) NOT NULL UNIQUE,

    primer_nombre VARCHAR(50) NOT NULL,
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50) NOT NULL,
    segundo_apellido VARCHAR(50),

    cargo_id INT NOT NULL,
    departamento_id INT NOT NULL,

    fecha_ingreso DATE NOT NULL,
    salario_basico DECIMAL(18,2) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,

    estado_civil_id INT NOT NULL,
    arl_id INT NOT NULL,
    eps_id INT NOT NULL,
    fondo_pension_id INT NOT NULL,

    fecha_nacimiento DATE NOT NULL,
    direccion VARCHAR(200) NOT NULL,

    tipo_contrato_id INT NOT NULL,
    riesgo_id INT NOT NULL,

    cuenta_bancaria VARCHAR(30) NOT NULL,
    banco_id INT NOT NULL,
    estado_id INT NOT NULL,

    FOREIGN KEY (cargo_id) REFERENCES cargo(id_cargo),
    FOREIGN KEY (departamento_id) REFERENCES departamento(id_departamento),
    FOREIGN KEY (estado_civil_id) REFERENCES estado_civil(id_estado_civil),
    FOREIGN KEY (arl_id) REFERENCES arl(id_arl),
    FOREIGN KEY (eps_id) REFERENCES eps(id_eps),
    FOREIGN KEY (fondo_pension_id) REFERENCES fondo_pension(id_fondo_pension),
    FOREIGN KEY (tipo_contrato_id) REFERENCES tipo_contrato(id_tipo_contrato),
    FOREIGN KEY (riesgo_id) REFERENCES factor_riesgo(id_factor),
    FOREIGN KEY (banco_id) REFERENCES entidad_bancaria(id_banco),
    FOREIGN KEY (estado_id) REFERENCES estado(id_estado)
);

/* 
  =====================================================
  Sección 3: Tabla de Devengado
  Registra los ingresos obtenidos por cada empleado
  durante un período determinado.
  =====================================================
*/

CREATE TABLE devengado (
    id_devengado INT PRIMARY KEY IDENTITY(1,1),
    id_empleado INT NOT NULL,

    horas_trabajadas DECIMAL(10,2) NOT NULL,
    sueldo DECIMAL(18,2) NOT NULL,
    sub_total DECIMAL(18,2) NOT NULL,
    auxilio_transporte DECIMAL(18,2),
	total_horas_extras DECIMAL(18,2),
    total_devengado DECIMAL(18,2) NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
);

/* 
  =====================================================
  Sección 4: Tabla de Horas Extras
  Detalla las horas adicionales trabajadas por tipo,
  su respectiva remuneración y fechas asociadas.
  =====================================================
*/

CREATE TABLE horas_extras (
    id_hora_extra INT PRIMARY KEY IDENTITY(1,1),
	id_empleado INT NOT NULL,
    id_tipo_hora_extra INT NOT NULL,

    cantidad_horas DECIMAL(10,2) NOT NULL,
    valor_hora DECIMAL(18,2) NOT NULL,
    total_pagado DECIMAL(18,2) NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

	FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_tipo_hora_extra) REFERENCES tipo_hora_extra(id_tipo_hora_extra)
);

/* 
  =====================================================
  Sección 5: Tabla de Novedades
  Registra eventos laborales que afectan la jornada del 
  empleado, como incapacidades, licencias o ausencias.
  =====================================================
*/

CREATE TABLE novedad (
    id_novedad INT PRIMARY KEY IDENTITY(1,1),
    id_empleado INT NOT NULL,
    id_tipo_novedad INT NOT NULL,
    
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    observaciones TEXT,
    
    dias_afectados INT,
    
    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_tipo_novedad) REFERENCES tipo_novedad(id_tipo_novedad)
);

/* 
  =====================================================
  Sección 6: Tabla de Deducciones
  Almacena los descuentos aplicados al salario del 
  empleado, como salud, pensión, retenciones, etc.
  =====================================================
*/

CREATE TABLE deducciones (
    id_deduccion INT PRIMARY KEY IDENTITY(1,1),
    id_devengado INT NOT NULL UNIQUE,

    salud DECIMAL(18,2) NOT NULL, -- 4% del salario del empleado
    pension DECIMAL(18,2) NOT NULL, -- 4% del salario del empleado
    fondo_solidaridad DECIMAL(18,2), -- 1% si el salario > 4 SMLV
    rete_fuente DECIMAL(18,2), -- Basado en UVT
    descuentos_dias DECIMAL(18,2), -- Días no laborados
	total_deducciones DECIMAL(18,2) NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

    FOREIGN KEY (id_devengado) REFERENCES devengado(id_devengado)
);

/* 
  =====================================================
  Sección 7: Tabla de Prestaciones Sociales
  Representa las obligaciones legales del empleador
  como cesantías, intereses, primas y vacaciones.
  =====================================================
*/

CREATE TABLE prestaciones_sociales (
    id_prestacion INT PRIMARY KEY IDENTITY(1,1),
    id_empleado INT NOT NULL,

    cesantias DECIMAL(18,2) NOT NULL,
    intereses DECIMAL(18,2) NOT NULL,
    prima DECIMAL(18,2) NOT NULL,
    vacaciones DECIMAL(18,2) NOT NULL,
	total_prestaciones DECIMAL(18,2) NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
);

/* 
  =====================================================
  Sección 8: Tabla de Aportes Patronales
  Almacena los aportes que el empleador realiza a 
  entidades externas por concepto de seguridad social.
  =====================================================
*/

CREATE TABLE aportes_patronales (
    id_aporte INT PRIMARY KEY IDENTITY(1,1),
    id_empleado INT NOT NULL,
    factor_riesgo_id INT NOT NULL,

    caja_compensacion DECIMAL(18,2) NOT NULL, -- 4% del salario
    salud DECIMAL(18,2) NOT NULL, -- 8.5% del salario
    pension DECIMAL(18,2) NOT NULL, -- 12% del salario
	sena DECIMAL(18,2) NOT NULL, -- 2% del salario
	icbf DECIMAL(18,2) NOT NULL, -- 3% del salario
    riesgo_laboral DECIMAL(18,2) NOT NULL, -- salario * porcentaje de riesgo
	total_aportes DECIMAL(18,2) NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (factor_riesgo_id) REFERENCES factor_riesgo(id_factor)
);

/* 
  =====================================================
  Sección 9: Tabla de Nómina Consolidada
  Integra todos los componentes que afectan la nómina del 
  empleado, incluyendo ingresos, deducciones, aportes y 
  prestaciones, en un único registro.
  =====================================================
*/

CREATE TABLE nomina (
    id_nomina INT PRIMARY KEY IDENTITY(1,1),
    id_empleado INT NOT NULL,
    id_devengado INT NOT NULL,
    id_deduccion INT NOT NULL,
    id_prestacion INT NOT NULL,
    id_aporte INT NOT NULL,

    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,

    total_a_pagar_empleado DECIMAL(18,2) NOT NULL, -- total_devengado - total_deducciones
	total_nomina DECIMAL(18,2) NOT NULL, -- total_devengado + prestaciones + aportes

    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado),
    FOREIGN KEY (id_devengado) REFERENCES devengado(id_devengado),
    FOREIGN KEY (id_deduccion) REFERENCES deducciones(id_deduccion),
    FOREIGN KEY (id_prestacion) REFERENCES prestaciones_sociales(id_prestacion),
    FOREIGN KEY (id_aporte) REFERENCES aportes_patronales(id_aporte)
);

/* 
  =====================================================
  Sección 10: Tabla de Liquidación de Prestaciones Sociales
  Registra los valores consolidados de prestaciones sociales
  por semestre y año para cada empleado. Incluye cesantías,
  intereses, prima, vacaciones y el total liquidado, así como 
  la fecha de generación para trazabilidad histórica.
  =====================================================
*/

CREATE TABLE liquidacion_prestacion (
    id_liquidacion INT IDENTITY(1,1) PRIMARY KEY,
    id_empleado INT NOT NULL,
    anio INT NOT NULL,
    semestre INT NOT NULL CHECK (semestre IN (1, 2)), -- nuevo campo

    cesantias DECIMAL(18,2),
    intereses DECIMAL(18,2),
    prima DECIMAL(18,2),
    vacaciones DECIMAL(18,2),
    total_liquidacion DECIMAL(18,2),

    fecha_generacion DATETIME DEFAULT GETDATE(),

    FOREIGN KEY (id_empleado) REFERENCES empleado(id_empleado)
);

/* 
  =====================================================
  Sección 11: Tabla de Auditoría de Nómina
  Almacena registros históricos consolidados por empleado 
  para cada periodo de nómina procesado. Incluye montos 
  totales pagados, valores globales de la nómina y 
  metadatos relevantes para trazabilidad y control.
  =====================================================
*/

CREATE TABLE auditoria_nomina (
    id_auditoria INT IDENTITY(1,1) PRIMARY KEY,
    id_empleado INT NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    total_pagado_empleado DECIMAL(18,2) NOT NULL,
    total_nomina DECIMAL(18,2) NOT NULL,
    fecha_operacion DATETIME NOT NULL DEFAULT GETDATE(),
    usuario NVARCHAR(100) NOT NULL
);