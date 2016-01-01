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
    @RequestMapping(value = "hosts", method = RequestMethod.GET)
    public List<String> hosts() {
        return metadataService.retrieveHosts();
    }

    @CrossOrigin
    @RequestMapping(value = "metadata/{macAddress}", method = RequestMethod.GET)
    public MetricMetadata hosts(@PathVariable String macAddress) {
        return metadataService.retrieveMetadataForMACAddress(macAddress);
    }

}
