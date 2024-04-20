package com.devsm.ecommerce.domain.auth.controller;

import com.devsm.ecommerce.domain.auth.dto.request.SignInRequestDto;
import com.devsm.ecommerce.domain.auth.dto.response.SignInResponseDto;
import com.devsm.ecommerce.domain.auth.service.AuthService;
import com.devsm.ecommerce.domain.auth.dto.request.SignUpRequestDto;
import com.devsm.ecommerce.domain.auth.dto.response.SignUpResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final AuthService authService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "auth-ok";
    }

    @PostMapping("/sign-up")
    public ResponseEntity<? super SignUpResponseDto> singUp(@RequestBody @Valid SignUpRequestDto dto){
        return authService.signUp(dto);
    }
    @PostMapping("/sign-in")
    public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto dto){
        return authService.signIn(dto);
    }
}
