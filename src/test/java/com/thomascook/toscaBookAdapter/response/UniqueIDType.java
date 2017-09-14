//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:47 PM EEST 
//


package com.thomascook.toscaBookAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * An identifier used to uniquely reference an object in a system (e.g. an airline reservation reference, customer profile reference, booking confirmation number, or a reference to a previous availability quote).
 * <p>
 * <p>Java class for UniqueID_Type complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="UniqueID_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyName" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}UniqueID_Group"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UniqueID_Type", propOrder = {
        "companyName"
})
@XmlSeeAlso({
        SourceType.RequestorID.class
})
public class UniqueIDType {

    @XmlElement(name = "CompanyName")
    private CompanyNameType companyName;
    @XmlAttribute(name = "URL")
    @XmlSchemaType(name = "anyURI")
    private String url;
    @XmlAttribute(name = "Type", required = true)
    private String type;
    @XmlAttribute(name = "Instance")
    private String instance;
    @XmlAttribute(name = "ID_Context")
    private String idContext;
    @XmlAttribute(name = "ID", required = true)
    private String id;

    /**
     * Gets the value of the companyName property.
     *
     * @return possible object is
     * {@link CompanyNameType }
     */
    public CompanyNameType getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     *
     * @param value allowed object is
     *              {@link CompanyNameType }
     */
    public void setCompanyName(CompanyNameType value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the url property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURL(String value) {
        this.url = value;
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
     * Gets the value of the instance property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInstance() {
        return instance;
    }

    /**
     * Sets the value of the instance property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInstance(String value) {
        this.instance = value;
    }

    /**
     * Gets the value of the idContext property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIDContext() {
        return idContext;
    }

    /**
     * Sets the value of the idContext property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIDContext(String value) {
        this.idContext = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setID(String value) {
        this.id = value;
    }

}
