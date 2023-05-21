package com.sia.localiza.api.common.exceptions;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiError {
    private String message;

    private Integer status_code;

    private String request;

    private String method;
}