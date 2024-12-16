package com.example.demospringai.services;

import com.example.demospringai.dtos.PromptRequestDTO;
import com.example.demospringai.dtos.PromptResponseDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient openAIClient;
    private final ChatClient mistralClient;

    public ChatService(@Qualifier("openAI") ChatClient openAIClient, @Qualifier("mistral") ChatClient mistralClient) {
        this.openAIClient = openAIClient;
        this.mistralClient = mistralClient;
    }

    public PromptResponseDTO sendPromptToOpenAI(PromptRequestDTO request){
        String response = openAIClient.prompt()
                .user(request.prompt())
                .call()
                .content();
        return new PromptResponseDTO(response);
    }

    // Método para Mixtral
    public PromptResponseDTO sendPromptToMistral(PromptRequestDTO request) {
        String response = mistralClient.prompt()
                .user(request.prompt())
                .call()
                .content();
        return new PromptResponseDTO(response);
    }
}
