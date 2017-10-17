//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.30 at 10:58:29 AM EEST 
//


package com.thomascook.nurvisAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Reservation-ResponseType-Response complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Reservation-ResponseType-Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fab" type="{}Reservation-FabType-Response" minOccurs="0"/>
 *         &lt;element name="Warning" type="{}Reservation-WarningType-Response" minOccurs="0"/>
 *         &lt;element name="Err" type="{}Reservation-ErrType-Response" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="8"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="From">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="20"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="To">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="20"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="STermId">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="9"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Unit">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Date" type="{}DateType" />
 *       &lt;attribute name="Time" type="{}TimeType" />
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="15"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="SubType">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="20"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Agent">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="6"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="RSystem">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="6"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Rsystem_Create">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="6"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Lang">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Mode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="4"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="UserCode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="13"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="EducBook" type="{}YesNoType" />
 *       &lt;attribute name="IComClient">
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
@XmlType(name = "Reservation-ResponseType-Response", propOrder = {
        "fab",
        "warning",
        "err"
})
@XmlRootElement(name = "Response")
public class ReservationResponseTypeResponse {

    @XmlElement(name = "Fab")
    private ReservationFabTypeResponse fab;
    @XmlElement(name = "Warning")
    private ReservationWarningTypeResponse warning;
    @XmlElement(name = "Err")
    private ReservationErrTypeResponse err;
    @XmlAttribute(name = "Version")
    private String version;
    @XmlAttribute(name = "From")
    private String from;
    @XmlAttribute(name = "To")
    private String to;
    @XmlAttribute(name = "STermId")
    private String sTermId;
    @XmlAttribute(name = "Unit")
    private String unit;
    @XmlAttribute(name = "Date")
    private String date;
    @XmlAttribute(name = "Time")
    private String time;
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "SubType")
    private String subType;
    @XmlAttribute(name = "Agent")
    private String agent;
    @XmlAttribute(name = "RSystem")
    private String rSystem;
    @XmlAttribute(name = "Rsystem_Create")
    private String rsystemCreate;
    @XmlAttribute(name = "Lang")
    private String lang;
    @XmlAttribute(name = "Mode")
    private String mode;
    @XmlAttribute(name = "UserCode")
    private String userCode;
    @XmlAttribute(name = "EducBook")
    private String educBook;
    @XmlAttribute(name = "IComClient")
    private String iComClient;

    /**
     * Gets the value of the fab property.
     *
     * @return possible object is
     * {@link ReservationFabTypeResponse }
     */
    public ReservationFabTypeResponse getFab() {
        return fab;
    }

    /**
     * Sets the value of the fab property.
     *
     * @param value allowed object is
     *              {@link ReservationFabTypeResponse }
     */
    public void setFab(ReservationFabTypeResponse value) {
        this.fab = value;
    }

    /**
     * Gets the value of the warning property.
     *
     * @return possible object is
     * {@link ReservationWarningTypeResponse }
     */
    public ReservationWarningTypeResponse getWarning() {
        return warning;
    }

    /**
     * Sets the value of the warning property.
     *
     * @param value allowed object is
     *              {@link ReservationWarningTypeResponse }
     */
    public void setWarning(ReservationWarningTypeResponse value) {
        this.warning = value;
    }

    /**
     * Gets the value of the err property.
     *
     * @return possible object is
     * {@link ReservationErrTypeResponse }
     */
    public ReservationErrTypeResponse getErr() {
        return err;
    }

    /**
     * Sets the value of the err property.
     *
     * @param value allowed object is
     *              {@link ReservationErrTypeResponse }
     */
    public void setErr(ReservationErrTypeResponse value) {
        this.err = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the from property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the sTermId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSTermId() {
        return sTermId;
    }

    /**
     * Sets the value of the sTermId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSTermId(String value) {
        this.sTermId = value;
    }

    /**
     * Gets the value of the unit property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Sets the value of the unit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDate(String value) {
        this.date = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the subType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Gets the value of the agent property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAgent(String value) {
        this.agent = value;
    }

    /**
     * Gets the value of the rSystem property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRSystem() {
        return rSystem;
    }

    /**
     * Sets the value of the rSystem property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRSystem(String value) {
        this.rSystem = value;
    }

    /**
     * Gets the value of the rsystemCreate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRsystemCreate() {
        return rsystemCreate;
    }

    /**
     * Sets the value of the rsystemCreate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRsystemCreate(String value) {
        this.rsystemCreate = value;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLang(String value) {
        this.lang = value;
    }

    /**
     * Gets the value of the mode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMode(String value) {
        this.mode = value;
    }

    /**
     * Gets the value of the userCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * Sets the value of the userCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserCode(String value) {
        this.userCode = value;
    }

    /**
     * Gets the value of the educBook property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEducBook() {
        return educBook;
    }

    /**
     * Sets the value of the educBook property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEducBook(String value) {
        this.educBook = value;
    }

    /**
     * Gets the value of the iComClient property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIComClient() {
        return iComClient;
    }

    /**
     * Sets the value of the iComClient property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIComClient(String value) {
        this.iComClient = value;
    }

}
