package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity;

import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation.MaskCVVData;
import com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation.MaskData;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;


@Entity(name = "CARD_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CardDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long cardId;

    // This annotation @MaskData not working
    //@Convert(converter = AESConfig.class)
    @Size(max = 16, message =  "Card Number should be 16 characters")
    @NotBlank(message = "Card Number is a required field")
    @Column(name = "CARD_NUMBER")
    @MaskData
    private String cardNumber;

    // This annotation @MaskCVVData not working
    //@Convert(converter = AESConfig.class)
    @Size(max = 3, message =  "CVV should be 3 characters")
    @NotNull(message = "CVV is a required field")
    @Column(name = "CVV")
    @MaskCVVData
    private String cvv;

    //@Convert(converter = AESConfig.class)
    @NotNull(message = "Amount is a required field")
    @PositiveOrZero
    @Column(name = "AMOUNT")
    private Double amount;

    //@Convert(converter = AESConfig.class)
    @NotNull(message = "IsActive is a required field")
    @Column(name = "IS_ACTIVE")
    private Boolean isActive;
}