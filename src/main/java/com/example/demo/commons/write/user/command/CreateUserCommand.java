package com.example.demo.commons.write.user.command;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.structure.api.Command;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateUserCommand extends Command {
    @AggregateId
    UUID userId;
    String name;
    String email;

    @Builder(buildMethodName = "create")
    public CreateUserCommand(UUID userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
