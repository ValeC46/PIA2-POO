# Dulceria de Cine
## Nombre de los integrantes:

Jorge Daniel Benavides Gómez _Matrícula_: 1931714

Oscar Iván Salinas Jaramillo _Matricula_: 1928800

Ingrid Valeria Cordero Elizondo _Matricula_: 1972274

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
#### - AgregarProducto.java
* _Producto_ pdcto: nos dara el acceso a la clase Producto.
* **initComponents**
* **claveboxActionPerformed**: _ActionEvent_ evt.
* **precioboxActionPerformed**: _ActionEvent_ evt.
* **jButton2ActionPerformed**: _ActionEvent_ evt.
* **GuardarActionPerformed**: _ActionEvent_ evt.
* **claveboxKeyTyped**: _KeyEvent_ evt.
* **cantboxKeyTyped**: _KeyEvent_ evt.
* **precioboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ Guardar
* _JLabel_ cant
* _JTextField_ cantbox
* _JTextField_ clavebox
* _JButton_ jButton2
* _JLabel_ jLabel7
* _JLabel_ jLabel8
* _JLabel_ jLabel9
* _JTextField_ nombrebox
* _JLabel_ nombret
* _JTextField_ preciobox
* _JLabel_ preciot

#### - BusquedaUsuario.java
* _Usuario_ user: nos dara el acceso a la clase Usuario.
* **initComponents**
* **idboxActionPerformed**: _ActionEvent_ evt.
* **nombreboxActionPerformed**: _ActionEvent_ evt.
* **sueldoboxActionPerformed**: _ActionEvent_ evt.
* **puestoboxActionPerformed**: _ActionEvent_ evt.
* **celularboxActionPerformed**: _ActionEvent_ evt.
* **estboxActionPerformed**: _ActionEvent_ evt.
* **EliminarActionPerformed**: _ActionEvent_ evt.
* **guardarActionPerformed**: _ActionEvent_ evt.
* **HabilitarActionPerformed**: _ActionEvent_ evt.
* **jButton4ActionPerformed**: _ActionEvent_ evt.
* **sueldoboxKeyTyped**: _KeyEvent_ evt.
* **celularboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ Eliminar
* _JButton_ Habilitar
* _JTextField_ celularbox
* _JTextField_ contrabox
* _JTextField_ estbox
* _JButton_ guardar
* _JTextField_ idbox
* _JButton_ jButton4
* _JLabel_ jLabel1
* _JLabel_ jLabel2
* _JLabel_ jLabel3
* _JLabel_ jLabel4
* _JLabel_ jLabel5
* _JLabel_ jLabel6
* _JLabel_ jLabel7
* _JLabel_ jLabel8
* _JTextField_ nombrebox
* _JTextField_ puestobox
* _JTextField_ sueldobox

#### - ConsultaVenta.java
* _Venta_ venta: nos dara el acceso a la clase Venta.
* **initComponents**
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **BuscarActionPerformed**: _ActionEvent_ evt.
* **claveboxKeyTyped**: _KeyEvent_ evt.
* **Buscar2ActionPerformed**: _ActionEvent_ evt.
* **main**
* _JButton_ Buscar
* _JButton_ Buscar2
* _JTextField_ clavebox
* _JButton_ jButton1
* _JLabel_ jLabel6
* _JLabel_ jLabel8
* _JScrollPane_ jScrollPane1
* _JComboBox(String)_ lista
* _JTextArea_ panel

#### - FrameCliente.java
* _Cliente_ cliente: nos dara el acceso a la clase Cliente.
* **initComponents**
* **idboxActionPerformed**: _ActionEvent_ evt.
* **nombreboxActionPerformed**: _ActionEvent_ evt.
* **contactoboxActionPerformed**: _ActionEvent_ evt.
* **BuscarActionPerformed**: _ActionEvent_ evt.
* **GuardarCambiosActionPerformed**: _ActionEvent_ evt.
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **EliminarActionPerformed**: _ActionEvent_ evt.
* **GuardarClienteActionPerformed**: _ActionEvent_ evt.
* **HabilitarActionPerformed**: _ActionEvent_ evt.
* **Buscar2ActionPerformed**: _ActionEvent_ evt.
* **NuevoActionPerformed**: _ActionEvent_ evt.
* **idboxKeyTyped**: _KeyEvent_ evt.
* **contactoboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ Buscar
* _JButton_ Buscar2
* _JButton_ Eliminar
* _JButton_ GuardarCambios
* _JButton_ GuardarCLiente
* _JButton_ Habilitar
* _JButton_ Nuevo
* _JTextField_ contactobox
* _JTextField_ idbox
* _JLabel_ idt
* _JButton_ jButton1
* _JLabel_ jLabel6
* _JTextField_ nombrebox
* _JLabel_ t1
* _JLabel_ t2

#### - FrameMenu.java
* **initComponents**
* **jLabel5MousePressed**: _MouseEvent_ evt.
* **jLabel4MouseClicked**: _MouseEvent_ evt.
* **BuscarActionPerformed**: _ActionEvent_ evt.
* **jLabel3MouseClicked**: _MouseEvent_ evt.
* **jLabel2MouseClicked**: _MouseEvent_ evt.
* **jLabel6MouseClicked**: _MouseEvent_ evt.
* **main**
* _JButton_ jButton1
* _JLabel_ jLabel1
* _JLabel_ jLabel2
* _JLabel_ jLabel3
* _JLabel_ jLabel4
* _JLabel_ jLabel5
* _JLabel_ jLabel6
* _JPanel_ jPanel1
* _JLabel_ title

#### - FramePrincipal.java
* _Usuario_ user: nos dara el acceso a la clase Usuario.
* **initComponents**
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **usuarioTxtKeyTyped**: _KeyEvent_ evt.
* **main**
* _JTextField_ contraTxt
* _JButton_ jButton1
* _JLabel_ passLabel
* _JLabel_ title
* _JLabel_ userLabel
* _JTextField_ usuarioTxt

#### - FrameUsuario.java
* _Usuario_ user: nos dara el acceso a la clase Cliente.
* _String_ id.
* _String_ nombre.
* _String_ contraseÃ.
* _String_ puesto.
* _String_ sueldo.
* _String_ celular.
* _boolean_ estado.
* **initComponents**
* **PuestoboxActionPerformed**: _ActionEvent_ evt.
* **NombreboxActionPerformed**: _ActionEvent_ evt.
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **jButton1MouseClicked**: _MouseEvent_ evt.
* **BusquedaIdboxActionPerformed**: _ActionEvent_ evt.
* **BotonBusquedaActionPerformed**: _ActionEvent_ evt.
* **VolverActionPerformed**: _ActionEvent_ evt.
* **BusquedaIdboxKeyTyped**: _KeyEvent_ evt.
* **SueldoboxKeyTyped**: _KeyEvent_ evt.
* **CelularboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ BotonBusqueda
* _JTextField_ BusquedaIdbox
* _JTextField_ Celularbox
* _JTextField_ Nombrebox
* _JTextField_ Passbox
* _JTextField_ Puestobox
* _JTextField_ Sueldobox
* _JButton_ Volver
* _JButton_ jButton1
* _JLabel_ jLabel1
* _JLabel_ jLabel2
* _JLabel_ jLabel3
* _JLabel_ jLabel4
* _JLabel_ jLabel5
* _JLabel_ jLabel6
* _JLabel_ jLabel7
* _JLabel_ jLabel8
* _JLabel_ jLabel9

#### - FrameVenta.java
* _Producto_ pc: nos dara el acceso a la clase Producto.
* _Venta_ vta: nos dara el acceso a la clase Venta.
* _float_ total.
* _float_ precio.
* _String_ cliente.
* _boolean_ v1.
* _boolean_ v2.
* _String_ Texto.
* **initComponents**
* **claveboxActionPerformed**: _ActionEvent_ evt.
* **AgregarActionPerformed**: _ActionEvent_ evt.
* **ConfirmarActionPerformed**: _ActionEvent_ evt.
* **contactoboxActionPerformed**: _ActionEvent_ evt.
* **nombreboxActionPerformed**: _ActionEvent_ evt.
* **NuevoActionPerformed**: _ActionEvent_ evt.
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **GuardarClienteActionPerformed**: _ActionEvent_ evt.
* **idboxActionPerformed**: _ActionEvent_ evt.
* **Validar2ActionPerformed**: _ActionEvent_ evt.
* **totalboxActionPerformed**: _ActionEvent_ evt.
* **conboxActionPerformed**: _ActionEvent_ evt.
* **ValidarActionPerformed**: _ActionEvent_ evt.
* **claveboxKeyTyped**: _KeyEvent_ evt.
* **cantboxKeyTyped**: _KeyEvent_ evt.
* **idboxKeyTyped**: _KeyEvent_ evt.
* **contactoboxKeyTyped**: _KeyEvent_ evt.
* **conboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ Agregar
* _JLabel_ CON
* _JButton_ Confirmar
* _JButton_ GuardarCliente
* _JTextArea_ Lista
* _JButton_ Nuevo
* _JButton_ Validar
* _JLabel_ cant
* _JTextField_ cantbox
* _JTextField_ clavebox
* _JComboBox(String)_ claves
* _JTextField_ conbox
* _JLabel_ contact
* _JTextField_ contactobox
* _JTextField_ idbox
* _JLabel_ idt
* _JButton_ jButton1
* _JLabel_ jLabel6
* _JLabel_ jLabel8
* _JLabel_ jLabel9
* _JScrollPane_ jScrollPane1
* _JTextField_ nombrebox
* _JLabel_ nombret
* _JLabel_ nombret1
* _JTextField_ totalbox
* _JButton_ validar2

#### - Inventario.java
* _Producto_ pc: nos dara el acceso a la clase Producto.
* **initComponents**
* **precioboxActionPerformed**: _ActionEvent_ evt.
* **claveboxActionPerformed**: _ActionEvent_ evt.
* **BuscarActionPerformed**: _ActionEvent_ evt.
* **GuardarActionPerformed**: _ActionEvent_ evt.
* **HabilitarActionPerformed**: _ActionEvent_ evt.
* **estboxActionPerformed**: _ActionEvent_ evt.
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **Buscar2ActionPerformed**: _ActionEvent_ evt.
* **jButton2ActionPerformed**: _ActionEvent_ evt.
* **EliminarActionPerformed**: _ActionEvent_ evt.
* **claveboxKeyTyped**: _KeyEvent_ evt.
* **cantboxKeyTyped**: _KeyEvent_ evt.
* **precioboxKeyTyped**: _KeyEvent_ evt.
* **main**
* _JButton_ Buscar
* _JButton_ Buscar2
* _JButton_ Eliminar
* _JButton_ Guardar
* _JButton_ Habilitar
* _JLabel_ cant
* _JTextField_ cantTxt
* _JTextField_ claveTxt
* _JComboBox(String)_ claves
* _JLabel_ estadot
* _JTextField_ estbox
* _JButton_ jButton1
* _JButton_ jButton2
* _JLabel_ jLabel6
* _JLabel_ jLabel7
* _JLabel_ jLabel8
* _JTextField_ nombrebox
* _JLabel_ nombret
* _JTextField_ preciobox
* _JLabel_ preciot

#### - NewJFrame.java
* **initComponents**
* **main**

#### - Ticket.java
* _FrameVenta_ ticket: nos dara el acceso a la clase FrameVenta.
* _Venta_ venta: nos dara el acceso a la clase Venta.
* **initComponents**
* **jButton1ActionPerformed**: _ActionEvent_ evt.
* **main**
* _JButton_ jButton1
* _JScrollPane_ jScrollPane1
* _JTextPane_ lista

## ¿Que Utilizamos?
* NetBeans IDE
* MySQL
* XAMPP
