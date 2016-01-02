package com.djh.sampleit.metadata.controller;

import com.djh.sampleit.metadata.MetricMetadata;
import com.djh.sampleit.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Hancock
 */
@RestController
public class MetadataController {

    @Autowired
    private MetadataService metadataService;

    @CrossOrigin
    @RequestMapping(value = "metadata/{machineAlias}", method = RequestMethod.GET)
    public MetricMetadata getMetadata(@PathVariable String machineAlias) {
        return metadataService.retrieveMetadataForMachine(machineAlias);
    }

    // TODO Candidate for moving to Machine Controller
    @CrossOrigin
    @RequestMapping(value = "metadata/{currentMachineAlias}/{newMachineAlias}/", method = RequestMethod.POST)
    public String updateMetadataAlias(@PathVariable String currentMachineAlias,
                                      @PathVariable String newMachineAlias) {

        metadataService.updateMachineAliasMapping(currentMachineAlias, newMachineAlias);
        return newMachineAlias;
    }

    //  TODO Candidate for moving to Machine Controller
    @CrossOrigin
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public List<String> getMachineAliases() {
        return metadataService.retrieveMachineAliases();
    }

}
