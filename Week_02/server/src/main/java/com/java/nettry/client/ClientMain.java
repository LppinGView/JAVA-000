package com.java.nettry.client;

public class ClientMain {
    public static void main(String[] args) {
        String responseContent = HttpUtil.getInstance()
            .sendHttpGet("http://localhost:8801");
        System.out.println("reponse content:" + responseContent);
    }
}
