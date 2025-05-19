package com.github.hint.examples.service.dto;

/**
 * @ClassName Result
 * @Description
 * @Author wzq
 * @Date 2025/5/19 16:57
 * @Version 1.0
 */
public class Result<T> {
    private String code;

    private String msg;

    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode("0000");
        result.setMsg("success");
        return result;
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("0000");
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(String code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
