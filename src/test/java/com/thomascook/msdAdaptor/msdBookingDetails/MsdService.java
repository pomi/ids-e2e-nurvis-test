package com.thomascook.msdAdaptor.msdBookingDetails;

import com.thomascook.ontour.Pax;
import com.thomascook.ontour.Pax_remark;
import com.thomascook.ontour.Pax_service;
import com.thomascook.ontour.Service;
import org.junit.Assert;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.hasItem;

abstract class MsdService {

    static final DateTimeFormatter ONTOUR_DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");
    static final DateTimeFormatter ONTOUR_TIME_FORMATTER = DateTimeFormatter.ofPattern("HHmm");
    static final DateTimeFormatter MSD_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    static final Map<String, String> STATE_MAP = new HashMap<String, String>() {{
        put("A", "Active");
        put("C", "Cancelled");
    }};
    static final Map<String, String> TRANSFER_TYPES_MAP = new HashMap<String, String>() {{
        put("IN", "Inbound");
        put("OUT", "Outbound");
    }};

    abstract boolean assertMsdBookingMatchesOnTour(Service onTourService);

    /**
     * Parses {@link List<Pax>} to {@link List<MsdPax>}
     *
     * @param onTourPaxList {@link List<Pax>} representation of PAX list
     * @return PAX list in {@link MsdPax} format.
     */
    List<MsdPax> parseOnTourPaxListToMsdPaxList(List<Pax> onTourPaxList) {
        List<MsdPax> msdPaxList = new ArrayList<>();
        onTourPaxList.forEach(onTourPax -> msdPaxList.add(new MsdPax(onTourPax)));

        return msdPaxList;
    }

    /**
     * Parses PAX list in string format separated by new line character,
     * parses remarks represented in the same way and merges them to {@link MsdPax} object.
     *
     * @param msdPax       {@link String} where passengers separated with {@code "\r\n"} and elements of each are comma separated.
     * @param msdPaxRemark {@link String} where remarks separated with {@code "\r\n"} and elements of each are comma separated.
     * @return List<MsdPax> with passengers and remarks merged.
     */
    protected List<MsdPax> getPaxList(String msdPax, String msdPaxRemark) {
        List<MsdPax> paxList = new ArrayList<>();

        String[] paxSeparatedByPerson = msdPax.split("\\r\\n");
        Arrays.stream(paxSeparatedByPerson).forEach(it -> paxList.add(new MsdPax(it, null)));

        if (null != msdPaxRemark && !msdPaxRemark.equals("null")) {
            String[] remarkSeparatedByPerson = msdPaxRemark.split("\\r\\n");
            if (remarkSeparatedByPerson.length == 1) {
                remarkSeparatedByPerson = msdPaxRemark.split("\\n");
            }

            Arrays.stream(remarkSeparatedByPerson).forEach(remark -> {
                String[] remarkCommaSeparated = remark.split(",");
                assert remarkCommaSeparated.length == 3 :
                        String.format("PAX remark %s has incompatible quantity of elements. There should be 3 of them: identifier, type and text",
                                remark);
                paxList.forEach(onePax -> {
                    if (onePax.getIdentifier().equals(remarkCommaSeparated[0])) {
                        onePax.setPaxRemark(new Pax_remark(remarkCommaSeparated[1], remarkCommaSeparated[2]));
                    }
                });
            });

            for (int i = 0; i < paxSeparatedByPerson.length; i++) {
                paxList.add(new MsdPax(paxSeparatedByPerson[i], remarkSeparatedByPerson[i]));
            }
        }

        return paxList;
    }

    /**
     * Parses PAX list in string format separated by new line character,
     *
     * @param msdPax {@link String} where passengers separated with {@code "\r\n"} and elements of each are comma separated.
     * @return List<MsdPax> with passengers.
     */
    protected List<MsdPax> getPaxList(String msdPax) {
        return getPaxList(msdPax, null);
    }

    public void assertMsdAndOnTourPaxAssignments(List<Pax_service> onTourAssignments, List<MsdPax> msdPaxList) {
        List<String> msdIdentifiersList, onTourIdentifiersList;

        onTourIdentifiersList = onTourAssignments
                .stream()
                .map(it -> String.valueOf(it.getPax_service_assignment().get(0).getPax_identifier()))
                .collect(Collectors.toList());
        msdIdentifiersList = msdPaxList
                .stream()
                .map(MsdPax::getIdentifier)
                .collect(Collectors.toList());

        Assert.assertEquals(onTourIdentifiersList, msdIdentifiersList);

        onTourIdentifiersList
                .forEach(onTourIdentifier ->
                        Assert.assertThat(msdIdentifiersList, hasItem(onTourIdentifier)));
    }
}
