package com.example.demo.Model.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {

    private String status;
    private String result;
    private String code;
    private String excepcion;
    private String exceptionMessage;

}
