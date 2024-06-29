# NasaApiImageSearch

Autor: Joel Joshua Luna Grijalva

## Descripción

Este proyecto es una aplicación Java que consume la API de fotos de Marte de la NASA para buscar imágenes basadas en ciertos parámetros. Utiliza el patrón de diseño Modelo-Vista-Controlador (MVC) y sigue los principios SOLID, especialmente la Inversión de Dependencias. Además, emplea programación funcional con `Stream().filter`.

## Funcionalidades

- Consulta de fotos de Marte por sol y cámara.
- Filtrado de fotos por cámara.
- Visualización de las fotos en una interfaz gráfica hecha con `JFrame`.

## Requisitos

- Java 8 o superior
- Apache Maven

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu_usuario/NasaApiImageSearch.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd NasaApiImageSearch
    ```
3. Construye el proyecto usando Maven:
    ```bash
    mvn clean install
    ```

## Uso

1. Ejecuta la aplicación:
    ```bash
    mvn exec:java -Dexec.mainClass="Main"
    ```

2. Usa la interfaz gráfica para ingresar los parámetros de búsqueda (sol y cámara) y visualizar las fotos.

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- Apache HttpClient
- Jackson Databind
- JUnit (para pruebas)

Estas dependencias están especificadas en el archivo `pom.xml`.

## Estructura del Proyecto

- `controller/`: Contiene la lógica de controladores.
- `model/`: Define los modelos de datos.
- `service/`: Incluye servicios para interactuar con la API y filtrar datos.
- `view/`: Contiene las clases para la interfaz gráfica de usuario.
- `Main.java`: Punto de entrada de la aplicación.

## Ejemplo de Uso de la API

Para consultar fotos de Marte, puedes usar la siguiente URL de ejemplo:
