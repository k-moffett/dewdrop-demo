package com.example.demo.usecase.account.create;

import com.example.demo.data.write.account.command.CreateAccountCommand;
import com.example.demo.usecase.account.AbstractAccountController;
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
    public ResponseEntity create(@RequestBody CreateAccountCommand createAccountCommand) {
        return createAccountUseCase.execute(createAccountCommand);
    }
}
