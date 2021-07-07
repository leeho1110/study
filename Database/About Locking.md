# About Locking



## Lock

Lock은 트랜잭션 처리의 순차성을 보장하기 위해 등장했습니다. 개념은 같지만 DBMS마다 Lock을 구현하는 방식과 세부적인 방법이 상이하므로 각 DB에 맞춰 Lock을 이해하고 사용해야합니다.

### 종류

1. **Shared Lock (Read Lock)**

    `Shared Lock`은 공유 Lock 이라고도 불리며 데이터를 조회할 때(*Read*) 사용됩니다.  데이터를 조회할 때 서로 다른 사용자가 해당 `ROW`에 접근할 수 있습니다. 하지만 공유 Lock이 설정된 데이터에는 `Exclusive Lock`을 사용할 수 없습니다. 

2. **Exclusive Lock (Write Lock)**

    `Exclusive Lock` 은 배타 Lock 이라고도 불리며 데이터를 변경할 때 (*Write*) 사용됩니다. 배타 Lock 은 Lock이 해제될 때까지 다른 트랜잭션의 Read 및 Write를 모두 금합니다. 즉 변경을 진행하고자 하는 Resource에 대한 접근을 원천 차단합니다. 또한 다른 트랙재션이 수행되고있는 데이터에 대해서 함께 Lock을 설정할수도 없습니다.

    아래 그림은 Shared Lock 과 Exclusive Lock 간의 경쟁 여부입니다. 

![https://github.com/leeho1110/TIL/raw/master/img/sLockxLock.png](https://github.com/leeho1110/TIL/raw/master/img/sLockxLock.png)

### Blocking

위 사진처럼 Lock 들이 동시다발적으로 발생하고 경쟁 상태에 돌입하게 되면 자연스럽게 경쟁에서 밀려난 Lock 들이 존재합니다. 예를 들어 특정 row를 `Transcation-1`이 선점하게 되어 뒤이어 진행되어야 하는 `Transaction-2`는 대기하는 상황이 발생하죠. 

이런 Lock 간 경합이 발생하여 `Transaction` 이 작업을 진행시키지 못하고 대기하는 상태를 **Blocking** 이라고 합니다. 이를 해소하기 위해선 먼저 작업을 진행하고있는 `Transaction-1` 이 `COMMIT` 혹은 `ROLLBACK` 되어야 합니다. 하지만 만약 뒤에 밀려있는 트랜잭션이 수백개라면? 이런 경합은 성능에 치명적인 영향을 끼치게 됩니다. 따라서 경합을 최소화할 수 있도록 설계 단계에서 주의해야 합니다. 


### DeadLock
그런데 만약 Blocking이 두 개의 resource에 대해서 동시에 발생한다면 어떻게 될까요. 예시를 통해 설명해보겠습니다.

우선 자료 검색을 진행하다보면 Dead Lock에 빠질 수 있는 조건들과 여러가지들이 나옵니다. 다만 지금은 Dead Lock이 무엇인지부터 이해하도록 하겠습니다.

<br><br>
---

##### 참고링크

- [https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=parkjy76&logNo=220015135826](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=parkjy76&logNo=220015135826)
- [https://suhwan.dev/2019/06/09/transaction-isolation-level-and-lock/](https://suhwan.dev/2019/06/09/transaction-isolation-level-and-lock/)
- [https://myjamong.tistory.com/181](https://myjamong.tistory.com/181)
