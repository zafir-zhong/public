package com.alibaba.csp.sentinel.dashboard.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * nacos配置
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午5:31
 * @modified By：
 */
@Component
@ConfigurationProperties(prefix = "dashboard.nacos")
@Data
@RefreshScope
public class NacosProperties {


    private String groupId = "SENTINEL_GROUP";

    private String flowRulesSuf = "-flow-rules";

    private String degradeRulesSuf="-degrade-rules";

    private String systemRulesSuf="-system-rules";

    private String paramFlowRulesSuf="-param-flow-rules";

    private String authorityRulesSuf="-authority-rules";

    private String dashboardSuf="-dashboard";

    private String gatewayApiRulesSuf="-gateway-api-rules";

    private String gatewayFlowRulesSuf="-gateway-flow-rules";

    // 未使用

    private String clusterMapSuf="-cluster-map";


    // 未使用

    private String clusterClientConfigSuf="-cc-config";

    private String clusterServerTransportConfigSuf="-cs-transport-config";

    private String clusterServerFlowConfigSuf="-cs-flow-config";

    private String clusterServerNamespaceSetSuf="-cs-namespace-set";

}
