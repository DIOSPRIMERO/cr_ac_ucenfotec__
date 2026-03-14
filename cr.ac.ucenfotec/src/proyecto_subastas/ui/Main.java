package proyecto_subastas.ui;

import proyecto_subastas.control.ControladorSubasta;
import proyecto_subastas.control.ControladorUsuario;
import proyecto_subastas.dominio.ObjetoSubasta;
import proyecto_subastas.dominio.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Clase principal de la interfaz gráfica de la plataforma de subastas.
 *
 * Implementa el menú de usuario mediante cuadros de diálogo (JOptionPane) y
 * delega toda la lógica de negocio a los controladores correspondientes.
 * La interfaz <b>no instancia objetos de negocio directamente</b>; toda creación
 * de objetos de dominio se realiza en la capa de control.
 * </p>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see ControladorUsuario
 * @see ControladorSubasta
 */
public class Main {

    /** Controlador encargado de la gestión de usuarios. */
    private static ControladorUsuario ctrlUsuario = new ControladorUsuario();

    /** Controlador encargado de la gestión de subastas y ofertas. */
    private static ControladorSubasta ctrlSubasta = new ControladorSubasta();

    /**
     * Método principal de la aplicación.
     * <p>
     * Al iniciar, verifica si existe un moderador registrado; si no, solicita
     * su registro. Luego despliega el menú principal en un ciclo hasta que
     * el usuario seleccione la opción de salida.
     * </p>
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        if (!ctrlUsuario.existeModerador()) {
            JOptionPane.showMessageDialog(null,
                    "No hay moderador registrado. Debe registrar uno primero.");
            registrarModerador();
        }

        String opcion = "";
        while (!opcion.equals("0")) {

            opcion = JOptionPane.showInputDialog(
                    " PLATAFORMA DE SUBASTAS \n\n"
                            + "1. Registro de usuarios\n"
                            + "2. Listado de usuarios\n"
                            + "3. Creación de subastas\n"
                            + "4. Listado de subastas\n"
                            + "5. Creación de ofertas\n"
                            + "6. Listado de ofertas\n"
                            + "0. Salir\n\n"
                            + "Seleccione una opción:"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1": menuRegistroUsuarios(); break;
                case "2": mostrar(ctrlUsuario.listarUsuarios()); break;
                case "3": menuCrearSubasta(); break;
                case "4": mostrar(ctrlSubasta.listarSubastas()); break;
                case "5": menuCrearOferta(); break;
                case "6": mostrar(ctrlSubasta.listarOfertas()); break;
                case "0": mostrar("Hasta luego"); break;
                default:  mostrar("Opción no válida. Intente de nuevo");
            }
        }
    }

    /**
     * Solicita los datos necesarios para registrar al moderador del sistema.
     * Repite la solicitud hasta que el registro sea exitoso.
     */
    private static void registrarModerador() {
        boolean listo = false;
        while (!listo) {
            String nombre  = JOptionPane.showInputDialog("Nombre completo del moderador:");
            String id      = JOptionPane.showInputDialog("Número de cedula:");
            String correo  = JOptionPane.showInputDialog("Correo electrónico:");
            String contra  = JOptionPane.showInputDialog("Contraseña:");
            String anioStr = JOptionPane.showInputDialog("Año de nacimiento (ej: 1985):");

            int anioNac = Integer.parseInt(anioStr);
            String resultado = ctrlUsuario.registrarModerador(nombre, id, anioNac, contra, correo);
            mostrar(resultado);

            if (!resultado.startsWith("ERROR")) {
                listo = true;
            }
        }
    }

    /**
     * Despliega el submenú de registro de usuarios y redirige a la opción seleccionada.
     */
    private static void menuRegistroUsuarios() {
        String opcion = JOptionPane.showInputDialog(
                " REGISTRO DE USUARIOS \n\n"
                        + "1. Registrar Vendedor\n"
                        + "2. Registrar Coleccionista\n"
                        + "0. Volver\n\n"
                        + "Seleccione:"
        );

        if (opcion == null) return;

        switch (opcion) {
            case "1": registrarVendedor(); break;
            case "2": registrarColeccionista(); break;
            case "0": break;
            default:  mostrar("Opción no válida");
        }
    }

    /**
     * Solicita los datos necesarios para registrar un vendedor en el sistema.
     */
    private static void registrarVendedor() {
        String nombre  = JOptionPane.showInputDialog("Nombre completo:");
        String id      = JOptionPane.showInputDialog("Número de identificación:");
        String correo  = JOptionPane.showInputDialog("Correo electrónico:");
        String contra  = JOptionPane.showInputDialog("Contraseña:");
        String dir     = JOptionPane.showInputDialog("Dirección:");
        String anioStr = JOptionPane.showInputDialog("Año de nacimiento (ej: 1995):");

        int anioNac = Integer.parseInt(anioStr);
        String resultado = ctrlUsuario.registrarVendedor(nombre, id, anioNac, contra, correo, dir);
        mostrar(resultado);
    }

    /**
     * Solicita los datos necesarios para registrar un coleccionista en el sistema.
     */
    private static void registrarColeccionista() {
        String nombre  = JOptionPane.showInputDialog("Nombre completo:");
        String id      = JOptionPane.showInputDialog("Número de identificación:");
        String correo  = JOptionPane.showInputDialog("Correo electrónico:");
        String contra  = JOptionPane.showInputDialog("Contraseña:");
        String dir     = JOptionPane.showInputDialog("Dirección:");
        String anioStr = JOptionPane.showInputDialog("Año de nacimiento (ej: 1998):");

        int anioNac = Integer.parseInt(anioStr);
        String resultado = ctrlUsuario.registrarColeccionista(nombre, id, anioNac, contra, correo, dir);
        mostrar(resultado);
    }

    /**
     * Solicita los datos para crear una nueva subasta.
     * <p>
     * Los objetos de subasta son creados por el controlador (no por la interfaz),
     * respetando la separación entre capas de la arquitectura.
     * </p>
     */
    private static void menuCrearSubasta() {
        String idCreador = JOptionPane.showInputDialog("Su ID de usuario (creador):");
        if (idCreador == null) return;

        Usuario creador = ctrlUsuario.buscarPorId(idCreador);
        if (creador == null) {
            mostrar("ERROR: No existe un usuario con ese ID.");
            return;
        }

        String fechaVenc = JOptionPane.showInputDialog("Fecha de vencimiento (ej: 30/06/2026):");
        String precioStr = JOptionPane.showInputDialog("Precio mínimo ($):");
        double precioMinimo = Double.parseDouble(precioStr);

        // Los objetos son creados por el CONTROLADOR, no por la interfaz (arquitectura por capas)
        ArrayList<ObjetoSubasta> objetos = new ArrayList<>();
        String agregarMas = "s";

        while (agregarMas != null && agregarMas.equalsIgnoreCase("s")) {
            String nombreObj = JOptionPane.showInputDialog("Nombre del objeto:");
            String descObj   = JOptionPane.showInputDialog("Descripción:");
            String anioStr   = JOptionPane.showInputDialog("Año de compra (ej: 2015):");

            String estadoOpc = JOptionPane.showInputDialog(
                    "Estado del objeto:\n"
                            + "1. Nuevo\n"
                            + "2. Usado\n"
                            + "3. Antiguo sin abrir\n\nSeleccione:"
            );

            String estado;
            switch (estadoOpc != null ? estadoOpc : "") {
                case "1": estado = "Nuevo"; break;
                case "2": estado = "Usado"; break;
                case "3": estado = "Antiguo sin abrir"; break;
                default:  estado = "Desconocido"; break;
            }

            int anioCompra = Integer.parseInt(anioStr);

            // La creación del objeto de negocio se delega al controlador
            ObjetoSubasta obj = ctrlSubasta.crearObjeto(nombreObj, descObj, estado, anioCompra);
            objetos.add(obj);

            agregarMas = JOptionPane.showInputDialog("¿Agregar otro objeto? (s/n)");
        }

        String resultado = ctrlSubasta.crearSubasta(creador, objetos, precioMinimo, fechaVenc);
        mostrar(resultado);
    }

    /**
     * Solicita los datos para registrar una oferta en una subasta existente.
     */
    private static void menuCrearOferta() {
        mostrar("Subastas disponibles:\n\n" + ctrlSubasta.listarSubastas());

        String idSubastaStr = JOptionPane.showInputDialog("ID de la subasta en la que desea ofertar:");
        if (idSubastaStr == null) return;

        String idOferente = JOptionPane.showInputDialog("Su ID de usuario:");
        if (idOferente == null) return;

        Usuario oferente = ctrlUsuario.buscarPorId(idOferente);
        if (oferente == null) {
            mostrar("ERROR: No existe un usuario con ese ID");
            return;
        }

        String montoStr = JOptionPane.showInputDialog("Monto a ofertar ($):");
        double monto = Double.parseDouble(montoStr);

        int idSubasta = Integer.parseInt(idSubastaStr);
        String resultado = ctrlSubasta.registrarOferta(idSubasta, oferente, monto);
        mostrar(resultado);
    }

    /**
     * Muestra un mensaje al usuario mediante un cuadro de diálogo.
     *
     * @param mensaje Texto a mostrar en el cuadro de diálogo.
     */
    private static void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
