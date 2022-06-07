package com.example.demo.api.account.get;

import com.dewdrop.aggregate.annotation.AggregateId;
import com.dewdrop.structure.api.Command;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
public class GetAccountByIdQuery extends Command {

    @AggregateId
    UUID id;

    @Builder(buildMethodName = "create")
    public GetAccountByIdQuery(UUID id) {
        this.id = id;
    }
}
