package proyecto_subastas.dominio;

/**
 * Clase que representa un objeto ofrecido dentro de una subasta en la plataforma.
 * <p>
 * Cada objeto tiene un nombre, descripción, estado de conservación y año de compra.
 * El sistema calcula automáticamente la antigüedad del objeto a partir del año de compra.
 * </p>
 *
 * <p>Los estados posibles de un objeto son:</p>
 * <ul>
 *   <li><b>Nuevo</b>: Objeto sin uso.</li>
 *   <li><b>Usado</b>: Objeto que ha sido utilizado.</li>
 *   <li><b>Antiguo sin abrir</b>: Objeto antiguo que no ha sido abierto o usado.</li>
 * </ul>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 */
public class ObjetoSubasta {

    /** Nombre descriptivo del objeto. */
    private String nombre;

    /** Descripción detallada del objeto. */
    private String descripcion;

    /** Estado de conservación del objeto: "Nuevo", "Usado" o "Antiguo sin abrir". */
    private String estado;

    /** Año en el que fue comprado el objeto. */
    private int anioCompra;

    /**
     * Constructor por defecto.
     * Crea una instancia de ObjetoSubasta sin inicializar atributos.
     */
    public ObjetoSubasta() {
    }

    /**
     * Constructor completo que inicializa todos los atributos del objeto.
     *
     * @param nombre      Nombre del objeto.
     * @param descripcion Descripción detallada del objeto.
     * @param estado      Estado de conservación ("Nuevo", "Usado", "Antiguo sin abrir").
     * @param anioCompra  Año en que fue adquirido el objeto.
     */
    public ObjetoSubasta(String nombre, String descripcion, String estado, int anioCompra) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.anioCompra = anioCompra;
    }

    /**
     * Calcula la antigüedad aproximada del objeto en años.
     * El cálculo se realiza restando el año de compra al año actual (2026).
     *
     * @return Antigüedad del objeto en años.
     */
    public int calcularAntiguedad() {
        return 2026 - anioCompra;
    }

    /**
     * Obtiene el nombre del objeto.
     *
     * @return Nombre del objeto.
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del objeto.
     *
     * @param nombre Nuevo nombre del objeto.
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Obtiene la descripción del objeto.
     *
     * @return Descripción del objeto.
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripción del objeto.
     *
     * @param descripcion Nueva descripción del objeto.
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Obtiene el estado de conservación del objeto.
     *
     * @return Estado del objeto ("Nuevo", "Usado" o "Antiguo sin abrir").
     */
    public String getEstado() { return estado; }

    /**
     * Establece el estado de conservación del objeto.
     *
     * @param estado Nuevo estado del objeto.
     */
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Obtiene el año de compra del objeto.
     *
     * @return Año de compra del objeto.
     */
    public int getAnioCompra() { return anioCompra; }

    /**
     * Establece el año de compra del objeto.
     *
     * @param anioCompra Nuevo año de compra.
     */
    public void setAnioCompra(int anioCompra) { this.anioCompra = anioCompra; }

    /**
     * Retorna una representación textual del objeto con sus datos principales.
     *
     * @return Cadena con nombre, estado y antigüedad calculada en años.
     */
    @Override
    public String toString() {
        return "Objeto: " + nombre
                + " | Estado: " + estado
                + " | Antigüedad: " + calcularAntiguedad() + " año(s)";
    }
}
