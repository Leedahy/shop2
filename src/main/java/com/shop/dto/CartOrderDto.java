package com.shop.dto;

import lombok.*;

import java.util.List;

@Getter @Setter
public class CartOrderDto {

  private Long cartItemId;

  private List<CartOrderDto> cartOrderDtoList;
}
