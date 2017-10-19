package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.thomascook.nurvisAdapter.request.ReservationCustomerTypeRequest;
import com.thomascook.ontour.Service;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MsdCustomer extends MsdService {

    private static final Map LANGUAGES_MSD_TO_NURVIS = new HashMap<String, String>() {{
        put("950000002", "H");
    }};
    //region Fields
    private String customertypecode;
    private String tc_sourcesystemid;
    private String tc_salutation;
    private String address2_addresstypecode;
    private String birthdate;
    private String merged;
    private String territorycode;
    private String emailaddress1;
    private String emailaddress2;
    private String tc_address1_postalcode;
    private String preferredappointmenttimecode;
    private String tc_address2_postalcode;
    private String _tc_sourcemarketid_value;
    private String haschildrencode;
    private String tc_language;
    private String tc_address2_county;
    private String isbackofficecustomer;
    private String _owningbusinessunit_value;
    private String educationcode;
    private String lastname;
    private String donotpostalmail;
    private String marketingonly;
    private String donotphone;
    private String preferredcontactmethodcode;
    private String tc_marketing;
    private String _ownerid_value;
    private String tc_address1_county;
    private String tc_address1_street;
    private String customersizecode;
    private String firstname;
    private String yomifullname;
    private String tc_telephone3type;
    private String tc_address2_street;
    private String donotemail;
    private String middlename;
    private String address2_shippingmethodcode;
    private String fullname;
    private String timezoneruleversionnumber;
    private String address1_addressid;
    private String address2_freighttermscode;
    private String statuscode;
    private String createdon;
    private String tc_emailaddress2type;
    private String tc_donotallowsms;
    private String tc_telephone1type;
    private String donotsendmm;
    private String donotfax;
    private String tc_address1_town;
    private String leadsourcecode;
    private String tc_disabledindicator;
    private String versionnumber;
    private String modifiedon;
    private String creditonhold;
    private String telephone2;
    private String telephone3;
    private String telephone1;
    private String tc_gender;
    private String tc_telephone2type;
    private String address3_addressid;
    private String donotbulkemail;
    private String _modifiedby_value;
    private String followemail;
    private String shippingmethodcode;
    private String _createdby_value;
    private String donotbulkpostalmail;
    private String tc_emailaddress1type;
    private String contactid;
    private String tc_address2_town;
    private String _owningteam_value;
    private String participatesinworkflow;
    private String statecode;
    private String address2_addressid;
    private String address2_line2;
    private String assistantphone;
    private String utcconversiontimezonecode;
    private String address1_county;
    private String address3_line3;
    private String yomimiddlename;
    private String ftpsiteurl;
    private String address1_longitude;
    private String accountrolecode;
    private String address1_postalcode;
    private String tc_address2_flatorunitnumber;
    private String pager;
    private String address3_postalcode;
    private String _createdbyexternalparty_value;
    private String address1_composite;
    private String assistantname;
    private String anniversary;
    private String governmentid;
    private String emailaddress3;
    private String address2_telephone1;
    private String address1_upszone;
    private String address3_utcoffset;
    private String address2_stateorprovince;
    private String _defaultpricelevelid_value;
    private String address3_telephone3;
    private String salutation;
    private String address1_telephone3;
    private String familystatuscode;
    private String tc_address2_additionalinformation;
    private String yomilastname;
    private String lastusedincampaign;
    private String _parentcustomerid_value;
    private String address2_country;
    private String entityimage;
    private String aging60;
    private String address1_telephone2;
    private String address2_longitude;
    private String nickname;
    private String address1_country;
    private String _owninguser_value;
    private String paymenttermscode;
    private String address1_telephone1;
    private String _accountid_value;
    private String _parentcontactid_value;
    private String entityimage_url;
    private String address3_longitude;
    private String mobilephone;
    private String address2_city;
    private String address1_freighttermscode;
    private String externaluseridentifier;
    private String tc_calculatedyearofbirth;
    private String address3_name;
    private String tc_address1_housenumberorbuilding;
    private String subscriptionid;
    private String overriddencreatedon;
    private String yomifirstname;
    private String address1_primarycontactname;
    private String processid;
    private String _masterid_value;
    private String managerphone;
    private String address1_utcoffset;
    private String address2_latitude;
    private String creditlimit_base;
    private String address1_city;
    private String address3_latitude;
    private String callback;
    private String aging30;
    private String company;
    private String address2_utcoffset;
    private String numberofchildren;
    private String gendercode;
    private String _modifiedbyexternalparty_value;
    private String address2_line3;
    private String address3_upszone;
    private String address3_line1;
    private String address1_stateorprovince;
    private String _tc_address2_countryid_value;
    private String _originatingleadid_value;
    private String aging30_base;
    private String annualincome_base;
    private String address3_shippingmethodcode;
    private String childrensnames;
    private String address3_line2;
    private String address1_name;
    private String department;
    private String address2_telephone3;
    private String tc_address1_flatorunitnumber;
    private String address3_city;
    private String business2;
    private String entityimageid;
    private String address1_latitude;
    private String address1_postofficebox;
    private String spousesname;
    private String home2;
    private String address2_county;
    private String traversedpath;
    private String _transactioncurrencyid_value;
    private String address2_fax;
    private String address2_composite;
    private String exchangerate;
    private String creditlimit;
    private String preferredappointmentdaycode;
    private String _preferredsystemuserid_value;
    private String address1_line2;
    private String jobtitle;
    private String _preferredserviceid_value;
    private String address2_line1;
    private String tc_address1_additionalinformation;
    private String importsequencenumber;
    private String address3_telephone1;
    private String address2_telephone2;
    private String tc_academictitle;
    private String timespentbymeonemailandmeetings;
    private String address1_line3;
    private String description;
    private String _slaid_value;
    private String entityimage_timestamp;
    private String address3_primarycontactname;
    private String address3_stateorprovince;
    private String tc_emailaddress3type;
    private String address2_upszone;
    private String address3_country;
    private String tc_dateofdeath;
    private String _preferredequipmentid_value;
    private String address2_postofficebox;
    private String websiteurl;
    private String address2_postalcode;
    private String annualincome;
    private String aging90;
    private String fax;
    private String address1_shippingmethodcode;
    private String address3_addresstypecode;
    private String _modifiedonbehalfby_value;
    private String address1_line1;
    private String address3_postofficebox;
    private String address3_composite;
    private String address2_name;
    private String _tc_address1_countryid_value;
    private String suffix;
    private String lastonholdtime;
    private String address3_freighttermscode;
    private String tc_address2_housenumberorbuilding;
    private String employeeid;
    private String managername;
    private String tc_segment;
    private String address2_primarycontactname;
    private String stageid;
    private String aging60_base;
    private String address1_addresstypecode;
    private String address3_county;
    private String _createdonbehalfby_value;
    private String aging90_base;
    private String address3_telephone2;
    private String address1_fax;
    private String onholdtime;
    private String address3_fax;
    //endregion
    private String _slainvokedid_value;

    public MsdCustomer(Map<String, Object> jsonMap) {
        setDetailsFromJsonMap(jsonMap);
    }

    /**
     * Fills in the Customer fields according to response on rest-call
     *
     * @param jsonMap Json Map made basing on {@link com.jayway.restassured.response.Response}. {@code (new JSONObject(jsonObject)).toMap().get("value").get(i)}
     */
    private void setDetailsFromJsonMap(Map<String, Object> jsonMap) {
        this.customertypecode = String.valueOf(jsonMap.get("customertypecode"));
        this.tc_sourcesystemid = String.valueOf(jsonMap.get("tc_sourcesystemid"));
        this.tc_salutation = String.valueOf(jsonMap.get("tc_salutation@OData.Community.Display.V1.FormattedValue"));
        this.address2_addresstypecode = String.valueOf(jsonMap.get("address2_addresstypecode"));
        this.birthdate = String.valueOf(jsonMap.get("birthdate"));
        this.merged = String.valueOf(jsonMap.get("merged"));
        this.territorycode = String.valueOf(jsonMap.get("territorycode"));
        this.emailaddress1 = String.valueOf(jsonMap.get("emailaddress1"));
        this.emailaddress2 = String.valueOf(jsonMap.get("emailaddress2"));
        this.tc_address1_postalcode = String.valueOf(jsonMap.get("tc_address1_postalcode"));
        this.preferredappointmenttimecode = String.valueOf(jsonMap.get("preferredappointmenttimecode"));
        this.tc_address2_postalcode = String.valueOf(jsonMap.get("tc_address2_postalcode"));
        this._tc_sourcemarketid_value = String.valueOf(jsonMap.get("_tc_sourcemarketid_value"));
        this.haschildrencode = String.valueOf(jsonMap.get("haschildrencode"));
        this.tc_language = String.valueOf(jsonMap.get("tc_language"));
        this.tc_address2_county = String.valueOf(jsonMap.get("tc_address2_county"));
        this.isbackofficecustomer = String.valueOf(jsonMap.get("isbackofficecustomer"));
        this._owningbusinessunit_value = String.valueOf(jsonMap.get("_owningbusinessunit_value"));
        this.educationcode = String.valueOf(jsonMap.get("educationcode"));
        this.lastname = String.valueOf(jsonMap.get("lastname"));
        this.donotpostalmail = String.valueOf(jsonMap.get("donotpostalmail"));
        this.marketingonly = String.valueOf(jsonMap.get("marketingonly"));
        this.donotphone = String.valueOf(jsonMap.get("donotphone"));
        this.preferredcontactmethodcode = String.valueOf(jsonMap.get("preferredcontactmethodcode"));
        this.tc_marketing = String.valueOf(jsonMap.get("tc_marketing"));
        this._ownerid_value = String.valueOf(jsonMap.get("_ownerid_value"));
        this.tc_address1_county = String.valueOf(jsonMap.get("tc_address1_county"));
        this.tc_address1_street = String.valueOf(jsonMap.get("tc_address1_street"));
        this.customersizecode = String.valueOf(jsonMap.get("customersizecode"));
        this.firstname = String.valueOf(jsonMap.get("firstname"));
        this.yomifullname = String.valueOf(jsonMap.get("yomifullname"));
        this.tc_telephone3type = String.valueOf(jsonMap.get("tc_telephone3type"));
        this.tc_address2_street = String.valueOf(jsonMap.get("tc_address2_street"));
        this.donotemail = String.valueOf(jsonMap.get("donotemail"));
        this.middlename = String.valueOf(jsonMap.get("middlename"));
        this.address2_shippingmethodcode = String.valueOf(jsonMap.get("address2_shippingmethodcode"));
        this.fullname = String.valueOf(jsonMap.get("fullname"));
        this.timezoneruleversionnumber = String.valueOf(jsonMap.get("timezoneruleversionnumber"));
        this.address1_addressid = String.valueOf(jsonMap.get("address1_addressid"));
        this.address2_freighttermscode = String.valueOf(jsonMap.get("address2_freighttermscode"));
        this.statuscode = String.valueOf(jsonMap.get("statuscode"));
        this.createdon = String.valueOf(jsonMap.get("createdon"));
        this.tc_emailaddress2type = String.valueOf(jsonMap.get("tc_emailaddress2type"));
        this.tc_donotallowsms = String.valueOf(jsonMap.get("tc_donotallowsms"));
        this.tc_telephone1type = String.valueOf(jsonMap.get("tc_telephone1type"));
        this.donotsendmm = String.valueOf(jsonMap.get("donotsendmm"));
        this.donotfax = String.valueOf(jsonMap.get("donotfax"));
        this.tc_address1_town = String.valueOf(jsonMap.get("tc_address1_town"));
        this.leadsourcecode = String.valueOf(jsonMap.get("leadsourcecode"));
        this.tc_disabledindicator = String.valueOf(jsonMap.get("tc_disabledindicator"));
        this.versionnumber = String.valueOf(jsonMap.get("versionnumber"));
        this.modifiedon = String.valueOf(jsonMap.get("modifiedon"));
        this.creditonhold = String.valueOf(jsonMap.get("creditonhold"));
        this.telephone2 = String.valueOf(jsonMap.get("telephone2"));
        this.telephone3 = String.valueOf(jsonMap.get("telephone3"));
        this.telephone1 = String.valueOf(jsonMap.get("telephone1"));
        this.tc_gender = String.valueOf(jsonMap.get("tc_gender"));
        this.tc_telephone2type = String.valueOf(jsonMap.get("tc_telephone2type"));
        this.address3_addressid = String.valueOf(jsonMap.get("address3_addressid"));
        this.donotbulkemail = String.valueOf(jsonMap.get("donotbulkemail"));
        this._modifiedby_value = String.valueOf(jsonMap.get("_modifiedby_value"));
        this.followemail = String.valueOf(jsonMap.get("followemail"));
        this.shippingmethodcode = String.valueOf(jsonMap.get("shippingmethodcode"));
        this._createdby_value = String.valueOf(jsonMap.get("_createdby_value"));
        this.donotbulkpostalmail = String.valueOf(jsonMap.get("donotbulkpostalmail"));
        this.tc_emailaddress1type = String.valueOf(jsonMap.get("tc_emailaddress1type"));
        this.contactid = String.valueOf(jsonMap.get("contactid"));
        this.tc_address2_town = String.valueOf(jsonMap.get("tc_address2_town"));
        this._owningteam_value = String.valueOf(jsonMap.get("_owningteam_value"));
        this.participatesinworkflow = String.valueOf(jsonMap.get("participatesinworkflow"));
        this.statecode = String.valueOf(jsonMap.get("statecode"));
        this.address2_addressid = String.valueOf(jsonMap.get("address2_addressid"));
        this.address2_line2 = String.valueOf(jsonMap.get("address2_line2"));
        this.assistantphone = String.valueOf(jsonMap.get("assistantphone"));
        this.utcconversiontimezonecode = String.valueOf(jsonMap.get("utcconversiontimezonecode"));
        this.address1_county = String.valueOf(jsonMap.get("address1_county"));
        this.address3_line3 = String.valueOf(jsonMap.get("address3_line3"));
        this.yomimiddlename = String.valueOf(jsonMap.get("yomimiddlename"));
        this.ftpsiteurl = String.valueOf(jsonMap.get("ftpsiteurl"));
        this.address1_longitude = String.valueOf(jsonMap.get("address1_longitude"));
        this.accountrolecode = String.valueOf(jsonMap.get("accountrolecode"));
        this.address1_postalcode = String.valueOf(jsonMap.get("address1_postalcode"));
        this.tc_address2_flatorunitnumber = String.valueOf(jsonMap.get("tc_address2_flatorunitnumber"));
        this.pager = String.valueOf(jsonMap.get("pager"));
        this.address3_postalcode = String.valueOf(jsonMap.get("address3_postalcode"));
        this._createdbyexternalparty_value = String.valueOf(jsonMap.get("_createdbyexternalparty_value"));
        this.address1_composite = String.valueOf(jsonMap.get("address1_composite"));
        this.assistantname = String.valueOf(jsonMap.get("assistantname"));
        this.anniversary = String.valueOf(jsonMap.get("anniversary"));
        this.governmentid = String.valueOf(jsonMap.get("governmentid"));
        this.emailaddress3 = String.valueOf(jsonMap.get("emailaddress3"));
        this.address2_telephone1 = String.valueOf(jsonMap.get("address2_telephone1"));
        this.address1_upszone = String.valueOf(jsonMap.get("address1_upszone"));
        this.address3_utcoffset = String.valueOf(jsonMap.get("address3_utcoffset"));
        this.address2_stateorprovince = String.valueOf(jsonMap.get("address2_stateorprovince"));
        this._defaultpricelevelid_value = String.valueOf(jsonMap.get("_defaultpricelevelid_value"));
        this.address3_telephone3 = String.valueOf(jsonMap.get("address3_telephone3"));
        this.salutation = String.valueOf(jsonMap.get("salutation"));
        this.address1_telephone3 = String.valueOf(jsonMap.get("address1_telephone3"));
        this.familystatuscode = String.valueOf(jsonMap.get("familystatuscode"));
        this.tc_address2_additionalinformation = String.valueOf(jsonMap.get("tc_address2_additionalinformation"));
        this.yomilastname = String.valueOf(jsonMap.get("yomilastname"));
        this.lastusedincampaign = String.valueOf(jsonMap.get("lastusedincampaign"));
        this._parentcustomerid_value = String.valueOf(jsonMap.get("_parentcustomerid_value"));
        this.address2_country = String.valueOf(jsonMap.get("address2_country"));
        this.entityimage = String.valueOf(jsonMap.get("entityimage"));
        this.aging60 = String.valueOf(jsonMap.get("aging60"));
        this.address1_telephone2 = String.valueOf(jsonMap.get("address1_telephone2"));
        this.address2_longitude = String.valueOf(jsonMap.get("address2_longitude"));
        this.nickname = String.valueOf(jsonMap.get("nickname"));
        this.address1_country = String.valueOf(jsonMap.get("address1_country"));
        this._owninguser_value = String.valueOf(jsonMap.get("_owninguser_value"));
        this.paymenttermscode = String.valueOf(jsonMap.get("paymenttermscode"));
        this.address1_telephone1 = String.valueOf(jsonMap.get("address1_telephone1"));
        this._accountid_value = String.valueOf(jsonMap.get("_accountid_value"));
        this._parentcontactid_value = String.valueOf(jsonMap.get("_parentcontactid_value"));
        this.entityimage_url = String.valueOf(jsonMap.get("entityimage_url"));
        this.address3_longitude = String.valueOf(jsonMap.get("address3_longitude"));
        this.mobilephone = String.valueOf(jsonMap.get("mobilephone"));
        this.address2_city = String.valueOf(jsonMap.get("address2_city"));
        this.address1_freighttermscode = String.valueOf(jsonMap.get("address1_freighttermscode"));
        this.externaluseridentifier = String.valueOf(jsonMap.get("externaluseridentifier"));
        this.tc_calculatedyearofbirth = String.valueOf(jsonMap.get("tc_calculatedyearofbirth"));
        this.address3_name = String.valueOf(jsonMap.get("address3_name"));
        this.tc_address1_housenumberorbuilding = String.valueOf(jsonMap.get("tc_address1_housenumberorbuilding"));
        this.subscriptionid = String.valueOf(jsonMap.get("subscriptionid"));
        this.overriddencreatedon = String.valueOf(jsonMap.get("overriddencreatedon"));
        this.yomifirstname = String.valueOf(jsonMap.get("yomifirstname"));
        this.address1_primarycontactname = String.valueOf(jsonMap.get("address1_primarycontactname"));
        this.processid = String.valueOf(jsonMap.get("processid"));
        this._masterid_value = String.valueOf(jsonMap.get("_masterid_value"));
        this.managerphone = String.valueOf(jsonMap.get("managerphone"));
        this.address1_utcoffset = String.valueOf(jsonMap.get("address1_utcoffset"));
        this.address2_latitude = String.valueOf(jsonMap.get("address2_latitude"));
        this.creditlimit_base = String.valueOf(jsonMap.get("creditlimit_base"));
        this.address1_city = String.valueOf(jsonMap.get("address1_city"));
        this.address3_latitude = String.valueOf(jsonMap.get("address3_latitude"));
        this.callback = String.valueOf(jsonMap.get("callback"));
        this.aging30 = String.valueOf(jsonMap.get("aging30"));
        this.company = String.valueOf(jsonMap.get("company"));
        this.address2_utcoffset = String.valueOf(jsonMap.get("address2_utcoffset"));
        this.numberofchildren = String.valueOf(jsonMap.get("numberofchildren"));
        this.gendercode = String.valueOf(jsonMap.get("gendercode"));
        this._modifiedbyexternalparty_value = String.valueOf(jsonMap.get("_modifiedbyexternalparty_value"));
        this.address2_line3 = String.valueOf(jsonMap.get("address2_line3"));
        this.address3_upszone = String.valueOf(jsonMap.get("address3_upszone"));
        this.address3_line1 = String.valueOf(jsonMap.get("address3_line1"));
        this.address1_stateorprovince = String.valueOf(jsonMap.get("address1_stateorprovince"));
        this._tc_address2_countryid_value = String.valueOf(jsonMap.get("_tc_address2_countryid_value"));
        this._originatingleadid_value = String.valueOf(jsonMap.get("_originatingleadid_value"));
        this.aging30_base = String.valueOf(jsonMap.get("aging30_base"));
        this.annualincome_base = String.valueOf(jsonMap.get("annualincome_base"));
        this.address3_shippingmethodcode = String.valueOf(jsonMap.get("address3_shippingmethodcode"));
        this.childrensnames = String.valueOf(jsonMap.get("childrensnames"));
        this.address3_line2 = String.valueOf(jsonMap.get("address3_line2"));
        this.address1_name = String.valueOf(jsonMap.get("address1_name"));
        this.department = String.valueOf(jsonMap.get("department"));
        this.address2_telephone3 = String.valueOf(jsonMap.get("address2_telephone3"));
        this.tc_address1_flatorunitnumber = String.valueOf(jsonMap.get("tc_address1_flatorunitnumber"));
        this.address3_city = String.valueOf(jsonMap.get("address3_city"));
        this.business2 = String.valueOf(jsonMap.get("business2"));
        this.entityimageid = String.valueOf(jsonMap.get("entityimageid"));
        this.address1_latitude = String.valueOf(jsonMap.get("address1_latitude"));
        this.address1_postofficebox = String.valueOf(jsonMap.get("address1_postofficebox"));
        this.spousesname = String.valueOf(jsonMap.get("spousesname"));
        this.home2 = String.valueOf(jsonMap.get("home2"));
        this.address2_county = String.valueOf(jsonMap.get("address2_county"));
        this.traversedpath = String.valueOf(jsonMap.get("traversedpath"));
        this._transactioncurrencyid_value = String.valueOf(jsonMap.get("_transactioncurrencyid_value"));
        this.address2_fax = String.valueOf(jsonMap.get("address2_fax"));
        this.address2_composite = String.valueOf(jsonMap.get("address2_composite"));
        this.exchangerate = String.valueOf(jsonMap.get("exchangerate"));
        this.creditlimit = String.valueOf(jsonMap.get("creditlimit"));
        this.preferredappointmentdaycode = String.valueOf(jsonMap.get("preferredappointmentdaycode"));
        this._preferredsystemuserid_value = String.valueOf(jsonMap.get("_preferredsystemuserid_value"));
        this.address1_line2 = String.valueOf(jsonMap.get("address1_line2"));
        this.jobtitle = String.valueOf(jsonMap.get("jobtitle"));
        this._preferredserviceid_value = String.valueOf(jsonMap.get("_preferredserviceid_value"));
        this.address2_line1 = String.valueOf(jsonMap.get("address2_line1"));
        this.tc_address1_additionalinformation = String.valueOf(jsonMap.get("tc_address1_additionalinformation"));
        this.importsequencenumber = String.valueOf(jsonMap.get("importsequencenumber"));
        this.address3_telephone1 = String.valueOf(jsonMap.get("address3_telephone1"));
        this.address2_telephone2 = String.valueOf(jsonMap.get("address2_telephone2"));
        this.tc_academictitle = String.valueOf(jsonMap.get("tc_academictitle"));
        this.timespentbymeonemailandmeetings = String.valueOf(jsonMap.get("timespentbymeonemailandmeetings"));
        this.address1_line3 = String.valueOf(jsonMap.get("address1_line3"));
        this.description = String.valueOf(jsonMap.get("description"));
        this._slaid_value = String.valueOf(jsonMap.get("_slaid_value"));
        this.entityimage_timestamp = String.valueOf(jsonMap.get("entityimage_timestamp"));
        this.address3_primarycontactname = String.valueOf(jsonMap.get("address3_primarycontactname"));
        this.address3_stateorprovince = String.valueOf(jsonMap.get("address3_stateorprovince"));
        this.tc_emailaddress3type = String.valueOf(jsonMap.get("tc_emailaddress3type"));
        this.address2_upszone = String.valueOf(jsonMap.get("address2_upszone"));
        this.address3_country = String.valueOf(jsonMap.get("address3_country"));
        this.tc_dateofdeath = String.valueOf(jsonMap.get("tc_dateofdeath"));
        this._preferredequipmentid_value = String.valueOf(jsonMap.get("_preferredequipmentid_value"));
        this.address2_postofficebox = String.valueOf(jsonMap.get("address2_postofficebox"));
        this.websiteurl = String.valueOf(jsonMap.get("websiteurl"));
        this.address2_postalcode = String.valueOf(jsonMap.get("address2_postalcode"));
        this.annualincome = String.valueOf(jsonMap.get("annualincome"));
        this.aging90 = String.valueOf(jsonMap.get("aging90"));
        this.fax = String.valueOf(jsonMap.get("fax"));
        this.address1_shippingmethodcode = String.valueOf(jsonMap.get("address1_shippingmethodcode"));
        this.address3_addresstypecode = String.valueOf(jsonMap.get("address3_addresstypecode"));
        this._modifiedonbehalfby_value = String.valueOf(jsonMap.get("_modifiedonbehalfby_value"));
        this.address1_line1 = String.valueOf(jsonMap.get("address1_line1"));
        this.address3_postofficebox = String.valueOf(jsonMap.get("address3_postofficebox"));
        this.address3_composite = String.valueOf(jsonMap.get("address3_composite"));
        this.address2_name = String.valueOf(jsonMap.get("address2_name"));
        this._tc_address1_countryid_value = String.valueOf(jsonMap.get("_tc_address1_countryid_value"));
        this.suffix = String.valueOf(jsonMap.get("suffix"));
        this.lastonholdtime = String.valueOf(jsonMap.get("lastonholdtime"));
        this.address3_freighttermscode = String.valueOf(jsonMap.get("address3_freighttermscode"));
        this.tc_address2_housenumberorbuilding = String.valueOf(jsonMap.get("tc_address2_housenumberorbuilding"));
        this.employeeid = String.valueOf(jsonMap.get("employeeid"));
        this.managername = String.valueOf(jsonMap.get("managername"));
        this.tc_segment = String.valueOf(jsonMap.get("tc_segment"));
        this.address2_primarycontactname = String.valueOf(jsonMap.get("address2_primarycontactname"));
        this.stageid = String.valueOf(jsonMap.get("stageid"));
        this.aging60_base = String.valueOf(jsonMap.get("aging60_base"));
        this.address1_addresstypecode = String.valueOf(jsonMap.get("address1_addresstypecode"));
        this.address3_county = String.valueOf(jsonMap.get("address3_county"));
        this._createdonbehalfby_value = String.valueOf(jsonMap.get("_createdonbehalfby_value"));
        this.aging90_base = String.valueOf(jsonMap.get("aging90_base"));
        this.address3_telephone2 = String.valueOf(jsonMap.get("address3_telephone2"));
        this.address1_fax = String.valueOf(jsonMap.get("address1_fax"));
        this.onholdtime = String.valueOf(jsonMap.get("onholdtime"));
        this.address3_fax = String.valueOf(jsonMap.get("address3_fax"));
        this._slainvokedid_value = String.valueOf(jsonMap.get("_slainvokedid_value"));
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("customertypecode", customertypecode)
                .add("tc_sourcesystemid", tc_sourcesystemid)
                .add("tc_salutation", tc_salutation)
                .add("address2_addresstypecode", address2_addresstypecode)
                .add("birthdate", birthdate)
                .add("merged", merged)
                .add("territorycode", territorycode)
                .add("emailaddress1", emailaddress1)
                .add("emailaddress2", emailaddress2)
                .add("tc_address1_postalcode", tc_address1_postalcode)
                .add("preferredappointmenttimecode", preferredappointmenttimecode)
                .add("tc_address2_postalcode", tc_address2_postalcode)
                .add("_tc_sourcemarketid_value", _tc_sourcemarketid_value)
                .add("haschildrencode", haschildrencode)
                .add("tc_language", tc_language)
                .add("tc_address2_county", tc_address2_county)
                .add("isbackofficecustomer", isbackofficecustomer)
                .add("_owningbusinessunit_value", _owningbusinessunit_value)
                .add("educationcode", educationcode)
                .add("lastname", lastname)
                .add("donotpostalmail", donotpostalmail)
                .add("marketingonly", marketingonly)
                .add("donotphone", donotphone)
                .add("preferredcontactmethodcode", preferredcontactmethodcode)
                .add("tc_marketing", tc_marketing)
                .add("_ownerid_value", _ownerid_value)
                .add("tc_address1_county", tc_address1_county)
                .add("tc_address1_street", tc_address1_street)
                .add("customersizecode", customersizecode)
                .add("firstname", firstname)
                .add("yomifullname", yomifullname)
                .add("tc_telephone3type", tc_telephone3type)
                .add("tc_address2_street", tc_address2_street)
                .add("donotemail", donotemail)
                .add("middlename", middlename)
                .add("address2_shippingmethodcode", address2_shippingmethodcode)
                .add("fullname", fullname)
                .add("timezoneruleversionnumber", timezoneruleversionnumber)
                .add("address1_addressid", address1_addressid)
                .add("address2_freighttermscode", address2_freighttermscode)
                .add("statuscode", statuscode)
                .add("createdon", createdon)
                .add("tc_emailaddress2type", tc_emailaddress2type)
                .add("tc_donotallowsms", tc_donotallowsms)
                .add("tc_telephone1type", tc_telephone1type)
                .add("donotsendmm", donotsendmm)
                .add("donotfax", donotfax)
                .add("tc_address1_town", tc_address1_town)
                .add("leadsourcecode", leadsourcecode)
                .add("tc_disabledindicator", tc_disabledindicator)
                .add("versionnumber", versionnumber)
                .add("modifiedon", modifiedon)
                .add("creditonhold", creditonhold)
                .add("telephone2", telephone2)
                .add("telephone3", telephone3)
                .add("telephone1", telephone1)
                .add("tc_gender", tc_gender)
                .add("tc_telephone2type", tc_telephone2type)
                .add("address3_addressid", address3_addressid)
                .add("donotbulkemail", donotbulkemail)
                .add("_modifiedby_value", _modifiedby_value)
                .add("followemail", followemail)
                .add("shippingmethodcode", shippingmethodcode)
                .add("_createdby_value", _createdby_value)
                .add("donotbulkpostalmail", donotbulkpostalmail)
                .add("tc_emailaddress1type", tc_emailaddress1type)
                .add("contactid", contactid)
                .add("tc_address2_town", tc_address2_town)
                .add("_owningteam_value", _owningteam_value)
                .add("participatesinworkflow", participatesinworkflow)
                .add("statecode", statecode)
                .add("address2_addressid", address2_addressid)
                .add("address2_line2", address2_line2)
                .add("assistantphone", assistantphone)
                .add("utcconversiontimezonecode", utcconversiontimezonecode)
                .add("address1_county", address1_county)
                .add("address3_line3", address3_line3)
                .add("yomimiddlename", yomimiddlename)
                .add("ftpsiteurl", ftpsiteurl)
                .add("address1_longitude", address1_longitude)
                .add("accountrolecode", accountrolecode)
                .add("address1_postalcode", address1_postalcode)
                .add("tc_address2_flatorunitnumber", tc_address2_flatorunitnumber)
                .add("pager", pager)
                .add("address3_postalcode", address3_postalcode)
                .add("_createdbyexternalparty_value", _createdbyexternalparty_value)
                .add("address1_composite", address1_composite)
                .add("assistantname", assistantname)
                .add("anniversary", anniversary)
                .add("governmentid", governmentid)
                .add("emailaddress3", emailaddress3)
                .add("address2_telephone1", address2_telephone1)
                .add("address1_upszone", address1_upszone)
                .add("address3_utcoffset", address3_utcoffset)
                .add("address2_stateorprovince", address2_stateorprovince)
                .add("_defaultpricelevelid_value", _defaultpricelevelid_value)
                .add("address3_telephone3", address3_telephone3)
                .add("salutation", salutation)
                .add("address1_telephone3", address1_telephone3)
                .add("familystatuscode", familystatuscode)
                .add("tc_address2_additionalinformation", tc_address2_additionalinformation)
                .add("yomilastname", yomilastname)
                .add("lastusedincampaign", lastusedincampaign)
                .add("_parentcustomerid_value", _parentcustomerid_value)
                .add("address2_country", address2_country)
                .add("entityimage", entityimage)
                .add("aging60", aging60)
                .add("address1_telephone2", address1_telephone2)
                .add("address2_longitude", address2_longitude)
                .add("nickname", nickname)
                .add("address1_country", address1_country)
                .add("_owninguser_value", _owninguser_value)
                .add("paymenttermscode", paymenttermscode)
                .add("address1_telephone1", address1_telephone1)
                .add("_accountid_value", _accountid_value)
                .add("_parentcontactid_value", _parentcontactid_value)
                .add("entityimage_url", entityimage_url)
                .add("address3_longitude", address3_longitude)
                .add("mobilephone", mobilephone)
                .add("address2_city", address2_city)
                .add("address1_freighttermscode", address1_freighttermscode)
                .add("externaluseridentifier", externaluseridentifier)
                .add("tc_calculatedyearofbirth", tc_calculatedyearofbirth)
                .add("address3_name", address3_name)
                .add("tc_address1_housenumberorbuilding", tc_address1_housenumberorbuilding)
                .add("subscriptionid", subscriptionid)
                .add("overriddencreatedon", overriddencreatedon)
                .add("yomifirstname", yomifirstname)
                .add("address1_primarycontactname", address1_primarycontactname)
                .add("processid", processid)
                .add("_masterid_value", _masterid_value)
                .add("managerphone", managerphone)
                .add("address1_utcoffset", address1_utcoffset)
                .add("address2_latitude", address2_latitude)
                .add("creditlimit_base", creditlimit_base)
                .add("address1_city", address1_city)
                .add("address3_latitude", address3_latitude)
                .add("callback", callback)
                .add("aging30", aging30)
                .add("company", company)
                .add("address2_utcoffset", address2_utcoffset)
                .add("numberofchildren", numberofchildren)
                .add("gendercode", gendercode)
                .add("_modifiedbyexternalparty_value", _modifiedbyexternalparty_value)
                .add("address2_line3", address2_line3)
                .add("address3_upszone", address3_upszone)
                .add("address3_line1", address3_line1)
                .add("address1_stateorprovince", address1_stateorprovince)
                .add("_tc_address2_countryid_value", _tc_address2_countryid_value)
                .add("_originatingleadid_value", _originatingleadid_value)
                .add("aging30_base", aging30_base)
                .add("annualincome_base", annualincome_base)
                .add("address3_shippingmethodcode", address3_shippingmethodcode)
                .add("childrensnames", childrensnames)
                .add("address3_line2", address3_line2)
                .add("address1_name", address1_name)
                .add("department", department)
                .add("address2_telephone3", address2_telephone3)
                .add("tc_address1_flatorunitnumber", tc_address1_flatorunitnumber)
                .add("address3_city", address3_city)
                .add("business2", business2)
                .add("entityimageid", entityimageid)
                .add("address1_latitude", address1_latitude)
                .add("address1_postofficebox", address1_postofficebox)
                .add("spousesname", spousesname)
                .add("home2", home2)
                .add("address2_county", address2_county)
                .add("traversedpath", traversedpath)
                .add("_transactioncurrencyid_value", _transactioncurrencyid_value)
                .add("address2_fax", address2_fax)
                .add("address2_composite", address2_composite)
                .add("exchangerate", exchangerate)
                .add("creditlimit", creditlimit)
                .add("preferredappointmentdaycode", preferredappointmentdaycode)
                .add("_preferredsystemuserid_value", _preferredsystemuserid_value)
                .add("address1_line2", address1_line2)
                .add("jobtitle", jobtitle)
                .add("_preferredserviceid_value", _preferredserviceid_value)
                .add("address2_line1", address2_line1)
                .add("tc_address1_additionalinformation", tc_address1_additionalinformation)
                .add("importsequencenumber", importsequencenumber)
                .add("address3_telephone1", address3_telephone1)
                .add("address2_telephone2", address2_telephone2)
                .add("tc_academictitle", tc_academictitle)
                .add("timespentbymeonemailandmeetings", timespentbymeonemailandmeetings)
                .add("address1_line3", address1_line3)
                .add("description", description)
                .add("_slaid_value", _slaid_value)
                .add("entityimage_timestamp", entityimage_timestamp)
                .add("address3_primarycontactname", address3_primarycontactname)
                .add("address3_stateorprovince", address3_stateorprovince)
                .add("tc_emailaddress3type", tc_emailaddress3type)
                .add("address2_upszone", address2_upszone)
                .add("address3_country", address3_country)
                .add("tc_dateofdeath", tc_dateofdeath)
                .add("_preferredequipmentid_value", _preferredequipmentid_value)
                .add("address2_postofficebox", address2_postofficebox)
                .add("websiteurl", websiteurl)
                .add("address2_postalcode", address2_postalcode)
                .add("annualincome", annualincome)
                .add("aging90", aging90)
                .add("fax", fax)
                .add("address1_shippingmethodcode", address1_shippingmethodcode)
                .add("address3_addresstypecode", address3_addresstypecode)
                .add("_modifiedonbehalfby_value", _modifiedonbehalfby_value)
                .add("address1_line1", address1_line1)
                .add("address3_postofficebox", address3_postofficebox)
                .add("address3_composite", address3_composite)
                .add("address2_name", address2_name)
                .add("_tc_address1_countryid_value", _tc_address1_countryid_value)
                .add("suffix", suffix)
                .add("lastonholdtime", lastonholdtime)
                .add("address3_freighttermscode", address3_freighttermscode)
                .add("tc_address2_housenumberorbuilding", tc_address2_housenumberorbuilding)
                .add("employeeid", employeeid)
                .add("managername", managername)
                .add("tc_segment", tc_segment)
                .add("address2_primarycontactname", address2_primarycontactname)
                .add("stageid", stageid)
                .add("aging60_base", aging60_base)
                .add("address1_addresstypecode", address1_addresstypecode)
                .add("address3_county", address3_county)
                .add("_createdonbehalfby_value", _createdonbehalfby_value)
                .add("aging90_base", aging90_base)
                .add("address3_telephone2", address3_telephone2)
                .add("address1_fax", address1_fax)
                .add("onholdtime", onholdtime)
                .add("address3_fax", address3_fax)
                .add("_slainvokedid_value", _slainvokedid_value)
                .toString();
    }

    @Override
    boolean assertMsdBookingMatchesOnTour(Service onTourService) {
        return false;
    }

    public boolean assertMsdBookingMatchesOnTour(ReservationCustomerTypeRequest request) {
        if (null != request.getCFirstName()) {
            assertThat(request.getCFirstName(), equalToIgnoringCase(this.firstname));
        }
        if (null != request.getCName()) {
            assertThat(request.getCName(), equalToIgnoringCase(this.lastname));
        }
        if (null != request.getCTitle()) {
            assertEquals(request.getCTitle(), this.tc_salutation);
        }
        if (null != request.getCPOCode()) {
            assertThat(request.getCPOCode(), equalToIgnoringCase(this.tc_address1_postalcode));
        }
        if (null != request.getCLanguage()) {
            assertEquals(request.getCLanguage(), LANGUAGES_MSD_TO_NURVIS.get(this.tc_language));
        }
        if (null != request.getCStreet()) {
            assertThat(request.getCStreet(), equalToIgnoringCase(this.tc_address1_street));
        }
        if (null != request.getCHouseNr()) {
            assertThat(request.getCHouseNr(), equalToIgnoringCase(this.tc_address1_housenumberorbuilding));
        }
        if (null != request.getCCity()) {
            assertThat(request.getCCity(), equalToIgnoringCase(this.tc_address1_town));
        }
        if (null != request.getCTelNr()) {
            assertThat(request.getCTelNr(), equalToIgnoringCase(this.telephone1));
        }
        if (null != request.getCMobile()) {
            assertThat(request.getCMobile(), equalToIgnoringCase(this.mobilephone));
        }
        if (null != request.getCEMailUser() && null != request.getCEMailDomain()) {
            assertThat(String.format("%s@%s", request.getCEMailUser(), request.getCEMailDomain()),
                    equalToIgnoringCase(this.emailaddress1));
        }

        return true;
    }
}
