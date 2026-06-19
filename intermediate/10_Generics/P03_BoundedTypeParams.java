/**
 * ============================================================
 * 학습 목표:
 *   1. 타입 경계(Bounded Type Parameters)를 이용해 타입 제한을 둘 수 있다.
 *   2. <T extends Comparable<T>>를 활용하여 비교 연산이 가능한 타입만 허용한다.
 *   3. <T extends A & B> 형태로 여러 인터페이스/클래스를 동시에 경계로 설정한다.
 *
 * 핵심 개념:
 *   - 상한 경계(Upper Bounded): <T extends SomeClass> - T는 SomeClass이거나 그 하위 타입
 *   - Comparable<T>: compareTo()를 제공하는 인터페이스 (Integer, String 등이 구현)
 *   - Number 클래스: Integer, Double, Long 등의 공통 상위 클래스 (intValue(), doubleValue() 등 제공)
 *   - 다중 경계: <T extends ClassA & InterfaceB & InterfaceC>
 *     - 클래스는 최대 하나, 인터페이스는 여러 개 가능
 *     - 클래스가 있다면 가장 먼저 선언해야 함
 * ============================================================
 */
public class P03_BoundedTypeParams {

    // =========================================================
    // 문제 1: <T extends Comparable<T>>로 최대값 찾기
    // ---------------------------------------------------------
    // 설명:
    //   Comparable을 구현한 타입의 배열에서 최대값을 찾는
    //   제네릭 메소드 findMax()를 구현하세요.
    //   - T extends Comparable<T>를 타입 경계로 사용합니다.
    //   - compareTo() 메소드를 활용하여 원소를 비교합니다.
    //   - 배열이 비어 있거나 null이면 null을 반환합니다.
    //
    // 예상 출력:
    //   정수 배열 최대값: 99
    //   문자열 배열 최대값 (사전순): mango
    //   Double 배열 최대값: 9.9
    //
    // 힌트:
    //   - public static <T extends Comparable<T>> T findMax(T[] arr)
    //   - arr[0]을 초기 최대값으로 설정하고 순회
    //   - if (arr[i].compareTo(max) > 0) max = arr[i];
    // =========================================================
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        // TODO: 배열이 null이거나 길이가 0이면 null을 반환하세요.

        // TODO: arr[0]을 초기 최대값으로 설정하세요.

        // TODO: 배열을 순회하며 compareTo()로 더 큰 값을 찾아 max를 갱신하세요.

        // TODO: 최종 max를 반환하세요.
        return null;
    }

    // =========================================================
    // 문제 2: <T extends Number>로 합계 계산
    // ---------------------------------------------------------
    // 설명:
    //   Number 타입(Integer, Double, Long 등)의 배열을 받아
    //   모든 원소의 합계를 double로 반환하는 제네릭 메소드 sum()을 구현하세요.
    //   - Number 클래스의 doubleValue() 메소드를 활용합니다.
    //   - 결과는 double 타입으로 반환합니다.
    //
    // 예상 출력:
    //   Integer 배열 합계: 15.0
    //   Double 배열 합계: 6.6
    //   혼합 Number 배열 합계: (ArrayList<Number>를 사용하여 테스트)
    //
    // 힌트:
    //   - public static <T extends Number> double sum(T[] arr)
    //   - double total = 0; 초기화
    //   - total += elem.doubleValue(); 로 누적
    // =========================================================
    public static <T extends Number> double sum(T[] arr) {
        // TODO: 합계를 누적할 변수를 선언하고 0으로 초기화하세요.

        // TODO: 배열을 순회하며 각 원소를 doubleValue()로 변환하여 합계에 더하세요.

        // TODO: 최종 합계를 반환하세요.
        return 0.0;
    }

    // =========================================================
    // 문제 3: 여러 경계 (<T extends A & B>)
    // ---------------------------------------------------------
    // 설명:
    //   아래 인터페이스 Printable과 Serializable(java.io.Serializable)을
    //   동시에 구현하는 타입만 허용하는 제네릭 메소드를 구현하세요.
    //
    //   (a) Printable 인터페이스: print() 메소드 선언
    //   (b) PrintableInfo 클래스: Printable과 java.io.Serializable을 구현
    //       - name 필드를 갖고, print()는 "이름: [name]"을 출력
    //
    //   (c) <T extends Printable & java.io.Serializable> void printAll(T[] arr)
    //       - 배열의 모든 원소에 대해 print()를 호출합니다.
    //
    // 예상 출력:
    //   이름: 홍길동
    //   이름: 김철수
    //   이름: 이영희
    //
    // 힌트:
    //   - interface Printable { void print(); }
    //   - class PrintableInfo implements Printable, java.io.Serializable { ... }
    //   - public static <T extends Printable & java.io.Serializable> void printAll(T[] arr)
    // =========================================================

    // TODO: Printable 인터페이스를 선언하세요 (print() 메소드 포함).
    interface Printable {
        void print(); // TODO: 이미 선언됨 — PrintableInfo에서 @Override로 구현하세요.
    }

    // TODO: PrintableInfo 클래스를 선언하세요.
    //       - Printable과 java.io.Serializable을 구현합니다.
    //       - String name 필드를 갖습니다.
    //       - 생성자에서 name을 초기화합니다.
    //       - print()는 "이름: [name]"을 출력합니다.
    static class PrintableInfo implements Printable, java.io.Serializable {
        // TODO: String 타입의 name 필드를 선언하세요.
        String name; // TODO: private으로 변경하세요.

        // TODO: 생성자를 완성하세요.
        PrintableInfo(String name) { this.name = name; }

        // TODO: print() 메소드를 구현하세요.
        @Override
        public void print() {
            // TODO: "이름: " + name 을 출력하세요.
        }
    }

    // TODO: 다중 경계 제네릭 메소드 printAll()을 구현하세요.
    public static <T extends Printable & java.io.Serializable> void printAll(T[] arr) {
        // TODO: 배열의 모든 원소에 대해 print()를 호출하세요.
    }

    // =========================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // =========================================================

    /**
     * Comparable을 구현한 타입의 배열에서 최솟값을 찾는 메소드 (선택 문제)
     */
    public static <T extends Comparable<T>> T findMin(T[] arr) {
        // TODO: (선택) 배열에서 최솟값을 찾아 반환하세요.
        return null;
    }

    /**
     * Number 타입 배열의 평균을 반환하는 메소드 (선택 문제)
     */
    public static <T extends Number> double average(T[] arr) {
        // TODO: (선택) sum()을 활용하여 평균을 반환하세요.
        return 0.0;
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: Comparable 경계로 최대값 찾기 ===");
        Integer[] intArr = {3, 99, 7, 45, 12};
        // TODO: findMax(intArr)를 호출하여 결과를 출력하세요.
        System.out.println("정수 배열 최대값: " /* TODO */);

        String[] strArr = {"apple", "mango", "banana", "grape"};
        // TODO: findMax(strArr)를 호출하여 결과를 출력하세요.
        System.out.println("문자열 배열 최대값 (사전순): " /* TODO */);

        Double[] dblArr = {2.5, 9.9, 1.1, 5.5};
        // TODO: findMax(dblArr)를 호출하여 결과를 출력하세요.
        System.out.println("Double 배열 최대값: " /* TODO */);

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: Number 경계로 합계 계산 ===");
        Integer[] nums1 = {1, 2, 3, 4, 5};
        // TODO: sum(nums1)을 호출하여 결과를 출력하세요.
        System.out.println("Integer 배열 합계: " /* TODO */);

        Double[] nums2 = {1.1, 2.2, 3.3};
        // TODO: sum(nums2)을 호출하여 결과를 출력하세요.
        System.out.println("Double 배열 합계: " /* TODO */);

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 다중 경계 제네릭 메소드 ===");
        PrintableInfo[] people = {
            new PrintableInfo("홍길동"),
            new PrintableInfo("김철수"),
            new PrintableInfo("이영희")
        };
        // TODO: printAll(people)을 호출하세요.
    }
}
