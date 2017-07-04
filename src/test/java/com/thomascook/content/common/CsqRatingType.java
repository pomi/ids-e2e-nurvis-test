//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for csqRatingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="csqRatingType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OverallHolidayRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OverallAccomRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LocationRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FoodAndDrinkRating" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CSQNote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "csqRatingType", propOrder = {
    "overallHolidayRating",
    "overallAccomRating",
    "locationRating",
    "foodAndDrinkRating",
    "csqNote"
})
public class CsqRatingType {

    @XmlElement(name = "OverallHolidayRating")
    protected String overallHolidayRating;
    @XmlElement(name = "OverallAccomRating")
    protected String overallAccomRating;
    @XmlElement(name = "LocationRating")
    protected String locationRating;
    @XmlElement(name = "FoodAndDrinkRating")
    protected String foodAndDrinkRating;
    @XmlElement(name = "CSQNote")
    protected String csqNote;

    /**
     * Gets the value of the overallHolidayRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverallHolidayRating() {
        return overallHolidayRating;
    }

    /**
     * Sets the value of the overallHolidayRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverallHolidayRating(String value) {
        this.overallHolidayRating = value;
    }

    /**
     * Gets the value of the overallAccomRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOverallAccomRating() {
        return overallAccomRating;
    }

    /**
     * Sets the value of the overallAccomRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOverallAccomRating(String value) {
        this.overallAccomRating = value;
    }

    /**
     * Gets the value of the locationRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocationRating() {
        return locationRating;
    }

    /**
     * Sets the value of the locationRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocationRating(String value) {
        this.locationRating = value;
    }

    /**
     * Gets the value of the foodAndDrinkRating property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoodAndDrinkRating() {
        return foodAndDrinkRating;
    }

    /**
     * Sets the value of the foodAndDrinkRating property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoodAndDrinkRating(String value) {
        this.foodAndDrinkRating = value;
    }

    /**
     * Gets the value of the csqNote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSQNote() {
        return csqNote;
    }

    /**
     * Sets the value of the csqNote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSQNote(String value) {
        this.csqNote = value;
    }

}
