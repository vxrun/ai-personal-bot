package com.varun.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class BeanConfig {

//    @Value("${spring.ai.openai.api-key}")
//    private String openAiApiKey;
//
//    @Bean
//    ChatClient chatClient(){
//        OpenAiChatClient
//    }

    @Bean
    ObjectMapper objectMapper() {
        log.debug("Initializing object mapper...");
        return new ObjectMapper();
    }
}
