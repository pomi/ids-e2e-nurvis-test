//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 04:28:21 PM EEST 
//


package com.thomascook.wrAdapter.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PMS_ResStatusType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PMS_ResStatusType">
 *   &lt;restriction base="{}StringLength1to16">
 *     &lt;enumeration value="Reserved"/>
 *     &lt;enumeration value="Requested"/>
 *     &lt;enumeration value="Request denied"/>
 *     &lt;enumeration value="No-show"/>
 *     &lt;enumeration value="Cancelled"/>
 *     &lt;enumeration value="In-house"/>
 *     &lt;enumeration value="Checked out"/>
 *     &lt;enumeration value="Waitlisted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "PMS_ResStatusType")
@XmlEnum
public enum PMSResStatusType {


    /**
     * The reservation has been reserved.
     */
    @XmlEnumValue("Reserved")
    RESERVED("Reserved"),

    /**
     * The reservation has been requested but has not yet been reserved.
     */
    @XmlEnumValue("Requested")
    REQUESTED("Requested"),

    /**
     * The request for the reservation has been denied.
     */
    @XmlEnumValue("Request denied")
    REQUEST_DENIED("Request denied"),

    /**
     * This reservation is in "no show" status. Typically this means the
     * person for whom this reservation belonged did not check in and the reservation was
     * moved to "no show" status.
     */
    @XmlEnumValue("No-show")
    NO_SHOW("No-show"),

    /**
     * This reservation has been cancelled.
     */
    @XmlEnumValue("Cancelled")
    CANCELLED("Cancelled"),

    /**
     * This reservation has been check in, and is in "in-house" status.
     */
    @XmlEnumValue("In-house")
    IN_HOUSE("In-house"),

    /**
     * The guest has checked out and the reservation has been changed to
     * "Checked out" status
     */
    @XmlEnumValue("Checked out")
    CHECKED_OUT("Checked out"),

    /**
     * This reservation is in waitlist status and the reservation has not
     * been confirmed.
     */
    @XmlEnumValue("Waitlisted")
    WAITLISTED("Waitlisted");
    private final String value;

    PMSResStatusType(String v) {
        value = v;
    }

    public static PMSResStatusType fromValue(String v) {
        for (PMSResStatusType c : PMSResStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

}
