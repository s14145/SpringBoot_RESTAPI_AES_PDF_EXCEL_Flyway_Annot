package com.aes.SpringBoot_RESTAPI_AES_PDF_EXCEL.annotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class MaskDataSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        // Using regex positive lookahead
        String pii = value.toString().replaceAll("\\w(?=\\w{4})", "x");
        gen.writeString(pii);
    }
}