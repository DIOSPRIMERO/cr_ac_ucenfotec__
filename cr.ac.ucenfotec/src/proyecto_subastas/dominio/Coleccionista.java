package proyecto_subastas.dominio;

import java.util.ArrayList;

/**
 * Clase que representa a un coleccionista registrado en la plataforma de subastas.
 * <p>
 * El coleccionista es el único tipo de usuario que puede realizar ofertas en subastas.
 * También puede crear subastas, pero únicamente con objetos que estén registrados
 * en su colección personal. No puede ofertar en subastas que él mismo haya creado.
 * </p>
 *
 * <p>Además de los atributos heredados de {@link Usuario}, el coleccionista posee:</p>
 * <ul>
 *   <li>Una puntuación de reputación (inicia en 0).</li>
 *   <li>Una dirección de domicilio.</li>
 *   <li>Una lista de intereses o categorías de su preferencia.</li>
 *   <li>Una colección personal de objetos ({@link ObjetoSubasta}).</li>
 * </ul>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see Usuario
 * @see ObjetoSubasta
 */
public class Coleccionista extends Usuario {

    /** Puntuación de reputación del coleccionista dentro de la plataforma. */
    private double puntuacion;

    /** Dirección de domicilio del coleccionista. */
    private String direccion;

    /** Lista de categorías o temas de interés del coleccionista. */
    private ArrayList<String> intereses;

    /** Colección de objetos que pertenecen al coleccionista. */
    private ArrayList<ObjetoSubasta> coleccion;

    /**
     * Constructor por defecto.
     * Crea una instancia de Coleccionista con puntuación en 0
     * y listas de intereses y colección vacías.
     */
    public Coleccionista() {
        this.puntuacion = 0;
        this.intereses = new ArrayList<>();
        this.coleccion = new ArrayList<>();
    }

    /**
     * Constructor completo que inicializa todos los atributos del coleccionista.
     * Las listas de intereses y colección se inicializan vacías.
     *
     * @param nombreCompleto    Nombre completo del coleccionista.
     * @param identificacion    Número de identificación del coleccionista.
     * @param anioNacimiento    Año de nacimiento del coleccionista.
     * @param contrasena        Contraseña de acceso a la plataforma.
     * @param correoElectronico Correo electrónico del coleccionista.
     * @param puntuacion        Puntuación de reputación inicial.
     * @param direccion         Dirección de domicilio del coleccionista.
     */
    public Coleccionista(String nombreCompleto, String identificacion,
                         int anioNacimiento, String contrasena, String correoElectronico,
                         double puntuacion, String direccion) {
        super(nombreCompleto, identificacion, anioNacimiento, contrasena, correoElectronico);
        this.puntuacion = puntuacion;
        this.direccion = direccion;
        this.intereses = new ArrayList<>();
        this.coleccion = new ArrayList<>();
    }

    /**
     * Obtiene la puntuación de reputación del coleccionista.
     *
     * @return Puntuación del coleccionista.
     */
    public double getPuntuacion() { return puntuacion; }

    /**
     * Establece la puntuación de reputación del coleccionista.
     *
     * @param puntuacion Nueva puntuación.
     */
    public void setPuntuacion(double puntuacion) { this.puntuacion = puntuacion; }

    /**
     * Obtiene la dirección de domicilio del coleccionista.
     *
     * @return Dirección del coleccionista.
     */
    public String getDireccion() { return direccion; }

    /**
     * Establece la dirección de domicilio del coleccionista.
     *
     * @param direccion Nueva dirección.
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Obtiene la lista de intereses o categorías del coleccionista.
     *
     * @return Lista de intereses.
     */
    public ArrayList<String> getIntereses() { return intereses; }

    /**
     * Establece la lista de intereses del coleccionista.
     *
     * @param intereses Nueva lista de intereses.
     */
    public void setIntereses(ArrayList<String> intereses) { this.intereses = intereses; }

    /**
     * Obtiene la colección personal de objetos del coleccionista.
     *
     * @return Lista de objetos que componen la colección.
     */
    public ArrayList<ObjetoSubasta> getColeccion() { return coleccion; }

    /**
     * Establece la colección personal de objetos del coleccionista.
     *
     * @param coleccion Nueva lista de objetos de la colección.
     */
    public void setColeccion(ArrayList<ObjetoSubasta> coleccion) { this.coleccion = coleccion; }

    /**
     * Agrega un objeto a la colección personal del coleccionista.
     *
     * @param objeto Objeto a agregar a la colección.
     */
    public void agregarAColeccion(ObjetoSubasta objeto) {
        this.coleccion.add(objeto);
    }

    /**
     * Retorna una representación textual del coleccionista con sus datos completos.
     *
     * @return Cadena con el prefijo [COLECCIONISTA], datos del usuario, puntuación y dirección.
     */
    @Override
    public String toString() {
        return "[COLECCIONISTA] " + super.toString()
                + " | Puntuación: " + puntuacion
                + " | Dirección: " + direccion;
    }
}
