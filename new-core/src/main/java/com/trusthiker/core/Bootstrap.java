package com.trusthiker.core;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rui on 16/10/22.
 */

@Configuration
public class Bootstrap {


    public static void main(String[] args) throws Exception {
        System.setProperty("server.port", "8081");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new
                String[]{"classpath*:app-core.xml"});
        MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        System.out.println("server start...");
    }

    @Bean
    public AnnotationBean motanAnnotationBean() {
        AnnotationBean motanAnnotationBean = new AnnotationBean();
        motanAnnotationBean.setPackage("com.trusthiker.core");
        return motanAnnotationBean;
    }

    @Bean(name = "demoMotan")
    public ProtocolConfigBean protocolConfig1() {
        ProtocolConfigBean config = new ProtocolConfigBean();
        config.setDefault(true);
        config.setName("motan");
        config.setMaxContentLength(1048576);
        return config;
    }

    @Bean(name = "registryConfig1")
    public RegistryConfigBean registryConfig() {
        RegistryConfigBean config = new RegistryConfigBean();
        config.setRegProtocol("local");
        return config;
    }

    @Bean
    public BasicServiceConfigBean baseServiceConfig() {
        BasicServiceConfigBean config = new BasicServiceConfigBean();
        config.setExport("demoMotan:8002");
        config.setGroup("testgroup");
        config.setAccessLog(false);
        config.setShareChannel(true);
        config.setModule("motan-demo-rpc");
        config.setApplication("myMotanDemo");
        config.setRegistry("registryConfig1");
        return config;
    }





}
