package com.djh.sampleit.cpu.service;

import com.djh.sampleit.cpu.controller.model.CPUMetric;
import com.djh.sampleit.cpu.controller.model.CPUSampleSet;

import java.util.List;

/**
 * @author David Hancock
 */
public interface CPUService {

    void saveCPUMetric(CPUMetric cpuMetric);

    CPUSampleSet retrieveCPUSampleSet(String hostname);

    List<CPUSampleSet> retrieveAllCPUSampleSets();

    List<CPUSampleSet> retrieveLatestCPUSampleSets();

}
