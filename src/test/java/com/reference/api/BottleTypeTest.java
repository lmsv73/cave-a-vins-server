package com.reference.api;

import com.reference.api.models.*;
import com.reference.api.repository.*;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.json.JacksonJsonParser;

import javax.naming.Name;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class BottleTypeTest {

    /***
     * Problem : https://stackoverflow.com/questions/49887730/spring-boot-oauth2-403-forbidden-when-oauth-token-in-integration-test
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    private String obtainAccessToken(String username, String password) throws Exception {

        ArrayList<NameValuePair> params;

        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("grant_type", "password"));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));

        HttpPost request = new HttpPost(new URL("http://localhost:" + 8080 + "/oauth/token").toURI());


        request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));


        request.setHeader(new BasicHeader("Authorization", "Basic Z2lneTpzZWNyZXQ="));
        request.setHeader("Content-type", "application/x-www-form-urlencoded");

        System.out.println("executing request " + request.getRequestLine());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String json = EntityUtils.toString(response.getEntity());
        JacksonJsonParser jsonParser = new JacksonJsonParser();

        return jsonParser.parseMap(json).get("access_token").toString();
    }

    @Test
    public void should_create_user() throws IOException, URISyntaxException, Exception {

    }

    @Test
    public void should_create_bottletype() throws IOException, URISyntaxException, Exception {

    }



    @Test
    public void should_200_On_Existing_BottleType() throws IOException, URISyntaxException, Exception {
        String token = obtainAccessToken("ludo","asticot");

        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 8080 + "/api/bottletype/").toURI());
        request.setHeader("Authorization", "Bearer " + token);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
    }

    @Test
    public void should_200_On_BottleType_All() throws IOException, URISyntaxException, Exception {
        String token = obtainAccessToken("ludo","asticot");
        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 8080 + "/api/bottletype/all").toURI());
        request.setHeader("Authorization", "Bearer " + token);
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
    }

    @Test
    public void should_200_On_Updating_BottleType() throws IOException, URISyntaxException, Exception {
        String token = obtainAccessToken("admin","admin");
        HttpPut request = new HttpPut(new URL("http://localhost:" + 8080 + "/api/bottletype/").toURI());

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");
        request.setHeader("Authorization", "Bearer " + token);

        ObjectMapper mapper = new ObjectMapper();

        BottleType obj = new BottleType("blabla", 1850,"Rhone", "rouge",true);
        obj.setId(Integer.toUnsignedLong(1));

        String test = mapper.writeValueAsString(obj);
        request.setEntity(new StringEntity(mapper.writeValueAsString(obj), "UTF-8"));

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

        HttpUriRequest request2 = new HttpGet(new URL("http://localhost:" + 8080 + "/api/bottletype/all").toURI());
        request2.setHeader("Authorization", "Bearer " + token);
        HttpResponse response2 = HttpClientBuilder.create().build().execute(request2);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response2.getEntity().getContent()));

        String result = rd.readLine();

        JsonNode rootNode = mapper.readTree(result);

        assertEquals(rootNode.get(0).get("name").asText(), "blabla");
        assertEquals(rootNode.get(0).get("date").asText(), 1850);
        assertEquals(rootNode.get(0).get("region").asText(), "Rhone");



    }

    @Test
    public void should_create_bottle() throws IOException, URISyntaxException, Exception {

    }

    @Test
    public void should_update_bottle() throws IOException, URISyntaxException, Exception {

    }

    @Test
    public void should_delete_bottle() throws IOException, URISyntaxException, Exception {

    }

    @Test
    public void should_delete_bottletype() throws IOException, URISyntaxException, Exception {

    }


}
