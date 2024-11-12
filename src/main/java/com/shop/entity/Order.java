package com.shop.entity;


import com.shop.constant.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order extends BaseEntity {

  @Id
  @GeneratedValue
  @Column(name = "order_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY) //다대일관계
  @JoinColumn(name = "member_id")
  private Member member;

  private LocalDateTime orderDate;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;  //주문상태

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  //cascade 영속성 전이 설정 orphanRemoval 고아객체 사용
  private List<OrderItem> orderItems = new ArrayList<>();
  //orderItem은 주문 디테일로 생각하면 된다(order는 주문 헤더)

//  private LocalDateTime regTime;

//  private LocalDateTime updateTime;
}
