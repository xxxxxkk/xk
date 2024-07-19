package com.gw.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private String resCode;
    private String resDesc;
    private T resultSet;

    public static <T> Result<T> success() {
        return new Result<>(ResultConstant.SUCCESS.getResCode(), ResultConstant.SUCCESS.getResDesc(), null);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultConstant.SUCCESS.getResCode(), ResultConstant.SUCCESS.getResDesc(), data);
    }

    public static <T> Result<T> success(T data, String message) {
        return new Result<>(ResultConstant.SUCCESS.getResCode(), message, data);
    }

    public static <T> Result<T> success(String message) {
        return new Result<>(ResultConstant.SUCCESS.getResCode(), message, null);
    }

    public static <T> Result<T> fail() {
        return new Result<>(ResultConstant.PARAM_ERROR.getResCode(), ResultConstant.PARAM_ERROR.getResDesc(), null);
    }

    public static <T> Result<T> fail(String message) {
        return new Result<>(ResultConstant.PARAM_ERROR.getResCode(), message, null);
    }

    public static <T> Result<T> fail(String message, T data) {
        return new Result<>(ResultConstant.PARAM_ERROR.getResCode(), message, data);
    }
}
