# 키오스크 만들기
[TIL 블로그 링크](https://rvrlo.tistory.com/entry/WIL-4%EC%A3%BC%EC%B0%A8-%EA%B3%BC%EC%A0%9C-%ED%82%A4%EC%98%A4%EC%8A%A4%ED%81%AC-%EB%A7%8C%EB%93%A4%EA%B8%B0) <br>
[트러블 슈팅 링크](https://rvrlo.tistory.com/entry/%ED%82%A4%EC%98%A4%EC%8A%A4%ED%81%AC-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EA%B0%9C%EB%B0%9C-%ED%8A%B8%EB%9F%AC%EB%B8%94-%EC%8A%88%ED%8C%85-%EC%A0%95%EB%A6%AC)

<br><br>

## 목차
[1. 제품을 나타내는 Item](#1-item) <br>
[2. 제품 카테고리를 구성하는 Menu](#2-menu) <br>
[3. 장바구니를 위한 ShppingCart](#3-shoppingcart) <br>
[4. 할인율 계산 Discount](#4-discount) <br>
[5. 화면에 나타낼 Display](#5-display) <br>
[6. 사용자가 사용할 Kisok](#6-kiosk) <br>

<br><br><br>

## 구현도 및 모듈 설명

### 1. Item
![Item](https://github.com/user-attachments/assets/a22d24b3-6082-41fe-84ae-d635d4f3e539)

<b>제품을 나타내는 인터페이스 Item, 활용하는 추상클래스 Product</b>
- 전체 메뉴에서 나타내는 제품은 MenuItem
- 장바구니에 담은 제품은 CartItem

<br>

### 2. Menu
![Menu](https://github.com/user-attachments/assets/656fa2ca-e018-4de6-8e02-b749da8a3a1c)

<b>전체 메뉴 Category, 소메뉴 Burgers, Drinks, Desserts -> 상속받아 관리하는 Menu</b>
- 각 제품 유형은 인터페이스로 존재하며 자기만의 static필드 사용 Burgers, Drinks, Desserts
- 추상클래스 Menu는 이 인터페이스를 활용
- 직접 구현하는 것은 인터페이스의 static 필드에 제품을 넣어서 사용할 일반클래스
- List&lt;MenuItem&gt;에 제품을 넣어 사용

<br>

### 3. ShoppingCart

<b>장바구니를 위한 ShoppingCart</b>
- 메뉴를 선택하면 해당 제품을 장바구니에 저장
- 장바구니에 제품이 존재하지 않으면 전체 메뉴에서 장바구니 선택 제외
- List&lt;CartItem&gt;에 제품을 넣어 사용

<br>

### 4. Discount

<b>Enum 값을 이용해 할인을 계산하는 Discount</b>
- 상수값(String, int)로 구성되어 String은 할인유협, int는 할인율 저장
- 할인율 계산 : ( 100 - int ) * 0.01
- Math.floor로 소수점 2 미만 버림 : (할인율 * 수량 * 100) / 100.0;

<br>

### 5. Display

<b>메뉴 등을 화면에 보여주기 위한 Display</b>
- Kiosk에서 메뉴를 선택하고, 어떤 제품의 정보를 가져올지 구분하는 Display
- 메뉴를 관리하는 Menu와 메뉴를 사용하는 Display로 기능을 분리하기 위해 생성

<br>

### 6. Kiosk

<b>사용자가 사용하는 Kiosk</b>
- Client가 직접 접근하는 Kiosk
- 전체 흐름을 관리하며, 사용자에게 정보를 제공하는 역할



