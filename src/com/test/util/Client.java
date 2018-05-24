package com.test.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {  
    public static void main(String[] args) {  
        try {  
            URL url = new URL("http://localhost:12001");  
            HttpURLConnection con = (HttpURLConnection) url.openConnection();  
            con.setDoOutput(true);  
//            con.setDoInput(true);  
            con.setRequestMethod("POST");  
//            con.setUseCaches(false);  
            con.setReadTimeout(5000);// 设置读取超时为5秒  
            con.setConnectTimeout(10000);// 设置连接网络超时为10秒  
  
            String test = "<name>Hello</name>";  
            byte[] bytes = test.getBytes();  
  
//            con.setRequestProperty("Content-type", "text/html");  
  
            OutputStream out = con.getOutputStream();  
  
            out.write(bytes);  
            out.flush();  
            out.close();  
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));  
            String temp;  
            while((temp = in.readLine()) != null)  
                System.out.println(temp);  
//            out.close();  
            in.close();  
            con.disconnect();  
        } catch(Exception e) {  
            e.printStackTrace();  
            System.exit(1);}}}  