package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDetailResponse {

    private Long cardId;
    private String cardNumber;
    private String cvv;
    private Double amount;
    private Boolean isActive;
}