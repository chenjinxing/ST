package com.example.demo.http;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod; 
import org.springframework.http.MediaType; 
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient; 
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import com.example.demo.api.ApiBase;

import reactor.core.publisher.Mono;

public class WebClientTest {
	public static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ApiBase.class); 
	
	public void testWithCookie(){
        Mono<String> resp = WebClient.create()
                .method(HttpMethod.GET)
                .uri("http://baidu.com")
                .cookie("token","xxxx")
                .cookie("JSESSIONID","XXXX")
                .retrieve()
                .bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
    }
	
	public void testWithBasicAuth(){
        String basicAuth = "Basic "+ Base64.getEncoder().encodeToString("user:pwd".getBytes(StandardCharsets.UTF_8));
        LOGGER.info(basicAuth);
        Mono<String> resp = WebClient.create()
                .get()
                .uri("http://baidu.com")
                .header(HttpHeaders.AUTHORIZATION,basicAuth)
                .retrieve()
                .bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
    }
	public void testFormParam(){
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("name1","value1");
        formData.add("name2","value2");
        Mono<String> resp = WebClient.create().post()
                .uri("http://www.w3school.com.cn/test/demo_form.asp")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(BodyInserters.fromFormData(formData))
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
    }
	
	static class Book {
        String name;
        String title;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public void testPostJson(){
        Book book = new Book();
        book.setName("name");
        book.setTitle("this is title");
        Mono<String> resp = WebClient.create().post()
                .uri("http://localhost:8080/demo/json")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(Mono.just(book),Book.class)
                .retrieve().bodyToMono(String.class);
        LOGGER.info("result:{}",resp.block());
    }
}
