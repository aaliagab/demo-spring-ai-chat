package com.example.demospringai.services;

import com.example.demospringai.dtos.PromptRequestDTO;
import com.example.demospringai.dtos.PromptResponseDTO;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class GPTService {
    private final ChatClient client;

    public GPTService(ChatClient client) {
        this.client = client;
    }

    public PromptResponseDTO sendPromptToOpenAI(PromptRequestDTO request){
        String response = client.prompt()
                .user(request.prompt())
                .call()
                .content();
        return new PromptResponseDTO(response);
    }
}
