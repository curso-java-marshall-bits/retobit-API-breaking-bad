# RetoBit: API de Breaking Bad 👨‍🔬

En este RetoBit vamos a continuar el desarrollo de una API de breaking bad. La API ya fue inicializada por compis de nuestro equipo y ahora nos han asignado la tarea de añadir nuevas funcionalidades. Deberemos implementar dos endpoints que nos permitirán obtener un personaje por su ID y cambiar su estado de "Alive" a "Dead". Además, también debemos añadir validaciones en el DTO de creación de personajes.

Puedes ejecutar el proyecto para ver cómo funciona la API y probar los endpoints ya están implementados. La API está construida con Spring Boot y utiliza una base de datos en memoria para almacenar los personajes, así que **no hace falta que configures nada relativo a la base de datos**. Simplemente, ejecuta el proyecto y podrás probar los endpoints ya implementados con Postman usando el puerto `8080`.

### Endpoints ya implementados:
- `GET /api/characters`: Obtiene todos los personajes.
- `POST /api/characters`: Crea un nuevo personaje.

**Añade el puerto `8080` a la URL de la API para probar los endpoints. Por ejemplo, si quieres probar el endpoint `GET /api/characters`, la URL completa sería `http://localhost:8080/api/characters`.*

## ¿Qué practicarás?

- Controladores
- DTOs
- Servicios
- Repositorios
- Excepciones
- Modelos

## Fork del repositorio:

Haz un fork del repo.

Pulsa el botón Fork en github:

![fork](public/img1.png)

Esto creará una copia del repositorio en tu perfil de Github.

## Clona el repo en tu computadora

Ahora hay que descargarse el proyecto en tu computadora.

### 1. Asegúrate de que estás en la URL de TU copia del repositorio


Si la URL es esta: https://github.com/curso-java-marshall-bits/retobit-API-breaking-bad **NO ES CORRECTO**.


Donde aparece 'curso-java-marshall-bits' debería aparecer tu nombre de usuario. Haz click en tu perfil y mira tus repositorios para comprobar si hiciste el fork. En caso contrario vuelve al paso anterior.


### 2. Pulsa en "code" para ver la URL del repositorio y cópiala

![clone](public/img2.png)

Para ello deberás abrir una terminal y navegar a la carpeta donde quieras añadir este retoBit.

Utiliza el siguiente comando:

```commandline
git clone https://aqui.debes.pegar.la.url
```

**Nota: Después del 'git clone' debes pegar la url del repositorio. No pongas la que he puesto yo en el ejemplo 🤣*

Ahora se va a crear un nuevo directorio con el nombre del retobit.

### 3. ¡Ya puedes abrir este reto en IntelliJ!

# Instrucciones

## Tarea 1: Implementación de Endpoints

1. **Obtener personaje por ID**:
   - Implementa el método `findById` en `CharacterServiceImpl`.
   - Usa `characterRepository.findById(id)` para buscar el personaje.
   - Lanza una excepción `ResponseStatusException` si el personaje no existe para mandar una respuesta de **404 Not found** con el mensaje: `Recurso no encontrado`.
   - Implementa el endpoint correspondiente en `CharacterController` usando `@GetMapping("/{id}")`.

2. **Cambiar estado de Alive a Dead**:
   - Implementa el método `updateStatusToDead` en `CharacterServiceImpl`.
   - Busca el personaje por ID, cambia su estado a `DEAD` y guarda los cambios.
   - Implementa el endpoint correspondiente en `CharacterController` usando `@PatchMapping("/{id}/status")`.

## Tarea 2: Validaciones

**DTO para creación de personajes**:
El endpoint para crear personajes ya está implementado, pero debemos asegurarnos de que los datos enviados cumplen con ciertas validaciones.
   - Agrega validaciones en `CreateCharacterDTO`.
   - Usa anotaciones como `@NotBlank`, `@NotNull` y `@Size` para validar los campos obligatorios y limitar la longitud de texto.
   - `name` debe tener un máximo de 100 caracteres.
   - `occupation` debe tener un máximo de 200 caracteres.

## Testing

Para comprobar si has realizado bien el ejercicio ejecuta los tests. Puedes ejecutarlos todos a la vez con el botón derecho en el directorio **src/test/java** seleccionando la opción 'Run tests in Java'.

El test te indicará si has pasado con un tick verde ✅. En caso contrario verás el error.

Ejemplo:

![img.png](public/img3.png)

Pulsa en cualquiera de los tests que has fallado y mira el mensaje de la derecha.

- *Expected*: es el valor que el test estaba esperando.
- *Actual*: es el valor que tu reto está retornando.

## Solución

Si quieres ver una posible solución para el retoBit que pasa todos los tests puedes mirar la rama *solution* dentro del repositorio.

![rama solution](public/img4.png)

Ten en cuenta que hay muchas formas de resolver los ejercicios y la tuya puede pasar los tests iguales, pero ser completamente distinta a la solución. No significa que la tuya esté mal. Compara los resultados y decide cuál te gusta más o te parece más legible.

## Entrega

Realiza un commit con los cambios desde la terminal:

1. Añade todos los cambios
````commandline
git add .
````

2. Haz el commit con el mensaje
````commandline
git commit -m "retobit finalizado"
````

3. Haz un push
````commandline
git push origin main
````

Debes realizar una pull request para entregar el ejercicio. Abre el link del repositorio en github y haz click en la pestaña *pull requests*.

Selecciona *New pull request*, *Create pull request* y confírmala. Esto hará que yo pueda verlo y revisarlo en caso de que haya fallado algún test para poder darte feedback.

Mucha suerte con el reto. Te mando un abrazo y ¡Sigamos desarrollando! 🫂

[marshall-bits.dev](http://marshall-bits.dev)

*Nota: Estos retos pertenecen al curso de Marcel Bosch de Java para desarrolladores junior. Cualquier uso fuera de este contexto debe estar autorizado explícitamente. Si quieres usar estos ejercicios ponte en contacto conmigo a través de mis redes sociales (visita mi página para [más información](http://marshall-bits.dev)).*
