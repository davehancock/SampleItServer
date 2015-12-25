package com.djh.sampleit.host.service;

import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author David Hancock
 */
public class DefaultHostService implements HostService {

    // FIXME master host data elsewhere? Get Hosts for each specific Metric type?
    @Autowired
    private CPUSampleDAO cpuSampleDAO;

    @Override
    public List<String> retrieveHosts() {
        return cpuSampleDAO.readAllHostsWithCPUMetrics();
    }

}
