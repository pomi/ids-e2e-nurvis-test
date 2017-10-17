//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:34 PM EEST 
//


package com.thomascook.toscaCostAdapter.request;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Provides the available facilities for the enquiror's chosen property and stay.
 * <p>
 * <p>Java class for FacilityChoicesType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="FacilityChoicesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AvailableRooms" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Room" type="{http://www.opentravel.org/OTA/2003/05}PkgRoomInventoryType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="AvailableMealPlans" minOccurs="0">
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
 *         &lt;element name="RoomPrices" maxOccurs="9" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="RoomPrice" type="{http://www.opentravel.org/OTA/2003/05}RoomPriceType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="MealPlan" type="{http://www.opentravel.org/OTA/2003/05}MealPlanCode" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}OccupancyGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FacilityChoicesType", propOrder = {
        "availableRooms",
        "availableMealPlans",
        "roomPrices"
})
public class FacilityChoicesType {

    @XmlElement(name = "AvailableRooms")
    private AvailableRooms availableRooms;
    @XmlElement(name = "AvailableMealPlans")
    private AvailableMealPlans availableMealPlans;
    @XmlElement(name = "RoomPrices")
    private List<RoomPrices> roomPrices;
    @XmlAttribute(name = "MinOccupancy")
    private Integer minOccupancy;
    @XmlAttribute(name = "MaxOccupancy")
    private Integer maxOccupancy;

    /**
     * Gets the value of the availableRooms property.
     *
     * @return possible object is
     * {@link AvailableRooms }
     */
    public AvailableRooms getAvailableRooms() {
        return availableRooms;
    }

    /**
     * Sets the value of the availableRooms property.
     *
     * @param value allowed object is
     *              {@link AvailableRooms }
     */
    public void setAvailableRooms(AvailableRooms value) {
        this.availableRooms = value;
    }

    /**
     * Gets the value of the availableMealPlans property.
     *
     * @return possible object is
     * {@link AvailableMealPlans }
     */
    public AvailableMealPlans getAvailableMealPlans() {
        return availableMealPlans;
    }

    /**
     * Sets the value of the availableMealPlans property.
     *
     * @param value allowed object is
     *              {@link AvailableMealPlans }
     */
    public void setAvailableMealPlans(AvailableMealPlans value) {
        this.availableMealPlans = value;
    }

    /**
     * Gets the value of the roomPrices property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomPrices property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomPrices().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomPrices }
     */
    public List<RoomPrices> getRoomPrices() {
        if (roomPrices == null) {
            roomPrices = new ArrayList<>();
        }
        return this.roomPrices;
    }

    /**
     * Gets the value of the minOccupancy property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMinOccupancy() {
        return minOccupancy;
    }

    /**
     * Sets the value of the minOccupancy property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMinOccupancy(Integer value) {
        this.minOccupancy = value;
    }

    /**
     * Gets the value of the maxOccupancy property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMaxOccupancy() {
        return maxOccupancy;
    }

    /**
     * Sets the value of the maxOccupancy property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxOccupancy(Integer value) {
        this.maxOccupancy = value;
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
    public static class AvailableMealPlans {

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
     *         &lt;element name="Room" type="{http://www.opentravel.org/OTA/2003/05}PkgRoomInventoryType" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "room"
    })
    public static class AvailableRooms {

        @XmlElement(name = "Room", required = true)
        List<PkgRoomInventoryType> room;

        /**
         * Gets the value of the room property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the room property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRoom().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PkgRoomInventoryType }
         */
        public List<PkgRoomInventoryType> getRoom() {
            if (room == null) {
                room = new ArrayList<>();
            }
            return this.room;
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
     *         &lt;element name="RoomPrice" type="{http://www.opentravel.org/OTA/2003/05}RoomPriceType" maxOccurs="99"/>
     *       &lt;/sequence>
     *       &lt;attribute name="MealPlan" type="{http://www.opentravel.org/OTA/2003/05}MealPlanCode" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "roomPrice"
    })
    public static class RoomPrices {

        @XmlElement(name = "RoomPrice", required = true)
        List<RoomPriceType> roomPrice;
        @XmlAttribute(name = "MealPlan")
        String mealPlan;

        /**
         * Gets the value of the roomPrice property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the roomPrice property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRoomPrice().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link RoomPriceType }
         */
        public List<RoomPriceType> getRoomPrice() {
            if (roomPrice == null) {
                roomPrice = new ArrayList<>();
            }
            return this.roomPrice;
        }

        /**
         * Gets the value of the mealPlan property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getMealPlan() {
            return mealPlan;
        }

        /**
         * Sets the value of the mealPlan property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setMealPlan(String value) {
            this.mealPlan = value;
        }

    }

}
