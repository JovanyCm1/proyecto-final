## 🔐 Roles y Permisos

### Usuario USER

- **Permisos:**
  - ✅ Crear tareas (POST /api/tasks)
  - ✅ Visualizar todas las tareas (GET /api/tasks)
  - ✅ Visualizar una tarea específica (GET /api/tasks/{id})
  - ❌ Actualizar tareas
  - ❌ Eliminar tareas

### Usuario ADMIN

- **Permisos:**
  - ✅ Crear tareas (POST /api/tasks)
  - ✅ Visualizar todas las tareas (GET /api/tasks)
  - ✅ Visualizar una tarea específica (GET /api/tasks/{id})
  - ✅ Actualizar tareas (PUT /api/tasks/{id})
  - ✅ Eliminar tareas (DELETE /api/tasks/{id})

## 👥 Usuarios Predefinidos

Al iniciar la aplicación, se crean automáticamente dos usuarios:

| Usuario | Contraseña | Rol   |
| ------- | ---------- | ----- |
| user    | user123    | USER  |
| admin   | admin123   | ADMIN |

## 🚀 Cómo usar la API

### 1. Iniciar la aplicación

```bash
./mvnw spring-boot:run
```

La aplicación estará disponible en: `http://localhost:8080`

### 2. Acceder a Swagger UI

Abrir en el navegador: `http://localhost:8080/swagger-ui.html`

### 3. Autenticación

#### 3.1 Iniciar sesión

**Endpoint:** `POST /api/auth/login`

**Request Body (usuario normal):**

```json
{
  "username": "user",
  "password": "user123"
}
```

**Request Body (administrador):**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Response:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "username": "user",
  "role": "USER"
}
```

#### 3.2 Registrar nuevo usuario

**Endpoint:** `POST /api/auth/register`

**Request Body:**

```json
{
  "username": "nuevo_usuario",
  "password": "password123",
  "role": "USER"
}
```

> **Nota:** Los valores permitidos para `role` son: `USER` o `ADMIN`

### 4. Usar el token JWT

Una vez obtenido el token, debes incluirlo en el header `Authorization` de todas las peticiones a endpoints protegidos:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

#### En Swagger UI:

1. Hacer clic en el botón **"Authorize"** 🔒 en la parte superior
2. Introducir el token en el campo (sin necesidad de escribir "Bearer")
3. Hacer clic en **"Authorize"**
4. ¡Listo! Ahora puedes probar los endpoints protegidos

#### Con curl:

```bash
curl -X GET "http://localhost:8080/api/tasks" \
  -H "Authorization: Bearer TU_TOKEN_AQUI"
```

#### Con Postman:

1. Ir a la pestaña **"Authorization"**
2. Seleccionar tipo: **"Bearer Token"**
3. Pegar el token en el campo **"Token"**

### 5. Ejemplos de uso

#### Crear una tarea (USER o ADMIN)

```bash
curl -X POST "http://localhost:8080/api/tasks" \
  -H "Authorization: Bearer TU_TOKEN" \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Completar proyecto",
    "descripcion": "Implementar autenticación JWT"
  }'
```

#### Listar todas las tareas (USER o ADMIN)

```bash
curl -X GET "http://localhost:8080/api/tasks" \
  -H "Authorization: Bearer TU_TOKEN"
```

#### Actualizar una tarea (solo ADMIN)

```bash
curl -X PUT "http://localhost:8080/api/tasks/1" \
  -H "Authorization: Bearer TU_TOKEN_ADMIN" \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Tarea actualizada",
    "descripcion": "Nueva descripción"
  }'
```

#### Eliminar una tarea (solo ADMIN)

```bash
curl -X DELETE "http://localhost:8080/api/tasks/1" \
  -H "Authorization: Bearer TU_TOKEN_ADMIN"
```

## 📚 Endpoints disponibles

### Autenticación

- `POST /api/auth/login` - Iniciar sesión
- `POST /api/auth/register` - Registrar nuevo usuario

### Tareas

- `GET /api/tasks` - Listar todas las tareas (USER, ADMIN)
- `GET /api/tasks/{id}` - Obtener una tarea (USER, ADMIN)
- `POST /api/tasks` - Crear tarea (USER, ADMIN)
- `PUT /api/tasks/{id}` - Actualizar tarea (solo ADMIN)
- `DELETE /api/tasks/{id}` - Eliminar tarea (solo ADMIN)

## ⚙️ Configuración

### Base de datos

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager
spring.datasource.username=root
spring.datasource.password=12345678
```

### JWT

- **Expiración del token:** 24 horas
- **Algoritmo:** HS256

## 🔧 Tecnologías utilizadas

- Spring Boot 3.5.7
- Spring Security 6
- Spring Data JPA
- JWT (io.jsonwebtoken:jjwt 0.12.6)
- MySQL 8
- Lombok
- SpringDoc OpenAPI (Swagger)
- Maven

## 📝 Notas de seguridad

- Los tokens JWT tienen una duración de 24 horas
- Las contraseñas se almacenan encriptadas con BCrypt
- Todos los endpoints de `/api/tasks/**` requieren autenticación
- Los endpoints `/api/auth/**` y Swagger UI son públicos

## 🐛 Troubleshooting

### Error 401 Unauthorized

- Verifica que el token JWT esté incluido en el header Authorization
- Asegúrate de incluir "Bearer " antes del token
- Verifica que el token no haya expirado (24 horas)

### Error 403 Forbidden

- El usuario no tiene los permisos necesarios para realizar la operación
- Verifica que estés usando un usuario con rol ADMIN para operaciones de UPDATE y DELETE

### Error de conexión a la base de datos

- Verifica que MySQL esté ejecutándose
- Asegúrate de que la base de datos `task_manager` exista
- Verifica las credenciales en `application.properties`

---

**Autor:** Jaime Carrizalez
