package com.varun.api.service.impl;

import com.varun.api.service.IChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
//@RequiredArgsConstructor
public class ChatService implements IChatService {

    private final ChatClient chatClient;

    public ChatService(ChatModel chatModel){
        this.chatClient = ChatClient.builder(chatModel).build();
    }

    @Override
    public String getResponse(String q) {
        ChatResponse chatResponse = chatClient.prompt(q).call().chatResponse();
        assert chatResponse != null;
        return chatResponse.getResult().toString();
    }

    @Override
    public Flux<String> streamResponse(String q) {
        return chatClient
                .prompt(q)
                .stream()
                .content();
    }

}
