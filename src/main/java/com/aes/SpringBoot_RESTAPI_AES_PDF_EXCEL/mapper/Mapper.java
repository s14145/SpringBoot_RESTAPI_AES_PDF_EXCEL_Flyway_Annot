package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.mapper;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailRequest;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity.CardDetail;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mapper {

    public static CardDetail convertToCardDetailEntity(CardDetailRequest cardDetailRequest){

        CardDetail cardDetail = new CardDetail();
        cardDetail.setCardNumber(cardDetailRequest.getCardNumber());
        cardDetail.setCvv(cardDetailRequest.getCvv());
        cardDetail.setAmount(cardDetailRequest.getAmount());
        cardDetail.setIsActive(cardDetailRequest.getIsActive());
        return cardDetail;
    }

    public static CardDetailRequest convertToCardDetailRequestDTO(CardDetail cardDetail){

        CardDetailRequest cardDetailRequest = new CardDetailRequest();
        cardDetailRequest.setCardNumber(cardDetail.getCardNumber());
        cardDetailRequest.setCvv(cardDetail.getCvv());
        cardDetailRequest.setAmount(cardDetail.getAmount());
        cardDetailRequest.setIsActive(cardDetail.getIsActive());
        return cardDetailRequest;
    }

    public static String mapToJsonString(Object object){
        try{
            return new ObjectMapper().writeValueAsString(object);
        }catch(JsonProcessingException exception){
            log.error("Unable to convert " + object + " to JSON.");
            exception.printStackTrace();
        }
        return null;
    }
}