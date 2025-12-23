package com.macademy.shop.item.dto;

import com.macademy.shop.item.constant.ItemSellStatus;
import lombok.Data;

@Data
public class ItemSearchDto {
    private String searchDataType;
    private ItemSellStatus searchSellStatus;
    private String searchBy;
    private String searchText="";

}
