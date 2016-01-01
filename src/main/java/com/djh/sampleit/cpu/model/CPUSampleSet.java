package com.djh.sampleit.cpu.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David Hancock
 */
public class CPUSampleSet {

    private String macAddress;

    List<CPUSample> cpuSamples = new ArrayList<>();

    public CPUSampleSet() {
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public List<CPUSample> getCpuSamples() {
        return cpuSamples;
    }

    public void setCpuSamples(List<CPUSample> cpuSamples) {
        this.cpuSamples = cpuSamples;
    }

}
