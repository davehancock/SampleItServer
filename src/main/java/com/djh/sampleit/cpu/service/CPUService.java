package com.djh.sampleit.cpu.service;

import com.djh.sampleit.cpu.controller.model.CPUMetric;
import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.cpu.model.CPUSampleSet;

import java.util.List;

/**
 * @author David Hancock
 */
public interface CPUService {

    void saveCPUMetric(CPUMetric cpuMetric);

    List<CPUSample> retrieveCPUSampleSetsForHostname(String hostname);

}
