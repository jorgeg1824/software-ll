package com.parking.infrastructure.rest.dto;

import java.time.LocalDateTime;

public class ErrorResponse {

    private String title;
    private String detail;
    private int status;
    private LocalDateTime timestamp;

    public ErrorResponse(final String title, final String detail, final int status) {
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getTitle() { return title; }
    public String getDetail() { return detail; }
    public int getStatus() { return status; }
    public LocalDateTime getTimestamp() { return timestamp; }
}