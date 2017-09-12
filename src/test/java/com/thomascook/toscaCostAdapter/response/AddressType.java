//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:48 PM EEST 
//


package com.thomascook.toscaCostAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * Provides address information.
 * <p>
 * <p>Java class for AddressType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AddressType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StreetNmbr" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StreetNmbrType">
 *                 &lt;attribute name="StreetNmbrSuffix" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *                 &lt;attribute name="StreetDirection" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *                 &lt;attribute name="RuralRouteNmbr" type="{http://www.opentravel.org/OTA/2003/05}NumericStringLength1to5" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="BldgRoom" maxOccurs="2" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StringLength0to64">
 *                 &lt;attribute name="BldgNameIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AddressLine" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to255" maxOccurs="5" minOccurs="2"/>
 *         &lt;element name="CityName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" minOccurs="0"/>
 *         &lt;element name="PostalCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" minOccurs="0"/>
 *         &lt;element name="County" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" minOccurs="0"/>
 *         &lt;element name="StateProv" type="{http://www.opentravel.org/OTA/2003/05}StateProvType" minOccurs="0"/>
 *         &lt;element name="CountryName" type="{http://www.opentravel.org/OTA/2003/05}CountryNameType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PrivacyGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}FormattedInd"/>
 *       &lt;attribute name="Type" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
        "streetNmbr",
        "bldgRoom",
        "addressLine",
        "cityName",
        "postalCode",
        "county",
        "stateProv",
        "countryName"
})
@XmlSeeAlso({
        AddressInfoType.class
})
public class AddressType {

    @XmlElement(name = "StreetNmbr")
    private StreetNmbr streetNmbr;
    @XmlElement(name = "BldgRoom")
    private List<BldgRoom> bldgRoom;
    @XmlElement(name = "AddressLine", required = true)
    private List<String> addressLine;
    @XmlElement(name = "CityName")
    private String cityName;
    @XmlElement(name = "PostalCode")
    private String postalCode;
    @XmlElement(name = "County")
    private String county;
    @XmlElement(name = "StateProv")
    private StateProvType stateProv;
    @XmlElement(name = "CountryName")
    private CountryNameType countryName;
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "ShareSynchInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareMarketInd;
    @XmlAttribute(name = "FormattedInd")
    private Boolean formattedInd;

    /**
     * Gets the value of the streetNmbr property.
     *
     * @return possible object is
     * {@link StreetNmbr }
     */
    public StreetNmbr getStreetNmbr() {
        return streetNmbr;
    }

    /**
     * Sets the value of the streetNmbr property.
     *
     * @param value allowed object is
     *              {@link StreetNmbr }
     */
    public void setStreetNmbr(StreetNmbr value) {
        this.streetNmbr = value;
    }

    /**
     * Gets the value of the bldgRoom property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bldgRoom property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBldgRoom().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BldgRoom }
     */
    public List<BldgRoom> getBldgRoom() {
        if (bldgRoom == null) {
            bldgRoom = new ArrayList<>();
        }
        return this.bldgRoom;
    }

    /**
     * Gets the value of the addressLine property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressLine property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressLine().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<>();
        }
        return this.addressLine;
    }

    /**
     * Gets the value of the cityName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCityName(String value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the postalCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the county property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the stateProv property.
     *
     * @return possible object is
     * {@link StateProvType }
     */
    public StateProvType getStateProv() {
        return stateProv;
    }

    /**
     * Sets the value of the stateProv property.
     *
     * @param value allowed object is
     *              {@link StateProvType }
     */
    public void setStateProv(StateProvType value) {
        this.stateProv = value;
    }

    /**
     * Gets the value of the countryName property.
     *
     * @return possible object is
     * {@link CountryNameType }
     */
    public CountryNameType getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     *
     * @param value allowed object is
     *              {@link CountryNameType }
     */
    public void setCountryName(CountryNameType value) {
        this.countryName = value;
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
     * Gets the value of the shareSynchInd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShareSynchInd() {
        return shareSynchInd;
    }

    /**
     * Sets the value of the shareSynchInd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShareSynchInd(String value) {
        this.shareSynchInd = value;
    }

    /**
     * Gets the value of the shareMarketInd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShareMarketInd() {
        return shareMarketInd;
    }

    /**
     * Sets the value of the shareMarketInd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShareMarketInd(String value) {
        this.shareMarketInd = value;
    }

    /**
     * Gets the value of the formattedInd property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isFormattedInd() {
        if (formattedInd == null) {
            return false;
        } else {
            return formattedInd;
        }
    }

    /**
     * Sets the value of the formattedInd property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setFormattedInd(Boolean value) {
        this.formattedInd = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StringLength0to64">
     *       &lt;attribute name="BldgNameIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "value"
    })
    public static class BldgRoom {

        @XmlValue
        String value;
        @XmlAttribute(name = "BldgNameIndicator")
        Boolean bldgNameIndicator;

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
         * Gets the value of the bldgNameIndicator property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public Boolean isBldgNameIndicator() {
            return bldgNameIndicator;
        }

        /**
         * Sets the value of the bldgNameIndicator property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setBldgNameIndicator(Boolean value) {
            this.bldgNameIndicator = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StreetNmbrType">
     *       &lt;attribute name="StreetNmbrSuffix" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
     *       &lt;attribute name="StreetDirection" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
     *       &lt;attribute name="RuralRouteNmbr" type="{http://www.opentravel.org/OTA/2003/05}NumericStringLength1to5" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class StreetNmbr
            extends StreetNmbrType {

        @XmlAttribute(name = "StreetNmbrSuffix")
        String streetNmbrSuffix;
        @XmlAttribute(name = "StreetDirection")
        String streetDirection;
        @XmlAttribute(name = "RuralRouteNmbr")
        String ruralRouteNmbr;

        /**
         * Gets the value of the streetNmbrSuffix property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getStreetNmbrSuffix() {
            return streetNmbrSuffix;
        }

        /**
         * Sets the value of the streetNmbrSuffix property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setStreetNmbrSuffix(String value) {
            this.streetNmbrSuffix = value;
        }

        /**
         * Gets the value of the streetDirection property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getStreetDirection() {
            return streetDirection;
        }

        /**
         * Sets the value of the streetDirection property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setStreetDirection(String value) {
            this.streetDirection = value;
        }

        /**
         * Gets the value of the ruralRouteNmbr property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getRuralRouteNmbr() {
            return ruralRouteNmbr;
        }

        /**
         * Sets the value of the ruralRouteNmbr property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setRuralRouteNmbr(String value) {
            this.ruralRouteNmbr = value;
        }

    }

}
