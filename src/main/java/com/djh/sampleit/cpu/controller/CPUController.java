package com.djh.sampleit.cpu.controller;

import com.djh.sampleit.cpu.controller.model.CPUCore;
import com.djh.sampleit.cpu.controller.model.CPUMetric;
import com.djh.sampleit.cpu.controller.model.CPUSample;
import com.djh.sampleit.cpu.controller.model.CPUSampleSet;
import com.djh.sampleit.cpu.service.CPUService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hancock
 */
@RestController
public class CPUController {

    private static final Logger LOG = LoggerFactory.getLogger(CPUController.class);

    @Autowired
    private CPUService cpuService;

    @RequestMapping(value = "cpu", method = RequestMethod.POST)
    public void cpuMetric(@RequestBody CPUMetric cpuMetric) {

        LOG.info("Received metric: " + cpuMetric.toString());
        cpuService.saveCPUMetric(cpuMetric);
    }

    @CrossOrigin
    @RequestMapping(value = "cpus", method = RequestMethod.GET)
    public List<CPUSampleSet> cpuSampleSet() {
        return cpuService.retrieveLatestCPUSampleSets();
    }

    @CrossOrigin
    @RequestMapping(value = "cpu/overlay", method = RequestMethod.GET)
    public List<List<Double>> cpuOverlay() {

        List<List<Double>> cpuStats = new ArrayList<>();

        // TODO Move this logic down into the service maybe
        List<CPUSampleSet> cpuSampleSets = cpuService.retrieveLatestCPUSampleSets();

        if (!cpuSampleSets.isEmpty()) {

            int numberOfCores = cpuSampleSets.get(0).getCpuSamples().get(0).getCpuCores().size();

            for (int i = 0; i < numberOfCores; i++) {
                cpuStats.add(new ArrayList<>());
            }

            List<CPUSample> cpuSamples = cpuSampleSets.get(0).getCpuSamples();

            for (CPUSample cpuSample : cpuSamples) {
                List<CPUCore> cpuCores = cpuSample.getCpuCores();

                for (int i = 0; i < numberOfCores; i++) {
                    cpuStats.get(i).add(cpuCores.get(i).getCpuClockSpeed());
                }
            }
        }

        return cpuStats;
    }

    @CrossOrigin
    @RequestMapping(value = "cpu/{hostname}", method = RequestMethod.GET)
    public CPUSampleSet cpuSampleSets(@PathVariable("hostname") String hostname) {
        return cpuService.retrieveCPUSampleSet(hostname);
    }

}
