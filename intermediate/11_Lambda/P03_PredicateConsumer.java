/**
 * 파일명: P03_PredicateConsumer.java
 * 주제: Predicate와 Consumer 인터페이스
 *
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. Predicate<T>를 사용해 조건 검사 로직을 람다로 표현할 수 있다.
 * 2. and, or, negate로 Predicate를 논리적으로 조합할 수 있다.
 * 3. Consumer<T>를 사용해 데이터를 소비(출력/저장 등)하는 람다를 작성할 수 있다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [Predicate<T>]
 * - T 타입 입력을 받아 boolean을 반환하는 함수형 인터페이스
 * - 핵심 메소드: boolean test(T t)
 * - 조합 메소드:
 *     and(other)    → this && other  (두 조건 모두 참)
 *     or(other)     → this || other  (둘 중 하나 참)
 *     negate()      → !this          (조건 반전)
 *     not(pred)     → 정적 메소드, Predicate.not(pred) (자바11+)
 *
 * [Consumer<T>]
 * - T 타입 입력을 받아 아무것도 반환하지 않는(void) 함수형 인터페이스
 * - 핵심 메소드: void accept(T t)
 * - 조합 메소드:
 *     andThen(after) → this 실행 후 after 실행 (순서대로 소비)
 *
 * [BiPredicate<T, U> / BiConsumer<T, U>]
 * - 두 개의 인수를 받는 Predicate/Consumer의 확장
 * - BiPredicate: boolean test(T t, U u)
 * - BiConsumer:  void accept(T t, U u)
 */

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P03_PredicateConsumer {

    public static void main(String[] args) {
        System.out.println("===== Predicate와 Consumer =====\n");

        problem1_PredicateTest();
        problem2_ConsumerAccept();
        problem3_BiPredicateBiConsumer();
    }

    // =====================================================
    // 문제 1: Predicate<T> test, and, or, negate
    // =====================================================
    /**
     * [문제 1] Predicate<T> 기본 및 조합 사용
     *
     * 설명:
     *   다음 Predicate들을 람다로 구현하고 조합하세요.
     *
     *   기본 Predicate:
     *     1) isEven:      정수가 짝수인지 검사
     *     2) isPositive:  정수가 양수(0 초과)인지 검사
     *     3) isLongStr:   문자열 길이가 5 초과인지 검사
     *
     *   조합:
     *     4) isEvenAndPositive: 짝수이면서 양수
     *     5) isEvenOrNegative:  짝수이거나 음수
     *     6) isOdd:             isEven을 negate()로 변환
     *
     *   목록 필터링:
     *     7) numbers 리스트에서 isEvenAndPositive를 만족하는 숫자 출력
     *
     * 예상 출력:
     *   4는 짝수? true
     *   -3은 양수? false
     *   "Java"는 긴 문자열? false
     *   짝수 AND 양수 (6): true
     *   짝수 OR 음수 (-3): true
     *   홀수 negate (7): true
     *   짝수이고 양수인 수: [2, 4, 6, 8, 10]
     *
     * 힌트:
     *   - Predicate<Integer> isEven = n -> n % 2 == 0;
     *   - 조합: isEven.and(isPositive)
     *   - Stream 없이 반복문으로 필터링해도 됨
     */
    static void problem1_PredicateTest() {
        System.out.println("--- 문제 1: Predicate test & 조합 ---");

        // TODO: 짝수 검사 Predicate 구현
        Predicate<Integer> isEven = null; // TODO

        // TODO: 양수 검사 Predicate 구현 (0 초과)
        Predicate<Integer> isPositive = null; // TODO

        // TODO: 문자열 길이 5 초과 검사 Predicate 구현
        Predicate<String> isLongStr = null; // TODO

        // TODO: 기본 test() 결과 출력
        // System.out.println("4는 짝수? " + isEven.test(4));
        // System.out.println("-3은 양수? " + isPositive.test(-3));
        // System.out.println("\"Java\"는 긴 문자열? " + isLongStr.test("Java"));

        // TODO: and() 조합: 짝수이면서 양수
        Predicate<Integer> isEvenAndPositive = null; // TODO: isEven.and(...)

        // TODO: or() 조합: 짝수이거나 음수 (음수 = isPositive.negate())
        Predicate<Integer> isEvenOrNegative = null; // TODO: isEven.or(...)

        // TODO: negate() 사용: isEven의 반전 (홀수)
        Predicate<Integer> isOdd = null; // TODO: isEven.negate()

        // TODO: 조합 결과 출력
        // System.out.println("짝수 AND 양수 (6): " + isEvenAndPositive.test(6));
        // System.out.println("짝수 OR 음수 (-3): " + isEvenOrNegative.test(-3));
        // System.out.println("홀수 negate (7): " + isOdd.test(7));

        // TODO: 목록에서 isEvenAndPositive를 만족하는 수만 출력
        List<Integer> numbers = Arrays.asList(-4, -2, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.print("짝수이고 양수인 수: [");
        // TODO: 반복문으로 isEvenAndPositive.test() 를 통과한 수만 출력
        System.out.println("]");

        System.out.println();
    }

    // =====================================================
    // 문제 2: Consumer<T> accept, andThen
    // =====================================================
    /**
     * [문제 2] Consumer<T> 기본 및 andThen 조합
     *
     * 설명:
     *   다음 Consumer들을 람다로 구현하세요.
     *
     *   기본 Consumer:
     *     1) printConsumer:    문자열을 "[출력] " 접두사와 함께 출력
     *     2) upperConsumer:    문자열을 대문자로 변환 후 출력
     *     3) lengthConsumer:   문자열의 길이를 "길이: N" 형식으로 출력
     *
     *   조합:
     *     4) printAndLength:   printConsumer.andThen(lengthConsumer)
     *     5) allConsumer:      세 Consumer를 모두 andThen으로 연결
     *
     *   목록 적용:
     *     6) words 리스트의 각 단어에 allConsumer를 적용
     *
     * 예상 출력:
     *   [출력] Hello
     *   대문자: HELLO
     *   길이: 5
     *   --- andThen 조합 ---
     *   [출력] Java
     *   길이: 4
     *   --- 목록 적용 ---
     *   [출력] apple / 대문자: APPLE / 길이: 5
     *   [출력] banana / 대문자: BANANA / 길이: 6
     *
     * 힌트:
     *   - Consumer<String> printConsumer = s -> System.out.println("[출력] " + s);
     *   - consumer1.andThen(consumer2) 는 consumer1 실행 후 consumer2 실행
     *   - Consumer는 반환값이 없음 (void)
     */
    static void problem2_ConsumerAccept() {
        System.out.println("--- 문제 2: Consumer accept & andThen ---");

        // TODO: "[출력] " 접두사를 붙여 출력하는 Consumer 구현
        Consumer<String> printConsumer = null; // TODO

        // TODO: 대문자로 변환 후 "대문자: " 접두사와 출력하는 Consumer 구현
        Consumer<String> upperConsumer = null; // TODO

        // TODO: 문자열 길이를 "길이: N" 형식으로 출력하는 Consumer 구현
        Consumer<String> lengthConsumer = null; // TODO

        // TODO: 기본 accept() 호출 결과 출력
        // printConsumer.accept("Hello");
        // upperConsumer.accept("Hello");
        // lengthConsumer.accept("Hello");

        System.out.println("--- andThen 조합 ---");
        // TODO: printConsumer와 lengthConsumer를 andThen으로 조합
        Consumer<String> printAndLength = null; // TODO
        // printAndLength.accept("Java");

        System.out.println("--- 목록 적용 ---");
        // TODO: 세 Consumer 모두 andThen으로 연결
        Consumer<String> allConsumer = null; // TODO

        List<String> words = Arrays.asList("apple", "banana", "cherry");
        // TODO: words 각 원소에 allConsumer 적용 (반복문 사용)

        System.out.println();
    }

    // =====================================================
    // 문제 3: BiPredicate, BiConsumer
    // =====================================================
    /**
     * [문제 3] BiPredicate<T,U>와 BiConsumer<T,U> 활용
     *
     * 설명:
     *   두 개의 인수를 받는 BiPredicate와 BiConsumer를 구현하세요.
     *
     *   BiPredicate 구현:
     *     1) startsWith:  문자열이 특정 접두사로 시작하는지 검사
     *        BiPredicate<String, String> → (문자열, 접두사) -> boolean
     *     2) isGreaterThan: 첫 번째 정수가 두 번째 정수보다 큰지 검사
     *        BiPredicate<Integer, Integer>
     *     3) and(), or(), negate() 조합 적용
     *
     *   BiConsumer 구현:
     *     4) printKeyValue:  키와 값을 "키 = 값" 형식으로 출력
     *        BiConsumer<String, Object>
     *     5) printSumResult: 두 정수의 합을 출력
     *        BiConsumer<Integer, Integer>
     *     6) andThen으로 두 BiConsumer 조합
     *
     * 예상 출력:
     *   "Java"가 "Ja"로 시작? true
     *   10 > 3? true
     *   조합 결과 ("Hello", "He"): true
     *   이름 = 홍길동
     *   두 수의 합: 15
     *
     * 힌트:
     *   - BiPredicate<String, String> startsWith = (s, prefix) -> s.startsWith(prefix);
     *   - BiConsumer<String, Object> printKV = (k, v) -> System.out.println(k + " = " + v);
     */
    static void problem3_BiPredicateBiConsumer() {
        System.out.println("--- 문제 3: BiPredicate & BiConsumer ---");

        // TODO: (문자열, 접두사) -> 시작 여부를 반환하는 BiPredicate 구현
        BiPredicate<String, String> startsWith = null; // TODO

        // TODO: (정수1, 정수2) -> 정수1 > 정수2 인지 반환하는 BiPredicate 구현
        BiPredicate<Integer, Integer> isGreaterThan = null; // TODO

        // TODO: BiPredicate test() 결과 출력
        // System.out.println("\"Java\"가 \"Ja\"로 시작? " + startsWith.test("Java", "Ja"));
        // System.out.println("10 > 3? " + isGreaterThan.test(10, 3));

        // TODO: BiPredicate 조합: startsWith AND isGreaterThan (타입이 달라 직접 조합은 불가)
        // 힌트: 각각 별개로 test() 호출 후 && 연산으로 수동 조합
        // System.out.println("조합 결과 (\"Hello\", \"He\"): " + (startsWith.test("Hello", "He") && isGreaterThan.test(5, 3)));

        // TODO: (키, 값)을 "키 = 값" 형식으로 출력하는 BiConsumer 구현
        BiConsumer<String, Object> printKeyValue = null; // TODO

        // TODO: (정수1, 정수2)의 합을 "두 수의 합: N" 형식으로 출력하는 BiConsumer 구현
        BiConsumer<Integer, Integer> printSumResult = null; // TODO

        // TODO: BiConsumer accept() 호출
        // printKeyValue.accept("이름", "홍길동");
        // printSumResult.accept(7, 8);

        // TODO: BiConsumer를 andThen으로 조합하는 예시 (String, Object 타입 맞추기)
        // BiConsumer<String, Object> combined = printKeyValue.andThen((k, v) -> ...);
        // combined.accept("점수", 100);

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 시그니처 (내용 직접 구현)
    // =====================================================

    /**
     * Predicate를 사용해 리스트를 필터링한 결과를 반환
     * @param list     필터링할 리스트
     * @param predicate 조건
     * @return 조건을 만족하는 원소만 담긴 새 리스트
     */
    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        // TODO: 반복문과 predicate.test()를 사용하여 구현
        return null;
    }

    /**
     * Consumer를 사용해 리스트의 각 원소를 처리
     * @param list     처리할 리스트
     * @param consumer 각 원소에 적용할 Consumer
     */
    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        // TODO: 반복문과 consumer.accept()를 사용하여 구현
    }
}
