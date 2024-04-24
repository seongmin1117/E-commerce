package com.devsm.ecommerce.domain.user.controller;

import com.devsm.ecommerce.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("health-check")
    public String healthCheck(){
        return "user-ok";
    }


}
