//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Employment identification; using an employee ID number, title, level within the company, and an indication of their status, i.e.: active, retired, on leave, or terminated from employment.  Additional information about an employee can be entered into the element, including the name of the employee, if it differs from the person name identified as a customer or contact.
 * <p>
 * <p>Java class for EmployeeInfoType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="EmployeeInfoType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StringLength0to64">
 *       &lt;attribute name="EmployeeId" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="EmployeeLevel" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="EmployeeTitle" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *       &lt;attribute name="EmployeeStatus" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EmployeeInfoType", propOrder = {
        "value"
})
public class EmployeeInfoType {

    @XmlValue
    private String value;
    @XmlAttribute(name = "EmployeeId")
    private String employeeId;
    @XmlAttribute(name = "EmployeeLevel")
    private String employeeLevel;
    @XmlAttribute(name = "EmployeeTitle")
    private String employeeTitle;
    @XmlAttribute(name = "EmployeeStatus")
    private String employeeStatus;

    /**
     * Used for Character Strings, length 0 to 64
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the employeeId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
    }

    /**
     * Gets the value of the employeeLevel property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmployeeLevel() {
        return employeeLevel;
    }

    /**
     * Sets the value of the employeeLevel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmployeeLevel(String value) {
        this.employeeLevel = value;
    }

    /**
     * Gets the value of the employeeTitle property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmployeeTitle() {
        return employeeTitle;
    }

    /**
     * Sets the value of the employeeTitle property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmployeeTitle(String value) {
        this.employeeTitle = value;
    }

    /**
     * Gets the value of the employeeStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEmployeeStatus() {
        return employeeStatus;
    }

    /**
     * Sets the value of the employeeStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEmployeeStatus(String value) {
        this.employeeStatus = value;
    }

}
