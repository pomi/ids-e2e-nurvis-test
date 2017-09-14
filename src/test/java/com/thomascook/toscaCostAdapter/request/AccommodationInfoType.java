//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:34 PM EEST 
//


package com.thomascook.toscaCostAdapter.request;

import javax.xml.bind.annotation.*;


/**
 * Provides accommodation location, dates and classifications
 * <p>
 * <p>Java class for AccommodationInfoType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AccommodationInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Property" type="{http://www.opentravel.org/OTA/2003/05}PropertyIdentityType"/>
 *         &lt;element name="Resort" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}ResortCodeGroup"/>
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DestinationLevelGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AccommodationClass" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}AccommodationClassGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SourceIdentification" type="{http://www.opentravel.org/OTA/2003/05}SourceIdentificationType" minOccurs="0"/>
 *         &lt;element name="ContentInfo" type="{http://www.opentravel.org/OTA/2003/05}URL_Type" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PackageID" type="{http://www.opentravel.org/OTA/2003/05}PackageID_RefType" />
 *       &lt;attribute name="MinChildAge" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="MaxChildAge" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="BaseMealPlan" type="{http://www.opentravel.org/OTA/2003/05}MealPlanCode" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationInfoType", propOrder = {
        "property",
        "resort",
        "accommodationClass",
        "sourceIdentification",
        "contentInfo"
})
@XmlSeeAlso({
        AccommodationDetailType.class
})
public class AccommodationInfoType {

    @XmlElement(name = "Property", required = true)
    private PropertyIdentityType property;
    @XmlElement(name = "Resort")
    private Resort resort;
    @XmlElement(name = "AccommodationClass")
    private AccommodationClass accommodationClass;
    @XmlElement(name = "SourceIdentification")
    private SourceIdentificationType sourceIdentification;
    @XmlElement(name = "ContentInfo")
    private URLType contentInfo;
    @XmlAttribute(name = "PackageID")
    private String packageID;
    @XmlAttribute(name = "MinChildAge")
    private Integer minChildAge;
    @XmlAttribute(name = "MaxChildAge")
    private Integer maxChildAge;
    @XmlAttribute(name = "BaseMealPlan")
    private String baseMealPlan;

    /**
     * Gets the value of the property property.
     *
     * @return possible object is
     * {@link PropertyIdentityType }
     */
    public PropertyIdentityType getProperty() {
        return property;
    }

    /**
     * Sets the value of the property property.
     *
     * @param value allowed object is
     *              {@link PropertyIdentityType }
     */
    public void setProperty(PropertyIdentityType value) {
        this.property = value;
    }

    /**
     * Gets the value of the resort property.
     *
     * @return possible object is
     * {@link Resort }
     */
    public Resort getResort() {
        return resort;
    }

    /**
     * Sets the value of the resort property.
     *
     * @param value allowed object is
     *              {@link Resort }
     */
    public void setResort(Resort value) {
        this.resort = value;
    }

    /**
     * Gets the value of the accommodationClass property.
     *
     * @return possible object is
     * {@link AccommodationClass }
     */
    public AccommodationClass getAccommodationClass() {
        return accommodationClass;
    }

    /**
     * Sets the value of the accommodationClass property.
     *
     * @param value allowed object is
     *              {@link AccommodationClass }
     */
    public void setAccommodationClass(AccommodationClass value) {
        this.accommodationClass = value;
    }

    /**
     * Gets the value of the sourceIdentification property.
     *
     * @return possible object is
     * {@link SourceIdentificationType }
     */
    public SourceIdentificationType getSourceIdentification() {
        return sourceIdentification;
    }

    /**
     * Sets the value of the sourceIdentification property.
     *
     * @param value allowed object is
     *              {@link SourceIdentificationType }
     */
    public void setSourceIdentification(SourceIdentificationType value) {
        this.sourceIdentification = value;
    }

    /**
     * Gets the value of the contentInfo property.
     *
     * @return possible object is
     * {@link URLType }
     */
    public URLType getContentInfo() {
        return contentInfo;
    }

    /**
     * Sets the value of the contentInfo property.
     *
     * @param value allowed object is
     *              {@link URLType }
     */
    public void setContentInfo(URLType value) {
        this.contentInfo = value;
    }

    /**
     * Gets the value of the packageID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPackageID() {
        return packageID;
    }

    /**
     * Sets the value of the packageID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPackageID(String value) {
        this.packageID = value;
    }

    /**
     * Gets the value of the minChildAge property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMinChildAge() {
        return minChildAge;
    }

    /**
     * Sets the value of the minChildAge property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinChildAge(Integer value) {
        this.minChildAge = value;
    }

    /**
     * Gets the value of the maxChildAge property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMaxChildAge() {
        return maxChildAge;
    }

    /**
     * Sets the value of the maxChildAge property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxChildAge(Integer value) {
        this.maxChildAge = value;
    }

    /**
     * Gets the value of the baseMealPlan property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBaseMealPlan() {
        return baseMealPlan;
    }

    /**
     * Sets the value of the baseMealPlan property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBaseMealPlan(String value) {
        this.baseMealPlan = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}AccommodationClassGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AccommodationClass {

        @XmlAttribute(name = "Code")
        String code;
        @XmlAttribute(name = "Name")
        String name;
        @XmlAttribute(name = "NationalCode")
        String nationalCode;
        @XmlAttribute(name = "OfficialName")
        String officialName;

        /**
         * Gets the value of the code property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the nationalCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getNationalCode() {
            return nationalCode;
        }

        /**
         * Sets the value of the nationalCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setNationalCode(String value) {
            this.nationalCode = value;
        }

        /**
         * Gets the value of the officialName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getOfficialName() {
            return officialName;
        }

        /**
         * Sets the value of the officialName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setOfficialName(String value) {
            this.officialName = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}ResortCodeGroup"/>
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DestinationLevelGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Resort {

        @XmlAttribute(name = "ResortCode")
        String resortCode;
        @XmlAttribute(name = "ResortName")
        String resortName;
        @XmlAttribute(name = "DestinationCode")
        String destinationCode;
        @XmlAttribute(name = "DestinationLevel")
        DestinationLevelType destinationLevel;
        @XmlAttribute(name = "DestinationName")
        String destinationName;

        /**
         * Gets the value of the resortCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getResortCode() {
            return resortCode;
        }

        /**
         * Sets the value of the resortCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setResortCode(String value) {
            this.resortCode = value;
        }

        /**
         * Gets the value of the resortName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getResortName() {
            return resortName;
        }

        /**
         * Sets the value of the resortName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setResortName(String value) {
            this.resortName = value;
        }

        /**
         * Gets the value of the destinationCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDestinationCode() {
            return destinationCode;
        }

        /**
         * Sets the value of the destinationCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDestinationCode(String value) {
            this.destinationCode = value;
        }

        /**
         * Gets the value of the destinationLevel property.
         *
         * @return possible object is
         * {@link DestinationLevelType }
         */
        public DestinationLevelType getDestinationLevel() {
            return destinationLevel;
        }

        /**
         * Sets the value of the destinationLevel property.
         *
         * @param value allowed object is
         *              {@link DestinationLevelType }
         */
        public void setDestinationLevel(DestinationLevelType value) {
            this.destinationLevel = value;
        }

        /**
         * Gets the value of the destinationName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getDestinationName() {
            return destinationName;
        }

        /**
         * Sets the value of the destinationName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setDestinationName(String value) {
            this.destinationName = value;
        }

    }

}
