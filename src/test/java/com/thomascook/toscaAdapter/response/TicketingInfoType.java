//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Minimum information about ticketing required to complete the booking transaction.
 * <p>
 * <p>Java class for TicketingInfoType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="TicketingInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TicketAdvisory" type="{http://www.opentravel.org/OTA/2003/05}FreeTextType" maxOccurs="10" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="TicketTimeLimit" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="TicketType" type="{http://www.opentravel.org/OTA/2003/05}TicketType" />
 *       &lt;attribute name="TicketingStatus" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="FlightSegmentRefNumber" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *       &lt;attribute name="TravelerRefNumber" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *       &lt;attribute name="ReverseTktgSegmentsInd" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="PseudoCityCode" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TicketingInfoType", propOrder = {
        "ticketAdvisory"
})
@XmlSeeAlso({
        TicketingInfoRSType.class
})
public class TicketingInfoType {

    @XmlElement(name = "TicketAdvisory")
    private List<FreeTextType> ticketAdvisory;
    @XmlAttribute(name = "TicketTimeLimit")
    @XmlSchemaType(name = "dateTime")
    private XMLGregorianCalendar ticketTimeLimit;
    @XmlAttribute(name = "TicketType")
    private TicketType ticketType;
    @XmlAttribute(name = "TicketingStatus")
    private String ticketingStatus;
    @XmlAttribute(name = "FlightSegmentRefNumber")
    private List<String> flightSegmentRefNumber;
    @XmlAttribute(name = "TravelerRefNumber")
    private List<String> travelerRefNumber;
    @XmlAttribute(name = "ReverseTktgSegmentsInd")
    private Boolean reverseTktgSegmentsInd;
    @XmlAttribute(name = "PseudoCityCode")
    private String pseudoCityCode;

    /**
     * Gets the value of the ticketAdvisory property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketAdvisory property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketAdvisory().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FreeTextType }
     */
    public List<FreeTextType> getTicketAdvisory() {
        if (ticketAdvisory == null) {
            ticketAdvisory = new ArrayList<>();
        }
        return this.ticketAdvisory;
    }

    /**
     * Gets the value of the ticketTimeLimit property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getTicketTimeLimit() {
        return ticketTimeLimit;
    }

    /**
     * Sets the value of the ticketTimeLimit property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setTicketTimeLimit(XMLGregorianCalendar value) {
        this.ticketTimeLimit = value;
    }

    /**
     * Gets the value of the ticketType property.
     *
     * @return possible object is
     * {@link TicketType }
     */
    public TicketType getTicketType() {
        return ticketType;
    }

    /**
     * Sets the value of the ticketType property.
     *
     * @param value allowed object is
     *              {@link TicketType }
     */
    public void setTicketType(TicketType value) {
        this.ticketType = value;
    }

    /**
     * Gets the value of the ticketingStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTicketingStatus() {
        return ticketingStatus;
    }

    /**
     * Sets the value of the ticketingStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTicketingStatus(String value) {
        this.ticketingStatus = value;
    }

    /**
     * Gets the value of the flightSegmentRefNumber property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flightSegmentRefNumber property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlightSegmentRefNumber().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getFlightSegmentRefNumber() {
        if (flightSegmentRefNumber == null) {
            flightSegmentRefNumber = new ArrayList<>();
        }
        return this.flightSegmentRefNumber;
    }

    /**
     * Gets the value of the travelerRefNumber property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the travelerRefNumber property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTravelerRefNumber().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getTravelerRefNumber() {
        if (travelerRefNumber == null) {
            travelerRefNumber = new ArrayList<>();
        }
        return this.travelerRefNumber;
    }

    /**
     * Gets the value of the reverseTktgSegmentsInd property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isReverseTktgSegmentsInd() {
        return reverseTktgSegmentsInd;
    }

    /**
     * Sets the value of the reverseTktgSegmentsInd property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setReverseTktgSegmentsInd(Boolean value) {
        this.reverseTktgSegmentsInd = value;
    }

    /**
     * Gets the value of the pseudoCityCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPseudoCityCode() {
        return pseudoCityCode;
    }

    /**
     * Sets the value of the pseudoCityCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPseudoCityCode(String value) {
        this.pseudoCityCode = value;
    }

}
