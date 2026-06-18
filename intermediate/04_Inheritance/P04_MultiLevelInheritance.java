/**
 * ============================================================
 * 파일명: P04_MultiLevelInheritance.java
 * 주제: 다단계 상속 (Multi-Level Inheritance)
 * ============================================================
 *
 * [학습 목표]
 * 1. 3단계 이상의 다단계 상속 구조를 설계하고 각 레벨에서 기능을 확장할 수 있다.
 * 2. 상속 체인에서 super() 호출이 어떻게 위로 전파되는지 이해할 수 있다.
 * 3. Object 클래스가 모든 클래스의 최상위 부모임을 이해하고 toString, equals를 오버라이딩할 수 있다.
 *
 * [핵심 개념]
 * - 다단계 상속(Multi-Level Inheritance):
 *   A → B → C 처럼 상속이 여러 단계로 이어지는 구조
 *   C는 B의 자식이자 A의 손자 — A와 B의 모든 공개 필드/메소드를 물려받음
 *
 * - 상속 체인 생성자 호출 순서:
 *   C 객체 생성 시: A 생성자 → B 생성자 → C 생성자 순으로 실행
 *
 * - Object 클래스:
 *   자바의 모든 클래스는 묵시적으로 java.lang.Object를 상속받음
 *   주요 메소드: toString(), equals(), hashCode(), getClass() 등
 *   → toString()을 오버라이딩하면 System.out.println(객체) 시 원하는 형식으로 출력 가능
 *   → equals()를 오버라이딩하면 객체 내용 비교 가능 (기본은 주소 비교)
 * ============================================================
 */
public class P04_MultiLevelInheritance {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: Vehicle → Car → ElectricCar 3단계 상속
        // ============================================================
        /*
         * [문제 설명]
         * 3단계 상속 구조를 만들어 각 레벨의 기능을 확인하세요.
         *
         * [클래스 구조]
         * VehicleML (1단계 - 최상위)
         *   - brand (String)
         *   - maxSpeed (int) : 최고 속도
         *   + VehicleML(String brand, int maxSpeed)
         *   + move() : "[brand] 이동 중... (최고 속도: [maxSpeed]km/h)" 출력
         *
         * CarML (2단계) extends VehicleML
         *   - doorCount (int) : 문 개수
         *   + CarML(String brand, int maxSpeed, int doorCount)
         *     → super(brand, maxSpeed) 호출 필수
         *   + honk() : "[brand] 빵빵!" 출력
         *
         * ElectricCar (3단계) extends CarML
         *   - batteryCapacity (int) : 배터리 용량(kWh)
         *   + ElectricCar(String brand, int maxSpeed, int doorCount, int batteryCapacity)
         *     → super(brand, maxSpeed, doorCount) 호출 필수
         *   + charge() : "[brand] 충전 중... (배터리: [batteryCapacity]kWh)" 출력
         *   + getInfo() : 브랜드, 최고속도, 문 개수, 배터리 용량 모두 출력
         *
         * [예상 출력]
         * 테슬라 이동 중... (최고 속도: 250km/h)
         * 테슬라 빵빵!
         * 테슬라 충전 중... (배터리: 100kWh)
         * --- 차량 정보 ---
         * 브랜드: 테슬라
         * 최고 속도: 250km/h
         * 문 개수: 4개
         * 배터리: 100kWh
         *
         * [힌트]
         * ElectricCar는 VehicleML과 CarML의 모든 public 필드/메소드에 접근 가능
         */

        System.out.println("=== 문제 1: 3단계 상속 (Vehicle → Car → ElectricCar) ===");

        ElectricCar tesla = new ElectricCar("테슬라", 250, 4, 100);
        tesla.move();       // VehicleML의 메소드
        tesla.honk();       // CarML의 메소드
        tesla.charge();     // ElectricCar의 메소드
        tesla.getInfo();

        System.out.println();

        // ============================================================
        // 문제 2: 각 레벨에서 기능 확장 확인
        // ============================================================
        /*
         * [문제 설명]
         * 3단계 상속에서 각 레벨의 객체를 만들어 접근 가능한 메소드를 확인하세요.
         *
         * VehicleML 객체 → move() 만 가능
         * CarML 객체      → move() + honk() 가능
         * ElectricCar 객체→ move() + honk() + charge() 모두 가능
         *
         * [예상 출력]
         * [VehicleML] 현대 이동 중... (최고 속도: 180km/h)
         * [CarML] 기아 이동 중... (최고 속도: 200km/h)
         * [CarML] 기아 빵빵!
         * [ElectricCar] 테슬라 이동 중... (최고 속도: 250km/h)
         * [ElectricCar] 테슬라 빵빵!
         * [ElectricCar] 테슬라 충전 중... (배터리: 75kWh)
         *
         * [힌트]
         * 각 레벨의 객체는 자신의 레벨 이하 메소드만 사용 가능
         */

        System.out.println("=== 문제 2: 각 레벨에서 기능 확장 ===");

        VehicleML v = new VehicleML("현대", 180);
        System.out.print("[VehicleML] ");
        v.move();

        CarML c = new CarML("기아", 200, 2);
        System.out.print("[CarML] ");
        c.move();
        System.out.print("[CarML] ");
        c.honk();

        ElectricCar e = new ElectricCar("테슬라", 250, 4, 75);
        System.out.print("[ElectricCar] ");
        e.move();
        System.out.print("[ElectricCar] ");
        e.honk();
        System.out.print("[ElectricCar] ");
        e.charge();

        System.out.println();

        // ============================================================
        // 문제 3: Object 클래스 — toString, equals 오버라이딩
        // ============================================================
        /*
         * [문제 설명]
         * Book 클래스를 만들고 Object 클래스의 toString()과 equals()를 오버라이딩하세요.
         *
         * [클래스 구조]
         * Book
         *   - title (String)  : 제목
         *   - author (String) : 저자
         *   - isbn (String)   : ISBN 번호
         *   + Book(String title, String author, String isbn)
         *   + toString() : @Override
         *       "Book{title='[title]', author='[author]', isbn='[isbn]'}" 반환
         *   + equals(Object obj) : @Override
         *       ISBN이 같으면 같은 책으로 간주 (true 반환)
         *
         * [예상 출력]
         * Book{title='자바의 정석', author='남궁성', isbn='9788994492032'}
         * book1 == book2: false   ← 주소 비교 (다른 객체)
         * book1.equals(book2): true   ← ISBN 비교 (같은 책)
         * book1.equals(book3): false  ← ISBN 다름
         *
         * [힌트]
         * - toString()은 System.out.println(객체) 시 자동 호출됨
         * - equals()에서 instanceof로 타입 체크 후 ISBN을 비교
         *   예) if (!(obj instanceof Book)) return false;
         *       Book other = (Book) obj;
         *       return this.isbn.equals(other.isbn);
         */

        System.out.println("=== 문제 3: Object 클래스 — toString, equals 오버라이딩 ===");

        Book book1 = new Book("자바의 정석", "남궁성", "9788994492032");
        Book book2 = new Book("자바의 정석", "남궁성", "9788994492032"); // 같은 ISBN
        Book book3 = new Book("이펙티브 자바", "조슈아 블로크", "9788966262281");

        System.out.println(book1);                                    // toString() 자동 호출
        System.out.println("book1 == book2: " + (book1 == book2));   // 주소 비교 → false
        System.out.println("book1.equals(book2): " + book1.equals(book2)); // ISBN 비교 → true
        System.out.println("book1.equals(book3): " + book1.equals(book3)); // ISBN 다름 → false
    }
}

// ============================================================
// VehicleML 클래스 (문제 1 - 1단계 최상위)
// ============================================================
class VehicleML {

    // TODO: brand(String), maxSpeed(int) 필드를 선언하세요.

    /**
     * VehicleML 생성자
     */
    public VehicleML(String brand, int maxSpeed) {
        // TODO: this.brand = brand; this.maxSpeed = maxSpeed; 로 초기화하세요.
    }

    /**
     * 이동 메소드
     */
    public void move() {
        // TODO: "[brand] 이동 중... (최고 속도: [maxSpeed]km/h)" 를 출력하세요.
    }
}

// ============================================================
// CarML 클래스 (문제 1 - 2단계, VehicleML 상속)
// ============================================================
class CarML extends VehicleML {

    // TODO: doorCount(int) 필드를 추가하세요.

    /**
     * CarML 생성자 — super()로 VehicleML 생성자 호출
     */
    public CarML(String brand, int maxSpeed, int doorCount) {
        // TODO: super(brand, maxSpeed) 를 첫 줄에 작성하세요.
        //       그 다음 this.doorCount = doorCount; 로 초기화하세요.
    }

    /**
     * 경적 메소드
     */
    public void honk() {
        // TODO: "[brand] 빵빵!" 을 출력하세요.
    }
}

// ============================================================
// ElectricCar 클래스 (문제 1 - 3단계, CarML 상속)
// ============================================================
class ElectricCar extends CarML {

    // TODO: batteryCapacity(int) 필드를 추가하세요.

    /**
     * ElectricCar 생성자 — super()로 CarML 생성자 호출
     */
    public ElectricCar(String brand, int maxSpeed, int doorCount, int batteryCapacity) {
        // TODO: super(brand, maxSpeed, doorCount) 를 첫 줄에 작성하세요.
        //       그 다음 this.batteryCapacity = batteryCapacity; 로 초기화하세요.
    }

    /**
     * 충전 메소드
     */
    public void charge() {
        // TODO: "[brand] 충전 중... (배터리: [batteryCapacity]kWh)" 를 출력하세요.
    }

    /**
     * 전체 정보 출력
     */
    public void getInfo() {
        // TODO: 아래 형식으로 출력하세요.
        //       "--- 차량 정보 ---"
        //       "브랜드: " + brand
        //       "최고 속도: " + maxSpeed + "km/h"
        //       "문 개수: " + doorCount + "개"
        //       "배터리: " + batteryCapacity + "kWh"
    }
}

// ============================================================
// Book 클래스 (문제 3 - Object 오버라이딩)
// ============================================================
class Book {

    // TODO: title(String), author(String), isbn(String) 필드를 선언하세요.

    /**
     * Book 생성자
     */
    public Book(String title, String author, String isbn) {
        // TODO: 세 필드를 초기화하세요.
    }

    /**
     * toString 오버라이딩 — 객체 정보를 문자열로 반환
     */
    @Override
    public String toString() {
        // TODO: "Book{title='[title]', author='[author]', isbn='[isbn]'}" 형식의 문자열을 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * equals 오버라이딩 — ISBN이 같으면 동일한 책으로 판단
     */
    @Override
    public boolean equals(Object obj) {
        // TODO: 1. obj가 Book의 인스턴스가 아니면 false 반환
        //          if (!(obj instanceof Book)) return false;
        //       2. obj를 Book 타입으로 캐스팅: Book other = (Book) obj;
        //       3. this.isbn.equals(other.isbn) 결과를 반환
        return false; // 임시 반환값 — 완성 후 삭제
    }
}
