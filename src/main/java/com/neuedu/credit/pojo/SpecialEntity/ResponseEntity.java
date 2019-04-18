package com.neuedu.credit.pojo.SpecialEntity;

import com.neuedu.credit.pojo.enums.ResponseEnum;

/**
 * @Created by elvin on 2018/9/26 11:46.
 * @Describe:
 */
public class ResponseEntity {
    private int Code;
    private String Message;
    private Object object;

    public ResponseEntity(ResponseEnum responseEnum){
        this.Code = responseEnum.getCode();
        this.Message = responseEnum.getMessage();
    }

    public ResponseEntity(ResponseEnum responseEnum,Object data){
        this(responseEnum);
        this.object = data;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
