package ru.glukhov.doge.api.domain.request;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;

@RequiredArgsConstructor
public class GetTransactionRequest extends DogeRequest {

    private final String transactionHash;

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getUrlSuffix() {
        return "/transaction/" + transactionHash;
    }

}
