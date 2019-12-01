package ru.glukhov.doge.api.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBalanceResponse extends DogeResponse {

    public double balance;
}
