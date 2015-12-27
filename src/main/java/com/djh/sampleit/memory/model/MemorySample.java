package com.djh.sampleit.memory.model;

/**
 * @author David Hancock
 */
public class MemorySample {

    private long totalMemory;

    private long availableMemory;

    public MemorySample(long totalMemory, long availableMemory) {
        this.totalMemory = totalMemory;
        this.availableMemory = availableMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public long getAvailableMemory() {
        return availableMemory;
    }

}
