package com.example.demo.Model.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponceDTO {

    private String status;
    private Object result;
    private String code;
    private String exception;
    private String exceptionMessage;

}
