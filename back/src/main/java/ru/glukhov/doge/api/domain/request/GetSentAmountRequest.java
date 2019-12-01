package ru.glukhov.doge.api.domain.request;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor
public class GetSentAmountRequest extends DogeRequest {

    private final String address;

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getUrlSuffix() {
        return "/address/received/" + address;
    }

}
