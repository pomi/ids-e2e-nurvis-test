//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines a complete package holiday request.
 * <p>
 * <p>Java class for PackageType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PackageType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="URL" type="{http://www.opentravel.org/OTA/2003/05}URL_Type" minOccurs="0"/>
 *         &lt;element name="CompanyName" type="{http://www.opentravel.org/OTA/2003/05}CompanyNameType" minOccurs="0"/>
 *         &lt;element name="DateRange" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ItineraryItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ItineraryItem" type="{http://www.opentravel.org/OTA/2003/05}ItineraryItemRequestType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Extras" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Extra" type="{http://www.opentravel.org/OTA/2003/05}ExtrasType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="SeatRequests" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SeatRequest" type="{http://www.opentravel.org/OTA/2003/05}SeatRequestType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}ID_OptionalGroup"/>
 *       &lt;attribute name="Type" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="TravelCode" type="{http://www.opentravel.org/OTA/2003/05}PkgTravelCode" />
 *       &lt;attribute name="TourCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *       &lt;attribute name="BoardCode" type="{http://www.opentravel.org/OTA/2003/05}MealPlanCode" />
 *       &lt;attribute name="PromotionCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="FreeChildrenQuantity" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to99" />
 *       &lt;attribute name="BrandCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *       &lt;attribute name="ProductCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackageType", propOrder = {
        "url",
        "companyName",
        "dateRange",
        "itineraryItems",
        "extras",
        "seatRequests"
})
public class PackageType {

    @XmlElement(name = "URL")
    private URLType url;
    @XmlElement(name = "CompanyName")
    private CompanyNameType companyName;
    @XmlElement(name = "DateRange")
    private DateRange dateRange;
    @XmlElement(name = "ItineraryItems")
    private ItineraryItems itineraryItems;
    @XmlElement(name = "Extras")
    private Extras extras;
    @XmlElement(name = "SeatRequests")
    private SeatRequests seatRequests;
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "TravelCode")
    private String travelCode;
    @XmlAttribute(name = "TourCode")
    private String tourCode;
    @XmlAttribute(name = "BoardCode")
    private String boardCode;
    @XmlAttribute(name = "PromotionCode")
    private String promotionCode;
    @XmlAttribute(name = "FreeChildrenQuantity")
    private Integer freeChildrenQuantity;
    @XmlAttribute(name = "BrandCode")
    private String brandCode;
    @XmlAttribute(name = "ProductCode")
    private String productCode;
    @XmlAttribute(name = "ID")
    private String id;

    /**
     * Gets the value of the url property.
     *
     * @return possible object is
     * {@link URLType }
     */
    public URLType getURL() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value allowed object is
     *              {@link URLType }
     */
    public void setURL(URLType value) {
        this.url = value;
    }

    /**
     * Gets the value of the companyName property.
     *
     * @return possible object is
     * {@link CompanyNameType }
     */
    public CompanyNameType getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     *
     * @param value allowed object is
     *              {@link CompanyNameType }
     */
    public void setCompanyName(CompanyNameType value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the dateRange property.
     *
     * @return possible object is
     * {@link DateRange }
     */
    public DateRange getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     *
     * @param value allowed object is
     *              {@link DateRange }
     */
    public void setDateRange(DateRange value) {
        this.dateRange = value;
    }

    /**
     * Gets the value of the itineraryItems property.
     *
     * @return possible object is
     * {@link ItineraryItems }
     */
    public ItineraryItems getItineraryItems() {
        return itineraryItems;
    }

    /**
     * Sets the value of the itineraryItems property.
     *
     * @param value allowed object is
     *              {@link ItineraryItems }
     */
    public void setItineraryItems(ItineraryItems value) {
        this.itineraryItems = value;
    }

    /**
     * Gets the value of the extras property.
     *
     * @return possible object is
     * {@link Extras }
     */
    public Extras getExtras() {
        return extras;
    }

    /**
     * Sets the value of the extras property.
     *
     * @param value allowed object is
     *              {@link Extras }
     */
    public void setExtras(Extras value) {
        this.extras = value;
    }

    /**
     * Gets the value of the seatRequests property.
     *
     * @return possible object is
     * {@link SeatRequests }
     */
    public SeatRequests getSeatRequests() {
        return seatRequests;
    }

    /**
     * Sets the value of the seatRequests property.
     *
     * @param value allowed object is
     *              {@link SeatRequests }
     */
    public void setSeatRequests(SeatRequests value) {
        this.seatRequests = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the travelCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTravelCode() {
        return travelCode;
    }

    /**
     * Sets the value of the travelCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTravelCode(String value) {
        this.travelCode = value;
    }

    /**
     * Gets the value of the tourCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTourCode() {
        return tourCode;
    }

    /**
     * Sets the value of the tourCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTourCode(String value) {
        this.tourCode = value;
    }

    /**
     * Gets the value of the boardCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBoardCode() {
        return boardCode;
    }

    /**
     * Sets the value of the boardCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBoardCode(String value) {
        this.boardCode = value;
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
     * Gets the value of the freeChildrenQuantity property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getFreeChildrenQuantity() {
        return freeChildrenQuantity;
    }

    /**
     * Sets the value of the freeChildrenQuantity property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setFreeChildrenQuantity(Integer value) {
        this.freeChildrenQuantity = value;
    }

    /**
     * Gets the value of the brandCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrandCode() {
        return brandCode;
    }

    /**
     * Sets the value of the brandCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrandCode(String value) {
        this.brandCode = value;
    }

    /**
     * Gets the value of the productCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setID(String value) {
        this.id = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class DateRange {

        @XmlAttribute(name = "Start")
        String start;
        @XmlAttribute(name = "Duration")
        String duration;
        @XmlAttribute(name = "End")
        String end;

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
     *         &lt;element name="Extra" type="{http://www.opentravel.org/OTA/2003/05}ExtrasType" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "extra"
    })
    public static class Extras {

        @XmlElement(name = "Extra", required = true)
        List<ExtrasType> extra;

        /**
         * Gets the value of the extra property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the extra property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExtra().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExtrasType }
         */
        public List<ExtrasType> getExtra() {
            if (extra == null) {
                extra = new ArrayList<>();
            }
            return this.extra;
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
     *         &lt;element name="ItineraryItem" type="{http://www.opentravel.org/OTA/2003/05}ItineraryItemRequestType" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "itineraryItem"
    })
    public static class ItineraryItems {

        @XmlElement(name = "ItineraryItem", required = true)
        List<ItineraryItemRequestType> itineraryItem;

        /**
         * Gets the value of the itineraryItem property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the itineraryItem property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItineraryItem().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ItineraryItemRequestType }
         */
        public List<ItineraryItemRequestType> getItineraryItem() {
            if (itineraryItem == null) {
                itineraryItem = new ArrayList<>();
            }
            return this.itineraryItem;
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
     *         &lt;element name="SeatRequest" type="{http://www.opentravel.org/OTA/2003/05}SeatRequestType" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "seatRequest"
    })
    public static class SeatRequests {

        @XmlElement(name = "SeatRequest", required = true)
        List<SeatRequestType> seatRequest;

        /**
         * Gets the value of the seatRequest property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the seatRequest property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSeatRequest().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link SeatRequestType }
         */
        public List<SeatRequestType> getSeatRequest() {
            if (seatRequest == null) {
                seatRequest = new ArrayList<>();
            }
            return this.seatRequest;
        }

    }

}
