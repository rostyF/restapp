package com.example.restapp.service;

import com.example.restapp.DateChanger;
import com.example.restapp.dto.HumanDTO;
import com.example.restapp.entity.Human;
import com.example.restapp.repository.HumanRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HumanService {
    private HumanRepository humanRepository;

    public HumanService(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }


    public Human saveHuman(Human human){
        Human savedHuman =humanRepository.save(human);
        return savedHuman;
    }

    public HumanDTO getHumanById(long id){
        Optional<Human> humanOpt = humanRepository.findById(id);
        if (humanOpt.isEmpty()){
            return null;
        }
        Human human = humanOpt.get();
        int age = DateChanger.changeDate(human.getBirthDay());
        return new HumanDTO(human.getId(), human.getName(), human.getLastName(), age);

    }
}
