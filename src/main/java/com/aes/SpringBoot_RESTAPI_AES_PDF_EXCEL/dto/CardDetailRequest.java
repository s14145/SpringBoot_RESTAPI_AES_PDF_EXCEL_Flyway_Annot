package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CardDetailRequest {
    private String cardNumber;
    private Integer cvv;
    private Double amount;
    private Boolean isActive;
}