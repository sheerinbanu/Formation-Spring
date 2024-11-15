package com.formation.spring.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SimpleController {

    private ArrayList<String> list = new ArrayList<String>();
    private int count = 4;

    public SimpleController() {
        list.add("String1");
        list.add("String2");
        list.add("String3");
    }

    @GetMapping("/")
    public String SimpleGet(){
        return "Hello world";
    }

    @GetMapping("/list")
    public ArrayList<String> getList(){
        return list;
    }

    @PostMapping("/add")
    public ArrayList<String> add (){
        list.add("String"+ count);
        count++; 
        return list;
    }

    @PutMapping("/update")
    public ArrayList<String> update(){
        list.set(0, "Updated");
        return list;
    }

    @DeleteMapping("/delete")
    public ArrayList<String> delete(){
        list.remove(0);
        return list;
    }

    
}
