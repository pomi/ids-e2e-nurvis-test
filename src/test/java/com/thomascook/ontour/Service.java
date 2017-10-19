package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by omm on 7/26/2017.
 */
@XmlType(propOrder = {
        "code",
        "type",
        "name",
        "order",
        "beginning_date",
        "beginning_time",
        "end_date",
        "end_time",
        "accomodation",
        "board",
        "status",
        "shared_room_type",
        "shared_localizer",
        "characteristic",
        "transfer_type",
        "origin",
        "destination",
        "carrier_code",
        "carrier_flight_code",
        "allotment",
        "identifier",
        "occupancy",
        "numberofunits",
        "transfer_code",
        "external_service_flag",
        "external_service_supplier",
        "notification_flag",
        "tourguide_flag",
        "transfer_booked_external",
        "transfer_start",
        "transfer_end",
        "servicelevel",
        "pax_service",
        "service_remark",
        "tourguide_assignment",
        "environment_criteria"
})
public class Service {

    public class TypeId {
        public static final String TRANSPORT = "FL";
        public static final String ACCOMMODATION = "RM";
        public static final String TRANSFER = "TR";
        public static final String EXTRAS = "MI";
    }

    private String code = "";
    private String type = "";
    private String name = "";
    private int order = 0;
    private String beginning_date = "";
    private String beginning_time = "";
    private String end_date = "";
    private String end_time = "";
    private String accomodation = "";
    private String board = "";
    private String status = "";
    private String shared_room_type = "";
    private String shared_localizer = "";
    private String characteristic = "";
    private String transfer_type = "";
    private String origin = "";
    private String destination = "";
    private String carrier_code = "";
    private String carrier_flight_code = "";
    private int allotment = 0;
    private String identifier = "";
    private String occupancy = "";
    private int numberofunits = 0;
    private String transfer_code = "";
    private String external_service_flag = "";
    private String external_service_supplier = "";
    private String notification_flag = "";
    private String tourguide_flag = "";
    private String transfer_booked_external = "";
    private String transfer_start = "";
    private String transfer_end = "";
    private String servicelevel = "";
    private List<Pax_service> pax_service;
    private List<Service_remark> service_remark;
    private List<Tourguide_assignment> tourguide_assignment;
    private List<Environment_criteria> environment_criteria;

    public List<Pax_service> getPax_service() {
        return pax_service;
    }

    @XmlElement(name = "PAX_SERVICE")
    public void setPax_service(List<Pax_service> pax_service) {
        this.pax_service = pax_service;
    }

    public String getCode() {
        return code;
    }

    @XmlElement(name = "CODE")
    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    @XmlElement(name = "TYPE")
    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    @XmlElement(name = "ORDER")
    public void setOrder(int order) {
        this.order = order;
    }

    public String getBeginning_date() {
        return beginning_date;
    }

    @XmlElement(name = "BEGINNING_DATE")
    public void setBeginning_date(String beginning_date) {
        this.beginning_date = beginning_date;
    }

    public String getBeginning_time() {
        return beginning_time;
    }

    @XmlElement(name = "BEGINNING_TIME")
    public void setBeginning_time(String beginning_time) {
        this.beginning_time = beginning_time;
    }

    public String getEnd_date() {
        return end_date;
    }

    @XmlElement(name = "END_DATE")
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getEnd_time() {
        return end_time;
    }

    @XmlElement(name = "END_TIME")
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getAccomodation() {
        return accomodation;
    }

    @XmlElement(name = "ACCOMODATION")
    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public String getBoard() {
        return board;
    }

    @XmlElement(name = "BOARD")
    public void setBoard(String board) {
        this.board = board;
    }

    public String getStatus() {
        return status;
    }

    @XmlElement(name = "STATUS")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getShared_room_type() {
        return shared_room_type;
    }

    @XmlElement(name = "SHARED_ROOM_TYPE")
    public void setShared_room_type(String shared_room_type) {
        this.shared_room_type = shared_room_type;
    }

    public String getShared_localizer() {
        return shared_localizer;
    }

    @XmlElement(name = "SHARED_LOCALIZER")
    public void setShared_localizer(String shared_localizer) {
        this.shared_localizer = shared_localizer;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    @XmlElement(name = "CHARACTERISTIC")
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getTransfer_type() {
        return transfer_type;
    }

    @XmlElement(name = "TRANSFER_TYPE")
    public void setTransfer_type(String transfer_type) {
        this.transfer_type = transfer_type;
    }

    public String getOrigin() {
        return origin;
    }

    @XmlElement(name = "ORIGIN")
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    @XmlElement(name = "DESTINATION")
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCarrier_code() {
        return carrier_code;
    }

    @XmlElement(name = "CARRIER_CODE")
    public void setCarrier_code(String carrier_code) {
        this.carrier_code = carrier_code;
    }

    public String getCarrier_flight_code() {
        return carrier_flight_code;
    }

    @XmlElement(name = "CARRIER_FLIGHT_CODE")
    public void setCarrier_flight_code(String carrier_flight_code) {
        this.carrier_flight_code = carrier_flight_code;
    }

    public int getAllotment() {
        return allotment;
    }

    @XmlElement(name = "ALLOTMENT")
    public void setAllotment(int allotment) {
        this.allotment = allotment;
    }

    public String getIdentifier() {
        return identifier;
    }

    @XmlElement(name = "IDENTIFIER")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getOccupancy() {
        return occupancy;
    }

    @XmlElement(name = "OCCUPANCY")
    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public int getNumberofunits() {
        return numberofunits;
    }

    @XmlElement(name = "NUMBEROFUNITS")
    public void setNumberofunits(int numberofunits) {
        this.numberofunits = numberofunits;
    }

    public String getTransfer_code() {
        return transfer_code;
    }

    @XmlElement(name = "TRANSFER_CODE")
    public void setTransfer_code(String transfer_code) {
        this.transfer_code = transfer_code;
    }

    public String getExternal_service_flag() {
        return external_service_flag;
    }

    @XmlElement(name = "EXTERNAL_SERVICE_CODE")
    public void setExternal_service_flag(String external_service_flag) {
        this.external_service_flag = external_service_flag;
    }

    public String getExternal_service_supplier() {
        return external_service_supplier;
    }

    @XmlElement(name = "EXTERNAL_SERVICE_SUPPLIER")
    public void setExternal_service_supplier(String external_service_supplier) {
        this.external_service_supplier = external_service_supplier;
    }

    public String getNotification_flag() {
        return notification_flag;
    }

    @XmlElement(name = "NOTIFICATION_FLAG")
    public void setNotification_flag(String notification_flag) {
        this.notification_flag = notification_flag;
    }

    public String getTourguide_flag() {
        return tourguide_flag;
    }

    @XmlElement(name = "TOURGUIDE_FLAG")
    public void setTourguide_flag(String tourguide_flag) {
        this.tourguide_flag = tourguide_flag;
    }

    public String getTransfer_booked_external() {
        return transfer_booked_external;
    }

    @XmlElement(name = "TRANSFER_BOOKING_EXTERNAL")
    public void setTransfer_booked_external(String transfer_booked_external) {
        this.transfer_booked_external = transfer_booked_external;
    }

    public String getTransfer_start() {
        return transfer_start;
    }

    @XmlElement(name = "TRANSFER_START")
    public void setTransfer_start(String transfer_start) {
        this.transfer_start = transfer_start;
    }

    public String getTransfer_end() {
        return transfer_end;
    }

    @XmlElement(name = "TRANSFER_END")
    public void setTransfer_end(String transfer_end) {
        this.transfer_end = transfer_end;
    }

    public String getServicelevel() {
        return servicelevel;
    }

    @XmlElement(name = "SERVICELEVEL")
    public void setServicelevel(String servicelevel) {
        this.servicelevel = servicelevel;
    }

    public List<Service_remark> getService_remark() {
        return service_remark;
    }

    @XmlElement(name = "SERVICE_REMARK")
    public void setService_remark(List<Service_remark> service_remark) {
        this.service_remark = service_remark;
    }

    public List<Tourguide_assignment> getTourguide_assignment() {
        return tourguide_assignment;
    }

    @XmlElement(name = "TOURGUIDE_ASIGNMENT")
    public void setTourguide_assignment(List<Tourguide_assignment> tourguide_assignment) {
        this.tourguide_assignment = tourguide_assignment;
    }

    public List<Environment_criteria> getEnvironment_criteria() {
        return environment_criteria;
    }

    @XmlElement(name = "ENVIRONMENT_CRITERIA")
    public void setEnvironment_criteria(List<Environment_criteria> environment_criteria) {
        this.environment_criteria = environment_criteria;
    }
}
