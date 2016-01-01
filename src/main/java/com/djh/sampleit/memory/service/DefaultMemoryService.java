package com.djh.sampleit.memory.service;

import com.djh.sampleit.memory.dao.MemoryDAO;
import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;
import com.djh.sampleit.metadata.MetricMetadata;
import com.djh.sampleit.metadata.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultMemoryService implements MemoryService {

    @Autowired
    private MemoryDAO memoryDAO;

    // TODO AOP Metadata cross cutting concern
    @Autowired
    private MetadataService metadataService;

    @Override
    public void saveMemoryMetric(MemoryMetric memoryMetric) {

        // TODO AOP Metadata cross cutting concern
        metadataService.saveMetadata(memoryMetric.getMetricMetadata());

        MetricMetadata metricMetadata = memoryMetric.getMetricMetadata();
        MemorySample memorySample = new MemorySample(memoryMetric.getTotalMemory(), memoryMetric.getTotalAvailableMemory());

        memoryDAO.persistMemoryMetric(metricMetadata.getMacAddress(), memorySample);
    }

    @Override
    public List<MemorySample> retrieveMemorySamplesForMACAddress(String macAddress) {
        return memoryDAO.readAllMemorySamplesForMACAddress(macAddress);
    }

}
