package com.example.demo.usecase.user.get;

import com.dewdrop.Dewdrop;
import com.dewdrop.api.result.Result;
import com.dewdrop.api.result.ResultException;
import com.example.demo.data.read.user.GetUserDetailsByIdQuery;
import com.example.demo.data.read.user.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class GetUserDetailsByIdUseCase {

    @Autowired
    Dewdrop dewdrop;

    public ResponseEntity<UserDetailsDTO> execute(GetUserDetailsByIdQuery query) throws ResultException {
        Result<Object> result = dewdrop.executeQuery(query);

        if (result.isEmpty()) {
            return ResponseEntity.notFound()
                .build();
        }

        return ResponseEntity.ok((UserDetailsDTO) result.get());
    }
}
