//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:45 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.request;

import javax.xml.bind.annotation.*;


/**
 * Provides accommodation location, dates and classifications
 * <p>
 * <p>Java class for AccommodationDetailType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AccommodationDetailType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}AccommodationInfoType">
 *       &lt;sequence>
 *         &lt;element name="FacilityChoices" type="{http://www.opentravel.org/OTA/2003/05}FacilityChoicesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
 *       &lt;attribute name="BedQuantity" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to999" />
 *       &lt;attribute name="TravelOKFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationDetailType", propOrder = {
        "facilityChoices"
})
public class AccommodationDetailType
        extends AccommodationInfoType {

    @XmlElement(name = "FacilityChoices")
    private FacilityChoicesType facilityChoices;
    @XmlAttribute(name = "BedQuantity")
    private Integer bedQuantity;
    @XmlAttribute(name = "TravelOKFlag")
    private Boolean travelOKFlag;
    @XmlAttribute(name = "Start")
    private String start;
    @XmlAttribute(name = "Duration")
    private String duration;
    @XmlAttribute(name = "End")
    private String end;

    /**
     * Gets the value of the facilityChoices property.
     *
     * @return possible object is
     * {@link FacilityChoicesType }
     */
    public FacilityChoicesType getFacilityChoices() {
        return facilityChoices;
    }

    /**
     * Sets the value of the facilityChoices property.
     *
     * @param value allowed object is
     *              {@link FacilityChoicesType }
     */
    public void setFacilityChoices(FacilityChoicesType value) {
        this.facilityChoices = value;
    }

    /**
     * Gets the value of the bedQuantity property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getBedQuantity() {
        return bedQuantity;
    }

    /**
     * Sets the value of the bedQuantity property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setBedQuantity(Integer value) {
        this.bedQuantity = value;
    }

    /**
     * Gets the value of the travelOKFlag property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isTravelOKFlag() {
        return travelOKFlag;
    }

    /**
     * Sets the value of the travelOKFlag property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setTravelOKFlag(Boolean value) {
        this.travelOKFlag = value;
    }

    /**
     * Gets the value of the start property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStart(String value) {
        this.start = value;
    }

    /**
     * Gets the value of the duration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEnd(String value) {
        this.end = value;
    }

}
