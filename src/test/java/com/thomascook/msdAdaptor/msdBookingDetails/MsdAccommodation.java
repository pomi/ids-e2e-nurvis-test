package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.thomascook.nurvisAdapter.response.ReservationFahTypeResponse;
import com.thomascook.ontour.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class MsdAccommodation extends MsdService {

    private static final Map<String, String> BOARD_TYPES_MAP = new HashMap<String, String>() {
        {
            put("UF", "Breakfast");
            put("VP", "Full Board");
            put("HP", "Half Board");
            put("LP", "Board according to description");
            put("ZZ", "Unknown");
            put("AB", "American Breakfast");
            put("AI", "All Inclusive");
            put("AP", "All Inclusive +");
            put("BB", "Bed and Breakfast");
            put("CB", "Continental Bfast");
            put("CC", "Catered Chalet");
            put("CL", "Club Board");
            put("CR", "Cruise Board");
            put("DH", "Deluxe Half Board");
            put("DI", "Drinks Inclusive");
            put("DO", "Dine Out");
            put("EB", "Bed English Bfast");
            put("EM", "Evening Meal");
            put("FB", "Full Board");
            put("FD", "Fly Drive");
            put("FP", "Full Board +");
            put("HB", "Half Board");
            put("HP", "Half Board +");
            put("HU", "Half Board Upgrade");
            put("MP", "Meal Plan");
            put("NA", "Not Applicable");
            put("RO", "Room Only");
            put("SC", "Self Catering");
            put("VB", "Variable Board");
            put("VD", "Value Dining Plan");
        }
    };
    //region Fields
    private String _createdby_value;
    private String _createdonbehalfby_value;
    private String _modifiedby_value;
    private String _modifiedonbehalfby_value;
    private String _ownerid_value;
    private String _owningbusinessunit_value;
    private String _owningteam_value;
    private String _owninguser_value;
    private String _tc_bookingid_value;
    private String _tc_hotelid_value;
    private String createdon;
    private String importsequencenumber;
    private String modifiedon;
    private String overriddencreatedon;
    private String statecode;
    private String statuscode;
    private String tc_boardtype;
    private String tc_bookingaccommodationid;
    private String tc_enddateandtime;
    private String tc_externalservicecodetype;
    private String tc_externaltransfer;
    private String tc_hassharedroom;
    private String tc_isexternalservice;
    private String tc_name;
    private String tc_needtourguideassignment;
    private String tc_notificationrequired;
    private String tc_numberofparticipants;
    private String tc_numberofrooms;
    private String tc_order;
    private String tc_participants;
    private String tc_remark;
    private String tc_roomtype;
    private String tc_sourcemarkethotelcode;
    private String tc_sourcemarkethotelname;
    private String tc_startdateandtime;
    private String tc_transferserviceleveltype;
    private String tc_withtransfer;
    private String timezoneruleversionnumber;
    private String utcconversiontimezonecode;
    private String versionnumber;
    //endregion

    public MsdAccommodation(Map<String, Object> jsonMap) {
        fillInDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the Accommodation service details according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void fillInDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this._createdby_value = null != jsonMap.get("_createdby_value") ? String.valueOf(jsonMap.get("_createdby_value")) : null;
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value"));
        this._tc_bookingid_value = String.valueOf(jsonMap.get("_tc_bookingid_value"));
        this._tc_hotelid_value = String.valueOf(jsonMap.get("_tc_hotelid_value"));
        this.createdon = String.valueOf(jsonMap.get("createdon"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon"));
        this.statecode = String.valueOf(jsonMap.get("statecode@OData.Community.Display.V1.FormattedValue"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode@OData.Community.Display.V1.FormattedValue"));
        this.tc_boardtype = String.valueOf(jsonMap.get("tc_boardtype@OData.Community.Display.V1.FormattedValue"));
        this.tc_bookingaccommodationid = String.valueOf(jsonMap.get("tc_bookingaccommodationid"));
        this.tc_enddateandtime = String.valueOf(jsonMap.get("tc_enddateandtime"));
        this.tc_externalservicecodetype = String.valueOf(jsonMap.get("tc_externalservicecodetype"));
        this.tc_externaltransfer = String.valueOf(jsonMap.get("tc_externaltransfer"));
        this.tc_hassharedroom = String.valueOf(jsonMap.get("tc_hassharedroom"));
        this.tc_isexternalservice = String.valueOf(jsonMap.get("tc_isexternalservice"));
        this.tc_name = String.valueOf(jsonMap.get("tc_name"));
        this.tc_needtourguideassignment = String.valueOf(jsonMap.get("tc_needtourguideassignment"));
        this.tc_notificationrequired = String.valueOf(jsonMap.get("tc_notificationrequired"));
        this.tc_numberofparticipants = String.valueOf(jsonMap.get("tc_numberofparticipants"));
        this.tc_numberofrooms = String.valueOf(jsonMap.get("tc_numberofrooms"));
        this.tc_order = String.valueOf(jsonMap.get("tc_order"));
        this.tc_participants = String.valueOf(jsonMap.get("tc_participants"));
        this.tc_remark = String.valueOf(jsonMap.get("tc_remark"));
        this.tc_roomtype = String.valueOf(jsonMap.get("tc_roomtype"));
        this.tc_sourcemarkethotelcode = String.valueOf(jsonMap.get("tc_sourcemarkethotelcode"));
        this.tc_sourcemarkethotelname = String.valueOf(jsonMap.get("tc_sourcemarkethotelname"));
        this.tc_startdateandtime = String.valueOf(jsonMap.get("tc_startdateandtime"));
        this.tc_transferserviceleveltype = String.valueOf(jsonMap.get("tc_transferserviceleveltype@OData.Community.Display.V1.FormattedValue"));
        this.tc_withtransfer = String.valueOf(jsonMap.get("tc_withtransfer"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber"));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("_createdby_value", _createdby_value)
                .add("_createdonbehalfby_value", _createdonbehalfby_value)
                .add("_modifiedby_value", _modifiedby_value)
                .add("_modifiedonbehalfby_value", _modifiedonbehalfby_value)
                .add("_ownerid_value", _ownerid_value)
                .add("_owningbusinessunit_value", _owningbusinessunit_value)
                .add("_owningteam_value", _owningteam_value)
                .add("_owninguser_value", _owninguser_value)
                .add("_tc_bookingid_value", _tc_bookingid_value)
                .add("_tc_hotelid_value", _tc_hotelid_value)
                .add("createdon", createdon)
                .add("importsequencenumber", importsequencenumber)
                .add("modifiedon", modifiedon)
                .add("overriddencreatedon", overriddencreatedon)
                .add("statecode", statecode)
                .add("statuscode", statuscode)
                .add("tc_boardtype", tc_boardtype)
                .add("tc_bookingaccommodationid", tc_bookingaccommodationid)
                .add("tc_enddateandtime", tc_enddateandtime)
                .add("tc_externalservicecodetype", tc_externalservicecodetype)
                .add("tc_externaltransfer", tc_externaltransfer)
                .add("tc_hassharedroom", tc_hassharedroom)
                .add("tc_isexternalservice", tc_isexternalservice)
                .add("tc_name", tc_name)
                .add("tc_needtourguideassignment", tc_needtourguideassignment)
                .add("tc_notificationrequired", tc_notificationrequired)
                .add("tc_numberofparticipants", tc_numberofparticipants)
                .add("tc_numberofrooms", tc_numberofrooms)
                .add("tc_order", tc_order)
                .add("tc_participants", tc_participants)
                .add("tc_remark", tc_remark)
                .add("tc_roomtype", tc_roomtype)
                .add("tc_sourcemarkethotelcode", tc_sourcemarkethotelcode)
                .add("tc_sourcemarkethotelname", tc_sourcemarkethotelname)
                .add("tc_startdateandtime", tc_startdateandtime)
                .add("tc_transferserviceleveltype", tc_transferserviceleveltype)
                .add("tc_withtransfer", tc_withtransfer)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("versionnumber", versionnumber)
                .toString();
    }

    /**
     * Transforms original onTour's "Y", "N" values of {@code shared_room_type} key to boolean.
     *
     * @param roomShared original onTour's "Y", "N".
     * @return true in case of "Y".
     */
    private boolean isOnTourRoomShared(String roomShared) {
        assert Stream.of("Y", "N").collect(Collectors.toList()).contains(roomShared.toUpperCase());
        return roomShared.toUpperCase().equals("Y");
    }

    /**
     * Transforms original onTour's "G", "K" value of {@code transfer_code} to boolean.
     *
     * @param transferIncluded original onTour's "G", "K".
     * @return true in case of "G".
     */
    private boolean isOnTourTransferIncluded(String transferIncluded) {
        assert Stream.of("G", "K").collect(Collectors.toList()).contains(transferIncluded.toUpperCase());
        return transferIncluded.toUpperCase().equals("G");
    }

    /**
     * Transforms original onTour's "I", "E" value of {@code external_service_flag} to boolean.
     *
     * @param serviceExternal original onTour's "I", "E".
     * @return true in case of "E".
     */
    private boolean isOnTourServiceExternal(String serviceExternal) {
        assert Stream.of("I", "E").collect(Collectors.toList()).contains(serviceExternal.toUpperCase());
        return serviceExternal.toUpperCase().equals("E");
    }

    public boolean equalsToNurvisOrder(ReservationFahTypeResponse nurvisResponse) {
        //compare statuscode = 950000002;
        //compare tc_boardtype = 950000020;
        //compare tc_externalservicecodetype = 950000001;
        //compare tc_transferserviceleveltype = 950000001;
        if (!this.tc_sourcemarkethotelname.equals(nurvisResponse.getProductName())) {
            return false;
        }
        if (!this.tc_numberofparticipants.equals(nurvisResponse.getAdults())) {
            return false;
        }
        //compare tc_numberofrooms;
        //compare tc_participants;
        if (!this.tc_roomtype.equals(nurvisResponse.getRoom())) {
            return false;
        }
        if (!this.tc_sourcemarkethotelcode.equals(nurvisResponse.getProduct())) {
            return false;
        }
        if (!this.tc_sourcemarkethotelname.equals(nurvisResponse.getProductName())) {
            return false;
        }
        if (!LocalDate.parse(this.tc_startdateandtime).equals(LocalDate.parse(nurvisResponse.getStartDate()))) {
            return false;
        }
        //compare tc_remark;

        return true;
    }

//    @Override
//    public boolean assertMsdBookingMatchesOnTour(Service onTour) {
//        ERROR_COLLECTOR.checkThat(onTour.getCode(), IsEqual.equalTo(this.tc_sourcemarkethotelcode));
//        ERROR_COLLECTOR.checkThat(onTour.getName(), IsEqual.equalTo(this.tc_sourcemarkethotelname));
//        ERROR_COLLECTOR.checkThat(LocalDate.parse(onTour.getBeginning_date(), ONTOUR_DATE_FORMATTER),
//                IsEqual.equalTo(LocalDate.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER)));
//        ERROR_COLLECTOR.checkThat(LocalTime.parse(onTour.getBeginning_time(), ONTOUR_TIME_FORMATTER),
//                IsEqual.equalTo(LocalTime.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER)));
//        ERROR_COLLECTOR.checkThat(LocalDate.parse(onTour.getEnd_date()),
//                IsEqual.equalTo(LocalDate.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER)));
//        ERROR_COLLECTOR.checkThat(LocalTime.parse(onTour.getEnd_time(), ONTOUR_TIME_FORMATTER),
//                IsEqual.equalTo(LocalTime.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER)));
//        ERROR_COLLECTOR.checkThat(onTour.getAccomodation(), IsEqual.equalTo(this.tc_roomtype));
//        ERROR_COLLECTOR.checkThat(BOARD_TYPES_MAP.get(onTour.getBoard()), IsEqual.equalTo(this.tc_boardtype));
//        ERROR_COLLECTOR.checkThat(onTour.getStatus(), IsEqual.equalTo(this.statuscode));
//        ERROR_COLLECTOR.checkThat(onTour.getOccupancy(), IsEqual.equalTo(this.tc_numberofparticipants));
//        ERROR_COLLECTOR.checkThat(isOnTourRoomShared(onTour.getShared_room_type()), IsEqual.equalTo(Boolean.valueOf(this.tc_hassharedroom)));
//        ERROR_COLLECTOR.checkThat(String.valueOf(onTour.getNumberofunits()), IsEqual.equalTo(this.tc_numberofrooms));
//        ERROR_COLLECTOR.checkThat(isOnTourTransferIncluded(onTour.getTransfer_code()), IsEqual.equalTo(Boolean.valueOf(this.tc_withtransfer)));
//        ERROR_COLLECTOR.checkThat(isOnTourServiceExternal(onTour.getExternal_service_flag()), IsEqual.equalTo(Boolean.valueOf(this.tc_isexternalservice)));
////        assertMsdAndOnTourPaxAssignments(onTour.getPax_service().get(0), getPaxList(this.tc_participants));
//
//        return true;
//    }

    @Override
    public boolean assertMsdBookingMatchesOnTour(Service onTour) {
        assertEquals(onTour.getCode(), this.tc_sourcemarkethotelcode);
        assertEquals(onTour.getName(), this.tc_sourcemarkethotelname);
        assertEquals(LocalDate.parse(onTour.getBeginning_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalTime.parse(onTour.getBeginning_time(), ONTOUR_TIME_FORMATTER),
                LocalTime.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getEnd_date()),
                LocalDate.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalTime.parse(onTour.getEnd_time(), ONTOUR_TIME_FORMATTER),
                LocalTime.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(onTour.getAccomodation(), this.tc_roomtype);
        assertEquals(BOARD_TYPES_MAP.get(onTour.getBoard()), this.tc_boardtype);
        assertEquals(onTour.getStatus(), this.statuscode);
        assertEquals(onTour.getOccupancy(), this.tc_numberofparticipants);
        assertEquals(isOnTourRoomShared(onTour.getShared_room_type()), Boolean.valueOf(this.tc_hassharedroom));
        assertEquals(String.valueOf(onTour.getNumberofunits()), this.tc_numberofrooms);
        assertEquals(isOnTourTransferIncluded(onTour.getTransfer_code()), Boolean.valueOf(this.tc_withtransfer));
        assertEquals(isOnTourServiceExternal(onTour.getExternal_service_flag()), Boolean.valueOf(this.tc_isexternalservice));
        assertMsdAndOnTourPaxAssignments(onTour.getPax_service(), getPaxList(this.tc_participants));

        return true;
    }
}
