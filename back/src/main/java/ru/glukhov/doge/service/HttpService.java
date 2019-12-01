package ru.glukhov.doge.service;

import org.apache.http.Header;
import org.json.simple.JSONObject;

import java.util.Collection;
import java.util.Map;

public interface HttpService {

    JSONObject getJson(String url, Map<String, ?> params);

    JSONObject postJson(String url, Map<String, ?> params);

    JSONObject getJson(String url, Map<String, ?> params, Collection<Header> headers);

    JSONObject postJson(String url, Map<String, ?> params, Collection<Header> headers);
}
