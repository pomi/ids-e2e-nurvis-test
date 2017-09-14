//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * Company name and location for sending invoice for remittances for travel services.
 * <p>
 * <p>Java class for DirectBillType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DirectBillType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyName" minOccurs="0">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNameType">
 *                 &lt;attribute name="ContactName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Address" type="{http://www.opentravel.org/OTA/2003/05}AddressInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PrivacyGroup"/>
 *       &lt;attribute name="DirectBill_ID" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
 *       &lt;attribute name="BillingNumber" type="{http://www.opentravel.org/OTA/2003/05}StringLength0to64" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectBillType", propOrder = {
        "companyName",
        "address"
})
public class DirectBillType {

    @XmlElement(name = "CompanyName")
    private CompanyName companyName;
    @XmlElement(name = "Address")
    private AddressInfoType address;
    @XmlAttribute(name = "DirectBill_ID")
    private String directBillID;
    @XmlAttribute(name = "BillingNumber")
    private String billingNumber;
    @XmlAttribute(name = "ShareSynchInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareMarketInd;

    /**
     * Gets the value of the companyName property.
     *
     * @return possible object is
     * {@link CompanyName }
     */
    public CompanyName getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     *
     * @param value allowed object is
     *              {@link CompanyName }
     */
    public void setCompanyName(CompanyName value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return possible object is
     * {@link AddressInfoType }
     */
    public AddressInfoType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value allowed object is
     *              {@link AddressInfoType }
     */
    public void setAddress(AddressInfoType value) {
        this.address = value;
    }

    /**
     * Gets the value of the directBillID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDirectBillID() {
        return directBillID;
    }

    /**
     * Sets the value of the directBillID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDirectBillID(String value) {
        this.directBillID = value;
    }

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
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>CompanyNameType">
     *       &lt;attribute name="ContactName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CompanyName
            extends CompanyNameType {

        @XmlAttribute(name = "ContactName")
        String contactName;

        /**
         * Gets the value of the contactName property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getContactName() {
            return contactName;
        }

        /**
         * Sets the value of the contactName property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setContactName(String value) {
            this.contactName = value;
        }

    }

}
