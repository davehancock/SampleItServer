package com.djh.sampleit.metadata.service;

import com.djh.sampleit.metadata.MetricMetadata;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MetadataService {

    void saveMetadata(MetricMetadata metricMetadata);

    MetricMetadata retrieveMetadataForMachine(String machineAlias);

    void updateMachineAliasMapping(String currentMachineAlias, String newMachineAlias);

    List<String> retrieveMachineAliases();

}
