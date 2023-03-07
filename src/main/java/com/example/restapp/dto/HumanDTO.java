package com.example.restapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HumanDTO {
    private Long id;
    private String name;
    private String lastName;
    private int age;

}
