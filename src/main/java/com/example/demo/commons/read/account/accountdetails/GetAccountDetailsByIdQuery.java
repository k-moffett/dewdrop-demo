package com.example.demo.commons.read.account.accountdetails;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAccountDetailsByIdQuery {

    private UUID id;
}
