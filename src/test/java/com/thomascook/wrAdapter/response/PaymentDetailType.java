//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 04:28:34 PM EEST 
//


package com.thomascook.wrAdapter.response;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Details of payment.
 * <p>
 * <p>
 * <p>Java class for PaymentDetailType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PaymentDetailType">
 *   &lt;complexContent>
 *     &lt;extension base="{}PaymentFormType">
 *       &lt;sequence>
 *         &lt;element name="PaymentAmount" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{}CurrencyAmountGroup"/>
 *                 &lt;attribute name="ApprovalCode" type="{}StringLength1to16" />
 *                 &lt;attribute name="AuthenticationCAVV" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="CCCharge" type="{}Money" />
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

    @XmlElement(name = "PaymentAmount", required = true)
    protected List<PaymentAmount> paymentAmount;

    /**
     * Gets the value of the paymentAmount property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentAmount property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentAmount().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentAmount }
     */
    public List<PaymentAmount> getPaymentAmount() {
        if (paymentAmount == null) {
            paymentAmount = new ArrayList<PaymentAmount>();
        }
        return this.paymentAmount;
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
     *       &lt;attGroup ref="{}CurrencyAmountGroup"/>
     *       &lt;attribute name="ApprovalCode" type="{}StringLength1to16" />
     *       &lt;attribute name="AuthenticationCAVV" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="CCCharge" type="{}Money" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PaymentAmount {

        @XmlAttribute(name = "ApprovalCode")
        protected String approvalCode;
        @XmlAttribute(name = "AuthenticationCAVV")
        protected String authenticationCAVV;
        @XmlAttribute(name = "TransactionID")
        protected String transactionID;
        @XmlAttribute(name = "CCCharge")
        protected BigDecimal ccCharge;
        @XmlAttribute(name = "Amount")
        protected BigDecimal amount;
        @XmlAttribute(name = "CurrencyCode")
        protected String currencyCode;

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
         * Gets the value of the authenticationCAVV property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getAuthenticationCAVV() {
            return authenticationCAVV;
        }

        /**
         * Sets the value of the authenticationCAVV property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setAuthenticationCAVV(String value) {
            this.authenticationCAVV = value;
        }

        /**
         * Gets the value of the transactionID property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getTransactionID() {
            return transactionID;
        }

        /**
         * Sets the value of the transactionID property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setTransactionID(String value) {
            this.transactionID = value;
        }

        /**
         * Gets the value of the ccCharge property.
         *
         * @return possible object is
         * {@link BigDecimal }
         */
        public BigDecimal getCCCharge() {
            return ccCharge;
        }

        /**
         * Sets the value of the ccCharge property.
         *
         * @param value allowed object is
         *              {@link BigDecimal }
         */
        public void setCCCharge(BigDecimal value) {
            this.ccCharge = value;
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

    }

}
