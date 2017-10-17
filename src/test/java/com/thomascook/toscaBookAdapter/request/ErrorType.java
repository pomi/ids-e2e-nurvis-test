//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:57 PM EEST 
//


package com.thomascook.toscaBookAdapter.request;

import javax.xml.bind.annotation.*;


/**
 * Standard way to indicate that an error occurred during the processing of an OTA message
 * <p>
 * <p>Java class for ErrorType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ErrorType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.opentravel.org/OTA/2003/05>FreeTextType">
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}ErrorWarningAttributeGroup"/>
 *       &lt;attribute name="Type" use="required" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *       &lt;attribute name="NodeList" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ErrorType")
public class ErrorType
        extends FreeTextType {

    @XmlAttribute(name = "Type", required = true)
    private String type;
    @XmlAttribute(name = "NodeList")
    private String nodeList;
    @XmlAttribute(name = "ShortText")
    private String shortText;
    @XmlAttribute(name = "Code")
    private String code;
    @XmlAttribute(name = "DocURL")
    @XmlSchemaType(name = "anyURI")
    private String docURL;
    @XmlAttribute(name = "Status")
    private String status;
    @XmlAttribute(name = "Tag")
    private String tag;
    @XmlAttribute(name = "RecordID")
    private String recordID;

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the nodeList property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNodeList() {
        return nodeList;
    }

    /**
     * Sets the value of the nodeList property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNodeList(String value) {
        this.nodeList = value;
    }

    /**
     * Gets the value of the shortText property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getShortText() {
        return shortText;
    }

    /**
     * Sets the value of the shortText property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setShortText(String value) {
        this.shortText = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the docURL property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDocURL() {
        return docURL;
    }

    /**
     * Sets the value of the docURL property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDocURL(String value) {
        this.docURL = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the tag property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets the value of the tag property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTag(String value) {
        this.tag = value;
    }

    /**
     * Gets the value of the recordID property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRecordID() {
        return recordID;
    }

    /**
     * Sets the value of the recordID property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRecordID(String value) {
        this.recordID = value;
    }

}
