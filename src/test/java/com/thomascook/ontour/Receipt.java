package com.thomascook.ontour;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by omm on 7/26/2017.
 */
public class Receipt{
    private String remark;
    private String receipt;
    private String route_change_code;

    public String getRemark() {
        return remark;
    }

    @XmlElement(name="REMARK")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReceipt() {
        return receipt;
    }

    @XmlElement(name="RECEIPT")
    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getRoute_change_code() {
        return route_change_code;
    }

    @XmlElement(name="ROUTE_CHANGE_CODE")
    public void setRoute_change_code(String route_change_code) {
        this.route_change_code = route_change_code;
    }
}
