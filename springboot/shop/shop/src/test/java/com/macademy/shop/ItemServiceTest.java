package com.macademy.shop;

import com.macademy.shop.item.dto.ItemDto;
import com.macademy.shop.item.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;

    @Test
    @DisplayName("상품등록테스트")
    public void createItemTest(){
        ItemDto item = new ItemDto();
        item.setItemName("파프니르 가드");
        item.setPrice(100000);
        item.setItemDetail("카오스벨룸의 조각 10개");
        item.setItemSellStatus("SELL");
        item.setStockNumber(2);

        int result = itemService.itemInsert(item);
        assertThat(result).isEqualTo(1);

    }

    @Test
    public void itemListAllTest(){
        List<ItemDto> itemLists = itemService.itemListAll();
        assertThat(itemLists).isNotEmpty();

    }
}
