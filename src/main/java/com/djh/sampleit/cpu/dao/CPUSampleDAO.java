package com.djh.sampleit.cpu.dao;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.cpu.model.CPUSampleSet;

import java.util.List;

/**
 * @author David Hancock
 */
public interface CPUSampleDAO {

    void persistCPUSample(String hostname, CPUSample cpuSample);

    List<CPUSample> readAllCPUSamplesForHostname(String hostname);

    List<String> readAllHostsWithCPUMetrics();

}
