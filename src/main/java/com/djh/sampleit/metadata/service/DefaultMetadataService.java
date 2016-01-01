package com.djh.sampleit.metadata.service;

import com.djh.sampleit.cpu.dao.CPUSampleDAO;
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
        metadataDAO.persistMetadataForHost(metricMetadata);
    }

    @Override
    public List<String> retrieveHosts() {
        return metadataDAO.readAllHosts();
    }

    @Override
    public MetricMetadata retrieveMetadataForHost(String hostname) {
        return metadataDAO.readMetadataForHost(hostname);
    }

}
