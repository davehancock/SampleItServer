package com.djh.sampleit.metadata.dao;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MetadataDAO {

    void persistMetadataForHost(MetricMetadata metricMetadata);

    MetricMetadata readMetadataForHost(String hostname);

    List<String> readAllHosts();

}
