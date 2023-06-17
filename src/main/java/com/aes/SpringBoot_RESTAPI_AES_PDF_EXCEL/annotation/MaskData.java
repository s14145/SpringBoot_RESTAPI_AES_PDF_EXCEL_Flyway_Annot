package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.*;

@JacksonAnnotationsInside
@JsonSerialize(using = ProtectDataSerializer.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MaskData {
}