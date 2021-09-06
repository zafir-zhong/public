package com.alibaba.csp.sentinel.dashboard.component;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推送gatewayApiRules的实际实现类
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午6:13
 * @modified By：
 */
@Component("gatewayApiNacosProvider")
public class GatewayApiNacosProvider implements DynamicRuleProvider<List<ApiDefinitionEntity>> {
    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosProperties nacosProperties;

    @Override
    public List<ApiDefinitionEntity> getRules(String appName) throws Exception {
        return NacosConfigUtil.getRuleEntitiesFromNacos(configService,appName,nacosProperties.getGatewayApiRulesSuf(),ApiDefinitionEntity.class);
    }

}

