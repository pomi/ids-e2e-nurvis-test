//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.tripadvisor;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.thomascook.com/content/tripadvisor}TripadvisorOverview" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="URI" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tripadvisorOverview"
})
@XmlRootElement(name = "Tripadvisor")
public class Tripadvisor {

    @XmlElement(name = "TripadvisorOverview")
    private TripadvisorOverviewType tripadvisorOverview;
    @XmlAttribute(name = "URI")
    private String uri;

    /**
     * Gets the value of the tripadvisorOverview property.
     *
     * @return possible object is
     * {@link TripadvisorOverviewType }
     */
    public TripadvisorOverviewType getTripadvisorOverview() {
        return tripadvisorOverview;
    }

    /**
     * Sets the value of the tripadvisorOverview property.
     *
     * @param value allowed object is
     *              {@link TripadvisorOverviewType }
     */
    public void setTripadvisorOverview(TripadvisorOverviewType value) {
        this.tripadvisorOverview = value;
    }

    /**
     * Gets the value of the uri property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getURI() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setURI(String value) {
        this.uri = value;
    }

}
