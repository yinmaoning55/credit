package com.neuedu.credit.pojo.enums;


public enum Authentication implements IEnums{
    NO_AUTHENTICATION("未认证",0),
    PERSON_AUTHENTICATION("个人认证",1),
    /**
     * 企业认证
     */
    ENTERPRISE_AUTHENTICATION("企业认证",2),
    MANAGER_AUTHENTICATION("后台管理",-1);

    private String name;
    private int index;
    Authentication(String name, int index) {
        this.name = name;
        this.index = index;
    }
    @Override
    public int getCode(){
        return this.index;
    }

    @Override
    public String getMessage(){
        return this.name;
    }
}
