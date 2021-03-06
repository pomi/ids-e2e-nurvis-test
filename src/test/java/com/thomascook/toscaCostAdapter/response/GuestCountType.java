//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:48 PM EEST 
//


package com.thomascook.toscaCostAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * A collection of GuestCount by age group.
 * <p>
 * <p>Java class for GuestCountType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="GuestCountType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GuestCount" maxOccurs="99">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}GuestCountGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="IsPerRoom" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GuestCountType", propOrder = {
        "guestCount"
})
public class GuestCountType {

    @XmlElement(name = "GuestCount", required = true)
    private List<GuestCount> guestCount;
    @XmlAttribute(name = "IsPerRoom")
    private Boolean isPerRoom;

    /**
     * Gets the value of the guestCount property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the guestCount property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuestCount().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuestCount }
     */
    public List<GuestCount> getGuestCount() {
        if (guestCount == null) {
            guestCount = new ArrayList<>();
        }
        return this.guestCount;
    }

    /**
     * Gets the value of the isPerRoom property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isIsPerRoom() {
        return isPerRoom;
    }

    /**
     * Sets the value of the isPerRoom property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setIsPerRoom(Boolean value) {
        this.isPerRoom = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}GuestCountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class GuestCount {

        @XmlAttribute(name = "AgeQualifyingCode")
        String ageQualifyingCode;
        @XmlAttribute(name = "Age")
        Integer age;
        @XmlAttribute(name = "Count")
        Integer count;

        /**
         * Gets the value of the ageQualifyingCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAgeQualifyingCode() {
            return ageQualifyingCode;
        }

        /**
         * Sets the value of the ageQualifyingCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAgeQualifyingCode(String value) {
            this.ageQualifyingCode = value;
        }

        /**
         * Gets the value of the age property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getAge() {
            return age;
        }

        /**
         * Sets the value of the age property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setAge(Integer value) {
            this.age = value;
        }

        /**
         * Gets the value of the count property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getCount() {
            return count;
        }

        /**
         * Sets the value of the count property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setCount(Integer value) {
            this.count = value;
        }

    }

}
