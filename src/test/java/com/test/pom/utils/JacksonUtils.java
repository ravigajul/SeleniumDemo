package com.test.pom.utils;

import com.test.pom.objects.BillingAddress;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonUtils {
    public static <T> T deserializeJson(String fileName,Class<T> T) throws IOException{
       //maven will resolve the path of the file. No need to hardcode the path
        InputStream inputStream = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(inputStream, T);
    }
}
