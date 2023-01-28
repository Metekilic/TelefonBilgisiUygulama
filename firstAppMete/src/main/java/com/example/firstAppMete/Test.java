package com.example.firstAppMete;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telefon")
public class Test {

    @GetMapping
    public PhoneResponseDto mesaj(){

        Client client = new Client();
        PhoneResponseDto phoneResponseDto = client.verifyNumber();
        return phoneResponseDto;

    }
}
