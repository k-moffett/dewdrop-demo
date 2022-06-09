package com.example.demo.data.write.account.event;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.read.readmodel.annotation.CreationEvent;
import com.dewdrop.structure.api.Event;
import com.example.demo.common.enums.AccountType;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CreationEvent
public class AccountCreatedEvent extends Event {

    @AggregateId
    private UUID accountId;
    private UUID ownerId;
    private List<UUID> adminUserIds;
    private List<UUID> userIds;
    private AccountType accountType;

    public AccountCreatedEvent(UUID accountId, UUID ownerId, List<UUID> adminUserIds, List<UUID> userIds, AccountType accountType) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.adminUserIds = adminUserIds;
        this.userIds = userIds;
        this.accountType = accountType;
    }

}
