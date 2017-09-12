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
 * <p>Java class for ServiceType.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AlternativeScore"/>
 *     &lt;enumeration value="SEO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "ServiceType")
@XmlEnum
public enum ServiceType {


    /**
     * Search executed against "alternative scoring" rules loaded into Solr to allow experimenting with different
     * scoring parameters and
     * observing their effect on the result list. Sorting on Relevancy is a requirement for these searches.
     */
    @XmlEnumValue("AlternativeScore")
    ALTERNATIVE_SCORE("AlternativeScore"),

    /**
     * WEB-8257 - Differentiate SEO requests from matrix search with a flag
     */
    SEO("SEO");
    private final String value;

    ServiceType(String v) {
        value = v;
    }

    public static ServiceType fromValue(String v) {
        for (ServiceType c : ServiceType.values()) {
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
