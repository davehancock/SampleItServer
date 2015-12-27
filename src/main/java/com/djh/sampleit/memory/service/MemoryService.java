package com.djh.sampleit.memory.service;

import com.djh.sampleit.memory.model.MemoryMetric;
import com.djh.sampleit.memory.model.MemorySample;

import java.util.List;

/**
 * @author David Hancock
 */
public interface MemoryService {

    void saveMemoryMetric(MemoryMetric memoryMetric);

    List<MemorySample> retrieveMemorySamplesForHostname(String hostname);

}
