//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.30 at 05:53:57 PM EEST 
//


package com.thomascook.toscaBookAdapter.request;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * Details of meal arrangements, booked or available according to context, with appropriate supplementary charges.
 * <p>
 * <p>Java class for MealPlanType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="MealPlanType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustomerCounts" type="{http://www.opentravel.org/OTA/2003/05}CustomerCountsType" minOccurs="0"/>
 *         &lt;element name="PassengerRPHs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="ListOfPassengerRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Prices" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Price" maxOccurs="9">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PriceGroup"/>
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
 *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}MealPlanGroup"/>
 *       &lt;attribute name="ListOfRoomRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MealPlanType", propOrder = {
        "customerCounts",
        "passengerRPHs",
        "prices"
})
public class MealPlanType {

    @XmlElement(name = "CustomerCounts")
    private CustomerCountsType customerCounts;
    @XmlElement(name = "PassengerRPHs")
    private PassengerRPHs passengerRPHs;
    @XmlElement(name = "Prices")
    private Prices prices;
    @XmlAttribute(name = "ListOfRoomRPH")
    private List<String> listOfRoomRPH;
    @XmlAttribute(name = "Plan")
    private String plan;
    @XmlAttribute(name = "Code", required = true)
    private String code;
    @XmlAttribute(name = "RPH")
    private String rph;
    @XmlAttribute(name = "Quantity")
    @XmlSchemaType(name = "nonNegativeInteger")
    private BigInteger quantity;

    /**
     * Gets the value of the customerCounts property.
     *
     * @return possible object is
     * {@link CustomerCountsType }
     */
    public CustomerCountsType getCustomerCounts() {
        return customerCounts;
    }

    /**
     * Sets the value of the customerCounts property.
     *
     * @param value allowed object is
     *              {@link CustomerCountsType }
     */
    public void setCustomerCounts(CustomerCountsType value) {
        this.customerCounts = value;
    }

    /**
     * Gets the value of the passengerRPHs property.
     *
     * @return possible object is
     * {@link PassengerRPHs }
     */
    public PassengerRPHs getPassengerRPHs() {
        return passengerRPHs;
    }

    /**
     * Sets the value of the passengerRPHs property.
     *
     * @param value allowed object is
     *              {@link PassengerRPHs }
     */
    public void setPassengerRPHs(PassengerRPHs value) {
        this.passengerRPHs = value;
    }

    /**
     * Gets the value of the prices property.
     *
     * @return possible object is
     * {@link Prices }
     */
    public Prices getPrices() {
        return prices;
    }

    /**
     * Sets the value of the prices property.
     *
     * @param value allowed object is
     *              {@link Prices }
     */
    public void setPrices(Prices value) {
        this.prices = value;
    }

    /**
     * Gets the value of the listOfRoomRPH property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listOfRoomRPH property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListOfRoomRPH().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getListOfRoomRPH() {
        if (listOfRoomRPH == null) {
            listOfRoomRPH = new ArrayList<>();
        }
        return this.listOfRoomRPH;
    }

    /**
     * Gets the value of the plan property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPlan() {
        return plan;
    }

    /**
     * Sets the value of the plan property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPlan(String value) {
        this.plan = value;
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
     * Gets the value of the rph property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRPH() {
        return rph;
    }

    /**
     * Sets the value of the rph property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRPH(String value) {
        this.rph = value;
    }

    /**
     * Gets the value of the quantity property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setQuantity(BigInteger value) {
        this.quantity = value;
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
     *       &lt;attribute name="ListOfPassengerRPH" type="{http://www.opentravel.org/OTA/2003/05}ListOfRPH" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class PassengerRPHs {

        @XmlAttribute(name = "ListOfPassengerRPH")
        List<String> listOfPassengerRPH;

        /**
         * Gets the value of the listOfPassengerRPH property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the listOfPassengerRPH property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getListOfPassengerRPH().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         */
        public List<String> getListOfPassengerRPH() {
            if (listOfPassengerRPH == null) {
                listOfPassengerRPH = new ArrayList<>();
            }
            return this.listOfPassengerRPH;
        }

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
     *         &lt;element name="Price" maxOccurs="9">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PriceGroup"/>
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
            "price"
    })
    public static class Prices {

        @XmlElement(name = "Price", required = true)
        List<Price> price;

        /**
         * Gets the value of the price property.
         * <p>
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the price property.
         * <p>
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrice().add(newItem);
         * </pre>
         * <p>
         * <p>
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Price }
         */
        public List<Price> getPrice() {
            if (price == null) {
                price = new ArrayList<>();
            }
            return this.price;
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
         *       &lt;attGroup ref="{http://www.opentravel.org/OTA/2003/05}PriceGroup"/>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Price {

            @XmlAttribute(name = "PriceQualifier")
            Integer priceQualifier;
            @XmlAttribute(name = "PriceBasis")
            PricingType priceBasis;
            @XmlAttribute(name = "Amount")
            BigDecimal amount;
            @XmlAttribute(name = "CurrencyCode")
            String currencyCode;
            @XmlAttribute(name = "DecimalPlaces")
            @XmlSchemaType(name = "nonNegativeInteger")
            BigInteger decimalPlaces;
            @XmlAttribute(name = "AgeQualifyingCode")
            String ageQualifyingCode;
            @XmlAttribute(name = "Age")
            Integer age;
            @XmlAttribute(name = "Count")
            Integer count;

            /**
             * Gets the value of the priceQualifier property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getPriceQualifier() {
                return priceQualifier;
            }

            /**
             * Sets the value of the priceQualifier property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setPriceQualifier(Integer value) {
                this.priceQualifier = value;
            }

            /**
             * Gets the value of the priceBasis property.
             *
             * @return possible object is
             * {@link PricingType }
             */
            public PricingType getPriceBasis() {
                return priceBasis;
            }

            /**
             * Sets the value of the priceBasis property.
             *
             * @param value allowed object is
             *              {@link PricingType }
             */
            public void setPriceBasis(PricingType value) {
                this.priceBasis = value;
            }

            /**
             * Gets the value of the amount property.
             *
             * @return possible object is
             * {@link BigDecimal }
             */
            public BigDecimal getAmount() {
                return amount;
            }

            /**
             * Sets the value of the amount property.
             *
             * @param value allowed object is
             *              {@link BigDecimal }
             */
            public void setAmount(BigDecimal value) {
                this.amount = value;
            }

            /**
             * Gets the value of the currencyCode property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getCurrencyCode() {
                return currencyCode;
            }

            /**
             * Sets the value of the currencyCode property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setCurrencyCode(String value) {
                this.currencyCode = value;
            }

            /**
             * Gets the value of the decimalPlaces property.
             *
             * @return possible object is
             * {@link BigInteger }
             */
            public BigInteger getDecimalPlaces() {
                return decimalPlaces;
            }

            /**
             * Sets the value of the decimalPlaces property.
             *
             * @param value allowed object is
             *              {@link BigInteger }
             */
            public void setDecimalPlaces(BigInteger value) {
                this.decimalPlaces = value;
            }

            /**
             * Gets the value of the ageQualifyingCode property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getAgeQualifyingCode() {
                return ageQualifyingCode;
            }

            /**
             * Sets the value of the ageQualifyingCode property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setAgeQualifyingCode(String value) {
                this.ageQualifyingCode = value;
            }

            /**
             * Gets the value of the age property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getAge() {
                return age;
            }

            /**
             * Sets the value of the age property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setAge(Integer value) {
                this.age = value;
            }

            /**
             * Gets the value of the count property.
             *
             * @return possible object is
             * {@link Integer }
             */
            public Integer getCount() {
                return count;
            }

            /**
             * Sets the value of the count property.
             *
             * @param value allowed object is
             *              {@link Integer }
             */
            public void setCount(Integer value) {
                this.count = value;
            }

        }

    }

}
