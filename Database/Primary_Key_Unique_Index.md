# PK, Unique Index

업무 관련하여 특정 테이블에 컬럼을 추가해야할 일이 있어 테이블을 살펴보던 중 PK가 없는 것을 발견했습니다. *Not Null Constraints* 를 제외한 어떠한 제약조건도 걸려있지 않은 상태였고, 암시적으로 PK의 역할을 하는 컬럼에만 **Not null**이 들어간 테이블이었습니다. 

테이블을 보며 생각했던 것은 도대체 무슨 생각으로 테이블을 이렇게 만든걸까? 그런데 왜 나는 이걸 지금까지 몰랐을까? 생각 반반이었습니다. 그래서 이번엔 PK가 필요한 이유와 Unique Index 와 PK의 차이를 알아보려 합니다



### *Primary Key ↔ Unique Index*

이 둘의 차이는 무엇일까요. 가장 명확하고도 치명적인 차이를 꼽자면 바로 **Nullable** 입니다. 물론 

- Primary Key 는 *Constraints* 로 제약조건에 속하고, Unique Index 는 *INDEX* 라는 점
- Primary Key 는 암묵적으로 ***Not Null Constraints*** 제약조건을 갖습니다
- Unique Index는 구성 컬럼에 Null 값을 인정합니다 → *Nullable*

따라서 `Select Count(*) from TABLE;`  쿼리에서 옵티마이저는 아래와 같이 실행계획을 세웁니다

→ Primary Key가 없는 경우에는 TSC (Table Full Scan)

![TABLE_FULL_SCAN](./img/TABLE_FULL_SCAN.png)

→ PK가 있는 경우에는 Index Fast Full Scan

![INDEX_FAST_FULL_SCAN](./img/IDX_FAST_FULL_SCAN.png)

*SORT AGGREGATE* 는 전체 ROW를 대상으로 집계를 수행할 떄 나타난다 → `COUNT(*)` 

이 외에 ORDER BY 절을 수행할 때는 *SORT ORDER BY* 

또한 쿼리 뿐만 아니라 데이터베이스의 관리 및 무결성 등 여러가지 측면을 생각한다면 둘의 특성을 정리할 수 있을 것 같습니다. 

우선 Primary Key, Unique Index 모두 유일성은 보장됩니다. 하지만 Unique Index는 PK와 다르게 참조 무결성 지정이 불가능하며, 역공학이 적용될 수 없다는 단점이 있습니다. 

또한 특정 테이블 내에 Primary Key를 부여하는 것은 Unique Index + Not null Constraints 제약조건을  매기는 것 외에도 다른 인스턴스들과 구분할 수 있도록 데이터베이스에게 설명을 해주는 식별자 역할을 합니다. 

즉,  Unique Index는 PK 컬럼의 Unique함을 보장하기 위한 하나의 도구에 불과하며 Primary Key는 단순히 한 컬럼에 위 두가지의 제약조건을 매기는 것 외에도 테이블의 식별자이기 때문에 Unique 해야하며 null값이 허용되서는 안된다는 의미론적인 의미에서 정의되는 것입니다.

```sql
-- PK 조회 쿼리
SELECT A.TABLE_NAME
     , A.CONSTRAINT_NAME
     , B.COLUMN_NAME
     , B.POSITION
  FROM ALL_CONSTRAINTS  A
     , ALL_CONS_COLUMNS B
 WHERE A.TABLE_NAME      = 'TABLE_NAME'
   AND A.CONSTRAINT_TYPE = 'P'
   AND A.OWNER           = B.OWNER, EDATE
   AND A.CONSTRAINT_NAME = B.CONSTRAINT_NAME
 ORDER BY B.POSITION;

-- INDEX 조회 쿼리
SELECT A.TABLE_NAME
     , A.INDEX_NAME
     , A.COLUMN_NAME
  FROM ALL_IND_COLUMNS A
 WHERE A.TABLE_NAME = 'BANNER_INFO'
 ORDER BY A.INDEX_NAME
        , A.COLUMN_POSITION;

-- [출처] https://gent.tistory.com/202, ~/203
```

*[참고링크]*
- [https://m.blog.naver.com/hanajava/220723974615](https://m.blog.naver.com/hanajava/220723974615%E3%84%B9%E3%85%87%E3%85%87)
- [https://myjamong.tistory.com/237](https://myjamong.tistory.com/237) 
- [https://blog.naver.com/soonhg/40033913881](https://blog.naver.com/soonhg/40033913881)