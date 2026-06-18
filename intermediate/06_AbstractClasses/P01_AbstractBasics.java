/**
 * 파일명: P01_AbstractBasics.java
 * 주제: 추상 클래스 (Abstract Classes)
 *
 * ========================================
 * 학습 목표
 * ========================================
 * 1. abstract 키워드로 추상 클래스와 추상 메소드를 선언하고 자식 클래스에서 구현할 수 있다.
 * 2. 추상 클래스는 직접 인스턴스화할 수 없음을 확인하고 그 이유를 설명할 수 있다.
 * 3. 추상 메소드와 일반 메소드를 혼용하여 공통 기능과 개별 기능을 분리할 수 있다.
 *
 * ========================================
 * 핵심 개념 설명
 * ========================================
 * [추상 클래스 (Abstract Class)]
 *   - abstract 키워드로 선언하는 클래스
 *   - 직접 객체를 생성(new)할 수 없다
 *   - 추상 메소드를 0개 이상 가질 수 있다
 *   - 일반 메소드, 필드, 생성자도 가질 수 있다
 *   - 자식 클래스에서 반드시 모든 추상 메소드를 구현해야 한다
 *
 * [추상 메소드 (Abstract Method)]
 *   - abstract 키워드로 선언하며 메소드 본문(중괄호)이 없다
 *   - 예: abstract double getArea();
 *   - 자식 클래스가 반드시 오버라이딩해야 한다 (강제 계약)
 *   - 추상 클래스 안에만 선언 가능하다
 *
 * [추상 클래스 vs 인터페이스]
 *   - 추상 클래스: 단일 상속만 가능, 상태(필드)와 구현 메소드 보유 가능
 *   - 인터페이스: 다중 구현 가능, Java 8+ default/static 메소드 허용
 *   - 공통 상태와 일부 구현을 공유할 때는 추상 클래스가 적합
 */
public class P01_AbstractBasics {

    // ----------------------------------------
    // 추상 클래스 정의
    // ----------------------------------------

    /**
     * 도형 추상 클래스
     * - 공통 상태(color)와 공통 메소드(printInfo)는 여기에 구현
     * - 도형마다 다른 면적 계산(getArea)은 추상 메소드로 강제
     */
    abstract static class Shape {
        String color;
        String shapeName;

        Shape(String color, String shapeName) {
            this.color = color;
            this.shapeName = shapeName;
        }

        /**
         * 추상 메소드: 도형의 면적을 반환한다.
         * 각 자식 클래스에서 반드시 구현해야 한다.
         */
        abstract double getArea();

        /**
         * 추상 메소드: 도형의 둘레를 반환한다.
         * 각 자식 클래스에서 반드시 구현해야 한다.
         */
        abstract double getPerimeter();

        /**
         * 일반 메소드: 도형 정보를 출력한다. (공통 구현 - 오버라이딩 불필요)
         * getArea()와 getPerimeter()를 호출하므로 자식의 구현이 자동 활용된다.
         */
        void printInfo() {
            System.out.println(shapeName + " [" + color + "] - 면적: "
                    + String.format("%.2f", getArea())
                    + ", 둘레: " + String.format("%.2f", getPerimeter()));
        }

        /**
         * 일반 메소드: 면적을 비교하여 더 큰 도형을 반환한다. (공통 구현)
         */
        Shape getLarger(Shape other) {
            return this.getArea() >= other.getArea() ? this : other;
        }
    }

    // ----------------------------------------
    // 자식 클래스: 원
    // ----------------------------------------

    /** 원 클래스 - Shape의 추상 메소드를 구현 */
    static class Circle extends Shape {
        double radius;

        Circle(String color, double radius) {
            super(color, "원");
            this.radius = radius;
        }

        @Override
        double getArea() {
            // TODO: 원의 면적 = π × r² (Math.PI 활용)
            return 0.0;
        }

        @Override
        double getPerimeter() {
            // TODO: 원의 둘레 = 2 × π × r (Math.PI 활용)
            return 0.0;
        }
    }

    // ----------------------------------------
    // 자식 클래스: 직사각형
    // ----------------------------------------

    /** 직사각형 클래스 - Shape의 추상 메소드를 구현 */
    static class Rectangle extends Shape {
        double width;
        double height;

        Rectangle(String color, double width, double height) {
            super(color, "직사각형");
            this.width = width;
            this.height = height;
        }

        @Override
        double getArea() {
            // TODO: 직사각형 면적 = 가로 × 세로
            return 0.0;
        }

        @Override
        double getPerimeter() {
            // TODO: 직사각형 둘레 = 2 × (가로 + 세로)
            return 0.0;
        }
    }

    // ----------------------------------------
    // 자식 클래스: 삼각형
    // ----------------------------------------

    /** 삼각형 클래스 - Shape의 추상 메소드를 구현 */
    static class Triangle extends Shape {
        double base;
        double height;
        double sideA; // 나머지 두 변 (둘레 계산용)
        double sideB;

        Triangle(String color, double base, double height, double sideA, double sideB) {
            super(color, "삼각형");
            this.base = base;
            this.height = height;
            this.sideA = sideA;
            this.sideB = sideB;
        }

        @Override
        double getArea() {
            // TODO: 삼각형 면적 = 밑변 × 높이 / 2
            return 0.0;
        }

        @Override
        double getPerimeter() {
            // TODO: 삼각형 둘레 = 밑변 + 나머지 두 변의 합
            return 0.0;
        }
    }

    // ----------------------------------------
    // 문제 1: 추상 클래스 구현 및 다형성 활용
    // ----------------------------------------
    /**
     * [문제 1] 추상 클래스 구현체 생성과 다형성
     *
     * 설명:
     *   Circle, Rectangle, Triangle 객체를 생성하고 Shape 배열에 저장한 뒤,
     *   각 도형의 printInfo()를 호출하여 면적과 둘레를 출력하세요.
     *
     * 예상 출력:
     *   =====추상 클래스 구현=====
     *   원 [빨강] - 면적: 78.54, 둘레: 31.42
     *   직사각형 [파랑] - 면적: 24.00, 둘레: 20.00
     *   삼각형 [초록] - 면적: 12.00, 둘레: 18.00
     *
     * 힌트:
     *   - Shape[] shapes = { new Circle(...), new Rectangle(...), new Triangle(...) };
     *   - for (Shape s : shapes) s.printInfo();
     *   - getArea()와 getPerimeter()를 각 자식 클래스에서 구현해야 출력됨
     */
    static void problem1() {
        System.out.println("=====추상 클래스 구현=====");
        // TODO: Circle("빨강", 5.0) 생성
        // TODO: Rectangle("파랑", 4.0, 6.0) 생성
        // TODO: Triangle("초록", 3.0, 8.0, 7.5, 7.5) 생성
        // TODO: Shape 배열에 저장 후 반복문으로 printInfo() 호출
    }

    // ----------------------------------------
    // 문제 2: 추상 클래스 인스턴스화 불가 확인
    // ----------------------------------------
    /**
     * [문제 2] 추상 클래스는 인스턴스화 불가
     *
     * 설명:
     *   추상 클래스 Shape를 직접 new로 생성하려 하면 컴파일 오류가 발생합니다.
     *   아래 주석 처리된 코드를 보고, 왜 오류가 발생하는지 설명하고
     *   올바른 방법으로 Shape 타입 변수를 선언하세요.
     *
     * 예상 출력:
     *   =====추상 클래스 인스턴스화 테스트=====
     *   Shape 타입 변수에 Circle 객체 저장 성공
     *   shapeName: 원, 면적: 78.54
     *   추상 클래스(Shape)는 직접 new로 생성 불가 - 컴파일 오류 발생
     *
     * 힌트:
     *   - new Shape(...) 는 컴파일 오류 → 주석으로 설명
     *   - Shape shape = new Circle("빨강", 5.0); 은 가능 (자식 객체 저장)
     */
    static void problem2() {
        System.out.println("=====추상 클래스 인스턴스화 테스트=====");

        // 아래 코드는 컴파일 오류 발생 - 추상 클래스는 직접 인스턴스화 불가
        // Shape s = new Shape("빨강", "테스트");  // 컴파일 오류!

        // TODO: Shape 타입 변수에 Circle 객체를 대입하여 정상 동작 확인
        // TODO: shapeName과 면적 출력

        System.out.println("추상 클래스(Shape)는 직접 new로 생성 불가 - 컴파일 오류 발생");
    }

    // ----------------------------------------
    // 문제 3: 추상 메소드와 일반 메소드 혼용
    // ----------------------------------------
    /**
     * [문제 3] 추상 메소드 vs 일반 메소드 혼용
     *
     * 설명:
     *   Shape의 일반 메소드 getLarger()와 추상 메소드 getArea()가 함께 동작하는
     *   방식을 확인하세요. getLarger()는 내부적으로 getArea()를 호출하므로,
     *   자식 클래스의 getArea() 구현이 자동으로 활용됩니다.
     *
     * 예상 출력:
     *   =====추상/일반 메소드 혼용=====
     *   원 면적: 78.54
     *   직사각형 면적: 30.00
     *   더 큰 도형: 원 [빨강]
     *   삼각형 면적: 12.00
     *   더 큰 도형: 원 [빨강]
     *
     * 힌트:
     *   - Shape larger = circle.getLarger(rectangle);
     *   - larger.printInfo(); 로 더 큰 도형 출력
     *   - getLarger()는 Shape에 이미 구현되어 있으므로 자식에서 재정의 불필요
     */
    static void problem3() {
        System.out.println("=====추상/일반 메소드 혼용=====");
        // TODO: Circle("빨강", 5.0), Rectangle("파랑", 5.0, 6.0), Triangle("초록", 3.0, 8.0, 7.5, 7.5) 생성
        // TODO: 각 도형의 면적 출력
        // TODO: getLarger()로 가장 큰 도형 찾아 출력
    }

    /**
     * 헬퍼 메소드: Shape 배열에서 전체 면적 합계를 계산한다
     * @param shapes 도형 배열
     * @return 모든 도형의 면적 합계
     */
    static double totalArea(Shape[] shapes) {
        // TODO: 반복문으로 각 shape.getArea() 합산 후 반환
        return 0.0;
    }

    // ----------------------------------------
    // main 메소드
    // ----------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }
}
