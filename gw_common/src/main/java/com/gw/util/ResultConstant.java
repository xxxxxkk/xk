package com.gw.util;

public enum ResultConstant {
    SUCCESS("000000", "操作成功"),

    PARAM_ERROR("000101", "参数错误"),

    SYS_ERROR("000102", "系统错误"),

    BUS_ERROR("000103", "业务错误"),

    AUTH_ERROR("000104", "账号错误"),

    JWT_ERROR("000105", "token无效"),

    CODE_ERROR("000106", "验证码错误");
    private String resCode;
    private String resDesc;

    private ResultConstant(String resCode, String resDesc) {
        this.resCode = resCode;
        this.resDesc = resDesc;
    }

    public String getResCode() {
        return this.resCode;
    }

    public String getResDesc() {
        return this.resDesc;
    }
}
