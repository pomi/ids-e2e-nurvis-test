package com.thomascook.msdAdaptor.msdBookingDetails;

import com.google.common.base.MoreObjects;
import com.jayway.restassured.response.Response;
import com.thomascook.msdAdaptor.MsdSession;
import com.thomascook.ontour.Booking;
import com.thomascook.ontour.Service;
import com.thomascook.utils.Holder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MsdBookingDetails {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsdBookingDetails.class);
    //region Fields
    private MsdBookingGeneralDetails generalDetails;
    private List<MsdAccommodation> accommodations;
    private List<MsdTransport> transports;
    private List<MsdExtraService> extraServices;
    private List<MsdTransfer> transfers;
    private MsdCustomer customer;
    //endregion

    public MsdBookingDetails() {
    }

    public MsdBookingDetails(String bookingId) {
        String bookingGuid = MsdSession.get().getBookingGuidByMsdId(bookingId);

        setGeneralDetails(MsdSession.get().getBookingGeneralDetailsByBookingId(bookingId).prettyPrint());
        setTransports(MsdSession.get().getBookingTransportsServiceByBookingGuid(bookingGuid).prettyPrint());
        setAccommodations(MsdSession.get().getAccommodationServiceByBookingGuid(bookingGuid).prettyPrint());
        setTransfers(MsdSession.get().getBookingTransfersServiceByBookingGuid(bookingGuid).prettyPrint());
        setExtraServices(MsdSession.get().getBookingExtraServiceByBookingGuid(bookingGuid).prettyPrint());
        setCustomer(MsdSession.get().getCustomerObjectByBookingId(bookingId).prettyPrint());
    }

    public MsdBookingGeneralDetails getGeneralDetails() {
        return generalDetails;
    }

    /**
     * Fills in the Booking General details according to response on rest-call
     *
     * @param msdGeneralDetailsServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setGeneralDetails(String msdGeneralDetailsServiceJson) {
        this.generalDetails = (MsdBookingGeneralDetails) getMapFromServiceJson(msdGeneralDetailsServiceJson, MsdBookingGeneralDetails.class);
    }

    public List<MsdAccommodation> getAccommodations() {
        return accommodations;
    }

    /**
     * Fills in the accommodations according to response on rest-call
     *
     * @param msdAccommodationServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setAccommodations(String msdAccommodationServiceJson) {
        this.accommodations = getMapListFromServiceJson(msdAccommodationServiceJson, MsdAccommodation.class);
    }

    public List<MsdTransport> getTransports() {
        return transports;
    }

    /**
     * Fills in the transports according to response on rest-call
     *
     * @param msdTransportServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setTransports(String msdTransportServiceJson) {
        this.transports = getMapListFromServiceJson(msdTransportServiceJson, MsdTransport.class);
    }

    public List<MsdTransfer> getTransfers() {
        return transfers;
    }

    /**
     * Fills in the transfers according to response on rest-call
     *
     * @param msdTransfersServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setTransfers(String msdTransfersServiceJson) {
        this.transfers = getMapListFromServiceJson(msdTransfersServiceJson, MsdTransfer.class);
    }

    public List<MsdExtraService> getExtraServices() {
        return extraServices;
    }

    /**
     * Fills in the extraServices according to response on rest-call
     *
     * @param msdExtraServicesJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setExtraServices(String msdExtraServicesJson) {
        this.extraServices = getMapListFromServiceJson(msdExtraServicesJson, MsdExtraService.class);
    }

    public MsdCustomer getCustomer() {
        return customer;
    }

    /**
     * Fills in the customer according to response on rest-call
     *
     * @param msdCustomerServiceJson {@link String} representation of {@link Response} on rest-call ({@code Response.prettyPrint()})
     */
    public void setCustomer(String msdCustomerServiceJson) {
        this.customer = (MsdCustomer) getMapFromServiceJson(msdCustomerServiceJson, MsdCustomer.class);
    }

    /**
     * Sets details to fields that contains a List of Maps.
     *
     * @param msdServiceJson {@link org.json.JSONArray} in {@link String} format.
     * @param serviceType    A class the jsonMap is expected be mapped to.
     * @return A {@link List} of json Maps.
     */
    private ArrayList getMapListFromServiceJson(String msdServiceJson, Class serviceType) {
        ArrayList<Map> jsonMapsList;
        ArrayList mapList = new ArrayList<>();


        jsonMapsList = (ArrayList<Map>) new JSONObject(msdServiceJson).toMap().get("value");

        jsonMapsList.forEach((Map it) -> {
            assert it instanceof Map;

            Constructor<?> cons = null;
            try {
                cons = serviceType.getConstructor(Map.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                mapList.add(cons.newInstance(it));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });

        return mapList;
    }

    /**
     * Sets details to Map-structured fields.
     *
     * @param jsonObject {@link JSONObject} in String format. Usually {@link Response}.prettyPrint().
     * @param T          A class the jsonMap is expected be mapped to. The class should extend {@link MsdService}.
     * @return Object of a class that implements {@link MsdService}.
     */
    private MsdService getMapFromServiceJson(String jsonObject, Class T) {
        Map jsonObjectMap;

        jsonObjectMap = ((ArrayList<Map>) (new JSONObject(jsonObject)).toMap().get("value")).get(0);
        Constructor<?> constructor = null;

        try {
            constructor = T.getConstructor(Map.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            assert constructor != null;
            return (MsdService) constructor.newInstance(jsonObjectMap);
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("generalDetails", generalDetails)
                .add("accommodations", accommodations)
                .add("transports", transports)
                .add("extraServices", extraServices)
                .add("transfers", transfers)
                .add("customer", customer)
                .toString();
    }

    /**
     * Compares
     *
     * @return
     */
    public boolean assertSameAsOnTourBookingInHolder() {
        ArrayList<Service> onTourTransferServices, onTourTransportServices, onTourAccommodationServices, onTourExtraServices;
        Booking onTourBooking;

        onTourBooking = Holder.get().getOnTourShipment().getBooking().get(0);

        onTourTransferServices = (ArrayList<Service>) onTourBooking.getServicesOfGivenType(Service.TypeId.TRANSFER);
        onTourTransportServices = (ArrayList<Service>) onTourBooking.getServicesOfGivenType(Service.TypeId.TRANSPORT);
        onTourAccommodationServices = (ArrayList<Service>) onTourBooking.getServicesOfGivenType(Service.TypeId.ACCOMMODATION);
        onTourExtraServices = (ArrayList<Service>) onTourBooking.getServicesOfGivenType(Service.TypeId.EXTRAS);

        assertEquals(onTourTransferServices.size(), this.transfers.size());
        assertEquals(onTourTransportServices.size(), this.transports.size());
        assertEquals(onTourAccommodationServices.size(), this.accommodations.size());
        assertEquals(onTourExtraServices.size(), this.extraServices.size());

        this.generalDetails.assertMsdBookingMatchesOnTour(onTourBooking);
        this.customer.assertMsdBookingMatchesOnTour(Holder.get().getCustomer());
        areMsdServicesListEqualToOnTourServicesList(this.transports, onTourTransportServices);
        areMsdServicesListEqualToOnTourServicesList(this.accommodations, onTourAccommodationServices);
        areMsdServicesListEqualToOnTourServicesList(this.transfers, onTourTransferServices);
        areMsdServicesListEqualToOnTourServicesList(this.extraServices, onTourExtraServices);

        return true;
    }

    /**
     * Compares {@link List} of {@link MsdService}s with onTour {@link Booking} List to be equal.
     *
     * @param msdServices    An instance of a class that implements {@link MsdService} interface.
     * @param onTourServices A list of {@link Service}s filtered to belong to one {@link Service.TypeId}
     * @return false if one of services does not match.
     */
    private boolean areMsdServicesListEqualToOnTourServicesList(List<? extends MsdService> msdServices, ArrayList<Service> onTourServices) {
        for (int i = 0; i < msdServices.size(); i++) {
            if (!msdServices.get(i).assertMsdBookingMatchesOnTour(onTourServices.get(i))) {
                LOGGER.error(String.format("Service [%d] are not the same. %s not equals %s",
                        i, msdServices.get(i), onTourServices.get(i)));
                return false;
            }
        }
        return true;
    }
}
