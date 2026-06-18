/**
 * ================================================================
 * 파일명: P03_AnonymousClass.java
 * 주제: 익명 클래스 (Anonymous Class)
 * ================================================================
 *
 * 【학습 목표】
 * 1. 인터페이스와 추상 클래스를 익명 클래스로 즉석 구현하는 방법을 익힌다.
 * 2. 익명 클래스의 문법 구조와 사용 시기를 이해한다.
 * 3. 익명 클래스와 람다 표현식을 비교하여 각각의 장단점을 파악한다.
 *
 * 【핵심 개념】
 * - 익명 클래스: 이름이 없는 클래스, 선언과 동시에 인스턴스 생성
 * - 사용 시기: 단 한 번만 사용할 클래스를 간략하게 표현할 때
 * - 문법: new 인터페이스/추상클래스() { // 구현 내용 }
 * - 익명 클래스는 인터페이스 또는 추상 클래스를 상속/구현할 수 있음
 * - 람다 vs 익명 클래스:
 *   - 람다: 함수형 인터페이스(추상 메소드 1개)만 구현 가능, 더 간결
 *   - 익명 클래스: 여러 메소드 구현 가능, 상태(필드) 보유 가능
 * ================================================================
 */
public class P03_AnonymousClass {

    // ================================================================
    // 문제 1에서 사용할 인터페이스 정의
    // ================================================================
    interface Greeting {
        void greet(String name);
        default void farewell(String name) {
            System.out.println("안녕히 가세요, " + name + "님!");
        }
    }

    interface Calculator {
        int calculate(int a, int b);
    }

    interface Sortable {
        int compare(int a, int b); // 양수: a>b, 0: a==b, 음수: a<b
        default String getDescription() {
            return "정렬 가능한 비교기";
        }
    }

    // ================================================================
    // 문제 2에서 사용할 추상 클래스 정의
    // ================================================================
    abstract static class Shape {
        protected String color;

        public Shape(String color) {
            this.color = color;
        }

        public abstract double getArea();
        public abstract String getName();

        public void displayInfo() {
            System.out.println("도형: " + getName());
            System.out.println("색상: " + color);
            System.out.printf("넓이: %.2f%n", getArea());
        }
    }

    abstract static class Animal {
        protected String name;
        protected int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public abstract String makeSound();
        public abstract String getType();

        public void introduce() {
            System.out.println("이름: " + name + ", 나이: " + age + "살");
            System.out.println("종류: " + getType());
            System.out.println("소리: " + makeSound());
        }
    }

    // ================================================================
    // 문제 1: 인터페이스를 익명 클래스로 구현
    // ================================================================
    /**
     * 【문제 1】 인터페이스 익명 구현
     *
     * 설명:
     *   main 메소드에서 다음 3개의 인터페이스를 익명 클래스로 구현하세요.
     *
     *   (1) Greeting 인터페이스를 익명 클래스로 구현:
     *       greet() 메소드는 "안녕하세요, X님! 반갑습니다." 출력
     *       farewell() 메소드는 이미 default 구현이 있으므로 선택적으로 오버라이드
     *
     *   (2) Calculator 인터페이스를 여러 익명 클래스로 구현:
     *       덧셈 계산기: calculate(a, b) -> a + b
     *       곱셈 계산기: calculate(a, b) -> a * b
     *
     *   (3) Sortable 인터페이스 구현:
     *       오름차순 비교기: a < b 이면 음수 반환
     *       내림차순 비교기: a > b 이면 음수 반환
     *
     * 예상 출력:
     *   [Greeting 익명 클래스]
     *   안녕하세요, 홍길동님! 반갑습니다.
     *   안녕히 가세요, 홍길동님!
     *
     *   [Calculator 익명 클래스]
     *   덧셈: 10 + 5 = 15
     *   곱셈: 10 * 5 = 50
     *
     *   [Sortable 익명 클래스]
     *   오름차순 비교 (3, 7): -1 (3이 7보다 작음)
     *   내림차순 비교 (3, 7): 1 (3이 7보다 큼으로 내림차순에서 앞에 위치)
     *
     * 힌트:
     *   - 익명 클래스 기본 문법:
     *     인터페이스명 변수명 = new 인터페이스명() {
     *         @Override
     *         public 반환타입 메소드명(매개변수) {
     *             // 구현
     *         }
     *     };
     *   - 인터페이스의 모든 추상 메소드를 반드시 구현해야 합니다.
     */
    static void problem1_InterfaceAnonymousClass() {
        System.out.println("[Greeting 익명 클래스]");
        // TODO: Greeting 인터페이스를 익명 클래스로 구현
        // Greeting greeting = new Greeting() {
        //     @Override
        //     public void greet(String name) {
        //         // TODO: 구현
        //     }
        // };
        // TODO: greeting.greet("홍길동") 호출
        // TODO: greeting.farewell("홍길동") 호출

        System.out.println("\n[Calculator 익명 클래스]");
        // TODO: 덧셈 Calculator 익명 클래스 구현 및 테스트 (10, 5)
        // TODO: 곱셈 Calculator 익명 클래스 구현 및 테스트 (10, 5)

        System.out.println("\n[Sortable 익명 클래스]");
        // TODO: 오름차순 Sortable 익명 클래스 구현
        //       compare(3, 7): 3 < 7 이므로 음수(-1) 반환
        // TODO: 내림차순 Sortable 익명 클래스 구현
        //       compare(3, 7): 내림차순에서 3이 7보다 뒤에 오므로 양수(1) 반환
    }

    // ================================================================
    // 문제 2: 추상 클래스를 익명 클래스로 구현
    // ================================================================
    /**
     * 【문제 2】 추상 클래스 익명 구현
     *
     * 설명:
     *   main 메소드에서 다음 추상 클래스들을 익명 클래스로 구현하세요.
     *
     *   (1) Shape 추상 클래스를 익명 클래스로 구현:
     *       - 원(Circle): radius = 5.0, 넓이 = Math.PI * radius * radius
     *       - 직사각형(Rectangle): width = 4.0, height = 6.0, 넓이 = width * height
     *       주의: 익명 클래스는 생성자를 직접 정의할 수 없지만,
     *             추상 클래스의 생성자를 super처럼 호출할 수 있습니다.
     *             new Shape("빨간색") { ... } 형태로 생성
     *
     *   (2) Animal 추상 클래스를 익명 클래스로 구현:
     *       - 강아지: "멍멍!", 종류 "포유류"
     *       - 새: "짹짹!", 종류 "조류"
     *
     * 예상 출력:
     *   [Shape 추상 클래스 - Circle]
     *   도형: 원
     *   색상: 빨간색
     *   넓이: 78.54
     *
     *   [Shape 추상 클래스 - Rectangle]
     *   도형: 직사각형
     *   색상: 파란색
     *   넓이: 24.00
     *
     *   [Animal 추상 클래스]
     *   이름: 바둑이, 나이: 3살
     *   종류: 포유류
     *   소리: 멍멍!
     *   이름: 짹짹이, 나이: 1살
     *   종류: 조류
     *   소리: 짹짹!
     *
     * 힌트:
     *   - 추상 클래스 익명 구현 문법:
     *     Shape circle = new Shape("빨간색") {
     *         // radius 같은 추가 필드도 선언 가능
     *         double radius = 5.0;
     *         @Override
     *         public double getArea() { return Math.PI * radius * radius; }
     *         @Override
     *         public String getName() { return "원"; }
     *     };
     *   - 익명 클래스 내에 추가 필드와 메소드를 선언할 수 있습니다.
     */
    static void problem2_AbstractClassAnonymous() {
        System.out.println("[Shape 추상 클래스 - Circle]");
        // TODO: Shape를 익명 클래스로 구현하여 원(Circle) 생성
        //       color = "빨간색", radius = 5.0

        System.out.println("\n[Shape 추상 클래스 - Rectangle]");
        // TODO: Shape를 익명 클래스로 구현하여 직사각형(Rectangle) 생성
        //       color = "파란색", width = 4.0, height = 6.0

        System.out.println("\n[Animal 추상 클래스]");
        // TODO: Animal을 익명 클래스로 구현하여 강아지 생성 ("바둑이", 3)
        // TODO: Animal을 익명 클래스로 구현하여 새 생성 ("짹짹이", 1)
    }

    // ================================================================
    // 문제 3: 익명 클래스 vs 람다 비교
    // ================================================================
    /**
     * 【문제 3】 익명 클래스와 람다 표현식 비교
     *
     * 설명:
     *   동일한 기능을 익명 클래스와 람다 두 가지 방법으로 구현하고 차이를 비교하세요.
     *
     *   (1) Runnable 인터페이스 구현 비교:
     *       익명 클래스: new Runnable() { public void run() { ... } }
     *       람다: () -> { ... }
     *       내용: "작업 실행 중..." 출력
     *
     *   (2) Calculator 인터페이스 구현 비교:
     *       익명 클래스와 람다로 각각 뺄셈 계산기 구현
     *       calculate(20, 8) -> 12
     *
     *   (3) 익명 클래스만 가능한 경우 (다중 메소드):
     *       Greeting 인터페이스는 greet()와 farewell() 두 메소드를 가집니다.
     *       익명 클래스로만 구현하고, 람다로 구현할 수 없는 이유를 주석으로 작성하세요.
     *
     * 예상 출력:
     *   [익명 클래스 vs 람다 - Runnable]
     *   익명 클래스: 작업 실행 중...
     *   람다: 작업 실행 중...
     *
     *   [익명 클래스 vs 람다 - Calculator (뺄셈)]
     *   익명 클래스 결과: 20 - 8 = 12
     *   람다 결과: 20 - 8 = 12
     *
     *   [익명 클래스만 가능 - Greeting (다중 메소드)]
     *   안녕하세요, 김철수님! 반갑습니다.
     *   안녕히 가세요, 김철수님!
     *   (람다 불가: Greeting은 추상 메소드가 2개이므로 함수형 인터페이스가 아님)
     *
     * 힌트:
     *   - 람다는 @FunctionalInterface (추상 메소드 1개)만 구현 가능합니다.
     *   - Runnable의 run()은 이미 java.lang에 정의된 함수형 인터페이스입니다.
     *   - 람다 문법: (매개변수) -> { 구현 } 또는 단일 표현식은 {} 생략 가능
     *   - 익명 클래스: 상태(필드)를 가질 수 있고, 여러 메소드를 구현할 수 있습니다.
     */
    static void problem3_AnonymousVsLambda() {
        System.out.println("[익명 클래스 vs 람다 - Runnable]");
        // TODO: 익명 클래스로 Runnable 구현 후 run() 호출
        // System.out.print("익명 클래스: ");
        // Runnable r1 = new Runnable() { ... };
        // r1.run();

        // TODO: 람다로 Runnable 구현 후 run() 호출
        // System.out.print("람다: ");
        // Runnable r2 = () -> ...;
        // r2.run();

        System.out.println("\n[익명 클래스 vs 람다 - Calculator (뺄셈)]");
        // TODO: 익명 클래스로 뺄셈 Calculator 구현 및 테스트 (20, 8)
        // TODO: 람다로 뺄셈 Calculator 구현 및 테스트 (20, 8)

        System.out.println("\n[익명 클래스만 가능 - Greeting (다중 메소드)]");
        // TODO: Greeting을 익명 클래스로 구현 (greet, farewell 모두 구현)
        //       greet("김철수") 및 farewell("김철수") 호출
        // TODO: 주석으로 람다가 불가능한 이유 설명
        // /* 람다 불가: Greeting 인터페이스는 추상 메소드가 greet()와 farewell() 2개이므로
        //    함수형 인터페이스(@FunctionalInterface) 조건을 충족하지 않습니다. */
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: 인터페이스를 익명 클래스로 구현 ===");
        problem1_InterfaceAnonymousClass();

        System.out.println("\n=== 문제 2: 추상 클래스를 익명 클래스로 구현 ===");
        problem2_AbstractClassAnonymous();

        System.out.println("\n=== 문제 3: 익명 클래스 vs 람다 비교 ===");
        problem3_AnonymousVsLambda();
    }
}
