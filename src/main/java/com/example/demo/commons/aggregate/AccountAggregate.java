package com.example.demo.commons.aggregate;

import com.dewdrop.aggregate.annotation.Aggregate;
import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.command.CommandHandler;
import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.example.demo.commons.write.account.command.CreateAccountCommand;
import com.example.demo.commons.write.account.event.AccountCreatedEvent;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@Aggregate
public class AccountAggregate {

    @AggregateId
    UUID accountId;
    UUID ownerID;
    List<UUID> adminUserIds;
    List<UUID> userIds;

    public AccountAggregate() {}

    @CommandHandler
    public AccountCreatedEvent handle(CreateAccountCommand command) {
        return new AccountCreatedEvent(command.getAccountId(), command.getOwnerId(), command.getAdminUserIds(), command.getUserIds());
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.ownerID = event.getOwnerId();
        this.adminUserIds = event.getAdminUserIds();
        this.userIds = event.getUserIds();
    }
}
