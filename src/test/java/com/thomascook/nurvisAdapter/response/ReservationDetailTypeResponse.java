//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.30 at 10:58:29 AM EEST 
//


package com.thomascook.nurvisAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Detailed information, e.g. confirmed errata
 * <p>
 * <p>
 * <p>Java class for Reservation-DetailType-Response complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Reservation-DetailType-Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Text">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="250"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Apply" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="7"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation-DetailType-Response", propOrder = {
        "text"
})
public class ReservationDetailTypeResponse {

    @XmlElement(name = "Text", required = true)
    private String text;
    @XmlAttribute(name = "Apply", required = true)
    private String apply;

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setText(String value) {
        this.text = value;
    }

    /**
     * Gets the value of the apply property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getApply() {
        return apply;
    }

    /**
     * Sets the value of the apply property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setApply(String value) {
        this.apply = value;
    }

}
