package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.thomascook.msdAdaptor.MsdSession;
import com.thomascook.ontour.Booking;
import com.thomascook.ontour.Booking_remark;
import com.thomascook.ontour.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MsdBookingGeneralDetails extends MsdService {

    //region Fields
    private String tc_name;
    private String tc_departuredate;
    private String versionnumber;

    private String statecode;

    private String statuscode;
    private String tc_hassourcemarketcomplaint;
    private String tc_bookingdate;
    private String createdon;
    private String tc_numberofinfants;
    private String tc_sourceapplication;
    private String _tc_touroperatorid_value;
    private String _tc_brandid_value;
    private String tc_returndate;
    private String _ownerid_value;
    private String modifiedon;
    private String tc_brochurecode;
    private String tc_duration;
    private String tc_islatebooking;
    private String tc_ontourversion;
    private String tc_numberofparticipants;
    private String _transactioncurrencyid_value;
    private String exchangerate;
    private String timezoneruleversionnumber;
    private String tc_numberofadults;
    private String _modifiedby_value;
    private String _tc_sourcemarketid_value;
    private String _owningbusinessunit_value;
    private String tc_travelamount_base;
    private String tc_travelamount;
    private String _tc_destinationid_value;
    private String _owningteam_value;
    private String tc_numberofchildren;
    private String tc_sourcesystem;
    private String tc_touroperatorupdateddate;
    private String tc_bookingid;
    private String tc_participants;
    private String _createdby_value;
    private String tc_touroperatorversion;
    private String _tc_destinationgatewayid_value;
    private String tc_ontourupdateddate;
    private String tc_shopchannel;
    private String tc_agentshortname;
    private String _createdonbehalfby_value;
    private String tc_bookeremail;
    private String tc_remark;
    private String tc_agentfullname;
    private String tc_gocardlessuniqueid;
    private String overriddencreatedon;
    private String tc_shopcode;
    private String tc_participantremarks;
    private String tc_bookeremergencyphone;
    private String tc_bookerphone2;
    private String utcconversiontimezonecode;
    private String tc_shopname;
    private String tc_agentpersonalnumber;
    private String tc_shopcompany;
    private String tc_bookerphone1;
    private String tc_webrioconsultationnumber;
    private String importsequencenumber;
    private String tc_touroperatorreference;
    private String tc_agentteam;
    private String _owninguser_value;
    private String _modifiedonbehalfby_value;
    //endregion

    public MsdBookingGeneralDetails(Map<String, Object> jsonMap) {
        fillInDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the booking General details according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void fillInDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this.tc_name = String.valueOf(jsonMap.get("tc_name"));
        this.tc_departuredate = String.valueOf(jsonMap.get("tc_departuredate"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber"));
        this.statecode = String.valueOf(jsonMap.get("statecode@OData.Community.Display.V1.FormattedValue"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode@OData.Community.Display.V1.FormattedValue"));
        this.tc_hassourcemarketcomplaint = String.valueOf(jsonMap.get("tc_hassourcemarketcomplaint"));
        this.tc_bookingdate = String.valueOf(jsonMap.get("tc_bookingdate"));
        this.createdon = String.valueOf(jsonMap.get("createdon"));
        this.tc_numberofinfants = String.valueOf(jsonMap.get("tc_numberofinfants"));
        this.tc_sourceapplication = String.valueOf(jsonMap.get("tc_sourceapplication"));
        this._tc_touroperatorid_value = String.valueOf(jsonMap.get("_tc_touroperatorid_value"));
        this._tc_brandid_value = String.valueOf(jsonMap.get("_tc_brandid_value"));
        this.tc_returndate = String.valueOf(jsonMap.get("tc_returndate"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon"));
        this.tc_brochurecode = String.valueOf(jsonMap.get("tc_brochurecode"));
        this.tc_duration = String.valueOf(jsonMap.get("tc_duration"));
        this.tc_islatebooking = String.valueOf(jsonMap.get("tc_islatebooking"));
        this.tc_ontourversion = String.valueOf(jsonMap.get("tc_ontourversion"));
        this.tc_numberofparticipants = String.valueOf(jsonMap.get("tc_numberofparticipants"));
        this._transactioncurrencyid_value = String.valueOf(jsonMap.get("_transactioncurrencyid_value"));
        this.exchangerate = String.valueOf(jsonMap.get("exchangerate"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber"));
        this.tc_numberofadults = String.valueOf(jsonMap.get("tc_numberofadults"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value"));
        this._tc_sourcemarketid_value = String.valueOf(jsonMap.get("_tc_sourcemarketid_value"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value"));
        this.tc_travelamount_base = String.valueOf(jsonMap.get("tc_travelamount_base"));
        this.tc_travelamount = String.valueOf(jsonMap.get("tc_travelamount"));
        this._tc_destinationid_value = String.valueOf(jsonMap.get("_tc_destinationid_value"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value"));
        this.tc_numberofchildren = String.valueOf(jsonMap.get("tc_numberofchildren"));
        this.tc_sourcesystem = String.valueOf(jsonMap.get("tc_sourcesystem"));
        this.tc_touroperatorupdateddate = String.valueOf(jsonMap.get("tc_touroperatorupdateddate"));
        this.tc_bookingid = String.valueOf(jsonMap.get("tc_bookingid"));
        this.tc_participants = String.valueOf(jsonMap.get("tc_participants"));
        this._createdby_value = String.valueOf(jsonMap.get("_createdby_value"));
        this.tc_touroperatorversion = String.valueOf(jsonMap.get("tc_touroperatorversion"));
        this._tc_destinationgatewayid_value = String.valueOf(jsonMap.get("_tc_destinationgatewayid_value@OData.Community.Display.V1.FormattedValue"));
        this.tc_ontourupdateddate = String.valueOf(jsonMap.get("tc_ontourupdateddate"));
        this.tc_shopchannel = String.valueOf(jsonMap.get("tc_shopchannel"));
        this.tc_agentshortname = String.valueOf(jsonMap.get("tc_agentshortname"));
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value"));
        this.tc_bookeremail = String.valueOf(jsonMap.get("tc_bookeremail"));
        this.tc_remark = String.valueOf(jsonMap.get("tc_remark"));
        this.tc_agentfullname = String.valueOf(jsonMap.get("tc_agentfullname"));
        this.tc_gocardlessuniqueid = String.valueOf(jsonMap.get("tc_gocardlessuniqueid"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon"));
        this.tc_shopcode = String.valueOf(jsonMap.get("tc_shopcode"));
        this.tc_participantremarks = String.valueOf(jsonMap.get("tc_participantremarks"));
        this.tc_bookeremergencyphone = String.valueOf(jsonMap.get("tc_bookeremergencyphone"));
        this.tc_bookerphone2 = String.valueOf(jsonMap.get("tc_bookerphone2"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode"));
        this.tc_shopname = String.valueOf(jsonMap.get("tc_shopname"));
        this.tc_agentpersonalnumber = String.valueOf(jsonMap.get("tc_agentpersonalnumber"));
        this.tc_shopcompany = String.valueOf(jsonMap.get("tc_shopcompany"));
        this.tc_bookerphone1 = String.valueOf(jsonMap.get("tc_bookerphone1"));
        this.tc_webrioconsultationnumber = String.valueOf(jsonMap.get("tc_webrioconsultationnumber"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber"));
        this.tc_touroperatorreference = String.valueOf(jsonMap.get("tc_touroperatorreference"));
        this.tc_agentteam = String.valueOf(jsonMap.get("tc_agentteam"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value"));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tc_name", tc_name)
                .add("tc_departuredate", tc_departuredate)
                .add("versionnumber", versionnumber)
                .add("statecode", statecode)
                .add("statuscode", statuscode)
                .add("tc_hassourcemarketcomplaint", tc_hassourcemarketcomplaint)
                .add("tc_bookingdate", tc_bookingdate)
                .add("createdon", createdon)
                .add("tc_numberofinfants", tc_numberofinfants)
                .add("tc_sourceapplication", tc_sourceapplication)
                .add("_tc_touroperatorid_value", _tc_touroperatorid_value)
                .add("_tc_brandid_value", _tc_brandid_value)
                .add("tc_returndate", tc_returndate)
                .add("_ownerid_value", _ownerid_value)
                .add("modifiedon", modifiedon)
                .add("tc_brochurecode", tc_brochurecode)
                .add("tc_duration", tc_duration)
                .add("tc_islatebooking", tc_islatebooking)
                .add("tc_ontourversion", tc_ontourversion)
                .add("tc_numberofparticipants", tc_numberofparticipants)
                .add("_transactioncurrencyid_value", _transactioncurrencyid_value)
                .add("exchangerate", exchangerate)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("tc_numberofadults", tc_numberofadults)
                .add("_modifiedby_value", _modifiedby_value)
                .add("_tc_sourcemarketid_value", _tc_sourcemarketid_value)
                .add("_owningbusinessunit_value", _owningbusinessunit_value)
                .add("tc_travelamount_base", tc_travelamount_base)
                .add("tc_travelamount", tc_travelamount)
                .add("_tc_destinationid_value", _tc_destinationid_value)
                .add("_owningteam_value", _owningteam_value)
                .add("tc_numberofchildren", tc_numberofchildren)
                .add("tc_sourcesystem", tc_sourcesystem)
                .add("tc_touroperatorupdateddate", tc_touroperatorupdateddate)
                .add("tc_bookingid", tc_bookingid)
                .add("tc_participants", tc_participants)
                .add("_createdby_value", _createdby_value)
                .add("tc_touroperatorversion", tc_touroperatorversion)
                .add("_tc_destinationgatewayid_value", _tc_destinationgatewayid_value)
                .add("tc_ontourupdateddate", tc_ontourupdateddate)
                .add("tc_shopchannel", tc_shopchannel)
                .add("tc_agentshortname", tc_agentshortname)
                .add("_createdonbehalfby_value", _createdonbehalfby_value)
                .add("tc_bookeremail", tc_bookeremail)
                .add("tc_remark", tc_remark)
                .add("tc_agentfullname", tc_agentfullname)
                .add("tc_gocardlessuniqueid", tc_gocardlessuniqueid)
                .add("overriddencreatedon", overriddencreatedon)
                .add("tc_shopcode", tc_shopcode)
                .add("tc_participantremarks", tc_participantremarks)
                .add("tc_bookeremergencyphone", tc_bookeremergencyphone)
                .add("tc_bookerphone2", tc_bookerphone2)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("tc_shopname", tc_shopname)
                .add("tc_agentpersonalnumber", tc_agentpersonalnumber)
                .add("tc_shopcompany", tc_shopcompany)
                .add("tc_bookerphone1", tc_bookerphone1)
                .add("tc_webrioconsultationnumber", tc_webrioconsultationnumber)
                .add("importsequencenumber", importsequencenumber)
                .add("tc_touroperatorreference", tc_touroperatorreference)
                .add("tc_agentteam", tc_agentteam)
                .add("_owninguser_value", _owninguser_value)
                .add("_modifiedonbehalfby_value", _modifiedonbehalfby_value)
                .toString();
    }

    public boolean equalsToNurvisOrder(Booking onTour) {
        throw new NotImplementedException();
    }

    public boolean assertMsdBookingMatchesOnTour(Booking onTour) {
        assertEquals(STATE_MAP.get(onTour.getStatus()), this.statecode);
        assertEquals(LocalDate.parse(onTour.getBeginning_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_departuredate, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getEnd_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_returndate, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getDate(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.createdon, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getAmendment_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_ontourupdateddate, MSD_DATE_TIME_FORMATTER));
        assertEquals(LocalDate.parse(onTour.getExt_amendment_date(), ONTOUR_DATE_FORMATTER),
                LocalDate.parse(this.tc_touroperatorupdateddate, MSD_DATE_TIME_FORMATTER));
        assertEquals(onTour.getDestination(), this._tc_destinationgatewayid_value);
        assertEquals(onTour.getBrand(), MsdSession.get().getTcBrandNameByBrandGuid(this._tc_brandid_value));
        assertEquals(onTour.getTo_code(), MsdSession.get().getTcToCodeByTourOperatorGiud(this._tc_touroperatorid_value));
        assertEquals(String.valueOf(onTour.getPnr_version()), this.tc_ontourversion);
        if (null != onTour.getBrochure_code()) {
            assertEquals(onTour.getBrochure_code(), this.tc_brochurecode);
        }
        assertEquals(onTour.getBooking_remark(), getParsedRemarks(this.tc_remark));
        assertEquals(parseOnTourPaxListToMsdPaxList(onTour.getPax()),
                getPaxList(this.tc_participants, this.tc_participantremarks));

        return true;
    }

    @Override
    public boolean assertMsdBookingMatchesOnTour(Service onTourService) {
        throw new NotImplementedException();
    }

    /**
     * Parses remarks into {@link Booking_remark}s List.
     *
     * @param msdPaxRemark remarks from msD.
     * @return Parsed Remarks.
     */
    private ArrayList<Booking_remark> getParsedRemarks(String msdPaxRemark) {
        ArrayList<Booking_remark> remarkList = new ArrayList<>();
        String[] remarkSeparatedByItem = msdPaxRemark.split(",\\r\\n");
        if (remarkSeparatedByItem.length == 1) {
            remarkSeparatedByItem = msdPaxRemark.split("\\n");
        }

        if (remarkSeparatedByItem.length == 1 && remarkSeparatedByItem[0].equals("null")) return null;

        Arrays.stream(remarkSeparatedByItem).forEach(it -> {
            String[] oneRemarkSeparatedByComma = it.split(",");
            assert oneRemarkSeparatedByComma.length == 2 :
                    String.format("Remark has unexpected quantity of properties. Expected 2, Actually - %s", oneRemarkSeparatedByComma.length);

            remarkList.add(new Booking_remark(oneRemarkSeparatedByComma[0], oneRemarkSeparatedByComma[1]));
        });

        return remarkList;
    }
}
