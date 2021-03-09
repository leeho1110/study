# Logging Framework (slf4j)

### *로깅이 왜 필요할까?*

애플리케이션 개발 시 디버깅 메시지가 필요하거나 정보를 전달하는 경우 주로 System.out.println()를 이용한다. 하지만 실제 운영 시에는 리소스 낭비로 이어지고 삽입한 코드를 삭제해야하는 문제점도 발생한다. 

즉, 성능 이슈없이 로직의 진행 상황 파악 및 편리한 디버깅을 위해 사용한다.