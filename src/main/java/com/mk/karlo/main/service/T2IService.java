package com.mk.karlo.main.service;

import com.mk.karlo.main.core.clients.AppClientFactory;
import com.mk.karlo.main.core.clients.DOMAIN;
import com.mk.karlo.main.core.clients.KarloApi;
import com.mk.karlo.main.domain.kalro.T2IReq;
import com.mk.karlo.main.domain.kalro.T2IRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class T2IService {

    private final AppClientFactory appClientFactory;

    public void textToImage(T2IReq t2IReq) {

        log.info("# req : {}", t2IReq);

        KarloApi karloApi = appClientFactory.load(DOMAIN.KARLO_API);
        T2IRes t2IRes =  karloApi.t2i(t2IReq);

        log.info("# res : {}", t2IRes);
    }
}
