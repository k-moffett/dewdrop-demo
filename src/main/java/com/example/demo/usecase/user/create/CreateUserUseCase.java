package com.example.demo.usecase.user.create;

import com.dewdrop.Dewdrop;
import com.example.demo.data.write.user.command.CreateUserCommand;
import java.net.URI;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCase {

    @Autowired
    Dewdrop dewdrop;

    public ResponseEntity execute(CreateUserCommand createUserCommand) {
        createUserCommand.setUserId(UUID.randomUUID());
        dewdrop.executeCommand(createUserCommand);
        return ResponseEntity.created(URI.create("localhost:8080/user/" + createUserCommand.getUserId()))
            .build();
    }
}
