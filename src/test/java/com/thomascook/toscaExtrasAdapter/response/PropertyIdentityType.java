//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Full name or description plus codes for a property.
 * <p>
 * <p>Java class for PropertyIdentityType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PropertyIdentityType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StringLength0to128">
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}HotelReferenceGroup"/>
 *       &lt;attribute name="PropertyClassType" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="ContentURL" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PropertyIdentityType", propOrder = {
        "value"
})
public class PropertyIdentityType {

    @XmlValue
    private String value;
    @XmlAttribute(name = "PropertyClassType")
    private String propertyClassType;
    @XmlAttribute(name = "ContentURL")
    @XmlSchemaType(name = "anyURI")
    private String contentURL;
    @XmlAttribute(name = "ChainCode")
    private String chainCode;
    @XmlAttribute(name = "BrandCode")
    private String brandCode;
    @XmlAttribute(name = "HotelCode")
    private String hotelCode;
    @XmlAttribute(name = "HotelCityCode")
    private String hotelCityCode;
    @XmlAttribute(name = "HotelName")
    private String hotelName;
    @XmlAttribute(name = "HotelCodeContext")
    private String hotelCodeContext;
    @XmlAttribute(name = "ChainName")
    private String chainName;
    @XmlAttribute(name = "BrandName")
    private String brandName;
    @XmlAttribute(name = "AreaID")
    private String areaID;

    /**
     * Used for Character Strings, length 0 to 128
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
     * Gets the value of the propertyClassType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPropertyClassType() {
        return propertyClassType;
    }

    /**
     * Sets the value of the propertyClassType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPropertyClassType(String value) {
        this.propertyClassType = value;
    }

    /**
     * Gets the value of the contentURL property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getContentURL() {
        return contentURL;
    }

    /**
     * Sets the value of the contentURL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setContentURL(String value) {
        this.contentURL = value;
    }

    /**
     * Gets the value of the chainCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChainCode() {
        return chainCode;
    }

    /**
     * Sets the value of the chainCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChainCode(String value) {
        this.chainCode = value;
    }

    /**
     * Gets the value of the brandCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * Sets the value of the brandCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandCode(String value) {
        this.brandCode = value;
    }

    /**
     * Gets the value of the hotelCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHotelCode() {
        return hotelCode;
    }

    /**
     * Sets the value of the hotelCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHotelCode(String value) {
        this.hotelCode = value;
    }

    /**
     * Gets the value of the hotelCityCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHotelCityCode() {
        return hotelCityCode;
    }

    /**
     * Sets the value of the hotelCityCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHotelCityCode(String value) {
        this.hotelCityCode = value;
    }

    /**
     * Gets the value of the hotelName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the value of the hotelName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHotelName(String value) {
        this.hotelName = value;
    }

    /**
     * Gets the value of the hotelCodeContext property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHotelCodeContext() {
        return hotelCodeContext;
    }

    /**
     * Sets the value of the hotelCodeContext property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHotelCodeContext(String value) {
        this.hotelCodeContext = value;
    }

    /**
     * Gets the value of the chainName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChainName() {
        return chainName;
    }

    /**
     * Sets the value of the chainName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChainName(String value) {
        this.chainName = value;
    }

    /**
     * Gets the value of the brandName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets the value of the brandName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandName(String value) {
        this.brandName = value;
    }

    /**
     * Gets the value of the areaID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAreaID() {
        return areaID;
    }

    /**
     * Sets the value of the areaID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAreaID(String value) {
        this.areaID = value;
    }

}
