package com.imooc.exception;

public class MyCustomException extends RuntimeException{
    public MyCustomException(String errorMsg){
        super(errorMsg);
    }
}
