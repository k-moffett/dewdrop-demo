package com.example.demo.data.read.user;

import com.dewdrop.api.result.Result;
import com.dewdrop.read.readmodel.annotation.DewdropCache;
import com.dewdrop.read.readmodel.annotation.ReadModel;
import com.dewdrop.read.readmodel.annotation.Stream;
import com.dewdrop.read.readmodel.query.QueryHandler;
import java.util.Map;
import java.util.UUID;

@ReadModel(resultClass = UserDetailsDTO.class)
@Stream(name = "UserAggregate")
@Stream(name = "UserAggregate", subscribed = false)
public class UserDetailsReadModel {

    @DewdropCache
    Map<UUID, UserDetailsDTO> cache;

    @QueryHandler
    public Result<UserDetailsDTO> handle(GetUserDetailsByIdQuery query) {
        UserDetailsDTO userDetailsDTO = cache.get(query.getId());
        if (userDetailsDTO != null) {return Result.of(userDetailsDTO);}
        return Result.empty();
    }
}
