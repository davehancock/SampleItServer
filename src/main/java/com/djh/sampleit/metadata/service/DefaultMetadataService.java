package com.djh.sampleit.metadata.service;

import com.djh.sampleit.machine.dao.MachineDAO;
import com.djh.sampleit.metadata.MetricMetadata;
import com.djh.sampleit.metadata.dao.MetadataDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultMetadataService implements MetadataService {

    @Autowired
    private MachineDAO machineDAO;

    @Autowired
    private MetadataDAO metadataDAO;

    @Override
    public void saveMetadata(MetricMetadata metricMetadata) {

        String macAddress = metricMetadata.getMacAddress();
        metadataDAO.persistMetadataForMACAddress(macAddress, metricMetadata);

        // TODO This may have to be moved to a more sensible place
        if(machineDAO.readMachineAliasForMACAddress(macAddress) == null){
            machineDAO.updateMachineAliasMapping(macAddress, macAddress);
        }
    }

    @Override
    public MetricMetadata retrieveMetadataForMachine(String machineAlias) {
        String macAddress = machineDAO.readMACAddressForMachineAlias(machineAlias);
        return metadataDAO.readMetadataForMACAddress(macAddress);
    }

    // TODO Candidate for pulling into a specific MachineAlias service
    @Override
    public void updateMachineAliasMapping(String macAddress, String newMachineAlias) {
        machineDAO.updateMachineAliasMapping(macAddress, newMachineAlias);
    }

    // TODO Candidate for pulling into a specific MachineAlias service
    @Override
    public List<String> retrieveMachineAliases() {
        return machineDAO.readAllMachineAliases();
    }

}
