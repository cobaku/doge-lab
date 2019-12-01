package ru.glukhov.doge.dto;

import ru.glukhov.doge.api.domain.response.GetBlockInfoResponse;

import java.util.List;

public class BlockInfoResponseDto {

    public double valueIn;
    public double valueOut;
    public String previousBlockHash;
    public String nextBlockHash;
    public double averageCoinAge;
    public String hash;
    public double difficulty;
    public long time;
    public long confirmations;
    public String merkleRoot;
    public List<String> txs;
    public long version;
    public long height;

    public BlockInfoResponseDto(GetBlockInfoResponse response) {
        this.valueIn = response.block.valueIn;
        this.valueOut = response.block.valueOut;
        this.previousBlockHash = response.block.previousBlockHash;
        this.nextBlockHash = response.block.nextBlockHash;
        this.averageCoinAge = response.block.averageCoinAge;
        this.hash = response.block.hash;
        this.difficulty = response.block.difficulty;
        this.time = response.block.time * 1000;
        this.confirmations = response.block.confirmations;
        this.merkleRoot = response.block.merkleroot;
        this.txs = response.block.txs;
        this.version = response.block.version;
        this.height = response.block.height;
    }
}
