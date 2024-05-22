package org.zane.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
aop 不需要additional configuration 也可以正常執行
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
}
