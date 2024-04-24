package com.devsm.ecommerce.domain.wishlist.controller;

import com.devsm.ecommerce.domain.wishlist.dto.request.AddWishListRequestDto;
import com.devsm.ecommerce.domain.wishlist.entity.Wishlist;
import com.devsm.ecommerce.domain.wishlist.service.WishListService;
import com.devsm.ecommerce.global.response.ResponseDto;
import com.devsm.ecommerce.global.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlist")
public class WishListController {
    private final WishListService wishListService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "wishlist health-check";
    }

    // 내 장바구니 조회
    @GetMapping("")
    public ResponseEntity<ResponseDto<Page<Wishlist>>> getWishList(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                                                   @RequestParam Pageable pageable) {
        String uuid = userDetails.getUsername();
        ResponseDto<Page<Wishlist>> response = wishListService.getWishList(uuid, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    // 장바구니에 추가
    @PostMapping("")
    public ResponseEntity<ResponseDto<Long>> addWishList(@AuthenticationPrincipal UserDetailsImpl userDetails, AddWishListRequestDto dto){
        String uuid = userDetails.getUsername();
        ResponseDto<Long> response = wishListService.addWishList(uuid, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
