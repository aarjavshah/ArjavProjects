//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v3.0-03/04/2009 09:20 AM(valikov)-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.19 at 06:58:12 PM IST 
//


package org.example.brokers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Broker_TYP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Broker_TYP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/Brokers}BrokerName"/>
 *         &lt;element ref="{http://www.example.org/Brokers}isBrokerRunning"/>
 *         &lt;element ref="{http://www.example.org/Brokers}EnvironmentAlias"/>
 *         &lt;element ref="{http://www.example.org/Brokers}ExecutionGroups"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Broker_TYP", propOrder = {
    "brokerName",
    "isBrokerRunning",
    "environmentAlias",
    "executionGroups"
})
public class BrokerTYP {

    @XmlElement(name = "BrokerName", required = true)
    protected String brokerName;
    protected boolean isBrokerRunning;
    @XmlElement(name = "EnvironmentAlias", required = true)
    protected String environmentAlias;
    @XmlElement(name = "ExecutionGroups", required = true)
    protected ExecutionGroupsTYP executionGroups;

    /**
     * Gets the value of the brokerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrokerName() {
        return brokerName;
    }

    /**
     * Sets the value of the brokerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrokerName(String value) {
        this.brokerName = value;
    }

    /**
     * Gets the value of the isBrokerRunning property.
     * 
     */
    public boolean isIsBrokerRunning() {
        return isBrokerRunning;
    }

    /**
     * Sets the value of the isBrokerRunning property.
     * 
     */
    public void setIsBrokerRunning(boolean value) {
        this.isBrokerRunning = value;
    }

    /**
     * Gets the value of the environmentAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnvironmentAlias() {
        return environmentAlias;
    }

    /**
     * Sets the value of the environmentAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnvironmentAlias(String value) {
        this.environmentAlias = value;
    }

    /**
     * Gets the value of the executionGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionGroupsTYP }
     *     
     */
    public ExecutionGroupsTYP getExecutionGroups() {
        return executionGroups;
    }

    /**
     * Sets the value of the executionGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionGroupsTYP }
     *     
     */
    public void setExecutionGroups(ExecutionGroupsTYP value) {
        this.executionGroups = value;
    }

}
