package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.service;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.mapper.Mapper;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailRequest;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailResponse;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity.CardDetail;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.exception.CardDetailAlreadyExistsException;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.exception.CardDetailNotFoundException;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.repository.CardDetailRepository;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.utils.CardDetailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("CardServiceImpl")
@Slf4j
public class CardServiceImpl implements CardDetailService{

    @Autowired
    private CardDetailRepository cardDetailRepository;

    public List<CardDetailResponse> getAllCardDetails() {
        log.info("CardServiceImpl: getAllCardDetails method entered");

        Optional<List<CardDetail>> optionalCardDetailList = Optional.ofNullable(cardDetailRepository.findAll());
        if (optionalCardDetailList.isEmpty()) {
            throw new CardDetailNotFoundException("No Card Details !", HttpStatus.NOT_FOUND);
        }
        List<CardDetail> cardDetails = optionalCardDetailList.get();

        List<CardDetailResponse> cardDetailResponseList = new ArrayList<>();
        for (CardDetail cardDetail : cardDetails) {
            cardDetailResponseList.add(CardDetailUtils.createCardDetailResponse(cardDetail));
        }

        log.info("CardServiceImpl: getAllCardDetails method exited");
        return cardDetailResponseList;
    }

    public CardDetailResponse getCardDetail(Long cardId) {
        log.info("CardServiceImpl: getCardDetail method entered");

        CardDetail cardDetail = cardDetailRepository.findById(cardId)
                .orElseThrow(() -> new CardDetailNotFoundException("No card detail present with id " + cardId + ".", HttpStatus.NOT_FOUND));

        CardDetailResponse cardDetailResponse = CardDetailUtils.createCardDetailResponse(cardDetail);

        log.info("CardServiceImpl: getCardDetail method exited");
        return cardDetailResponse;
    }

    public CardDetailResponse saveCardDetail(CardDetailRequest cardDetailRequest) {
        log.info("CardServiceImpl: saveCardDetail method entered");
        log.info("CardServiceImpl: saveCardDetail method request payload {}", Mapper.mapToJsonString(cardDetailRequest));

        if (cardDetailRequest == null) {
            throw new IllegalArgumentException("Request cannot be null.");
        }
        CardDetail savedCardDetail = null;
        if(cardDetailRepository.existsByCardNumber(cardDetailRequest.getCardNumber())){
            throw new CardDetailAlreadyExistsException("Card detail already exists.", HttpStatus.BAD_REQUEST);
        }else {
            CardDetail cardDetail = Mapper.convertToCardDetailEntity(cardDetailRequest);
            savedCardDetail = cardDetailRepository.save(cardDetail);
        }
        CardDetailResponse cardDetailResponse = CardDetailUtils.createCardDetailResponse(savedCardDetail);

        log.info("CardServiceImpl: saveCardDetail method response payload {}", Mapper.mapToJsonString(cardDetailResponse));
        log.info("CardServiceImpl: saveCardDetail method exited");
        return cardDetailResponse;
    }

    public CardDetailResponse updateCardDetail(Long cardId, CardDetailRequest cardDetailRequest){
        log.info("CardServiceImpl: updateCardDetail method entered");
        log.info("CardServiceImpl: updateCardDetail method request payload {} for id " + cardId + ".", Mapper.mapToJsonString(cardDetailRequest));

        if (cardDetailRequest == null ) {
            throw new IllegalArgumentException("Request cannot be null.");
        }
        CardDetail existingCardDetail = cardDetailRepository.findById(cardId)
                .orElseThrow(() -> new CardDetailNotFoundException("No card detail present with id " + cardId + ".", HttpStatus.NOT_FOUND));
        existingCardDetail.setCardNumber(cardDetailRequest.getCardNumber());
        existingCardDetail.setCvv(cardDetailRequest.getCvv());
        existingCardDetail.setAmount(cardDetailRequest.getAmount());
        existingCardDetail.setIsActive(cardDetailRequest.getIsActive());
        CardDetail savedCardDetail = cardDetailRepository.save(existingCardDetail);
        CardDetailResponse cardDetailResponse = CardDetailUtils.createCardDetailResponse(savedCardDetail);

        log.info("CardServiceImpl: updateCardDetail method response payload {} for id " + cardId + ".", Mapper.mapToJsonString(cardDetailResponse));
        log.info("CardServiceImpl: updateCardDetail method exited");
        return cardDetailResponse;
    }

    public void deleteCardDetail(Long cardId){
        log.info("CardServiceImpl: deleteCardDetail method entered");

        CardDetail existingCardDetail = cardDetailRepository.findById(cardId)
                .orElseThrow(() -> new CardDetailNotFoundException("No card detail present with id " + cardId + ".", HttpStatus.NOT_FOUND));
        cardDetailRepository.delete(existingCardDetail);

        log.info("CardServiceImpl: deleteCardDetail method exited");
    }
}