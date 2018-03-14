package com.reference.api;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class BottleTypeTest {

    @Test
    public void should_200_On_Existing_BottleType() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 8080 + "/bottletype/").toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

}
