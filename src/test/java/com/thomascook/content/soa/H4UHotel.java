//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.soa;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for H4UHotel complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="H4UHotel">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.thomascook.com/content/soa}BasePackage">
 *       &lt;attribute name="Chain" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="HotelID" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "H4UHotel")
@XmlSeeAlso({
        Request.H4U.Hotel.class
})
public class H4UHotel
        extends BasePackage {

    @XmlAttribute(name = "Chain", required = true)
    private String chain;
    @XmlAttribute(name = "HotelID", required = true)
    private String hotelID;

    /**
     * Gets the value of the chain property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChain() {
        return chain;
    }

    /**
     * Sets the value of the chain property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChain(String value) {
        this.chain = value;
    }

    /**
     * Gets the value of the hotelID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHotelID() {
        return hotelID;
    }

    /**
     * Sets the value of the hotelID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHotelID(String value) {
        this.hotelID = value;
    }

}
