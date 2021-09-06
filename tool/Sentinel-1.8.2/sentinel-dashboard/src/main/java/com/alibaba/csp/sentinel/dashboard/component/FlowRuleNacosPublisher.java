package com.alibaba.csp.sentinel.dashboard.component;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.dashboard.util.NacosConfigUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 推送flowRules的实际实现类
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午6:13
 * @modified By：
 */
@Component("flowRuleNacosPublisher")
public class FlowRuleNacosPublisher implements DynamicRulePublisher<List<FlowRuleEntity>> {
    @Autowired
    private ConfigService configService;
    @Autowired
    private NacosProperties nacosProperties;

    @Override
    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
        NacosConfigUtil.storeRuleStringToNacos(
                this.configService,
                app,
                nacosProperties.getFlowRulesSuf(),
                rules
        );
    }
}

