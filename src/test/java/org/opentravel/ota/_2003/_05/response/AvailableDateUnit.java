//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 06:35:24 PM EEST 
//


package org.opentravel.ota._2003._05.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AvailableDateUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AvailableDateUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Month"/>
 *     &lt;enumeration value="Week"/>
 *     &lt;enumeration value="Day"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AvailableDateUnit")
@XmlEnum
public enum AvailableDateUnit {

    @XmlEnumValue("Month")
    MONTH("Month"),
    @XmlEnumValue("Week")
    WEEK("Week"),
    @XmlEnumValue("Day")
    DAY("Day");
    private final String value;

    AvailableDateUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AvailableDateUnit fromValue(String v) {
        for (AvailableDateUnit c: AvailableDateUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
