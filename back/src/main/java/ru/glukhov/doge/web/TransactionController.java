package ru.glukhov.doge.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.glukhov.doge.api.domain.request.GetTransactionRequest;
import ru.glukhov.doge.api.domain.response.GetTransactionResponse;
import ru.glukhov.doge.api.service.DogeRequestService;
import ru.glukhov.doge.dto.TransactionDto;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private DogeRequestService dogeRequestService;

    @Autowired
    public TransactionController(DogeRequestService dogeRequestService) {
        this.dogeRequestService = dogeRequestService;
    }

    @GetMapping(value = "{transaction}")
    public TransactionDto getTransaction(@PathVariable String transaction) {
        return new TransactionDto(dogeRequestService.handle(new GetTransactionRequest(transaction), GetTransactionResponse.class).transaction);
    }
}
