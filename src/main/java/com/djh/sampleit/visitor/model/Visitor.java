package com.djh.sampleit.visitor.model;

import java.util.Date;

/**
 * @author David Hancock
 */
public class Visitor {

    private Date visitDate;

    private String visitorIP;

    public Visitor() {
    }

    public Visitor(Date visitDate, String visitorIP) {
        this.visitDate = visitDate;
        this.visitorIP = visitorIP;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public String getVisitorIP() {
        return visitorIP;
    }

}
