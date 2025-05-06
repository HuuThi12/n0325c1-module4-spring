package com.techzen.academy_n0325c1.ExerciseDay1.Exercise1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(defaultValue = "")String name) {
        return String.format("Hello %s!", name);
//        if (name == null){
//            return "Hello {name}";
//        }else {
//            return "Hello";
//        }
    }
}