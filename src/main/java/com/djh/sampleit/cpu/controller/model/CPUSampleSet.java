package com.djh.sampleit.cpu.controller.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hancock
 */
public class CPUSampleSet {

    private String Hostname;

    List<CPUSample> cpuSamples = new ArrayList<>();

    public CPUSampleSet() {
    }

    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }

    public List<CPUSample> getCpuSamples() {
        return cpuSamples;
    }

    public void setCpuSamples(List<CPUSample> cpuSamples) {
        this.cpuSamples = cpuSamples;
    }

}
