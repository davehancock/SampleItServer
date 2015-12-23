package com.djh.sampleit.configuration;

import com.djh.sampleit.cpu.dao.CPUSampleDAO;
import com.djh.sampleit.cpu.dao.SimpleCPUSampleDAO;
import com.djh.sampleit.cpu.service.CPUService;
import com.djh.sampleit.cpu.service.DefaultCPUService;
import com.djh.sampleit.host.service.DefaultHostService;
import com.djh.sampleit.host.service.HostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author David Hancock
 */
@Configuration
public class ServerConfiguration {

    @Bean
    public CPUService cpuService() {
        return new DefaultCPUService();
    }

    @Bean
    public CPUSampleDAO cpuMetricDAO() {
        return new SimpleCPUSampleDAO();
    }

    @Bean
    public HostService hostService() {
        return new DefaultHostService();
    }

}
