//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:45 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.request;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Describes an optional service which is not included in the standard package but may be booked in addition.
 * <p>
 * <p>Java class for ExtrasCoreType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ExtrasCoreType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubCategory" maxOccurs="5" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}OptionalCodeOptionalNameGroup"/>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="RPH" type="{http://www.opentravel.org/OTA/2003/05}RPH_Type" />
 *       &lt;attribute name="Code" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *       &lt;attribute name="Type" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *       &lt;attribute name="SubType" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to8" />
 *       &lt;attribute name="Quantity" type="{http://www.opentravel.org/OTA/2003/05}Numeric0to99" />
 *       &lt;attribute name="GroupCode" type="{http://www.opentravel.org/OTA/2003/05}AlphaLength1" />
 *       &lt;attribute name="Name" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *       &lt;attribute name="ListOfInventoryItemRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *       &lt;attribute name="ListofRoomRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtrasCoreType", propOrder = {
        "subCategory"
})
@XmlSeeAlso({
        ExtrasType.class,
        ExtrasInfoType.class
})
public class ExtrasCoreType {

    @XmlElement(name = "SubCategory")
    private List<SubCategory> subCategory;
    @XmlAttribute(name = "RPH")
    private String rph;
    @XmlAttribute(name = "Code")
    private String code;
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "SubType")
    private String subType;
    @XmlAttribute(name = "Quantity")
    private Integer quantity;
    @XmlAttribute(name = "GroupCode")
    private String groupCode;
    @XmlAttribute(name = "Name")
    private String name;
    @XmlAttribute(name = "ListOfInventoryItemRPH")
    private List<String> listOfInventoryItemRPH;
    @XmlAttribute(name = "ListofRoomRPH")
    private List<String> listofRoomRPH;

    /**
     * Gets the value of the subCategory property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subCategory property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubCategory().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubCategory }
     */
    public List<SubCategory> getSubCategory() {
        if (subCategory == null) {
            subCategory = new ArrayList<>();
        }
        return this.subCategory;
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
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the subType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setQuantity(Integer value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the groupCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupCode() {
        return groupCode;
    }

    /**
     * Sets the value of the groupCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupCode(String value) {
        this.groupCode = value;
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
     * Gets the value of the listOfInventoryItemRPH property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfInventoryItemRPH property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfInventoryItemRPH().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getListOfInventoryItemRPH() {
        if (listOfInventoryItemRPH == null) {
            listOfInventoryItemRPH = new ArrayList<>();
        }
        return this.listOfInventoryItemRPH;
    }

    /**
     * Gets the value of the listofRoomRPH property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listofRoomRPH property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListofRoomRPH().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getListofRoomRPH() {
        if (listofRoomRPH == null) {
            listofRoomRPH = new ArrayList<>();
        }
        return this.listofRoomRPH;
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
     *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}OptionalCodeOptionalNameGroup"/>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SubCategory {

        @XmlAttribute(name = "Code")
        String code;
        @XmlAttribute(name = "Name")
        String name;

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

    }

}
