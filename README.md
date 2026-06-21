# Mini OMS
Spring Boot와 JPA를 활용하여 구현한 주문 관리 시스템입니다.

## 프로젝트 소개
상품(Product)과 주문(Order)을 관리하는 REST API 프로젝트입니다.

## 기술 스택
- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle

## API 목록

### 상품 API
- 상품 등록
- 상품 단건 조회
- 상품 목록 조회
- 상품 수정
- 상품 삭제

### 주문 API
- 주문 생성
- 주문 목록 조회

## 주문 목록 조회 실행 결과
<img width="1095" height="753" alt="페이징" src="https://github.com/user-attachments/assets/e67baad3-4ad8-465c-a7de-48713054b6b2" />

## 실행 방법
1. 프로젝트를 Clone 합니다.
2. `src/main/resources/application.properties` 파일을 생성합니다.
3. DB 정보를 입력합니다.
4. `MiniOmsApplication`을 실행합니다.
