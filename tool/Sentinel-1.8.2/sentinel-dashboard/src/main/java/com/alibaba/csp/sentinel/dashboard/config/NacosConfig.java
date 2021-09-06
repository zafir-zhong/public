package com.alibaba.csp.sentinel.dashboard.config;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * nacosConfig
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午7:13
 * @modified By：
 */
@Configuration
public class NacosConfig {

    @Bean
    public ConfigService configService(NacosConfigManager manager) {
        return manager.getConfigService();
    }
}
