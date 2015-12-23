package com.djh.sampleit.cpu.controller.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author David Hancock
 */
public class CPUSample {

    private Date timestamp;

    List<CPUCore> cpuCores = new ArrayList<>();

    public CPUSample() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<CPUCore> getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(List<CPUCore> cpuCores) {
        this.cpuCores = cpuCores;
    }
}
