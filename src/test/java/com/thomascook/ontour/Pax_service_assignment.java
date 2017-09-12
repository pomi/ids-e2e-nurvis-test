package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by omm on 7/26/2017.
 */
public class Pax_service_assignment {
    private int pax_identifier;

    public int getPax_identifier() {
        return pax_identifier;
    }

    @XmlElement(name = "PAX_IDENTIFIER")
    public void setPax_identifier(int pax_identifier) {
        this.pax_identifier = pax_identifier;
    }
}
