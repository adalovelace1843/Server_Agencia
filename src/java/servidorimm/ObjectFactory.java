
package servidorimm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servidorimm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AltaTicketCompletoResponse_QNAME = new QName("http://servidorimm/", "altaTicketCompletoResponse");
    private final static QName _AltaTicketCompleto_QNAME = new QName("http://servidorimm/", "altaTicketCompleto");
    private final static QName _AnularTicketIMMResponse_QNAME = new QName("http://servidorimm/", "anularTicketIMMResponse");
    private final static QName _AnularTicketIMM_QNAME = new QName("http://servidorimm/", "anularTicketIMM");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidorimm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnularTicketIMMResponse }
     * 
     */
    public AnularTicketIMMResponse createAnularTicketIMMResponse() {
        return new AnularTicketIMMResponse();
    }

    /**
     * Create an instance of {@link AltaTicketCompleto }
     * 
     */
    public AltaTicketCompleto createAltaTicketCompleto() {
        return new AltaTicketCompleto();
    }

    /**
     * Create an instance of {@link AltaTicketCompletoResponse }
     * 
     */
    public AltaTicketCompletoResponse createAltaTicketCompletoResponse() {
        return new AltaTicketCompletoResponse();
    }

    /**
     * Create an instance of {@link AnularTicketIMM }
     * 
     */
    public AnularTicketIMM createAnularTicketIMM() {
        return new AnularTicketIMM();
    }

    /**
     * Create an instance of {@link VoTicketCompleto }
     * 
     */
    public VoTicketCompleto createVoTicketCompleto() {
        return new VoTicketCompleto();
    }

    /**
     * Create an instance of {@link VoTicketBasico }
     * 
     */
    public VoTicketBasico createVoTicketBasico() {
        return new VoTicketBasico();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaTicketCompletoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "altaTicketCompletoResponse")
    public JAXBElement<AltaTicketCompletoResponse> createAltaTicketCompletoResponse(AltaTicketCompletoResponse value) {
        return new JAXBElement<AltaTicketCompletoResponse>(_AltaTicketCompletoResponse_QNAME, AltaTicketCompletoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaTicketCompleto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "altaTicketCompleto")
    public JAXBElement<AltaTicketCompleto> createAltaTicketCompleto(AltaTicketCompleto value) {
        return new JAXBElement<AltaTicketCompleto>(_AltaTicketCompleto_QNAME, AltaTicketCompleto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularTicketIMMResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "anularTicketIMMResponse")
    public JAXBElement<AnularTicketIMMResponse> createAnularTicketIMMResponse(AnularTicketIMMResponse value) {
        return new JAXBElement<AnularTicketIMMResponse>(_AnularTicketIMMResponse_QNAME, AnularTicketIMMResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularTicketIMM }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "anularTicketIMM")
    public JAXBElement<AnularTicketIMM> createAnularTicketIMM(AnularTicketIMM value) {
        return new JAXBElement<AnularTicketIMM>(_AnularTicketIMM_QNAME, AnularTicketIMM.class, null, value);
    }

}
