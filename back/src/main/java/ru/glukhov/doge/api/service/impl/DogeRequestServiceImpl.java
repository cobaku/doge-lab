package ru.glukhov.doge.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.glukhov.doge.api.domain.request.DogeRequest;
import ru.glukhov.doge.api.domain.response.DogeResponse;
import ru.glukhov.doge.api.service.DogeRequestService;
import ru.glukhov.doge.service.HttpService;

@Service
public class DogeRequestServiceImpl implements DogeRequestService {

    @Value("${doge.api.endpoint}")
    private String dogeApiEndpoint;

    private final ObjectMapper mapper = new ObjectMapper();

    private final HttpService httpService;

    @Autowired
    public DogeRequestServiceImpl(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    @SneakyThrows
    public <T extends DogeResponse> T handle(DogeRequest request, Class<T> classToSerialize) {
        JSONObject json = null;

        switch (request.getMethod()) {
            case GET:
                json = httpService.getJson(dogeApiEndpoint + request.getUrlSuffix(), request.getParams());
                break;
            case POST:
                json = httpService.postJson(dogeApiEndpoint + request.getUrlSuffix(), request.getParams());
                break;
        }

        if (json == null) {
            throw new RuntimeException("Incorrect request");
        }

        final T payload = mapper.readValue(json.toJSONString(), classToSerialize);

        if (!payload.isSuccess()) {
            throw new RuntimeException(payload.getMessage());
        }

        return payload;
    }
}
