package com.example.demo.commons.write.account.event;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.read.readmodel.annotation.CreationEvent;
import com.dewdrop.structure.api.Event;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CreationEvent
public class AccountCreatedEvent extends Event {

    @AggregateId
    UUID accountId;
    UUID ownerId;
    List<UUID> adminUserIds;
    List<UUID> userIds;

    public AccountCreatedEvent(UUID accountId, UUID ownerId, List<UUID> adminUserIds, List<UUID> userIds) {
        this.accountId = accountId;
        this.ownerId = ownerId;
        this.adminUserIds = adminUserIds;
        this.userIds = userIds;
    }

}
