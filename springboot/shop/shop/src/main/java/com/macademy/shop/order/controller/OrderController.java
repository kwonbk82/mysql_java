package com.macademy.shop.order.controller;

import com.macademy.shop.config.PageHandler;
import com.macademy.shop.member.service.MemberService;
import com.macademy.shop.order.dto.OrderHistDto;
import com.macademy.shop.order.form.OrderForm;
import com.macademy.shop.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;

    @PostMapping("/order")
    public @ResponseBody ResponseEntity order(@RequestBody @Valid OrderForm orderForm
                                                , BindingResult bindingResult
                                                , Principal principal){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for(FieldError fieldError : fieldErrors){
                sb.append(fieldError.getDefaultMessage());
            }
            return new ResponseEntity<String>(sb.toString(), HttpStatus.BAD_REQUEST);
        }
        String id = principal.getName();
        Long orderId;
        try {
            orderId=orderService.createOrder(orderForm,id);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Long>(orderId,HttpStatus.OK);
    }

    @GetMapping(value = {"/orders","/orders/{page}"})
    public String OrderHist(@PathVariable(value="page",required = false) Integer page
                            , @ModelAttribute("orderHistDto")OrderHistDto orderHistDto
                            , Principal principal
                            , Model model){
        int ps =4;
        Map map = new HashMap();
        if(page == null ) page=1;

        map.put("offset",page*ps-ps);
        map.put("pageSize",ps);

        Long memberId = memberService.findMemberId(principal.getName());
        map.put("memberId",memberId);

        int totalCnt = orderService.orderCount(map);
        PageHandler pageHandler = new PageHandler(totalCnt,ps,page);

        List<OrderHistDto> orderHist=  orderService.orderSelect(map);

        model.addAttribute("offset",page);
        model.addAttribute("orderHist",orderHist);
        model.addAttribute("pageHandler",pageHandler);

        return "order/orderHist";
    }
}
