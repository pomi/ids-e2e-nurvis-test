//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.15 at 11:09:51 AM EEST 
//


package com.thomascook.toscaAdapter.response;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Details of an operating schedule (e.g. a golf tee time may be more expensive during peak hours v. off peak hours).
 * <p>
 * <p>Java class for OperationScheduleType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="OperationScheduleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="OperationTimes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="OperationTime" maxOccurs="999">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
 *                           &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DOW_PatternGroup"/>
 *                           &lt;attribute name="AdditionalOperationInfoCode" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
 *                           &lt;attribute name="Frequency" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
 *                           &lt;attribute name="Text" type="{http://www.opentravel.org/OTA/2003/05}StringLength0to64" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OperationScheduleType", propOrder = {
        "operationTimes"
})
@XmlSeeAlso({
        PeriodPriceType.class
})
public class OperationScheduleType {

    @XmlElement(name = "OperationTimes")
    private OperationTimes operationTimes;
    @XmlAttribute(name = "Start")
    private String start;
    @XmlAttribute(name = "Duration")
    private String duration;
    @XmlAttribute(name = "End")
    private String end;

    /**
     * Gets the value of the operationTimes property.
     *
     * @return possible object is
     * {@link OperationTimes }
     */
    public OperationTimes getOperationTimes() {
        return operationTimes;
    }

    /**
     * Sets the value of the operationTimes property.
     *
     * @param value allowed object is
     *              {@link OperationTimes }
     */
    public void setOperationTimes(OperationTimes value) {
        this.operationTimes = value;
    }

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
     * Gets the value of the duration property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDuration(String value) {
        this.duration = value;
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
     *         &lt;element name="OperationTime" maxOccurs="999">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
     *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DOW_PatternGroup"/>
     *                 &lt;attribute name="AdditionalOperationInfoCode" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
     *                 &lt;attribute name="Frequency" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
     *                 &lt;attribute name="Text" type="{http://www.opentravel.org/OTA/2003/05}StringLength0to64" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "operationTime"
    })
    public static class OperationTimes {

        @XmlElement(name = "OperationTime", required = true)
        List<OperationTime> operationTime;

        /**
         * Gets the value of the operationTime property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the operationTime property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOperationTime().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OperationTime }
         */
        public List<OperationTime> getOperationTime() {
            if (operationTime == null) {
                operationTime = new ArrayList<>();
            }
            return this.operationTime;
        }


        /**
         * <p>Java class for anonymous complex type.
         * <p>
         * <p>The following schema fragment specifies the expected content contained within this class.
         * <p>
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DateTimeSpanGroup"/>
         *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}DOW_PatternGroup"/>
         *       &lt;attribute name="AdditionalOperationInfoCode" type="{http://www.opentravel.org/OTA/2003/05}OTA_CodeType" />
         *       &lt;attribute name="Frequency" type="{http://www.opentravel.org/OTA/2003/05}StringLength1to64" />
         *       &lt;attribute name="Text" type="{http://www.opentravel.org/OTA/2003/05}StringLength0to64" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class OperationTime {

            @XmlAttribute(name = "AdditionalOperationInfoCode")
            String additionalOperationInfoCode;
            @XmlAttribute(name = "Frequency")
            String frequency;
            @XmlAttribute(name = "Text")
            String text;
            @XmlAttribute(name = "Start")
            String start;
            @XmlAttribute(name = "Duration")
            String duration;
            @XmlAttribute(name = "End")
            String end;
            @XmlAttribute(name = "Mon")
            Boolean mon;
            @XmlAttribute(name = "Tue")
            Boolean tue;
            @XmlAttribute(name = "Weds")
            Boolean weds;
            @XmlAttribute(name = "Thur")
            Boolean thur;
            @XmlAttribute(name = "Fri")
            Boolean fri;
            @XmlAttribute(name = "Sat")
            Boolean sat;
            @XmlAttribute(name = "Sun")
            Boolean sun;

            /**
             * Gets the value of the additionalOperationInfoCode property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getAdditionalOperationInfoCode() {
                return additionalOperationInfoCode;
            }

            /**
             * Sets the value of the additionalOperationInfoCode property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setAdditionalOperationInfoCode(String value) {
                this.additionalOperationInfoCode = value;
            }

            /**
             * Gets the value of the frequency property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getFrequency() {
                return frequency;
            }

            /**
             * Sets the value of the frequency property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setFrequency(String value) {
                this.frequency = value;
            }

            /**
             * Gets the value of the text property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setText(String value) {
                this.text = value;
            }

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
             * Gets the value of the duration property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getDuration() {
                return duration;
            }

            /**
             * Sets the value of the duration property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setDuration(String value) {
                this.duration = value;
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

            /**
             * Gets the value of the mon property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isMon() {
                return mon;
            }

            /**
             * Sets the value of the mon property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setMon(Boolean value) {
                this.mon = value;
            }

            /**
             * Gets the value of the tue property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isTue() {
                return tue;
            }

            /**
             * Sets the value of the tue property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setTue(Boolean value) {
                this.tue = value;
            }

            /**
             * Gets the value of the weds property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isWeds() {
                return weds;
            }

            /**
             * Sets the value of the weds property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setWeds(Boolean value) {
                this.weds = value;
            }

            /**
             * Gets the value of the thur property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isThur() {
                return thur;
            }

            /**
             * Sets the value of the thur property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setThur(Boolean value) {
                this.thur = value;
            }

            /**
             * Gets the value of the fri property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isFri() {
                return fri;
            }

            /**
             * Sets the value of the fri property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setFri(Boolean value) {
                this.fri = value;
            }

            /**
             * Gets the value of the sat property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isSat() {
                return sat;
            }

            /**
             * Sets the value of the sat property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setSat(Boolean value) {
                this.sat = value;
            }

            /**
             * Gets the value of the sun property.
             *
             * @return possible object is
             * {@link Boolean }
             */
            public Boolean isSun() {
                return sun;
            }

            /**
             * Sets the value of the sun property.
             *
             * @param value allowed object is
             *              {@link Boolean }
             */
            public void setSun(Boolean value) {
                this.sun = value;
            }

        }

    }

}
