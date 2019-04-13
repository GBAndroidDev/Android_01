package com.example.weather;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherAPI {

    private final String APIKEY = "8eddd98c-3c1c-4a9e-9fd2-f0e535be04c5";

    WeatherAPI() throws IOException {

        try {

            URL obj = new URL("https://api.weather.yandex.ru/v1/informers?lat=55.75396&lon=37.620393");
            URLConnection conn = obj.openConnection();
            conn.setRequestProperty("X-Yandex-API-Key", "8eddd98c-3c1c-4a9e-9fd2-f0e535be04c5");

            Map<String, List<String>> map = conn.getHeaderFields();

            System.out.println("Printing All Response Header for URL: " + obj.toString() + "\n");
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            System.out.println("\nGet Response Header By Key ...\n");
            List<String> contentLength = map.get("Content-Length");
            if (contentLength == null) {
                System.out.println("'Content-Length' doesn't present in Header!");
            } else {
                for (String header : contentLength) {
                    System.out.println("Content-Lenght: " + header);
                }
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

