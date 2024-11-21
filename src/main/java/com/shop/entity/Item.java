package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import com.shop.dto.ItemFormDto;
import com.shop.exception.OutOfStockException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "item")
@Getter
@Setter
@ToString
public class Item extends BaseEntity {

    @Id
    @Column(name = "itme_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //상품코드

    @Column(nullable = false, length = 50)
    private String itemNM; //상품명

    @Column(name = "price", nullable = false)
    private int price;  //가격

    @Column(nullable = false)
    private int stockNum;   //재고수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  //상품 판매 여부

//    private LocalDateTime regTime;  //등록 시간

//    private LocalDateTime updateTime;   //수정 시간

    //상품 업데이트 로직
    public void updateItem(ItemFormDto itemFormDto) {
        this.itemNM = itemFormDto.getItemNM();
        this.price = itemFormDto.getPrice();
        this.stockNum = itemFormDto.getStockNum();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }

    public void removeStock(int stockNum) {
        int restStock = this.stockNum - stockNum;
        if(restStock < 0) {
            throw new OutOfStockException("상품의 재고가 부족합니다." +
            "(현재 재고: " + this.stockNum + ")");
        }
        this.stockNum = restStock;
    }

    public void addStock(int stockNum) {
        this.stockNum += stockNum;
    }
}
