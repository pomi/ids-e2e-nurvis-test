//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:57 PM EEST 
//


package com.thomascook.toscaBookAdapter.request;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CabinType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CabinType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="First"/>
 *     &lt;enumeration value="Business"/>
 *     &lt;enumeration value="Economy"/>
 *     &lt;enumeration value="P"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CabinType")
@XmlEnum
public enum CabinType {


    /**
     * First class compartment.
     */
    @XmlEnumValue("First")
    FIRST("First"),

    /**
     * Business class compartment.
     */
    @XmlEnumValue("Business")
    BUSINESS("Business"),

    /**
     * Economy (or sometimes referred to as Coach) class compartment.
     */
    @XmlEnumValue("Economy")
    ECONOMY("Economy"),

    /**
     * Premium Cabin
     */
    P("P");
    private final String value;

    CabinType(String v) {
        value = v;
    }

    public static CabinType fromValue(String v) {
        for (CabinType c : CabinType.values()) {
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
