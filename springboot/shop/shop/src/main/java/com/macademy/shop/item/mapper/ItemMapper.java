package com.macademy.shop.item.mapper;

import com.macademy.shop.item.dto.ItemDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    int itemInsert(ItemDto itemDto);
    List<ItemDto> itemListAll();
    ItemDto selectItem(Long itemId);
           List<ItemImgDto> selectItemImg(Long itemId);
    ItemImgDto selectItemImgId(Long itemImgId);
    int updateItem(ItemDto itemDto);
    int updateItemImg(ItemImgDto itemImgDto);
}
