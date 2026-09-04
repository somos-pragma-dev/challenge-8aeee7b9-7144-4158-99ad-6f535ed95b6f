# Implementación del Ciclo de Vida del Estado en el Pipeline

El sistema de gestión de solicitudes de préstamo requiere un proceso robusto para manejar el ciclo de vida del estado de las solicitudes a medida que avanzan por el pipeline. Las solicitudes pasan por varios estados: 'Recibido', 'En Revisión', 'Aprobado', 'Rechazado'. El sistema debe asegurar la trazabilidad y la consistencia del estado en cada transición. Los actores involucrados son el 'originador de créditos', el'motor antifraude', y el 'core bancario'. Cada transición debe ser idempotente y manejar adecuadamente los errores como timeouts del buró y respuestas 5xx del core.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Status Progression Test |
| **Nivel** | junior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: Un IDE o editor de código.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Verifica que el proyecto arranca sin errores.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Definición de Estados y Transiciones

**Objetivo:** Establecer los estados válidos y las transiciones permitidas entre ellos.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar los estados válidos de una solicitud de préstamo.
- Definir las transiciones permitidas entre los estados.
- Establecer criterios de aceptación para cada transición.

**Entregable:** Documento que describe los estados y transiciones válidos.

<details>
<summary>Pistas de conocimiento</summary>

- Considera la trazabilidad y la consistencia en cada transición.
- Piensa en cómo manejar errores comunes como timeouts y respuestas de error del core.

</details>

### Fase 2: Implementación de la Lógica de Transición

**Objetivo:** Implementar la lógica para manejar las transiciones de estado.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Desarrollar la lógica para manejar las transiciones de estado definidas en la fase anterior.
- Asegurar que cada transición sea idempotente.
- Manejar adecuadamente los errores como timeouts y respuestas 5xx.

**Entregable:** Implementación de la lógica de transición de estados.

<details>
<summary>Pistas de conocimiento</summary>

- Recuerda que la idempotencia implica que múltiples invocaciones con la misma clave deben producir el mismo resultado.
- Considera cómo comunicar los errores al sistema y al usuario de manera efectiva.

</details>

### Fase 3: Integración y Pruebas

**Objetivo:** Integrar la lógica de transición con el pipeline y realizar pruebas exhaustivas.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Integrar la lógica de transición con el pipeline existente.
- Realizar pruebas unitarias y de integración para validar el comportamiento de las transiciones.
- Asegurar que el sistema maneje correctamente los edge cases identificados.

**Entregable:** Pipeline integrado con la lógica de transición y reporte de pruebas.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza casos de prueba que cubran tanto los casos felices como los edge cases.
- Asegúrate de que las pruebas validen la idempotencia y el manejo de errores.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Cuáles son los estados válidos de una solicitud de préstamo y cómo se relacionan entre sí?
- **paraQueSirve**: ¿Por qué es importante manejar las transiciones de estado de manera idempotente?
- **comoSeUsa**: ¿Cómo implementaste la lógica para manejar las transiciones de estado?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir durante las transiciones de estado y cómo los manejaste?
- **queDecisionesImplica**: ¿Qué decisiones tomaste al integrar la lógica de transición con el pipeline?

## Criterios de Evaluacion

- Definición clara de estados y transiciones válidas.
- Implementación idempotente de la lógica de transición.
- Manejo adecuado de errores comunes durante las transiciones.
- Integración exitosa con el pipeline y pruebas exhaustivas.

## Como trabajar con un asistente de IA

- **AGENTS.md** — instrucciones nativas del repo (Cursor, Codex, Copilot, Gemini, Claude Code). Abrí el proyecto y el agente las carga solo.
- **PROMPT_MEJORA.md** — el mismo prompt, para copiar y pegar en un chat (claude.ai, ChatGPT, etc.).

---

*Reto generado automaticamente por Challenge Generator - Pragma*
