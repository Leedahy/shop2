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

  public static OrderItem createOrderItem(Item item, int count) {
    OrderItem orderItem = new OrderItem();
    orderItem.setItem(item);
    orderItem.setCount(count);
    orderItem.setOrderPrice(item.getPrice());

    item.removeStock(count);
    return orderItem;
  }

  public int getTotalPrice() {
    return orderPrice*count;
  }

  //주문 취소 시 그만큼 재고 증가
  public void cancel() {
    this.getItem().addStock(count);
  }
}
