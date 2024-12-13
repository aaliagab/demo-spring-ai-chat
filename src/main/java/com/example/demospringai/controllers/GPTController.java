package com.example.demospringai.controllers;

import com.example.demospringai.dtos.PromptRequestDTO;
import com.example.demospringai.dtos.PromptResponseDTO;
import com.example.demospringai.services.GPTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="gpt")
public class GPTController {
    public final GPTService service;

    public GPTController(GPTService service) {
        this.service = service;
    }

    @PostMapping("/prompt")
    public ResponseEntity<PromptResponseDTO> makeQuery(@RequestBody PromptRequestDTO query){
        PromptResponseDTO response = service.sendPromptToOpenAI(query);
        return ResponseEntity.ok(response);
    }
}
