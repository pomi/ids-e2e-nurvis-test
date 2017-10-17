//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Details of an invoice item
 * <p>
 * <p>Java class for CostingItemType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CostingItemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitCost" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="UnitPrice" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExtendedCost" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ExtendedPrice" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Commission" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}AgentCommissionGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}QuantityGroup"/>
 *       &lt;attribute name="Description" type="{http://www.opentravel.org/OTA/2003/05}ShortDescriptionType" />
 *       &lt;attribute name="InventoryItemRPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="PassengerRPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="CostBasis" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="ExtraRPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CostingItemType", propOrder = {
        "unitCost",
        "unitPrice",
        "extendedCost",
        "extendedPrice",
        "commission"
})
public class CostingItemType {

    @XmlElement(name = "UnitCost")
    private UnitCost unitCost;
    @XmlElement(name = "UnitPrice")
    private UnitPrice unitPrice;
    @XmlElement(name = "ExtendedCost")
    private ExtendedCost extendedCost;
    @XmlElement(name = "ExtendedPrice")
    private ExtendedPrice extendedPrice;
    @XmlElement(name = "Commission")
    private Commission commission;
    @XmlAttribute(name = "Description")
    private String description;
    @XmlAttribute(name = "InventoryItemRPH")
    private String inventoryItemRPH;
    @XmlAttribute(name = "PassengerRPH")
    private String passengerRPH;
    @XmlAttribute(name = "CostBasis")
    private String costBasis;
    @XmlAttribute(name = "ExtraRPH")
    private String extraRPH;
    @XmlAttribute(name = "Quantity")
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger quantity;

    /**
     * Gets the value of the unitCost property.
     *
     * @return possible object is
     * {@link UnitCost }
     */
    public UnitCost getUnitCost() {
        return unitCost;
    }

    /**
     * Sets the value of the unitCost property.
     *
     * @param value allowed object is
     *              {@link UnitCost }
     */
    public void setUnitCost(UnitCost value) {
        this.unitCost = value;
    }

    /**
     * Gets the value of the unitPrice property.
     *
     * @return possible object is
     * {@link UnitPrice }
     */
    public UnitPrice getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     *
     * @param value allowed object is
     *              {@link UnitPrice }
     */
    public void setUnitPrice(UnitPrice value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the extendedCost property.
     *
     * @return possible object is
     * {@link ExtendedCost }
     */
    public ExtendedCost getExtendedCost() {
        return extendedCost;
    }

    /**
     * Sets the value of the extendedCost property.
     *
     * @param value allowed object is
     *              {@link ExtendedCost }
     */
    public void setExtendedCost(ExtendedCost value) {
        this.extendedCost = value;
    }

    /**
     * Gets the value of the extendedPrice property.
     *
     * @return possible object is
     * {@link ExtendedPrice }
     */
    public ExtendedPrice getExtendedPrice() {
        return extendedPrice;
    }

    /**
     * Sets the value of the extendedPrice property.
     *
     * @param value allowed object is
     *              {@link ExtendedPrice }
     */
    public void setExtendedPrice(ExtendedPrice value) {
        this.extendedPrice = value;
    }

    /**
     * Gets the value of the commission property.
     *
     * @return possible object is
     * {@link Commission }
     */
    public Commission getCommission() {
        return commission;
    }

    /**
     * Sets the value of the commission property.
     *
     * @param value allowed object is
     *              {@link Commission }
     */
    public void setCommission(Commission value) {
        this.commission = value;
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
     * Gets the value of the inventoryItemRPH property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInventoryItemRPH() {
        return inventoryItemRPH;
    }

    /**
     * Sets the value of the inventoryItemRPH property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInventoryItemRPH(String value) {
        this.inventoryItemRPH = value;
    }

    /**
     * Gets the value of the passengerRPH property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPassengerRPH() {
        return passengerRPH;
    }

    /**
     * Sets the value of the passengerRPH property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPassengerRPH(String value) {
        this.passengerRPH = value;
    }

    /**
     * Gets the value of the costBasis property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCostBasis() {
        return costBasis;
    }

    /**
     * Sets the value of the costBasis property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCostBasis(String value) {
        this.costBasis = value;
    }

    /**
     * Gets the value of the extraRPH property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExtraRPH() {
        return extraRPH;
    }

    /**
     * Sets the value of the extraRPH property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExtraRPH(String value) {
        this.extraRPH = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}AgentCommissionGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Commission {

        @XmlAttribute(name = "Description")
        String description;
        @XmlAttribute(name = "Rate")
        BigDecimal rate;
        @XmlAttribute(name = "CommissionType")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        String commissionType;
        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

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
         * Gets the value of the rate property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getRate() {
            return rate;
        }

        /**
         * Sets the value of the rate property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setRate(BigDecimal value) {
            this.rate = value;
        }

        /**
         * Gets the value of the commissionType property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCommissionType() {
            return commissionType;
        }

        /**
         * Sets the value of the commissionType property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCommissionType(String value) {
            this.commissionType = value;
        }

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExtendedCost {

        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ExtendedPrice {

        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UnitCost {

        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class UnitPrice {

        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

        /**
         * Gets the value of the amount property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getAmount() {
            return amount;
        }

        /**
         * Sets the value of the amount property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setAmount(BigDecimal value) {
            this.amount = value;
        }

        /**
         * Gets the value of the currencyCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCurrencyCode() {
            return currencyCode;
        }

        /**
         * Sets the value of the currencyCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCurrencyCode(String value) {
            this.currencyCode = value;
        }

        /**
         * Gets the value of the decimalPlaces property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getDecimalPlaces() {
            return decimalPlaces;
        }

        /**
         * Sets the value of the decimalPlaces property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setDecimalPlaces(BigInteger value) {
            this.decimalPlaces = value;
        }

    }

}
