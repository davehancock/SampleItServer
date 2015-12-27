package com.djh.sampleit.memory.service;

import com.djh.sampleit.memory.dao.MemoryDAO;
import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;
import com.djh.sampleit.metadata.MetricMetadata;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultMemoryService implements MemoryService {

    @Autowired
    private MemoryDAO memoryDAO;

    @Override
    public void saveMemoryMetric(MemoryMetric memoryMetric) {

        MetricMetadata metricMetadata = memoryMetric.getMetricMetadata();
        MemorySample memorySample = new MemorySample(memoryMetric.getTotalMemory(), memoryMetric.getTotalAvailableMemory());

        memoryDAO.persistMemoryMetric(metricMetadata.getHostname(), memorySample);
    }

    @Override
    public List<MemorySample> retrieveMemorySamplesForHostname(String hostname) {
        return memoryDAO.readAllMemorySamplesForHostname(hostname);
    }

}
