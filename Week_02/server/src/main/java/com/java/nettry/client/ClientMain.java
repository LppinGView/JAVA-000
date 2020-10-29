package com.java.nettry.client;

public class ClientMain {
    public static void main(String[] args) {
        String responseContent = HttpUtil.getInstance()
            .sendHttpGet("http://127.0.0.1:8808/test");
        System.out.println("reponse content:" + responseContent);
    }
}
