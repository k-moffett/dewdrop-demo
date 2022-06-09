package com.example.demo.data.write.account.command;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.structure.api.Command;
import com.example.demo.common.enums.AccountType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
public class CreateAccountCommand extends Command {

    @AggregateId
    UUID accountId;
    @NonNull
    UUID ownerId;
    List<UUID> adminUserIds;
    List<UUID> userIds;
    AccountType accountType;

    @Builder(buildMethodName = "create")
    public CreateAccountCommand(UUID accountId, @NonNull UUID ownerId, List<UUID> adminUserIds, List<UUID> userIds, @NonNull AccountType accountType) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.adminUserIds = adminUserIds;
        this.userIds = userIds;
        this.accountType = accountType;
    }
}
