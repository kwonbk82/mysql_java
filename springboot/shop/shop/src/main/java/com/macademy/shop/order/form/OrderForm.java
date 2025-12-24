package com.macademy.shop.order.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderForm {
    @NotNull(message = "상품 아이디는 필수")
    private Long itemId;
    @Min(value=1,message="최소 1개는 주문하십쇼")
    @Max(value=100,message="최대 주문 수량은 100개")
    private int count;
}
