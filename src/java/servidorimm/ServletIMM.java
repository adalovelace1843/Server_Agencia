
package servidorimm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServletIMM", targetNamespace = "http://servidorimm/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServletIMM {


    /**
     * 
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "anularTicketIMM", targetNamespace = "http://servidorimm/", className = "servidorimm.AnularTicketIMM")
    @ResponseWrapper(localName = "anularTicketIMMResponse", targetNamespace = "http://servidorimm/", className = "servidorimm.AnularTicketIMMResponse")
    public int anularTicketIMM(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns servidorimm.VoTicketBasico
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "altaTicketCompleto", targetNamespace = "http://servidorimm/", className = "servidorimm.AltaTicketCompleto")
    @ResponseWrapper(localName = "altaTicketCompletoResponse", targetNamespace = "http://servidorimm/", className = "servidorimm.AltaTicketCompletoResponse")
    public VoTicketBasico altaTicketCompleto(
        @WebParam(name = "arg0", targetNamespace = "")
        VoTicketCompleto arg0);

}
