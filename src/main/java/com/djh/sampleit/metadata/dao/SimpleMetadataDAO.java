package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleMetadataDAO implements MetadataDAO {

    // This is always keyed by the unique and consistent MAC Address
    private Map<String, MetricMetadata> metadataMap = new ConcurrentHashMap<>();

    @Override
    public void persistMetadataForMACAddress(String macAddress, MetricMetadata metricMetadata) {
        metadataMap.put(macAddress, metricMetadata);
    }

    @Override
    public MetricMetadata readMetadataForMACAddress(String macAddress) {
        return metadataMap.get(macAddress);
    }

}
