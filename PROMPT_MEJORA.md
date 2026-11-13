# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/kotlin/domain/application/usecase/TaskUseCase.kt` — La fase "Implementación básica de la API" se implementa aqui: este archivo es el ejercicio.
- `src/main/kotlin/domain/infrastructure/plugins/StatusPages.kt` — La fase "Adición de validaciones y manejo de errores" se implementa aqui: este archivo es el ejercicio.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Kotlin, Senior L2

### Brecha de conocimiento
Construir una API REST en Kotlin con Ktor para gestionar tareas, Implementa endpoints REST en Kotlin con Ktor para crear, listar y actualizar tareas

### Misión / candidato
Exponer la gestion de tareas por HTTP

### Reto
- Tema: API REST de tareas con Kotlin y Ktor
- Seniority: senior-l2
- Tipo: practical
- Título: Gestión de tareas con API REST en Kotlin
- Tiempo estimado: 6 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Implementación básica de la API — objetivo: Crear los endpoints REST básicos para crear, listar y actualizar tareas. — entregable (NO resolver): API REST funcional que permite crear, listar y actualizar tareas con las validaciones básicas.
- Fase 2: Adición de validaciones y manejo de errores — objetivo: Incorporar validaciones adicionales y mejorar el manejo de errores. — entregable (NO resolver): API REST actualizada con validaciones adicionales y manejo de errores mejorado.
- Fase 3: Optimización y refactorización — objetivo: Optimizar el código y refactorizar la API para mejorar su mantenibilidad y rendimiento. — entregable (NO resolver): API REST refactorizada y optimizada con mejoras en mantenibilidad y rendimiento.

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
- Después seguí al PASO 5 (entrega de archivos).

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
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.example</groupId>
  <artifactId>ktor-skeleton</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>
  
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <kotlin.version>1.9.22</kotlin.version>
    <ktor.version>2.3.12</ktor.version>
    <jvm.target>21</jvm.target>
  </properties>

  <dependencies>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-core-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>io.ktor</groupId>
      <artifactId>ktor-server-netty-jvm</artifactId>
      <version>${ktor.version}</version>
    </dependency>
    <dependency>
      <groupId>org.jetbrains.kotlin</groupId>
      <artifactId>kotlin-test-junit</artifactId>
      <version>${kotlin.version}</version>
      <scope>test</scope>
    </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-serialization-kotlinx-json-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-content-negotiation-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-request-validation-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>io.ktor</groupId>
          <artifactId>ktor-server-status-pages-jvm</artifactId>
          <version>2.3.12</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.kotlinx</groupId>
          <artifactId>kotlinx-coroutines-core</artifactId>
          <version>1.8.1</version>
      </dependency>
      <dependency>
          <groupId>org.jetbrains.kotlinx</groupId>
          <artifactId>kotlinx-serialization-json</artifactId>
          <version>1.6.3</version>
      </dependency>
  </dependencies>

  <build>
    <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
    <testSourceDirectory>${project.basedir}/src/test/kotlin</testSourceDirectory>
    <plugins>
      <plugin>
        <groupId>org.jetbrains.kotlin</groupId>
        <artifactId>kotlin-maven-plugin</artifactId>
        <version>${kotlin.version}</version>
        <configuration>
          <compilerPlugins>
            <plugin>kotlinx-serialization</plugin>
          </compilerPlugins>
        </configuration>
        <dependencies>
          <dependency>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-serialization</artifactId>
            <version>${kotlin.version}</version>
          </dependency>
        </dependencies>
        <executions>
          <execution>
            <id>compile</id>
            <goals>
              <goal>compile</goal>
            </goals>
          </execution>
          <execution>
            <id>test-compile</id>
            <goals>
              <goal>test-compile</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.11.0</version>
        <configuration>
          <source>${jvm.target}</source>
          <target>${jvm.target}</target>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

// === ARCHIVO: src/main/kotlin/com/example/Application.kt ===
package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import domain.infrastructure.routing.taskRoutes
import domain.application.usecase.TaskUseCase
import domain.infrastructure.repository.TaskRepositoryImpl
import domain.infrastructure.plugins.configureStatusPages

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}

fun Application.module() {
    val taskRepository = TaskRepositoryImpl()
    val taskUseCase = TaskUseCase(taskRepository)

    configureStatusPages()

    routing {
        taskRoutes(taskUseCase)
    }
}

// === ARCHIVO: mvnw ===
#!/bin/sh
"exec" "$(dirname "$0")/mvnw" "$@"

// === ARCHIVO: mvnw.cmd ===
@REM
@REM Copyright 2007 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM     http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.

@IF "%MAVEN_SKIP_RC%" == "" @
@call :chkMHome
@IF ERRORLEVEL 1 @
@call "%MAVEN_PROJECTBASEDIR%\.mvn\jvm.config" %MAVEN_CMD_LINE_ARGS%
@goto :continue

@:chkMHome
@REM Check for Maven home defined inside Maven wrapper distribution
@IF "%MAVEN_HOME%" == "" (
  @SET MAVEN_HOME=%~dp0\.mvn\wrapper\maven-wrapper
)

@:continue
@set CMD_LINE_ARGS=%*
@set MAVEN_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
@set WRAPPER_JAR="%MAVEN_HOME%\maven-wrapper.jar"
@set WRAPPER_PROPS="%MAVEN_HOME%\maven-wrapper.properties"
@set WRAPPER_LOG="%MAVEN_HOME%\maven-wrapper.log"

@if exist %MAVEN_JAVA_EXE% (
  if exist %WRAPPER_JAR% (
    %MAVEN_JAVA_EXE% %MAVEN_OPTS% -classpath %WRAPPER_JAR% -Dmaven.multiModuleProjectDirectory="%MAVEN_PROJECTBASEDIR%" org.apache.maven.wrapper.MavenWrapperMain %CMD_LINE_ARGS%
  ) else (
    @echo Could not locate maven-wrapper.jar, using basic mvn commands
    @call mvn %CMD_LINE_ARGS%
  )
) else (
  @echo Could not locate java.exe, please check JAVA_HOME
)

// === ARCHIVO: .mvn/wrapper/maven-wrapper.properties ===
distributionUrl=https://repo.maven.apache.org/maven2/org/apache/maven/apache-maven/3.9.6/apache-maven-3.9.6-bin.zip
wrapperUrl=https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.3.0/maven-wrapper-3.3.0.jar

// === ARCHIVO: src/main/kotlin/domain/domain/model/Task.kt ===
package domain.model

import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val description: String,
    val status: TaskStatus
) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(description.isNotBlank()) { "Description cannot be blank" }
    }

    enum class TaskStatus {
        PENDING,
        IN_PROGRESS,
        COMPLETED
    }
}

// === ARCHIVO: src/main/kotlin/domain/domain/repository/TaskRepository.kt ===
package domain.repository

import domain.model.Task

interface TaskRepository {
    suspend fun findAll(): List<Task>
    suspend fun findById(id: String): Task?
    suspend fun findByTitle(title: String): Task?
    suspend fun save(task: Task): Task
    suspend fun update(task: Task): Task
    suspend fun delete(id: String)
}

// === ARCHIVO: src/main/kotlin/domain/application/dto/TaskRequest.kt ===
package domain.application.dto

import domain.model.Task
import io.ktor.server.application.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.request.*
import kotlinx.serialization.Serializable

@Serializable
data class TaskRequest(
    val title: String,
    val description: String,
    val status: Task.TaskStatus
) {
    init {
        require(title.isNotBlank()) { "Title cannot be blank" }
        require(description.isNotBlank()) { "Description cannot be blank" }
    }

    companion object {
        suspend fun fromApplicationCall(call: ApplicationCall): TaskRequest {
            return call.receive<TaskRequest>()
        }

        fun toValidationRequest(): RequestValidationConfig.() -> Unit = {
            validate<TaskRequest> { request ->
                if (request.title.isBlank()) {
                    ValidationResult.Invalid("Title cannot be blank")
                } else if (request.description.isBlank()) {
                    ValidationResult.Invalid("Description cannot be blank")
                } else if (request.title.length < 3) {
                    ValidationResult.Invalid("Title must be at least 3 characters long")
                } else if (request.description.length < 10) {
                    ValidationResult.Invalid("Description must be at least 10 characters long")
                } else {
                    ValidationResult.Valid
                }
            }
        }

        fun validateTitleUniqueness(title: String, existingTitles: Set<String>): ValidationResult {
            return if (existingTitles.contains(title.lowercase())) {
                ValidationResult.Invalid("A task with this title already exists")
            } else {
                ValidationResult.Valid
            }
        }

        fun validateStatusTransition(currentStatus: Task.TaskStatus?, newStatus: Task.TaskStatus): ValidationResult {
            if (currentStatus == null) {
                return ValidationResult.Valid
            }
            
            return when {
                currentStatus == Task.TaskStatus.COMPLETED && newStatus != Task.TaskStatus.COMPLETED -> {
                    ValidationResult.Invalid("Cannot reopen a completed task")
                }
                else -> ValidationResult.Valid
            }
        }
    }

    fun toTask(): Task {
        return Task(
            id = java.util.UUID.randomUUID().toString(),
            title = this.title,
            description = this.description,
            status = this.status
        )
    }

    fun validate(): List<String> {
        val errors = mutableListOf<String>()
        
        if (title.isBlank()) {
            errors.add("Title cannot be blank")
        } else if (title.length < 3) {
            errors.add("Title must be at least 3 characters long")
        } else if (title.length > 100) {
            errors.add("Title cannot exceed 100 characters")
        }
        
        if (description.isBlank()) {
            errors.add("Description cannot be blank")
        } else if (description.length < 10) {
            errors.add("Description must be at least 10 characters long")
        } else if (description.length > 500) {
            errors.add("Description cannot exceed 500 characters")
        }
        
        if (status == null) {
            errors.add("Status is required")
        }
        
        return errors
    }

    fun isValid(): Boolean {
        return validate().isEmpty()
    }
}

// === ARCHIVO: src/main/kotlin/domain/application/dto/TaskResponse.kt ===
package domain.application.dto

import domain.model.Task
import java.time.Instant

data class TaskResponse(
    val id: String,
    val title: String,
    val description: String,
    val status: Task.TaskStatus,
    val createdAt: Instant = Instant.now(),
    val updatedAt: Instant = Instant.now()
) {
    companion object {
        fun fromTask(task: Task): TaskResponse {
            return TaskResponse(
                id = task.id,
                title = task.title,
                description = task.description,
                status = task.status
            )
        }

        fun fromTaskList(tasks: List<Task>): List<TaskResponse> {
            return tasks.map { fromTask(it) }
        }
    }
}

data class ErrorResponse(
    val error: String,
    val message: String,
    val timestamp: Instant = Instant.now()
)

// === ARCHIVO: src/main/kotlin/domain/application/usecase/TaskUseCase.kt ===
package domain.application.usecase

import domain.application.dto.TaskRequest
import domain.application.dto.TaskResponse
import domain.repository.TaskRepository
import io.ktor.server.plugins.*

class TaskUseCase(private val taskRepository: TaskRepository) {
    suspend fun createTask(request: TaskRequest): TaskResponse {
        // TODO(reto): Implementar la lógica para crear una tarea
        // - Validar que el título sea único
        // - Convertir TaskRequest a Task
        // - Guardar la tarea usando el repositorio
        // - Retornar TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }

    suspend fun getAllTasks(): List<TaskResponse> {
        // TODO(reto): Implementar la lógica para listar todas las tareas
        // - Obtener todas las tareas del repositorio
        // - Convertir la lista de Task a lista de TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }

    suspend fun updateTask(id: String, request: TaskRequest): TaskResponse {
        // TODO(reto): Implementar la lógica para actualizar una tarea
        // - Validar que la tarea exista
        // - Validar que el título sea único (excepto para la misma tarea)
        // - Actualizar la tarea usando el repositorio
        // - Retornar TaskResponse
        throw NotImplementedError("Implementación pendiente")
    }
}

// === ARCHIVO: src/main/kotlin/domain/infrastructure/repository/TaskRepositoryImpl.kt ===
package domain.infrastructure.repository

import domain.model.Task
import domain.repository.TaskRepository
import java.util.concurrent.ConcurrentHashMap

class TaskRepositoryImpl : TaskRepository {
    private val tasks = ConcurrentHashMap<String, Task>()

    override suspend fun findAll(): List<Task> {
        return tasks.values.toList()
    }

    override suspend fun findById(id: String): Task? {
        return tasks[id]
    }

    override suspend fun findByTitle(title: String): Task? {
        return tasks.values.find { it.title == title }
    }

    override suspend fun save(task: Task): Task {
        tasks[task.id] = task
        return task
    }

    override suspend fun update(task: Task): Task {
        tasks[task.id] = task
        return task
    }

    override suspend fun delete(id: String) {
        tasks.remove(id)
    }
}

// === ARCHIVO: src/main/kotlin/domain/infrastructure/routing/TaskRoutes.kt ===
package domain.infrastructure.routing

import domain.application.dto.TaskRequest
import domain.application.dto.TaskResponse
import domain.application.usecase.TaskUseCase
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.UUID

fun Route.taskRoutes(taskUseCase: TaskUseCase) {
    route("/api/tasks") {
        get {
            try {
                val tasks = taskUseCase.getAllTasks()
                call.respond(tasks)
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = TaskResponse(
                        id = UUID.randomUUID().toString(),
                        title = "Error",
                        description = e.message ?: "Unknown error occurred",
                        status = domain.model.Task.TaskStatus.PENDING
                    )
                )
            }
        }

        post {
            try {
                val request = call.receive<TaskRequest>()
                val createdTask = taskUseCase.createTask(request)
                call.respond(
                    status = io.ktor.http.HttpStatusCode.Created,
                    message = createdTask
                )
            } catch (e: IllegalArgumentException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.BadRequest,
                    message = mapOf(
                        "error" to "Validation Error",
                        "message" to (e.message ?: "Invalid request data")
                    )
                )
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        get("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@get
                }
                
                val task = taskUseCase.getAllTasks().find { it.id == id }
                if (task != null) {
                    call.respond(task)
                } else {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NotFound,
                        message = mapOf(
                            "error" to "Not Found",
                            "message" to "Task with id $id not found"
                        )
                    )
                }
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        put("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@put
                }

                val request = call.receive<TaskRequest>()
                val updatedTask = taskUseCase.updateTask(id, request)
                call.respond(
                    status = io.ktor.http.HttpStatusCode.OK,
                    message = updatedTask
                )
            } catch (e: IllegalArgumentException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.BadRequest,
                    message = mapOf(
                        "error" to "Validation Error",
                        "message" to (e.message ?: "Invalid request data")
                    )
                )
            } catch (e: NoSuchElementException) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.NotFound,
                    message = mapOf(
                        "error" to "Not Found",
                        "message" to (e.message ?: "Task not found")
                    )
                )
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }

        delete("/{id}") {
            try {
                val id = call.parameters["id"] ?: run {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.BadRequest,
                        message = mapOf("error" to "Missing task ID")
                    )
                    return@delete
                }

                val existingTask = taskUseCase.getAllTasks().find { it.id == id }
                if (existingTask != null) {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NoContent,
                        message = ""
                    )
                } else {
                    call.respond(
                        status = io.ktor.http.HttpStatusCode.NotFound,
                        message = mapOf(
                            "error" to "Not Found",
                            "message" to "Task with id $id not found"
                        )
                    )
                }
            } catch (e: Exception) {
                call.respond(
                    status = io.ktor.http.HttpStatusCode.InternalServerError,
                    message = mapOf(
                        "error" to "Internal Server Error",
                        "message" to (e.message ?: "Unknown error occurred")
                    )
                )
            }
        }
    }
}

// === ARCHIVO: src/main/kotlin/domain/infrastructure/plugins/StatusPages.kt ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.infrastructure.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.response.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

fun Application.configureStatusPages() {
  TODO("reto: configureStatusPages")
}
```
