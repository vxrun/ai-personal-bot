package com.varun.api.controller;

import com.varun.api.dto.RequestDto;
import com.varun.api.dto.ResponseDto;
import com.varun.api.service.IChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final IChatService chatService;

    @GetMapping("/query")
    public ResponseEntity<ResponseDto> chat(RequestDto requestDto) {
        log.info("Processing request for {}", requestDto.toString());
        return ResponseEntity.accepted().body(ResponseDto.builder().data(chatService.getResponse(requestDto.getData())).build());
    }

    @GetMapping(value = "/stream", produces = "text/event-stream")
    public Flux<String> streamResponse(@RequestParam String q) {
        return chatService.streamResponse(q);
    }

}
