package com.example.demo.usecase.account.get;

import com.dewdrop.api.result.ResultException;
import com.example.demo.data.read.account.accountdetails.AccountDetailsDTO;
import com.example.demo.data.read.account.accountdetails.GetAccountDetailsByIdQuery;
import com.example.demo.usecase.account.AbstractAccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountDetailsByIdController extends AbstractAccountController {

    @Autowired
    GetAccountDetailsByIdUseCase accountDetailsByIdUseCase;

    @GetMapping(MAPPING + "/{id}")
    public ResponseEntity<AccountDetailsDTO> create(GetAccountDetailsByIdQuery query) throws ResultException {
        return accountDetailsByIdUseCase.execute(query);
    }
}

