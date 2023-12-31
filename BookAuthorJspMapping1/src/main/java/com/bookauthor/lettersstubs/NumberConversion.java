package com.bookauthor.lettersstubs;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceFeature;
import jakarta.xml.ws.Service;

/**
 * The Number Conversion Web Service, implemented with
 * 			Visual DataFlex, provides functions that convert numbers into words
 * 			or dollar amounts.
 * 		
 *
 * This class was generated by Apache CXF 4.0.0
 * 2023-09-16T08:56:41.461+05:30
 * Generated source version: 4.0.0
 *
 */
@WebServiceClient(name = "NumberConversion",
                  wsdlLocation = "file:/C:/Users/buddpras/OneDrive%20-%20Capgemini/Desktop/JavaCodesGit/BookAuthorJspMapping1/src/main/resources/wsdl/LettersConversion.wsdl",
                  targetNamespace = "http://www.dataaccess.com/webservicesserver/")
public class NumberConversion extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversion");
    public final static QName NumberConversionSoap = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap");
    public final static QName NumberConversionSoap12 = new QName("http://www.dataaccess.com/webservicesserver/", "NumberConversionSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/buddpras/OneDrive%20-%20Capgemini/Desktop/JavaCodesGit/BookAuthorJspMapping1/src/main/resources/wsdl/LettersConversion.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(NumberConversion.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/buddpras/OneDrive%20-%20Capgemini/Desktop/JavaCodesGit/BookAuthorJspMapping1/src/main/resources/wsdl/LettersConversion.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public NumberConversion(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public NumberConversion(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public NumberConversion() {
        super(WSDL_LOCATION, SERVICE);
    }

    public NumberConversion(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public NumberConversion(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public NumberConversion(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap")
    public NumberConversionSoapType getNumberConversionSoap() {
        return super.getPort(NumberConversionSoap, NumberConversionSoapType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap")
    public NumberConversionSoapType getNumberConversionSoap(WebServiceFeature... features) {
        return super.getPort(NumberConversionSoap, NumberConversionSoapType.class, features);
    }


    /**
     *
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap12")
    public NumberConversionSoapType getNumberConversionSoap12() {
        return super.getPort(NumberConversionSoap12, NumberConversionSoapType.class);
    }

    /**
     *
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns NumberConversionSoapType
     */
    @WebEndpoint(name = "NumberConversionSoap12")
    public NumberConversionSoapType getNumberConversionSoap12(WebServiceFeature... features) {
        return super.getPort(NumberConversionSoap12, NumberConversionSoapType.class, features);
    }

}
