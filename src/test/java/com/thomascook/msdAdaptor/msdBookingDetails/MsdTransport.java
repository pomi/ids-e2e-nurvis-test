package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.util.Map;

public class MsdTransport implements MsdService {

    //region Fields
    private String tc_name;
    private String _owningbusinessunit_value;
    private String statuscode;
    private String _tc_arrivalgatewayid_value;
    private String createdon;
    private String statecode;
    private String tc_transfertype;
    private String tc_transportcode;
    private String tc_order;
    private String _ownerid_value;
    private String modifiedon;
    private String tc_enddateandtime;
    private String versionnumber;
    private String tc_numberofparticipants;
    private String _tc_departuregatewayid_value;
    private String timezoneruleversionnumber;
    private String tc_flightnumber;
    private String _modifiedby_value;
    private String tc_carriercode;
    private String tc_flightidentifier;
    private String _tc_bookingid_value;
    private String tc_participants;
    private String _createdby_value;
    private String tc_description;
    private String tc_bookingtransportid;
    private String _owninguser_value;
    private String tc_startdateandtime;
    private String importsequencenumber;
    private String utcconversiontimezonecode;
    private String _createdonbehalfby_value;
    private String overriddencreatedon;
    private String _owningteam_value;
    private String _modifiedonbehalfby_value;
    private String tc_remark;
    //endregion

    public MsdTransport(Map<String, Object> jsonMap) {
        fillInTransportDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the Transport Service details according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void fillInTransportDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this.tc_name = String.valueOf(jsonMap.get("tc_name"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode"));
        this._tc_arrivalgatewayid_value = String.valueOf(jsonMap.get("_tc_arrivalgatewayid_value"));
        this.createdon = String.valueOf(jsonMap.get("createdon"));
        this.statecode = String.valueOf(jsonMap.get("statecode"));
        this.tc_transfertype = String.valueOf(jsonMap.get("tc_transfertype"));
        this.tc_transportcode = String.valueOf(jsonMap.get("tc_transportcode"));
        this.tc_order = String.valueOf(jsonMap.get("tc_order"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon"));
        this.tc_enddateandtime = String.valueOf(jsonMap.get("tc_enddateandtime"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber"));
        this.tc_numberofparticipants = String.valueOf(jsonMap.get("tc_numberofparticipants"));
        this._tc_departuregatewayid_value = String.valueOf(jsonMap.get("_tc_departuregatewayid_value"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber"));
        this.tc_flightnumber = String.valueOf(jsonMap.get("tc_flightnumber"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value"));
        this.tc_carriercode = String.valueOf(jsonMap.get("tc_carriercode"));
        this.tc_flightidentifier = String.valueOf(jsonMap.get("tc_flightidentifier"));
        this._tc_bookingid_value = String.valueOf(jsonMap.get("_tc_bookingid_value"));
        this.tc_participants = String.valueOf(jsonMap.get("tc_participants"));
        this._createdby_value = String.valueOf(jsonMap.get("_createdby_value"));
        this.tc_description = String.valueOf(jsonMap.get("tc_description"));
        this.tc_bookingtransportid = String.valueOf(jsonMap.get("tc_bookingtransportid"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value"));
        this.tc_startdateandtime = String.valueOf(jsonMap.get("tc_startdateandtime"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode"));
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value"));
        this.tc_remark = String.valueOf(jsonMap.get("tc_remark"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MsdTransport that = (MsdTransport) o;
        return Objects.equal(tc_name, that.tc_name) &&
                Objects.equal(_owningbusinessunit_value, that._owningbusinessunit_value) &&
                Objects.equal(statuscode, that.statuscode) &&
                Objects.equal(_tc_arrivalgatewayid_value, that._tc_arrivalgatewayid_value) &&
                Objects.equal(createdon, that.createdon) &&
                Objects.equal(statecode, that.statecode) &&
                Objects.equal(tc_transfertype, that.tc_transfertype) &&
                Objects.equal(tc_transportcode, that.tc_transportcode) &&
                Objects.equal(tc_order, that.tc_order) &&
                Objects.equal(_ownerid_value, that._ownerid_value) &&
                Objects.equal(modifiedon, that.modifiedon) &&
                Objects.equal(tc_enddateandtime, that.tc_enddateandtime) &&
                Objects.equal(versionnumber, that.versionnumber) &&
                Objects.equal(tc_numberofparticipants, that.tc_numberofparticipants) &&
                Objects.equal(_tc_departuregatewayid_value, that._tc_departuregatewayid_value) &&
                Objects.equal(timezoneruleversionnumber, that.timezoneruleversionnumber) &&
                Objects.equal(tc_flightnumber, that.tc_flightnumber) &&
                Objects.equal(_modifiedby_value, that._modifiedby_value) &&
                Objects.equal(tc_carriercode, that.tc_carriercode) &&
                Objects.equal(tc_flightidentifier, that.tc_flightidentifier) &&
                Objects.equal(_tc_bookingid_value, that._tc_bookingid_value) &&
                Objects.equal(tc_participants, that.tc_participants) &&
                Objects.equal(_createdby_value, that._createdby_value) &&
                Objects.equal(tc_description, that.tc_description) &&
                Objects.equal(tc_bookingtransportid, that.tc_bookingtransportid) &&
                Objects.equal(_owninguser_value, that._owninguser_value) &&
                Objects.equal(tc_startdateandtime, that.tc_startdateandtime) &&
                Objects.equal(importsequencenumber, that.importsequencenumber) &&
                Objects.equal(utcconversiontimezonecode, that.utcconversiontimezonecode) &&
                Objects.equal(_createdonbehalfby_value, that._createdonbehalfby_value) &&
                Objects.equal(overriddencreatedon, that.overriddencreatedon) &&
                Objects.equal(_owningteam_value, that._owningteam_value) &&
                Objects.equal(_modifiedonbehalfby_value, that._modifiedonbehalfby_value) &&
                Objects.equal(tc_remark, that.tc_remark);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tc_name, _owningbusinessunit_value, statuscode, _tc_arrivalgatewayid_value, createdon, statecode, tc_transfertype, tc_transportcode, tc_order, _ownerid_value, modifiedon, tc_enddateandtime, versionnumber, tc_numberofparticipants, _tc_departuregatewayid_value, timezoneruleversionnumber, tc_flightnumber, _modifiedby_value, tc_carriercode, tc_flightidentifier, _tc_bookingid_value, tc_participants, _createdby_value, tc_description, tc_bookingtransportid, _owninguser_value, tc_startdateandtime, importsequencenumber, utcconversiontimezonecode, _createdonbehalfby_value, overriddencreatedon, _owningteam_value, _modifiedonbehalfby_value, tc_remark);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tc_name", tc_name)
                .add("_owningbusinessunit_value", _owningbusinessunit_value)
                .add("statuscode", statuscode)
                .add("_tc_arrivalgatewayid_value", _tc_arrivalgatewayid_value)
                .add("createdon", createdon)
                .add("statecode", statecode)
                .add("tc_transfertype", tc_transfertype)
                .add("tc_transportcode", tc_transportcode)
                .add("tc_order", tc_order)
                .add("_ownerid_value", _ownerid_value)
                .add("modifiedon", modifiedon)
                .add("tc_enddateandtime", tc_enddateandtime)
                .add("versionnumber", versionnumber)
                .add("tc_numberofparticipants", tc_numberofparticipants)
                .add("_tc_departuregatewayid_value", _tc_departuregatewayid_value)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("tc_flightnumber", tc_flightnumber)
                .add("_modifiedby_value", _modifiedby_value)
                .add("tc_carriercode", tc_carriercode)
                .add("tc_flightidentifier", tc_flightidentifier)
                .add("_tc_bookingid_value", _tc_bookingid_value)
                .add("tc_participants", tc_participants)
                .add("_createdby_value", _createdby_value)
                .add("tc_description", tc_description)
                .add("tc_bookingtransportid", tc_bookingtransportid)
                .add("_owninguser_value", _owninguser_value)
                .add("tc_startdateandtime", tc_startdateandtime)
                .add("importsequencenumber", importsequencenumber)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("_createdonbehalfby_value", _createdonbehalfby_value)
                .add("overriddencreatedon", overriddencreatedon)
                .add("_owningteam_value", _owningteam_value)
                .add("_modifiedonbehalfby_value", _modifiedonbehalfby_value)
                .add("tc_remark", tc_remark)
                .toString();
    }
}
