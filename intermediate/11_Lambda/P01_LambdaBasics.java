/**
 * 파일명: P01_LambdaBasics.java
 * 주제: 람다 표현식 기본 (Lambda Expression Basics)
 *
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. 익명 클래스(Anonymous Class)를 람다 표현식으로 변환할 수 있다.
 * 2. 람다 표현식의 세 가지 문법 형태를 이해하고 작성할 수 있다.
 * 3. 람다 내부에서 외부 변수를 캡처하는 규칙(effectively final)을 이해한다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [람다 표현식이란?]
 * - 함수형 인터페이스(추상 메소드가 1개인 인터페이스)를 구현하는 간결한 방법
 * - 형식: (매개변수) -> { 실행코드 }
 * - 자바 8부터 도입되어 코드를 더 간결하게 작성 가능
 *
 * [람다의 3가지 문법 형태]
 * - 블록 형태:       (x, y) -> { return x + y; }
 * - 단일 표현식:     (x, y) -> x + y
 * - 매개변수 없음:   () -> System.out.println("hello")
 *
 * [effectively final이란?]
 * - 람다 내부에서 외부 지역 변수를 사용할 때,
 *   그 변수는 final이거나 사실상 final(값이 변경되지 않는)이어야 함
 * - final 키워드 없이도 값이 변경되지 않으면 캡처 가능
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P01_LambdaBasics {

    public static void main(String[] args) {
        System.out.println("===== 람다 표현식 기본 =====\n");

        problem1_AnonymousToLambda();
        problem2_LambdaSyntaxForms();
        problem3_VariableCapture();
    }

    // =====================================================
    // 문제 1: 익명 클래스를 람다로 변환
    // =====================================================
    /**
     * [문제 1] 익명 클래스 → 람다 변환 (Runnable, Comparator)
     *
     * 설명:
     *   아래에 익명 클래스 방식으로 작성된 Runnable과 Comparator가 있습니다.
     *   이를 람다 표현식으로 변환하여 동일하게 동작하도록 작성하세요.
     *
     * 예상 출력:
     *   [익명 클래스 Runnable] 안녕하세요!
     *   [람다 Runnable] 안녕하세요!
     *   익명 클래스 정렬 결과: [apple, banana, cherry, date]
     *   람다 정렬 결과: [apple, banana, cherry, date]
     *
     * 힌트:
     *   - Runnable의 추상 메소드: run()
     *   - Comparator<String>의 추상 메소드: compare(String o1, String o2)
     *   - 람다: () -> { ... } 또는 () -> 단일표현식
     */
    static void problem1_AnonymousToLambda() {
        System.out.println("--- 문제 1: 익명 클래스 → 람다 변환 ---");

        // 익명 클래스 방식 (변경하지 마세요)
        Runnable anonymousRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("[익명 클래스 Runnable] 안녕하세요!");
            }
        };
        anonymousRunnable.run();

        // TODO: 위 익명 클래스 Runnable을 람다 표현식으로 변환하세요
        Runnable lambdaRunnable = null; // TODO: 람다로 구현

        // TODO: lambdaRunnable.run() 호출
        // lambdaRunnable.run();

        // 익명 클래스 방식 Comparator (변경하지 마세요)
        List<String> words1 = Arrays.asList("banana", "apple", "date", "cherry");
        words1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("익명 클래스 정렬 결과: " + words1);

        // TODO: 위 익명 클래스 Comparator를 람다 표현식으로 변환하세요
        List<String> words2 = Arrays.asList("banana", "apple", "date", "cherry");
        // TODO: words2.sort(람다로 구현)

        System.out.println("람다 정렬 결과: " + words2);
        System.out.println();
    }

    // =====================================================
    // 문제 2: 람다 문법 3가지 형태
    // =====================================================
    /**
     * [문제 2] 람다 문법 3가지 형태 실습
     *
     * 설명:
     *   함수형 인터페이스 MathOperation을 이용하여
     *   람다의 세 가지 문법 형태를 모두 사용해보세요.
     *   1) 블록 형태: { return ...; }
     *   2) 단일 표현식 형태: -> 결과값
     *   3) 매개변수 없는 형태 (Runnable 등 사용)
     *
     * 예상 출력:
     *   블록 형태 - 덧셈: 15
     *   단일 표현식 - 곱셈: 50
     *   매개변수 없는 람다 실행: 현재 시각 출력됨
     *
     * 힌트:
     *   - 블록:   (a, b) -> { int result = a + b; return result; }
     *   - 단일:   (a, b) -> a * b
     *   - 매개변수 없음: () -> System.out.println(...)
     */
    static void problem2_LambdaSyntaxForms() {
        System.out.println("--- 문제 2: 람다 문법 3가지 형태 ---");

        // TODO: 블록 형태 람다로 MathOperation 구현 (두 수의 합 반환)
        MathOperation blockForm = null; // TODO: 블록 형태 람다

        // TODO: 단일 표현식 형태 람다로 MathOperation 구현 (두 수의 곱 반환)
        MathOperation singleForm = null; // TODO: 단일 표현식 람다

        // TODO: 결과 출력
        // System.out.println("블록 형태 - 덧셈: " + blockForm.operate(10, 5));
        // System.out.println("단일 표현식 - 곱셈: " + singleForm.operate(10, 5));

        // TODO: 매개변수 없는 람다 (Runnable 사용) - 현재 시각 출력
        Runnable noParam = null; // TODO: 매개변수 없는 람다로 현재 시각 출력
        // noParam.run();

        System.out.println();
    }

    // =====================================================
    // 문제 3: 변수 캡처 (effectively final)
    // =====================================================
    /**
     * [문제 3] 람다에서의 변수 캡처 (effectively final)
     *
     * 설명:
     *   람다 표현식은 외부 지역 변수를 캡처할 수 있지만,
     *   해당 변수는 'effectively final'이어야 합니다.
     *   아래 각 케이스를 완성하고, 컴파일 에러가 발생하는 케이스를 주석으로 설명하세요.
     *
     *   케이스 1: final 변수 캡처 (정상)
     *   케이스 2: effectively final 변수 캡처 (정상 - 변경 없음)
     *   케이스 3: 변경된 변수 캡처 시도 (컴파일 에러 발생 - 주석 처리)
     *   케이스 4: 인스턴스 변수/정적 변수는 캡처 제한 없음
     *
     * 예상 출력:
     *   케이스 1 - final 변수 캡처: Hello, Java!
     *   케이스 2 - effectively final 캡처: 외부값 = 100
     *   케이스 4 - 인스턴스 변수 사용: counter = 42
     *
     * 힌트:
     *   - final int x = 10; -> 람다 내부에서 x 사용 가능
     *   - int y = 20; (이후 변경 없음) -> effectively final, 사용 가능
     *   - int z = 30; z = 40; -> 람다 내부에서 z 사용 불가 (컴파일 에러)
     */
    static int counter = 42; // 정적 변수 (캡처 제한 없음)

    static void problem3_VariableCapture() {
        System.out.println("--- 문제 3: 변수 캡처 (effectively final) ---");

        // 케이스 1: final 변수
        final String greeting = "Hello, Java!";
        // TODO: Runnable 람다를 만들어 greeting을 출력하세요
        Runnable case1 = null; // TODO
        // case1.run();

        // 케이스 2: effectively final (선언 후 값 변경 없음)
        int externalValue = 100;
        // TODO: Runnable 람다를 만들어 externalValue를 출력하세요
        Runnable case2 = null; // TODO
        // case2.run();

        // 케이스 3: 컴파일 에러 케이스 (주석 처리된 상태로 유지)
        // TODO: 아래 코드가 왜 컴파일 에러인지 주석으로 설명하세요
        /*
        int changeableValue = 30;
        changeableValue = 40; // 이 라인이 있으면 아래 람다에서 사용 불가
        Runnable case3 = () -> System.out.println(changeableValue); // 컴파일 에러!
        // 이유: TODO - 여기에 설명 작성
        */

        // 케이스 4: 정적 변수는 제한 없음
        // TODO: Runnable 람다를 만들어 정적 변수 counter를 출력하세요
        Runnable case4 = null; // TODO
        // case4.run();

        System.out.println();
    }

    // =====================================================
    // 헬퍼: 함수형 인터페이스 정의
    // =====================================================

    /**
     * 두 정수를 받아 정수를 반환하는 함수형 인터페이스
     */
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}
