package com.example;

import com.example.app.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@EnableAutoConfiguration
@Import(AppConfig.class) 
//JavaConfig를 읽어들이기 위해서 @Configuration이 붙은 클래스를 지정합니다.
public class App {
    public static void main(String[] args) {
    	//자바 7에서 도입한 try-with-resources 문 안에 변수를 선언하여 try안쪽에서 처리가 끝나면 자동으로 close()메소드가 호출되어 
    	//DI컨테이너가 소멸되고 어플리케이션이 실행을 마치게 됩니다.
        try (ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {

            Scanner scanner = new Scanner(System.in); //표준입력으로 데이터를 받아들인다.
            System.out.print("Enter 2 numbers like 'a b' : ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Calculator calculator = context.getBean(Calculator.class); //getBean()메서드를 사용하여 DI컨테이너에서 Calculator 타입 인스턴스를 받습니다.
            int result = calculator.calc(a, b);

            System.out.println("result = " + result);
        }
    }
}
