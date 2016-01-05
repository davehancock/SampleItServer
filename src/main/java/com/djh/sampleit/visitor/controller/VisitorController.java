package com.djh.sampleit.visitor.controller;

import com.djh.sampleit.visitor.dao.SimpleVisitorDAO;
import com.djh.sampleit.visitor.model.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author David Hancock
 */
@RestController
public class VisitorController {

    @Autowired
    private SimpleVisitorDAO simpleVisitorDAO;

    @RequestMapping(value = "visitors", method = RequestMethod.GET)
    public List<Visitor> getVisitors(){
        return simpleVisitorDAO.readAllVisitors();
    }

}
