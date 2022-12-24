package com.example.zoomrentals.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountRequest {

    @NotBlank
    private String accountName;
    @NotBlank
    private String accountNumber;
}
