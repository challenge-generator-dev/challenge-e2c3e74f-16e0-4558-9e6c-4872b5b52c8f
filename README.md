# Gestión de tareas con API REST en Kotlin

Necesitas construir una API REST en Kotlin con Ktor para gestionar tareas en una plataforma de gestión de proyectos. La API debe soportar la creación, listación y actualización de tareas. Cada tarea tiene un título, una descripción y un estado (pendiente, en progreso, completado). La API debe asegurar que los títulos de las tareas sean únicos y que las descripciones no estén vacías. En caso de violación de estas reglas, la API debe responder con un código de error apropiado y un mensaje descriptivo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | API REST de tareas con Kotlin y Ktor |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 6 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Implementación básica de la API

**Objetivo:** Crear los endpoints REST básicos para crear, listar y actualizar tareas.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Define un modelo de datos para las tareas que incluya título, descripción y estado.
- Implementa los endpoints REST para crear, listar y actualizar tareas.
- Asegúrate de que los títulos de las tareas sean únicos y que las descripciones no estén vacías.

**Entregable:** API REST funcional que permite crear, listar y actualizar tareas con las validaciones básicas.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo estructurar la información de las tareas.
- Piensa en cómo manejar los errores de validación.

</details>

### Fase 2: Adición de validaciones y manejo de errores

**Objetivo:** Incorporar validaciones adicionales y mejorar el manejo de errores.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Añade validaciones para asegurar que el estado de la tarea sea uno de los valores permitidos (pendiente, en progreso, completado).
- Mejora el manejo de errores para proporcionar mensajes más descriptivos y códigos de error específicos.

**Entregable:** API REST actualizada con validaciones adicionales y manejo de errores mejorado.

<details>
<summary>Pistas de conocimiento</summary>

- Piensa en cómo validar el estado de la tarea.
- Considera cómo mejorar la comunicación de errores al usuario.

</details>

### Fase 3: Optimización y refactorización

**Objetivo:** Optimizar el código y refactorizar la API para mejorar su mantenibilidad y rendimiento.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Revisa el código y busca oportunidades para optimizar y refactorizar.
- Aplica patrones de diseño y buenas prácticas para mejorar la mantenibilidad y el rendimiento de la API.

**Entregable:** API REST refactorizada y optimizada con mejoras en mantenibilidad y rendimiento.

<details>
<summary>Pistas de conocimiento</summary>

- Considera patrones de diseño y buenas prácticas.
- Piensa en cómo mejorar la estructura y organización del código.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es una tarea y cómo se representa en la API?
- **paraQueSirve**: ¿Para qué sirven los endpoints REST en la gestión de tareas?
- **comoSeUsa**: ¿Cómo se usan las validaciones y el manejo de errores en la API?
- **erroresComunes**: ¿Cuáles son los errores comunes en la gestión de tareas y cómo se manejan en la API?
- **queDecisionesImplica**: ¿Qué decisiones implica la optimización y refactorización de la API?

## Criterios de Evaluacion

- Implementación de endpoints REST para crear, listar y actualizar tareas.
- Validación de títulos únicos y descripciones no vacías.
- Validación de estados de tareas permitidos.
- Manejo de errores con mensajes descriptivos y códigos de error específicos.
- Optimización y refactorización del código para mejorar mantenibilidad y rendimiento.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
