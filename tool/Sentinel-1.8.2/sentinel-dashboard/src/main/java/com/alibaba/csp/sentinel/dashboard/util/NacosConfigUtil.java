package com.alibaba.csp.sentinel.dashboard.util;

import com.alibaba.csp.sentinel.dashboard.config.NacosProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.RuleEntity;
import com.alibaba.csp.sentinel.slots.block.Rule;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * nacos提交和获取配置的工具类
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午5:10
 * @modified By：
 */
@Component
public class NacosConfigUtil {

    private static NacosProperties nacosProperties;


    public NacosConfigUtil(NacosProperties nacosProperties) {
        NacosConfigUtil.nacosProperties = nacosProperties;
    }

    /**
     * 将规则序列化成JSON文本，存储到Nacos server中
     *
     * @param configService nacos config service
     * @param app           应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param rules         规则对象
     * @throws NacosException 异常
     */
    public static <T> void storeRuleStringToNacos(ConfigService configService, String app, String postfix, List<T> rules) throws NacosException {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }

        List<Rule> ruleForApp = rules.stream()
                .map(rule -> {
                    RuleEntity rule1 = (RuleEntity) rule;
                    System.out.println(rule1.getClass());
                    Rule rule2 = rule1.toRule();
                    System.out.println(rule2.getClass());
                    return rule2;
                })
                .collect(Collectors.toList());

        // 存储，给微服务使用
        String dataId = genDataId(app, postfix);
        configService.publishConfig(
                dataId,
                nacosProperties.getGroupId(),
                JSON.toJSONString(ruleForApp)
        );

        // 存储，给控制台使用
        configService.publishConfig(
                dataId + nacosProperties.getDashboardSuf(),
                nacosProperties.getGroupId(),
                JSON.toJSONString(rules)
        );
    }

    /**
     * 从Nacos server中查询响应规则，并将其反序列化成对应Rule实体
     *
     * @param configService nacos config service
     * @param appName       应用名称
     * @param postfix       规则后缀 eg.NacosConfigUtil.FLOW_DATA_ID_POSTFIX
     * @param clazz         类
     * @param <T>           泛型
     * @return 规则对象列表
     * @throws NacosException 异常
     */
    public static <T> List<T> getRuleEntitiesFromNacos(ConfigService configService, String appName, String postfix, Class<T> clazz) throws NacosException {
        String rules = configService.getConfig(
                genDataId(appName, postfix) + nacosProperties.getDashboardSuf(),
                nacosProperties.getGroupId(),
                3000
        );
        if (StringUtil.isEmpty(rules)) {
            return new ArrayList<>();
        }
        return JSON.parseArray(rules, clazz);
    }

    private static String genDataId(String appName, String postfix) {
        return appName + postfix;
    }
}
