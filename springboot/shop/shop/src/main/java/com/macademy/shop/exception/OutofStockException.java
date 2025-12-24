package com.macademy.shop.exception;

public class OutofStockException extends RuntimeException{
    public OutofStockException(String msg){
        super(msg);
    }
}
