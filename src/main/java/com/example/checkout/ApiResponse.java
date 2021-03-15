package com.example.checkout;

public class ApiResponse {
    private int code;
    private String message;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return message;
    }
}
