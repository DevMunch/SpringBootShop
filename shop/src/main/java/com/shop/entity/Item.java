package com.shop.entity;

import com.shop.constant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity // Item 클래스를 entity로 선언
@Table(name="item") // 어떤 테이블과 매핑될지를 지정
@Getter
@Setter
@ToString
public class Item {

    @Id // id를 기본키로 설정
    @Column(name="item_id") // item 테이블의 item_id 컬럼이 매핑되도록 설정
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본키 전략을 JPA가 자동으로 지정하도록 설정
    private Long id; //상품 코드

    @Column(nullable = false, length=50) // not null로 설정하고 String는 기본이 255이므로 50으로 세팅
    private String itemNm; //상품명

    @Column(name="price", nullable=false)
    private int price; //가격

    @Column(nullable=false)
    private int stockNumber; //재고 수령

    @Lob
    @Column(nullable = false)
    private String itemDetail; //상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; //상품 판매 상태

    private LocalDateTime regTime; //등록 시간

    private LocalDateTime updateTime; //수정시간
}
