//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v3.0-03/04/2009 09:20 AM(valikov)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.11.24 at 03:39:28 PM IST 
//


package com.cts.dnb.model1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Application_TYP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Application_TYP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/Brokers}ApplicationName"/>
 *         &lt;element ref="{http://www.example.org/Brokers}isApplicationRunning"/>
 *         &lt;element ref="{http://www.example.org/Brokers}ApplicationDeployedOn"/>
 *         &lt;element ref="{http://www.example.org/Brokers}MessageFlows"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Application_TYP", propOrder = {
    "applicationName",
    "isApplicationRunning",
    "applicationDeployedOn",
    "messageFlows"
})
public class ApplicationTYP {

    @XmlElement(name = "ApplicationName", required = true)
    protected String applicationName;
    protected boolean isApplicationRunning;
    @XmlElement(name = "ApplicationDeployedOn", required = true)
    protected String applicationDeployedOn;
    @XmlElement(name = "MessageFlows", required = true)
    protected MessageFlowsTYP messageFlows;

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationName(String value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the isApplicationRunning property.
     * 
     */
    public boolean isIsApplicationRunning() {
        return isApplicationRunning;
    }

    /**
     * Sets the value of the isApplicationRunning property.
     * 
     */
    public void setIsApplicationRunning(boolean value) {
        this.isApplicationRunning = value;
    }

    /**
     * Gets the value of the applicationDeployedOn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApplicationDeployedOn() {
        return applicationDeployedOn;
    }

    /**
     * Sets the value of the applicationDeployedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApplicationDeployedOn(String value) {
        this.applicationDeployedOn = value;
    }

    /**
     * Gets the value of the messageFlows property.
     * 
     * @return
     *     possible object is
     *     {@link MessageFlowsTYP }
     *     
     */
    public MessageFlowsTYP getMessageFlows() {
        return messageFlows;
    }

    /**
     * Sets the value of the messageFlows property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageFlowsTYP }
     *     
     */
    public void setMessageFlows(MessageFlowsTYP value) {
        this.messageFlows = value;
    }

}
