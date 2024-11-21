package com.shop.dto;

import com.shop.entity.OrderItem;
import lombok.*;

@Getter @Setter
public class OrderItemDto {

  public OrderItemDto(OrderItem orderItem, String imgUrl) {
    this.itemNM = orderItem.getItem().getItemNM();
    this.count = orderItem.getCount();
    this.orderPrice = orderItem.getOrderPrice();
    this.imgUrl = imgUrl;
  }

  private String itemNM;

  private int count;

  private int orderPrice;

  private String imgUrl;
}
