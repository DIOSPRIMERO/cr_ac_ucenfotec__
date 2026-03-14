package proyecto_subastas.dominio;

/**
 * Clase que representa a un vendedor registrado en la plataforma de subastas.
 * <p>
 * El vendedor puede crear subastas con sus objetos, pero <b>no puede realizar ofertas</b>
 * en ninguna subasta de la plataforma. Para registrarse, el vendedor debe ser
 * mayor de edad.
 * </p>
 *
 * <p>Además de los atributos heredados de {@link Usuario}, el vendedor posee:</p>
 * <ul>
 *   <li>Una puntuación de reputación (inicia en 0).</li>
 *   <li>Una dirección de domicilio.</li>
 * </ul>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see Usuario
 */
public class Vendedor extends Usuario {

    /** Puntuación de reputación del vendedor dentro de la plataforma. */
    private double puntuacion;

    /** Dirección de domicilio del vendedor. */
    private String direccion;

    /**
     * Constructor por defecto.
     * Crea una instancia de Vendedor con puntuación inicial en 0.
     */
    public Vendedor() {
        this.puntuacion = 0;
    }

    /**
     * Constructor completo que inicializa todos los atributos del vendedor.
     *
     * @param nombreCompleto    Nombre completo del vendedor.
     * @param identificacion    Número de identificación del vendedor.
     * @param anioNacimiento    Año de nacimiento del vendedor.
     * @param contrasena        Contraseña de acceso a la plataforma.
     * @param correoElectronico Correo electrónico del vendedor.
     * @param puntuacion        Puntuación de reputación inicial del vendedor.
     * @param direccion         Dirección de domicilio del vendedor.
     */
    public Vendedor(String nombreCompleto, String identificacion,
                    int anioNacimiento, String contrasena, String correoElectronico,
                    double puntuacion, String direccion) {
        super(nombreCompleto, identificacion, anioNacimiento, contrasena, correoElectronico);
        this.puntuacion = puntuacion;
        this.direccion = direccion;
    }

    /**
     * Obtiene la puntuación de reputación del vendedor.
     *
     * @return Puntuación del vendedor.
     */
    public double getPuntuacion() { return puntuacion; }

    /**
     * Establece la puntuación de reputación del vendedor.
     *
     * @param puntuacion Nueva puntuación.
     */
    public void setPuntuacion(double puntuacion) { this.puntuacion = puntuacion; }

    /**
     * Obtiene la dirección de domicilio del vendedor.
     *
     * @return Dirección del vendedor.
     */
    public String getDireccion() { return direccion; }

    /**
     * Establece la dirección de domicilio del vendedor.
     *
     * @param direccion Nueva dirección.
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Retorna una representación textual del vendedor con sus datos completos.
     *
     * @return Cadena con el prefijo [VENDEDOR], los datos del usuario, puntuación y dirección.
     */
    @Override
    public String toString() {
        return "[VENDEDOR] " + super.toString()
                + " | Puntuación: " + puntuacion
                + " | Dirección: " + direccion;
    }
}
