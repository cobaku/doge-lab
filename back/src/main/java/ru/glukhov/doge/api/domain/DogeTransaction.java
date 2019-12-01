package ru.glukhov.doge.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DogeTransaction {

    @JsonProperty(value = "block_hash")
    public String blockHash;

    @JsonProperty(value = "outputs_value")
    public double outputsValue;

    @JsonProperty(value = "inputs_value")
    public double inputsValue;

    @JsonProperty(value = "inputs_n")
    public int inputsLenght;

    @JsonProperty(value = "outputs_n")
    public int outputsLength;

    public String hash;
    public long confirmations;
    public int size;
    public int version;
    public int locktime;
    public long time;
    public double fee;
    public ArrayList<Input> inputs;
    public ArrayList<Output> outputs;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Input {

        @JsonProperty(value = "scriptSig")
        public Sig sig;

        public int pos;
        public double value;
        public String address;
        public String type;

        public static class Sig {
            public String hex;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Output {
        public int pos;
        public double value;
        public String type;
        public String address;
    }

}
