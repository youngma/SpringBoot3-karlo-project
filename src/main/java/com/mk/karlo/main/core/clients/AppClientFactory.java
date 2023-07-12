package com.mk.karlo.main.core.clients;


import com.mk.karlo.main.core.clients.haders.KakaoKarloHeader;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.HashMap;

@Component
@AllArgsConstructor
@Slf4j
public class AppClientFactory {

    private final HashMap<DOMAIN, WebClients> clientMaps = new HashMap<>();

    private final KakaoKarloHeader kakaoKarloHeader;

    @PostConstruct
    public void init() throws ClassNotFoundException {
        for (DOMAIN value : DOMAIN.values()) {
            clientMaps.put(value, initClients(value));
        }
    }

    private <S> S initClients(DOMAIN domain){

        Class<S> serviceType = (Class<S>) domain.getClazz();

        WebClient client =
                WebClient.builder()
                        .baseUrl(domain.getUrl())
                        .defaultHeaders(httpHeaders -> {
                            // todo 수정 가능 한지 확인..
                            if (serviceType.getTypeName().equals(KarloApi.class.getTypeName())) {
                                kakaoKarloHeader.getHeaders().keySet().forEach( key -> {
                                    httpHeaders.set(key, kakaoKarloHeader.getHeaders().get(key));
                                });
                            }
                        })
                        .build();

        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(client))
                .build();

        return proxyFactory.createClient(serviceType);
    }

    public <S> S load(DOMAIN domain) {
        Class<S> serviceType = (Class<S>) domain.getClazz();
        return serviceType.cast(clientMaps.get(domain));
    }
}
