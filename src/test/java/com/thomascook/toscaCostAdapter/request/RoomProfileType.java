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
 * Describes the occupancy of a room or cabin.
 * <p>
 * <p>Java class for RoomProfileType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RoomProfileType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}RoomStayCandidateType">
 *       &lt;sequence>
 *         &lt;element name="PassengerRPHs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ListOfPassengerRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}OccupancyGroup"/>
 *       &lt;attribute name="Description" type="{http://www.opentravel.org/OTA/2003/05}ShortDescriptionType" />
 *       &lt;attribute name="MaxAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="CotQuantity" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to4" />
 *       &lt;attribute name="FreeChildFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomProfileType", propOrder = {
        "passengerRPHs"
})
@XmlSeeAlso({
        com.thomascook.toscaCostAdapter.request.ItineraryItemResponseType.Accommodation.RoomProfiles.RoomProfile.class
})
public class RoomProfileType
        extends RoomStayCandidateType {

    @XmlElement(name = "PassengerRPHs")
    private PassengerRPHs passengerRPHs;
    @XmlAttribute(name = "Description")
    private String description;
    @XmlAttribute(name = "MaxAdults")
    private Integer maxAdults;
    @XmlAttribute(name = "CotQuantity")
    private Integer cotQuantity;
    @XmlAttribute(name = "FreeChildFlag")
    private Boolean freeChildFlag;
    @XmlAttribute(name = "MinOccupancy")
    private Integer minOccupancy;
    @XmlAttribute(name = "MaxOccupancy")
    private Integer maxOccupancy;

    /**
     * Gets the value of the passengerRPHs property.
     *
     * @return possible object is
     * {@link PassengerRPHs }
     */
    public PassengerRPHs getPassengerRPHs() {
        return passengerRPHs;
    }

    /**
     * Sets the value of the passengerRPHs property.
     *
     * @param value allowed object is
     *              {@link PassengerRPHs }
     */
    public void setPassengerRPHs(PassengerRPHs value) {
        this.passengerRPHs = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the maxAdults property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getMaxAdults() {
        return maxAdults;
    }

    /**
     * Sets the value of the maxAdults property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setMaxAdults(Integer value) {
        this.maxAdults = value;
    }

    /**
     * Gets the value of the cotQuantity property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getCotQuantity() {
        return cotQuantity;
    }

    /**
     * Sets the value of the cotQuantity property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setCotQuantity(Integer value) {
        this.cotQuantity = value;
    }

    /**
     * Gets the value of the freeChildFlag property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isFreeChildFlag() {
        return freeChildFlag;
    }

    /**
     * Sets the value of the freeChildFlag property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setFreeChildFlag(Boolean value) {
        this.freeChildFlag = value;
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
     *       &lt;attribute name="ListOfPassengerRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PassengerRPHs {

        @XmlAttribute(name = "ListOfPassengerRPH")
        List<String> listOfPassengerRPH;

        /**
         * Gets the value of the listOfPassengerRPH property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the listOfPassengerRPH property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getListOfPassengerRPH().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getListOfPassengerRPH() {
            if (listOfPassengerRPH == null) {
                listOfPassengerRPH = new ArrayList<>();
            }
            return this.listOfPassengerRPH;
        }

    }

}
