package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.thomascook.ontour.Service;
import org.hamcrest.CoreMatchers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MsdExtraService extends MsdService {

    //region Fields
    private String tc_enddateandtime;
    private String _owningbusinessunit_value;
    private String tc_bookingextraserviceid;
    private String createdon;
    private String _tc_bookingid_value;
    private String statecode;
    private String statuscode;
    private String _createdby_value;
    private String tc_participants;
    private String timezoneruleversionnumber;
    private String tc_remark;
    private String _ownerid_value;
    private String tc_startdateandtime;
    private String tc_order;
    private String _owninguser_value;
    private String _modifiedby_value;
    private String versionnumber;
    private String modifiedon;
    private String tc_extraservicecode;
    private String tc_name;
    private String overriddencreatedon;
    private String _owningteam_value;
    private String utcconversiontimezonecode;
    private String importsequencenumber;
    private String _modifiedonbehalfby_value;
    private String _createdonbehalfby_value;
    //endregion

    public MsdExtraService(Map<String, Object> jsonMap) {
        setDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the Extra Service details according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void setDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this.tc_enddateandtime = String.valueOf(jsonMap.get("tc_enddateandtime"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value"));
        this.tc_bookingextraserviceid = String.valueOf(jsonMap.get("tc_bookingextraserviceid"));
        this.createdon = String.valueOf(jsonMap.get("createdon"));
        this._tc_bookingid_value = String.valueOf(jsonMap.get("_tc_bookingid_value"));
        this.statecode = String.valueOf(jsonMap.get("statecode"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode"));
        this._createdby_value = String.valueOf(jsonMap.get("_createdby_value"));
        this.tc_participants = String.valueOf(jsonMap.get("tc_participants"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber"));
        this.tc_remark = String.valueOf(jsonMap.get("tc_remark"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value"));
        this.tc_startdateandtime = String.valueOf(jsonMap.get("tc_startdateandtime"));
        this.tc_order = String.valueOf(jsonMap.get("tc_order"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon"));
        this.tc_extraservicecode = String.valueOf(jsonMap.get("tc_extraservicecode"));
        this.tc_name = String.valueOf(jsonMap.get("tc_name"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value"));
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value"));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tc_enddateandtime", tc_enddateandtime)
                .add("_owningbusinessunit_value", _owningbusinessunit_value)
                .add("tc_bookingextraserviceid", tc_bookingextraserviceid)
                .add("createdon", createdon)
                .add("_tc_bookingid_value", _tc_bookingid_value)
                .add("statecode", statecode)
                .add("statuscode", statuscode)
                .add("_createdby_value", _createdby_value)
                .add("tc_participants", tc_participants)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("tc_remark", tc_remark)
                .add("_ownerid_value", _ownerid_value)
                .add("tc_startdateandtime", tc_startdateandtime)
                .add("tc_order", tc_order)
                .add("_owninguser_value", _owninguser_value)
                .add("_modifiedby_value", _modifiedby_value)
                .add("versionnumber", versionnumber)
                .add("modifiedon", modifiedon)
                .add("tc_extraservicecode", tc_extraservicecode)
                .add("tc_name", tc_name)
                .add("overriddencreatedon", overriddencreatedon)
                .add("_owningteam_value", _owningteam_value)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("importsequencenumber", importsequencenumber)
                .add("_modifiedonbehalfby_value", _modifiedonbehalfby_value)
                .add("_createdonbehalfby_value", _createdonbehalfby_value)
                .toString();
    }

    @Override
    public boolean assertMsdBookingMatchesOnTour(Service onTour) {
        assertEquals(onTour.getCode(), this.tc_extraservicecode);
        assertThat(this.tc_name, CoreMatchers.containsString(onTour.getName()));
        assertEquals(LocalDate.parse(onTour.getBeginning_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalTime.parse(onTour.getBeginning_time(), ONTOUR_TIME_FORMATTER),
                LocalTime.parse(this.tc_startdateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getEnd_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalTime.parse(onTour.getEnd_time(), ONTOUR_TIME_FORMATTER),
                LocalTime.parse(this.tc_enddateandtime, MSD_DATE_TIME_FORMATTER));
        assertEquals(STATE_MAP.get(onTour.getStatus()), this.statuscode);
        assertMsdAndOnTourPaxAssignments(onTour.getPax_service(), getPaxList(this.tc_participants));

        return false;
    }
}
