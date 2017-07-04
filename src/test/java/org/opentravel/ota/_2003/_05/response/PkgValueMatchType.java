//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 06:35:24 PM EEST 
//


package org.opentravel.ota._2003._05.response;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 A package satisfying a
 *                 single room request.
 *             
 * 
 * <p>Java class for PkgValueMatchType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PkgValueMatchType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ScoreValues" type="{http://www.opentravel.org/OTA/2003/05}ScoreValuesType" minOccurs="0"/>
 *         &lt;element name="PriceInfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PriceBreakdown" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
 *                             &lt;element name="ChildPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" maxOccurs="2" minOccurs="0"/>
 *                             &lt;element name="InfantPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                           &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PriceDataGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="RoomAvailabilities" type="{http://www.opentravel.org/OTA/2003/05}AvailabilitySearchResponseType" minOccurs="0"/>
 *         &lt;element name="Stunts" type="{http://www.opentravel.org/OTA/2003/05}StuntsType" minOccurs="0"/>
 *         &lt;element name="BookingID" type="{http://www.opentravel.org/OTA/2003/05}BookingIDType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="PkgID" use="required" type="{http://www.opentravel.org/OTA/2003/05}PackageID_RefType" />
 *       &lt;attribute name="FoundPAX" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to999" />
 *       &lt;attribute name="PAX" use="required" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to999" />
 *       &lt;attribute name="RoomType" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="BoardType" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to99" />
 *       &lt;attribute name="MaxChildAge" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="MaxAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="MinAdults" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="MaxChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="MinChildren" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="OriginCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="AvailableRooms" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *       &lt;attribute name="PromoRoomCodeAndType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="FreeChildFlag" type="{http://www.opentravel.org/OTA/2003/05}FreeChildFlagType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkgValueMatchType", propOrder = {
    "scoreValues",
    "priceInfo",
    "roomAvailabilities",
    "stunts",
    "bookingID"
})
public class PkgValueMatchType {

    @XmlElement(name = "ScoreValues")
    protected ScoreValuesType scoreValues;
    @XmlElement(name = "PriceInfo", required = true)
    protected PriceInfo priceInfo;
    @XmlElement(name = "RoomAvailabilities")
    protected AvailabilitySearchResponseType roomAvailabilities;
    @XmlElement(name = "Stunts")
    protected StuntsType stunts;
    @XmlElement(name = "BookingID")
    protected BookingIDType bookingID;
    @XmlAttribute(name = "PkgID", required = true)
    protected String pkgID;
    @XmlAttribute(name = "FoundPAX")
    protected Integer foundPAX;
    @XmlAttribute(name = "PAX", required = true)
    protected int pax;
    @XmlAttribute(name = "RoomType")
    protected String roomType;
    @XmlAttribute(name = "BoardType")
    protected Integer boardType;
    @XmlAttribute(name = "MaxChildAge")
    protected Integer maxChildAge;
    @XmlAttribute(name = "MaxAdults")
    protected Integer maxAdults;
    @XmlAttribute(name = "MinAdults")
    protected Integer minAdults;
    @XmlAttribute(name = "MaxChildren")
    protected Integer maxChildren;
    @XmlAttribute(name = "MinChildren")
    protected Integer minChildren;
    @XmlAttribute(name = "OriginCode")
    protected String originCode;
    @XmlAttribute(name = "AvailableRooms")
    protected Integer availableRooms;
    @XmlAttribute(name = "PromoRoomCodeAndType")
    protected String promoRoomCodeAndType;
    @XmlAttribute(name = "FreeChildFlag")
    protected FreeChildFlagType freeChildFlag;

    /**
     * Gets the value of the scoreValues property.
     * 
     * @return
     *     possible object is
     *     {@link ScoreValuesType }
     *     
     */
    public ScoreValuesType getScoreValues() {
        return scoreValues;
    }

    /**
     * Sets the value of the scoreValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScoreValuesType }
     *     
     */
    public void setScoreValues(ScoreValuesType value) {
        this.scoreValues = value;
    }

    /**
     * Gets the value of the priceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PriceInfo }
     *     
     */
    public PriceInfo getPriceInfo() {
        return priceInfo;
    }

    /**
     * Sets the value of the priceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceInfo }
     *     
     */
    public void setPriceInfo(PriceInfo value) {
        this.priceInfo = value;
    }

    /**
     * Gets the value of the roomAvailabilities property.
     * 
     * @return
     *     possible object is
     *     {@link AvailabilitySearchResponseType }
     *     
     */
    public AvailabilitySearchResponseType getRoomAvailabilities() {
        return roomAvailabilities;
    }

    /**
     * Sets the value of the roomAvailabilities property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilitySearchResponseType }
     *     
     */
    public void setRoomAvailabilities(AvailabilitySearchResponseType value) {
        this.roomAvailabilities = value;
    }

    /**
     * Gets the value of the stunts property.
     * 
     * @return
     *     possible object is
     *     {@link StuntsType }
     *     
     */
    public StuntsType getStunts() {
        return stunts;
    }

    /**
     * Sets the value of the stunts property.
     * 
     * @param value
     *     allowed object is
     *     {@link StuntsType }
     *     
     */
    public void setStunts(StuntsType value) {
        this.stunts = value;
    }

    /**
     * Gets the value of the bookingID property.
     * 
     * @return
     *     possible object is
     *     {@link BookingIDType }
     *     
     */
    public BookingIDType getBookingID() {
        return bookingID;
    }

    /**
     * Sets the value of the bookingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingIDType }
     *     
     */
    public void setBookingID(BookingIDType value) {
        this.bookingID = value;
    }

    /**
     * Gets the value of the pkgID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPkgID() {
        return pkgID;
    }

    /**
     * Sets the value of the pkgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPkgID(String value) {
        this.pkgID = value;
    }

    /**
     * Gets the value of the foundPAX property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFoundPAX() {
        return foundPAX;
    }

    /**
     * Sets the value of the foundPAX property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFoundPAX(Integer value) {
        this.foundPAX = value;
    }

    /**
     * Gets the value of the pax property.
     * 
     */
    public int getPAX() {
        return pax;
    }

    /**
     * Sets the value of the pax property.
     * 
     */
    public void setPAX(int value) {
        this.pax = value;
    }

    /**
     * Gets the value of the roomType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the value of the roomType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRoomType(String value) {
        this.roomType = value;
    }

    /**
     * Gets the value of the boardType property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBoardType() {
        return boardType;
    }

    /**
     * Sets the value of the boardType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBoardType(Integer value) {
        this.boardType = value;
    }

    /**
     * Gets the value of the maxChildAge property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxChildAge() {
        return maxChildAge;
    }

    /**
     * Sets the value of the maxChildAge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxChildAge(Integer value) {
        this.maxChildAge = value;
    }

    /**
     * Gets the value of the maxAdults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxAdults() {
        return maxAdults;
    }

    /**
     * Sets the value of the maxAdults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxAdults(Integer value) {
        this.maxAdults = value;
    }

    /**
     * Gets the value of the minAdults property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinAdults() {
        return minAdults;
    }

    /**
     * Sets the value of the minAdults property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinAdults(Integer value) {
        this.minAdults = value;
    }

    /**
     * Gets the value of the maxChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxChildren() {
        return maxChildren;
    }

    /**
     * Sets the value of the maxChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxChildren(Integer value) {
        this.maxChildren = value;
    }

    /**
     * Gets the value of the minChildren property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinChildren() {
        return minChildren;
    }

    /**
     * Sets the value of the minChildren property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinChildren(Integer value) {
        this.minChildren = value;
    }

    /**
     * Gets the value of the originCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginCode() {
        return originCode;
    }

    /**
     * Sets the value of the originCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginCode(String value) {
        this.originCode = value;
    }

    /**
     * Gets the value of the availableRooms property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailableRooms() {
        return availableRooms;
    }

    /**
     * Sets the value of the availableRooms property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailableRooms(Integer value) {
        this.availableRooms = value;
    }

    /**
     * Gets the value of the promoRoomCodeAndType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPromoRoomCodeAndType() {
        return promoRoomCodeAndType;
    }

    /**
     * Sets the value of the promoRoomCodeAndType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPromoRoomCodeAndType(String value) {
        this.promoRoomCodeAndType = value;
    }

    /**
     * Gets the value of the freeChildFlag property.
     * 
     * @return
     *     possible object is
     *     {@link FreeChildFlagType }
     *     
     */
    public FreeChildFlagType getFreeChildFlag() {
        return freeChildFlag;
    }

    /**
     * Sets the value of the freeChildFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreeChildFlagType }
     *     
     */
    public void setFreeChildFlag(FreeChildFlagType value) {
        this.freeChildFlag = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="PriceBreakdown" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
     *                   &lt;element name="ChildPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" maxOccurs="2" minOccurs="0"/>
     *                   &lt;element name="InfantPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
     *                 &lt;/sequence>
     *                 &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PriceDataGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "priceBreakdown"
    })
    public static class PriceInfo {

        @XmlElement(name = "PriceBreakdown")
        protected PriceBreakdown priceBreakdown;
        @XmlAttribute(name = "Amount", required = true)
        protected BigDecimal amount;
        @XmlAttribute(name = "OriginalPrice")
        protected BigDecimal originalPrice;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        protected BigInteger decimalPlaces;

        /**
         * Gets the value of the priceBreakdown property.
         * 
         * @return
         *     possible object is
         *     {@link PriceBreakdown }
         *     
         */
        public PriceBreakdown getPriceBreakdown() {
            return priceBreakdown;
        }

        /**
         * Sets the value of the priceBreakdown property.
         * 
         * @param value
         *     allowed object is
         *     {@link PriceBreakdown }
         *     
         */
        public void setPriceBreakdown(PriceBreakdown value) {
            this.priceBreakdown = value;
        }

        /**
         * Gets the value of the amount property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the originalPrice property.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getOriginalPrice() {
            return originalPrice;
        }

        /**
         * Sets the value of the originalPrice property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setOriginalPrice(BigDecimal value) {
            this.originalPrice = value;
        }

        /**
         * Gets the value of the currencyCode property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="AdultPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
         *         &lt;element name="ChildPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" maxOccurs="2" minOccurs="0"/>
         *         &lt;element name="InfantPrice" type="{http://www.opentravel.org/OTA/2003/05}PkgPriceBreakdownType" minOccurs="0"/>
         *       &lt;/sequence>
         *       &lt;attribute name="PriceTypeIndicator" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "adultPrice",
            "childPrice",
            "infantPrice"
        })
        public static class PriceBreakdown {

            @XmlElement(name = "AdultPrice")
            protected PkgPriceBreakdownType adultPrice;
            @XmlElement(name = "ChildPrice")
            protected List<PkgPriceBreakdownType> childPrice;
            @XmlElement(name = "InfantPrice")
            protected PkgPriceBreakdownType infantPrice;
            @XmlAttribute(name = "PriceTypeIndicator")
            protected String priceTypeIndicator;

            /**
             * Gets the value of the adultPrice property.
             * 
             * @return
             *     possible object is
             *     {@link PkgPriceBreakdownType }
             *     
             */
            public PkgPriceBreakdownType getAdultPrice() {
                return adultPrice;
            }

            /**
             * Sets the value of the adultPrice property.
             * 
             * @param value
             *     allowed object is
             *     {@link PkgPriceBreakdownType }
             *     
             */
            public void setAdultPrice(PkgPriceBreakdownType value) {
                this.adultPrice = value;
            }

            /**
             * Gets the value of the childPrice property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the childPrice property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getChildPrice().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link PkgPriceBreakdownType }
             * 
             * 
             */
            public List<PkgPriceBreakdownType> getChildPrice() {
                if (childPrice == null) {
                    childPrice = new ArrayList<PkgPriceBreakdownType>();
                }
                return this.childPrice;
            }

            /**
             * Gets the value of the infantPrice property.
             * 
             * @return
             *     possible object is
             *     {@link PkgPriceBreakdownType }
             *     
             */
            public PkgPriceBreakdownType getInfantPrice() {
                return infantPrice;
            }

            /**
             * Sets the value of the infantPrice property.
             * 
             * @param value
             *     allowed object is
             *     {@link PkgPriceBreakdownType }
             *     
             */
            public void setInfantPrice(PkgPriceBreakdownType value) {
                this.infantPrice = value;
            }

            /**
             * Gets the value of the priceTypeIndicator property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPriceTypeIndicator() {
                return priceTypeIndicator;
            }

            /**
             * Sets the value of the priceTypeIndicator property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPriceTypeIndicator(String value) {
                this.priceTypeIndicator = value;
            }

        }

    }

}
