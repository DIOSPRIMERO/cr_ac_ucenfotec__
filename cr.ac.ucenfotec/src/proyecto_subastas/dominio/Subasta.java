package proyecto_subastas.dominio;

import java.util.ArrayList;

/**
 * Clase que representa una subasta publicada en la plataforma.
 * <p>
 * Una subasta agrupa uno o más objetos ({@link ObjetoSubasta}) ofrecidos por
 * un usuario creador ({@link Usuario}), con un precio mínimo de aceptación y
 * una fecha de vencimiento.
 * </p>
 *
 * @author Steven Mendez Jimenez
 * @version 2.0
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

    // ── Getters / Setters

    public int getId() { return id; }

    public Usuario getCreador() { return creador; }
    public void setCreador(Usuario creador) { this.creador = creador; }

    public ArrayList<ObjetoSubasta> getObjetos() { return objetos; }
    public void setObjetos(ArrayList<ObjetoSubasta> objetos) { this.objetos = objetos; }

    public ArrayList<Oferta> getOfertas() { return ofertas; }
    public void setOfertas(ArrayList<Oferta> ofertas) { this.ofertas = ofertas; }

    public double getPrecioMinimo() { return precioMinimo; }
    public void setPrecioMinimo(double precioMinimo) { this.precioMinimo = precioMinimo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    // ── equals

    /**
     * Dos subastas son iguales si tienen el mismo ID.
     *
     * @param obj Objeto a comparar.
     * @return {@code true} si el ID coincide.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Subasta)) return false;
        Subasta otra = (Subasta) obj;
        return this.id == otra.id;
    }

    // ── toString ──────────────────────────────────────────────────────────────

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

