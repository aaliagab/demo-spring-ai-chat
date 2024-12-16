package com.example.demospringai.controllers;

import com.example.demospringai.dtos.PromptRequestDTO;
import com.example.demospringai.dtos.PromptResponseDTO;
import com.example.demospringai.services.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="chat")
public class ChatController {
    public final ChatService service;

    public ChatController(ChatService service) {
        this.service = service;
    }

    @PostMapping("/prompt-gpt")
    public ResponseEntity<PromptResponseDTO> makeQuery(@RequestBody PromptRequestDTO query){
        PromptResponseDTO response = service.sendPromptToOpenAI(query);
        return ResponseEntity.ok(response);
    }

    // Nuevo endpoint para Mistral
    @PostMapping("/prompt-mistral")
    public ResponseEntity<PromptResponseDTO> makeQueryToMistral(@RequestBody PromptRequestDTO query) {
        PromptResponseDTO response = service.sendPromptToMistral(query);
        return ResponseEntity.ok(response);
    }
}
