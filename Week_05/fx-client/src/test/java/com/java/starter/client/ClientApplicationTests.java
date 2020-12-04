package com.java.starter.client;

import com.java.fx.model.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClientApplicationTests {

    @Autowired
    Student student;

    @Test
    void contextLoads() {
    }

    @Test
    public void testStarter(){
<<<<<<< HEAD
//        School school = new School();
//        school.dong();
=======
        System.out.println(student.toString());
>>>>>>> 6ccf475d0a51e67efde814e38bc099adfad5518a
    }

}
