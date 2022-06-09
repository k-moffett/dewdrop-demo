package com.example.demo.data.read.account.accountdetails;

import com.dewdrop.api.result.Result;
import com.dewdrop.read.readmodel.annotation.DewdropCache;
import com.dewdrop.read.readmodel.annotation.ReadModel;
import com.dewdrop.read.readmodel.annotation.Stream;
import com.dewdrop.read.readmodel.query.QueryHandler;
import java.util.Map;
import java.util.UUID;

@ReadModel(resultClass = AccountDetailsDTO.class)
@Stream(name = "AccountAggregate")
@Stream(name = "AccountAggregate", subscribed = false)
public class AccountDetailsReadModel {

    @DewdropCache
    Map<UUID, AccountDetailsDTO> cache;

    @QueryHandler
    public Result<AccountDetailsDTO> handle(GetAccountDetailsByIdQuery query) {
        AccountDetailsDTO accountDetailsDTO = cache.get(query.getId());
        if (accountDetailsDTO != null) {return Result.of(accountDetailsDTO);}
        return Result.empty();
    }
}
