package com.onlineshop.entity;
/**
 * @Author CrystalLight
 * @Date 2019/12/18 9:02
 * @Version 1.0
 * @Description
 * 公共的返回码
 *     返回码code：
 *        成功：200
 *        失败：500
 *        未登录：10002
 *        未授权：10003
 *        抛出异常：4444
 *        用户已存在：10004
 *        用户不存在：10005
 **/

public enum ResultCode {

    SUCCESS(true,200,"操作成功！"),
    //---系统错误返回码-----
    FAIL(false,500,"操作失败"),
    UNAUTHENTICATED(false,10002,"您还未登录"),
    UNAUTHORISE(false,10003,"权限不足"),
    UEREXISTED(false,10004,"用户已存在"),
    UERNOEXISTED(false,10005,"用户名可用"),
    SERVER_ERROR(false,4444,"抱歉，系统繁忙，请稍后重试！"),

    //---用户操作返回码  2xxxx----
    MOBILEORPASSWORDERROR(false,20001,"用户名或密码错误");

    //---权限操作返回码----
    //---其他操作返回码----

    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
