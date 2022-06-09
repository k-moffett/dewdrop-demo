package com.example.demo.commons.read.account.accountdetails;

import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.dewdrop.read.readmodel.annotation.PrimaryCacheKey;
import com.example.demo.commons.write.account.event.AccountCreatedEvent;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDTO {

    @PrimaryCacheKey
    UUID accountId;
    UUID ownerId;

    @EventHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.ownerId = event.getOwnerId();
    }

}
