package com.klezovich.catbot.photo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatPhotoUrlProvider {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CAT_PICTURE_API_URI = "https://api.thecatapi.com/v1/images/search";

    public String getUrl() {
        var url = restTemplate.getForObject(CAT_PICTURE_API_URI, CatApiResponse[].class)[0].getUrl();
        return url;
    }

    @Data
    private static class CatApiResponse {
        private String url;
    }

    public static void main(String[] args) {
        var url = new CatPhotoUrlProvider().getUrl();
        System.out.println(url);
    }
}
