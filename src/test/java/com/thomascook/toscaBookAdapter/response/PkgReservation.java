//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:47 PM EEST 
//


package com.thomascook.toscaBookAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Details of a Package Holiday reservation object.
 * <p>
 * <p>Java class for PkgReservation complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkgReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="POS" type="{http://www.opentravel.org/OTA/2003/05}POS_Type" minOccurs="0"/>
 *         &lt;element name="UniqueID" type="{http://www.opentravel.org/OTA/2003/05}UniqueID_Type" minOccurs="0"/>
 *         &lt;element name="Package" type="{http://www.opentravel.org/OTA/2003/05}PackageResponseType" minOccurs="0"/>
 *         &lt;element name="ContactDetail" type="{http://www.opentravel.org/OTA/2003/05}ContactPersonType" minOccurs="0"/>
 *         &lt;element name="PassengerListItems" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PassengerListItem" type="{http://www.opentravel.org/OTA/2003/05}PkgPassengerListItem" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="OwnInsuranceChoices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OwnInsuranceChoice" type="{http://www.opentravel.org/OTA/2003/05}OwnInsuranceChoiceType" maxOccurs="9"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TicketingInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;extension base="{http://www.opentravel.org/OTA/2003/05}TicketingInfoRS_Type">
 *                 &lt;attribute name="TOD_Ind" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *               &lt;/extension>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="InvoiceDetail" type="{http://www.opentravel.org/OTA/2003/05}PkgInvoiceDetail" minOccurs="0"/>
 *         &lt;element name="Transactions" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Transaction" type="{http://www.opentravel.org/OTA/2003/05}TransactionType" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{http://www.opentravel.org/OTA/2003/05}TPA_Extensions" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkgReservation", propOrder = {
        "pos",
        "uniqueID",
        "_package",
        "contactDetail",
        "passengerListItems",
        "ownInsuranceChoices",
        "ticketingInfo",
        "invoiceDetail",
        "transactions",
        "tpaExtensions"
})
public class PkgReservation {

    @XmlElement(name = "POS")
    private POSType pos;
    @XmlElement(name = "UniqueID")
    private UniqueIDType uniqueID;
    @XmlElement(name = "Package")
    private PackageResponseType _package;
    @XmlElement(name = "ContactDetail")
    private ContactPersonType contactDetail;
    @XmlElement(name = "PassengerListItems")
    private PassengerListItems passengerListItems;
    @XmlElement(name = "OwnInsuranceChoices")
    private OwnInsuranceChoices ownInsuranceChoices;
    @XmlElement(name = "TicketingInfo")
    private TicketingInfo ticketingInfo;
    @XmlElement(name = "InvoiceDetail")
    private PkgInvoiceDetail invoiceDetail;
    @XmlElement(name = "Transactions")
    private Transactions transactions;
    @XmlElement(name = "TPA_Extensions")
    private TPAExtensionsType tpaExtensions;

    /**
     * Gets the value of the pos property.
     *
     * @return possible object is
     * {@link POSType }
     */
    public POSType getPOS() {
        return pos;
    }

    /**
     * Sets the value of the pos property.
     *
     * @param value allowed object is
     *              {@link POSType }
     */
    public void setPOS(POSType value) {
        this.pos = value;
    }

    /**
     * Gets the value of the uniqueID property.
     *
     * @return possible object is
     * {@link UniqueIDType }
     */
    public UniqueIDType getUniqueID() {
        return uniqueID;
    }

    /**
     * Sets the value of the uniqueID property.
     *
     * @param value allowed object is
     *              {@link UniqueIDType }
     */
    public void setUniqueID(UniqueIDType value) {
        this.uniqueID = value;
    }

    /**
     * Gets the value of the package property.
     *
     * @return possible object is
     * {@link PackageResponseType }
     */
    public PackageResponseType getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     *
     * @param value allowed object is
     *              {@link PackageResponseType }
     */
    public void setPackage(PackageResponseType value) {
        this._package = value;
    }

    /**
     * Gets the value of the contactDetail property.
     *
     * @return possible object is
     * {@link ContactPersonType }
     */
    public ContactPersonType getContactDetail() {
        return contactDetail;
    }

    /**
     * Sets the value of the contactDetail property.
     *
     * @param value allowed object is
     *              {@link ContactPersonType }
     */
    public void setContactDetail(ContactPersonType value) {
        this.contactDetail = value;
    }

    /**
     * Gets the value of the passengerListItems property.
     *
     * @return possible object is
     * {@link PassengerListItems }
     */
    public PassengerListItems getPassengerListItems() {
        return passengerListItems;
    }

    /**
     * Sets the value of the passengerListItems property.
     *
     * @param value allowed object is
     *              {@link PassengerListItems }
     */
    public void setPassengerListItems(PassengerListItems value) {
        this.passengerListItems = value;
    }

    /**
     * Gets the value of the ownInsuranceChoices property.
     *
     * @return possible object is
     * {@link OwnInsuranceChoices }
     */
    public OwnInsuranceChoices getOwnInsuranceChoices() {
        return ownInsuranceChoices;
    }

    /**
     * Sets the value of the ownInsuranceChoices property.
     *
     * @param value allowed object is
     *              {@link OwnInsuranceChoices }
     */
    public void setOwnInsuranceChoices(OwnInsuranceChoices value) {
        this.ownInsuranceChoices = value;
    }

    /**
     * Gets the value of the ticketingInfo property.
     *
     * @return possible object is
     * {@link TicketingInfo }
     */
    public TicketingInfo getTicketingInfo() {
        return ticketingInfo;
    }

    /**
     * Sets the value of the ticketingInfo property.
     *
     * @param value allowed object is
     *              {@link TicketingInfo }
     */
    public void setTicketingInfo(TicketingInfo value) {
        this.ticketingInfo = value;
    }

    /**
     * Gets the value of the invoiceDetail property.
     *
     * @return possible object is
     * {@link PkgInvoiceDetail }
     */
    public PkgInvoiceDetail getInvoiceDetail() {
        return invoiceDetail;
    }

    /**
     * Sets the value of the invoiceDetail property.
     *
     * @param value allowed object is
     *              {@link PkgInvoiceDetail }
     */
    public void setInvoiceDetail(PkgInvoiceDetail value) {
        this.invoiceDetail = value;
    }

    /**
     * Gets the value of the transactions property.
     *
     * @return possible object is
     * {@link Transactions }
     */
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     *
     * @param value allowed object is
     *              {@link Transactions }
     */
    public void setTransactions(Transactions value) {
        this.transactions = value;
    }

    /**
     * Gets the value of the tpaExtensions property.
     *
     * @return possible object is
     * {@link TPAExtensionsType }
     */
    public TPAExtensionsType getTPAExtensions() {
        return tpaExtensions;
    }

    /**
     * Sets the value of the tpaExtensions property.
     *
     * @param value allowed object is
     *              {@link TPAExtensionsType }
     */
    public void setTPAExtensions(TPAExtensionsType value) {
        this.tpaExtensions = value;
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
     *         &lt;element name="OwnInsuranceChoice" type="{http://www.opentravel.org/OTA/2003/05}OwnInsuranceChoiceType" maxOccurs="9"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "ownInsuranceChoice"
    })
    public static class OwnInsuranceChoices {

        @XmlElement(name = "OwnInsuranceChoice", required = true)
        List<OwnInsuranceChoiceType> ownInsuranceChoice;

        /**
         * Gets the value of the ownInsuranceChoice property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the ownInsuranceChoice property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOwnInsuranceChoice().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OwnInsuranceChoiceType }
         */
        public List<OwnInsuranceChoiceType> getOwnInsuranceChoice() {
            if (ownInsuranceChoice == null) {
                ownInsuranceChoice = new ArrayList<>();
            }
            return this.ownInsuranceChoice;
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
     *         &lt;element name="PassengerListItem" type="{http://www.opentravel.org/OTA/2003/05}PkgPassengerListItem" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "passengerListItem"
    })
    public static class PassengerListItems {

        @XmlElement(name = "PassengerListItem", required = true)
        List<PkgPassengerListItem> passengerListItem;

        /**
         * Gets the value of the passengerListItem property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the passengerListItem property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPassengerListItem().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link PkgPassengerListItem }
         */
        public List<PkgPassengerListItem> getPassengerListItem() {
            if (passengerListItem == null) {
                passengerListItem = new ArrayList<>();
            }
            return this.passengerListItem;
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
     *     &lt;extension base="{http://www.opentravel.org/OTA/2003/05}TicketingInfoRS_Type">
     *       &lt;attribute name="TOD_Ind" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *     &lt;/extension>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class TicketingInfo
            extends TicketingInfoRSType {

        @XmlAttribute(name = "TOD_Ind")
        Boolean todInd;

        /**
         * Gets the value of the todInd property.
         *
         * @return possible object is
         * {@link Boolean }
         */
        public Boolean isTODInd() {
            return todInd;
        }

        /**
         * Sets the value of the todInd property.
         *
         * @param value allowed object is
         *              {@link Boolean }
         */
        public void setTODInd(Boolean value) {
            this.todInd = value;
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
     *         &lt;element name="Transaction" type="{http://www.opentravel.org/OTA/2003/05}TransactionType" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "transaction"
    })
    public static class Transactions {

        @XmlElement(name = "Transaction", required = true)
        List<TransactionType> transaction;

        /**
         * Gets the value of the transaction property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the transaction property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTransaction().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TransactionType }
         */
        public List<TransactionType> getTransaction() {
            if (transaction == null) {
                transaction = new ArrayList<>();
            }
            return this.transaction;
        }

    }

}
