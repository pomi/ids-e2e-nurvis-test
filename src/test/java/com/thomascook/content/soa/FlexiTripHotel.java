//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.soa;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for FlexiTripHotel complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="FlexiTripHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.thomascook.com/content/soa}BasePackage">
 *       &lt;attribute name="FlexitripId" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlexiTripHotel")
@XmlSeeAlso({
        Request.Flexitrips.Hotel.class
})
public class FlexiTripHotel
        extends BasePackage {

    @XmlAttribute(name = "FlexitripId", required = true)
    private String flexitripId;

    /**
     * Gets the value of the flexitripId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFlexitripId() {
        return flexitripId;
    }

    /**
     * Sets the value of the flexitripId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFlexitripId(String value) {
        this.flexitripId = value;
    }

}
