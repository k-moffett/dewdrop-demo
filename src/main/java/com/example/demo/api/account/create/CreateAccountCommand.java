package com.example.demo.api.account.create;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.structure.api.Command;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateAccountCommand extends Command {

    @AggregateId
    UUID id;
    String name;
    String email;

    @Builder(buildMethodName = "create")
    public CreateAccountCommand(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
