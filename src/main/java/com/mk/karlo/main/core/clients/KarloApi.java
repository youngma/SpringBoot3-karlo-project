package com.mk.karlo.main.core.clients;

import com.mk.karlo.main.domain.kalro.T2IReq;
import com.mk.karlo.main.domain.kalro.T2IRes;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface KarloApi extends WebClients {
    @PostExchange(value = "v2/inference/karlo/t2i", contentType = "application/json")
    T2IRes t2i(@RequestBody T2IReq t2IReq);
}
