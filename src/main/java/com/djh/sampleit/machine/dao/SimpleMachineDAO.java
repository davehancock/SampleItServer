package com.djh.sampleit.machine.dao;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hancock
 */
public class SimpleMachineDAO implements MachineDAO {

    // A Mapping for Machine Alias, keeping MAC Address as the natural key and a user defined alias as the value.
    private BiMap<String, String> machineAliasMap = Maps.synchronizedBiMap(HashBiMap.<String, String>create());

    @Override
    public void updateMachineAliasMapping(String currentMachineAlias, String newMachineAlias) {

        // If no alias exists then create it
        if (!machineAliasMap.inverse().containsKey(currentMachineAlias)) {
            machineAliasMap.put(currentMachineAlias, newMachineAlias);

            // Otherwise update the existing alias with the new value
        } else {
            String macAddress = machineAliasMap.inverse().get(currentMachineAlias);
            machineAliasMap.put(macAddress, newMachineAlias);
        }
    }

    @Override
    public List<String> readAllMachineAliases() {
        return new ArrayList<>(machineAliasMap.values());
    }

    // TODO Candidates for moving up to the service
    @Override
    public String readMACAddressForMachineAlias(String machineAlias) {
        return machineAliasMap.inverse().get(machineAlias);
    }

    // TODO Candidates for moving up to the service
    @Override
    public String readMachineAliasForMACAddress(String macAddress) {
        return machineAliasMap.get(macAddress);
    }

}
