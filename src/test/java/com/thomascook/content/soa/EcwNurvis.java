//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.27 at 04:27:20 PM EEST 
//


package com.thomascook.content.soa;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for EcwNurvis complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="EcwNurvis">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.thomascook.com/content/soa}BasePackage">
 *       &lt;attribute name="Brand" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Season" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ProductBookingCode" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Ekms" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Catalog" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EcwNurvis")
@XmlSeeAlso({
        Request.EcwNurvis.Package.class
})
public class EcwNurvis
        extends BasePackage {

    @XmlAttribute(name = "Brand", required = true)
    private String brand;
    @XmlAttribute(name = "Season", required = true)
    private String season;
    @XmlAttribute(name = "ProductBookingCode")
    private String productBookingCode;
    @XmlAttribute(name = "Ekms")
    private String ekms;
    @XmlAttribute(name = "Catalog", required = true)
    private String catalog;

    /**
     * Gets the value of the brand property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the value of the brand property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBrand(String value) {
        this.brand = value;
    }

    /**
     * Gets the value of the season property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSeason() {
        return season;
    }

    /**
     * Sets the value of the season property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSeason(String value) {
        this.season = value;
    }

    /**
     * Gets the value of the productBookingCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProductBookingCode() {
        return productBookingCode;
    }

    /**
     * Sets the value of the productBookingCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProductBookingCode(String value) {
        this.productBookingCode = value;
    }

    /**
     * Gets the value of the ekms property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEkms() {
        return ekms;
    }

    /**
     * Sets the value of the ekms property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEkms(String value) {
        this.ekms = value;
    }

    /**
     * Gets the value of the catalog property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCatalog() {
        return catalog;
    }

    /**
     * Sets the value of the catalog property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCatalog(String value) {
        this.catalog = value;
    }

}
