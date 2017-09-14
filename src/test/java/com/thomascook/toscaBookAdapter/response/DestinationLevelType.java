//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:47 PM EEST 
//


package com.thomascook.toscaBookAdapter.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DestinationLevelType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DestinationLevelType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Continent"/>
 *     &lt;enumeration value="Country"/>
 *     &lt;enumeration value="State"/>
 *     &lt;enumeration value="Area"/>
 *     &lt;enumeration value="SubArea"/>
 *     &lt;enumeration value="Resort"/>
 *     &lt;enumeration value="District"/>
 *     &lt;enumeration value="Region"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "DestinationLevelType")
@XmlEnum
public enum DestinationLevelType {

    @XmlEnumValue("Continent")
    CONTINENT("Continent"),
    @XmlEnumValue("Country")
    COUNTRY("Country"),
    @XmlEnumValue("State")
    STATE("State"),
    @XmlEnumValue("Area")
    AREA("Area"),
    @XmlEnumValue("SubArea")
    SUB_AREA("SubArea"),
    @XmlEnumValue("Resort")
    RESORT("Resort"),
    @XmlEnumValue("District")
    DISTRICT("District"),
    @XmlEnumValue("Region")
    REGION("Region");
    private final String value;

    DestinationLevelType(String v) {
        value = v;
    }

    public static DestinationLevelType fromValue(String v) {
        for (DestinationLevelType c : DestinationLevelType.values()) {
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
