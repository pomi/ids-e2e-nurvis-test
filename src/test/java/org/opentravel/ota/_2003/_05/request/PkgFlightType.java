//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package org.opentravel.ota._2003._05.request;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Details of a flight.
 * <p>
 * <p>
 * <p>Java class for PkgFlightType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkgFlightType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DepartureAirport" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *         &lt;element name="ArrivalAirport" type="{http://www.opentravel.org/OTA/2003/05}LocationType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="FlightCode" type="{http://www.opentravel.org/OTA/2003/05}FlightNumberType" />
 *       &lt;attribute name="AirplaneCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Airline" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ServiceClass" type="{http://www.opentravel.org/OTA/2003/05}UpperCaseAlphaLength1to2" />
 *       &lt;attribute name="DepartureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="DepartureTimeStatus" type="{http://www.opentravel.org/OTA/2003/05}DateTimeStatus" />
 *       &lt;attribute name="ArrivalTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="ArrivalTimeStatus" type="{http://www.opentravel.org/OTA/2003/05}DateTimeStatus" />
 *       &lt;attribute name="FlightConnection" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkgFlightType", propOrder = {
        "departureAirport",
        "arrivalAirport"
})
public class PkgFlightType {

    @XmlElement(name = "DepartureAirport", required = true)
    private LocationType departureAirport;
    @XmlElement(name = "ArrivalAirport", required = true)
    private LocationType arrivalAirport;
    @XmlAttribute(name = "FlightCode")
    private String flightCode;
    @XmlAttribute(name = "AirplaneCode")
    private String airplaneCode;
    @XmlAttribute(name = "Airline")
    private String airline;
    @XmlAttribute(name = "ServiceClass")
    private String serviceClass;
    @XmlAttribute(name = "DepartureTime")
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar departureTime;
    @XmlAttribute(name = "DepartureTimeStatus")
    private DateTimeStatus departureTimeStatus;
    @XmlAttribute(name = "ArrivalTime")
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar arrivalTime;
    @XmlAttribute(name = "ArrivalTimeStatus")
    private DateTimeStatus arrivalTimeStatus;
    @XmlAttribute(name = "FlightConnection")
    private String flightConnection;

    /**
     * Gets the value of the departureAirport property.
     *
     * @return possible object is
     * {@link LocationType }
     */
    public LocationType getDepartureAirport() {
        return departureAirport;
    }

    /**
     * Sets the value of the departureAirport property.
     *
     * @param value allowed object is
     *              {@link LocationType }
     */
    public void setDepartureAirport(LocationType value) {
        this.departureAirport = value;
    }

    /**
     * Gets the value of the arrivalAirport property.
     *
     * @return possible object is
     * {@link LocationType }
     */
    public LocationType getArrivalAirport() {
        return arrivalAirport;
    }

    /**
     * Sets the value of the arrivalAirport property.
     *
     * @param value allowed object is
     *              {@link LocationType }
     */
    public void setArrivalAirport(LocationType value) {
        this.arrivalAirport = value;
    }

    /**
     * Gets the value of the flightCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFlightCode() {
        return flightCode;
    }

    /**
     * Sets the value of the flightCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFlightCode(String value) {
        this.flightCode = value;
    }

    /**
     * Gets the value of the airplaneCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAirplaneCode() {
        return airplaneCode;
    }

    /**
     * Sets the value of the airplaneCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAirplaneCode(String value) {
        this.airplaneCode = value;
    }

    /**
     * Gets the value of the airline property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Sets the value of the airline property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAirline(String value) {
        this.airline = value;
    }

    /**
     * Gets the value of the serviceClass property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getServiceClass() {
        return serviceClass;
    }

    /**
     * Sets the value of the serviceClass property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setServiceClass(String value) {
        this.serviceClass = value;
    }

    /**
     * Gets the value of the departureTime property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets the value of the departureTime property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setDepartureTime(XMLGregorianCalendar value) {
        this.departureTime = value;
    }

    /**
     * Gets the value of the departureTimeStatus property.
     *
     * @return possible object is
     * {@link DateTimeStatus }
     */
    public DateTimeStatus getDepartureTimeStatus() {
        return departureTimeStatus;
    }

    /**
     * Sets the value of the departureTimeStatus property.
     *
     * @param value allowed object is
     *              {@link DateTimeStatus }
     */
    public void setDepartureTimeStatus(DateTimeStatus value) {
        this.departureTimeStatus = value;
    }

    /**
     * Gets the value of the arrivalTime property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets the value of the arrivalTime property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setArrivalTime(XMLGregorianCalendar value) {
        this.arrivalTime = value;
    }

    /**
     * Gets the value of the arrivalTimeStatus property.
     *
     * @return possible object is
     * {@link DateTimeStatus }
     */
    public DateTimeStatus getArrivalTimeStatus() {
        return arrivalTimeStatus;
    }

    /**
     * Sets the value of the arrivalTimeStatus property.
     *
     * @param value allowed object is
     *              {@link DateTimeStatus }
     */
    public void setArrivalTimeStatus(DateTimeStatus value) {
        this.arrivalTimeStatus = value;
    }

    /**
     * Gets the value of the flightConnection property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFlightConnection() {
        return flightConnection;
    }

    /**
     * Sets the value of the flightConnection property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFlightConnection(String value) {
        this.flightConnection = value;
    }

}
