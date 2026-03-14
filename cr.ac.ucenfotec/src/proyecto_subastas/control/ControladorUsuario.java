package proyecto_subastas.control;

import proyecto_subastas.dominio.Coleccionista;
import proyecto_subastas.dominio.Moderador;
import proyecto_subastas.dominio.Usuario;
import proyecto_subastas.dominio.Vendedor;
import java.util.ArrayList;

/**
 * Controlador encargado de gestionar todos los usuarios de la plataforma.
 * <p>
 * Esta clase forma parte de la capa de control (lógica de negocio) y actúa
 * como intermediario entre la interfaz gráfica y los objetos del dominio.
 * Implementa todas las reglas de negocio relacionadas con el registro y
 * consulta de usuarios.
 * </p>
 *
 * <p>Reglas de negocio que aplica:</p>
 * <ul>
 *   <li>Solo puede existir un único moderador en el sistema.</li>
 *   <li>El moderador debe ser mayor de edad (18+ años).</li>
 *   <li>Los vendedores y coleccionistas deben ser mayores de edad.</li>
 *   <li>No se permiten dos usuarios con el mismo número de identificación.</li>
 * </ul>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see Usuario
 * @see Moderador
 * @see Vendedor
 * @see Coleccionista
 */
public class ControladorUsuario {

    /** Lista en memoria de todos los usuarios registrados en el sistema. */
    private ArrayList<Usuario> usuarios;

    /** Referencia al único moderador del sistema (null si no existe). */
    private Moderador moderador;

    /**
     * Constructor por defecto.
     * Inicializa la lista de usuarios vacía y sin moderador registrado.
     */
    public ControladorUsuario() {
        this.usuarios = new ArrayList<>();
        this.moderador = null;
    }

    /**
     * Verifica si ya existe un moderador registrado en el sistema.
     *
     * @return {@code true} si hay un moderador registrado; {@code false} en caso contrario.
     */
    public boolean existeModerador() {
        return moderador != null;
    }

    /**
     * Registra un nuevo moderador en el sistema.
     * <p>
     * Solo se permite un moderador por sistema. El moderador debe tener
     * al menos 18 años de edad.
     * </p>
     *
     * @param nombre    Nombre completo del moderador.
     * @param id        Número de identificación del moderador.
     * @param anioNac   Año de nacimiento del moderador.
     * @param contrasena Contraseña de acceso a la plataforma.
     * @param correo    Correo electrónico del moderador.
     * @return Mensaje de éxito o un mensaje de error con prefijo "ERROR:".
     */
    public String registrarModerador(String nombre, String id, int anioNac,
                                     String contrasena, String correo) {
        if (existeModerador()) {
            return "ERROR: Ya existe un moderador en el sistema.";
        }
        if ((2026 - anioNac) < 18) {
            return "ERROR: El moderador debe ser mayor de edad.";
        }
        moderador = new Moderador(nombre, id, anioNac, contrasena, correo);
        usuarios.add(moderador);
        return "Moderador registrado correctamente.";
    }

    /**
     * Registra un nuevo vendedor en el sistema.
     * <p>
     * El vendedor debe ser mayor de edad y no puede compartir identificación
     * con un usuario ya registrado.
     * </p>
     *
     * @param nombre    Nombre completo del vendedor.
     * @param id        Número de identificación del vendedor.
     * @param anioNac   Año de nacimiento del vendedor.
     * @param contrasena Contraseña de acceso a la plataforma.
     * @param correo    Correo electrónico del vendedor.
     * @param direccion Dirección de domicilio del vendedor.
     * @return Mensaje de éxito o un mensaje de error con prefijo "ERROR:".
     */
    public String registrarVendedor(String nombre, String id, int anioNac,
                                    String contrasena, String correo, String direccion) {
        if ((2026 - anioNac) < 18) {
            return "ERROR: Debe ser mayor de edad para registrarse.";
        }
        if (buscarPorId(id) != null) {
            return "ERROR: Ya existe un usuario con ese ID.";
        }
        Vendedor v = new Vendedor(nombre, id, anioNac, contrasena, correo, 0, direccion);
        usuarios.add(v);
        return "Vendedor registrado correctamente.";
    }

    /**
     * Registra un nuevo coleccionista en el sistema.
     * <p>
     * El coleccionista debe ser mayor de edad y no puede compartir identificación
     * con un usuario ya registrado.
     * </p>
     *
     * @param nombre    Nombre completo del coleccionista.
     * @param id        Número de identificación del coleccionista.
     * @param anioNac   Año de nacimiento del coleccionista.
     * @param contrasena Contraseña de acceso a la plataforma.
     * @param correo    Correo electrónico del coleccionista.
     * @param direccion Dirección de domicilio del coleccionista.
     * @return Mensaje de éxito o un mensaje de error con prefijo "ERROR:".
     */
    public String registrarColeccionista(String nombre, String id, int anioNac,
                                         String contrasena, String correo, String direccion) {
        if ((2026 - anioNac) < 18) {
            return "ERROR: Debe ser mayor de edad para registrarse.";
        }
        if (buscarPorId(id) != null) {
            return "ERROR: Ya existe un usuario con ese ID.";
        }
        Coleccionista c = new Coleccionista(nombre, id, anioNac, contrasena, correo, 0, direccion);
        usuarios.add(c);
        return "Coleccionista registrado correctamente.";
    }

    /**
     * Busca un usuario en el sistema por su número de identificación.
     *
     * @param id Número de identificación a buscar.
     * @return El {@link Usuario} con esa identificación, o {@code null} si no existe.
     */
    public Usuario buscarPorId(String id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdentificacion().equals(id)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    /**
     * Genera un listado textual de todos los usuarios registrados en el sistema.
     *
     * @return Cadena con la lista numerada de usuarios, o un mensaje indicando
     *         que no hay usuarios registrados.
     */
    public String listarUsuarios() {
        if (usuarios.isEmpty()) {
            return "No hay usuarios registrados.";
        }
        String lista = "";
        for (int i = 0; i < usuarios.size(); i++) {
            lista += (i + 1) + ". " + usuarios.get(i).toString() + "\n";
        }
        return lista;
    }
}
