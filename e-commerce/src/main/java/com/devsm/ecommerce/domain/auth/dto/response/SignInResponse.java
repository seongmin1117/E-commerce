package com.devsm.ecommerce.domain.auth.dto.response;

import com.devsm.ecommerce.global.response.ResponseCode;
import com.devsm.ecommerce.global.response.ResponseDto;
import com.devsm.ecommerce.global.response.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SignInResponse {
    private String token;
    private int expirationTime;

    public SignInResponse(String token) {
        this.token = token;
        this.expirationTime = 3600;
    }
}
