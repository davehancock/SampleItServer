package com.djh.sampleit.cpu.service;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.cpu.model.CPUSampleSet;
import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import com.djh.sampleit.cpu.controller.model.CPUMetric;
import com.djh.sampleit.metadata.MetricMetadata;
import com.djh.sampleit.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultCPUService implements CPUService {

    @Autowired
    private CPUSampleDAO cpuSampleDAO;

    // TODO AOP Metadata cross cutting concern
    @Autowired
    private MetadataService metadataService;

    @Override
    public void saveCPUMetric(CPUMetric cpuMetric) {

        // TODO AOP Metadata cross cutting concern
        metadataService.saveMetadata(cpuMetric.getMetricMetadata());

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
