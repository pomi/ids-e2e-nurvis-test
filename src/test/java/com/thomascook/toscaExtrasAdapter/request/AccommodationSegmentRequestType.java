//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:45 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.request;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines the required accommodation component of a package holiday.
 * <p>
 * <p>Java class for AccommodationSegmentRequestType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AccommodationSegmentRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Identity" type="{http://www.opentravel.org/OTA/2003/05}PropertyIdentityType" minOccurs="0"/>
 *         &lt;element name="DateRange" type="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanType"/>
 *         &lt;element name="RoomProfiles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RoomProfile" type="{http://www.opentravel.org/OTA/2003/05}RoomProfileType" maxOccurs="9"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MealPlans" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MealPlan" type="{http://www.opentravel.org/OTA/2003/05}MealPlanType" maxOccurs="9"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}ResortCodeGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DestinationLevelGroup"/>
 *       &lt;attribute name="RPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AccommodationSegmentRequestType", propOrder = {
        "identity",
        "dateRange",
        "roomProfiles",
        "mealPlans"
})
public class AccommodationSegmentRequestType {

    @XmlElement(name = "Identity")
    private PropertyIdentityType identity;
    @XmlElement(name = "DateRange", required = true)
    private DateTimeSpanType dateRange;
    @XmlElement(name = "RoomProfiles")
    private RoomProfiles roomProfiles;
    @XmlElement(name = "MealPlans")
    private MealPlans mealPlans;
    @XmlAttribute(name = "RPH")
    private String rph;
    @XmlAttribute(name = "ResortCode")
    private String resortCode;
    @XmlAttribute(name = "ResortName")
    private String resortName;
    @XmlAttribute(name = "DestinationCode")
    private String destinationCode;
    @XmlAttribute(name = "DestinationLevel")
    private DestinationLevelType destinationLevel;
    @XmlAttribute(name = "DestinationName")
    private String destinationName;

    /**
     * Gets the value of the identity property.
     *
     * @return possible object is
     * {@link PropertyIdentityType }
     */
    public PropertyIdentityType getIdentity() {
        return identity;
    }

    /**
     * Sets the value of the identity property.
     *
     * @param value allowed object is
     *              {@link PropertyIdentityType }
     */
    public void setIdentity(PropertyIdentityType value) {
        this.identity = value;
    }

    /**
     * Gets the value of the dateRange property.
     *
     * @return possible object is
     * {@link DateTimeSpanType }
     */
    public DateTimeSpanType getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     *
     * @param value allowed object is
     *              {@link DateTimeSpanType }
     */
    public void setDateRange(DateTimeSpanType value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the roomProfiles property.
     *
     * @return possible object is
     * {@link RoomProfiles }
     */
    public RoomProfiles getRoomProfiles() {
        return roomProfiles;
    }

    /**
     * Sets the value of the roomProfiles property.
     *
     * @param value allowed object is
     *              {@link RoomProfiles }
     */
    public void setRoomProfiles(RoomProfiles value) {
        this.roomProfiles = value;
    }

    /**
     * Gets the value of the mealPlans property.
     *
     * @return possible object is
     * {@link MealPlans }
     */
    public MealPlans getMealPlans() {
        return mealPlans;
    }

    /**
     * Sets the value of the mealPlans property.
     *
     * @param value allowed object is
     *              {@link MealPlans }
     */
    public void setMealPlans(MealPlans value) {
        this.mealPlans = value;
    }

    /**
     * Gets the value of the rph property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRPH() {
        return rph;
    }

    /**
     * Sets the value of the rph property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRPH(String value) {
        this.rph = value;
    }

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


    /**
     * <p>Java class for anonymous complex type.
     * <p>
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <p>
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MealPlan" type="{http://www.opentravel.org/OTA/2003/05}MealPlanType" maxOccurs="9"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "mealPlan"
    })
    public static class MealPlans {

        @XmlElement(name = "MealPlan", required = true)
        List<MealPlanType> mealPlan;

        /**
         * Gets the value of the mealPlan property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mealPlan property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMealPlan().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MealPlanType }
         */
        public List<MealPlanType> getMealPlan() {
            if (mealPlan == null) {
                mealPlan = new ArrayList<>();
            }
            return this.mealPlan;
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
     *       &lt;sequence>
     *         &lt;element name="RoomProfile" type="{http://www.opentravel.org/OTA/2003/05}RoomProfileType" maxOccurs="9"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "roomProfile"
    })
    public static class RoomProfiles {

        @XmlElement(name = "RoomProfile", required = true)
        List<RoomProfileType> roomProfile;

        /**
         * Gets the value of the roomProfile property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the roomProfile property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRoomProfile().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RoomProfileType }
         */
        public List<RoomProfileType> getRoomProfile() {
            if (roomProfile == null) {
                roomProfile = new ArrayList<>();
            }
            return this.roomProfile;
        }

    }

}
