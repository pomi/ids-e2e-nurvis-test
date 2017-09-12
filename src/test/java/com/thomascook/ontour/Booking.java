package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Booking {
    private String status; // C 1
    private String localizer; // C 20
    private int pnr_version; //PNR_VERSION N 1-255
    private int ext_pnr_version; //EXT_PNR_VERSION N
    private String date; //DATE C 8 DDMMYYYY
    private String amendment_date; //AMENDMENT DATE C 8 DDMMYYYY
    private String ext_amendment_date; //EXT_AMENDMENT DATE C 8 DDMMYYYY
    private String beginning_date; //BEGINNING_DATE C 8 DDMMYYYY
    private String end_date; //END_DATE C 8 DDMMYYYY
    private String destination; //DESTINATION C 3
    private String product_code; //PRODUCT_CODE C 15
    private String to_code; //TO_CODE C 2
    private String brand; //BRAND C 15
    private String brochure_code; //BROCHURE_CODE C 10
    private String latebooking; //LATEBOOKING C 1 N/Y
    private List<Pax> pax; // (0..X) See corresponding tag
    private List<Service> service; //SERVICE (0..X) See corresponding tag
    private List<Booking_remark> booking_remark; //BOOKING_REMARK (0..X) See corresponding tag
    private List<Receipt> receipt; //RECEIPT (0..X) See corresponding tag

    public String getStatus() {
        return status;
    }

    @XmlElement(name = "STATUS")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocalizer() {
        return localizer;
    }

    @XmlElement(name = "LOCALIZER")
    public void setLocalizer(String localizer) {
        this.localizer = localizer;
    }

    public int getPnr_version() {
        return pnr_version;
    }

    @XmlElement(name = "PNR_VERSION")
    public void setPnr_version(int pnr_version) {
        this.pnr_version = pnr_version;
    }

    public int getExt_pnr_version() {
        return ext_pnr_version;
    }

    @XmlElement(name = "EXT_PNR_VERSION")
    public void setExt_pnr_version(int ext_pnr_version) {
        this.ext_pnr_version = ext_pnr_version;
    }

    public String getDate() {
        return date;
    }

    @XmlElement(name = "DATE")
    public void setDate(String date) {
        this.date = date;
    }

    public String getAmendment_date() {
        return amendment_date;
    }

    @XmlElement(name = "AMENDMENT_DATE")
    public void setAmendment_date(String amendment) {
        this.amendment_date = amendment;
    }

    public String getExt_amendment_date() {
        return ext_amendment_date;
    }

    @XmlElement(name = "EXT_AMENDMENT_DATE")
    public void setExt_amendment_date(String ext_amendment) {
        this.ext_amendment_date = ext_amendment;
    }

    public String getBeginning_date() {
        return beginning_date;
    }

    @XmlElement(name = "BEGINNING_DATE")
    public void setBeginning_date(String beginning_date) {
        this.beginning_date = beginning_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    @XmlElement(name = "END_DATE")
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDestination() {
        return destination;
    }

    @XmlElement(name = "DESTINATION")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getProduct_code() {
        return product_code;
    }

    @XmlElement(name = "PRODUCT_CODE")
    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getTo_code() {
        return to_code;
    }

    @XmlElement(name = "TO_CODE")
    public void setTo_code(String to_code) {
        this.to_code = to_code;
    }

    public String getBrand() {
        return brand;
    }

    @XmlElement(name = "BRAND")
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrochure_code() {
        return brochure_code;
    }

    @XmlElement(name = "BROCHURE_CODE")
    public void setBrochure_code(String brochure_code) {
        this.brochure_code = brochure_code;
    }

    public String getLatebooking() {
        return latebooking;
    }

    @XmlElement(name = "LATEBOOKING")
    public void setLatebooking(String latebooking) {
        this.latebooking = latebooking;
    }

    public List<Pax> getPax() {
        return pax;
    }

    @XmlElement(name = "PAX")
    public void setPax(List<Pax> pax) {
        this.pax = pax;
    }

    public List<Service> getService() {
        return service;
    }

    @XmlElement(name = "SERVICE")
    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<Booking_remark> getBooking_remark() {
        return booking_remark;
    }

    @XmlElement(name = "BOOKING_REMARK")
    public void setBooking_remark(List<Booking_remark> booking_remark) {
        this.booking_remark = booking_remark;
    }

    public List<Receipt> getReceipt() {
        return receipt;
    }

    @XmlElement(name = "RECEIPT")
    public void setReceipt(List<Receipt> receipt) {
        this.receipt = receipt;
    }
}
