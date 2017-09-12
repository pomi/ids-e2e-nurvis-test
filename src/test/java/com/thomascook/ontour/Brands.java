package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

class Brands {
    private String brand;

    public String getBrand() {
        return brand;
    }

    @XmlElement(name = "BRAND")
    public void setBrand(String brand) {
        this.brand = brand;
    }
}
