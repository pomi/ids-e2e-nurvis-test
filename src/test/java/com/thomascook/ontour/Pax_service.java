package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class Pax_service {
    private List<Pax_service_assignment> pax_service_assignment;

    public List<Pax_service_assignment> getPax_service_assignment() {
        return pax_service_assignment;
    }

    @XmlElement(name = "PAX_SERVICE_ASIGNMENT")
    public void setPax_service_assignment(List<Pax_service_assignment> pax_service_assignment) {
        this.pax_service_assignment = pax_service_assignment;
    }
}
