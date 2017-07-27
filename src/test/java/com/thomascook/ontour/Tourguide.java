package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by omm on 7/26/2017.
 */
public class Tourguide{
    private int businesspartner_no;
    private String tourguide;

    @XmlElement(name="BUSINESSPARTNER_NO")
    public void setBusinesspartner_no(int businesspartner_no) {
        this.businesspartner_no = businesspartner_no;
    }

    @XmlElement(name="TOURGUIDE")
    public void setTourguide(String tourguide) {
        this.tourguide = tourguide;
    }

    public int getBusinesspartner_no() {
        return businesspartner_no;
    }

    public String getTourguide() {
        return tourguide;
    }
}
