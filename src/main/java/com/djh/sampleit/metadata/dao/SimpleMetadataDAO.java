package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleMetadataDAO implements MetadataDAO {

    // TODO For now the key is macAddress.
    // TODO It may make more sense on something unique and consistent, MAC Address? or generated composite key?
    private Map<String, MetricMetadata> metadataMap = new ConcurrentHashMap<>();

    @Override
    public void persistMetadataForMACAddress(MetricMetadata metricMetadata) {

        String macAddress = metricMetadata.getMacAddress();
        metadataMap.put(macAddress, metricMetadata);
    }

    @Override
    public MetricMetadata readMetadataForHost(String macAddress) {
        return metadataMap.get(macAddress);
    }

    @Override
    public List<String> readAllHosts() {
        return new ArrayList<>(metadataMap.keySet());
    }

}
