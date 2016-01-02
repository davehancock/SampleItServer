package com.djh.sampleit.memory.controller;

import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;
import com.djh.sampleit.memory.service.MemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    public void postMemoryMetric(@RequestBody MemoryMetric memoryMetric, HttpServletRequest httpServletRequest) {

        // TODO AOP this maybe.
        String originIPAddress = httpServletRequest.getRemoteAddr();
        memoryMetric.getMetricMetadata().setOriginPublicIPAddress(originIPAddress);

        LOG.info("Received Memory Metric: " + memoryMetric.toString());
        memoryService.saveMemoryMetric(memoryMetric);
    }

    @CrossOrigin
    @RequestMapping(value = "memory/sample/{machineAlias}", method = RequestMethod.GET)
    public MemorySample getCpuOverlayForMachine(@PathVariable String machineAlias) {

        List<MemorySample> memorySamples = memoryService.retrieveMemorySamplesForMachine(machineAlias);
        return memorySamples.get(memorySamples.size() - 1);
    }

    @CrossOrigin
    @RequestMapping(value = "memory/samples/{machineAlias}/{numberOfPoints}", method = RequestMethod.GET)
    public List<MemorySample> getCpuOverlayForMachine(@PathVariable String machineAlias, @PathVariable int numberOfPoints) {

        List<MemorySample> memorySamples = memoryService.retrieveMemorySamplesForMachine(machineAlias);
        return memorySamples.subList(memorySamples.size() - numberOfPoints, memorySamples.size());
    }

}
