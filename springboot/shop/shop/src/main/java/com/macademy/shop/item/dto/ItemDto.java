package com.macademy.shop.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Long itemId;
    private String itemName;
    private Integer price;
    private Integer stockNumber;
    private String itemDetail;
    private String itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;

}
