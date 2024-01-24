package com.example.test.controller;

import com.example.test.entity.ReturnTax;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/szs")
public class CalculationController {

    @GetMapping("/returnd")
    public int calculation (ReturnTax returnTax){
        int result = returnTax.getResultTax();
        return result;
    }
}
