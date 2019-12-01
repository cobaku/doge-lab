package ru.glukhov.doge.api.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class DogeResponse {

    public int success;
    public String message;
    public String error;

    public boolean isSuccess() {
        return success == 1;
    }

    public String getMessage() {
        return message == null ? error : message;
    }
}
