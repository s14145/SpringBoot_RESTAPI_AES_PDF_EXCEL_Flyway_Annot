package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation.MaskCVVData;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation.MaskData;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDetailRequest {

    @MaskData
    private String cardNumber;

    @MaskCVVData
    private String cvv;

    private Double amount;

    private Boolean isActive;
}