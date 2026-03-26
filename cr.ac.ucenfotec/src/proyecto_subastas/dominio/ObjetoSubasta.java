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
 * @version 2.0
 */
public class ObjetoSubasta {

    /** Nombre descriptivo del objeto. */
    private String nombre;

    /** Descripción detallada del objeto. */
    private String descripcion;

    /** Estado de conservación del objeto. */
    private String estado;

    /** Año en el que fue comprado el objeto. */
    private int anioCompra;

    /** Constructor por defecto. */
    public ObjetoSubasta() {}

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
     *
     * @return Antigüedad del objeto en años.
     */
    public int calcularAntiguedad() {
        return 2026 - anioCompra;
    }

    // ── Getters / Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public int getAnioCompra() { return anioCompra; }
    public void setAnioCompra(int anioCompra) { this.anioCompra = anioCompra; }

    // ── equals

    /**
     * Dos objetos son iguales si tienen el mismo nombre y año de compra.
     *
     * @param obj Objeto a comparar.
     * @return {@code true} si nombre y año de compra coinciden.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof ObjetoSubasta)) return false;
        ObjetoSubasta otro = (ObjetoSubasta) obj;
        return this.anioCompra == otro.anioCompra
                && this.nombre != null && this.nombre.equals(otro.nombre);
    }

    //  toString

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
