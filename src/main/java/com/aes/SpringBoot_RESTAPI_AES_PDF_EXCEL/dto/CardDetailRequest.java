package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDetailRequest {
    private String cardNumber;
    private String cvv;
    private Double amount;
    private Boolean isActive;
}