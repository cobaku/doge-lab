package ru.glukhov.doge.service.impl;

import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import ru.glukhov.doge.service.HttpService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class HttpServiceImpl implements HttpService {

    private static final String UTF_8 = Charsets.UTF_8.displayName();
    private final HttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();

    @Override
    public JSONObject getJson(String url, Map<String, ?> params) {
        return getJson(url, params, Collections.emptyList());
    }

    @Override
    public JSONObject postJson(String url, Map<String, ?> params) {
        return postJson(url, params, Collections.emptyList());
    }

    @Override
    public JSONObject getJson(String url, Map<String, ?> params, Collection<Header> headers) {
        return getJsonFromHttpResponse(execGetRequest(url, params, headers));
    }

    @Override
    public JSONObject postJson(String url, Map<String, ?> params, Collection<Header> headers) {
        try (final CloseableHttpClient httpClient = createClient()) {
            final HttpPost httpPost = new HttpPost(buildUrl(url, params));

            if (headers != null) {
                headers.forEach(httpPost::addHeader);
            }

            return getJsonFromHttpResponse(httpClient.execute(httpPost));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONObject getJsonFromHttpResponse(HttpResponse response) {
        try {
            return (JSONObject) new JSONParser().parse(EntityUtils.toString(response.getEntity()));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse execGetRequest(String url, Map<String, ?> params, Collection<Header> headers) {
        try (final CloseableHttpClient httpClient = createClient()) {
            final HttpGet httpGet = new HttpGet(buildUrl(url, params));

            if (headers != null) {
                headers.forEach(httpGet::addHeader);
            }

            return httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String buildUrl(String baseUrl, Map<String, ?> params) {
        if (params == null || params.isEmpty()) {
            return baseUrl;
        }

        final StringBuilder result = new StringBuilder(baseUrl.length() + 10 * params.size());
        result.append(baseUrl).append("?");

        try {
            for (final String name : params.keySet()) {
                final String value = URLEncoder.encode(String.valueOf(params.get(name)), UTF_8);
                result.append(name).append("=").append(value).append("&");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        return result.toString();
    }

    private CloseableHttpClient createClient() {
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                .setConnectionManager(manager)
                .setConnectionManagerShared(true)
                .setMaxConnTotal(20)
                .build();
    }
}
