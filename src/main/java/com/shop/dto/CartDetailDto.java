package com.shop.dto;

import lombok.*;

@Getter @Setter
public class CartDetailDto {

  private Long cartItemId;

  private String itemNM;

  private int price;

  private int count;

  private String imgUrl;

  public CartDetailDto(Long cartItemId, String itemNM, int price, int count, String imgUrl) {
    this.cartItemId = cartItemId;
    this.itemNM = itemNM;
    this.price = price;
    this.count = count;
    this.imgUrl = imgUrl;
  }
}
