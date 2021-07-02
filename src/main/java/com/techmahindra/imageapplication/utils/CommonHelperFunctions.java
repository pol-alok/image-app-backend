package com.techmahindra.imageapplication.utils;

import com.techmahindra.imageapplication.helper.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CommonHelperFunctions {
    public static ResponseEntity<Object> buildResponseEntity(ApiResponse apiResponse) {
        return new ResponseEntity<>(apiResponse, HttpStatus.valueOf(apiResponse.getStatus()));
    }
}
