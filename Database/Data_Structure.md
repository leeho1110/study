# Transaction Isolation Level


### Transaction

데이터를 조작하는 작업의 단위로써 Query를 하나의 묶음으로 처리하여 한번 실행되었을 때 모두 수행되거나 혹은 모두 수행되지 않는 작업 수행의 논리적 단위입니다. 

이는 DB서버에 여러 클라이언트가 동시에 작업을 진행하는 경우 위 과정에서 ***데이터 부정합*** 을 방지하고자 할 때 사용합니다. 아래는 트랜잭션을 수행할 때 지켜야하는 4가지 필수조건 **A-C-I-D** 입니다.

1. *Atomicity (원자성)*

    ***All or Nothing*** 의 개념으로 트랜잭션 작업이 부분적으로 성공하는 일이 없도록 보장합니다. 

    은행 송금의 예시를 들자면 A가 B에게 100원을 송금할때 A의 계좌에서 100원이 빠져나갔지만 B의 계좌에 입금되는 과정에서 오류가 발생한다면 A,B의 계좌 모두 이전 상태로 돌아와 **A의 계좌에서 빠져나간 100원이 사라지는 문제** 가 일어나지 않도록 합니다.

2. *Consistency (일관성)*

    트랜잭션이 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 유지하는 것을 의미합니다. 또한 시스템이 가지고 있는 고정요소는 트랜잭션 수행 전과 트랜잭션 수행 완료 후의 상태가 같아야 합니다.

3. *Isolation (격리성)*

    트랜잭션 작업 수행 중에는 다른 트랜잭션에 영향을 주거나 간섭을 받는 일 또는 수행 결과가 참조되지 않도록 하는 것을 의미합니다. 다른 트랜잭션의 영향을 받게 되면 자신의 동작이 달라 질 수 있기 때문에 **고립된 상태에서 수행** 되어야 합니다. 

4. *Durability (지속성)*

    성공적으로 완료된 트랜잭션의 결과는 시스템이 고장나더라도 영구적으로 반영되어야 합니다. **데이터베이스나 OS의 이상 종료 등의 시스템 장애에도 영향을 받아서는 안됩니다**. MySQL을 포함해 많은 데이터베이스의 구현에서는 트랜잭션 조작을 하드 디스크에 로그로 기록하고 시스템에 이상이 발생할 시 로그를 사용해 복원하는 것으로 지속성을 실현하고 있습니다.

<br>

위에서 작성한 트랜잭션의 4가지 원칙들을 지키기 위해서 DB 엔진은 여러 방법을 제공합니다. 하지만 실제로 ACID 원칙을 엄격하게 지키기 위해서는 동시성을 포기해야 합니다. 따라서 DB는 ACID 원칙을 조금 포기하여 동시성, 속도를 얻을 수 있는 방법들을 준비했습니다. 바로 **Locking** 전략과 **Isolation Level** 입니다.

---
### Transaction Isolation Level의 종류

1. **READ UNCOMMITTED**

    각 트랜잭션에서의 변경 내용이 `COMMIT` , `ROLLBACK` 여부에 상관없이 다른 트랜잭션에서 값을 조회하는 것이 가능합니다. 이 때문에 `DIRTY READ` (트랜잭션이 완료되지 않았는데 다른 트랜잭션에서 변경내용을 조회할 수 있는 현상) 가 발생할 가능성이 있고 정합성이 깨지게 되는 문제가 있습니다.
	

    ![https://github.com/leeho1110/TIL/blob/master/img/SERIALIZABLE.png](https://github.com/leeho1110/TIL/blob/master/img/SERIALIZABLE.png)
    <br><br>

2. **READ COMMITTED**

    SQL Server가 Default로 사용하는 Isolation Level로 `COMMIT` 된 데이터만 조회할 수 있습니다. 이 Level에선 SELECT 문장이 수행되는 동안 해당 데이터에 Shared Lock이 걸립니다. 그러므로, 어떠한 사용자가 A라는 데이터를 B라는 데이터로 변경하는 동안 다른 사용자는 해당 데이터(B)에 접근할 수 없습니다. 따라서 `READ UNCOMMITIED` 에서 발생하는 `DIRTY READ`는 발생하지 않습니다. 

    하지만 이 역시 *TRANSACTION-1* 이 `COMMIT` 을 진행한 이후 아직 끝나지 않은 *TRANSACTION-2*가 테이블 값을 읽는 경우 값이 변경되는 위험성이 있습니다. 이때문에 하나의 TRANSCATION 내에서 같은 SELECT 쿼리를 실행했을 때 항상 같은 결과를 가져와야 하는 `REPEATABLE READ`의 정합성에 어긋납니다.

    ![https://github.com/leeho1110/TIL/blob/master/img/READ%20COMMITTED.png](https://github.com/leeho1110/TIL/blob/master/img/READ%20COMMITTED.png)

    ex) 데이터를 업데이트하는 *T1* 이 실행되고, `COMMIT` 이전, 이후로 데이터를 2번 조회하는 *T2* 가 실행되었다고 가정했을 때 첫번째 조회에서는 T1 커밋 전의 데이터 *MIN*, 두번째에서는 T1 커밋 후의 데이터 K*IM* 이 조회되는 `Non-Repeatable Read` 이 발생합니다.
<br><br>
3. **REPEATABLE READ**

    트랜잭션이 완료되기 전까지 한 번 조회한 값은 계속 같은 값이 조회됩니다. 트랜잭션 시작 전에 커밋된 내용에 한해서만 조회되고 데이터 변경 시 UNDO 영역에 백업해두고 실제 레코드를 변경함으로써  `Non-Repeatable Read` 이 발생하지 않습니다. 

    이것이 가능한 이유는 트랜잭션마다 번호를 부여하는 특성때문입니다. 트랜잭션에서 데이터를 조회할때 자신의 트랜잭션 이전에 발생한 트랜잭션(본인의 ID 마다 작은 번호)의 변경 내역만 가져오게 됩니다. 이를 위에서 언급한 UNDO 영역에 백업해놓고 실제 레코드 값을 변경하는 것입니다. 이런 변경 방식을 **MVCC(Multi Version Concurrency Control)** 라고 합니다. 하지만 이는 백업된 레코드 때문에 서버의 처리 성능이 떨어질 가능성이 있기 때문에 불필요하다고 판단되는 시점에 주기적으로 백업 데이터를 삭제해줌으로써 위험성을 제거합니다.

    하지만 이 격리 수준에서도 완벽한 정합성을 보장하지는 않습니다. UPDATE 한 데이터에서는 정합성을 보장하지만 INSERT/DELETE 에선 보장되지 않는 데이터가 유령처럼 사라지거나 없던 데이터가 생기는 `Phantom Read` 문제가 발생하게 됩니다.

    ![https://github.com/leeho1110/TIL/blob/master/img/REPEATABLE%20READ.png](https://github.com/leeho1110/TIL/blob/master/img/REPEATABLE%20READ.png)

    ex) *T1* 로직이 실행되는 중 *T2* 에서 `UPDATE`가 진행되는 경우 *T1* 로직에서는 `COMMIT` 이전의 백업해놓았던 `UNDO` 영역의 데이터를 불러옵니다. 하지만 *T2* 에서 `INSERT, DELETE`가 진행된 경우에는 T1의 기존 조회결과에 없었던 *KIM* 이 노출되는 문제가 발생하고, 이 후 `ROLLBACK` 을 수행한다면 *KIM*은 *T1*의 조회결과에서 사라지게 되는 `Phantom Read` 문제가 발생합니다. 
<br><br>
4. **SERIALIZABLE**

이 격리수준은 가장 강력하게 격리가 가능한 수준으로 트랜잭션이 대해 어떠한 트랜잭션에 대해서도 데이터의 추가/변경/삭제를 허용하지 않습니다. 다라서 하위 3가지의 격리 수준에서 발생한 `Dirty Read`,  `Non-Repeatable Read`, `Phantom Read` 문제가 전혀 발생하지 않으므로 데이터 정합성을 매우 잘 보존합니다. 하지만 동시 처리 성능이 가장 떨어지는 단점이 있습니다. 
<br><br>
아래는 각 격리 수준별 발생가능한 문제를 나열한 표입니다. 

![https://github.com/leeho1110/TIL/blob/master/img/issueByLevel.png](https://github.com/leeho1110/TIL/blob/master/img/issueByLevel.png)

다음 정리내용으로는 **REPEATABLE READ** 에서 발생하는 Lost Update 에 대해서, 그리고 관련된 Locking 에 대해서 알아보고자 합니다. 


--- 
##### 참고자료

- [https://velog.io/@lsb156/Transaction-Isolation-Level](https://velog.io/@lsb156/Transaction-Isolation-Level)

- [https://idea-sketch.tistory.com/45](https://idea-sketch.tistory.com/45)

- [https://private-space.tistory.com/97](https://private-space.tistory.com/97)

- [https://www.stevenjlee.net/2020/06/26/이해하기-데이터베이스-트랜잭션의-기본-속성-acid-그/](https://www.stevenjlee.net/2020/06/26/%EC%9D%B4%ED%95%B4%ED%95%98%EA%B8%B0-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%ED%8A%B8%EB%9E%9C%EC%9E%AD%EC%85%98%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EC%86%8D%EC%84%B1-acid-%EA%B7%B8/)

- [https://nesoy.github.io/articles/2019-05/Database-Transaction-isolation](https://nesoy.github.io/articles/2019-05/Database-Transaction-isolation)
