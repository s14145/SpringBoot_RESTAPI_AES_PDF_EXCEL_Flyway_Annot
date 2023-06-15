package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.service;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailRequest;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailResponse;

import java.util.List;

public interface CardDetailService {

    List<CardDetailResponse> getAllCardDetails();

    CardDetailResponse getCardDetail(Long cardId);

    CardDetailResponse saveCardDetail(CardDetailRequest cardDetailRequest);

    CardDetailResponse updateCardDetail(Long cardId, CardDetailRequest cardDetailRequest);

    void deleteCardDetail(Long cardId);

}