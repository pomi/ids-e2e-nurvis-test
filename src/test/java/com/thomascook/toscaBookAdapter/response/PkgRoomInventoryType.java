//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:47 PM EEST 
//


package com.thomascook.toscaBookAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Describes a type of room/cabin/apartment etc.
 * <p>
 * <p>Java class for PkgRoomInventoryType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkgRoomInventoryType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}RoomStayCandidateType">
 *       &lt;sequence>
 *         &lt;element name="SupplementCharges" type="{http://www.opentravel.org/OTA/2003/05}ChargesType" maxOccurs="2" minOccurs="0"/>
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
@XmlType(name = "PkgRoomInventoryType", propOrder = {
        "supplementCharges"
})
public class PkgRoomInventoryType
        extends RoomStayCandidateType {

    @XmlElement(name = "SupplementCharges")
    private List<ChargesType> supplementCharges;
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
     * Gets the value of the supplementCharges property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supplementCharges property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupplementCharges().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargesType }
     */
    public List<ChargesType> getSupplementCharges() {
        if (supplementCharges == null) {
            supplementCharges = new ArrayList<>();
        }
        return this.supplementCharges;
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

}
