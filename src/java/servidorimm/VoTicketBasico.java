
package servidorimm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para voTicketBasico complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="voTicketBasico">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="importe_total" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="nro_ticket" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voTicketBasico", propOrder = {
    "importeTotal",
    "nroTicket"
})
@XmlSeeAlso({
    VoTicketCompleto.class
})
public class VoTicketBasico {

    @XmlElement(name = "importe_total")
    protected float importeTotal;
    @XmlElement(name = "nro_ticket")
    protected int nroTicket;

    /**
     * Obtiene el valor de la propiedad importeTotal.
     * 
     */
    public float getImporteTotal() {
        return importeTotal;
    }

    /**
     * Define el valor de la propiedad importeTotal.
     * 
     */
    public void setImporteTotal(float value) {
        this.importeTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad nroTicket.
     * 
     */
    public int getNroTicket() {
        return nroTicket;
    }

    /**
     * Define el valor de la propiedad nroTicket.
     * 
     */
    public void setNroTicket(int value) {
        this.nroTicket = value;
    }

}
