package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.controller;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailRequest;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.dto.CardDetailResponse;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.service.CardDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cards")
public class CardDetailController {

    @Autowired
    private CardDetailService cardDetailService;

    @GetMapping
    public ResponseEntity<List<CardDetailResponse>> getCardDetails(){
       List<CardDetailResponse> cardDetailResponseList = cardDetailService.getAllCardDetails();
        return new ResponseEntity<>(cardDetailResponseList, HttpStatus.OK);
    }

    @GetMapping("/{cardId}")
    public ResponseEntity<CardDetailResponse> getCardDetail(@PathVariable Long cardId){
        CardDetailResponse cardDetailResponse = cardDetailService.getCardDetail(cardId);
        return new ResponseEntity<>(cardDetailResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CardDetailResponse> saveCardDetail(@RequestBody CardDetailRequest cardDetailRequest){
        CardDetailResponse cardDetailResponse = cardDetailService.saveCardDetail(cardDetailRequest);
        return new ResponseEntity<>(cardDetailResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<CardDetailResponse> updateCardDetail(@PathVariable Long cardId, @RequestBody CardDetailRequest cardDetailRequest){
        CardDetailResponse cardDetailResponse = cardDetailService.updateCardDetail(cardId, cardDetailRequest);
        return new ResponseEntity<>(cardDetailResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> deleteCardDetail(@PathVariable Long cardId){
        cardDetailService.deleteCardDetail(cardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}