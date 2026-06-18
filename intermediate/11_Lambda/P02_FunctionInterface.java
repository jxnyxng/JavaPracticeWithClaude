/**
 * 파일명: P02_FunctionInterface.java
 * 주제: Function 인터페이스 (java.util.function.Function)
 *
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. Function<T,R> 인터페이스의 apply 메소드를 람다로 구현할 수 있다.
 * 2. andThen과 compose를 사용해 함수를 합성(조합)할 수 있다.
 * 3. UnaryOperator<T>와 BinaryOperator<T>의 특성과 사용법을 이해한다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [Function<T, R>]
 * - T 타입 입력을 받아 R 타입 결과를 반환하는 함수형 인터페이스
 * - 핵심 메소드: R apply(T t)
 * - 예시: Function<String, Integer> = 문자열 -> 정수 변환
 *
 * [함수 합성]
 * - andThen(after): f.andThen(g) → g(f(x))  (f 먼저, 그 다음 g)
 * - compose(before): f.compose(g) → f(g(x)) (g 먼저, 그 다음 f)
 *
 * [UnaryOperator<T>]
 * - Function<T, T>의 특수형 - 입력과 출력 타입이 동일
 * - 예시: UnaryOperator<String> = 문자열 -> 문자열
 *
 * [BinaryOperator<T>]
 * - BiFunction<T, T, T>의 특수형 - 두 입력과 출력 타입이 모두 동일
 * - 예시: BinaryOperator<Integer> = (정수, 정수) -> 정수
 */

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class P02_FunctionInterface {

    public static void main(String[] args) {
        System.out.println("===== Function 인터페이스 =====\n");

        problem1_FunctionApply();
        problem2_FunctionComposition();
        problem3_UnaryAndBinaryOperator();
    }

    // =====================================================
    // 문제 1: Function<T,R> apply 메소드
    // =====================================================
    /**
     * [문제 1] Function<T,R>의 apply 메소드 활용
     *
     * 설명:
     *   다음 Function 객체들을 람다로 구현하세요.
     *   1) 문자열을 받아 그 길이(정수)를 반환하는 Function
     *   2) 정수를 받아 제곱값을 반환하는 Function
     *   3) 문자열을 받아 대문자로 변환하는 Function
     *   4) 각 Function을 apply()로 호출하여 결과를 출력하세요.
     *
     * 예상 출력:
     *   문자열 길이: 5
     *   정수 제곱: 49
     *   대문자 변환: HELLO
     *
     * 힌트:
     *   - Function<String, Integer> strLength = s -> s.length();
     *   - apply() 메소드로 함수 실행
     */
    static void problem1_FunctionApply() {
        System.out.println("--- 문제 1: Function apply ---");

        // TODO: 문자열 -> 길이(Integer) 반환하는 Function 구현
        Function<String, Integer> strLength = null; // TODO

        // TODO: Integer -> 제곱값(Integer) 반환하는 Function 구현
        Function<Integer, Integer> square = null; // TODO

        // TODO: 문자열 -> 대문자 문자열 반환하는 Function 구현
        Function<String, String> toUpper = null; // TODO

        // TODO: 각 Function을 apply()로 호출하여 결과 출력
        // System.out.println("문자열 길이: " + strLength.apply("Hello"));
        // System.out.println("정수 제곱: " + square.apply(7));
        // System.out.println("대문자 변환: " + toUpper.apply("hello"));

        System.out.println();
    }

    // =====================================================
    // 문제 2: andThen, compose로 함수 합성
    // =====================================================
    /**
     * [문제 2] andThen과 compose를 이용한 함수 합성
     *
     * 설명:
     *   두 가지 Function을 준비하세요.
     *     - doubleIt: 정수를 받아 2배로 만드는 Function<Integer, Integer>
     *     - addTen:   정수를 받아 10을 더하는 Function<Integer, Integer>
     *
     *   그 후 아래 합성을 구현하고 결과를 출력하세요.
     *     1) andThen 사용: doubleIt.andThen(addTen) → 5 입력 시 결과는?
     *     2) compose  사용: doubleIt.compose(addTen) → 5 입력 시 결과는?
     *     3) 세 함수 연속 합성: 문자열 길이 → 제곱 → 문자열 변환
     *
     * 예상 출력:
     *   andThen (먼저 *2, 그 다음 +10): 20
     *   compose (먼저 +10, 그 다음 *2): 30
     *   세 함수 합성 결과: "25" (문자열 "Hello"의 길이5, 제곱25, 문자열"25")
     *
     * 힌트:
     *   - f.andThen(g).apply(x) == g(f(x))
     *   - f.compose(g).apply(x) == f(g(x))
     *   - Function.andThen()은 Function 반환 → 계속 체이닝 가능
     */
    static void problem2_FunctionComposition() {
        System.out.println("--- 문제 2: 함수 합성 (andThen, compose) ---");

        // TODO: 정수를 2배로 만드는 Function 구현
        Function<Integer, Integer> doubleIt = null; // TODO

        // TODO: 정수에 10을 더하는 Function 구현
        Function<Integer, Integer> addTen = null; // TODO

        // TODO: andThen으로 합성 (doubleIt 먼저, addTen 나중)
        // Function<Integer, Integer> doubleThenAdd = ...
        // System.out.println("andThen (먼저 *2, 그 다음 +10): " + doubleThenAdd.apply(5));

        // TODO: compose로 합성 (addTen 먼저, doubleIt 나중)
        // Function<Integer, Integer> addThenDouble = ...
        // System.out.println("compose (먼저 +10, 그 다음 *2): " + addThenDouble.apply(5));

        // TODO: 세 함수 연속 합성
        // 1단계: 문자열 -> 길이(Integer)
        Function<String, Integer> strToLength = null; // TODO
        // 2단계: Integer -> 제곱(Integer)
        Function<Integer, Integer> squareFn = null; // TODO
        // 3단계: Integer -> 문자열
        Function<Integer, String> intToStr = null; // TODO

        // TODO: 세 함수를 andThen으로 합성하여 "Hello" 입력 결과 출력
        // System.out.println("세 함수 합성 결과: " + composed.apply("Hello"));

        System.out.println();
    }

    // =====================================================
    // 문제 3: UnaryOperator<T>, BinaryOperator<T>
    // =====================================================
    /**
     * [문제 3] UnaryOperator와 BinaryOperator 활용
     *
     * 설명:
     *   UnaryOperator와 BinaryOperator는 Function의 특수화된 형태입니다.
     *   아래 항목을 구현하세요.
     *
     *   UnaryOperator 구현:
     *     1) 문자열 앞뒤 공백 제거 (trim)
     *     2) 정수를 절댓값으로 변환
     *
     *   BinaryOperator 구현:
     *     3) 두 문자열 중 더 긴 것 반환
     *     4) 두 정수의 최댓값 반환
     *
     *   추가 과제:
     *     5) UnaryOperator.identity() 메소드가 무엇인지 출력으로 확인
     *
     * 예상 출력:
     *   공백 제거: "Hello World"
     *   절댓값: 42
     *   더 긴 문자열: "banana"
     *   최댓값: 99
     *   identity 결과: "원본 그대로"
     *
     * 힌트:
     *   - UnaryOperator<T> extends Function<T,T>
     *   - BinaryOperator<T> extends BiFunction<T,T,T>
     *   - Math.abs() 활용 가능
     *   - UnaryOperator.identity() 는 입력을 그대로 반환
     */
    static void problem3_UnaryAndBinaryOperator() {
        System.out.println("--- 문제 3: UnaryOperator & BinaryOperator ---");

        // TODO: 문자열 앞뒤 공백을 제거하는 UnaryOperator<String> 구현
        UnaryOperator<String> trimOp = null; // TODO

        // TODO: 정수를 절댓값으로 변환하는 UnaryOperator<Integer> 구현
        UnaryOperator<Integer> absOp = null; // TODO

        // TODO: 두 문자열 중 더 긴 것을 반환하는 BinaryOperator<String> 구현
        BinaryOperator<String> longerStr = null; // TODO

        // TODO: 두 정수 중 최댓값을 반환하는 BinaryOperator<Integer> 구현
        BinaryOperator<Integer> maxOp = null; // TODO

        // TODO: 각 결과 출력
        // System.out.println("공백 제거: " + trimOp.apply("  Hello World  "));
        // System.out.println("절댓값: " + absOp.apply(-42));
        // System.out.println("더 긴 문자열: " + longerStr.apply("apple", "banana"));
        // System.out.println("최댓값: " + maxOp.apply(99, 55));

        // TODO: UnaryOperator.identity() 사용 예시 구현 및 출력
        UnaryOperator<String> identityOp = null; // TODO: UnaryOperator.identity() 사용
        // System.out.println("identity 결과: " + identityOp.apply("원본 그대로"));

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 시그니처 (내용 직접 구현)
    // =====================================================

    /**
     * 주어진 Function을 두 번 합성하여 반환 (f(f(x)))
     * @param f 합성할 Function
     * @return f를 두 번 적용하는 새로운 Function
     */
    static <T> Function<T, T> applyTwice(Function<T, T> f) {
        // TODO: f.andThen(f) 또는 f.compose(f) 활용
        return null;
    }

    /**
     * Function 리스트를 순서대로 합성하여 하나의 Function으로 반환
     * @param functions 합성할 Function 목록
     * @return 모든 함수가 합성된 단일 Function
     */
    static Function<Integer, Integer> composeAll(java.util.List<Function<Integer, Integer>> functions) {
        // TODO: 반복문과 andThen을 사용하여 모든 함수 합성
        return null;
    }
}
