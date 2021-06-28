# JS Eval() 함수

→ 회사 내부에서 비동기식으로 JSON 데이터를 전달하는 경우  거의 99%의 확률로 작성되어 있었던,그리고 그 누구도 바꾸지 않았던 eval() 함수에 대해서 알아보려 합니다.

 *`eval()`* 함수를 검색하자마자 나오는 것들은 대부분 *"사용하지 말아라"* 였습니다. 이유는 무엇일까요?

1. ***Scope Chain***

    ```jsx
    console.log(typeof un); // 'undefined' 가 기록된다. 
    console.log(typeof deux); // 'undefined' 가 기록된다. 
    console.log(typeof trois); // 'undefined' 가 기록된다. 

    var jsstring = 'var un = 1; console.log(un);'; 
    eval(jsstring); // 1 이 기록된다. 

    jsstring = 'var deux = 2; console.log(deux);'; 
    new Function(jsstring)(); // 2 가 기록된다 

    jsstring = 'var trois = 3; console.log(trois);'; 
    (function () { eval(jsstring); })(); // 3 이 기록된다. 

    // 전역 스코프에서 변수들을 체크해 본다. 
    console.log(typeof un); // number 가 기록된다. 
    console.log(typeof un); // undefined 가 기록된다. 
    console.log(typeof un); // undefined 가 기록된다.

    // 출처: https://webclub.tistory.com/512 [Web Club]
    ```

이 경우 `eval`을 통해 선언이 된 jsstring의 경우 전역변수에 남아 변수들의 Scope Chain의 영향을 끼칠 수 있습니다. 하지만 `new Function()`의 경우는 조금 더 위험성이 낮습니다.
