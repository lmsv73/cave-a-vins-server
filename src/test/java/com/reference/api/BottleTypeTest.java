package com.reference.api;

import com.reference.api.models.BottleType;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.junit.Test;
import org.springframework.boot.json.JacksonJsonParser;

import javax.naming.Name;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;


public class BottleTypeTest {

    /*
    private String obtainAccessToken(String username, String password) throws Exception {

        ArrayList<NameValuePair> params;

        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("grant_type", "password"));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("password", password));

        HttpPost request = new HttpPost(new URL("http://localhost:" + 8080 + "/oauth/token/").toURI());


        request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));


        request.setHeader("Authorization", "Basic Z2lneTpzZWNyZXQ=");
        request.setHeader("Content-type", "application/x-www-form-urlencoded");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        String test = response.getEntity().getContent().toString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(response.getEntity().getContent().toString()).get("access_token").toString();


        ResultActions result
                = mockMvc.perform(post("/oauth/token")
                .params(params)
                .with(httpBasic("fooClientIdPassword","secret"))
                .accept("application/json;charset=UTF-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        String resultString = result.andReturn().getResponse().getContentAsString();

        JacksonJsonParser jsonParser = new JacksonJsonParser();
        return jsonParser.parseMap(resultString).get("access_token").toString();
    }*/

    @Test
    public void should_200_On_Existing_BottleType() throws IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 8080 + "/bottletype/").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
    }

    @Test
    public void should_200_On_BottleType_To_Validate() throws IOException, URISyntaxException {
        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 8080 + "/bottletype/getBottleToValidate").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
    }

    @Test
    public void should_200_On_Updating_BottleType() throws IOException, URISyntaxException {
        HttpPost request = new HttpPost(new URL("http://localhost:" + 8080 + "/bottletype/update/").toURI());

        request.setHeader("Accept", "application/json");
        request.setHeader("Content-type", "application/json");

        ObjectMapper mapper = new ObjectMapper();

        BottleType obj = new BottleType("blabla", 1850,"Rhone", "rouge",true);
        obj.setId(Integer.toUnsignedLong(1));

        request.setEntity(new StringEntity(mapper.writeValueAsString(obj), "UTF-8"));

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
    }
}
