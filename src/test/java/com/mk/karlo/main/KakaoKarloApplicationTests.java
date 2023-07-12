package com.mk.karlo.main;

import com.mk.karlo.main.domain.kalro.T2IReq;
import com.mk.karlo.main.service.T2IService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KakaoKarloApplicationTests {


    @Autowired
    T2IService t2IService;

    @Test
    void contextLoads() {

        try {
            T2IReq t2IReq = new T2IReq("A cat with white fur", "sleeping cat, human, ugly face, cropped");
            t2IService.textToImage(t2IReq);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
