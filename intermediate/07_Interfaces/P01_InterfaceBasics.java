/*
 * =====================================================
 * 파일명: P01_InterfaceBasics.java
 * 주제: 인터페이스 기본 (Interface Basics)
 * =====================================================
 *
 * 【학습목표】
 * 1. 인터페이스(interface)의 개념과 선언 방법을 이해한다.
 * 2. 클래스가 인터페이스를 구현(implements)하는 방법을 익힌다.
 * 3. 인터페이스 타입으로 참조 변수를 선언하여 다형성을 활용한다.
 *
 * 【핵심개념】
 * - 인터페이스(Interface): 추상 메소드와 상수만으로 구성된 설계도(계약서)
 *   → 클래스가 반드시 구현해야 할 메소드의 목록을 정의한다.
 *   → 선언: interface 인터페이스명 { ... }
 *   → 구현: class 클래스명 implements 인터페이스명 { ... }
 *
 * - 인터페이스 멤버의 특징:
 *   → 모든 메소드는 묵시적으로 public abstract (생략 가능)
 *   → 모든 필드는 묵시적으로 public static final (생략 가능)
 *
 * - 인터페이스 타입 참조 변수:
 *   → Flyable f = new Bird();  // 인터페이스 타입으로 구현 객체 참조 가능
 *   → 인터페이스에 선언된 메소드만 호출 가능 (다형성 활용)
 * =====================================================
 */
public class P01_InterfaceBasics {

    // ================================================================
    // 【문제 1】 Flyable 인터페이스 선언 및 Bird, Airplane 구현
    // ================================================================
    /*
     * 문제 제목: Flyable 인터페이스와 구현 클래스
     *
     * 상세 설명:
     *   1) fly() 메소드를 가지는 Flyable 인터페이스를 선언하세요.
     *   2) Flyable을 구현하는 Bird 클래스를 작성하세요.
     *      - fly() 출력: "새가 날개를 퍼덕이며 날아갑니다."
     *      - name 필드(String)를 가지며, 생성자로 초기화
     *   3) Flyable을 구현하는 Airplane 클래스를 작성하세요.
     *      - fly() 출력: "비행기가 엔진을 가동하여 날아갑니다."
     *      - model 필드(String)를 가지며, 생성자로 초기화
     *
     * 예상 출력:
     *   새가 날개를 퍼덕이며 날아갑니다.
     *   비행기가 엔진을 가동하여 날아갑니다.
     *
     * 힌트:
     *   - interface Flyable { void fly(); }
     *   - class Bird implements Flyable { @Override public void fly() { ... } }
     */

    // TODO: Flyable 인터페이스를 선언하세요.
    // (fly() 추상 메소드 포함)


    // TODO: Bird 클래스를 작성하세요. (Flyable 구현)
    // (name 필드, 생성자, fly() 오버라이딩 포함)


    // TODO: Airplane 클래스를 작성하세요. (Flyable 구현)
    // (model 필드, 생성자, fly() 오버라이딩 포함)


    // ================================================================
    // 【문제 2】 인터페이스 상수 (public static final)
    // ================================================================
    /*
     * 문제 제목: 인터페이스 상수 정의 및 활용
     *
     * 상세 설명:
     *   1) FlightConstants 인터페이스를 선언하세요.
     *      - MAX_ALTITUDE: 최대 고도 (int, 값: 12000) → 단위: 미터
     *      - MIN_SPEED: 최소 속도 (int, 값: 200)     → 단위: km/h
     *      - DEFAULT_AIRLINE: 기본 항공사 (String, 값: "Korean Air")
     *   2) FlightInfo 클래스가 FlightConstants를 구현하도록 작성하세요.
     *      - printConstants() 메소드: 세 상수를 출력
     *
     * 예상 출력:
     *   최대 고도: 12000m
     *   최소 속도: 200km/h
     *   기본 항공사: Korean Air
     *
     * 힌트:
     *   - 인터페이스 필드는 자동으로 public static final 이 적용됩니다.
     *   - int MAX_ALTITUDE = 12000;  // 사실상 public static final int MAX_ALTITUDE = 12000;
     *   - 구현 클래스에서 인터페이스명.상수명 또는 상수명 으로 접근 가능
     */

    // TODO: FlightConstants 인터페이스를 선언하세요.
    // (MAX_ALTITUDE, MIN_SPEED, DEFAULT_AIRLINE 상수 포함)


    // TODO: FlightInfo 클래스를 작성하세요. (FlightConstants 구현)
    // (printConstants() 메소드 포함)


    // ================================================================
    // 【문제 3】 인터페이스 타입으로 참조 변수 선언
    // ================================================================
    /*
     * 문제 제목: 인터페이스 타입 참조 변수와 다형성
     *
     * 상세 설명:
     *   1) 문제 1에서 만든 Flyable, Bird, Airplane을 활용합니다.
     *   2) makeItFly(Flyable f) 헬퍼 메소드를 작성하세요.
     *      - 매개변수로 Flyable 타입을 받아 f.fly()를 호출
     *   3) main 메소드에서 다음을 수행하세요:
     *      a) Flyable 타입 배열 flyables[] 에 Bird와 Airplane 객체를 담으세요.
     *      b) 반복문으로 배열을 순회하며 makeItFly()를 호출하세요.
     *      c) instanceof 연산자로 실제 타입을 확인하고 출력하세요.
     *
     * 예상 출력:
     *   --- 비행 시작 ---
     *   새가 날개를 퍼덕이며 날아갑니다.
     *   비행기가 엔진을 가동하여 날아갑니다.
     *   --- 타입 확인 ---
     *   flyables[0]은 Bird 입니다.
     *   flyables[1]은 Airplane 입니다.
     *
     * 힌트:
     *   - Flyable[] flyables = { new Bird("참새"), new Airplane("Boeing747") };
     *   - for (Flyable f : flyables) { makeItFly(f); }
     *   - if (f instanceof Bird) { ... }
     */

    // TODO: makeItFly(Flyable f) 헬퍼 메소드를 작성하세요.
    static void makeItFly(/* TODO: 매개변수 타입과 이름 */ Object f) {
        // TODO: f.fly() 호출
    }

    public static void main(String[] args) {

        System.out.println("=== 문제 1: Flyable 인터페이스 구현 ===");
        // TODO: Bird 객체와 Airplane 객체를 생성하고 fly()를 호출하세요.


        System.out.println("\n=== 문제 2: 인터페이스 상수 활용 ===");
        // TODO: FlightInfo 객체를 생성하고 printConstants()를 호출하세요.
        // TODO: FlightConstants.MAX_ALTITUDE 로 직접 상수에 접근하여 출력하세요.


        System.out.println("\n=== 문제 3: 인터페이스 타입 참조 변수 ===");
        // TODO: Flyable 타입 배열을 만들고 반복문으로 makeItFly()를 호출하세요.
        // TODO: instanceof로 실제 타입을 확인하고 출력하세요.

    }
}
