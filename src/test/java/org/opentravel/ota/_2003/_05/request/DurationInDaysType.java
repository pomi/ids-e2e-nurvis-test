//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package org.opentravel.ota._2003._05.request;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Defines a group of
 * durations expressed as the exact number of days.
 * <p>
 * <p>
 * <p>Java class for DurationInDaysType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DurationInDaysType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DurationInDay" type="{http://www.opentravel.org/OTA/2003/05}Numeric1to99" maxOccurs="99"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DurationInDaysType", propOrder = {
        "durationInDay"
})
public class DurationInDaysType {

    @XmlElement(name = "DurationInDay", type = Integer.class)
    @XmlSchemaType(name = "integer")
    private List<Integer> durationInDay;

    /**
     * Gets the value of the durationInDay property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the durationInDay property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDurationInDay().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     */
    public List<Integer> getDurationInDay() {
        if (durationInDay == null) {
            durationInDay = new ArrayList<>();
        }
        return this.durationInDay;
    }

}
