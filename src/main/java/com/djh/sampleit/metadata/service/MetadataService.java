package com.djh.sampleit.metadata.service;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MetadataService {

    void saveMetadata(MetricMetadata metricMetadata);

    List<String> retrieveHosts();

    MetricMetadata retrieveMetadataForHost(String hostname);

}
