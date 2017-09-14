package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

class Booking_remark {
    private String type;
    private String text;

    public String getType() {
        return type;
    }

    @XmlElement(name = "TYPE")
    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    @XmlElement(name = "TEXT")
    public void setText(String text) {
        this.text = text;
    }
}
