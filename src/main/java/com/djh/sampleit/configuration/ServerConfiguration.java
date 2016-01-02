package com.djh.sampleit.configuration;

import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import com.djh.sampleit.cpu.dao.SimpleCPUSampleDAO;
import com.djh.sampleit.cpu.service.CPUService;
import com.djh.sampleit.cpu.service.DefaultCPUService;
import com.djh.sampleit.machine.dao.SimpleMachineDAO;
import com.djh.sampleit.machine.dao.MachineDAO;
import com.djh.sampleit.metadata.dao.MetadataDAO;
import com.djh.sampleit.metadata.dao.SimpleMetadataDAO;
import com.djh.sampleit.metadata.service.DefaultMetadataService;
import com.djh.sampleit.metadata.service.MetadataService;
import com.djh.sampleit.memory.dao.MemoryDAO;
import com.djh.sampleit.memory.dao.SimpleMemoryDAO;
import com.djh.sampleit.memory.service.DefaultMemoryService;
import com.djh.sampleit.memory.service.MemoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO Probably split out into distinct configuration classes
 *
 * @author David Hancock
 */
@Configuration
public class ServerConfiguration {

    // Metadata
    @Bean
    public MetadataService metadataService() {
        return new DefaultMetadataService();
    }

    @Bean
    public MetadataDAO metadataDAO() {
        return new SimpleMetadataDAO();
    }

    @Bean
    public MachineDAO machineDAO() {
        return new SimpleMachineDAO();
    }

    // CPU
    @Bean
    public CPUService cpuService() {
        return new DefaultCPUService();
    }

    @Bean
    public CPUSampleDAO cpuMetricDAO() {
        return new SimpleCPUSampleDAO();
    }

    // Memory
    @Bean
    public MemoryService memoryService() {
        return new DefaultMemoryService();
    }

    @Bean
    public MemoryDAO memoryDAO() {
        return new SimpleMemoryDAO();
    }

}
