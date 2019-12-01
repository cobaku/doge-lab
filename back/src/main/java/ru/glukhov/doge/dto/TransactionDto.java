package ru.glukhov.doge.dto;

import ru.glukhov.doge.api.domain.DogeTransaction;

import java.util.Set;
import java.util.stream.Collectors;

public class TransactionDto {

    public String blockHash;
    public double outputsValue;
    public double inputsValue;
    public String hash;
    public long confirmations;
    public int size;
    public long time;
    public double fee;
    public Set<OutputDto> outputAddress;
    public Set<InputDto> inputAddress;

    public TransactionDto(DogeTransaction transaction) {
        this.blockHash = transaction.blockHash;
        this.outputsValue = transaction.outputsValue;
        this.inputsValue = transaction.inputsValue;
        this.hash = transaction.hash;
        this.confirmations = transaction.confirmations;
        this.size = transaction.size;
        this.time = transaction.time * 1000;
        this.fee = transaction.fee;
        this.outputAddress = transaction.outputs.stream()
                .map(OutputDto::new)
                .collect(Collectors.toSet());
        this.inputAddress = transaction.inputs.stream()
                .map(InputDto::new)
                .collect(Collectors.toSet());
    }

    public static class InputDto {
        public String sig;
        public int pos;
        public double value;
        public String address;
        public String type;

        public InputDto(DogeTransaction.Input input) {
            this.sig = input.sig.hex;
            this.pos = input.pos;
            this.value = input.value;
            this.address = input.address;
            this.type = input.type;
        }
    }

    public static class OutputDto {
        public int pos;
        public double value;
        public String type;
        public String address;

        public OutputDto(DogeTransaction.Output output) {
            this.pos = output.pos;
            this.value = output.value;
            this.type = output.type;
            this.address = output.address;
        }
    }
}
