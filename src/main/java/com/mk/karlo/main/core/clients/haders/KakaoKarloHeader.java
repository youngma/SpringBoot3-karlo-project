package com.mk.karlo.main.core.clients.haders;


import io.micrometer.observation.annotation.Observed;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;

@ToString
@ConfigurationProperties(prefix = "kakao")
@Configuration
@Slf4j
public class KakaoKarloHeader extends AbstractHeaders {

    private final String AUTHORIZATION_KEY = "KakaoAK ";

    @Setter
    private String restKey;

    @Override
    public void init() {

        headers.put(HttpHeaders.AUTHORIZATION, AUTHORIZATION_KEY.concat(restKey));
        headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

//      headers = new HashMap<>() {{
//            put("key", "value")
//      }};
    }

}
