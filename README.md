# Proyecto Final Curso Grupo 2

## Ecommerce

El proyecto será crear plataforma o web Ecommerce de productos.

## Componentes del grupo

![img.png](src/main/resources/images/img.png)

# Descripción proyecto

Esta es la explicación en detalle del proyecto Ecommerce (en adelante Shop)

## Entidades para Shop

* USUARIO
  * id (PK)
  * nombre_usuario
  * password
  * email
  * direccion

* CATEGORIA
  * id (PK)
  * nombre
  * descripcion

* PRODUCTO ManytoOne
  * id (PK)
  * nombre
  * descripcion
  * precio
  * stock
  * disponible
  * image_url ? Preguntar a Maria
  * categoria_id (FK)

* COMPRA
  * id (PK)
  * fecha_compra
  * total
  * usuario_id (FK)

* DETALLE_COMPRA
  * id (PK)
  * cantidad
  * precio_unitario
  * dto_compra (duda)
  * compra_id (FK)
  * producto_id (FK)
  * producto_nombre (FK)

## CONTROLLERS



## HTML

 index.html
 productos.html
 categorias.html
 compra.html
 detalle_compra.html

## Desglose del trabajo

Entities
 Antonio
Repositorys
 Luis Miguel (buscar datos)
Controller
 Entre todos
Html
 Yo

