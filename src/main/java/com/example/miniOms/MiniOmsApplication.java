package com.example.miniOms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 현재 위치 및 하위 패키지의 클래스들을 탐색하여 스프링 빈으로 등록
public class MiniOmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniOmsApplication.class, args);
	}

}
