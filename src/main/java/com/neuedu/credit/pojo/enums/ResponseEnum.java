package com.neuedu.credit.pojo.enums;

/**
 * @Created by elvin on 2018/9/26 11:50.
 * @Describe:
 */
public enum ResponseEnum implements IEnums {
    SUCESSFUL("请求成功",0),
    FAILED("请求失败",-1);

    private String message;
    private int code;

    ResponseEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public int getCode(){
        return this.code;
    }

    @Override
    public String getMessage(){
        return this.message;
    }
}
