package com.djh.sampleit.memory.controller;

import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;
import com.djh.sampleit.memory.service.MemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author David Hancock
 */
@RestController
public class MemoryController {

    private static final Logger LOG = LoggerFactory.getLogger(MemoryController.class);

    @Autowired
    public MemoryService memoryService;

    @RequestMapping(value = "memory", method = RequestMethod.POST)
    public void memoryMetric(@RequestBody MemoryMetric memoryMetric) {

        LOG.info("Received Memory Metric: " + memoryMetric.toString());
        memoryService.saveMemoryMetric(memoryMetric);
    }

    @CrossOrigin
    @RequestMapping(value = "memory/sample/{hostname}", method = RequestMethod.GET)
    public MemorySample cpuOverlayForHost(@PathVariable String hostname) {

        List<MemorySample> memorySamples = memoryService.retrieveMemorySamplesForHostname(hostname);
        return memorySamples.get(memorySamples.size() - 1);
    }

    @CrossOrigin
    @RequestMapping(value = "memory/samples/{hostname}/{numberOfPoints}", method = RequestMethod.GET)
    public List<MemorySample> cpuOverlayForHost(@PathVariable String hostname, @PathVariable int numberOfPoints) {

        List<MemorySample> memorySamples = memoryService.retrieveMemorySamplesForHostname(hostname);
        return memorySamples.subList(memorySamples.size() - numberOfPoints, memorySamples.size());
    }

}
