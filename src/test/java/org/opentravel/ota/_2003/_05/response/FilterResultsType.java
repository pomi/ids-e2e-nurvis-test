//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.29 at 06:35:24 PM EEST 
//


package org.opentravel.ota._2003._05.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Specifies the desired
 * subset of the package result list. Used primarily to support
 * pagination. It is specified as
 * a range within the result list with
 * the index of the first and last package that should be included in
 * the response. Packages in the result list are ordered
 * based on
 * SortResults element and are indexed from 0. This filtering will not
 * affect facet calculation (packages filtered out are still considered
 * in the
 * facet counts).
 * <p>
 * <p>
 * <p>Java class for FilterResults_Type complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="FilterResults_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="start" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="end" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilterResults_Type")
public class FilterResultsType {

    @XmlAttribute(name = "start", required = true)
    private String start;
    @XmlAttribute(name = "end")
    private String end;

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
