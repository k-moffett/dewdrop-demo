package com.example.demo.api.account.create;

import com.dewdrop.Dewdrop;
import com.example.demo.config.DewdropConfig;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountUseCase {

    Dewdrop dewdrop = DewdropConfig.getInstance();

    public ResponseEntity execute(CreateAccountCommand createAccountCommand) {
        createAccountCommand.setId(UUID.randomUUID());
        dewdrop.executeCommand(createAccountCommand);

        return ResponseEntity.ok(createAccountCommand);
    }
}
