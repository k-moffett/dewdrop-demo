package com.example.demo.commons.write.account.command;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.structure.api.Command;
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

    @Builder(buildMethodName = "create")
    public CreateAccountCommand(UUID accountId, UUID ownerId, List<UUID> adminUserIds, List<UUID> userIds) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.adminUserIds = adminUserIds;
        this.userIds = userIds;
    }
}
