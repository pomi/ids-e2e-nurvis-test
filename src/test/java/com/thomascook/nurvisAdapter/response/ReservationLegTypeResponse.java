//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.30 at 10:58:29 AM EEST 
//


package com.thomascook.nurvisAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Leg-Information
 * <p>
 * <p>
 * <p>Java class for Reservation-LegType-Response complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Reservation-LegType-Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DepDate" type="{}DateType" minOccurs="0"/>
 *         &lt;element name="ArrDate" type="{}DateType" minOccurs="0"/>
 *         &lt;element name="Dep" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Arr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Class" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Carrier" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FlightNr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DepTime" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ArrTime" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ExtPortal" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ExtPortalRef" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Key">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="1000"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="External" type="{}YesNoType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation-LegType-Response", propOrder = {
        "depDate",
        "arrDate",
        "dep",
        "arr",
        "clazz",
        "carrier",
        "flightNr",
        "depTime",
        "arrTime",
        "extPortal",
        "extPortalRef"
})
public class ReservationLegTypeResponse {

    @XmlElement(name = "DepDate")
    private String depDate;
    @XmlElement(name = "ArrDate")
    private String arrDate;
    @XmlElement(name = "Dep")
    private String dep;
    @XmlElement(name = "Arr")
    private String arr;
    @XmlElement(name = "Class")
    private String clazz;
    @XmlElement(name = "Carrier")
    private String carrier;
    @XmlElement(name = "FlightNr")
    private String flightNr;
    @XmlElement(name = "DepTime")
    private String depTime;
    @XmlElement(name = "ArrTime")
    private String arrTime;
    @XmlElement(name = "ExtPortal")
    private String extPortal;
    @XmlElement(name = "ExtPortalRef")
    private String extPortalRef;
    @XmlAttribute(name = "Key")
    private String key;
    @XmlAttribute(name = "External")
    private String external;

    /**
     * Gets the value of the depDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDepDate() {
        return depDate;
    }

    /**
     * Sets the value of the depDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDepDate(String value) {
        this.depDate = value;
    }

    /**
     * Gets the value of the arrDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArrDate() {
        return arrDate;
    }

    /**
     * Sets the value of the arrDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArrDate(String value) {
        this.arrDate = value;
    }

    /**
     * Gets the value of the dep property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDep() {
        return dep;
    }

    /**
     * Sets the value of the dep property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDep(String value) {
        this.dep = value;
    }

    /**
     * Gets the value of the arr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArr() {
        return arr;
    }

    /**
     * Sets the value of the arr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArr(String value) {
        this.arr = value;
    }

    /**
     * Gets the value of the clazz property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the carrier property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * Sets the value of the carrier property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCarrier(String value) {
        this.carrier = value;
    }

    /**
     * Gets the value of the flightNr property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFlightNr() {
        return flightNr;
    }

    /**
     * Sets the value of the flightNr property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFlightNr(String value) {
        this.flightNr = value;
    }

    /**
     * Gets the value of the depTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDepTime() {
        return depTime;
    }

    /**
     * Sets the value of the depTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDepTime(String value) {
        this.depTime = value;
    }

    /**
     * Gets the value of the arrTime property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArrTime() {
        return arrTime;
    }

    /**
     * Sets the value of the arrTime property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArrTime(String value) {
        this.arrTime = value;
    }

    /**
     * Gets the value of the extPortal property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExtPortal() {
        return extPortal;
    }

    /**
     * Sets the value of the extPortal property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExtPortal(String value) {
        this.extPortal = value;
    }

    /**
     * Gets the value of the extPortalRef property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExtPortalRef() {
        return extPortalRef;
    }

    /**
     * Sets the value of the extPortalRef property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExtPortalRef(String value) {
        this.extPortalRef = value;
    }

    /**
     * Gets the value of the key property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the external property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExternal() {
        return external;
    }

    /**
     * Sets the value of the external property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExternal(String value) {
        this.external = value;
    }

}
