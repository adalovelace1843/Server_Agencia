
package servidorimm;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServletIMMService", targetNamespace = "http://servidorimm/", wsdlLocation = "http://localhost:8080/ServerIMM/ServletIMM?wsdl")
public class ServletIMMService
    extends Service
{

    private final static URL SERVLETIMMSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVLETIMMSERVICE_EXCEPTION;
    private final static QName SERVLETIMMSERVICE_QNAME = new QName("http://servidorimm/", "ServletIMMService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ServerIMM/ServletIMM?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVLETIMMSERVICE_WSDL_LOCATION = url;
        SERVLETIMMSERVICE_EXCEPTION = e;
    }

    public ServletIMMService() {
        super(__getWsdlLocation(), SERVLETIMMSERVICE_QNAME);
    }

    public ServletIMMService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVLETIMMSERVICE_QNAME, features);
    }

    public ServletIMMService(URL wsdlLocation) {
        super(wsdlLocation, SERVLETIMMSERVICE_QNAME);
    }

    public ServletIMMService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVLETIMMSERVICE_QNAME, features);
    }

    public ServletIMMService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServletIMMService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServletIMM
     */
    @WebEndpoint(name = "ServletIMMPort")
    public ServletIMM getServletIMMPort() {
        return super.getPort(new QName("http://servidorimm/", "ServletIMMPort"), ServletIMM.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServletIMM
     */
    @WebEndpoint(name = "ServletIMMPort")
    public ServletIMM getServletIMMPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servidorimm/", "ServletIMMPort"), ServletIMM.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVLETIMMSERVICE_EXCEPTION!= null) {
            throw SERVLETIMMSERVICE_EXCEPTION;
        }
        return SERVLETIMMSERVICE_WSDL_LOCATION;
    }

}
