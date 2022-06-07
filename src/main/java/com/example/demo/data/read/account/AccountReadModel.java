package com.example.demo.data.read.account;

import com.dewdrop.api.result.Result;
import com.dewdrop.read.readmodel.annotation.DewdropCache;
import com.dewdrop.read.readmodel.annotation.ReadModel;
import com.dewdrop.read.readmodel.annotation.Stream;
import com.dewdrop.read.readmodel.query.QueryHandler;
import com.example.demo.data.aggregate.AccountAggregate;
import java.util.Map;
import java.util.UUID;

@ReadModel(resultClass = AccountAggregate.class)
@Stream(name = "AccountAggregate")
@Stream(name = "AccountAggregate", subscribed = false)
public class AccountReadModel {

    @DewdropCache
    Map<UUID, AccountAggregate> cache;

    @QueryHandler
    public Result<AccountAggregate> handle(GetAccountByIdQuery query) {
        AccountAggregate account = cache.get(query.getId());
        if (account != null) {return Result.of(account);}
        return Result.empty();
    }
}
