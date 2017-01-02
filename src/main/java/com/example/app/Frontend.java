package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tinoll on 2017. 1. 3..
 */
@Component
public class Frontend {

    @Autowired   //DI컨테이너가 주입해야 할 필드를 의미합니다
    ArgumentResolver argumentResolver;
    @Autowired
    Calculator calculator;

    public void run() {

        System.out.println("Enter 2 number like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(),argument.getB());
        System.out.println("result : "+result);
    }
}
