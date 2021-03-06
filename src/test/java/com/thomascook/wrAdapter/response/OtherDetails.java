//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 04:28:34 PM EEST 
//


package com.thomascook.wrAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="AccommodationDescription" type="{}fiftyCharString" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="AccommodationNumber" type="{}tenCharString" maxOccurs="3" minOccurs="0"/>
 *         &lt;element name="VehicleMake" type="{}fifteenCharString" minOccurs="0"/>
 *         &lt;element name="VehicleModel" type="{}fifteenCharString" minOccurs="0"/>
 *         &lt;element name="VehicleRegistration" type="{}eightCharString" minOccurs="0"/>
 *         &lt;element name="VehicleHeight" type="{}sixCharString" minOccurs="0"/>
 *         &lt;element name="VehicleLength" type="{}sixCharString" minOccurs="0"/>
 *         &lt;element name="TrailerHeight" type="{}sixCharString" minOccurs="0"/>
 *         &lt;element name="TrailerLength" type="{}sixCharString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "accommodationDescription",
        "accommodationNumber",
        "vehicleMake",
        "vehicleModel",
        "vehicleRegistration",
        "vehicleHeight",
        "vehicleLength",
        "trailerHeight",
        "trailerLength"
})
@XmlRootElement(name = "OtherDetails")
public class OtherDetails {

    @XmlElement(name = "AccommodationDescription")
    protected List<String> accommodationDescription;
    @XmlElement(name = "AccommodationNumber")
    protected List<String> accommodationNumber;
    @XmlElement(name = "VehicleMake")
    protected String vehicleMake;
    @XmlElement(name = "VehicleModel")
    protected String vehicleModel;
    @XmlElement(name = "VehicleRegistration")
    protected String vehicleRegistration;
    @XmlElement(name = "VehicleHeight")
    protected String vehicleHeight;
    @XmlElement(name = "VehicleLength")
    protected String vehicleLength;
    @XmlElement(name = "TrailerHeight")
    protected String trailerHeight;
    @XmlElement(name = "TrailerLength")
    protected String trailerLength;

    /**
     * Gets the value of the accommodationDescription property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationDescription property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationDescription().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAccommodationDescription() {
        if (accommodationDescription == null) {
            accommodationDescription = new ArrayList<String>();
        }
        return this.accommodationDescription;
    }

    /**
     * Gets the value of the accommodationNumber property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodationNumber property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodationNumber().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getAccommodationNumber() {
        if (accommodationNumber == null) {
            accommodationNumber = new ArrayList<String>();
        }
        return this.accommodationNumber;
    }

    /**
     * Gets the value of the vehicleMake property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVehicleMake() {
        return vehicleMake;
    }

    /**
     * Sets the value of the vehicleMake property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVehicleMake(String value) {
        this.vehicleMake = value;
    }

    /**
     * Gets the value of the vehicleModel property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVehicleModel() {
        return vehicleModel;
    }

    /**
     * Sets the value of the vehicleModel property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVehicleModel(String value) {
        this.vehicleModel = value;
    }

    /**
     * Gets the value of the vehicleRegistration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    /**
     * Sets the value of the vehicleRegistration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVehicleRegistration(String value) {
        this.vehicleRegistration = value;
    }

    /**
     * Gets the value of the vehicleHeight property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVehicleHeight() {
        return vehicleHeight;
    }

    /**
     * Sets the value of the vehicleHeight property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVehicleHeight(String value) {
        this.vehicleHeight = value;
    }

    /**
     * Gets the value of the vehicleLength property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVehicleLength() {
        return vehicleLength;
    }

    /**
     * Sets the value of the vehicleLength property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVehicleLength(String value) {
        this.vehicleLength = value;
    }

    /**
     * Gets the value of the trailerHeight property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrailerHeight() {
        return trailerHeight;
    }

    /**
     * Sets the value of the trailerHeight property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrailerHeight(String value) {
        this.trailerHeight = value;
    }

    /**
     * Gets the value of the trailerLength property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrailerLength() {
        return trailerLength;
    }

    /**
     * Sets the value of the trailerLength property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrailerLength(String value) {
        this.trailerLength = value;
    }

}
