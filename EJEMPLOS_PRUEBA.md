# 🧪 Ejemplos de Prueba de la API

## Colección de Peticiones para Probar la API

### 1️⃣ Registrar un nuevo usuario

```http
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "username": "testuser",
  "password": "test123",
  "role": "USER"
}
```

**Respuesta esperada:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "username": "testuser",
  "role": "USER"
}
```

---

### 2️⃣ Login como USER

```http
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "user",
  "password": "user123"
}
```

**Respuesta esperada:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjk5...",
  "username": "user",
  "role": "USER"
}
```

---

### 3️⃣ Login como ADMIN

```http
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```

**Respuesta esperada:**

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTY5OT...",
  "username": "admin",
  "role": "ADMIN"
}
```

---

### 4️⃣ Crear una tarea (USER o ADMIN)

```http
POST http://localhost:8080/api/tasks
Content-Type: application/json
Authorization: Bearer TU_TOKEN_AQUI

{
  "titulo": "Implementar autenticación JWT",
  "descripcion": "Agregar Spring Security y JWT al proyecto"
}
```

**Respuesta esperada:**

```json
{
  "id": 1,
  "titulo": "Implementar autenticación JWT",
  "descripcion": "Agregar Spring Security y JWT al proyecto"
}
```

---

### 5️⃣ Listar todas las tareas (USER o ADMIN)

```http
GET http://localhost:8080/api/tasks
Authorization: Bearer TU_TOKEN_AQUI
```

**Respuesta esperada:**

```json
[
  {
    "id": 1,
    "titulo": "Implementar autenticación JWT",
    "descripcion": "Agregar Spring Security y JWT al proyecto"
  },
  {
    "id": 2,
    "titulo": "Documentar la API",
    "descripcion": "Crear documentación con Swagger"
  }
]
```

---

### 6️⃣ Obtener una tarea específica (USER o ADMIN)

```http
GET http://localhost:8080/api/tasks/1
Authorization: Bearer TU_TOKEN_AQUI
```

**Respuesta esperada:**

```json
{
  "id": 1,
  "titulo": "Implementar autenticación JWT",
  "descripcion": "Agregar Spring Security y JWT al proyecto"
}
```

---

### 7️⃣ Actualizar una tarea (solo ADMIN)

```http
PUT http://localhost:8080/api/tasks/1
Content-Type: application/json
Authorization: Bearer TOKEN_DE_ADMIN

{
  "titulo": "Tarea actualizada",
  "descripcion": "Descripción modificada"
}
```

**Respuesta esperada (con token de ADMIN):**

```json
{
  "id": 1,
  "titulo": "Tarea actualizada",
  "descripcion": "Descripción modificada"
}
```

**Respuesta esperada (con token de USER):**

```json
{
  "timestamp": "2025-11-02T18:30:00.000+00:00",
  "status": 403,
  "error": "Forbidden",
  "message": "Access Denied",
  "path": "/api/tasks/1"
}
```

---

### 8️⃣ Eliminar una tarea (solo ADMIN)

```http
DELETE http://localhost:8080/api/tasks/1
Authorization: Bearer TOKEN_DE_ADMIN
```

**Respuesta esperada (con token de ADMIN):**

```
Status: 204 No Content
```

**Respuesta esperada (con token de USER):**

```json
{
  "timestamp": "2025-11-02T18:30:00.000+00:00",
  "status": 403,
  "error": "Forbidden",
  "message": "Access Denied",
  "path": "/api/tasks/1"
}
```

---

### 9️⃣ Intentar acceder sin token (Error 401)

```http
GET http://localhost:8080/api/tasks
```

**Respuesta esperada:**

```json
{
  "timestamp": "2025-11-02T18:30:00.000+00:00",
  "status": 401,
  "error": "Unauthorized",
  "message": "Full authentication is required to access this resource",
  "path": "/api/tasks"
}
```

---

## 📝 Notas importantes

### Formato del token en el header

El token debe enviarse en el header `Authorization` con el prefijo `Bearer `:

```
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9...
```

### Duración del token

Los tokens tienen una validez de **24 horas**. Después de ese tiempo, deberás hacer login nuevamente.

### Permisos por rol

| Operación              | USER | ADMIN |
| ---------------------- | ---- | ----- |
| GET /api/tasks         | ✅   | ✅    |
| GET /api/tasks/{id}    | ✅   | ✅    |
| POST /api/tasks        | ✅   | ✅    |
| PUT /api/tasks/{id}    | ❌   | ✅    |
| DELETE /api/tasks/{id} | ❌   | ✅    |

---

## 🎯 Casos de prueba sugeridos

1. ✅ Login exitoso con usuario válido
2. ❌ Login fallido con credenciales incorrectas
3. ✅ Crear tarea como USER
4. ✅ Crear tarea como ADMIN
5. ✅ Listar tareas como USER
6. ✅ Listar tareas como ADMIN
7. ❌ Intentar actualizar tarea como USER (debe fallar)
8. ✅ Actualizar tarea como ADMIN
9. ❌ Intentar eliminar tarea como USER (debe fallar)
10. ✅ Eliminar tarea como ADMIN
11. ❌ Acceder a endpoint sin token (debe fallar)
12. ❌ Acceder con token expirado (debe fallar después de 24h)

---

**¡Listo para probar!** 🚀

Puedes usar Swagger UI en `http://localhost:8080/swagger-ui.html` para probar de manera interactiva.
