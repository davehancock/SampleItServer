package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MetadataDAO {

    void persistMetadataForMACAddress(String macAddress, MetricMetadata metricMetadata);

    MetricMetadata readMetadataForMACAddress(String macAddress);

}
