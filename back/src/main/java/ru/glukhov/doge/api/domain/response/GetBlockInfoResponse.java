package ru.glukhov.doge.api.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import ru.glukhov.doge.api.domain.DogeBlock;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlockInfoResponse extends DogeResponse {

    public DogeBlock block;
}
