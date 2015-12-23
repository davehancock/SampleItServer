package com.djh.sampleit.host.controller;

import com.djh.sampleit.cpu.controller.model.CPUSampleSet;
import com.djh.sampleit.host.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Hancock
 */
@RestController
public class HostController {

    @Autowired
    private HostService hostService;

    @CrossOrigin
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public List<String> hosts() {
        return hostService.retrieveHosts();
    }

}
