//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:45 AM EEST 
//


package com.thomascook.toscaAdapter.request;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.Duration;


/**
 * Specifies a time window.
 * <p>
 * <p>Java class for TimeInstantType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="TimeInstantType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>DateOrDateTimeType">
 *       &lt;attribute name="WindowBefore" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="WindowAfter" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="CrossDateAllowedIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeInstantType", propOrder = {
        "value"
})
public class TimeInstantType {

    @XmlValue
    private String value;
    @XmlAttribute(name = "WindowBefore")
    private Duration windowBefore;
    @XmlAttribute(name = "WindowAfter")
    private Duration windowAfter;
    @XmlAttribute(name = "CrossDateAllowedIndicator")
    private Boolean crossDateAllowedIndicator;

    /**
     * A construct to validate either a date or a dateTime value.
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
     * Gets the value of the windowBefore property.
     *
     * @return possible object is
     * {@link Duration }
     */
    public Duration getWindowBefore() {
        return windowBefore;
    }

    /**
     * Sets the value of the windowBefore property.
     *
     * @param value allowed object is
     *              {@link Duration }
     */
    public void setWindowBefore(Duration value) {
        this.windowBefore = value;
    }

    /**
     * Gets the value of the windowAfter property.
     *
     * @return possible object is
     * {@link Duration }
     */
    public Duration getWindowAfter() {
        return windowAfter;
    }

    /**
     * Sets the value of the windowAfter property.
     *
     * @param value allowed object is
     *              {@link Duration }
     */
    public void setWindowAfter(Duration value) {
        this.windowAfter = value;
    }

    /**
     * Gets the value of the crossDateAllowedIndicator property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isCrossDateAllowedIndicator() {
        return crossDateAllowedIndicator;
    }

    /**
     * Sets the value of the crossDateAllowedIndicator property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setCrossDateAllowedIndicator(Boolean value) {
        this.crossDateAllowedIndicator = value;
    }

}
