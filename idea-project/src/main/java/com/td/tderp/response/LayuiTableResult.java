package com.td.tderp.response;

import java.util.List;

public class LayuiTableResult {
    private int code = 0;
    private String msg ="";
    private int count;
    private List<?> data;


    public LayuiTableResult(int count, List<?> data) {
        this.count = count;
        this.data = data;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public List<?> getData() {
        return data;
    }
    public void setData(List<?> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiTableResult [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
    }
}
