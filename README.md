# PIA2-POO
En este PIA mostraremos una solucion a una problematica

## Problematica
En la dulceria de un cine tienen que apuntar cada pedido de los clientes en una libreta, hacer las cuentas manualmente y registrar las ganancias. Esto hace que sea muy ineficiente, ya que aveces olvidan apuntar una venta, o se hace mal una cuenta y por consiguiente los numeros correctos no dan.

## Solucion
Crearemos un sistema que registre clientes, usuarios, productos y ventas. Cada realizara distintas acciones.
* _Usuario_ - Tendra acceso a todos los clientes ya registrados, a los uasuarios y a todas la ventas hechas previamente, asi como la opcion de hacer una nueva venta, crear un nuevo cliente o agregar un nuevo usuario.
* _Cliente_ - Nos pedira registrar un cliente y le asignara un id, que necesitaremos para poder realizar una venta.
* _Ventas_ - Nos pedira la clave de una venta y nos mostrara la misma, o si no existe nos lo dira.
* _Productos_ - Nos permitira registrar un nuevo producto al inventario para que luego aparezca entre los que vamos a vender.

## Clases y Atributos
### Clases
#### - Cliente.java
* **NuevoCliente**: _String_ nombre, _String_ contacto.
* **ValidarId**: _int_ id.
* **Editar**: _int_ id, _String_ nombre, _String_ contacto.
* **Eliminar**: _int_ id.

#### - Producto.java
* **Editar**: _int_ clave, _int_ cantidad, _String_ nombre, _float_ precio, _String_ estado.
* **Editar**: _int_ clave, _int_ cantidad, _String_ nombre, _float_ precio, _boolean_ estado.
* **ValidarClave**: _int_ clave.
* **ValidarCantidad**: _int_ cantidad.
* **Eliminar**: _int_ clave.
* **modeloproductos**

#### - Usuario.java
* **RegistrarUsuario**: _String_ nombre, _String_ contraseÃ±a, _String_ puesto, _String_ sueldo, _String_ celular.
* **ValidarUsuario**: _int_ ident, _String_ contraseÃ±a.
* **Editar**: _int_ id, _String_ nombre, _String_ contraseÃ±a, _String_ puesto, _String_ sueldo, _String_ celular, _String_ estado.
* **Eliminar**: _int_ id.

#### - Venta.java
* _String_ timeStamp: nos dara la fecha y hora del momento en que se realizo la venta.
* **ValidarCantidad**: _int_ clave, _int_ cantidad.
* **ValidarProducto**: _int_ clave.
* **Precio**: _int_ clave.
* **Producto**: _int_ clave.
* **ValidarEstado**: _int_ clave.
* **ActualizarInventario**: _int_ clave, _int_ cantidad.
* **ObtenerCant**: _int_ clave.
* **NuevoCliente**: _String_ nombre, _String_ contacto.
* **ValidarId**: _int_ id.
* **ValidarClave**: _int_ clave.
* **modeloventas**
* **RegistrarVenta**: _String_ texto.
* **ValidarVenta**: _int_ clave.
* **BuscarVenta**: _int_ clave.

### Frames

## ¿Que Utilizamos?
* NetBeans IDE
* MySQL
* XAMPP
