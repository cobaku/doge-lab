package ru.glukhov.doge.api.service;

import ru.glukhov.doge.api.domain.request.DogeRequest;
import ru.glukhov.doge.api.domain.response.DogeResponse;

public interface DogeRequestService {

    <T extends DogeResponse> T handle(DogeRequest request, Class<T> classToSerialize);
}
