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
 * <p>Java class for ExecutionGroup_TYP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExecutionGroup_TYP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.example.org/Brokers}ExecutionGroupName"/>
 *         &lt;element ref="{http://www.example.org/Brokers}isExecutionGroupRunning"/>
 *         &lt;element ref="{http://www.example.org/Brokers}Applications" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecutionGroup_TYP", propOrder = {
    "executionGroupName",
    "isExecutionGroupRunning",
    "applications"
})
public class ExecutionGroupTYP {

    @XmlElement(name = "ExecutionGroupName", required = true)
    protected String executionGroupName;
    protected boolean isExecutionGroupRunning;
    @XmlElement(name = "Applications")
    protected ApplicationsTYP applications;

    /**
     * Gets the value of the executionGroupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionGroupName() {
        return executionGroupName;
    }

    /**
     * Sets the value of the executionGroupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionGroupName(String value) {
        this.executionGroupName = value;
    }

    /**
     * Gets the value of the isExecutionGroupRunning property.
     * 
     */
    public boolean isIsExecutionGroupRunning() {
        return isExecutionGroupRunning;
    }

    /**
     * Sets the value of the isExecutionGroupRunning property.
     * 
     */
    public void setIsExecutionGroupRunning(boolean value) {
        this.isExecutionGroupRunning = value;
    }

    /**
     * Gets the value of the applications property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationsTYP }
     *     
     */
    public ApplicationsTYP getApplications() {
        return applications;
    }

    /**
     * Sets the value of the applications property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationsTYP }
     *     
     */
    public void setApplications(ApplicationsTYP value) {
        this.applications = value;
    }

}
