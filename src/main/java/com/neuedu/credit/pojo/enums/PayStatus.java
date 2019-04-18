package com.neuedu.credit.pojo.enums;

/**
 * @Created by elvin on 2018/10/9 14:34.
 * @Describe:
 */
public enum PayStatus implements IEnums {
    STATUS_CODE_NOT_PAID("等待支付",-5),
    STATUS_CODE_INVALID("订单已取消",-1),
    STATUS_CODE_UNPROCESSED("订单未处理",1),
    STATUS_CODE_PROCESSED_AND_VALID("订单已处理",2);

    private String message;
    private int code;
    PayStatus(String message, int code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
