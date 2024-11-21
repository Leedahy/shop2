package com.shop.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

@Getter @Setter
public class MainItemDto {

  private Long id;

  private String itemNM;

  private String itemDetail;

  private String imgUrl;

  private Integer price;

  @QueryProjection
  public MainItemDto(Long id, String itemNM, String itemDetail, String imgUrl, Integer price) {

    this.id = id;
    this.itemNM = itemNM;
    this.itemDetail = itemDetail;
    this.imgUrl = imgUrl;
    this.price = price;
  }


}
