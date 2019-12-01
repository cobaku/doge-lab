package ru.glukhov.doge.api.domain.request;

import org.springframework.http.HttpMethod;

public class GetBlockInfoRequest extends DogeRequest {

    private final long block;
    private final String hash;

    public GetBlockInfoRequest(long block) {
        this.block = block;
        this.hash = null;
    }

    public GetBlockInfoRequest(String hash) {
        this.hash = hash;
        this.block = -1;
    }

    @Override
    public HttpMethod getMethod() {
        return HttpMethod.GET;
    }

    @Override
    public String getUrlSuffix() {
        return "/block/" + (hash == null ? block : hash);
    }
}
