package com.example.demo.usecase.account.create;

import com.dewdrop.Dewdrop;
import com.example.demo.commons.write.account.command.CreateAccountCommand;
import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountUseCase {

    @Autowired
    Dewdrop dewdrop;

    public ResponseEntity execute(CreateAccountCommand createAccountCommand) {
        createAccountCommand.setId(UUID.randomUUID());
        dewdrop.executeCommand(createAccountCommand);
        return ResponseEntity.created(URI.create("localhost:8080/account/" + createAccountCommand.getId()))
            .build();
    }
}
