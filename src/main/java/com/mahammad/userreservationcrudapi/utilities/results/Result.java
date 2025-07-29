package com.mahammad.userreservationcrudapi.utilities.results;

import lombok.Data;

@Data
public class Result<T> {
    private boolean success;
    private String message;
    private T data;

    private Result(boolean success, String message, T data) {

        this.success = success;
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(true, message, data);
    }

    public static Result<?> success(String message) {
        return new Result<>(true, message, null);
    }

    public static Result<?> failure(String message) {
        return new Result<>(false, message, null);
    }

    public static <T> Result<T> failure(String message, T data) {
        return new Result<>(false, message, data);
    }

}
