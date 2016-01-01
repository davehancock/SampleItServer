package com.djh.sampleit.memory.dao;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MemoryDAO {

    void persistMemoryMetric(String macAddress, MemorySample memorySample);

    List<MemorySample> readAllMemorySamplesForMACAddress(String macAddress);

}
