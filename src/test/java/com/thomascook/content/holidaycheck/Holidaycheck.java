//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.holidaycheck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.thomascook.com/content/holidaycheck}HolidaycheckOverview" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "holidaycheckOverview"
})
@XmlRootElement(name = "Holidaycheck")
public class Holidaycheck {

    @XmlElement(name = "HolidaycheckOverview")
    protected HolidaycheckOverviewType holidaycheckOverview;
    @XmlAttribute(name = "URI")
    protected String uri;

    /**
     * Gets the value of the holidaycheckOverview property.
     * 
     * @return
     *     possible object is
     *     {@link HolidaycheckOverviewType }
     *     
     */
    public HolidaycheckOverviewType getHolidaycheckOverview() {
        return holidaycheckOverview;
    }

    /**
     * Sets the value of the holidaycheckOverview property.
     * 
     * @param value
     *     allowed object is
     *     {@link HolidaycheckOverviewType }
     *     
     */
    public void setHolidaycheckOverview(HolidaycheckOverviewType value) {
        this.holidaycheckOverview = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
