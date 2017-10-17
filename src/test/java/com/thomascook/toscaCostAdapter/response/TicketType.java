//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.28 at 01:25:48 PM EEST 
//


package com.thomascook.toscaCostAdapter.response;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TicketType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TicketType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *     &lt;enumeration value="eTicket"/>
 *     &lt;enumeration value="Paper"/>
 *     &lt;enumeration value="MCO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "TicketType")
@XmlEnum
public enum TicketType {


    /**
     * An electronic ticket
     */
    @XmlEnumValue("eTicket")
    E_TICKET("eTicket"),

    /**
     * A paper ticket
     */
    @XmlEnumValue("Paper")
    PAPER("Paper"),

    /**
     * A miscellaneous charge order
     */
    MCO("MCO");
    private final String value;

    TicketType(String v) {
        value = v;
    }

    public static TicketType fromValue(String v) {
        for (TicketType c : TicketType.values()) {
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
