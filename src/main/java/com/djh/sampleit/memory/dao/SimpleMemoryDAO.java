package com.djh.sampleit.memory.dao;

import com.djh.sampleit.memory.model.MemorySample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleMemoryDAO implements MemoryDAO {

    private Map<String, List<MemorySample>> memoryMetricMap = new ConcurrentHashMap<>();

    @Override
    public void persistMemoryMetric(String macAddress, MemorySample memorySample) {

        if (memoryMetricMap.containsKey(macAddress)) {
            memoryMetricMap.get(macAddress).add(memorySample);
        } else {
            List<MemorySample> memorySamples = new ArrayList<>();
            memorySamples.add(memorySample);
            memoryMetricMap.put(macAddress, memorySamples);
        }
    }

    // TODO Throws null pointer on empty list
    @Override
    public List<MemorySample> readAllMemorySamplesForMACAddress(String macAddress) {
        return new ArrayList<>(memoryMetricMap.get(macAddress));
    }

}
