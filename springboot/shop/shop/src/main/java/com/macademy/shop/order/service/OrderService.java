package com.macademy.shop.order.service;

import com.macademy.shop.member.dto.MemberDto;
import com.macademy.shop.member.mapper.MemberMapper;
import com.macademy.shop.order.dto.OrderDto;
import com.macademy.shop.order.dto.OrderHistDto;
import com.macademy.shop.order.form.OrderForm;
import com.macademy.shop.order.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;
    private final MemberMapper memberMapper;
    public int createOrder(OrderForm orderForm, String id){
        OrderDto orderDto = new OrderDto();
        MemberDto memberDto = memberMapper.loginMember(id);
//        orderDto.setMemberId (memberDto.getMemberId());
//        orderDto.setOrderStatus(OrderStatus.ORDER);

        orderMapper.insertOrder(orderDto);

        return orderDto;
    }
    public List<OrderHistDto> orderSelect(Map map) {
        return orderMapper.orderSelect(map);
    };
    public int orderCount(Map map){
        return orderMapper.orderCount(map);
    };
}
