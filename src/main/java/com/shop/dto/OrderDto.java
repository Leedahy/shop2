package com.shop.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
public class OrderDto {

  @NotNull(message = "상품 아이디가 비어있습니다.")
  private Long itemId;

  @Min(value = 1, message = "1개 이상 담아주세요")
  @Max(value = 999, message = "999개 이상 담을 수 없습니다")
  private int count;
}
