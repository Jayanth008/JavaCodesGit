package com.bookauthor.lettersstubs;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.0
 * 2023-06-06T14:50:58.968+05:30
 * Generated source version: 4.0.0
 *
 */
@WebService(targetNamespace = "http://www.dataaccess.com/webservicesserver/", name = "NumberConversionSoapType")
@XmlSeeAlso({ObjectFactory.class})
public interface NumberConversionSoapType {

    /**
     * Returns the word corresponding to the positive number
     * 				passed as parameter. Limited to quadrillions.
     * 			
     */
    @WebMethod(operationName = "NumberToWords")
    @RequestWrapper(localName = "NumberToWords", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bookauthor.lettersstubs.NumberToWords")
    @ResponseWrapper(localName = "NumberToWordsResponse", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bookauthor.lettersstubs.NumberToWordsResponse")
    @WebResult(name = "NumberToWordsResult", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
    public java.lang.String numberToWords(

        @WebParam(name = "ubiNum", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
        java.math.BigInteger ubiNum
    );

    /**
     * Returns the non-zero dollar amount of the passed
     * 				number.
     * 			
     */
    @WebMethod(operationName = "NumberToDollars")
    @RequestWrapper(localName = "NumberToDollars", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bookauthor.lettersstubs.NumberToDollars")
    @ResponseWrapper(localName = "NumberToDollarsResponse", targetNamespace = "http://www.dataaccess.com/webservicesserver/", className = "com.bookauthor.lettersstubs.NumberToDollarsResponse")
    @WebResult(name = "NumberToDollarsResult", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
    public java.lang.String numberToDollars(

        @WebParam(name = "dNum", targetNamespace = "http://www.dataaccess.com/webservicesserver/")
        java.math.BigDecimal dNum
    );
}
