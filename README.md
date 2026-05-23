# Microservicio de Inventario

Microservicio encargado de la gestión de el inventario de cada producto disponible del sistema de supermercado. Permite consultar y actualizar el stock de un producto, con validaciones de negocio como la existencia del producto dentro del microservicio catalogo.

---

## Configuración

**Puerto:** `8083`  
**Base de datos:** `db_inventario`

**OpenAPI**
```
http://localhost:8083/swagger-ui.html
```

**Eureka**
```
http://localhost:8761/
```

---

## Base de datos

Las tablas son creadas automáticamente por Flyway al iniciar la aplicación.

### `product`
| Campo       | Tipo         | Descripción                          |
|-------------|--------------|--------------------------------------|
| id          | BIGINT (PK)  | Identificador único                  |
| product_id  | BIGINT       | Id único del producto                |
| quantity    | INT          | Cantidad (mayor o igual a 0)         |

---

## URL base

```
http://localhost:8083
```

---

## Endpoints

### Inventory — `/api/v1/inventory`

| Método | Ruta                   | Descripción                       |
|--------|------------------------|-----------------------------------|
| GET    | `/product/{productId}` | Obtener stock de un producto      |
| PATCH  | `/update`              | Actualizar stock del producto     |

---

## Reglas de negocio

- Todo inventario debe tener un producto existente en el catalogo.
- El stock de un producto debe ser igual o mayor a 0.

---

### Integrantes

**- Isidora Gómez**

**- Rayen Bettancourt**
