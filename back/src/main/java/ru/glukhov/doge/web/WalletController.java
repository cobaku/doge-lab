package ru.glukhov.doge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.glukhov.doge.api.domain.request.GetBalanceRequest;
import ru.glukhov.doge.api.domain.request.GetReceivedAmountRequest;
import ru.glukhov.doge.api.domain.request.GetSentAmountRequest;
import ru.glukhov.doge.api.domain.response.DogeResponse;
import ru.glukhov.doge.api.domain.response.GetBalanceResponse;
import ru.glukhov.doge.api.domain.response.GetReceivedAmountResponse;
import ru.glukhov.doge.api.domain.response.GetSentAmountResponse;
import ru.glukhov.doge.api.service.DogeRequestService;
import ru.glukhov.doge.dto.WalletInfoDto;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    private DogeRequestService dogeRequestService;

    @Autowired
    public WalletController(DogeRequestService dogeRequestService) {
        this.dogeRequestService = dogeRequestService;
    }

    @GetMapping(value = "/{wallet}")
    public WalletInfoDto getWalletInfo(@PathVariable String wallet) {
        return new WalletInfoDto(
                dogeRequestService.handle(new GetBalanceRequest(wallet), GetBalanceResponse.class).balance,
                dogeRequestService.handle(new GetReceivedAmountRequest(wallet), GetReceivedAmountResponse.class).received,
                dogeRequestService.handle(new GetSentAmountRequest(wallet), GetSentAmountResponse.class).sent
        );
    }
}
