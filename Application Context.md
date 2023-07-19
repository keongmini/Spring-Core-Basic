# BeanFactory와 ApplicationContext

최상위 **BeanFactory** << interface >> => 를 상속받는 **ApplicationContext** << interface >>  =>  AnnotationConfig ApplicationContext

### BeanFactory
  - 스프링컨테이너의 최상위 인터페이스
  - 스프링 빈 관리 및 조회 역할
  - ```getBean()``` 제공
  - BeanFactory를 직접 사용할 일은 거의 없음 - ApplicationContext 사용


### ApplicationContext
  - BeanFactory의 기능을 모두 상속받아서 제공
  - 애플리케이션 개발 시에는 BeanFactory에서 제공해주는 기능 외에 많은 부가 기능이 필요
    - 메세지소스를 국제화하는 기능
    - 환경변수
    - 애플리케이션 이벤트
    - 편리한 리소스 조회
