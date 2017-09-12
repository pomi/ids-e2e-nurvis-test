package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

class Environment_criteria {
    private String environment_criteria;

    public String getEnvironment_criteria() {
        return environment_criteria;
    }

    @XmlElement(name = "ENVIRONMENT_CRITERIA")
    public void setEnvironment_criteria(String environment_criteria) {
        this.environment_criteria = environment_criteria;
    }
}
