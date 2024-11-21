package com.shop.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter @Setter
@ToString
public class Cart extends BaseEntity {

  @Id
  @Column(name = "cart_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(fetch = FetchType.LAZY) //일대일관계 //지연 로딩 설정
  @JoinColumn(name = "member_id")
  private Member member;

  public static Cart createCart(Member member) {
    Cart cart = new Cart();
    cart.setMember(member);
    return cart;
  }
}
