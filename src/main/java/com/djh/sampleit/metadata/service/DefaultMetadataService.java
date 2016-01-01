package com.djh.sampleit.metadata.service;

import com.djh.sampleit.metadata.MetricMetadata;
import com.djh.sampleit.metadata.dao.MetadataDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultMetadataService implements MetadataService {

    @Autowired
    private MetadataDAO metadataDAO;

    @Override
    public void saveMetadata(MetricMetadata metricMetadata) {
        metadataDAO.persistMetadataForMACAddress(metricMetadata);
    }

    @Override
    public List<String> retrieveHosts() {
        return metadataDAO.readAllHosts();
    }

    @Override
    public MetricMetadata retrieveMetadataForMACAddress(String macAddress) {
        return metadataDAO.readMetadataForHost(macAddress);
    }

}
