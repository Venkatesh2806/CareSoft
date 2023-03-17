package com.example.demo.config;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import org.springframework.stereotype.Component;

@Component
public class JavaBase64 {
    
    public String encodePassword(String pass) {
        Encoder encoder = Base64.getEncoder();
        String originalString = pass;
        String encodedString = encoder.encodeToString(originalString.getBytes());
        return encodedString;
    }
        
    public String decodePassword(String pass) {
       
        Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(pass);
         return  new String(bytes);
    }
 
}