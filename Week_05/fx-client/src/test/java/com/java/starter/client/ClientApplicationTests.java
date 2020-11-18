package com.java.starter.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testStarter(){
        School school = new School();
        school.dong();
    }

}
