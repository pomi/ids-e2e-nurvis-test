//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:45 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.request;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Identification about a specific credit card
 * <p>
 * <p>Java class for PaymentCardType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PaymentCardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CardHolderName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" minOccurs="0"/>
 *         &lt;element name="CardIssuerName" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}IssuerNameGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Address" type="{http://www.opentravel.org/OTA/2003/05}AddressType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PaymentCardDateGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PrivacyGroup"/>
 *       &lt;attribute name="CardType" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="CardCode" type="{http://www.opentravel.org/OTA/2003/05}PaymentCardCodeType" />
 *       &lt;attribute name="CardNumber" type="{http://www.opentravel.org/OTA/2003/05}NumericStringLength1to19" />
 *       &lt;attribute name="SeriesCode" type="{http://www.opentravel.org/OTA/2003/05}NumericStringLength1to8" />
 *       &lt;attribute name="MaskedCardNumber" type="{http://www.opentravel.org/OTA/2003/05}AlphaNumericStringLength1to19" />
 *       &lt;attribute name="CardHolderRPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="ExtendPaymentIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentCardType", propOrder = {
        "cardHolderName",
        "cardIssuerName",
        "address"
})
public class PaymentCardType {

    @XmlElement(name = "CardHolderName")
    private String cardHolderName;
    @XmlElement(name = "CardIssuerName")
    private CardIssuerName cardIssuerName;
    @XmlElement(name = "Address")
    private AddressType address;
    @XmlAttribute(name = "CardType")
    private String cardType;
    @XmlAttribute(name = "CardCode")
    private String cardCode;
    @XmlAttribute(name = "CardNumber")
    private String cardNumber;
    @XmlAttribute(name = "SeriesCode")
    private String seriesCode;
    @XmlAttribute(name = "MaskedCardNumber")
    private String maskedCardNumber;
    @XmlAttribute(name = "CardHolderRPH")
    private String cardHolderRPH;
    @XmlAttribute(name = "ExtendPaymentIndicator")
    private Boolean extendPaymentIndicator;
    @XmlAttribute(name = "EffectiveDate")
    private String effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    private String expireDate;
    @XmlAttribute(name = "ShareSynchInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareMarketInd;

    /**
     * Gets the value of the cardHolderName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCardHolderName() {
        return cardHolderName;
    }

    /**
     * Sets the value of the cardHolderName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardHolderName(String value) {
        this.cardHolderName = value;
    }

    /**
     * Gets the value of the cardIssuerName property.
     *
     * @return possible object is
     * {@link CardIssuerName }
     */
    public CardIssuerName getCardIssuerName() {
        return cardIssuerName;
    }

    /**
     * Sets the value of the cardIssuerName property.
     *
     * @param value allowed object is
     *              {@link CardIssuerName }
     */
    public void setCardIssuerName(CardIssuerName value) {
        this.cardIssuerName = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     * {@link AddressType }
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link AddressType }
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the cardType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * Sets the value of the cardType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardType(String value) {
        this.cardType = value;
    }

    /**
     * Gets the value of the cardCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * Sets the value of the cardCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardCode(String value) {
        this.cardCode = value;
    }

    /**
     * Gets the value of the cardNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the seriesCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSeriesCode() {
        return seriesCode;
    }

    /**
     * Sets the value of the seriesCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSeriesCode(String value) {
        this.seriesCode = value;
    }

    /**
     * Gets the value of the maskedCardNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMaskedCardNumber() {
        return maskedCardNumber;
    }

    /**
     * Sets the value of the maskedCardNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMaskedCardNumber(String value) {
        this.maskedCardNumber = value;
    }

    /**
     * Gets the value of the cardHolderRPH property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCardHolderRPH() {
        return cardHolderRPH;
    }

    /**
     * Sets the value of the cardHolderRPH property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCardHolderRPH(String value) {
        this.cardHolderRPH = value;
    }

    /**
     * Gets the value of the extendPaymentIndicator property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isExtendPaymentIndicator() {
        return extendPaymentIndicator;
    }

    /**
     * Sets the value of the extendPaymentIndicator property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setExtendPaymentIndicator(Boolean value) {
        this.extendPaymentIndicator = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expireDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setExpireDate(String value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the shareSynchInd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShareSynchInd() {
        return shareSynchInd;
    }

    /**
     * Sets the value of the shareSynchInd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShareSynchInd(String value) {
        this.shareSynchInd = value;
    }

    /**
     * Gets the value of the shareMarketInd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShareMarketInd() {
        return shareMarketInd;
    }

    /**
     * Sets the value of the shareMarketInd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShareMarketInd(String value) {
        this.shareMarketInd = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}IssuerNameGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CardIssuerName {

        @XmlAttribute(name = "BankID")
        String bankID;

        /**
         * Gets the value of the bankID property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBankID() {
            return bankID;
        }

        /**
         * Sets the value of the bankID property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBankID(String value) {
            this.bankID = value;
        }

    }

}
