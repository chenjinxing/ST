package com.example.demo.http;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.api.ApiBase;
import com.example.demo.entity.ClOrder;

import reactor.core.publisher.Mono;

public class HBJZClient {
	public static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApiBase.class);
	//提交订单信息
	public String applyClOrder(ClOrder order)
	{
		Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/demo/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(order),ClOrder.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
        return resp.block();
	}
	
}
