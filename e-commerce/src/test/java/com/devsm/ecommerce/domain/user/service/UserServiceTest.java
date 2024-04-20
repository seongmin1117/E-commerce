package com.devsm.ecommerce.domain.user.service;

import com.devsm.ecommerce.common.ServiceTest;
import com.devsm.ecommerce.common.UserBuilder;
import com.devsm.ecommerce.domain.user.entity.User;
import com.devsm.ecommerce.domain.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest extends ServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBuilder userBuilder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    @DisplayName("회원가입이 성공한다.")
    void signUp() {

        // Given
        SignUpRequestDto dto = new SignUpRequestDto();
        dto.setEmail("test@example.com");
        dto.setPassword("password");
        dto.setUsername("testUser");
        dto.setPhoneNumber("1234567890");
        dto.setAddress("123 Test St, Test City");

        // When
            String password = dto.getPassword();
            dto.setPassword(bCryptPasswordEncoder.encode(password));
            User savedUser = userRepository.save(new User(dto));

        // Then
        assertNotNull(savedUser.getId());
        assertEquals(dto.getEmail(), savedUser.getEmail());
    }

}