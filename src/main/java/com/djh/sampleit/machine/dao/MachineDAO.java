package com.djh.sampleit.machine.dao;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MachineDAO {

    void updateMachineAliasMapping(String currentMachineAlias, String newMachineAlias);

    String readMACAddressForMachineAlias(String machineAlias);

    String readMachineAliasForMACAddress(String macAddress);

    List<String> readAllMachineAliases();

}
