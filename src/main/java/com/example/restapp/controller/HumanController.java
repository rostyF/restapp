package com.example.restapp.controller;


import com.example.restapp.dto.HumanDTO;
import com.example.restapp.entity.Human;
import com.example.restapp.service.HumanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/humans")
public class HumanController {
    HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    @PostMapping
    public ResponseEntity<Human> saveHuman (@RequestBody Human human){
        Human savedHuman = humanService.saveHuman(human);
        return new ResponseEntity<>(savedHuman, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HumanDTO> getHuman (@PathVariable("id") Long id){
        HumanDTO humanDTO = humanService.getHumanById(id);
        return new ResponseEntity<>(humanDTO, HttpStatus.OK);
    }
}
