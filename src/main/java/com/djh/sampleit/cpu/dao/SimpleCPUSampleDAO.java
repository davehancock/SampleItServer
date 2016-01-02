package com.djh.sampleit.cpu.dao;

import com.djh.sampleit.cpu.model.CPUSample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleCPUSampleDAO implements CPUSampleDAO {

    // This is always keyed by the unique and consistent MAC Address
    private Map<String, List<CPUSample>> cpuSampleMap = new ConcurrentHashMap<>();

    // TODO persist as sampleSet instead? Or Rather Lists of CPUSamples per host...
    @Override
    public void persistCPUSample(String macAddress, CPUSample cpuSample) {

        if (cpuSampleMap.containsKey(macAddress)) {
            cpuSampleMap.get(macAddress).add(cpuSample);
        } else {
            List<CPUSample> cpuSamples = new ArrayList<>();
            cpuSamples.add(cpuSample);
            cpuSampleMap.put(macAddress, cpuSamples);
        }
    }

    // TODO Throws null pointer on empty list
    @Override
    public List<CPUSample> readAllCPUSamplesForMACAddress(String macAddress) {
        return new ArrayList<>(cpuSampleMap.get(macAddress));
    }

}
