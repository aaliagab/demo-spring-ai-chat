package com.example.demospringai.configurations;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.ai.mistralai.MistralAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfig {

    @Bean("openAI")
    ChatClient chatClientOpenAIWithMemory(OpenAiChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultSystem("Tú eres un ChatBot amigable con los usuarios")
                .defaultAdvisors(new PromptChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }


    @Bean("mistral")
    ChatClient mistralChatClient(MistralAiChatModel chatModel) {
        return ChatClient.builder(chatModel)
                .defaultSystem("Tú eres un ChatBot amigable con los usuarios")
                .defaultAdvisors(new PromptChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
    }
}
