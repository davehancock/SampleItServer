package com.djh.sampleit.cpu.dao;

import com.djh.sampleit.cpu.model.CPUSample;
import com.djh.sampleit.cpu.model.CPUSampleSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author David Hancock
 */
public class SimpleCPUSampleDAO implements CPUSampleDAO {

    private Map<String, List<CPUSample>> cpuSampleMap = new ConcurrentHashMap<>();

    // TODO persist as sampleSet instead? Or Rather Lists of CPUSamples per host...
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

    // TODO Redundant?
    @Override
    public List<CPUSampleSet> readAllCPUSamples() {

        List<CPUSampleSet> cpuSampleSets = new ArrayList<>();

        for (Map.Entry<String, List<CPUSample>> entry : cpuSampleMap.entrySet()) {

            CPUSampleSet cpuSampleSet = new CPUSampleSet();
            cpuSampleSet.setHostname(entry.getKey());
            cpuSampleSet.setCpuSamples(entry.getValue());

            cpuSampleSets.add(cpuSampleSet);
        }

        return new ArrayList<>(cpuSampleSets);
    }

    // TODO Throws null pointer on empty list
    @Override
    public List<CPUSample> readAllCPUSamplesForHostname(String hostname) {
        return new ArrayList<>(cpuSampleMap.get(hostname));
    }

    @Override
    public List<String> readAllHostsWithCPUMetrics(){
        return new ArrayList<>(cpuSampleMap.keySet());
    }

}
