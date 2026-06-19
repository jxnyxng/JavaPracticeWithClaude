/**
 * ============================================================
 * 파일명: P02_MethodOverriding.java
 * 주제: 메소드 오버라이딩 (@Override)
 * ============================================================
 *
 * [학습 목표]
 * 1. @Override 애노테이션을 사용하여 부모 클래스의 메소드를 재정의할 수 있다.
 * 2. 오버라이딩 규칙(메소드 이름, 매개변수, 반환타입 동일)을 이해할 수 있다.
 * 3. 오버라이딩(재정의)과 오버로딩(중복정의)의 차이를 명확히 구분할 수 있다.
 *
 * [핵심 개념]
 * - 메소드 오버라이딩(Method Overriding):
 *   부모 클래스에서 정의된 메소드를 자식 클래스에서 같은 이름/매개변수/반환타입으로 재정의
 *   → 자식 객체에서 호출 시 자식의 버전이 실행됨
 *
 * - @Override 애노테이션:
 *   컴파일러에게 "이 메소드는 부모 메소드를 오버라이딩한 것"임을 알림
 *   → 철자 오타 등 실수를 컴파일 시점에 오류로 잡아줌
 *
 * - 오버로딩(Overloading) vs 오버라이딩(Overriding) 비교:
 *   오버로딩: 같은 클래스 내에서 이름은 같지만 매개변수가 다른 메소드를 여러 개 정의
 *   오버라이딩: 부모-자식 관계에서 부모의 메소드를 자식이 새롭게 재정의
 * ============================================================
 */
public class P02_MethodOverriding {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: Shape → Circle / Rectangle 오버라이딩 (getArea())
        // ============================================================
        /*
         * [문제 설명]
         * 도형 클래스 Shape와 이를 상속하는 Circle, Rectangle 클래스를 완성하세요.
         * 각 자식 클래스에서 getArea() 메소드를 @Override하여 각 도형의 넓이를 계산하세요.
         *
         * [클래스 구조]
         * Shape (부모)
         *   + getArea() : 0.0 반환 (기본값, 자식이 오버라이딩할 것)
         *   + printInfo(): "도형 넓이: " + getArea() 출력
         *
         * Circle extends Shape
         *   - radius (double) : 반지름
         *   + getArea()       : 원의 넓이 (Math.PI * radius * radius), @Override
         *
         * Rectangle extends Shape
         *   - width (double), height (double)
         *   + getArea()       : 직사각형 넓이 (width * height), @Override
         *
         * [예상 출력]
         * 도형 넓이: 78.53981633974483
         * 도형 넓이: 20.0
         *
         * [힌트]
         * - 원 넓이 공식: Math.PI * radius * radius
         * - 직사각형 넓이 공식: width * height
         */

        System.out.println("=== 문제 1: Shape 오버라이딩 ===");

        Circle circle = new Circle();
        circle.radius = 5.0;
        circle.printInfo();          // 부모 메소드가 자식의 getArea()를 호출

        Rectangle rectangle = new Rectangle();
        rectangle.width = 4.0;
        rectangle.height = 5.0;
        rectangle.printInfo();

        System.out.println();

        // ============================================================
        // 문제 2: @Override 애노테이션의 역할 확인
        // ============================================================
        /*
         * [문제 설명]
         * @Override가 있을 때와 없을 때의 차이를 이해하는 문제입니다.
         * Printer 부모 클래스와 이를 상속하는 ColorPrinter, WrongPrinter 클래스를 확인하세요.
         *
         * [클래스 구조]
         * Printer (부모)
         *   + print() : "흑백 출력" 출력
         *
         * ColorPrinter extends Printer
         *   + print()  : @Override → "컬러 출력" 출력  ← 올바른 오버라이딩
         *
         * WrongPrinter extends Printer
         *   + Print()  : @Override 없음 → 오타여도 컴파일 통과  ← 주의!
         *   (실제로 @Override를 붙이면 컴파일 오류가 남 — 이 사실을 주석으로 설명)
         *
         * [예상 출력]
         * [Printer] 흑백 출력
         * [ColorPrinter] 컬러 출력
         * [WrongPrinter] 흑백 출력  ← Print()는 새 메소드이므로 부모 것이 실행됨
         *
         * [힌트]
         * WrongPrinter에서 print() 대신 Print() (대문자 P)로 작성하면
         * 오버라이딩이 아닌 새 메소드가 되어 부모 버전이 호출됩니다.
         */

        System.out.println("=== 문제 2: @Override 애노테이션 역할 ===");

        Printer p1 = new Printer();
        Printer p2 = new ColorPrinter();    // 다형성 — 자식 객체를 부모 타입으로
        Printer p3 = new WrongPrinter();    // 오타로 오버라이딩 실패 → 부모 메소드 실행

        p1.print();
        p2.print();
        p3.print();

        System.out.println();

        // ============================================================
        // 문제 3: 오버라이딩 vs 오버로딩 차이점
        // ============================================================
        /*
         * [문제 설명]
         * Calculator 클래스에서 오버로딩(Overloading)과
         * AdvancedCalculator에서 오버라이딩(Overriding)을 구분하세요.
         *
         * [클래스 구조]
         * Calculator (부모)
         *   + add(int a, int b)        : 두 정수 합 반환  ← 오버로딩 기준 메소드
         *   + add(int a, int b, int c) : 세 정수 합 반환  ← 오버로딩 (매개변수 개수 다름)
         *   + add(double a, double b)  : 두 실수 합 반환  ← 오버로딩 (타입 다름)
         *   + describe()               : "기본 계산기" 출력
         *
         * AdvancedCalculator extends Calculator
         *   + describe()               : @Override → "고급 계산기" 출력  ← 오버라이딩
         *
         * [예상 출력]
         * 오버로딩 결과 (int, int): 7
         * 오버로딩 결과 (int, int, int): 12
         * 오버로딩 결과 (double, double): 5.5
         * 기본 계산기
         * 고급 계산기
         *
         * [힌트]
         * - 오버로딩: 같은 클래스, 같은 이름, 다른 매개변수
         * - 오버라이딩: 부모-자식 클래스, 같은 이름, 같은 매개변수
         */

        System.out.println("=== 문제 3: 오버로딩 vs 오버라이딩 ===");

        Calculator calc = new Calculator();
        System.out.println("오버로딩 결과 (int, int): " + calc.add(3, 4));
        System.out.println("오버로딩 결과 (int, int, int): " + calc.add(3, 4, 5));
        System.out.println("오버로딩 결과 (double, double): " + calc.add(2.3, 3.2));
        calc.describe();

        AdvancedCalculator adv = new AdvancedCalculator();
        adv.describe();    // 오버라이딩된 메소드 실행
    }
}

// ============================================================
// Shape 클래스 (문제 1 - 부모 클래스)
// ============================================================
class Shape {

    /**
     * 넓이 반환 — 자식 클래스에서 오버라이딩할 메소드
     */
    public double getArea() {
        // TODO: 기본값 0.0을 반환하세요. (자식이 오버라이딩하여 실제 계산)
        return 0.0;
    }

    /**
     * 도형 정보 출력 — getArea()를 호출하므로 자식의 오버라이딩 버전이 실행됨
     */
    public void printInfo() {
        // TODO: "도형 넓이: " + getArea() 를 출력하세요.
    }
}

// ============================================================
// Circle 클래스 (문제 1 - Shape 상속)
// ============================================================
class Circle extends Shape {

    // TODO: radius(double) 필드를 선언하세요.
    double radius;

    /**
     * 원의 넓이 = π * r²
     */
    @Override
    public double getArea() {
        // TODO: Math.PI * radius * radius 를 반환하세요.
        return 0.0; // 임시 반환값 — 완성 후 삭제
    }
}

// ============================================================
// Rectangle 클래스 (문제 1 - Shape 상속)
// ============================================================
class Rectangle extends Shape {

    // TODO: width(double), height(double) 필드를 선언하세요.
    double width;
    double height;

    /**
     * 직사각형 넓이 = 가로 * 세로
     */
    @Override
    public double getArea() {
        // TODO: width * height 를 반환하세요.
        return 0.0; // 임시 반환값 — 완성 후 삭제
    }
}

// ============================================================
// Printer 클래스 (문제 2 - 부모 클래스)
// ============================================================
class Printer {

    public void print() {
        // TODO: "[Printer] 흑백 출력" 을 출력하세요.
    }
}

// ============================================================
// ColorPrinter 클래스 (문제 2 - @Override 올바른 예시)
// ============================================================
class ColorPrinter extends Printer {

    @Override
    public void print() {
        // TODO: "[ColorPrinter] 컬러 출력" 을 출력하세요.
    }
}

// ============================================================
// WrongPrinter 클래스 (문제 2 - @Override 없이 오타 낸 예시)
// ============================================================
class WrongPrinter extends Printer {

    // 주의: 아래 메소드는 print()가 아닌 Print() (대문자 P) — 오타!
    // @Override 없이는 컴파일러가 잡아주지 못함 → 부모의 print()가 그대로 실행됨
    public void Print() {
        // TODO: "[WrongPrinter] 컬러 출력 시도" 를 출력하세요.
        //       하지만 p3.print() 호출 시 이 메소드는 실행되지 않음을 확인하세요!
    }
}

// ============================================================
// Calculator 클래스 (문제 3 - 오버로딩 예시)
// ============================================================
class Calculator {

    /**
     * 두 정수 합산 (오버로딩 기준)
     */
    public int add(int a, int b) {
        // TODO: a + b를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 세 정수 합산 (오버로딩 — 매개변수 개수 다름)
     */
    public int add(int a, int b, int c) {
        // TODO: a + b + c를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 두 실수 합산 (오버로딩 — 타입 다름)
     */
    public double add(double a, double b) {
        // TODO: a + b를 반환하세요.
        return 0.0; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 계산기 설명 출력
     */
    public void describe() {
        // TODO: "기본 계산기" 를 출력하세요.
    }
}

// ============================================================
// AdvancedCalculator 클래스 (문제 3 - 오버라이딩 예시)
// ============================================================
class AdvancedCalculator extends Calculator {

    /**
     * describe() 오버라이딩
     */
    @Override
    public void describe() {
        // TODO: "고급 계산기" 를 출력하세요.
    }
}
