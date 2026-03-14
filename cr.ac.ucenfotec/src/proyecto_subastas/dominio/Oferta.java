package proyecto_subastas.dominio;

/**
 * Clase que representa una oferta económica presentada por un coleccionista en una subasta.
 * <p>
 * Una oferta registra el nombre del oferente, su puntuación de reputación
 * y el precio propuesto para adjudicarse los objetos de la subasta.
 * Solo los coleccionistas pueden realizar ofertas; los vendedores y el moderador
 * no tienen permitido ofertar.
 * </p>
 *
 * @author Steven Mendez Jimenez
 * @version 1.0
 * @see Subasta
 * @see Coleccionista
 */
public class Oferta {

    /** Nombre completo del coleccionista que realiza la oferta. */
    private String nombreOferente;

    /** Puntuación de reputación del oferente en el momento de la oferta. */
    private double puntuacionOferente;

    /** Precio económico ofertado por los objetos de la subasta. */
    private double precioOfertado;

    /**
     * Constructor por defecto.
     * Crea una instancia de Oferta sin inicializar atributos.
     */
    public Oferta() {
    }

    /**
     * Constructor completo que inicializa todos los atributos de la oferta.
     *
     * @param nombreOferente      Nombre del coleccionista que oferta.
     * @param puntuacionOferente  Puntuación de reputación del oferente.
     * @param precioOfertado      Monto económico de la oferta.
     */
    public Oferta(String nombreOferente, double puntuacionOferente, double precioOfertado) {
        this.nombreOferente = nombreOferente;
        this.puntuacionOferente = puntuacionOferente;
        this.precioOfertado = precioOfertado;
    }

    /**
     * Obtiene el nombre del coleccionista que realizó la oferta.
     *
     * @return Nombre del oferente.
     */
    public String getNombreOferente() { return nombreOferente; }

    /**
     * Establece el nombre del oferente.
     *
     * @param nombreOferente Nuevo nombre del oferente.
     */
    public void setNombreOferente(String nombreOferente) { this.nombreOferente = nombreOferente; }

    /**
     * Obtiene la puntuación de reputación del oferente.
     *
     * @return Puntuación del oferente.
     */
    public double getPuntuacionOferente() { return puntuacionOferente; }

    /**
     * Establece la puntuación de reputación del oferente.
     *
     * @param puntuacionOferente Nueva puntuación del oferente.
     */
    public void setPuntuacionOferente(double puntuacionOferente) { this.puntuacionOferente = puntuacionOferente; }

    /**
     * Obtiene el precio ofertado.
     *
     * @return Monto económico de la oferta.
     */
    public double getPrecioOfertado() { return precioOfertado; }

    /**
     * Establece el precio ofertado.
     *
     * @param precioOfertado Nuevo monto de la oferta.
     */
    public void setPrecioOfertado(double precioOfertado) { this.precioOfertado = precioOfertado; }

    /**
     * Retorna una representación textual de la oferta con sus datos principales.
     *
     * @return Cadena con nombre del oferente, puntuación y monto ofertado.
     */
    @Override
    public String toString() {
        return "Oferente: " + nombreOferente
                + " | Puntuación: " + puntuacionOferente
                + " | Monto: $" + precioOfertado;
    }
}
