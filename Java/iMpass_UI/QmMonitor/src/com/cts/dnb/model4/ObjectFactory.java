//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v3.0-03/04/2009 09:20 AM(valikov)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.24 at 01:59:36 AM IST 
//


package com.cts.dnb.model4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cts.dnb.model4 package. 
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

    private final static QName _UserName_QNAME = new QName("http://www.example.org/Users", "UserName");
    private final static QName _User_QNAME = new QName("http://www.example.org/Users", "User");
    private final static QName _Email_QNAME = new QName("http://www.example.org/Users", "Email");
    private final static QName _Password_QNAME = new QName("http://www.example.org/Users", "Password");
    private final static QName _UserType_QNAME = new QName("http://www.example.org/Users", "UserType");
    private final static QName _Users_QNAME = new QName("http://www.example.org/Users", "Users");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cts.dnb.model4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UsersTYP }
     * 
     */
    public UsersTYP createUsersTYP() {
        return new UsersTYP();
    }

    /**
     * Create an instance of {@link UserTYP }
     * 
     */
    public UserTYP createUserTYP() {
        return new UserTYP();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "UserName")
    public JAXBElement<String> createUserName(String value) {
        return new JAXBElement<String>(_UserName_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserTYP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "User")
    public JAXBElement<UserTYP> createUser(UserTYP value) {
        return new JAXBElement<UserTYP>(_User_QNAME, UserTYP.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "Email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "Password")
    public JAXBElement<String> createPassword(String value) {
        return new JAXBElement<String>(_Password_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "UserType")
    public JAXBElement<String> createUserType(String value) {
        return new JAXBElement<String>(_UserType_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsersTYP }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/Users", name = "Users")
    public JAXBElement<UsersTYP> createUsers(UsersTYP value) {
        return new JAXBElement<UsersTYP>(_Users_QNAME, UsersTYP.class, null, value);
    }

}
