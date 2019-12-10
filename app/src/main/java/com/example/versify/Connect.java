package com.example.versify;
import org.json.simple.JSONArray;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {

    private final String USER_AGENT = "Mozilla/5.0";

    public String c(String a) throws Exception {

        Connect http = new Connect();

        // Sending get request
        return http.sendingGetRequest(a);
    }

    // HTTP GET request
    private String sendingGetRequest(String b) throws Exception {
        URL url = new URL(b);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        // By default it is GET request
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("Sending get request : " + url);
        System.out.println("Response code : " + responseCode);

        // Reading response from input Stream
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String output;
        StringBuffer response = new StringBuffer();

        while ((output = in.readLine()) != null) {
            response.append(output);
        }
        in.close();
        String sR = response.toString();
        //JSONArray arr = new JSONArray(response);
        //String[] rV = arr.toString().replace("},{", " ,").split(" ");
        //printing result from response
        return sR;
    }
}
