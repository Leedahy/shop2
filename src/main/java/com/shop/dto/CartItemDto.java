package com.shop.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class CartItemDto {

  @NotNull(message = "상품 아이디는 반드시 필요합니다.")
  private Long itemId;

  @Min(value = 1, message = "최소 1개 이상 담아주세요")
  private int count;
}
