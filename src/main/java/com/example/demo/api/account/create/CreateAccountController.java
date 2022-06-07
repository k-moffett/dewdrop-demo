package com.example.demo.api.account.create;

import com.example.demo.api.account.AbstractAccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateAccountController extends AbstractAccountController {
    @Autowired
    CreateAccountUseCase createAccountUseCase;

    @PostMapping(MAPPING)
    public ResponseEntity<CreateAccountCommand> create(@RequestBody CreateAccountCommand createAccountCommand) {
        return createAccountUseCase.execute(createAccountCommand);
    }
}
