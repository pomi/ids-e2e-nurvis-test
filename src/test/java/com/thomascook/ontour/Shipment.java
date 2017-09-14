package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by omm on 2/8/2017.
 */

@XmlRootElement(name = "SHIPMENT")
@XmlType(propOrder = {
        "identifier",
        "emitter_code",
        "office_code",
        "shipment_date",
        "number_booking",
        "version",
        "booking"
})
public class Shipment {

    private int identifier;
    private String emitter_code;
    private String office_code;
    private String shipment_date;
    private int number_booking;
    private String version;
    private List<Booking> booking;

    public List<Booking> getBooking() {
        return booking;
    }

    @XmlElement(name = "BOOKING")
    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    public int getIdentifier() {
        return identifier;
    }

    @XmlElement(name = "IDENTIFIER")
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getEmitter_code() {
        return emitter_code;
    }

    @XmlElement(name = "EMITTER_CODE")
    public void setEmitter_code(String emitter_code) {
        this.emitter_code = emitter_code;
    }

    public String getOffice_code() {
        return office_code;
    }

    @XmlElement(name = "OFFICE_CODE")
    public void setOffice_code(String office_code) {
        this.office_code = office_code;
    }

    public String getShipment_date() {
        return shipment_date;
    }

    @XmlElement(name = "SHIPMENT_DATE")
    public void setShipment_date(String shipment_date) {
        this.shipment_date = shipment_date;
    }

    public int getNumber_booking() {
        return number_booking;
    }

    @XmlElement(name = "NUMBER_BOOKING")
    public void setNumber_booking(int number_booking) {
        this.number_booking = number_booking;
    }

    public String getVersion() {
        return version;
    }

    @XmlElement(name = "VERSION")
    public void setVersion(String version) {
        this.version = version;
    }
}

