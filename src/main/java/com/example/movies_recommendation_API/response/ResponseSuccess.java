package com.example.movies_recommendation_API.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSuccess {
    private String status;
    private final Date timestamp = new Date();
    private Object data;

    public ResponseSuccess(String status) {
        this.status = status;
    }

}
