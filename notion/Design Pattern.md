# Design Pattern

### Singleton Pattern

[https://multifrontgarden.tistory.com/260?category=471239](https://multifrontgarden.tistory.com/260?category=471239)

애플리케이션 개발 시 **오직 하나만의 객체를 생성한 뒤 다른 객체를 생성하지 않고  최초 생성된 객체를 계속 사용하는 것 ****이다. ******

하나의 인스턴스를 메모리에 등록하여 여러 개의 쓰레드가 동시에 해당 인스턴스를 공유하여 사용함으로써 자주 사용되는 경우에는 효율성을 높일 수 있는 장점이 있다. 

- **Double Checked Locking**

- **동기화(synchronized)**

     멀티 쓰레드 환경에서 하나의 데이터(인스턴스)를 공유하게 된다면 해당 데이터의 원자성을 보존하기 위해 현재 접근해있는 Thread를 제외하고 나머지 Thread는 접근을 막는 것. synchronized 가 선언되어있는 메소드의 경우 각 쓰레드들은 이를 위해 순차적으로 lock을 얻고 메소드를 수행 후 lock을 반납하는 형태로 진행된다. 

    ex) 은행 잔고 예시 [https://coding-start.tistory.com/68](https://coding-start.tistory.com/68)

    synchronized()의 매개변수는 동기화할 객체(해당 메소드가 작성된) 또는 클래스명 → 매개변수로 선언된 객체, 클래스의 인스턴스는 해당 임계영역에 접근할 수 없다.

    ### *→ synchronized(this) vs static synchronized(TargetClass.class)*

    ~~아아아아주 헷갈리는 부분이었다.~~  [https://blog.naver.com/playse444/150129254736](https://blog.naver.com/playse444/150129254736)

    *synchronized(this)* : 생성된 각 인스턴스 단위별로 동기화 

    *static synchronized(TargetClass.class)* : 지정된 클래스의 모든 instance에 대해 동기화

- **Java volatile**

    지정된 변수를 Main Memory에 저장하는 것을 명시, 또한 매 read시 CPU cache에 저장된 값이 아닌 Main Memory에서 read하며, 변수의 값을 write도 Main Memory에 진행

    ex) 멀티쓰레드 환경에서 두 개의 CPU가 있다고 가정했을 때 각 CPU는 데이터를 캐시에 저장하고 읽게 된다. (이 부분은 아직 하드웨어 쪽의 지식이 부족하여 무조건 CPU cache에 값이 저장되는지는 모르겠음) 

    이 과정에서 Thread1의 변수에 1씩 더하고, Thread2가 변수를 읽는다고 가정했을 때에 Thread1에서 더해진 값들은 Main Memory에 반영되지 않기 때문에 Thread2가 0을 읽어오는 상황이 발생한다. 따라서 이 둘의 값 불일치 현상을 고치기 위해 변수에 volatile을 선언한다.

    하지만 항상 volatile 이 옳은 것은 아니다. 이처럼 값의 변경을 한 Thread에서만 진행하는 경우에는 좋지만, 만약 여러 Thread가 동시의 write를 진행하는 경우에는 각 Thread의 연산 속도의 차이로 각각 반영하게 된다면 **데이터의 원자성(atomic) 이 깨지게 된다.** 따라서 값의 write가 다수의 쓰레드에 의해 진행되는 경우에는 **sychronized**를 통해 값의 원자성을 보존하는 것이 옳다.

### Transaction script

은행의 계좌이체 서비스를 모티브로 한 도메인 로직 패턴으로 한번 시작된 행동은 모두 완벽하게 성공해야지만 처리되는 하나의 트랜잭션으로 구성된 로직을 말한다. 

보통 JSP Model 1 Architecture에서 사용되며 우리가 사용하는 Spring Framework의 경우는 JSP Model 2 구조에서 Command Pattern과 MVC Pattern을 혼합하여 사용한다.

### MVC Pattern

### Proxy Pattern