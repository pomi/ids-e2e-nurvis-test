package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by omm on 7/26/2017.
 */
public class Service_remark{
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
