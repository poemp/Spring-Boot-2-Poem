package org.poem;

import org.poem.listenter.RedisChannelListenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@SpringBootApplication
public class SpringRedisApplication {

    @Bean
    public MessageListenerAdapter listenerAdapter(){
        return new MessageListenerAdapter(new RedisChannelListenter());
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory factory, MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(factory);
        container.addMessageListener(messageListenerAdapter, new PatternTopic("news.*"));
        return  container;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisApplication.class,args);
    }
}
