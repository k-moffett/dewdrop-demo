package com.example.demo.commons.write.account.event;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.read.readmodel.annotation.CreationEvent;
import com.dewdrop.structure.api.Event;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CreationEvent
public class AccountCreatedEvent extends Event {
    @AggregateId
    UUID id;
    String name;
    String email;

    public AccountCreatedEvent(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
