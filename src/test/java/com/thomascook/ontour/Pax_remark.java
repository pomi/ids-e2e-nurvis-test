package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

public class Pax_remark {
    private String type;
    private String text;

    public Pax_remark(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public Pax_remark() {
    }

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
