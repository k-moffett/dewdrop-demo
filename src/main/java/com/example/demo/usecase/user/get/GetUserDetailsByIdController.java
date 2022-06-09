package com.example.demo.usecase.user.get;

import com.dewdrop.api.result.ResultException;
import com.example.demo.commons.read.user.GetUserDetailsByIdQuery;
import com.example.demo.commons.read.user.UserDetailsDTO;
import com.example.demo.usecase.user.AbstractUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUserDetailsByIdController extends AbstractUserController {

    @Autowired
    GetUserDetailsByIdUseCase getUserDetailsByIdUseCase;

    @GetMapping(MAPPING + "/{id}")
    public ResponseEntity<UserDetailsDTO> create(GetUserDetailsByIdQuery query) throws ResultException {
        return getUserDetailsByIdUseCase.execute(query);
    }
}
