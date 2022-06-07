package com.example.demo.data.read.account;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAccountByIdQuery {
    private UUID id;
}
