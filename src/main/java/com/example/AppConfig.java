package com.example;

import com.example.app.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 이 클래스가 JavaConfing용 클래스임을 컴파일러에 알립니다.
@Configuration 
public class AppConfig {
    /*
     *DI 컨테이너가 관리할 Bean 을 생성하는 메서드에 붙입니다.
     *기본적으로 메서드 이름이 Bean 이름입니다. 
     *또한, 기본값으로 이 메서드가 생성한 인스턴스가 싱글통이 되며, DI컨테이너별로 인스턴스 한 개가 생성됩니다. 
     */
	@Bean
    Calculator calculator() {
        return new AddCalculator(); //생성자로 생성한 Calculator 타입의 calculator 인스턴스를 DI 컨테이너가 싱글톤으로 관리합니다.
    }

    @Bean
    ArgumentResolver argumentResolver() {
        return new ScannerArgumentResolver();
    }

    @Bean
    Frontend frontend() {
        return new Frontend();
    }
}
