# spring_mvc2

# 📌 정리


## 1. 타임리프 - 기본 기능

- 타임리프란?
  - 서버에서 HTML을 동적으로 렌더링함
  - 타임리프의 가장 큰 특징은 네츄럴 템플릿이라는 것
  - 즉, 파일의 HTML 구조를 유지한 상태에서 코드를 삽입하는 형식
    
- 기본 표현식
<img width="356" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/88b24799-fd65-4b24-8cf3-5eb1ed163f4a">
<br/>
<img width="385" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/051d112d-58a9-4b08-a53b-92913b0472a3">


  
## 🛠 기능

- 1. 텍스트 출력
  - 크게 두 가지 방식이 있음
  -  (1). HTML 태그의 속성을 통해 랜터링  <span th:text="${data}">
  -  (2). 콘텐츠 영역 안에서 직접 출력  <li>컨텐츠 안에서 직접 출력하기 = [[${data}]]</li>

- 2. 변수 - SpringEL
  - 타임 리프에서의 벼수 표현식 -> "${...}"
  - 타임 리프는 데이터를 전달 받아서 해당 데이터를 HTML에 뿌려주는 기능을 함
    - 구체적으로 말하면, Controller에서 비즈니스 로직이 처리된 데이터가 model.addAttribute(....) 저장되고
    - 타임리프가 적용된 뷰 파일은 해당 model에서 데이터를 가져와서 HTML을 동적으로 렌더링함
  - 즉, 모델 객체의 속성을 여러가지 방식으로 접근하는 방법을 말함
    <br/>
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
    <br/>
    <img width="626" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/65e91160-3053-482e-8051-b9510bf33d0b">

- 7. 연산
  - HTML 엔티티를 사용하는 부분만 주의
  <br/>
  <img width="690" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/46263824-df9e-42be-a885-014768579526">
    - >(gt), <(it), ≥(ge), ≤(le), !(not), ==(eq), ≠(neg, ne)

        
- 8. 속성 값 설정
  - "th:..." 으로 사용
  - 타임리프는 주로 HTML 태그에 th:... 속성을 지정하는 방식으로 동작하는 데 th:...로 속성을 적용하면 기존 속성을 대체함
  - 기존 속성이 없으면 새로 만듦
  - 예를 들어서 "<input type = "text" nam = "mock" th:name = "userA">" 에서 th:name이 기존의 name 속성을 대체함

- 9. 반복
  - "th:each" 를 통해 사용함, 예를 들어서 <tr th:each=”user : ${users}”>으로 사용해서 원하는 필드에 user의 속성 값을 주입할 수 있음
    <br/>
    <img width="406" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/285347a8-fd4e-4e43-a20a-eb3c06a3c779">

- 10. 조건부 평가
  - 'if', 'unless'를 사용
    <br/>
    <img width="529" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/1d4dac51-0720-4ed6-9c44-b539ed84a343">
    <br/>
  - 해당 분기문을 만족하는 경우 특정 값이 출력되고 그렇지 않는 경우 태그 자체가 없어짐

- 11. 주석
  - 타임리프 파서 주석 : "<!--/*...*/-->"
  - 타임리프 프로토타입 주석 : "<!--/*/.../*/-->(겅의 안씀)"
  - 렌더링에서 주석 부분을 제거함

- 12. 블록
  - <th:block>
  - 타임리프의 특성상 HTML 태그 안에 속성으로 기능을 정의해서 사용하는데, 해당 방식으로 사용하기 애매한 경우에 블록 기능을 활용함
    <img width="631" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/e01e9d21-358b-4369-850f-0ee95743b9d7">
    <br/>
    <img width="237" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/1f0d9486-dbdc-4f24-b28d-0efb199b03d8">

- 13. 자바스크립트 인라인
  - 해당 방식을 통해, 자바 스크립트 내에서 사용하는 코드 형식을 그대로 표현할 수 있음, 또한 객체를 JSON으로 자동 변환해줌
  - "<script th:inline=”javascript”>"
  <br/>
  <img width="320" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/e447d1e5-0312-4765-9057-a26070b6906a">
 
- 14. 템플릿 조각
  - 웹 개발의 특성상 여러 페이지에서 공통으로 사용하는 영역이 있음
  - 이를 효율적으로 처리하기 위해 템플릿 조각과 레이아웃 기능을 지원
  - th:fragment="...', -> 푸터, 카테고리 등등 공통적으로 사용하는 영역에 대해 코드를 작성
  - template/fragment/footer :: "..." -> 특정 페이지에서 template/fragment/footer.html에 있는 부분을 가져옴

- 15. 템플릿 레이아웃 
  - 템플릿 조각의 개념을 확장한 개념, 템플릿 조간은 일부 코드 조각을 가지고와서 사용하는 것
  - 템플릿 레이아웃은 코드 조각을 레이아웃에 넘겨서 사용하는 방식임
  - 사용 시기는 공통 정보를 사용하되 각 페이지마다 필요한 정보를 더 추가해서 사용하는 경우
  - 간단하게 말하면, 레이아웃 개념을 두고, 그 레이아웃에 필요한 코드 조각을 전달해서 완성하는 작업
    <br/>
    <img width="593" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/ef0c702e-9b87-46f0-99af-56e67d4540ae">

    
