package com.example.demospringai.configurations;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {
    /*@Bean
    ChatClient chatClient(ChatClient.Builder builder){
        return builder
                .defaultSystem("Tu eres un ChatBot amigable con los usuarios")
                .build();
    }

     */
    @Bean
    ChatClient chatClientWithMemory(ChatClient.Builder builder){
        return builder
                .defaultSystem("Tu eres un ChatBot amigable con los usuarios")
                .defaultAdvisors(
                        new PromptChatMemoryAdvisor(new InMemoryChatMemory())
                )
                .build();
    }
}
