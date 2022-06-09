package com.example.demo.usecase.account.create;

import com.dewdrop.Dewdrop;
import com.dewdrop.api.result.Result;
import com.example.demo.commons.read.user.GetUserDetailsByIdQuery;
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

        if (dewdrop.executeQuery(new GetUserDetailsByIdQuery(createAccountCommand.getOwnerId())).isEmpty()) {
            return ResponseEntity.status(404).body("User id: " + createAccountCommand.getOwnerId() + " not found.");
        }

        createAccountCommand.setAccountId(UUID.randomUUID());
        dewdrop.executeCommand(createAccountCommand);
        return ResponseEntity.created(URI.create("localhost:8080/account/" + createAccountCommand.getAccountId()))
            .build();
    }

}
