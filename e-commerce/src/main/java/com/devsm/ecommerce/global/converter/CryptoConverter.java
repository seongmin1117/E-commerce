package com.devsm.ecommerce.global.converter;

import com.devsm.ecommerce.global.util.AesUtil;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@Converter
@RequiredArgsConstructor
public class CryptoConverter implements AttributeConverter<String,String>{

    private final AesUtil aesUtil;

    @Override
    public String convertToDatabaseColumn(String plainText) {
        if (plainText == null) return null;

        try {
            return aesUtil.aesEncrypt(plainText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String convertToEntityAttribute(String encryptedText) {
        if (encryptedText == null) return null;
        try {
            System.out.println(encryptedText);
            return aesUtil.aesDecrypt(encryptedText);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
