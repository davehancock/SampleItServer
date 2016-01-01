package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.metadata.MetricMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleMetadataDAO implements MetadataDAO {

    // TODO For now the key is hostname.
    // TODO It may make more sense on something unique and consistent, MAC Address? or generated composite key?
    private Map<String, MetricMetadata> metadataMap = new ConcurrentHashMap<>();

    @Override
    public void persistMetadataForHost(MetricMetadata metricMetadata) {

        String hostname = metricMetadata.getHostname();
        metadataMap.put(hostname, metricMetadata);
    }

    @Override
    public MetricMetadata readMetadataForHost(String hostname) {
        return metadataMap.get(hostname);
    }

    @Override
    public List<String> readAllHosts() {
        return new ArrayList<>(metadataMap.keySet());
    }

}
