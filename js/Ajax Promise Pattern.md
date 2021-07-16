# Ajax Promise Pattern

레거시 코드 중 `g_ajax(url, pars, call_back)` 함수를 callback function (`.success()`, `.error()`)에서 Promise 패턴으로 변경해보는 작업. 

기존 헝가리안식 표기법으로 global용 ajax를 작성한 듯 한데 현재 우리 팀에서는 헝가리안식 표기법을 사용하고 있지 않기도 하고 `success()`, `fail()` 부분을 변경해보고자 진행.

#### 특이점 
서버에서 `ERROR` 가 발생해도 `ajax`는 `200 STATUS`로 인식. 이유는 서버에서는 `500 STATUS` 인 상태일 때 JSP 페이지로 포워딩을 해주기 때문에 `AJAX` 에서는 `200 STATUS` 으로 인식한다 

```java
// 운영:SERVICE단에서 RESULT 값을 자체 처리를 통해 SUCCESS:1 / FAIL : 0 으로 전달
int result = mServ.switchDormancyMemberToNormal(uVO);

JSONObject json = new JSONObject();
json.put("result", result);
        
CommUtil.JSONWrite(response, json);
```

- 서버측 `ERROR`를 그대로 `CommUtil.JSONWrite(response, result);` 으로 return 하는 경우 `Promise Pattern`의 `.fail()`, `callback function Pattern`의 `.error()` 둘다 잘 작동한다.

하지만 위에서 언급한 ERROR PAGE FORWARDING 이 설정되어있는 경우에는 JSP 페이지가 전달 (성공 `200 STATUS`) 되기 때문에 SUCCESS 만 `CALL` 됨