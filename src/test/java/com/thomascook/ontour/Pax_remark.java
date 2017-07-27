package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

public class Pax_remark{
    private String type;
    private String text;

    @XmlElement(name="TYPE")
    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="TEXT")
    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }
}
