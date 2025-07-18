# RetoBit: Breaking Bad API 🧪⚗️

¡Bienvenido al mundo de Breaking Bad! En este RetoBit desarrollarás una API REST completa para gestionar información de los personajes de la famosa serie. Trabajarás con Spring Boot, JPA, H2 Database y aprenderás a crear endpoints robustos.

## ¿Qué practicarás?

- Spring Boot y arquitectura REST
- JPA (Java Persistence API) y entidades
- Base de datos H2 en memoria
- Inyección de dependencias
- Controladores REST
- Servicios y capas de abstracción
- Validaciones con Bean Validation
- Manejo de excepciones
- DTOs (Data Transfer Objects)

## 🎯 Objetivo

Crear una API REST que permita:
- ✅ Obtener todos los personajes
- ✅ Buscar personaje por ID
- ✅ Buscar personajes por ocupación
- 🔧 **[TU TAREA]** Buscar personajes por estado (vivo/muerto)
- 🔧 **[TU TAREA]** Crear nuevo personaje
- 🔧 **[TU TAREA]** Actualizar personaje existente

## 📋 Estructura del proyecto

```
src/main/java/dev/marshallBits/breakingBadApi/
├── BreakingBadApiApplication.java
├── models/
│   ├── Character.java           ✅ (Completo)
│   └── CharacterStatus.java     ✅ (Completo)
├── repositories/
│   └── CharacterRepository.java ✅ (Completo)
├── services/
│   ├── CharacterService.java    ✅ (Completo)
│   └── CharacterServiceImpl.java 🔧 (Para completar)
├── controllers/
│   └── CharacterController.java 🔧 (Para completar)
├── dto/
│   ├── CharacterDTO.java        ✅ (Completo)
│   └── CreateCharacterDTO.java  🔧 (Para completar)
└── exceptions/
    ├── CharacterNotFoundException.java ✅ (Completo)
    └── GlobalExceptionHandler.java     🔧 (Para completar)
```

## 🚀 Cómo empezar

1. **Fork del repositorio**: Haz un fork de este repositorio
2. **Clona tu fork**: `git clone <tu-fork-url>`
3. **Ejecuta la aplicación**: `./mvnw spring-boot:run`
4. **Accede a H2 Console**: http://localhost:8080/h2-console
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: (vacío)

## 📊 Base de datos

La aplicación se inicializa con 10 personajes icónicos de Breaking Bad:

| ID | Nombre | Ocupación | Estado | Temporadas |
|----|--------|-----------|--------|------------|
| 1 | Walter White | Profesor de Química | Muerto | 1,2,3,4,5 |
| 2 | Jesse Pinkman | Ex-estudiante | Vivo | 1,2,3,4,5 |
| 3 | Skyler White | Contable | Vivo | 1,2,3,4,5 |
| 4 | Hank Schrader | Agente DEA | Muerto | 1,2,3,4,5 |
| 5 | Marie Schrader | Técnico Radiológico | Vivo | 1,2,3,4,5 |
| 6 | Walter White Jr. | Estudiante | Vivo | 1,2,3,4,5 |
| 7 | Saul Goodman | Abogado | Vivo | 2,3,4,5 |
| 8 | Mike Ehrmantraut | Ex-policía | Muerto | 2,3,4,5 |
| 9 | Gus Fring | Empresario | Muerto | 2,3,4 |
| 10 | Tuco Salamanca | Distribuidor | Muerto | 1,2 |

## 🎯 Tareas a completar

### 1. Completar CharacterServiceImpl.java
- Implementar método `findByStatus(CharacterStatus status)`
- Implementar método `createCharacter(CreateCharacterDTO dto)`
- Implementar método `updateCharacter(Long id, CreateCharacterDTO dto)`

### 2. Completar CharacterController.java
- Endpoint `GET /api/characters/status/{status}` 
- Endpoint `POST /api/characters`
- Endpoint `PUT /api/characters/{id}`

### 3. Crear CreateCharacterDTO.java
- Campos necesarios con validaciones apropiadas
- Anotaciones Bean Validation (@NotBlank, @NotNull, etc.)

### 4. Completar GlobalExceptionHandler.java
- Manejo de CharacterNotFoundException
- Manejo de errores de validación
- Respuestas HTTP apropiadas

## 🧪 Endpoints disponibles

### ✅ Implementados
```http
GET /api/characters           # Obtener todos los personajes
GET /api/characters/{id}      # Obtener personaje por ID
GET /api/characters/occupation/{occupation} # Buscar por ocupación
```

### 🔧 Para implementar
```http
GET /api/characters/status/{status}    # Buscar por estado (ALIVE/DEAD)
POST /api/characters                   # Crear nuevo personaje
PUT /api/characters/{id}               # Actualizar personaje
```

## 💡 Tips para el desarrollo

1. **Usa Lombok**: Aprovecha `@Data`, `@Entity`, `@NoArgsConstructor` para reducir boilerplate
2. **Validaciones**: Utiliza Bean Validation en los DTOs
3. **Excepciones**: Crea respuestas HTTP semánticamente correctas
4. **Testing**: Prueba tus endpoints con Postman o desde H2 Console
