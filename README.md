# oop-study
## 객체지향에 대한 학습 레파지토리 입니다.
  ### oop-basic : 최범균님의 '객체지향 프로그래밍 입문' 강의의 내용을 토대로 내용을 정리
  ### oop-object : 조영호님의 '오브젝트' 서적을 공부하며 내용 정리

## 조영호님 우아한객체지향 영상 시청후 요약 및 후기
> https://www.youtube.com/watch?v=dJ5C4qRqAgA&t=2883s 영상시청후 작성
- 의존성은 한쪽의 변경에 다른쪽이 영향 받는것을 말한다. 의존성은 크게 클래스 의존성과 패키지 의존성이 있다
- 클래스 의존성
  - 연관관계 : A 클래스에서 B클래스를 가지고 있는 형태 = 합성
  - 의존관계 : A클래스내의 메서드에서 B클래스에 대해 파라미터로 받거나, 리턴타입으로 응답하거나, 메서드 내에서 인스턴스로 생성하는 경우 의존관계라고 한다
  - 상속관계 : A클래스에서 B클래스를 상속받는경우
  - 실제화관계 : A클래스에서 B인터페이스를 상속받는 경우
- 패키지 의존성 : 패키지에 포함된 클래스 사이의 의존성을 의미한다. 간단하게 패키지 의존성을 확인하는 방법은 클래스를 열었을때 import구문들을 확인하면 파악할 수 있다
### 좋은 의존성 설계를 위해선?(정답은 아님. 결국 상황에 따라 사용여부가 달라짐)
  - 양방향 의존성을 피해라: 많은 문제가 발생하는 지점들이다. 일반적으로 양방향관계는 하나의 클래스를 억지로 찢어놓은 경우다 왕왕있다고 하는데 양방향관계를 되도록이면 피하고 단방향으로 설계하는 것이 좋다고한다
  - 다중성이 적은 방향을 선택해라: 일반적으로 one-to-many보다 many-to-one 관계가 좋다는 의미이다. jpa만 써도 성능이슈가 많이 발생했었다
  - 의존성이 필요없다면 제거해라
  - 패키지 사이의 의존성 사이클을 제거하라
- 디비와 객체의 관계 맺음이 다른 부분은 디비는 폴인키를 맺어주면 방향상관 없이 왔다갔다가 가능한데 객체는 어떤 형태로든 관계가 있다면 구현을 해줘야 한다.
- 관계의 방향은 = 협력의 방향이자 = 의존성의 방향이다.
- 연관관계는 = 탐색가능성 이다 order가 뭔지 알면 order를 통해 원하는 orderItem의 정보를 찾을수 있다
- 연관관계를 잡는 기준은 두 객체 사이에 협력이 필요하고 두객체의 관계가 영구적이라면(접근해야하는 빈도가 많다면) 연관관계를 이용해 탐색경로를 구현한다
### 객체 참조
- 객체를 참조하는 것은 객체간의 강한 결합도를 만들게 된다. 
- 이것에 대한 대안은 엔티티를 예로 들면 연관관계가 맻힌 클래스를 필드로 가지고 있기보다 해당하는 클래스의 id를 가지고 있으면서 사용해야하는 경우 id로 불러와서 사용하는 경우가 있다
- 다만 그럼 모든 연관관계를 일반 필드로 바꿔야하나? 그건 아니고 어떤 객체들은 묶고 어떤 객체는 분리하는지에 대한 3가지 규칙이 있다
  1) 함께 생성되고 함께 삭제되는 즉 생애주기를 함께하는 객체들은 묶어라 
  - 장바구니를 예로 들면 장바구니 객체내의 장바구니 아이템은 분리해야 할까 묶어야할까? 원칙에 따르면 장바구니가 생성되는 시점과 아이템이 생성되는 시점은 다르다. 아마도 장바구니는 기존에 존재하고 아이템은 아이템을 장바구에 넣을때 비로소 아이템이 생성되고 아이템이 삭제되도 장바구니 자체는 삭제되지 않는다 즉 생애주기가 다르므로 분리해야하는 부분이다.
  2) 도메인 제약사항을 공유하는 객체들을 함께 묶어라
  - 이번에도 장바구니를 예로 들면 만약 도메인 사항에 장바구니에 서로다른 a,b,c제품을 모두 넣을수 있고 이에대한 제약사항이 없다면 분리하는것이 맞다. 그러나 배민을 보게 되면 서로다른 a,b,c제품이더라도 가게가 다르다면 장바구니 성립 자체가 안된다. 그러므로 장바구니와 아이템은 하나의 제약사항을 가진다고 할 수 있으므로 묶는 것이 맞다.
  3) 가능하면 분리하라 
