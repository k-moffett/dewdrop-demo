package com.example.demo.data.read.user;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetUserDetailsByIdQuery {

    private UUID id;
}
