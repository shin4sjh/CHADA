


# CHADA
semi_project

---

<details>
<summary>

  # 목차 📖
</summary>   

- 설계

  1. [요구 사항](#요구사항)
  
  2. [화면 설계](#화면설계)
  
  3. [ERD](#table)
  
  4. [클래스 매핑](#클래스-매핑)

- 구현


</details>



 
### 요구사항 



| 요구사항 ID | 대분류 | 소분류 | 사용자 | 요구사항 명 | 요구사항 내용 | 화면코드 |
| --- | --- | --- | --- | --- | --- | --- |
| SJH_AC_01 | 회원가입 및 계정 | 로그인 | 관리자 / 회원 | 로그인 | 이메일(아이디) / 비밀번호 제출을 통한 로그인 - 이메일(아이디) / 비밀번호 입력칸 - 로그인 실패시 alert창 표시 | Login-01 |
| SJH_AC_02 | 회원가입 및 계정 | 로그아웃 | 관리자 / 회원 | 로그아웃 | 로그아웃 - 로그아웃 완료시 alert창 표시 | Main-01 |
| SJH_AC_03 | 회원가입 및 계정 | 비밀번호 | 관리자 / 회원 | 아이디/비밀번호 찾기 (재설정) | 이메일(아이디) / 성명 입력 후 DB내 일치하는 정보 확인    => 일치 시 비밀번호 재설정 가능 | Login-02 |
| SJH_AC_04 | 회원가입 및 계정 | 회원가입 | 회원 | 회원가입 | -이메일(아이디), [비밀번호], [성명], [성별],[생년월일], [연락처] 입력 - 이메일(아이디): 영어,숫자 조합 8자 이상, 중복 확인 필요,  => 중복 확인 버튼 클릭시 입력된 아이디가 db에 존재하는지 조회 - 비밀번호: 영어,숫자 조합 8자 이상, 재확인 필요. | Login-03 |





[요구사항 정의서](https://docs.google.com/spreadsheets/d/1evOlk0AURNnV4D4m7ayvQE9jMQT5Ebp_qkEiIpEWU1Q/edit#gid=0)




 
### 화면설계 


[화면 설계](https://ovenapp.io/view/kdVtcVrKSVA0XYvisgYpAtKxxBChDwfp/apSv2)

⏺ 메인 페이지 

###### 1️⃣상점 페이지 
###### 2️⃣커뮤니티 페이지 (2)
###### 3️⃣로그인 페이지
###### 4️⃣마이 페이지
###### 5️⃣관리자 페이지


1-1 상품 전체 (상품 검색) <br>
1-2 상품 카테고리 <br>
1-3 상품 상세페이 <br>

2-1 커뮤니티 메인 / 칼럼 메인 <br>
2-2 글 전체 (조회) 페이 <br>
2-3 글 상세 페이지 <br>
2-4 글 작성/수정 페이지 <br>

3-1 로그인 페이지 <br>
3-2 회원가입 페이지 <br>
3-3 아이디/비번 찾기 페이지 <br>

4-1 내 정보 조회 페이지 <br>
4-2 내 정보 수정 페이지 <br>

5 데이터 수정 페이지 
(회원 , 글 , 알림 , 상품 ,)




### ERD - TABLE

  
![차다](https://github.com/shin4sjh/CHADA/assets/135290550/0d27d88c-2ed1-426f-a0b8-d85f915dadc2)

# table

![Display_1](https://github.com/shin4sjh/CHADA/assets/135290550/b6f05ebc-5e21-4c6b-9d46-04fbc75885fd)


![sell](https://github.com/shin4sjh/CHADA/assets/135290550/905ff338-33c7-498c-b5ac-1d90b59e064f)






### 클래스 매핑 

![2023-10-27 12 50 55](https://github.com/shin4sjh/CHADA/assets/135290550/6d115019-6f77-46b6-ae2e-d4ad8f34e440)

[URL mapping](https://docs.google.com/spreadsheets/d/1xxSBL-NDS4OMk_pamXPuaJewvQL7s9gDpoe6DaiQFxc/edit#gid=0)





---

```
IDE       :  Eclipse / Version: 2022-03 (4.23.0) / Build id: 20220310-1457
DBMS      :  Oracle 11XE DB - sqldeveloper / 버전 19.4.0.354 / 빌드 354.1759
Server    :  Apache Tomcat 9.0
Language  : java 11, HTML5, CSS, javascript,Servlet
version manage system : github desktop 
```
<img src="https://img.shields.io/badge/apachetomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white"> <img src="https://img.shields.io/badge/eclipseide-2C2255?style=for-the-badge&logo=eclipseide&logoColor=white">
<img src="https://img.shields.io/badge/json-000000?style=for-the-badge&logo=json&logoColor=white">
