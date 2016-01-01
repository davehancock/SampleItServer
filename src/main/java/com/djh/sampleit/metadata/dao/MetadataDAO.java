package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MetadataDAO {

    void persistMetadataForMACAddress(MetricMetadata metricMetadata);

    MetricMetadata readMetadataForHost(String macAddress);

    List<String> readAllHosts();

}
