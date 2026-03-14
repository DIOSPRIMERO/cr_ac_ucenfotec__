package proyecto_subastas.dominio;

/**
 * Clase que representa al moderador de la plataforma de subastas.
 * <p>
 * El moderador es el administrador del sistema. Solo puede existir <b>un único moderador</b>
 * registrado. Por las reglas de negocio, el moderador no puede crear subastas
 * ni realizar ofertas en la plataforma.
 * </p>
 *
 * <ul>
 *   <li>Hereda todos los atributos de {@link Usuario}.</li>
 *   <li>Debe ser mayor de edad para registrarse.</li>
 *   <li>Es el primer usuario que se registra al iniciar el sistema.</li>
 * </ul>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see Usuario
 */
public class Moderador extends Usuario {

    /**
     * Constructor por defecto.
     * Crea una instancia de Moderador sin inicializar atributos.
     */
    public Moderador() {
    }

    /**
     * Constructor completo que inicializa todos los atributos del moderador.
     *
     * @param nombreCompleto    Nombre completo del moderador.
     * @param identificacion    Número de identificación del moderador.
     * @param anioNacimiento    Año de nacimiento del moderador.
     * @param contrasena        Contraseña de acceso a la plataforma.
     * @param correoElectronico Correo electrónico del moderador.
     */
    public Moderador(String nombreCompleto, String identificacion,
                     int anioNacimiento, String contrasena, String correoElectronico) {
        super(nombreCompleto, identificacion, anioNacimiento, contrasena, correoElectronico);
    }

    /**
     * Retorna una representación textual del moderador.
     *
     * @return Cadena con el prefijo [MODERADOR] seguido de los datos del usuario.
     */
    @Override
    public String toString() {
        return "[MODERADOR] " + super.toString();
    }
}
