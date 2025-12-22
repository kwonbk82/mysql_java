package com.macademy.shop.item.service;

import com.macademy.shop.item.dto.ItemDto;
import com.macademy.shop.item.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private ItemMapper itemMapper;
    public int itemInsert(ItemDto itemDto){
        return itemMapper.itemInsert(itemDto);
    }
    public List<ItemDto> itemListAll(){
        return itemMapper.itemListAll();
    }
    public ItemForm getItemDtl(Long itemId) {
        ItemDto itemDto = itemMapper.selectItem(itemId);
        if (itemDto == null) throw new NullPointerException("상품이 존재하지 않음");
        ItemForm itemForm = makeItemForm(itemDto);
        itemForm.setItemImgList(itemMapper.selectItemImgId(itemId));
        return itemForm;
    }
}
