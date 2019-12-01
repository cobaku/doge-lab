package ru.glukhov.doge.api.domain.request;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
public abstract class DogeRequest {

    public abstract HttpMethod getMethod();

    public abstract String getUrlSuffix();

    public Map<String, ?> getParams() {
        return Collections.emptyMap();
    }

}
