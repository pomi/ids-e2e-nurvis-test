//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 02:57:34 PM EEST 
//


package com.thomascook.toscaExtrasAdapter.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * A full definition of a travel segment including supplemental price and facilities.
 * <p>
 * <p>Java class for PkgTravelSegment complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkgTravelSegment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AirSegment" type="{http://www.opentravel.org/OTA/2003/05}PkgAirSegmentType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkgTravelSegment", propOrder = {
        "airSegment"
})
public class PkgTravelSegment {

    @XmlElement(name = "AirSegment", required = true)
    private PkgAirSegmentType airSegment;

    /**
     * Gets the value of the airSegment property.
     *
     * @return possible object is
     * {@link PkgAirSegmentType }
     */
    public PkgAirSegmentType getAirSegment() {
        return airSegment;
    }

    /**
     * Sets the value of the airSegment property.
     *
     * @param value allowed object is
     *              {@link PkgAirSegmentType }
     */
    public void setAirSegment(PkgAirSegmentType value) {
        this.airSegment = value;
    }

}
