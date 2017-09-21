package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class MsdAccommodation implements MsdService {

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
        this.statecode = String.valueOf(jsonMap.get("statecode"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode"));
        this.tc_boardtype = String.valueOf(jsonMap.get("tc_boardtype"));
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
        this.tc_transferserviceleveltype = String.valueOf(jsonMap.get("tc_transferserviceleveltype"));
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
}
