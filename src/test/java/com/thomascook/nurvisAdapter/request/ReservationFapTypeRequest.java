//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.30 at 10:58:08 AM EEST 
//


package com.thomascook.nurvisAdapter.request;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * To store bookable information about a passenger
 * <p>
 * <p>
 * <p>Java class for Reservation-FapType-Request complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Reservation-FapType-Request">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PersonType" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Sex" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Title" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Name">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="40"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="FirstName" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Age" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="-?[0-9]+"/>
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Birth" type="{}DateType" minOccurs="0"/>
 *         &lt;element name="PricePerson" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="-?[0-9]+(,[0-9][0-9])?"/>
 *               &lt;maxLength value="12"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Faq" type="{}Reservation-FaqType-Request" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ID" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;pattern value="-?[0-9]+"/>
 *             &lt;maxLength value="3"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Key">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;maxLength value="1000"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reservation-FapType-Request", propOrder = {
        "personType",
        "sex",
        "title",
        "name",
        "firstName",
        "age",
        "birth",
        "pricePerson",
        "faq"
})
public class ReservationFapTypeRequest {

    @XmlElement(name = "PersonType")
    private String personType;
    @XmlElement(name = "Sex")
    private String sex;
    @XmlElement(name = "Title")
    private String title;
    @XmlElement(name = "Name", required = true)
    private String name;
    @XmlElement(name = "FirstName")
    private String firstName;
    @XmlElement(name = "Age")
    private String age;
    @XmlElement(name = "Birth")
    private String birth;
    @XmlElement(name = "PricePerson")
    private String pricePerson;
    @XmlElement(name = "Faq")
    private List<ReservationFaqTypeRequest> faq;
    @XmlAttribute(name = "ID", required = true)
    private String id;
    @XmlAttribute(name = "Key")
    private String key;

    /**
     * Gets the value of the personType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPersonType() {
        return personType;
    }

    /**
     * Sets the value of the personType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPersonType(String value) {
        this.personType = value;
    }

    /**
     * Gets the value of the sex property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSex() {
        return sex;
    }

    /**
     * Sets the value of the sex property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSex(String value) {
        this.sex = value;
    }

    /**
     * Gets the value of the title property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the firstName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the age property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAge(String value) {
        this.age = value;
    }

    /**
     * Gets the value of the birth property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBirth() {
        return birth;
    }

    /**
     * Sets the value of the birth property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBirth(String value) {
        this.birth = value;
    }

    /**
     * Gets the value of the pricePerson property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPricePerson() {
        return pricePerson;
    }

    /**
     * Sets the value of the pricePerson property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPricePerson(String value) {
        this.pricePerson = value;
    }

    /**
     * Gets the value of the faq property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the faq property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFaq().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReservationFaqTypeRequest }
     */
    public List<ReservationFaqTypeRequest> getFaq() {
        if (faq == null) {
            faq = new ArrayList<>();
        }
        return this.faq;
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
     * Gets the value of the key property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setKey(String value) {
        this.key = value;
    }

}
