# spring_mvc2

# 📌 정리


## 1. 타임리프 - 기본 기능

### 핵심 개념 및 목표
- 타임리프란?
  - 서버에서 HTML을 동적으로 렌더링함
  - 타임리프의 가장 큰 특징은 네츄럴 템플릿이라는 것
  - 즉, 파일의 HTML 구조를 유지한 상태에서 특정 속성을 대체하는 형식
    
- 기본 표현식
<img width="356" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/88b24799-fd65-4b24-8cf3-5eb1ed163f4a">
<br/>
<img width="385" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/051d112d-58a9-4b08-a53b-92913b0472a3">


  
## 🛠 기능

- 1. 텍스트 출력
  - 크게 두 가지 방식이 있음
  -  (1). HTML 태그의 속성을 통해 랜터링  
      <br/>
      <img width="427" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/62765c01-663f-447e-b1be-abf6cbf10bf3">

  -  (2). 콘텐츠 영역 안에서 직접 출력
      <br/>
      <img width="363" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/3834f8d8-482b-4431-aaa7-2d99e074e1df">


- 2. 변수 - SpringEL
  - 타임 리프에서의 변수 표현식 -> "${...}"
  - 타임 리프는 데이터를 전달 받아서 해당 데이터를 HTML에 뿌려주는 기능을 함
    - 구체적으로 말하면, Controller에서 비즈니스 로직이 처리된 데이터가 model.addAttribute(....) 저장되고
    - 타임리프가 적용된 뷰 파일은 해당 model에서 데이터를 가져와서 HTML을 동적으로 렌더링함
  - 모델 객체의 속성을 여러가지 방식으로 접근하는 방법을 말함
    <br/>
    <img width="334" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/e6eb5a57-1121-455c-83b3-0cc48fa4f127">

- 3. 기본 객체들
  - request, response, session, servletContext, locale
  - 형식 : "${#...}"

- 4. 유틸리티 객체와 날짜
  - 타임리프는 문자, 숫자, 날짜, URI 등 편리하게 다루는 다양한 유틸리티 객체들을 제공함

- 5. URL 링크
   - 타임리프에서 URL을 생성할 때 "@{...}" 문자를 사용하면 됨

- 6. 리터럴
  - 리터럴은 수학에서 사용하는 상수와 비슷한 개념, 즉 고정된 값을 의미함
  - 예를 들어서, String a = "Hello"; 에서 리터럴은 "Hello"이다
    <br/>
    <img width="626" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/65e91160-3053-482e-8051-b9510bf33d0b">

- 7. 연산
  - HTML 엔티티를 사용하는 부분만 주의
  <br/>
  <img width="690" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/46263824-df9e-42be-a885-014768579526">
  <br/>
  - >(gt), <(lt), ≥(ge), ≤(le), !(not), ==(eq), ≠(neg, ne)

        
- 8. 속성 값 설정
  - "th:..." 으로 사용
  - 타임리프는 주로 HTML 태그에 th:... 속성을 지정하는 방식으로 동작하는 데 th:...로 속성을 적용하면 기존 속성을 대체함
  - 기존 속성이 없으면 새로 만듦
  - 예를 들어서 밑에 코드에서 th:name이 기존의 name 속성을 대체함
    <br/>
    <img width="411" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/93e360b2-92b4-4f55-8245-6a747d941b9d">


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
  - 타임리프 파서 주석 
  - 타임리프 프로토타입 주석
    <br/>
    <img width="356" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/25b5169a-4b1a-4555-95b9-4ca0403842cc">
    <br/>

  - 렌더링에서 주석 부분을 제거함

- 12. 블록
  - <th:block>
  - 타임리프의 특성상 HTML 태그 안에 속성으로 기능을 정의해서 사용하는데, 해당 방식으로 사용하기 애매한 경우에 블록 기능을 활용함
    <br/>
    <img width="631" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/e01e9d21-358b-4369-850f-0ee95743b9d7">
    <br/>
    <img width="237" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/1f0d9486-dbdc-4f24-b28d-0efb199b03d8">
    <br/>

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
  - 템플릿 조각의 개념을 확장한 개념, 템플릿 조각은 일부 코드 조각을 가지고와서 사용하는 것
  - 템플릿 레이아웃은 코드 조각을 레이아웃에 넘겨서 사용하는 방식임
  - 사용 시기는 공통 정보를 사용하되 각 페이지마다 필요한 정보를 더 추가해서 사용하는 경우
  - 간단하게 말하면, 레이아웃 개념을 두고, 그 레이아웃에 필요한 코드 조각을 전달해서 완성하는 작업
    <br/>
    <img width="593" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/ef0c702e-9b87-46f0-99af-56e67d4540ae">



## 2. 타임리프 - 스프링 통합과 폼

### 핵심 개념 및 목표

- 스프링이 지원하는 다양한 기능을 공부하면서 스프링 MVC를 깊이 있게 이해하기
- MVC 1 편 상품 관리 프로젝트를 기반으로 기능 붙여가면서 공부
- 스프링과 타임리프가 통합되면서 다양한 기능을 편리하게 사용할 수 있음
  - SpringEL 문법 통합
  - 스프링 빈 호출 지원
  - 편리한 폼 관리를 위한 추가 속성
  - 폼 컴포넌트 기능(checkbox, radio. buttom, list ,,,)
  - 스프링의 메시지, 국제화 기능의 편리한 통합
  - 스프링의 검증, 오류 처리 통합
  - 스프링의 반환 서비스 통합
  

## 🛠 기능
- 1. 입력 폼 처리
  - th:object : 커맨드 객체를 지정
  - '*{...}' : 선택 변수 식(위에 커맨드 객체를 지정해주면 객체의 이름없이 특정 필드의 이름으로 사용할 수 있음, 예를 들어서 *{name})
  - th:field : HTML 태그의 속성을 자동으로 처리, 즉 ‘id’, ‘name’, ‘value’ 속성을 모두 자동으로 만들어줌
    <br/>
    <img width="645" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/62a00f95-9449-4cb8-80c8-439f7e184ef6">
    <br/>

- 2. 단일 체크 박스
  - 체크 박스를 사용할 경우, 문제가 있음
  - 체크를 해제하고 form을 전송할 시 서버에 체크 필드의 값 자체가 넘어오지 않음
  - 이를 해결하기 위해 히든 필드를 사용하지만, 개발자가 일일이 히든 필드를 생성해줘야 하는 번거로움이 있음
  - 하지만, 타임리프를 사용하면 히든 필드와 체크값(체크되었는지 안되었는지)을 자동으로 생성해줌
    <br/>
    <img width="560" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/eb3cbe67-fe67-4d11-bbca-7cc0e6b58fbc">
    <br/>

- 3. 멀티 체크 박스
  - @ModelAttribute를 통해 멀티 체크 박스를 구성하는 데이터를 반복해서 넣어줘야함
  - 위의 작업은 컨트롤러에서 따로 메서드를 정의해서 처리할 수 있음
    <br/>
    <img width="480" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/1598c752-8611-41ca-af9d-3c8d3e32a3b2">
    <br/>
  - HTML 파일에서 해당 멀티 체크 박스를 구현할 때, 멀티 체크 박스의 이름은 같아도 되지만, id 값은 다르게 해줘야함. 이를 처리해주는 것이 "${#ids.prev('open')}" 임
  - 해당 코드는 동적으로 생성되는 id 값을 사용할 수 있음
    <br/>
    <img width="630" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/5cfe13d1-99a1-49ee-a20b-4a7da250c725">
    <br/>
    <img width="604" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/2a2c1250-6168-4908-90d7-f568c618b117">
    <br/>

    
- 4. 라디오 버튼
  - 여러 선택지 중에 하나를 선택할 때 사용할 수 있음, 자바 ENUM을 활용해서 개발
  - 라디오 버튼의 경우 항상 하나를 선택하도록 되어 있기 때문에 별도의 히든 필드를 사용할 필요가 없음
  - 위의 @ModelAttribute를 통해 여러 데이터를 넣은 것 처럼 라디오 버튼 또한 ENUM의 값들을 같은 방식으로 처리할 수도 있음
      <br/>
      <img width="273" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/2f2eed52-6913-4342-9c46-76019e211aae">
      <br/>
  - 또한, 타임리프로 자바 객체에 직접 접근하는 방법이 있음, 즉 타임리프로 ENUM 객체에 직접 접근하여 사용할 수 있음(스프링 EL 문법임). 하지만 해당 방식은 권장하는 방식이 아님
    <br/>
    <img width="644" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/b90ba235-038f-42f9-a0cc-e2da15161c39">
    <br/>

- 5. 셀렉트 박스
  - 여러 선택지 중에 하나를 선택할 때 사용하는 기능. 자바 객체를 활용해서 개발해보기
    <br/>
    <img width="524" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/d0f69105-0ce9-4eda-b9f7-3e44dc28e1c1">
    <br/>
    <img width="657" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/955f988e-8d6b-4b0e-b917-ace676554e8b">
    <br/>

## 3. 메시지, 국제화

### 핵심 개념 및 목표
- "메시지 기능" 이란?
  - HTML 파일에 메시지가 하드코딩 되어서 유지보수의 어려움을 막기 위해, 다양한 메시지를 한 곳에서 관리하는 기능
  - 주로 messages.properties 라는 관리용 파일을 만들어서 보관함(위치 : /resources/messages.peoperties)
  - 이를 통해서 변경에 유연하게 대처할 수 있음(변경이 일어나면 해당 괸리용 파일에서 변경이 일어난 부분을 찾아서 수정해주면됨)
<br/>

- "국제화 기능" 이란?
  - 메시지 기능에서 설명한 메시지 파일(messages.properties)을 각 나라별로 관리하면 서비스를 국제화 할 수 있음
  - 예를 들어서, message_en.properties -> 영어권, message_ko.properties -> 한국
  - 따라서, 사용자가 사용하는 언어에 맞춰서 메시지를 해당 언어로 표현할 수 있음
<br/>

- 스프링의 경우 메시지와 국제화 기능을 기본적으로 제공함
<br/>

## 📝 메시지와 국제화 기능 사용법
- 1. 스프링 메시지 소스 설정
  - MessageSource(인터페이스, 실질적으로 해당 인터페이스의 구현체인 ResourceBundleMessageSource를 등록함)를 스프링 빈으로 등록하기
    <br/>
    <img width="676" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/8083ae09-e9a3-4eac-8d7c-61eed5331f7b">
    - basenames을 통해서 설정 파일의 이름을 지정함, 예를 들어서 위의 사진 처럼 setBaesenames("massages")라고 하면 messages.properties를 읽어서 사용함
    - 국제화 기능의 경우 xxx_en.properties, xxx_ko.properties 형식으로 제공하면 됨
    - 스프링 부트를 사용하면 MessageSource가 자동으로 스프링 빈으로 등록됨
    - 스프링 부트 메시지 소스 설정의 경우 application.properties에서 "spring.messages.basename = messages ,,, " 형식으로 작성하면됨(기본값 : spring.messages.basename = messages)
    - 즉, 위에 처럼 application.properties에 메시지 관리용 파일을 등록하면 자동으로 메시지, 국제화가 인식됨

- 2. MessageSource
  - MessageSource 인터페이스
    <br/>
    <img width="644" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/c9f3448c-be57-4039-9052-a96fb32c505b">
    <br/>
    - 위의 인터페이스를 통해 알 수 있는 것은 코드를 포함한 일부 파라미터로 메시지를 읽어오는 기능을 제공함
    - MessageSource.getMessage(CODE, ,,,) -> CODE로 등록된 메시지를 읽어와서 문자열로 반환해줌
    
  
- 3. LocaleResolver
  - 스프링도 Locale 정보를 알아야 국제화 기능을 사용할 수 있음, Locale 정보를 알아야 특정 언어를 선택할 수 있다는 뜻
  <br/>
  <img width="522" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/1c1121e7-3ba2-4fc7-b331-bd79cfb6bd16">
  <br/>
  
  - LocaleResolver는 Locale 선택 방식을 변경할 수 있도록 도와주는 인터페이스(스프링 부트는 기본으로 AcceptHeaderLocaleResolver를 사용함)
    - 만약 Locale 선택 방식을 변경하려면 LcaleResolver의 구현체를 변경해야함


## 4. 검증1


### 핵심 개념 및 목표
- 웹 서비스는 폼 입력시 오류가 발생하면, 고객이 입력한 데이터를 유지한체 어떤 오류가 발생했는지 알려주어야함
- 컨트롤러의 중요한 역할 중 하나는 HTTP 요청이 정상인지 검증하는 것임, 앞으로 HTTP 요청 검증을 배울것임
- 즉, 검증이란? 클라이언트가 서버에 요청을 보낼 때 해당 요청이 올바른 요청인지 아닌지 확인을 하고 올바른 요청이 아닌 경우에는 어느 부분이 잘못되었는지 설명해주는 것을 말함. 그러기 위해서는 바로 400 에러 페이지가 발생하는 것이 아니라 컨트롤러에서 검증 로직을 통해 어느 부분이 잘 못됬는지 뷰 파일에 전달하고 뷰 파일은 클라이언트가 잘못된 부분을 알 수 있게끔 보여주어야함 
- 검증 성공 요청 흐름
  <br/>
  <img width="486" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/f79afc8c-f17a-4fbb-b3aa-8a8e06b0f6a5">
  <br/>

- 검증 실패 요청 흐름
  <br/>
  <img width="481" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/b5bf6ca0-33c4-49c0-b5fa-fdfbc9238c1e">
  <br/>


## 📝 검증 기능 사용법

- 검증 처리 방식, 크게 2가지 방식이 있음 -> 직접 처리/ BindingResult(FieldError & ObjectError)

- 1. 직접 처리 과정
  - 컨트롤러 내부에서 검증 로직을 삽입하여 검증 에러가 발생하면 저장함
  - 저장된 에러 내용을 model.addAttribute(,,,)에 담아서 다시 입력 폼으로 보냄
    
    <br/>
    <img width="593" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/97f7db7a-d409-4399-97e3-b2ccb341d8a1">
    <br/>

    <img width="412" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/c66c9aab-899d-43a8-997b-867c4872dedc">
    <br/>
    
  - 하지만, 직접 처리 방식은 문제점들이 있음
    - 타입 오류 처리가 안됨
    - 클라이언트가 입력한 정보를 바인딩할 수 없음, 즉 클라이언트가 입력한 값도 어딘가에 별도로 관리해야함

<br/>

- 2. 스프링이 제공하는 검증 방식 -> BindingResult

  <br/>
  <img width="679" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/679c7759-8c22-4282-b33f-6219089edec5">
  <br/>

  - 직접 처리 과정과는 다르게, 단순하게 자료구조로 에러 정보를 저장하는 것이 아닌 BindingResult 구현체에 저장함
  - BindingResult는 검증 오류를 보관하는 인터페이스임, BindingResul 구현체를 사용하면 @ModelAttribute에 바인딩 시 타입 오류가 발생해도 컨트롤러가 호출됨(사용하지 않는 경우는 400오류 페이지 발생)
  - BindingResult에 검증 오류를 적용하는 방법은 3가지가 있음
    - @ModelAttribute의 객체에 타입 오류 등으로 바인딩이 실패하는 경우 스프링이 FieldError 생성해서 BindingResult에 넣어줌
    - 개발자가 직접 작성
    - Validator 사용 
  - 필드에 오류가 있으면 FieldError 객체를 생성해서 bindingResult에 담아두면됨, 글로벌 오류의 경우 ObjectError 객체 생성해서 담아주기
  - 타임리프는 스프링의 BindingResult를 활용해서 편리하게 검증 오류를 표현함
    <br/>
    <img width="401" alt="image" src="https://github.com/jongheonleee/spring_mvc2/assets/87258372/f102b028-23b8-4b5c-8dbf-1961a1541420">
    <br/>
      
  
