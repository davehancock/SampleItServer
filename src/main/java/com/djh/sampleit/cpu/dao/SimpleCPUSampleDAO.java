package com.djh.sampleit.cpu.dao;

import com.djh.sampleit.cpu.controller.model.CPUSample;
import com.djh.sampleit.cpu.controller.model.CPUSampleSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleCPUSampleDAO implements CPUSampleDAO {

    private Map<String, List<CPUSample>> cpuSampleMap = new ConcurrentHashMap<>();

    // TODO persist as sampleSet instead?
    @Override
    public void persistCPUSample(String hostname, CPUSample cpuSample) {

        if (cpuSampleMap.containsKey(hostname)) {
            cpuSampleMap.get(hostname).add(cpuSample);
        } else {
            List<CPUSample> cpuSamples = new ArrayList<>();
            cpuSamples.add(cpuSample);
            cpuSampleMap.put(hostname, cpuSamples);
        }
    }

    // TODO read as a sampleSet instead?
    @Override
    public List<CPUSample> readAllCPUSamplesForHostname(String hostname) {
        return cpuSampleMap.get(hostname);
    }

    // TODO read as list of sampleSet instead?
    @Override
    public List<CPUSampleSet> readAllCPUSamples() {

        List<CPUSampleSet> cpuSampleSets = new ArrayList<>();

        for (Map.Entry<String, List<CPUSample>> entry : cpuSampleMap.entrySet()) {

            CPUSampleSet cpuSampleSet = new CPUSampleSet();
            cpuSampleSet.setHostname(entry.getKey());
            cpuSampleSet.setCpuSamples(entry.getValue());

            cpuSampleSets.add(cpuSampleSet);
        }

        return cpuSampleSets;
    }

    // TODO read as list of sampleSet instead?
    @Override
    public List<CPUSampleSet> readLatestCPUSamples() {

        List<CPUSampleSet> cpuSampleSets = new ArrayList<>();

        for (Map.Entry<String, List<CPUSample>> entry : cpuSampleMap.entrySet()) {

            CPUSampleSet cpuSampleSet = new CPUSampleSet();
            cpuSampleSet.setHostname(entry.getKey());

            List<CPUSample> cpuSamples = entry.getValue();
            if (cpuSamples.size() < 30) {
                cpuSampleSet.setCpuSamples(cpuSamples);
            } else {
                cpuSampleSet.setCpuSamples(cpuSamples.subList(cpuSamples.size() - 31, cpuSamples.size() - 1));
            }

            cpuSampleSets.add(cpuSampleSet);
        }

        return cpuSampleSets;
    }

}
