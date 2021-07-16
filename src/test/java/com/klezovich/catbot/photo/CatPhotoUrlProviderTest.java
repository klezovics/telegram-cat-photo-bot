package com.klezovich.catbot.photo;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CatPhotoUrlProviderTest {

    private CatPhotoUrlProvider provider = new CatPhotoUrlProvider();

    @Test
    void testCanGetCatPhotoUrl() {
        var url = provider.getUrl();

        assertNotNull(url);
        assertThat(url, CoreMatchers.startsWith("http"));
    }

}