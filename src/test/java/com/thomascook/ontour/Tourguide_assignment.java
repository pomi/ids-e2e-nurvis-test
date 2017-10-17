package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by omm on 7/26/2017.
 */
class Tourguide_assignment {
    private List<Tourguide> tourguide;
    private List<Brands> brands;

    public List<Tourguide> getTourguide() {
        return tourguide;
    }

    @XmlElement(name = "TOURGUIDE")
    public void setTourguide(List<Tourguide> tourguide) {
        this.tourguide = tourguide;
    }

    public List<Brands> getBrands() {
        return brands;
    }

    @XmlElement(name = "BRANDS")
    public void setBrands(List<Brands> brands) {
        this.brands = brands;
    }
}
