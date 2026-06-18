/**
 * 파일명: P03_Casting.java
 * 주제: 형변환 심화 (Advanced Casting)
 *
 * ========================================
 * 학습 목표
 * ========================================
 * 1. 부모 타입 매개변수를 활용하여 다양한 자식 객체를 하나의 메소드로 처리할 수 있다.
 * 2. 형변환 체인(연속 형변환)의 동작 원리와 주의사항을 이해한다.
 * 3. 다형성을 활용한 도형 면적 계산기를 설계하고 구현할 수 있다.
 *
 * ========================================
 * 핵심 개념 설명
 * ========================================
 * [부모 타입 매개변수 활용]
 *   - 메소드 매개변수를 부모 타입으로 선언하면 모든 자식 객체를 받을 수 있다
 *   - 내부에서 instanceof로 실제 타입을 구분하여 처리
 *   - 예: void process(Shape shape) → Circle, Rectangle 등 모두 전달 가능
 *
 * [형변환 체인]
 *   - A → B → C 처럼 연속으로 형변환하는 것
 *   - 중간 단계 타입과 실제 객체 타입의 관계를 정확히 파악해야 한다
 *   - 잘못된 체인은 ClassCastException 발생
 *
 * [다형성과 도형 계산기]
 *   - 도형(Shape)을 부모로, Circle/Rectangle/Triangle을 자식으로 설계
 *   - Shape 배열에 모든 도형을 담고 반복문으로 면적 합산 가능
 *   - 각 도형의 면적 계산 공식이 다르지만, 같은 메소드명(getArea)으로 호출
 */
public class P03_Casting {

    // ----------------------------------------
    // 도형 클래스 계층 정의
    // ----------------------------------------

    /** 도형 부모 클래스 */
    static class Shape {
        String color;

        Shape(String color) {
            this.color = color;
        }

        /** 면적을 반환하는 메소드 (자식에서 오버라이딩) */
        double getArea() {
            return 0.0;
        }

        /** 도형 정보 출력 */
        void printInfo() {
            System.out.println("도형 색상: " + color + ", 면적: " + getArea());
        }
    }

    /** 원 클래스 */
    static class Circle extends Shape {
        double radius;

        Circle(String color, double radius) {
            super(color);
            this.radius = radius;
        }

        @Override
        double getArea() {
            // TODO: 원의 면적 공식(πr²)으로 계산하여 반환 (Math.PI 활용)
            return 0.0;
        }

        void printCircleInfo() {
            System.out.println("원 - 색상: " + color + ", 반지름: " + radius + ", 면적: " + getArea());
        }
    }

    /** 직사각형 클래스 */
    static class Rectangle extends Shape {
        double width;
        double height;

        Rectangle(String color, double width, double height) {
            super(color);
            this.width = width;
            this.height = height;
        }

        @Override
        double getArea() {
            // TODO: 직사각형의 면적 공식(가로 × 세로)으로 계산하여 반환
            return 0.0;
        }

        void printRectangleInfo() {
            System.out.println("직사각형 - 색상: " + color + ", 가로: " + width + ", 세로: " + height + ", 면적: " + getArea());
        }
    }

    /** 삼각형 클래스 */
    static class Triangle extends Shape {
        double base;
        double height;

        Triangle(String color, double base, double height) {
            super(color);
            this.base = base;
            this.height = height;
        }

        @Override
        double getArea() {
            // TODO: 삼각형의 면적 공식(밑변 × 높이 / 2)으로 계산하여 반환
            return 0.0;
        }

        void printTriangleInfo() {
            System.out.println("삼각형 - 색상: " + color + ", 밑변: " + base + ", 높이: " + height + ", 면적: " + getArea());
        }
    }

    // ----------------------------------------
    // 문제 1: 부모 타입 매개변수로 다양한 자식 처리
    // ----------------------------------------
    /**
     * [문제 1] 부모 타입 매개변수 활용
     *
     * 설명:
     *   Shape 타입을 매개변수로 받는 describeShape() 메소드를 완성하고,
     *   instanceof로 실제 타입을 판별하여 각 도형에 맞는 정보를 출력하세요.
     *
     * 예상 출력:
     *   =====부모 타입 매개변수 활용=====
     *   [원 정보]
     *   원 - 색상: 빨강, 반지름: 5.0, 면적: 78.54
     *   [직사각형 정보]
     *   직사각형 - 색상: 파랑, 가로: 4.0, 세로: 6.0, 면적: 24.0
     *   [삼각형 정보]
     *   삼각형 - 색상: 초록, 밑변: 3.0, 높이: 8.0, 면적: 12.0
     *
     * 힌트:
     *   - describeShape(Shape shape) 메소드 안에서 instanceof로 분기
     *   - Circle이면 printCircleInfo(), Rectangle이면 printRectangleInfo() 호출
     */
    static void problem1() {
        System.out.println("=====부모 타입 매개변수 활용=====");

        System.out.println("[원 정보]");
        describeShape(new Circle("빨강", 5.0));

        System.out.println("[직사각형 정보]");
        describeShape(new Rectangle("파랑", 4.0, 6.0));

        System.out.println("[삼각형 정보]");
        describeShape(new Triangle("초록", 3.0, 8.0));
    }

    /**
     * 헬퍼 메소드: Shape 타입을 받아 실제 타입에 맞는 정보 출력
     * @param shape 정보를 출력할 도형 객체 (어떤 자식 타입도 가능)
     */
    static void describeShape(Shape shape) {
        // TODO: instanceof로 Circle, Rectangle, Triangle 구분
        // TODO: 각 타입에 맞게 다운캐스팅 후 해당 printXxxInfo() 메소드 호출
    }

    // ----------------------------------------
    // 문제 2: 형변환 체인
    // ----------------------------------------
    /**
     * [문제 2] 형변환 체인
     *
     * 설명:
     *   Circle → Shape → Circle 순서로 형변환 체인을 수행하고,
     *   각 단계에서 접근 가능한 멤버와 실제 동작을 확인하세요.
     *   또한 잘못된 체인(Circle → Shape → Rectangle)의 위험성도 확인하세요.
     *
     * 예상 출력:
     *   =====형변환 체인=====
     *   [단계 1: Circle → Shape (업캐스팅)]
     *   Shape 타입으로 getArea 호출: 78.54
     *   [단계 2: Shape → Circle (다운캐스팅)]
     *   다시 Circle로: 반지름 = 5.0
     *   [잘못된 체인 시도: Shape(실제 Circle) → Rectangle]
     *   ClassCastException 발생! 실제 객체는 Circle인데 Rectangle로 캐스팅 불가
     *
     * 힌트:
     *   - Shape shapeRef = new Circle("빨강", 5.0);  // 업캐스팅
     *   - Circle circleRef = (Circle) shapeRef;       // 다운캐스팅 (가능: 실제 Circle이므로)
     *   - Rectangle rectRef = (Rectangle) shapeRef;  // 오류: 실제 Circle이라 불가
     */
    static void problem2() {
        System.out.println("=====형변환 체인=====");

        System.out.println("[단계 1: Circle → Shape (업캐스팅)]");
        // TODO: Circle 객체를 Shape 타입 변수에 대입 (업캐스팅)
        // TODO: Shape 타입 변수로 getArea() 호출하여 결과 출력

        System.out.println("[단계 2: Shape → Circle (다운캐스팅)]");
        // TODO: Shape 타입 변수를 Circle로 다운캐스팅
        // TODO: Circle의 radius 출력

        System.out.println("[잘못된 체인 시도: Shape(실제 Circle) → Rectangle]");
        // TODO: try-catch로 Circle을 Rectangle로 캐스팅 시도 후 예외 메시지 출력
    }

    // ----------------------------------------
    // 문제 3: 다형성 활용 도형 면적 계산기
    // ----------------------------------------
    /**
     * [문제 3] 다형성 활용 도형 면적 계산기
     *
     * 설명:
     *   Shape 배열에 여러 도형을 저장하고, 반복문으로 모든 도형의 면적을 합산하는
     *   도형 면적 계산기를 완성하세요. 각 도형의 면적도 개별 출력하세요.
     *
     * 예상 출력:
     *   =====도형 면적 계산기=====
     *   원(빨강) 면적: 78.54
     *   직사각형(파랑) 면적: 24.00
     *   삼각형(초록) 면적: 12.00
     *   원(노랑) 면적: 28.27
     *   직사각형(보라) 면적: 35.00
     *   -------------------------
     *   총 도형 수: 5
     *   전체 면적 합계: 177.81
     *   평균 면적: 35.56
     *
     * 힌트:
     *   - Shape[] shapes 배열에 5개 도형 저장
     *   - for문으로 각 shape.getArea() 호출 (동적 바인딩 자동 적용)
     *   - 합계를 누적하고 마지막에 총합/평균 출력
     *   - 면적 출력은 String.format("%.2f", area) 활용
     */
    static void problem3() {
        System.out.println("=====도형 면적 계산기=====");

        // TODO: Shape 배열에 5개 도형 저장
        //   - Circle("빨강", 5.0)
        //   - Rectangle("파랑", 4.0, 6.0)
        //   - Triangle("초록", 3.0, 8.0)
        //   - Circle("노랑", 3.0)
        //   - Rectangle("보라", 5.0, 7.0)

        // TODO: 반복문으로 각 도형 면적 출력 및 합계 누적

        // TODO: 총 도형 수, 전체 면적 합계, 평균 면적 출력
    }

    /**
     * 헬퍼 메소드: Shape 배열에서 최대 면적 도형을 반환한다
     * @param shapes 도형 배열
     * @return 가장 면적이 큰 도형
     */
    static Shape findLargestShape(Shape[] shapes) {
        // TODO: 반복문으로 최대 면적 도형 찾아 반환
        return null;
    }

    /**
     * 헬퍼 메소드: 특정 색상의 도형만 골라 면적 합계를 반환한다
     * @param shapes 도형 배열
     * @param color  필터링할 색상
     * @return 해당 색상 도형들의 면적 합계
     */
    static double sumAreaByColor(Shape[] shapes, String color) {
        // TODO: 색상이 일치하는 도형의 면적만 합산하여 반환
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
