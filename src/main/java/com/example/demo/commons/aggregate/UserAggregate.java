package com.example.demo.commons.aggregate;

import com.dewdrop.aggregate.annotation.Aggregate;
import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.command.CommandHandler;
import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.example.demo.commons.write.user.command.CreateUserCommand;
import com.example.demo.commons.write.user.event.UserCreatedEvent;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@Aggregate
public class UserAggregate {

    @AggregateId
    private UUID userId;
    private String name;
    private String email;
    private List<UUID> accountIds;

    public UserAggregate() {}

    @CommandHandler
    public UserCreatedEvent handle(CreateUserCommand command) {
        return new UserCreatedEvent(command.getUserId(), command.getName(), command.getEmail());
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        this.userId = event.getUserId();
        this.name = event.getName();
        this.email = event.getEmail();
    }
}
