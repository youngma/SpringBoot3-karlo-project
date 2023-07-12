package com.mk.karlo.main.core.clients;

import lombok.Getter;

public enum DOMAIN {

    KARLO_API("karlo-api", "https://api.kakaobrain.com", KarloApi.class),
    ;

    @Getter
    private final String serviceName;

    @Getter
    private final String url;

    @Getter
    private final Class clazz;

    DOMAIN(String serviceName, String url, Class<? extends WebClients> clazz) {
        this.serviceName = serviceName;
        this.url = url;
        this.clazz = clazz;
    }

}
