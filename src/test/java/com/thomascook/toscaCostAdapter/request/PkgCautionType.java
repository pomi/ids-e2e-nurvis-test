//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:34 PM EEST 
//


package com.thomascook.toscaCostAdapter.request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Provides information regarding a package component which could affect a customer's decision to book.
 * <p>
 * <p>Java class for PkgCautionType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="PkgCautionType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FormattedTextTextType">
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
 *       &lt;attribute name="ItinerarySequence" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to3" />
 *       &lt;attribute name="Type" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="ID" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to16" />
 *       &lt;attribute name="ListOfItineraryItemRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *       &lt;attribute name="ListOfExtraRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PkgCautionType")
public class PkgCautionType
        extends FormattedTextTextType {

    @XmlAttribute(name = "ItinerarySequence")
    private Integer itinerarySequence;
    @XmlAttribute(name = "Type")
    private String type;
    @XmlAttribute(name = "ID")
    private String id;
    @XmlAttribute(name = "ListOfItineraryItemRPH")
    private List<String> listOfItineraryItemRPH;
    @XmlAttribute(name = "ListOfExtraRPH")
    private List<String> listOfExtraRPH;
    @XmlAttribute(name = "Start")
    private String start;
    @XmlAttribute(name = "Duration")
    private String duration;
    @XmlAttribute(name = "End")
    private String end;

    /**
     * Gets the value of the itinerarySequence property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getItinerarySequence() {
        return itinerarySequence;
    }

    /**
     * Sets the value of the itinerarySequence property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setItinerarySequence(Integer value) {
        this.itinerarySequence = value;
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
     * Gets the value of the listOfItineraryItemRPH property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfItineraryItemRPH property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfItineraryItemRPH().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getListOfItineraryItemRPH() {
        if (listOfItineraryItemRPH == null) {
            listOfItineraryItemRPH = new ArrayList<>();
        }
        return this.listOfItineraryItemRPH;
    }

    /**
     * Gets the value of the listOfExtraRPH property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfExtraRPH property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfExtraRPH().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getListOfExtraRPH() {
        if (listOfExtraRPH == null) {
            listOfExtraRPH = new ArrayList<>();
        }
        return this.listOfExtraRPH;
    }

    /**
     * Gets the value of the start property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStart(String value) {
        this.start = value;
    }

    /**
     * Gets the value of the duration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the end property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEnd() {
        return end;
    }

    /**
     * Sets the value of the end property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEnd(String value) {
        this.end = value;
    }

}
