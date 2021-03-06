//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.30 at 10:58:29 AM EEST 
//


package com.thomascook.nurvisAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Error from KOMT
 * <p>
 * <p>
 * <p>Java class for Reservation-ErrType-Response complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Reservation-ErrType-Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ErrorNr">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ErrorText">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="CommError" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation-ErrType-Response", propOrder = {
        "errorNr",
        "errorText"
})
public class ReservationErrTypeResponse {

    @XmlElement(name = "ErrorNr", required = true)
    private String errorNr;
    @XmlElement(name = "ErrorText", required = true)
    private String errorText;
    @XmlAttribute(name = "CommError", required = true)
    private String commError;

    /**
     * Gets the value of the errorNr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getErrorNr() {
        return errorNr;
    }

    /**
     * Sets the value of the errorNr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorNr(String value) {
        this.errorNr = value;
    }

    /**
     * Gets the value of the errorText property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * Sets the value of the errorText property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setErrorText(String value) {
        this.errorText = value;
    }

    /**
     * Gets the value of the commError property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCommError() {
        return commError;
    }

    /**
     * Sets the value of the commError property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCommError(String value) {
        this.commError = value;
    }

}
