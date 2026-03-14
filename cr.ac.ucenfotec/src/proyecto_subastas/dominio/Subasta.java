package proyecto_subastas.dominio;

import java.util.ArrayList;

/**
 * Clase que representa una subasta publicada en la plataforma.
 * <p>
 * Una subasta agrupa uno o más objetos ({@link ObjetoSubasta}) ofrecidos por
 * un usuario creador ({@link Usuario}), con un precio mínimo de aceptación y
 * una fecha de vencimiento. Durante su vigencia, los coleccionistas pueden
 * registrar ofertas ({@link Oferta}).
 * </p>
 *
 * <p>Estados posibles de la subasta:</p>
 * <ul>
 *   <li><b>Activa</b>: La subasta está abierta para recibir ofertas.</li>
 *   <li><b>Vencida</b>: La subasta ha concluido y ya no acepta ofertas.</li>
 * </ul>
 *
 * <p>El identificador de cada subasta es generado automáticamente por un contador
 * estático, garantizando unicidad durante la ejecución del programa.</p>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see ObjetoSubasta
 * @see Oferta
 * @see Usuario
 */
public class Subasta {

    /** Contador estático para asignar identificadores únicos a cada subasta. */
    private static int contadorId = 1;

    /** Identificador único de la subasta. */
    private int id;

    /** Usuario (vendedor o coleccionista) que creó la subasta. */
    private Usuario creador;

    /** Lista de objetos incluidos en la subasta. */
    private ArrayList<ObjetoSubasta> objetos;

    /** Lista de ofertas registradas en la subasta. */
    private ArrayList<Oferta> ofertas;

    /** Precio mínimo que debe superar cualquier oferta para ser válida. */
    private double precioMinimo;

    /** Estado actual de la subasta: "Activa" o "Vencida". */
    private String estado;

    /** Fecha de vencimiento de la subasta en formato dd/mm/aaaa. */
    private String fechaVencimiento;

    /**
     * Constructor por defecto.
     * Crea una subasta con ID autoincremental, listas vacías y estado "Activa".
     */
    public Subasta() {
        this.id = contadorId++;
        this.objetos = new ArrayList<>();
        this.ofertas = new ArrayList<>();
        this.estado = "Activa";
    }

    /**
     * Constructor completo que inicializa todos los atributos de la subasta.
     * El ID se asigna automáticamente y el estado inicial siempre es "Activa".
     *
     * @param creador          Usuario que crea la subasta (vendedor o coleccionista).
     * @param objetos          Lista de objetos ofrecidos en la subasta.
     * @param precioMinimo     Precio mínimo de aceptación de ofertas.
     * @param fechaVencimiento Fecha de vencimiento en formato dd/mm/aaaa.
     */
    public Subasta(Usuario creador, ArrayList<ObjetoSubasta> objetos,
                   double precioMinimo, String fechaVencimiento) {
        this.id = contadorId++;
        this.creador = creador;
        this.objetos = objetos;
        this.ofertas = new ArrayList<>();
        this.precioMinimo = precioMinimo;
        this.estado = "Activa";
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Obtiene el identificador único de la subasta.
     *
     * @return ID de la subasta.
     */
    public int getId() { return id; }

    /**
     * Obtiene el usuario creador de la subasta.
     *
     * @return Usuario que creó la subasta.
     */
    public Usuario getCreador() { return creador; }

    /**
     * Establece el usuario creador de la subasta.
     *
     * @param creador Nuevo usuario creador.
     */
    public void setCreador(Usuario creador) { this.creador = creador; }

    /**
     * Obtiene la lista de objetos incluidos en la subasta.
     *
     * @return Lista de objetos subastados.
     */
    public ArrayList<ObjetoSubasta> getObjetos() { return objetos; }

    /**
     * Establece la lista de objetos de la subasta.
     *
     * @param objetos Nueva lista de objetos.
     */
    public void setObjetos(ArrayList<ObjetoSubasta> objetos) { this.objetos = objetos; }

    /**
     * Obtiene la lista de ofertas registradas en la subasta.
     *
     * @return Lista de ofertas.
     */
    public ArrayList<Oferta> getOfertas() { return ofertas; }

    /**
     * Establece la lista de ofertas de la subasta.
     *
     * @param ofertas Nueva lista de ofertas.
     */
    public void setOfertas(ArrayList<Oferta> ofertas) { this.ofertas = ofertas; }

    /**
     * Obtiene el precio mínimo de aceptación de la subasta.
     *
     * @return Precio mínimo en dólares.
     */
    public double getPrecioMinimo() { return precioMinimo; }

    /**
     * Establece el precio mínimo de aceptación de la subasta.
     *
     * @param precioMinimo Nuevo precio mínimo.
     */
    public void setPrecioMinimo(double precioMinimo) { this.precioMinimo = precioMinimo; }

    /**
     * Obtiene el estado actual de la subasta.
     *
     * @return Estado de la subasta ("Activa" o "Vencida").
     */
    public String getEstado() { return estado; }

    /**
     * Establece el estado de la subasta.
     *
     * @param estado Nuevo estado ("Activa" o "Vencida").
     */
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Obtiene la fecha de vencimiento de la subasta.
     *
     * @return Fecha de vencimiento en formato dd/mm/aaaa.
     */
    public String getFechaVencimiento() { return fechaVencimiento; }

    /**
     * Establece la fecha de vencimiento de la subasta.
     *
     * @param fechaVencimiento Nueva fecha de vencimiento.
     */
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    /**
     * Retorna una representación textual de la subasta con sus datos principales.
     *
     * @return Cadena con ID, creador, precio mínimo, estado, fecha de vencimiento,
     *         cantidad de objetos y cantidad de ofertas.
     */
    @Override
    public String toString() {
        return "Subasta #" + id
                + " | Creador: " + creador.getNombreCompleto()
                + " | Precio mínimo: $" + precioMinimo
                + " | Estado: " + estado
                + " | Vence: " + fechaVencimiento
                + " | Objetos: " + objetos.size()
                + " | Ofertas: " + ofertas.size();
    }
}
