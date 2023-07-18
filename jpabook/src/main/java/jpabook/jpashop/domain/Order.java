package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long Id;
    @Column(name="MEMBER_ID")
    private Long memberId;          //관계형 디비의 맞춤 설계 -> 객체지향적이지 않다.
    private LocalDateTime orderDAte;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDAte() {
        return orderDAte;
    }

    public void setOrderDAte(LocalDateTime orderDAte) {
        this.orderDAte = orderDAte;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
