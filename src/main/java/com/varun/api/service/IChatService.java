package com.varun.api.service;

import reactor.core.publisher.Flux;

public interface IChatService {
    String getResponse(String q);

    Flux<String> streamResponse(String q);
}
