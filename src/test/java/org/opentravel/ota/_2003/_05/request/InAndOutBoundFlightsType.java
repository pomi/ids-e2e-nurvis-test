//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package org.opentravel.ota._2003._05.request;

import javax.xml.bind.annotation.*;


/**
 * Describes the details
 * about the in- and outbounding flights.
 * <p>
 * <p>
 * <p>Java class for InAndOutBoundFlightsType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="InAndOutBoundFlightsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InboundFlight" type="{http://www.opentravel.org/OTA/2003/05}PkgFlightType"/>
 *         &lt;element name="OutboundFlight" type="{http://www.opentravel.org/OTA/2003/05}PkgFlightType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="AvailableSeats" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InAndOutBoundFlightsType", propOrder = {
        "inboundFlight",
        "outboundFlight"
})
public class InAndOutBoundFlightsType {

    @XmlElement(name = "InboundFlight", required = true)
    private PkgFlightType inboundFlight;
    @XmlElement(name = "OutboundFlight", required = true)
    private PkgFlightType outboundFlight;
    @XmlAttribute(name = "AvailableSeats")
    private Integer availableSeats;

    /**
     * Gets the value of the inboundFlight property.
     *
     * @return possible object is
     * {@link PkgFlightType }
     */
    public PkgFlightType getInboundFlight() {
        return inboundFlight;
    }

    /**
     * Sets the value of the inboundFlight property.
     *
     * @param value allowed object is
     *              {@link PkgFlightType }
     */
    public void setInboundFlight(PkgFlightType value) {
        this.inboundFlight = value;
    }

    /**
     * Gets the value of the outboundFlight property.
     *
     * @return possible object is
     * {@link PkgFlightType }
     */
    public PkgFlightType getOutboundFlight() {
        return outboundFlight;
    }

    /**
     * Sets the value of the outboundFlight property.
     *
     * @param value allowed object is
     *              {@link PkgFlightType }
     */
    public void setOutboundFlight(PkgFlightType value) {
        this.outboundFlight = value;
    }

    /**
     * Gets the value of the availableSeats property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Sets the value of the availableSeats property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setAvailableSeats(Integer value) {
        this.availableSeats = value;
    }

}
