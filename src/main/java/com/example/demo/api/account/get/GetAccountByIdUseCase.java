package com.example.demo.api.account.get;

import com.dewdrop.Dewdrop;
import com.dewdrop.api.result.Result;
import com.dewdrop.api.result.ResultException;
import com.example.demo.config.DewdropConfig;
import java.util.ArrayList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetAccountByIdUseCase {

    Dewdrop dewdrop = DewdropConfig.getInstance();

    public ResponseEntity<?> execute(GetAccountByIdQuery query) throws ResultException {
        // TODO Fix casting once Result is updated to be generic
        Result<?> accountAggregate = dewdrop.executeCommand(query);

        ArrayList thisShouldBeFixed = (ArrayList) accountAggregate.get();
        // TODO Why does isEmpty return an empty array
        //if (accountAggregate.isEmpty()) {
        if (thisShouldBeFixed.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }

        return ResponseEntity.ok(accountAggregate);
    }
}
