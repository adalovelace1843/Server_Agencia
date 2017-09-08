
package servidorimm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para voTicketCompleto complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="voTicketCompleto">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidorimm/}voTicketBasico">
 *       &lt;sequence>
 *         &lt;element name="agencia_venta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cant_min" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="f_h_inicio" type="{http://servidorimm/}date" minOccurs="0"/>
 *         &lt;element name="f_h_venta" type="{http://servidorimm/}date" minOccurs="0"/>
 *         &lt;element name="matricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "voTicketCompleto", propOrder = {
    "agenciaVenta",
    "cantMin",
    "fhInicio",
    "fhVenta",
    "matricula"
})
public class VoTicketCompleto
    extends VoTicketBasico
{

    @XmlElement(name = "agencia_venta")
    protected String agenciaVenta;
    @XmlElement(name = "cant_min")
    protected int cantMin;
    @XmlElement(name = "f_h_inicio")
    protected Date fhInicio;
    @XmlElement(name = "f_h_venta")
    protected Date fhVenta;
    protected String matricula;

    /**
     * Obtiene el valor de la propiedad agenciaVenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgenciaVenta() {
        return agenciaVenta;
    }

    /**
     * Define el valor de la propiedad agenciaVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgenciaVenta(String value) {
        this.agenciaVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad cantMin.
     * 
     */
    public int getCantMin() {
        return cantMin;
    }

    /**
     * Define el valor de la propiedad cantMin.
     * 
     */
    public void setCantMin(int value) {
        this.cantMin = value;
    }

    /**
     * Obtiene el valor de la propiedad fhInicio.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getFHInicio() {
        return fhInicio;
    }

    /**
     * Define el valor de la propiedad fhInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setFHInicio(Date value) {
        this.fhInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad fhVenta.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getFHVenta() {
        return fhVenta;
    }

    /**
     * Define el valor de la propiedad fhVenta.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setFHVenta(Date value) {
        this.fhVenta = value;
    }

    /**
     * Obtiene el valor de la propiedad matricula.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define el valor de la propiedad matricula.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricula(String value) {
        this.matricula = value;
    }

}
