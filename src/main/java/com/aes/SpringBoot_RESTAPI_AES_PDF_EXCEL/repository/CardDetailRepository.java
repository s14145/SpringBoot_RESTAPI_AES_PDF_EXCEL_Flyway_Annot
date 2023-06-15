package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.repository;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("CardDetailRepository")
public interface CardDetailRepository extends JpaRepository<CardDetail, Long> {

    //@Query("SELECT CASE WHEN count(c) > 0 THEN true ELSE false END FROM CardDetail c where lower(c.cardNumber) = lower(:cardNumber)")
    boolean existsByCardNumber(String cardNumber);
}