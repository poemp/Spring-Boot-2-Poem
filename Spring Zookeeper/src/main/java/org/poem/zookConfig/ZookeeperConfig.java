package org.poem.zookConfig;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
public class ZookeeperConfig {

    @NotNull
    @Value(value = "${zookeeper.url}")
    private String zkUrl;


    @Bean
    public CuratorFramework curatorFramework(){
        //重新连接策略
        RetryPolicy policy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework framework = CuratorFrameworkFactory.newClient(zkUrl,policy);
        framework.start();
        return framework;
    }
}
