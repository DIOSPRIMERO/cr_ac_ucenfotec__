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
 * @version 2.0
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

    /** Constructor por defecto. */
    public Usuario() {}

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
     *
     * @return Edad aproximada del usuario en años.
     */
    public int calcularEdad() {
        return 2026 - anioNacimiento;
    }

    // ── Getters / Setters

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public int getAnioNacimiento() { return anioNacimiento; }
    public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    // ── equals

    /**
     * Dos usuarios son iguales si comparten el mismo número de identificación.
     *
     * @param obj Objeto a comparar.
     * @return {@code true} si la identificación coincide; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Usuario)) return false;
        Usuario otro = (Usuario) obj;
        return this.identificacion != null && this.identificacion.equals(otro.identificacion);
    }

    // ── toString

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
