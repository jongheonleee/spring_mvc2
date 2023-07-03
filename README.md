# spring_mvc2

### 📌 정리


#### 1. 타임리프 - 기본 기능

- 타임리프란?
  - 서버에서 HTML을 동적으로 렌더링함
  - 타임리프의 가장 큰 특징은 네츄럴 템플릿이라는 것
  - 즉, 파일의 HTML 형식을 유지한 상태에서 코드를 삽입하는 구조
    
- 기본 표현식
<img width="356" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/88b24799-fd65-4b24-8cf3-5eb1ed163f4a">
<img width="385" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/051d112d-58a9-4b08-a53b-92913b0472a3">


  
##### 🛠 기능

- 1. 텍스트 출력
    - 크게 두 가지 방식이 있음
    - 1. HTML 태그의 속성을 통해 랜터링 -> "<span th:text="${data}">"
    - 2. 콘텐츠 영역 안에서 직접 출력 -> "<li>컨텐츠 안에서 직접 출력하기 = [[${data}]]</li>"

- 2. 변수 - SpringEL
    - 타임 리프에서의 벼수 표현식 -> "${...}"
    - 타임 리프는 데이터를 전달 받아서 해당 데이터를 HTML에 뿌려주는 기능을 함
      - 구체적으로 말하면, Controller에서 비즈니스 로직이 처리된 데이터가 model.addAttribute(....) 저장되고
      - 타임리프가 적용된 뷰 파일은 해당 model에서 데이터를 가져와서 HTML을 동적으로 렌더링함
    - 즉, 모델 객체의 속성을 여러가지 방식으로 접근하는 방법을 말함
      <img width="334" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/e6eb5a57-1121-455c-83b3-0cc48fa4f127">

- 3. 기본 객체들
    - request, response, session, servletContext, locale
    - 형식 : "${#...}"

- 4. 유틸리티 객체와 날짜
    - 타임리프는 문자, 숫자, 날짜, URI 등 편리하게 다루는 다양한 우틸리티 객체들을 제공함

- 5. URL 링크
    - 타임리프에서 URL을 생성할 때 "@{...}" 문자를 사용하면 됨

- 6. 리터릴
     - 리터럴은 수학에서 사용하는 상수와 비슷한 개념, 즉 고정된 값을 의미함
     - 예를 들어서, String a = "Hello"; 에서 리터럴은 "Hello"이다
       <img width="626" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/65e91160-3053-482e-8051-b9510bf33d0b">

- 7. 연산
    - HTML 엔티티를 사용하는 부분만 주의
      <img width="690" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/46263824-df9e-42be-a885-014768579526">

      - >(gt), <(it), ≥(ge), ≤(le), !(not), ==(eq), ≠(neg, ne)

        
- 8. 속성 값 설정
    - 
