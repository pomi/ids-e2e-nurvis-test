//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;


/**
 * Street name; number on street.
 * <p>
 * <p>Java class for StreetNmbrType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="StreetNmbrType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>StringLength0to64">
 *       &lt;attribute name="PO_Box" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StreetNmbrType", propOrder = {
        "value"
})
@XmlSeeAlso({
        AddressType.StreetNmbr.class
})
public class StreetNmbrType {

    @XmlValue
    private String value;
    @XmlAttribute(name = "PO_Box")
    private String poBox;

    /**
     * Used for Character Strings, length 0 to 64
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the poBox property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPOBox() {
        return poBox;
    }

    /**
     * Sets the value of the poBox property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPOBox(String value) {
        this.poBox = value;
    }

}
