package com.td.tderp.response;

public class ResResultMap {
    public static enum codes{
        SUCCESS,
        ERROR,
        FAIL
    }

    private Enum code;
    private Object data;
    private  String msg;

    public ResResultMap(Enum code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Enum getCode() {
        return code;
    }

    public void setCode(Enum code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ResResultMap success(){
        return new ResResultMap(codes.SUCCESS,null,null);
    }
    public static ResResultMap success(Object data){
        return new ResResultMap(codes.SUCCESS,data,null);
    }
    public static ResResultMap success(String msg,Object data){
        return new ResResultMap(codes.SUCCESS,data,msg);
    }

    public static ResResultMap error(String msg){
        return new ResResultMap(codes.ERROR,null,msg);
    }

    public static ResResultMap fail(String msg){
        return new ResResultMap(codes.FAIL,null,msg);

    }
}
