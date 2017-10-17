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
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Provides information on a specific documents
 * <p>
 * <p>Java class for DocumentType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice minOccurs="0">
 *           &lt;element name="DocHolderName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" minOccurs="0"/>
 *           &lt;element name="DocHolderFormattedName" type="{http://www.opentravel.org/OTA/2003/05}PersonNameType" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element name="DocLimitations" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" maxOccurs="9" minOccurs="0"/>
 *         &lt;element name="AdditionalPersonNames" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AdditionalPersonName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" maxOccurs="99"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}BirthDateGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}EffectiveExpireOptionalDateGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}GenderGroup"/>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PrivacyGroup"/>
 *       &lt;attribute name="DocIssueAuthority" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *       &lt;attribute name="DocIssueLocation" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *       &lt;attribute name="DocID" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to32" />
 *       &lt;attribute name="DocType" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="DocIssueStateProv" type="{http://www.opentravel.org/OTA/2003/05}StateProvCodeType" />
 *       &lt;attribute name="DocIssueCountry" type="{http://www.opentravel.org/OTA/2003/05}ISO3166" />
 *       &lt;attribute name="BirthCountry" type="{http://www.opentravel.org/OTA/2003/05}ISO3166" />
 *       &lt;attribute name="DocHolderNationality" type="{http://www.opentravel.org/OTA/2003/05}ISO3166" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
        "docHolderName",
        "docHolderFormattedName",
        "docLimitations",
        "additionalPersonNames"
})
public class DocumentType {

    @XmlElement(name = "DocHolderName")
    private String docHolderName;
    @XmlElement(name = "DocHolderFormattedName")
    private PersonNameType docHolderFormattedName;
    @XmlElement(name = "DocLimitations")
    private List<String> docLimitations;
    @XmlElement(name = "AdditionalPersonNames")
    private AdditionalPersonNames additionalPersonNames;
    @XmlAttribute(name = "DocIssueAuthority")
    private String docIssueAuthority;
    @XmlAttribute(name = "DocIssueLocation")
    private String docIssueLocation;
    @XmlAttribute(name = "DocID")
    private String docID;
    @XmlAttribute(name = "DocType")
    private String docType;
    @XmlAttribute(name = "DocIssueStateProv")
    private String docIssueStateProv;
    @XmlAttribute(name = "DocIssueCountry")
    private String docIssueCountry;
    @XmlAttribute(name = "BirthCountry")
    private String birthCountry;
    @XmlAttribute(name = "DocHolderNationality")
    private String docHolderNationality;
    @XmlAttribute(name = "BirthDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar birthDate;
    @XmlAttribute(name = "EffectiveDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar effectiveDate;
    @XmlAttribute(name = "ExpireDate")
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar expireDate;
    @XmlAttribute(name = "Gender")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String gender;
    @XmlAttribute(name = "ShareSynchInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareSynchInd;
    @XmlAttribute(name = "ShareMarketInd")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private String shareMarketInd;

    /**
     * Gets the value of the docHolderName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocHolderName() {
        return docHolderName;
    }

    /**
     * Sets the value of the docHolderName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocHolderName(String value) {
        this.docHolderName = value;
    }

    /**
     * Gets the value of the docHolderFormattedName property.
     *
     * @return possible object is
     * {@link PersonNameType }
     */
    public PersonNameType getDocHolderFormattedName() {
        return docHolderFormattedName;
    }

    /**
     * Sets the value of the docHolderFormattedName property.
     *
     * @param value allowed object is
     *              {@link PersonNameType }
     */
    public void setDocHolderFormattedName(PersonNameType value) {
        this.docHolderFormattedName = value;
    }

    /**
     * Gets the value of the docLimitations property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docLimitations property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocLimitations().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getDocLimitations() {
        if (docLimitations == null) {
            docLimitations = new ArrayList<>();
        }
        return this.docLimitations;
    }

    /**
     * Gets the value of the additionalPersonNames property.
     *
     * @return possible object is
     * {@link AdditionalPersonNames }
     */
    public AdditionalPersonNames getAdditionalPersonNames() {
        return additionalPersonNames;
    }

    /**
     * Sets the value of the additionalPersonNames property.
     *
     * @param value allowed object is
     *              {@link AdditionalPersonNames }
     */
    public void setAdditionalPersonNames(AdditionalPersonNames value) {
        this.additionalPersonNames = value;
    }

    /**
     * Gets the value of the docIssueAuthority property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocIssueAuthority() {
        return docIssueAuthority;
    }

    /**
     * Sets the value of the docIssueAuthority property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocIssueAuthority(String value) {
        this.docIssueAuthority = value;
    }

    /**
     * Gets the value of the docIssueLocation property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocIssueLocation() {
        return docIssueLocation;
    }

    /**
     * Sets the value of the docIssueLocation property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocIssueLocation(String value) {
        this.docIssueLocation = value;
    }

    /**
     * Gets the value of the docID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocID() {
        return docID;
    }

    /**
     * Sets the value of the docID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocID(String value) {
        this.docID = value;
    }

    /**
     * Gets the value of the docType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocType() {
        return docType;
    }

    /**
     * Sets the value of the docType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocType(String value) {
        this.docType = value;
    }

    /**
     * Gets the value of the docIssueStateProv property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocIssueStateProv() {
        return docIssueStateProv;
    }

    /**
     * Sets the value of the docIssueStateProv property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocIssueStateProv(String value) {
        this.docIssueStateProv = value;
    }

    /**
     * Gets the value of the docIssueCountry property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocIssueCountry() {
        return docIssueCountry;
    }

    /**
     * Sets the value of the docIssueCountry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocIssueCountry(String value) {
        this.docIssueCountry = value;
    }

    /**
     * Gets the value of the birthCountry property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBirthCountry() {
        return birthCountry;
    }

    /**
     * Sets the value of the birthCountry property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBirthCountry(String value) {
        this.birthCountry = value;
    }

    /**
     * Gets the value of the docHolderNationality property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocHolderNationality() {
        return docHolderNationality;
    }

    /**
     * Sets the value of the docHolderNationality property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocHolderNationality(String value) {
        this.docHolderNationality = value;
    }

    /**
     * Gets the value of the birthDate property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setBirthDate(XMLGregorianCalendar value) {
        this.birthDate = value;
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
     * Gets the value of the gender property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGender(String value) {
        this.gender = value;
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
     *       &lt;sequence>
     *         &lt;element name="AdditionalPersonName" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" maxOccurs="99"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "additionalPersonName"
    })
    public static class AdditionalPersonNames {

        @XmlElement(name = "AdditionalPersonName", required = true)
        List<String> additionalPersonName;

        /**
         * Gets the value of the additionalPersonName property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the additionalPersonName property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAdditionalPersonName().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getAdditionalPersonName() {
            if (additionalPersonName == null) {
                additionalPersonName = new ArrayList<>();
            }
            return this.additionalPersonName;
        }

    }

}
