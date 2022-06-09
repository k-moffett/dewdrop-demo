package com.example.demo.data.aggregate;

import com.dewdrop.aggregate.annotation.Aggregate;
import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.command.CommandHandler;
import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.example.demo.common.enums.AccountStatus;
import com.example.demo.common.enums.AccountType;
import com.example.demo.data.write.account.command.CreateAccountCommand;
import com.example.demo.data.write.account.event.AccountCreatedEvent;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
@Aggregate
public class AccountAggregate {

    @AggregateId
    private UUID accountId;
    private UUID ownerID;
    private List<UUID> adminUserIds;
    private List<UUID> userIds;
    private AccountType accountType;
    private AccountStatus accountStatus = AccountStatus.ACTIVE;
    private BigDecimal balance = BigDecimal.ZERO;

    public AccountAggregate() {}

    @CommandHandler
    public AccountCreatedEvent handle(CreateAccountCommand command) {
        return new AccountCreatedEvent(command.getAccountId(), command.getOwnerId(), command.getAdminUserIds(), command.getUserIds(), command.getAccountType());
    }

    @EventHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.ownerID = event.getOwnerId();
        this.adminUserIds = event.getAdminUserIds();
        this.userIds = event.getUserIds();
        this.accountType = event.getAccountType();
    }
}
