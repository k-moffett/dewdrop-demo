package com.example.demo.data.write.user.event;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.read.readmodel.annotation.CreationEvent;
import com.dewdrop.structure.api.Event;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@CreationEvent
public class UserCreatedEvent extends Event {

    @AggregateId
    UUID userId;
    String name;
    String email;

    public UserCreatedEvent(UUID userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }
}
