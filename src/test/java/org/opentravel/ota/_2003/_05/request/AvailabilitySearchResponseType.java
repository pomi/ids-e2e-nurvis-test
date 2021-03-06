//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package org.opentravel.ota._2003._05.request;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The list of available
 * values of fields. It is similar to facet calculation but no actual
 * counts are calculated
 * only the fact whether there are any packages
 * left where the field contains a specific value. In other words it
 * gives the list of values a field can be
 * filtered for (in addition to
 * the actual filtering) to get at least one matching package in the
 * response. (Same as facets with count > 0.)
 * <p>
 * <p>
 * <p>Java class for AvailabilitySearchResponseType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="AvailabilitySearchResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Availability" maxOccurs="99" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AvailableValue" maxOccurs="99">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="BoardBasis" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="PkgId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="FreeChildFlag" type="{http://www.opentravel.org/OTA/2003/05}FreeChildFlagType" />
 *                           &lt;attribute name="Price" type="{http://www.opentravel.org/OTA/2003/05}Money" />
 *                           &lt;attribute name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
 *                           &lt;attribute name="OriginalPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
 *                           &lt;attribute name="MaxAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="MinAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="MaxChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="MinChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="AvailableRooms" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *                           &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AvailabilitySearchResponseType", propOrder = {
        "availability"
})
public class AvailabilitySearchResponseType {

    @XmlElement(name = "Availability")
    private List<Availability> availability;

    /**
     * Gets the value of the availability property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availability property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailability().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Availability }
     */
    public List<Availability> getAvailability() {
        if (availability == null) {
            availability = new ArrayList<>();
        }
        return this.availability;
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
     *         &lt;element name="AvailableValue" maxOccurs="99">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="BoardBasis" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="PkgId" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="FreeChildFlag" type="{http://www.opentravel.org/OTA/2003/05}FreeChildFlagType" />
     *                 &lt;attribute name="Price" type="{http://www.opentravel.org/OTA/2003/05}Money" />
     *                 &lt;attribute name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
     *                 &lt;attribute name="OriginalPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
     *                 &lt;attribute name="MaxAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="MinAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="MaxChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="MinChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="AvailableRooms" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
     *                 &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "availableValue"
    })
    public static class Availability {

        @XmlElement(name = "AvailableValue", required = true)
        List<AvailableValue> availableValue;
        @XmlAttribute(name = "Name")
        String name;

        /**
         * Gets the value of the availableValue property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the availableValue property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAvailableValue().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link AvailableValue }
         */
        public List<AvailableValue> getAvailableValue() {
            if (availableValue == null) {
                availableValue = new ArrayList<>();
            }
            return this.availableValue;
        }

        /**
         * Gets the value of the name property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setName(String value) {
            this.name = value;
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
         *       &lt;attribute name="Value" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="RoomType" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="BoardBasis" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="PkgId" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="FreeChildFlag" type="{http://www.opentravel.org/OTA/2003/05}FreeChildFlagType" />
         *       &lt;attribute name="Price" type="{http://www.opentravel.org/OTA/2003/05}Money" />
         *       &lt;attribute name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
         *       &lt;attribute name="OriginalPrice" type="{http://www.opentravel.org/OTA/2003/05}Money" />
         *       &lt;attribute name="MaxAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="MinAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="MaxChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="MinChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="AvailableRooms" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
         *       &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class AvailableValue {

            @XmlAttribute(name = "Value")
            String value;
            @XmlAttribute(name = "RoomType")
            String roomType;
            @XmlAttribute(name = "BoardBasis")
            Integer boardBasis;
            @XmlAttribute(name = "PkgId")
            String pkgId;
            @XmlAttribute(name = "FreeChildFlag")
            FreeChildFlagType freeChildFlag;
            @XmlAttribute(name = "Price")
            BigDecimal price;
            @XmlAttribute(name = "AdultPrice")
            BigDecimal adultPrice;
            @XmlAttribute(name = "OriginalPrice")
            BigDecimal originalPrice;
            @XmlAttribute(name = "MaxAdults")
            Integer maxAdults;
            @XmlAttribute(name = "MinAdults")
            Integer minAdults;
            @XmlAttribute(name = "MaxChildren")
            Integer maxChildren;
            @XmlAttribute(name = "MinChildren")
            Integer minChildren;
            @XmlAttribute(name = "AvailableRooms")
            Integer availableRooms;
            @XmlAttribute(name = "PriceTypeIndicator")
            String priceTypeIndicator;

            /**
             * Gets the value of the value property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setValue(String value) {
                this.value = value;
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
             * Gets the value of the boardBasis property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getBoardBasis() {
                return boardBasis;
            }

            /**
             * Sets the value of the boardBasis property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setBoardBasis(Integer value) {
                this.boardBasis = value;
            }

            /**
             * Gets the value of the pkgId property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getPkgId() {
                return pkgId;
            }

            /**
             * Sets the value of the pkgId property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setPkgId(String value) {
                this.pkgId = value;
            }

            /**
             * Gets the value of the freeChildFlag property.
             *
             * @return possible object is
             * {@link FreeChildFlagType }
             */
            public FreeChildFlagType getFreeChildFlag() {
                return freeChildFlag;
            }

            /**
             * Sets the value of the freeChildFlag property.
             *
             * @param value allowed object is
             *              {@link FreeChildFlagType }
             */
            public void setFreeChildFlag(FreeChildFlagType value) {
                this.freeChildFlag = value;
            }

            /**
             * Gets the value of the price property.
             *
             * @return possible object is
             * {@link BigDecimal }
             */
            public BigDecimal getPrice() {
                return price;
            }

            /**
             * Sets the value of the price property.
             *
             * @param value allowed object is
             *              {@link BigDecimal }
             */
            public void setPrice(BigDecimal value) {
                this.price = value;
            }

            /**
             * Gets the value of the adultPrice property.
             *
             * @return possible object is
             * {@link BigDecimal }
             */
            public BigDecimal getAdultPrice() {
                return adultPrice;
            }

            /**
             * Sets the value of the adultPrice property.
             *
             * @param value allowed object is
             *              {@link BigDecimal }
             */
            public void setAdultPrice(BigDecimal value) {
                this.adultPrice = value;
            }

            /**
             * Gets the value of the originalPrice property.
             *
             * @return possible object is
             * {@link BigDecimal }
             */
            public BigDecimal getOriginalPrice() {
                return originalPrice;
            }

            /**
             * Sets the value of the originalPrice property.
             *
             * @param value allowed object is
             *              {@link BigDecimal }
             */
            public void setOriginalPrice(BigDecimal value) {
                this.originalPrice = value;
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
             * Gets the value of the minAdults property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getMinAdults() {
                return minAdults;
            }

            /**
             * Sets the value of the minAdults property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setMinAdults(Integer value) {
                this.minAdults = value;
            }

            /**
             * Gets the value of the maxChildren property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getMaxChildren() {
                return maxChildren;
            }

            /**
             * Sets the value of the maxChildren property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setMaxChildren(Integer value) {
                this.maxChildren = value;
            }

            /**
             * Gets the value of the minChildren property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getMinChildren() {
                return minChildren;
            }

            /**
             * Sets the value of the minChildren property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setMinChildren(Integer value) {
                this.minChildren = value;
            }

            /**
             * Gets the value of the availableRooms property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getAvailableRooms() {
                return availableRooms;
            }

            /**
             * Sets the value of the availableRooms property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setAvailableRooms(Integer value) {
                this.availableRooms = value;
            }

            /**
             * Gets the value of the priceTypeIndicator property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getPriceTypeIndicator() {
                return priceTypeIndicator;
            }

            /**
             * Sets the value of the priceTypeIndicator property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setPriceTypeIndicator(String value) {
                this.priceTypeIndicator = value;
            }

        }

    }

}
