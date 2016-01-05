package com.djh.sampleit.visitor.dao;

import com.djh.sampleit.visitor.model.Visitor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleVisitorDAO {

    private Map<String, Date> visitorMap = new ConcurrentHashMap<>();

    public void addVisitor(String visitorIPAddress) {
        visitorMap.put(visitorIPAddress, new Date());
    }

    public List<Visitor> readAllVisitors() {

        List<Visitor> visitors = new ArrayList<>();

        for (Map.Entry<String, Date> entry : visitorMap.entrySet()) {
            visitors.add(new Visitor(entry.getValue(), entry.getKey()));
        }

        return visitors;
    }

}
