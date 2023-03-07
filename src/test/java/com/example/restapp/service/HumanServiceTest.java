package com.example.restapp.service;

import com.example.restapp.dto.HumanDTO;
import com.example.restapp.entity.Human;
import com.example.restapp.repository.HumanRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HumanServiceTest {

    @Mock
    private HumanRepository humanRepository;

    @InjectMocks
    private HumanService humanService;


    @Test
    public void saveHuman_shouldCallRepository(){
        Human human = new Human("Peter", "Peterson", "01.01.2000");
        humanService.saveHuman(human);


        verify(humanRepository).save(human);

    }

    @Test
    public void getHumanById_shouldCallRepository(){
        Human human = new Human(1L ,"Peter", "Peterson", "01.01.2000");
        humanService.saveHuman(human);
        Long id = human.getId();

        HumanDTO found = humanService.getHumanById(id);

        verify(humanRepository).findById(id);


    }




}