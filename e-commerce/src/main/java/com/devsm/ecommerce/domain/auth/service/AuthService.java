package com.devsm.ecommerce.domain.auth.service;

import com.devsm.ecommerce.domain.auth.dto.request.SignInRequestDto;
import com.devsm.ecommerce.domain.auth.dto.request.SignUpRequestDto;
import com.devsm.ecommerce.domain.auth.dto.response.SignInResponseDto;
import com.devsm.ecommerce.domain.auth.dto.response.SignUpResponseDto;
import com.devsm.ecommerce.domain.user.entity.Role;
import com.devsm.ecommerce.domain.user.entity.User;
import com.devsm.ecommerce.domain.user.repository.UserRepository;
import com.devsm.ecommerce.global.jwt.JwtProvider;
import com.devsm.ecommerce.global.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtProvider jwtProvider;


    // 회원가입
    public ResponseEntity<? super SignUpResponseDto> signUp (SignUpRequestDto dto) {
        try {
            String email = dto.getEmail();
            if (userRepository.existsByEmail(email)) return SignUpResponseDto.duplicateEmail();

            String phoneNumber = dto.getPhoneNumber();
            if(userRepository.existsByPhoneNumber(phoneNumber)) return SignUpResponseDto.duplicatePhoneNumber();

            String password = dto.getPassword();
            dto.setPassword(bCryptPasswordEncoder.encode(password));
            userRepository.save(User.builder()
                            .email(dto.getEmail())
                            .password(dto.getPassword())
                            .username(dto.getUsername())
                            .phoneNumber(dto.getPhoneNumber())
                            .address(dto.getAddress())
                            .role(Role.ROLE_USER)
                    .build());
        }
        catch (Exception e) {
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

     // 로그인
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

            String token = null;
            try {
                String email = dto.getEmail();

                User user = userRepository.findByEmail(email);
                if (user == null) return SignInResponseDto.signInFailed();

                String password = dto.getPassword();
                String encodedPassword = user.getPassword();
                boolean isMatched = bCryptPasswordEncoder.matches(password, encodedPassword);
                if (!isMatched) return SignInResponseDto.signInFailed();

                String role = user.getRole().toString();

                token = jwtProvider.create(email,role,3600);

            } catch (Exception e){
                return ResponseDto.databaseError();
            }


            return SignInResponseDto.success(token);
    }
}
