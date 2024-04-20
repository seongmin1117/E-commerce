package com.devsm.ecommerce.domain.user.entity;

import com.devsm.ecommerce.global.BaseEntity;
import com.devsm.ecommerce.global.converter.CryptoConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = CryptoConverter.class)
    private String email;

    private String password;

    @Convert(converter = CryptoConverter.class)
    private String username;

    @Convert(converter = CryptoConverter.class)
    private String phoneNumber;

    @Convert(converter = CryptoConverter.class)
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role;




}
