package com.example.demo.data.read.account.accountdetails;

import com.dewdrop.read.readmodel.annotation.EventHandler;
import com.dewdrop.read.readmodel.annotation.PrimaryCacheKey;
import com.example.demo.common.enums.AccountStatus;
import com.example.demo.common.enums.AccountType;
import com.example.demo.data.write.account.event.AccountCreatedEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDetailsDTO {

    @PrimaryCacheKey
    UUID accountId;
    UUID ownerId;
    private List<UUID> adminUserIds;
    private List<UUID> userIds;
    private AccountType accountType;
    private AccountStatus accountStatus = AccountStatus.ACTIVE;
    private BigDecimal balance = BigDecimal.ZERO;

    @EventHandler
    public void on(AccountCreatedEvent event) {
        this.accountId = event.getAccountId();
        this.ownerId = event.getOwnerId();
        this.adminUserIds = new ArrayList<>();
        this.userIds = new ArrayList<>();
        this.accountType = event.getAccountType();
    }

}
