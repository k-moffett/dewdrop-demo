package com.example.demo.usecase.user.create;

import com.example.demo.data.write.user.command.CreateUserCommand;
import com.example.demo.usecase.user.AbstractUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUserController extends AbstractUserController {

    @Autowired
    CreateUserUseCase createAccountUseCase;

    @PostMapping(MAPPING)
    public ResponseEntity create(@RequestBody CreateUserCommand createUserCommand) {
        return createAccountUseCase.execute(createUserCommand);
    }
}
