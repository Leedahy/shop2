package com.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
//public class OrderItem {
public class OrderItem extends BaseEntity{

  @Id
  @GeneratedValue
  @Column(name = "order_item_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "item_id")
  private Item item;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id")
  private Order order;

  private int orderPrice;

  private int count;

//  private LocalDateTime regTime;  BaseEntity 상속 받으며 삭제

//  private LocalDateTime updateTime; BaseEntity 상속 받으며 삭제
}