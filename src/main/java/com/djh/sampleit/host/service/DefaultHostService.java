package com.djh.sampleit.host.service;

import com.djh.sampleit.cpu.controller.model.CPUSample;
import com.djh.sampleit.cpu.controller.model.CPUSampleSet;
import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultHostService implements HostService {

    // FIXME master host data elsewhere?
    @Autowired
    private CPUSampleDAO cpuSampleDAO;

    @Override
    public List<String> retrieveHosts() {

        List<String> hosts = new ArrayList<>();

        List<CPUSampleSet> cpuSampleSets = cpuSampleDAO.readLatestCPUSamples();
        for (CPUSampleSet cpuSampleSet : cpuSampleSets) {
            hosts.add(cpuSampleSet.getHostname());
        }

        return hosts;
    }


}
