package com.example.demo.data.read.user;

import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.dewdrop.read.readmodel.annotation.PrimaryCacheKey;
import com.example.demo.data.write.user.event.UserCreatedEvent;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailsDTO {

    @PrimaryCacheKey
    UUID userId;
    String name;
    String email;

    @EventHandler
    public void on(UserCreatedEvent event) {
        this.userId = event.getUserId();
        this.name = event.getName();
        this.email = event.getEmail();
    }
}
