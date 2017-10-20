//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.06 at 04:28:34 PM EEST 
//


package com.thomascook.wrAdapter.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferActionType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TransferActionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="Automatic"/>
 *     &lt;enumeration value="Mandatory"/>
 *     &lt;enumeration value="Selectable"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TransferActionType")
@XmlEnum
public enum TransferActionType {


    /**
     * Indicates transfer when in automatic mode.
     */
    @XmlEnumValue("Automatic")
    AUTOMATIC("Automatic"),

    /**
     * Indicates transfer required in all modes.
     */
    @XmlEnumValue("Mandatory")
    MANDATORY("Mandatory"),

    /**
     * Indicates transfer when in selectable mode.
     */
    @XmlEnumValue("Selectable")
    SELECTABLE("Selectable");
    private final String value;

    TransferActionType(String v) {
        value = v;
    }

    public static TransferActionType fromValue(String v) {
        for (TransferActionType c : TransferActionType.values()) {
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
