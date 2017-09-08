
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

    private final static QName _AltaTicketResponse_QNAME = new QName("http://servidorimm/", "altaTicketResponse");
    private final static QName _AltaTicket_QNAME = new QName("http://servidorimm/", "altaTicket");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidorimm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AltaTicket }
     * 
     */
    public AltaTicket createAltaTicket() {
        return new AltaTicket();
    }

    /**
     * Create an instance of {@link AltaTicketResponse }
     * 
     */
    public AltaTicketResponse createAltaTicketResponse() {
        return new AltaTicketResponse();
    }

    /**
     * Create an instance of {@link VoTicket }
     * 
     */
    public VoTicket createVoTicket() {
        return new VoTicket();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaTicketResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "altaTicketResponse")
    public JAXBElement<AltaTicketResponse> createAltaTicketResponse(AltaTicketResponse value) {
        return new JAXBElement<AltaTicketResponse>(_AltaTicketResponse_QNAME, AltaTicketResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AltaTicket }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidorimm/", name = "altaTicket")
    public JAXBElement<AltaTicket> createAltaTicket(AltaTicket value) {
        return new JAXBElement<AltaTicket>(_AltaTicket_QNAME, AltaTicket.class, null, value);
    }

}
