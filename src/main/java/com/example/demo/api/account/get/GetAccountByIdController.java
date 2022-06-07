package com.example.demo.api.account.get;

import com.dewdrop.api.result.ResultException;
import com.example.demo.api.account.AbstractAccountController;
import com.example.demo.data.aggregate.AccountAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountByIdController extends AbstractAccountController {

    @Autowired
    GetAccountByIdUseCase getAccountByIdUseCase;

    @GetMapping(MAPPING + "/{id}")
    public ResponseEntity<?> create(GetAccountByIdQuery query) throws ResultException {
        return getAccountByIdUseCase.execute(query);
    }
}

