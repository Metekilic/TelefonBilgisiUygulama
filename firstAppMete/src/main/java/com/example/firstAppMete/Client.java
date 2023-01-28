package com.example.firstAppMete;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {

    public PhoneResponseDto verifyNumber(){

        try {


            URL url = new URL("https://veriphone.p.rapidapi.com/verify?phone=%+905441087448");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("X-RapidAPI-Key", "88b9a8e702mshf298931e8d65d64p151c67jsn7bf8e40ee62f");
            httpURLConnection.setRequestProperty("X-RapidAPI-Host", "veriphone.p.rapidapi.com");

            String response = convertStreamToString(httpURLConnection.getInputStream());

            ObjectMapper mapper = new ObjectMapper();
            PhoneResponseDto phoneResponseDto = mapper.readValue(response, PhoneResponseDto.class);

            phoneResponseDto.getCarrier();
            httpURLConnection.disconnect();

            return phoneResponseDto;

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return new PhoneResponseDto();
    }

    private String convertStreamToString(InputStream inputStream) throws IOException {


            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            inputStream.close();
            return sb.toString();
    }


}
