package com.example.demo.data.aggregate;

import com.dewdrop.aggregate.annotation.Aggregate;
import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.command.CommandHandler;
import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.dewdrop.read.readmodel.annotation.PrimaryCacheKey;
import com.example.demo.api.account.create.AccountCreatedEvent;
import com.example.demo.api.account.create.CreateAccountCommand;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@Aggregate
public class AccountAggregate {

    @PrimaryCacheKey
    @AggregateId
    UUID id;
    String name;
    String email;

    public AccountAggregate() {}

    @CommandHandler
    public List<AccountCreatedEvent> handle(CreateAccountCommand command) {
        return List.of(new AccountCreatedEvent(command.getId(), command.getName(), command.getEmail()));
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
    }
}
