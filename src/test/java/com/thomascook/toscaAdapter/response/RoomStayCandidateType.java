//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Used to identify available room products.
 * <p>
 * <p>Java class for RoomStayCandidateType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RoomStayCandidateType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GuestCounts" type="{http://www.opentravel.org/OTA/2003/05}GuestCountType" minOccurs="0"/>
 *         &lt;element name="RoomAmenity" type="{http://www.opentravel.org/OTA/2003/05}RoomAmenityPrefType" maxOccurs="5" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}EffectiveExpireOptionalDateGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}RoomGroup"/>
 *       &lt;attribute name="RPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="RatePlanCandidateRPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="BookingCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RoomStayCandidateType", propOrder = {
        "guestCounts",
        "roomAmenity"
})
@XmlSeeAlso({
        PkgRoomInventoryType.class,
        RoomProfileType.class
})
public class RoomStayCandidateType {

    @XmlElement(name = "GuestCounts")
    private GuestCountType guestCounts;
    @XmlElement(name = "RoomAmenity")
    private List<RoomAmenityPrefType> roomAmenity;
    @XmlAttribute(name = "RPH")
    private String rph;
    @XmlAttribute(name = "RatePlanCandidateRPH")
    private String ratePlanCandidateRPH;
    @XmlAttribute(name = "BookingCode")
    private String bookingCode;
    @XmlAttribute(name = "EffectiveDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar expireDate;
    @XmlAttribute(name = "RoomType")
    private String roomType;
    @XmlAttribute(name = "RoomTypeCode")
    private String roomTypeCode;
    @XmlAttribute(name = "RoomCategory")
    private String roomCategory;
    @XmlAttribute(name = "RoomID")
    private String roomID;
    @XmlAttribute(name = "Floor")
    private Integer floor;
    @XmlAttribute(name = "InvBlockCode")
    private String invBlockCode;
    @XmlAttribute(name = "RoomLocationCode")
    private String roomLocationCode;
    @XmlAttribute(name = "RoomViewCode")
    private String roomViewCode;
    @XmlAttribute(name = "BedTypeCode")
    private String bedTypeCode;
    @XmlAttribute(name = "NonSmoking")
    private Boolean nonSmoking;
    @XmlAttribute(name = "Configuration")
    private String configuration;
    @XmlAttribute(name = "SizeMeasurement")
    private String sizeMeasurement;
    @XmlAttribute(name = "Quantity")
    private Integer quantity;
    @XmlAttribute(name = "Composite")
    private Boolean composite;
    @XmlAttribute(name = "RoomClassificationCode")
    private String roomClassificationCode;
    @XmlAttribute(name = "RoomArchitectureCode")
    private String roomArchitectureCode;
    @XmlAttribute(name = "PromotionCode")
    private String promotionCode;
    @XmlAttribute(name = "PromotionVendorCode")
    private List<String> promotionVendorCode;

    /**
     * Gets the value of the guestCounts property.
     *
     * @return possible object is
     * {@link GuestCountType }
     */
    public GuestCountType getGuestCounts() {
        return guestCounts;
    }

    /**
     * Sets the value of the guestCounts property.
     *
     * @param value allowed object is
     *              {@link GuestCountType }
     */
    public void setGuestCounts(GuestCountType value) {
        this.guestCounts = value;
    }

    /**
     * Gets the value of the roomAmenity property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the roomAmenity property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomAmenity().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RoomAmenityPrefType }
     */
    public List<RoomAmenityPrefType> getRoomAmenity() {
        if (roomAmenity == null) {
            roomAmenity = new ArrayList<>();
        }
        return this.roomAmenity;
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
     * Gets the value of the ratePlanCandidateRPH property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRatePlanCandidateRPH() {
        return ratePlanCandidateRPH;
    }

    /**
     * Sets the value of the ratePlanCandidateRPH property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRatePlanCandidateRPH(String value) {
        this.ratePlanCandidateRPH = value;
    }

    /**
     * Gets the value of the bookingCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBookingCode() {
        return bookingCode;
    }

    /**
     * Sets the value of the bookingCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBookingCode(String value) {
        this.bookingCode = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setEffectiveDate(XMLGregorianCalendar value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the roomType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the roomTypeCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    /**
     * Sets the value of the roomTypeCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomTypeCode(String value) {
        this.roomTypeCode = value;
    }

    /**
     * Gets the value of the roomCategory property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomCategory() {
        return roomCategory;
    }

    /**
     * Sets the value of the roomCategory property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomCategory(String value) {
        this.roomCategory = value;
    }

    /**
     * Gets the value of the roomID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomID() {
        return roomID;
    }

    /**
     * Sets the value of the roomID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomID(String value) {
        this.roomID = value;
    }

    /**
     * Gets the value of the floor property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setFloor(Integer value) {
        this.floor = value;
    }

    /**
     * Gets the value of the invBlockCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInvBlockCode() {
        return invBlockCode;
    }

    /**
     * Sets the value of the invBlockCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInvBlockCode(String value) {
        this.invBlockCode = value;
    }

    /**
     * Gets the value of the roomLocationCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomLocationCode() {
        return roomLocationCode;
    }

    /**
     * Sets the value of the roomLocationCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomLocationCode(String value) {
        this.roomLocationCode = value;
    }

    /**
     * Gets the value of the roomViewCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomViewCode() {
        return roomViewCode;
    }

    /**
     * Sets the value of the roomViewCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomViewCode(String value) {
        this.roomViewCode = value;
    }

    /**
     * Gets the value of the bedTypeCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBedTypeCode() {
        return bedTypeCode;
    }

    /**
     * Sets the value of the bedTypeCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBedTypeCode(String value) {
        this.bedTypeCode = value;
    }

    /**
     * Gets the value of the nonSmoking property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isNonSmoking() {
        return nonSmoking;
    }

    /**
     * Sets the value of the nonSmoking property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setNonSmoking(Boolean value) {
        this.nonSmoking = value;
    }

    /**
     * Gets the value of the configuration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * Sets the value of the configuration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setConfiguration(String value) {
        this.configuration = value;
    }

    /**
     * Gets the value of the sizeMeasurement property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSizeMeasurement() {
        return sizeMeasurement;
    }

    /**
     * Sets the value of the sizeMeasurement property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSizeMeasurement(String value) {
        this.sizeMeasurement = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the composite property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isComposite() {
        return composite;
    }

    /**
     * Sets the value of the composite property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setComposite(Boolean value) {
        this.composite = value;
    }

    /**
     * Gets the value of the roomClassificationCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomClassificationCode() {
        return roomClassificationCode;
    }

    /**
     * Sets the value of the roomClassificationCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomClassificationCode(String value) {
        this.roomClassificationCode = value;
    }

    /**
     * Gets the value of the roomArchitectureCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRoomArchitectureCode() {
        return roomArchitectureCode;
    }

    /**
     * Sets the value of the roomArchitectureCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRoomArchitectureCode(String value) {
        this.roomArchitectureCode = value;
    }

    /**
     * Gets the value of the promotionCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPromotionCode() {
        return promotionCode;
    }

    /**
     * Sets the value of the promotionCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPromotionCode(String value) {
        this.promotionCode = value;
    }

    /**
     * Gets the value of the promotionVendorCode property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the promotionVendorCode property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPromotionVendorCode().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getPromotionVendorCode() {
        if (promotionVendorCode == null) {
            promotionVendorCode = new ArrayList<>();
        }
        return this.promotionVendorCode;
    }

}
