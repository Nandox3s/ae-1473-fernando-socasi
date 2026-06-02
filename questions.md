# Preguntas — Arquitectura en Capas

## 1. ¿Qué es un controlador?
Es la capa que recibe las peticiones HTTP y decide qué servicio llamar

## 2. ¿Qué responsabilidad tiene la capa de servicio?
Contiene la lógica de negocio y coordina el flujo entre controlador y repositorio

## 3. ¿Qué hace el repositorio y de qué se encarga?
Se comunica con la base de datos para guardar y consultar datos

## 4. ¿Qué es una entidad y a qué se mapea en la base de datos?
Es una clase que representa un dato del sistema y se mapea a una tabla

## 5. ¿Para qué sirve un DTO y por qué no devolvemos la entidad directamente?
Sirve para controlar los datos que entran y salen de la API y evitar exponer la entidad

## 6. ¿Cuál es la diferencia entre un Request y un Response?
Request es lo que envía el cliente y Response es lo que devuelve la API

## 7. ¿Por qué separamos la aplicación en capas? Menciona una ventaja.
Porque cada parte tiene una responsabilidad clara y el código queda más mantenible

## 8. ¿Qué anotación se usa para marcar un controlador REST? ¿Y un servicio?
Se usa `@RestController` para el controlador y `@Service` para el servicio

## 9. ¿Qué hace `@RequestBody` en un endpoint?
Lee el JSON del cuerpo de la petición y lo convierte en un objeto Kotlin

## 10. ¿Cuál es el flujo que sigue un request desde que llega hasta que se guarda en la base de datos?
Llega al controlador y pasa al servicio, el servicio prepara los datos y el repositorio los guarda