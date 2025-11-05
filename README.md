# Proyecto Final - TASK MANAGER API
Este proyecto es una API REST para la gestión de tareas, desarrollada con Spring Boot y utilizando MySQL como base de datos. La API permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las tareas.
## 🧩Implementación de JWT
> 🔐 La implementación del sistema **JWT (JSON Web Token)** se encuentra disponible en la rama **`jwt`**, la cual incluye todo el contenido del repositorio principal junto con la integración completa de **autenticación y autorización mediante JWT**.
## Características
- Crear, leer, actualizar y eliminar tareas.
- Documentación automática de la API con Swagger/OpenAPI.
- Manejo de excepciones personalizado.
## Tecnologías Utilizadas
- Java 
- Spring Boot
- MySQL
- Spring Data JPA
- Swagger/OpenAPI
- Maven
## Evidencias

A continuación se muestran las capturas del funcionamiento y la documentación de la API en **Swagger UI**, demostrando cada uno de los endpoints del CRUD completo (Create, Read, Update, Delete).

---

### Vista general – Documentación Swagger UI
> Pantalla principal de la documentación interactiva de la API, donde se muestran todos los endpoints disponibles para la gestión de tareas.

<img width="1921" height="1358" alt="Swagger-UI" src="https://github.com/user-attachments/assets/080286b7-0bb2-45ee-b9d2-de3603a0ed86" />

---

### 🔵 GET `/api/tasks/{id}`
> Permite **obtener una tarea específica** por su identificador (`id`).  
> Devuelve un objeto JSON con el título y descripción correspondientes.

<img width="1921" height="1986" alt="GET ID" src="https://github.com/user-attachments/assets/94848bfc-1f6f-4eb5-988c-a0c452446e9a" />

---

### 🟩 POST `/api/tasks`
> Endpoint para **crear una nueva tarea**.  
> Se observa el cuerpo JSON enviado y la respuesta con código `201 Created`.

<img width="1920" height="2573" alt="POST" src="https://github.com/user-attachments/assets/ae6066f4-3c48-4939-a124-fc93e0417b15" />

---

### 🟠 PUT `/api/tasks/{id}`
> Endpoint para **actualizar una tarea existente** mediante su `id`.  
> Devuelve la tarea actualizada con los nuevos valores del título y la descripción.

<img width="1915" height="2543" alt="PUT" src="https://github.com/user-attachments/assets/e75bd461-89b9-46c1-b155-f61065b4ddc4" />

---

### 🔴 DELETE `/api/tasks/{id}`
> Endpoint para **eliminar una tarea** de la base de datos.  
> Aunque no devuelve cuerpo, responde con un código `204 No Content` indicando que la operación fue exitosa.

<img width="1916" height="1536" alt="DELETE" src="https://github.com/user-attachments/assets/b2d950cf-0dcd-4ec6-ac76-62bd80ab1cf1" />

---

### 🟢 GET `/api/tasks`
> Permite **listar todas las tareas** registradas en la base de datos.  
> Muestra un ejemplo de respuesta con múltiples tareas y su estructura JSON.

<img width="1914" height="2182" alt="GET" src="https://github.com/user-attachments/assets/d4cf7498-4204-451a-8986-59831ca57127" />

---

## 🗄️ Base de datos en MySQL
> Visualización de la tabla `tasks` dentro de la base de datos `task_manager`.  
> Se muestran las tareas almacenadas después de ejecutar la API, confirmando la correcta persistencia de los datos.


<img width="1604" height="879" alt="image" src="https://github.com/user-attachments/assets/bb38d691-9b6e-4cbc-921c-df37632464aa" />
