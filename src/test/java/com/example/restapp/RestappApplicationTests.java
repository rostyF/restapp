package com.example.restapp;

import com.example.restapp.entity.Human;
import com.example.restapp.repository.HumanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestappApplicationTests {

    @Autowired
    private HumanRepository humanRepository;

@Test
public void createHumanTest(){
    Human human = new Human("Peter", "Peterson", "01.01.2000");
    humanRepository.save(human);
    Long id = human.getId();

    Human found = humanRepository.findById(id).orElse(null);

    assertNotNull(found);
    assertEquals(human.getName(), found.getName());
    assertEquals(human.getLastName(), found.getLastName());
    assertEquals(human.getBirthDay(), found.getBirthDay());


}

}
