package com.mk.karlo.main.core.clients.haders;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j

abstract class AbstractHeaders {

    @PostConstruct
    protected void init(){

    }

    @Getter
    protected final HashMap<String, String> headers = new HashMap<>();

}
