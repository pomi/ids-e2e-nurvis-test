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
 * <p>Java class for FreeChildFlagType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FreeChildFlagType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Yes"/>
 *     &lt;enumeration value="No"/>
 *     &lt;enumeration value="Fixed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreeChildFlagType")
@XmlEnum
public enum FreeChildFlagType {


    /**
     * Represents 'Y' free
     *                         child flag, it means that child price is 0.
     *                     
     * 
     */
    @XmlEnumValue("Yes")
    YES("Yes"),

    /**
     * Represents 'N' free
     *                         child flag, it means that child passanger cannot travel for free.
     *                     
     * 
     */
    @XmlEnumValue("No")
    NO("No"),

    /**
     * Represents 'F' free
     *                         child flag, it means that child price is fixed to a value, like
     *                         100 GBP
     *                     
     * 
     */
    @XmlEnumValue("Fixed")
    FIXED("Fixed");
    private final String value;

    FreeChildFlagType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FreeChildFlagType fromValue(String v) {
        for (FreeChildFlagType c: FreeChildFlagType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
