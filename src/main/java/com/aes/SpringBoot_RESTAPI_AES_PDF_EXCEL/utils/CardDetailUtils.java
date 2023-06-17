package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.utils;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailResponse;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity.CardDetail;

public class CardDetailUtils {

    public static CardDetailResponse createCardDetailResponse(CardDetail cardDetail) {
        CardDetailResponse cardDetailResponse = CardDetailResponse.builder()
                .cardId(cardDetail.getCardId())
                .cardNumber(cardDetail.getCardNumber())
                .cvv(cardDetail.getCvv())
                .amount(cardDetail.getAmount())
                .isActive(cardDetail.getIsActive())
                .build();
        return cardDetailResponse;
    }
}