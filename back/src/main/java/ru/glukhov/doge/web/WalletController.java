package ru.glukhov.doge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.glukhov.doge.api.domain.request.GetBalanceRequest;
import ru.glukhov.doge.api.domain.response.DogeResponse;
import ru.glukhov.doge.api.domain.response.GetBalanceResponse;
import ru.glukhov.doge.api.service.DogeRequestService;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    private DogeRequestService dogeRequestService;

    @Autowired
    public WalletController(DogeRequestService dogeRequestService) {
        this.dogeRequestService = dogeRequestService;
    }

    @GetMapping(value = "/balance/{wallet}")
    public DogeResponse getBalance(@PathVariable String wallet) {
        return dogeRequestService.handle(new GetBalanceRequest(wallet), GetBalanceResponse.class);
    }
}
