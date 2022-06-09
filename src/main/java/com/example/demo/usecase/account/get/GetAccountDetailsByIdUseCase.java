package com.example.demo.usecase.account.get;

import com.dewdrop.Dewdrop;
import com.dewdrop.api.result.Result;
import com.dewdrop.api.result.ResultException;
import com.example.demo.commons.read.account.accountdetails.AccountDetailsDTO;
import com.example.demo.commons.read.account.accountdetails.GetAccountDetailsByIdQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetAccountDetailsByIdUseCase {

    @Autowired
    Dewdrop dewdrop;

    public ResponseEntity<AccountDetailsDTO> execute(GetAccountDetailsByIdQuery query) throws ResultException {
        Result<Object> result = dewdrop.executeQuery(query);

        if (result.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }

        return ResponseEntity.ok((AccountDetailsDTO) result.get());
    }
}
