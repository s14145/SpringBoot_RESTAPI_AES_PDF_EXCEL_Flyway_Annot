package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity(name = "CARD_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class CardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CARD_ID")
    private Long cardId;

    @NotBlank(message = "Card Number is a required field")
    @Column(name = "CARD_NUMBER")
    @Size(max = 16, message =  "Card Number shouldn't exceed 16 characters")
    //@Convert(converter = AESConfig.class)
    private String cardNumber;

    @NotBlank(message = "CVV is a required field")
    @Column(name = "CVV")
    @Size(max = 3, message =  "CVV shouldn't exceed 3 characters")
    //@Convert(converter = AESConfig.class)
    private Integer cvv;

    @NotBlank(message = "Amount is a required field")
    @PositiveOrZero
    @Column(name = "AMOUNT")
    //@Convert(converter = AESConfig.class)
    private Double amount;

    @NotBlank(message = "IsActive is a required field")
    @Column(name = "IS_ACTIVE")
    //@Convert(converter = AESConfig.class)
    private Boolean isActive;
}