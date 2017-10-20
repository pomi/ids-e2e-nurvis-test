package com.thomascook.msdAdaptor.msdBookingDetails;

import com.thomascook.ontour.Pax;
import com.thomascook.ontour.Pax_remark;

import java.util.*;

public class MsdPax {
    private static final HashMap<String, String> SEX_MAP = new HashMap<String, String>() {{
        put("Male", "M");
        put("Female", "F");
        put("NotSpecified", "");
    }};

    //region Fields
    private String name;
    private String surename;
    private String age;
    private String sex;
    private String justMarried;
    private String identifier;
    private String language;
    private String birthDate;
    private List<Pax_remark> paxRemark;
    //endregion

    public MsdPax(Pax onTourPax) {
        this.name = onTourPax.getName();
        this.surename = onTourPax.getSurname();
        this.age = String.valueOf(onTourPax.getAge());
        this.sex = onTourPax.getSex();
        this.justMarried = onTourPax.getJust_married();
        this.identifier = String.valueOf(onTourPax.getIdentifier());
        this.language = onTourPax.getLanguage();
        this.birthDate = onTourPax.getBirth_date();
        this.paxRemark = onTourPax.getPax_remark();
    }

    /**
     * Creates {@link MsdPax} basing on msdResponse.tc_participants, msdResponse.tc_participantremarks
     *
     * @param paxSeparatedByPerson msdResponse.tc_participants
     * @param msdPaxRemark         msdResponse.tc_participantremarks
     */
    public MsdPax(String paxSeparatedByPerson, String msdPaxRemark) {
        String[] separatedByProperties = paxSeparatedByPerson.split(",");
        this.identifier = separatedByProperties[0];
        this.name = separatedByProperties[1];
        this.surename = separatedByProperties[2];
        this.age = separatedByProperties[3];
        this.sex = SEX_MAP.get(separatedByProperties[4]);
        if (separatedByProperties.length > 6) {
            this.language = separatedByProperties[6];
        }

        if (null != msdPaxRemark && !msdPaxRemark.equals("null")) {
            setPaxRemark(msdPaxRemark);
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setPaxRemark(Pax_remark paxRemark) {
        this.paxRemark = new ArrayList<>(Collections.singletonList(paxRemark));
    }

    public void setPaxRemark(String msdPaxRemark) {
        paxRemark = new ArrayList<>();
        String[] remarkSeparatedByItem = msdPaxRemark.split(",\\r\\n");
        if (remarkSeparatedByItem.length == 1) {
            remarkSeparatedByItem = msdPaxRemark.split("\\n");
        }

        Arrays.stream(remarkSeparatedByItem).forEach(it -> {
            String[] oneRemarkSeparatedByComma = it.split(",");
            Pax_remark oneRemark = new Pax_remark();
            oneRemark.setType(oneRemarkSeparatedByComma[1]);
            oneRemark.setText(oneRemarkSeparatedByComma[2]);
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MsdPax msdPax = (MsdPax) o;

        if (name != null ? !name.equals(msdPax.name) : msdPax.name != null) return false;
        if (surename != null ? !surename.equals(msdPax.surename) : msdPax.surename != null) return false;
        if (age != null ? !age.equals(msdPax.age) : msdPax.age != null) return false;
        if (sex != null ? !sex.equals(msdPax.sex) : msdPax.sex != null) return false;
        if (justMarried != null ? !justMarried.equals(msdPax.justMarried) : msdPax.justMarried != null) return false;
        if (identifier != null ? !identifier.equals(msdPax.identifier) : msdPax.identifier != null) return false;
        if (language != null ? !language.equals(msdPax.language) : msdPax.language != null) return false;
        if (birthDate != null ? !birthDate.equals(msdPax.birthDate) : msdPax.birthDate != null) return false;
        return paxRemark != null ? paxRemark.equals(msdPax.paxRemark) : msdPax.paxRemark == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surename != null ? surename.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (justMarried != null ? justMarried.hashCode() : 0);
        result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (paxRemark != null ? paxRemark.hashCode() : 0);
        return result;
    }
}
