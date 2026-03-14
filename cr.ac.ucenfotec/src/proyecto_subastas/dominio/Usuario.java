package proyecto_subastas.dominio;

/**
 * Clase abstracta que representa un usuario genérico dentro de la plataforma de subastas.
 * <p>
 * Todo usuario posee datos básicos de identificación y acceso.
 * Las subclases concretas ({@link Moderador}, {@link Vendedor}, {@link Coleccionista})
 * amplían esta clase con atributos y comportamientos específicos según su rol.
 * </p>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 */
public abstract class Usuario {

    /** Nombre completo del usuario. */
    private String nombreCompleto;

    /** Número de identificación único del usuario. */
    private String identificacion;

    /** Año de nacimiento del usuario para calcular la edad. */
    private int anioNacimiento;

    /** Contraseña de acceso a la plataforma. */
    private String contrasena;

    /** Correo electrónico del usuario. */
    private String correoElectronico;

    /**
     * Constructor por defecto.
     * Crea una instancia de Usuario sin inicializar atributos.
     */
    public Usuario() {
    }

    /**
     * Constructor completo que inicializa todos los atributos del usuario.
     *
     * @param nombreCompleto    Nombre completo del usuario.
     * @param identificacion    Número de identificación del usuario.
     * @param anioNacimiento    Año de nacimiento del usuario.
     * @param contrasena        Contraseña de acceso.
     * @param correoElectronico Correo electrónico del usuario.
     */
    public Usuario(String nombreCompleto, String identificacion,
                   int anioNacimiento, String contrasena, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.anioNacimiento = anioNacimiento;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Calcula la edad aproximada del usuario en años.
     * El cálculo se realiza restando el año de nacimiento al año actual (2026).
     *
     * @return Edad aproximada del usuario en años.
     */
    public int calcularEdad() {
        return 2026 - anioNacimiento;
    }

    /**
     * Obtiene el nombre completo del usuario.
     *
     * @return Nombre completo del usuario.
     */
    public String getNombreCompleto() { return nombreCompleto; }

    /**
     * Establece el nombre completo del usuario.
     *
     * @param nombreCompleto Nuevo nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    /**
     * Obtiene el número de identificación del usuario.
     *
     * @return Identificación del usuario.
     */
    public String getIdentificacion() { return identificacion; }

    /**
     * Establece el número de identificación del usuario.
     *
     * @param identificacion Nueva identificación.
     */
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    /**
     * Obtiene el año de nacimiento del usuario.
     *
     * @return Año de nacimiento.
     */
    public int getAnioNacimiento() { return anioNacimiento; }

    /**
     * Establece el año de nacimiento del usuario.
     *
     * @param anioNacimiento Nuevo año de nacimiento.
     */
    public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasena() { return contrasena; }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena Nueva contraseña.
     */
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return Correo electrónico.
     */
    public String getCorreoElectronico() { return correoElectronico; }

    /**
     * Establece el correo electrónico del usuario.
     *
     * @param correoElectronico Nuevo correo electrónico.
     */
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    /**
     * Retorna una representación textual del usuario con sus datos principales.
     *
     * @return Cadena con nombre, identificación, edad calculada y correo electrónico.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombreCompleto
                + " | ID: " + identificacion
                + " | Edad: " + calcularEdad()
                + " | Correo: " + correoElectronico;
    }
}
