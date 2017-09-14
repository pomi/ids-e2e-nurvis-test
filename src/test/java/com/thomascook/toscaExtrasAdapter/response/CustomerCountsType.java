//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * CustomerCounts- Categorization of all Customers in a reservation or request. The total number of Customers will equal the sum of the Count attribute of all CustomerCount objects in this collection and assumes that the AgeQualifyingCode will be used to determine how each Customer should be billed. Each booking segment has its own CustomerCount attribute to help determine billing, headcount, etc. The CustomerCount collection cannot be modified
 * using a delta. It must be resent in its entirety if modified.
 * <p>
 * <p>Java class for CustomerCountsType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="CustomerCountsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerCount" maxOccurs="99">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}BirthDateGroup"/>
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}TravelerCountGroup"/>
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
@XmlType(name = "CustomerCountsType", propOrder = {
        "customerCount"
})
public class CustomerCountsType {

    @XmlElement(name = "CustomerCount", required = true)
    private List<CustomerCount> customerCount;

    /**
     * Gets the value of the customerCount property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the customerCount property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCustomerCount().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomerCount }
     */
    public List<CustomerCount> getCustomerCount() {
        if (customerCount == null) {
            customerCount = new ArrayList<>();
        }
        return this.customerCount;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}BirthDateGroup"/>
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}TravelerCountGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class CustomerCount {

        @XmlAttribute(name = "BirthDate")
        @XmlSchemaType(name = "date")
        XMLGregorianCalendar birthDate;
        @XmlAttribute(name = "Age")
        Integer age;
        @XmlAttribute(name = "Code")
        String code;
        @XmlAttribute(name = "CodeContext")
        String codeContext;
        @XmlAttribute(name = "URI")
        @XmlSchemaType(name = "anyURI")
        String uri;
        @XmlAttribute(name = "Quantity")
        @XmlSchemaType(name = "nonNegativeInteger")
        BigInteger quantity;

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
         * Gets the value of the age property.
         *
         * @return possible object is
         * {@link Integer }
         */
        public Integer getAge() {
            return age;
        }

        /**
         * Sets the value of the age property.
         *
         * @param value allowed object is
         *              {@link Integer }
         */
        public void setAge(Integer value) {
            this.age = value;
        }

        /**
         * Gets the value of the code property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets the value of the codeContext property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getCodeContext() {
            return codeContext;
        }

        /**
         * Sets the value of the codeContext property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setCodeContext(String value) {
            this.codeContext = value;
        }

        /**
         * Gets the value of the uri property.
         *
         * @return possible object is
         * {@link String }
         */
        public String getURI() {
            return uri;
        }

        /**
         * Sets the value of the uri property.
         *
         * @param value allowed object is
         *              {@link String }
         */
        public void setURI(String value) {
            this.uri = value;
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

    }

}
