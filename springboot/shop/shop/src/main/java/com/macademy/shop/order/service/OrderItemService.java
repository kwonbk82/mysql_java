package com.macademy.shop.order.service;

import com.macademy.shop.exception.OutofStockException;
import com.macademy.shop.item.dto.ItemDto;
import com.macademy.shop.item.mapper.ItemMapper;
import com.macademy.shop.order.dto.OrderItemDto;
import com.macademy.shop.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderItemService {
    private final OrderMapper orderMapper;
    private final ItemMapper itemMapper;
    private final OrderItemService orderItemService;
    public OrderItemDto createOrderItem(Long orderId, Long itemId, int count){
        OrderItemDto orderItemDto = new OrderItemDto();
        ItemDto itemDto = itemMapper.selectItem(itemId);
//        orderItemDto.setItemId(itemId);

        this.removeStock(itemDto,count);
        return orderItemDto;
    }
    public void removeStock(ItemDto itemDto, int stockNumber){
        int restStock = itemDto.getStockNumber()-stockNumber;
        if(restStock<0){
            throw new OutofStockException(
                    "상품의 재고가 부족합니다 (현재 수량 :"+itemDto.getStockNumber()+")"
            );
        }
        Map map = new HashMap();

        map.put("itemId",itemDto.getItemId());
        map.put("stockNumber",restStock);

        orderMapper.changeStock(map);
    }
    public int getTotalPrice(int price,int count){
        return price*count;
    }
}
