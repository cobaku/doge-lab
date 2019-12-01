package ru.glukhov.doge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.glukhov.doge.api.domain.request.GetBlockInfoRequest;
import ru.glukhov.doge.api.domain.response.GetBlockInfoResponse;
import ru.glukhov.doge.api.service.DogeRequestService;
import ru.glukhov.doge.dto.BlockInfoResponseDto;

@RestController
@RequestMapping(value = "/chain")
public class ChainController {

    private final DogeRequestService dogeRequestService;

    @Autowired
    public ChainController(DogeRequestService dogeRequestService) {
        this.dogeRequestService = dogeRequestService;
    }

    @GetMapping(value = "block/{block}")
    public BlockInfoResponseDto getBlock(@PathVariable String block) {
        return new BlockInfoResponseDto(dogeRequestService.handle(new GetBlockInfoRequest(block), GetBlockInfoResponse.class));
    }
}
