package com.djh.sampleit.memory.dao;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MemoryDAO {

    void persistMemoryMetric(String hostname, MemorySample memorySample);

    List<MemorySample> readAllMemorySamplesForHostname(String hostname);

    List<String> readAllHostsWithCPUSamples();

}
