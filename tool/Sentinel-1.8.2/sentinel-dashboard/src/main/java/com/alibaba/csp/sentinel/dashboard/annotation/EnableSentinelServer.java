package com.alibaba.csp.sentinel.dashboard.annotation;

import com.alibaba.csp.sentinel.dashboard.config.SentinelServerAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 自动获取配置
 *
 * @author ：zafir zhong
 * @version : 1.0.0
 * @date ：Created in 2021/8/30 下午6:07
 * @modified By：
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(SentinelServerAutoConfiguration.class)
public @interface EnableSentinelServer {
}
