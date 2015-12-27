package com.djh.sampleit.cpu.service;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.cpu.model.CPUSampleSet;
import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import com.djh.sampleit.cpu.controller.model.CPUMetric;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultCPUService implements CPUService {

    @Autowired
    private CPUSampleDAO cpuSampleDAO;

    @Override
    public void saveCPUMetric(CPUMetric cpuMetric) {

        // TODO Do Transform here from Metric > Sample
        CPUSample cpuSample = new CPUSample();
        cpuSample.setCpuCores(cpuMetric.getCpuCores());
        cpuSample.setTimestamp(cpuMetric.getMetricMetadata().getDate());

        String hostname = cpuMetric.getMetricMetadata().getHostname();
        cpuSampleDAO.persistCPUSample(hostname, cpuSample);
    }

    @Override
    public List<CPUSample> retrieveCPUSampleSetsForHostname(String hostname) {
        return cpuSampleDAO.readAllCPUSamplesForHostname(hostname);
    }

}
