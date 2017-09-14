//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Details of payment.
 * <p>
 * <p>Java class for PaymentDetailType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PaymentDetailType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}PaymentFormType">
 *       &lt;sequence>
 *         &lt;element name="PaymentAmount" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}CurrencyAmountGroup"/>
 *                 &lt;attribute name="ApprovalCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentDetailType", propOrder = {
        "paymentAmount"
})
public class PaymentDetailType
        extends PaymentFormType {

    @XmlElement(name = "PaymentAmount")
    private PaymentAmount paymentAmount;

    /**
     * Gets the value of the paymentAmount property.
     *
     * @return possible object is
     * {@link PaymentAmount }
     */
    public PaymentAmount getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     *
     * @param value allowed object is
     *              {@link PaymentAmount }
     */
    public void setPaymentAmount(PaymentAmount value) {
        this.paymentAmount = value;
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
     *       &lt;attribute name="ApprovalCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaymentAmount {

        @XmlAttribute(name = "ApprovalCode")
        String approvalCode;
        @XmlAttribute(name = "Amount")
        BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        String currencyCode;
        @XmlAttribute(name = "DecimalPlaces")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger decimalPlaces;

        /**
         * Gets the value of the approvalCode property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getApprovalCode() {
            return approvalCode;
        }

        /**
         * Sets the value of the approvalCode property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setApprovalCode(String value) {
            this.approvalCode = value;
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

}
