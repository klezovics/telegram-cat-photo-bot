package com.klezovich.catbot.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CatPhotoProvider {

    private final CatPhotoUrlProvider provider;
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public CatPhotoProvider(CatPhotoUrlProvider provider) {
        this.provider = provider;
    }

    public byte[] getPhotoBytes() {
        return getPhotoBytesByUrl(provider.getUrl());
    }

    private byte[] getPhotoBytesByUrl(String url) {
        return restTemplate.getForObject(url, byte[].class);
    }
}
