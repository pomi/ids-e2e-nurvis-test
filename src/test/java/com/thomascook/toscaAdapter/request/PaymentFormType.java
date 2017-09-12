//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:45 AM EEST 
//


package com.thomascook.toscaAdapter.request;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Ways of providing funds for travel by the individual.
 * <p>
 * <p>Java class for PaymentFormType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PaymentFormType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice minOccurs="0">
 *         &lt;element name="PaymentCard" type="{http://www.opentravel.org/OTA/2003/05}PaymentCardType"/>
 *         &lt;element name="BankAcct" type="{http://www.opentravel.org/OTA/2003/05}BankAcctType"/>
 *         &lt;element name="DirectBill" type="{http://www.opentravel.org/OTA/2003/05}DirectBillType"/>
 *         &lt;element name="Voucher">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}VoucherGroup"/>
 *                 &lt;attribute name="BillingNumber" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *                 &lt;attribute name="SupplierIdentifier" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *                 &lt;attribute name="Identifier" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *                 &lt;attribute name="ValueType" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
 *                 &lt;attribute name="ElectronicIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="LoyaltyRedemption">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="LoyaltyCertificate" maxOccurs="9" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}LoyaltyCertificateGroup"/>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PromotionCodeGroup"/>
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}LoyaltyCertificateNumberGroup"/>
 *                 &lt;attribute name="RedemptionQuantity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="MiscChargeOrder">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="TicketNumber" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Cash">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="CashIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PrivacyGroup"/>
 *       &lt;attribute name="CostCenterID" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
 *       &lt;attribute name="RPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="PaymentTransactionTypeCode">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="charge"/>
 *             &lt;enumeration value="reserve"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentFormType", propOrder = {
        "paymentCard",
        "bankAcct",
        "directBill",
        "voucher",
        "loyaltyRedemption",
        "miscChargeOrder",
        "cash"
})
@XmlSeeAlso({
        PaymentDetailType.class
})
public class PaymentFormType {

    @XmlElement(name = "PaymentCard")
    private PaymentCardType paymentCard;
    @XmlElement(name = "BankAcct")
    private BankAcctType bankAcct;
    @XmlElement(name = "DirectBill")
    private DirectBillType directBill;
    @XmlElement(name = "Voucher")
    private Voucher voucher;
    @XmlElement(name = "LoyaltyRedemption")
    private LoyaltyRedemption loyaltyRedemption;
    @XmlElement(name = "MiscChargeOrder")
    private MiscChargeOrder miscChargeOrder;
    @XmlElement(name = "Cash")
    private Cash cash;
    @XmlAttribute(name = "CostCenterID")
    private String costCenterID;
    @XmlAttribute(name = "RPH")
    private String rph;
    @XmlAttribute(name = "PaymentTransactionTypeCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String paymentTransactionTypeCode;
    @XmlAttribute(name = "ShareSynchInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareMarketInd;

    /**
     * Gets the value of the paymentCard property.
     *
     * @return possible object is
     * {@link PaymentCardType }
     */
    public PaymentCardType getPaymentCard() {
        return paymentCard;
    }

    /**
     * Sets the value of the paymentCard property.
     *
     * @param value allowed object is
     *              {@link PaymentCardType }
     */
    public void setPaymentCard(PaymentCardType value) {
        this.paymentCard = value;
    }

    /**
     * Gets the value of the bankAcct property.
     *
     * @return possible object is
     * {@link BankAcctType }
     */
    public BankAcctType getBankAcct() {
        return bankAcct;
    }

    /**
     * Sets the value of the bankAcct property.
     *
     * @param value allowed object is
     *              {@link BankAcctType }
     */
    public void setBankAcct(BankAcctType value) {
        this.bankAcct = value;
    }

    /**
     * Gets the value of the directBill property.
     *
     * @return possible object is
     * {@link DirectBillType }
     */
    public DirectBillType getDirectBill() {
        return directBill;
    }

    /**
     * Sets the value of the directBill property.
     *
     * @param value allowed object is
     *              {@link DirectBillType }
     */
    public void setDirectBill(DirectBillType value) {
        this.directBill = value;
    }

    /**
     * Gets the value of the voucher property.
     *
     * @return possible object is
     * {@link Voucher }
     */
    public Voucher getVoucher() {
        return voucher;
    }

    /**
     * Sets the value of the voucher property.
     *
     * @param value allowed object is
     *              {@link Voucher }
     */
    public void setVoucher(Voucher value) {
        this.voucher = value;
    }

    /**
     * Gets the value of the loyaltyRedemption property.
     *
     * @return possible object is
     * {@link LoyaltyRedemption }
     */
    public LoyaltyRedemption getLoyaltyRedemption() {
        return loyaltyRedemption;
    }

    /**
     * Sets the value of the loyaltyRedemption property.
     *
     * @param value allowed object is
     *              {@link LoyaltyRedemption }
     */
    public void setLoyaltyRedemption(LoyaltyRedemption value) {
        this.loyaltyRedemption = value;
    }

    /**
     * Gets the value of the miscChargeOrder property.
     *
     * @return possible object is
     * {@link MiscChargeOrder }
     */
    public MiscChargeOrder getMiscChargeOrder() {
        return miscChargeOrder;
    }

    /**
     * Sets the value of the miscChargeOrder property.
     *
     * @param value allowed object is
     *              {@link MiscChargeOrder }
     */
    public void setMiscChargeOrder(MiscChargeOrder value) {
        this.miscChargeOrder = value;
    }

    /**
     * Gets the value of the cash property.
     *
     * @return possible object is
     * {@link Cash }
     */
    public Cash getCash() {
        return cash;
    }

    /**
     * Sets the value of the cash property.
     *
     * @param value allowed object is
     *              {@link Cash }
     */
    public void setCash(Cash value) {
        this.cash = value;
    }

    /**
     * Gets the value of the costCenterID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCostCenterID() {
        return costCenterID;
    }

    /**
     * Sets the value of the costCenterID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCostCenterID(String value) {
        this.costCenterID = value;
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
     * Gets the value of the paymentTransactionTypeCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPaymentTransactionTypeCode() {
        return paymentTransactionTypeCode;
    }

    /**
     * Sets the value of the paymentTransactionTypeCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPaymentTransactionTypeCode(String value) {
        this.paymentTransactionTypeCode = value;
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
     *       &lt;attribute name="CashIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Cash {

        @XmlAttribute(name = "CashIndicator")
        Boolean cashIndicator;

        /**
         * Gets the value of the cashIndicator property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public boolean isCashIndicator() {
            if (cashIndicator == null) {
                return true;
            } else {
                return cashIndicator;
            }
        }

        /**
         * Sets the value of the cashIndicator property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setCashIndicator(Boolean value) {
            this.cashIndicator = value;
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
     *         &lt;element name="LoyaltyCertificate" maxOccurs="9" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}LoyaltyCertificateGroup"/>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PromotionCodeGroup"/>
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}LoyaltyCertificateNumberGroup"/>
     *       &lt;attribute name="RedemptionQuantity" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "loyaltyCertificate"
    })
    public static class LoyaltyRedemption {

        @XmlElement(name = "LoyaltyCertificate")
        List<LoyaltyCertificate> loyaltyCertificate;
        @XmlAttribute(name = "RedemptionQuantity")
        @XmlSchemaType(name = "positiveInteger")
        BigInteger redemptionQuantity;
        @XmlAttribute(name = "PromotionCode")
        String promotionCode;
        @XmlAttribute(name = "PromotionVendorCode")
        List<String> promotionVendorCode;
        @XmlAttribute(name = "CertificateNumber")
        String certificateNumber;
        @XmlAttribute(name = "MemberNumber")
        String memberNumber;
        @XmlAttribute(name = "ProgramName")
        String programName;

        /**
         * Gets the value of the loyaltyCertificate property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the loyaltyCertificate property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLoyaltyCertificate().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LoyaltyCertificate }
         */
        public List<LoyaltyCertificate> getLoyaltyCertificate() {
            if (loyaltyCertificate == null) {
                loyaltyCertificate = new ArrayList<>();
            }
            return this.loyaltyCertificate;
        }

        /**
         * Gets the value of the redemptionQuantity property.
         *
         * @return possible object is
         * {@link BigInteger }
         */
        public BigInteger getRedemptionQuantity() {
            return redemptionQuantity;
        }

        /**
         * Sets the value of the redemptionQuantity property.
         *
         * @param value allowed object is
         *              {@link BigInteger }
         */
        public void setRedemptionQuantity(BigInteger value) {
            this.redemptionQuantity = value;
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

        /**
         * Gets the value of the certificateNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCertificateNumber() {
            return certificateNumber;
        }

        /**
         * Sets the value of the certificateNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCertificateNumber(String value) {
            this.certificateNumber = value;
        }

        /**
         * Gets the value of the memberNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getMemberNumber() {
            return memberNumber;
        }

        /**
         * Sets the value of the memberNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setMemberNumber(String value) {
            this.memberNumber = value;
        }

        /**
         * Gets the value of the programName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getProgramName() {
            return programName;
        }

        /**
         * Sets the value of the programName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setProgramName(String value) {
            this.programName = value;
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
         *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}LoyaltyCertificateGroup"/>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class LoyaltyCertificate {

            @XmlAttribute(name = "ID_Context")
            String idContext;
            @XmlAttribute(name = "NmbrOfNights")
            @XmlSchemaType(name = "nonNegativeInteger")
            BigInteger nmbrOfNights;
            @XmlAttribute(name = "Format")
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            String format;
            @XmlAttribute(name = "Status")
            String status;
            @XmlAttribute(name = "ID")
            String id;
            @XmlAttribute(name = "EffectiveDate")
            @XmlSchemaType(name = "date")
            XMLGregorianCalendar effectiveDate;
            @XmlAttribute(name = "ExpireDate")
            @XmlSchemaType(name = "date")
            XMLGregorianCalendar expireDate;
            @XmlAttribute(name = "CertificateNumber")
            String certificateNumber;
            @XmlAttribute(name = "MemberNumber")
            String memberNumber;
            @XmlAttribute(name = "ProgramName")
            String programName;

            /**
             * Gets the value of the idContext property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getIDContext() {
                return idContext;
            }

            /**
             * Sets the value of the idContext property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setIDContext(String value) {
                this.idContext = value;
            }

            /**
             * Gets the value of the nmbrOfNights property.
             *
             * @return possible object is
             * {@link BigInteger }
             */
            public BigInteger getNmbrOfNights() {
                return nmbrOfNights;
            }

            /**
             * Sets the value of the nmbrOfNights property.
             *
             * @param value allowed object is
             *              {@link BigInteger }
             */
            public void setNmbrOfNights(BigInteger value) {
                this.nmbrOfNights = value;
            }

            /**
             * Gets the value of the format property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getFormat() {
                return format;
            }

            /**
             * Sets the value of the format property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setFormat(String value) {
                this.format = value;
            }

            /**
             * Gets the value of the status property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getStatus() {
                return status;
            }

            /**
             * Sets the value of the status property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setStatus(String value) {
                this.status = value;
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
             * Gets the value of the certificateNumber property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCertificateNumber() {
                return certificateNumber;
            }

            /**
             * Sets the value of the certificateNumber property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCertificateNumber(String value) {
                this.certificateNumber = value;
            }

            /**
             * Gets the value of the memberNumber property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getMemberNumber() {
                return memberNumber;
            }

            /**
             * Sets the value of the memberNumber property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setMemberNumber(String value) {
                this.memberNumber = value;
            }

            /**
             * Gets the value of the programName property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getProgramName() {
                return programName;
            }

            /**
             * Sets the value of the programName property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setProgramName(String value) {
                this.programName = value;
            }

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
     *       &lt;attribute name="TicketNumber" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class MiscChargeOrder {

        @XmlAttribute(name = "TicketNumber")
        String ticketNumber;

        /**
         * Gets the value of the ticketNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getTicketNumber() {
            return ticketNumber;
        }

        /**
         * Sets the value of the ticketNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTicketNumber(String value) {
            this.ticketNumber = value;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}VoucherGroup"/>
     *       &lt;attribute name="BillingNumber" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
     *       &lt;attribute name="SupplierIdentifier" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
     *       &lt;attribute name="Identifier" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
     *       &lt;attribute name="ValueType" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
     *       &lt;attribute name="ElectronicIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Voucher {

        @XmlAttribute(name = "BillingNumber")
        String billingNumber;
        @XmlAttribute(name = "SupplierIdentifier")
        String supplierIdentifier;
        @XmlAttribute(name = "Identifier")
        String identifier;
        @XmlAttribute(name = "ValueType")
        String valueType;
        @XmlAttribute(name = "ElectronicIndicator")
        Boolean electronicIndicator;
        @XmlAttribute(name = "SeriesCode")
        String seriesCode;
        @XmlAttribute(name = "EffectiveDate")
        @XmlSchemaType(name = "date")
        XMLGregorianCalendar effectiveDate;
        @XmlAttribute(name = "ExpireDate")
        @XmlSchemaType(name = "date")
        XMLGregorianCalendar expireDate;

        /**
         * Gets the value of the billingNumber property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getBillingNumber() {
            return billingNumber;
        }

        /**
         * Sets the value of the billingNumber property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setBillingNumber(String value) {
            this.billingNumber = value;
        }

        /**
         * Gets the value of the supplierIdentifier property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getSupplierIdentifier() {
            return supplierIdentifier;
        }

        /**
         * Sets the value of the supplierIdentifier property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setSupplierIdentifier(String value) {
            this.supplierIdentifier = value;
        }

        /**
         * Gets the value of the identifier property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getIdentifier() {
            return identifier;
        }

        /**
         * Sets the value of the identifier property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setIdentifier(String value) {
            this.identifier = value;
        }

        /**
         * Gets the value of the valueType property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getValueType() {
            return valueType;
        }

        /**
         * Sets the value of the valueType property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setValueType(String value) {
            this.valueType = value;
        }

        /**
         * Gets the value of the electronicIndicator property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public Boolean isElectronicIndicator() {
            return electronicIndicator;
        }

        /**
         * Sets the value of the electronicIndicator property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setElectronicIndicator(Boolean value) {
            this.electronicIndicator = value;
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

    }

}
