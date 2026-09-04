# Prompt para Mejorar el Codigo Base

Copia y pega el siguiente contenido completo en un asistente de IA (Claude, ChatGPT, etc.)
para obtener un ZIP con el proyecto arrancable. Si el adjunto es una carcasa (docs/placeholders),
el asistente debe materializar la estructura del stack del briefing, sin resolver las fases del reto.

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Contexto técnico original
Testing complete status lifecycle through pipeline

### Reto
- Tema: Status Progression Test
- Seniority: junior-l2
- Tipo: practical
- Título: Implementación del Ciclo de Vida del Estado en el Pipeline
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Definición de Estados y Transiciones — objetivo: Establecer los estados válidos y las transiciones permitidas entre ellos. — entregable (NO resolver): Documento que describe los estados y transiciones válidos.
- Fase 2: Implementación de la Lógica de Transición — objetivo: Implementar la lógica para manejar las transiciones de estado. — entregable (NO resolver): Implementación de la lógica de transición de estados.
- Fase 3: Integración y Pruebas — objetivo: Integrar la lógica de transición con el pipeline y realizar pruebas exhaustivas. — entregable (NO resolver): Pipeline integrado con la lógica de transición y reporte de pruebas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:
// === ARCHIVO: src/main/java/com/pragma/statuspipeline/StatusPipelineApplication.java ===
package com.pragma.statuspipeline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatusPipelineApplication {
    public static void main(String[] args) {
        SpringApplication.run(StatusPipelineApplication.class, args);
    }
}

// === ARCHIVO: src/main/java/com/pragma/statuspipeline/domain/model/LoanRequest.java ===
package com.pragma.statuspipeline.domain.model;

import com.pragma.statuspipeline.domain.model.LoanRequestStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoanRequest {
    @Id
    private String id;
    private String clientId;
    private LoanRequestStatus status;
    // Getters and setters
}

// === ARCHIVO: src/main/java/com/pragma/statuspipeline/domain/model/LoanRequestStatus.java ===
package com.pragma.statuspipeline.domain.model;

public enum LoanRequestStatus {
    RECEIVED,
    UNDER_REVIEW,
    APPROVED,
    REJECTED
}

// === ARCHIVO: src/main/java/com/pragma/statuspipeline/domain/service/LoanRequestService.java ===
package com.pragma.statuspipeline.domain.service;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import com.pragma.statuspipeline.domain.model.LoanRequestStatus;

public interface LoanRequestService {
    LoanRequest transitionToNextStatus(LoanRequest loanRequest);
}

// === ARCHIVO: src/main/java/com/pragma/statuspipeline/infrastructure/adapter/LoanRequestRepository.java ===
package com.pragma.statuspipeline.infrastructure.adapter;

import com.pragma.statuspipeline.domain.model.LoanRequest;

public interface LoanRequestRepository {
    LoanRequest findById(String id);
    LoanRequest save(LoanRequest loanRequest);
}

// === ARCHIVO: src/main/java/com/pragma/statuspipeline/infrastructure/adapter/LoanRequestRepositoryImpl.java ===
package com.pragma.statuspipeline.infrastructure.adapter;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public class LoanRequestRepositoryImpl implements LoanRequestRepository {
    private final JpaRepository<LoanRequest, String> loanRequestRepository;

    public LoanRequestRepositoryImpl(JpaRepository<LoanRequest, String> loanRequestRepository) {
        this.loanRequestRepository = loanRequestRepository;
    }

    @Override
    public LoanRequest findById(String id) {
        return loanRequestRepository.findById(id).orElse(null);
    }

    @Override
    public LoanRequest save(LoanRequest loanRequest) {
        return loanRequestRepository.save(loanRequest);
    }
}

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driverClassName: org.h2.Driver
    username: sa
    password:
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    show-sql: true
    hibernate:
      ddl-auto: create-drop

// === ARCHIVO: src/test/java/com/pragma/statuspipeline/domain/service/LoanRequestServiceTest.java ===
package com.pragma.statuspipeline.domain.service;

import com.pragma.statuspipeline.domain.model.LoanRequest;
import com.pragma.statuspipeline.domain.model.LoanRequestStatus;
import com.pragma.statuspipeline.infrastructure.adapter.LoanRequestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LoanRequestServiceTest {

    @Test
    public void testTransitionToNextStatus() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.RECEIVED);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.UNDER_REVIEW, updatedRequest.getStatus());
    }

    @Test
    public void testTransitionToApproved() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.UNDER_REVIEW);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.APPROVED, updatedRequest.getStatus());
    }

    @Test
    public void testTransitionToRejected() {
        LoanRequestRepository repository = Mockito.mock(LoanRequestRepository.class);
        LoanRequestService service = new LoanRequestServiceImpl(repository);

        LoanRequest loanRequest = new LoanRequest();
        loanRequest.setStatus(LoanRequestStatus.UNDER_REVIEW);

        Mockito.when(repository.findById("1")).thenReturn(loanRequest);

        LoanRequest updatedRequest = service.transitionToNextStatus(loanRequest);

        Assertions.assertEquals(LoanRequestStatus.REJECTED, updatedRequest.getStatus());
    }
}

```
