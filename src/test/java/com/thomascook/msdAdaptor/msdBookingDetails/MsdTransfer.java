package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;

import java.util.Map;

public class MsdTransfer {

    //region Fields
    private String _createdby_value;
    private String _createdonbehalfby_value;
    private String _modifiedby_value;
    private String _modifiedonbehalfby_value;
    private String _ownerid_value;
    private String _owningbusinessunit_value;
    private String _owningteam_value;
    private String _owninguser_value;
    private String _tc_arrivalgatewayid_value;
    private String _tc_bookingid_value;
    private String _tc_departuregatewayid_value;
    private String createdon;
    private String importsequencenumber;
    private String modifiedon;
    private String overriddencreatedon;
    private String statecode;
    private String statuscode;
    private String tc_bookingtransferid;
    private String tc_category;
    private String tc_enddateandtime;
    private String tc_name;
    private String tc_order;
    private String tc_participants;
    private String tc_remark;
    private String tc_startdateandtime;
    private String tc_transfercode;
    private String tc_transfertype;
    private String timezoneruleversionnumber;
    private String utcconversiontimezonecode;
    private String versionnumber;
    //endregion

    public MsdTransfer(Map<String, Object> jsonMap) {
        setDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the Transfer details according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void setDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this._createdby_value = String.valueOf(jsonMap.get("_createdby_value;"));
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value;"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value;"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value;"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value;"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value;"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value;"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value;"));
        this._tc_arrivalgatewayid_value = String.valueOf(jsonMap.get("_tc_arrivalgatewayid_value;"));
        this._tc_bookingid_value = String.valueOf(jsonMap.get("_tc_bookingid_value;"));
        this._tc_departuregatewayid_value = String.valueOf(jsonMap.get("_tc_departuregatewayid_value;"));
        this.createdon = String.valueOf(jsonMap.get("createdon;"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber;"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon;"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon;"));
        this.statecode = String.valueOf(jsonMap.get("statecode;"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode;"));
        this.tc_bookingtransferid = String.valueOf(jsonMap.get("tc_bookingtransferid;"));
        this.tc_category = String.valueOf(jsonMap.get("tc_category;"));
        this.tc_enddateandtime = String.valueOf(jsonMap.get("tc_enddateandtime;"));
        this.tc_name = String.valueOf(jsonMap.get("tc_name;"));
        this.tc_order = String.valueOf(jsonMap.get("tc_order;"));
        this.tc_participants = String.valueOf(jsonMap.get("tc_participants;"));
        this.tc_remark = String.valueOf(jsonMap.get("tc_remark;"));
        this.tc_startdateandtime = String.valueOf(jsonMap.get("tc_startdateandtime;"));
        this.tc_transfercode = String.valueOf(jsonMap.get("tc_transfercode;"));
        this.tc_transfertype = String.valueOf(jsonMap.get("tc_transfertype;"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber;"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode;"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber;"));
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
                .add("_tc_arrivalgatewayid_value", _tc_arrivalgatewayid_value)
                .add("_tc_bookingid_value", _tc_bookingid_value)
                .add("_tc_departuregatewayid_value", _tc_departuregatewayid_value)
                .add("createdon", createdon)
                .add("importsequencenumber", importsequencenumber)
                .add("modifiedon", modifiedon)
                .add("overriddencreatedon", overriddencreatedon)
                .add("statecode", statecode)
                .add("statuscode", statuscode)
                .add("tc_bookingtransferid", tc_bookingtransferid)
                .add("tc_category", tc_category)
                .add("tc_enddateandtime", tc_enddateandtime)
                .add("tc_name", tc_name)
                .add("tc_order", tc_order)
                .add("tc_participants", tc_participants)
                .add("tc_remark", tc_remark)
                .add("tc_startdateandtime", tc_startdateandtime)
                .add("tc_transfercode", tc_transfercode)
                .add("tc_transfertype", tc_transfertype)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("versionnumber", versionnumber)
                .toString();
    }
}
