// 유사 배열을 Array로 변환해주는 Array.From() 메소드
// 그리고 IE 호환상때문에 대처 방안으로 찾은 Array.prototype.slice.call() 메소드에 대해서 알아보기

// → jQuery를 사용하지 않고 같은 Class를 갖는 td 태그의 CSS를 수정하는 것이 목적

// 우선 가장 쉽게 ***$(".XXX").css({});*** 로 바로 변경이 가능하다. 하지만 나중에 알게된 사실이기는 하지만 javascript에서는 HtmlCollection을 모두 한번에 수정해주는 메소드는 존재하지 않는다. 
// 따라서 loop를 돌려 각 td마다 클래스를 추가해주는 방법을 사용해야했다.

// 문제는 Array.from() 메소드를 사용하면 HTMLCollection 객체를 Array로 변환하여 map,forEach 메소드를 사용할 수 있는데 ie에서 지원을 하지 않는다. 따라서 같은 동작을 할 수 있게 소스 수정이 필요했다. 
// 그러다 발견한 것이 ***Array.prototype.slice.call()*** 이다. 

// 우선 이해하는데 알아야 할 것이 좀 있었다. 첫번재로는 Array.prototpy.slice() , call() 메소드가 어떤 역할을 하는지와 유사 배열이 무엇인지.
// MDN에서 알 수 있듯이 HTMLCollection은 배열 객체가 아닌 length와 index를 갖는 유사 배열이다. 
// 하지만 보통 slice() 메소드를 사용하는 방식인 ***XXX.slice()*** 로는  사용이 불가능했고, 이 때문에 ***Array.prototype.slice.call()*** 를 사용하게 되었다.

// slice() 는 매개변수로 들어온 배열, start, end index 만큼 shallow copy하여 뱉어주는 함수이다. 
// 하지만 첫번째 매개변수인 배열에는 Array 객체만 가능하기 때문에 우리는 call() 메소드를 통해 HTMLCollection 객체를 넣어준다. 
// 이게 가능한 이유는 call() 메소드를 사용하여 slice()에 매개변수를 넣어주면 arguments는 object 타입이기 때문에 상위 context 변경이 가능하고 따라서 유사배열을 배열로 변형시킬 수 있다. 
// 즉 유사 배열을 배열로 변환하는 경우 ie에서는 ***Array.prototype.slice.call()*** 를 크롬,엣지에서는 ***Array.from()*** 메소드를 사용하면 된다.

// 상위 context 변경이 무엇인지는 좀더 자세히 알아봐야할듯.
