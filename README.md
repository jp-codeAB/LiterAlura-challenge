# 📚 LiterAlura - Challenge Alura Latam

##  Descripción del Proyecto
**LiterAlura** es un catálogo de libros interactivo que permite la gestión de literatura mediante el consumo de la API de **Gutendex**. El sistema permite buscar libros por título, persistirlos en una base de datos relacional y realizar consultas avanzadas sobre autores y sus obras. 

El enfoque principal es la aplicación de la **Programación Orientada a Objetos (POO)**, la persistencia de datos con **Spring Data JPA** y la integración de servicios externos siguiendo los principios de **Clean Code**.

---

## 2. Metodología de Trabajo
Se utilizó la metodología **Kanban** para la gestión ágil del proyecto, permitiendo un flujo de trabajo continuo y visual.

* **🗂 Herramienta utilizada:** [Trello](https://trello.com/b/WDyMPDMb/literalura-challenge-java)
* **Columnas empleadas:**
    * `Backlog`: Ideas y requerimientos pendientes.
    * `En Desarrollo`: Tareas en implementación actual.
    * `Pausado`: Funcionalidades pospuestas.
    * `Concluido`: Tareas finalizadas.

---

## 3. Tecnologías Utilizadas

### 🛠 Stack Tecnológico
| Tecnología | Versión / Detalle |
| :--- | :--- |
| **Java** | 21 (LTS) |
| **Spring Boot** | 4.0.3 |
| **Spring Data JPA** | Gestión de persistencia |
| **PostgreSQL** | Base de datos relacional |
| **Jackson** | 2.13.2 |
| **Gradle** | Gestor de dependencias |

### ⚙️ Configuración del Proyecto (build.gradle)
```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '4.0.3'
    id 'io.spring.dependency-management' version '1.1.7'
}

group = 'com.aluracursos'
version = '0.0.1-SNAPSHOT'
description = 'Project for Alura'

java {
    toolchain {
       languageVersion = JavaLanguageVersion.of(21)
    }
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.20.1'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'org.postgresql:postgresql'
}
```

##Configuración de Base de Datos
spring:
  application:
    name: literalura-challenge

  datasource:
    url: jdbc:postgresql://${DB_HOST}/biblioteca_alura
    username: ${DB_USER}
    password: ${DB_PASSWORD}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true

