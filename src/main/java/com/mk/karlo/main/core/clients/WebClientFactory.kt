package com.mk.karlo.main.core.clients

import com.mk.karlo.main.core.clients.haders.KakaoKarloHeader
import org.springframework.http.HttpHeaders
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import java.util.function.Consumer

open class WebClientFactory( private val clientMaps: HashMap<DOMAIN, Any>,
                             private val kakaoKarloHeader: KakaoKarloHeader
    ) {

//    init {
//        for (value in DOMAIN.entries) {
//            clientMaps[value] = initClients<WebClients>(value)
//        }
//    }
//
//    private fun <S> initClients(domain: DOMAIN): S {
//        val serviceType = domain.clazz as Class<S>
//        val client = WebClient.builder()
//            .baseUrl(domain.url)
//            .defaultHeaders { httpHeaders: HttpHeaders ->
//                // todo 수정 가능 한지 확인..
//                if (serviceType.typeName == KarloApi::class.java.typeName) {
//                    kakaoKarloHeader.headers.keys.forEach(Consumer<String> { key: String ->
//                        httpHeaders[key] = kakaoKarloHeader.headers[key]
//                    })
//                }
//            }
//            .build()
//
//        val proxyFactory = HttpServiceProxyFactory
//            .builder(WebClientAdapter.forClient(client))
//            .build()
//
//        return proxyFactory.createClient(serviceType)
//    }
//
//    open fun load(domain: DOMAIN): Any? = clientMaps[domain]
}
