
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
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

    private final static QName _SearchUsuarioService_QNAME = new QName("http://WebService/", "SearchUsuarioService");
    private final static QName _SearchUsuarioServiceResponse_QNAME = new QName("http://WebService/", "SearchUsuarioServiceResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SearchUsuarioService }
     * 
     */
    public SearchUsuarioService createSearchUsuarioService() {
        return new SearchUsuarioService();
    }

    /**
     * Create an instance of {@link SearchUsuarioServiceResponse }
     * 
     */
    public SearchUsuarioServiceResponse createSearchUsuarioServiceResponse() {
        return new SearchUsuarioServiceResponse();
    }

    /**
     * Create an instance of {@link Usuario }
     * 
     */
    public Usuario createUsuario() {
        return new Usuario();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchUsuarioService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchUsuarioService }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "SearchUsuarioService")
    public JAXBElement<SearchUsuarioService> createSearchUsuarioService(SearchUsuarioService value) {
        return new JAXBElement<SearchUsuarioService>(_SearchUsuarioService_QNAME, SearchUsuarioService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchUsuarioServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchUsuarioServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://WebService/", name = "SearchUsuarioServiceResponse")
    public JAXBElement<SearchUsuarioServiceResponse> createSearchUsuarioServiceResponse(SearchUsuarioServiceResponse value) {
        return new JAXBElement<SearchUsuarioServiceResponse>(_SearchUsuarioServiceResponse_QNAME, SearchUsuarioServiceResponse.class, null, value);
    }

}
