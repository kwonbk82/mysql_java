package com.macademy.shop.item.mapper;

import com.macademy.shop.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    int itemInsert(ItemDto itemDto);
    List<ItemDto> itemListAll();
}
