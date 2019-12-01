package ru.glukhov.doge.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DogeBlock {

    @JsonProperty(value = "value_in")
    public double valueIn;

    @JsonProperty(value = "value_out")
    public double valueOut;

    @JsonProperty(value = "previous_block_hash")
    public String previousBlockHash;

    @JsonProperty(value = "next_block_hash")
    public String nextBlockHash;

    @JsonProperty(value = "average_coin_age")
    public double averageCoinAge;

    public String hash;
    public double difficulty;
    public long time;
    public long confirmations;
    public String merkleroot;
    public List<String> txs;
    public long version;
    public long height;
}
