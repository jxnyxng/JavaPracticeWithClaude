/*
 * =====================================================
 * 파일명: P04_FunctionalInterface.java
 * 주제: 함수형 인터페이스 (Functional Interface, Java 8+)
 * =====================================================
 *
 * 【학습목표】
 * 1. @FunctionalInterface 어노테이션으로 커스텀 함수형 인터페이스를 만드는 방법을 익힌다.
 * 2. 함수형 인터페이스를 람다 표현식(Lambda Expression)으로 구현하는 방법을 익힌다.
 * 3. java.util.function 패키지의 주요 함수형 인터페이스를 이해하고 활용한다.
 *
 * 【핵심개념】
 * - 함수형 인터페이스(Functional Interface):
 *   → 추상 메소드가 정확히 하나만 있는 인터페이스
 *   → @FunctionalInterface 어노테이션으로 명시 (선택 사항이지만 권장)
 *   → 람다 표현식이나 메소드 참조로 인스턴스 생성 가능
 *
 * - 람다 표현식(Lambda Expression):
 *   → 익명 함수를 간결하게 표현하는 방법
 *   → 문법: (매개변수) -> { 실행문 }  또는  (매개변수) -> 반환식
 *   → 예: Calculator add = (a, b) -> a + b;
 *
 * - java.util.function 주요 인터페이스:
 *   → Function<T, R>     : T를 받아 R을 반환  → R apply(T t)
 *   → Predicate<T>       : T를 받아 boolean 반환 → boolean test(T t)
 *   → Consumer<T>        : T를 받아 소비(반환 없음) → void accept(T t)
 *   → Supplier<T>        : 인자 없이 T를 공급 → T get()
 *   → BiFunction<T,U,R>  : T, U를 받아 R을 반환 → R apply(T t, U u)
 * =====================================================
 */

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;

public class P04_FunctionalInterface {

    // ================================================================
    // 【문제 1】 @FunctionalInterface로 커스텀 함수형 인터페이스 만들기
    // ================================================================
    /*
     * 문제 제목: 커스텀 함수형 인터페이스 설계
     *
     * 상세 설명:
     *   1) Transformer<T> 함수형 인터페이스를 선언하세요.
     *      - @FunctionalInterface 어노테이션 적용
     *      - 추상 메소드: T transform(T input)
     *      - 디폴트 메소드: andThen(Transformer<T> after) → 두 변환을 체이닝
     *        (after.transform(this.transform(input)) 을 수행하는 Transformer 반환)
     *   2) Converter 함수형 인터페이스를 선언하세요.
     *      - @FunctionalInterface 어노테이션 적용
     *      - 추상 메소드: double convert(double value)
     *   3) Validator<T> 함수형 인터페이스를 선언하세요.
     *      - @FunctionalInterface 어노테이션 적용
     *      - 추상 메소드: boolean validate(T value)
     *      - 추상 메소드가 2개면 @FunctionalInterface 컴파일 오류가 나는지 주석으로 설명
     *   4) main 에서 람다로 각 인터페이스를 구현하여 사용하세요:
     *      - Transformer<String>: 문자열을 대문자로 변환
     *      - Converter: 섭씨를 화씨로 변환 (공식: F = C * 9/5 + 32)
     *      - Validator<Integer>: 양수 여부 검사
     *
     * 예상 출력:
     *   변환 결과: HELLO WORLD
     *   섭씨 100도 → 화씨 212.0도
     *   42는 양수입니까? true
     *   -5는 양수입니까? false
     *
     * 힌트:
     *   - @FunctionalInterface
     *     interface Transformer<T> { T transform(T input); ... }
     *   - Transformer<String> toUpper = input -> input.toUpperCase();
     *   - Converter celsiusToFahrenheit = c -> c * 9.0 / 5 + 32;
     */

    // TODO: Transformer<T> 함수형 인터페이스를 선언하세요.
    // (@FunctionalInterface, transform() 추상 메소드, andThen() 디폴트 메소드 포함)


    // TODO: Converter 함수형 인터페이스를 선언하세요.
    // (@FunctionalInterface, convert() 추상 메소드 포함)


    // TODO: Validator<T> 함수형 인터페이스를 선언하세요.
    // (@FunctionalInterface, validate() 추상 메소드 포함)
    // TODO: 추상 메소드가 2개일 때 컴파일 오류가 나는 이유를 주석으로 설명하세요.


    // ================================================================
    // 【문제 2】 Calculator 인터페이스를 람다로 구현
    // ================================================================
    /*
     * 문제 제목: Calculator 함수형 인터페이스와 다양한 람다 구현
     *
     * 상세 설명:
     *   1) Calculator 함수형 인터페이스를 선언하세요.
     *      - @FunctionalInterface 어노테이션 적용
     *      - 추상 메소드: int calculate(int a, int b)
     *   2) operate(int a, int b, Calculator calc) 헬퍼 메소드를 작성하세요.
     *      - calc.calculate(a, b) 를 호출하여 결과 반환
     *   3) main 에서 다음 연산을 람다로 구현하세요:
     *      - add:      덧셈 (a + b)
     *      - subtract: 뺄셈 (a - b)
     *      - multiply: 곱셈 (a * b)
     *      - divide:   나눗셈 (a / b, b == 0이면 0 반환)
     *      - modulo:   나머지 (a % b)
     *   4) operate() 메소드에 각 Calculator 람다를 전달하여 결과 출력
     *
     * 예상 출력:
     *   10 + 3 = 13
     *   10 - 3 = 7
     *   10 * 3 = 30
     *   10 / 3 = 3
     *   10 % 3 = 1
     *
     * 힌트:
     *   - Calculator add = (a, b) -> a + b;
     *   - System.out.println(a + " + " + b + " = " + operate(a, b, add));
     *   - 나눗셈 람다: (a, b) -> b == 0 ? 0 : a / b
     */

    // TODO: Calculator 함수형 인터페이스를 선언하세요.
    // (@FunctionalInterface, calculate(int a, int b) 포함)


    // TODO: operate(int a, int b, Calculator calc) 헬퍼 메소드를 작성하세요.
    static int operate(int a, int b, /* TODO: Calculator 타입 매개변수 */ Object calc) {
        // TODO: calc.calculate(a, b) 호출 후 반환
        return 0;
    }


    // ================================================================
    // 【문제 3】 java.util.function 패키지 소개 및 활용
    // ================================================================
    /*
     * 문제 제목: 표준 함수형 인터페이스 (Function, Predicate, Consumer, Supplier)
     *
     * 상세 설명:
     *   java.util.function 패키지의 주요 함수형 인터페이스를 활용합니다.
     *
     *   1) Function<String, Integer> 사용:
     *      - 문자열의 길이를 반환하는 Function 람다 작성
     *      - "Hello" → 5
     *
     *   2) Predicate<String> 사용:
     *      - 문자열이 5글자 이상인지 검사하는 Predicate 람다 작성
     *      - "Hi" → false,  "Hello" → true
     *      - negate() 메소드로 조건을 반전시켜 사용하세요.
     *
     *   3) Consumer<String> 사용:
     *      - 문자열을 받아 "[출력] " 접두사를 붙여 출력하는 Consumer 람다 작성
     *      - 문자열 리스트를 만들고 forEach 에서 Consumer 사용
     *
     *   4) Supplier<String> 사용:
     *      - 랜덤한 인사말을 반환하는 Supplier 람다 작성
     *      - 인사말 목록: {"안녕하세요", "반갑습니다", "좋은 하루 되세요"}
     *      - Math.random()으로 하나를 선택하여 반환
     *
     *   5) Function.andThen() 체이닝:
     *      - 문자열 → 길이(Integer) 변환 후 → 길이 * 2 계산하는 체인 구성
     *      - "Hello" → 5 → 10
     *
     * 예상 출력:
     *   "Hello"의 길이: 5
     *   "Hi"는 5글자 이상? false
     *   "Hello"는 5글자 이상? true
     *   "Hi"는 5글자 미만? true     ← negate() 사용
     *   [출력] Java
     *   [출력] Python
     *   [출력] JavaScript
     *   오늘의 인사말: 안녕하세요  (또는 랜덤)
     *   "Hello" 길이의 2배: 10
     *
     * 힌트:
     *   - Function<String, Integer> strLen = s -> s.length();
     *   - Predicate<String> isLong = s -> s.length() >= 5;
     *   - isLong.negate() 로 반전
     *   - Consumer<String> printer = s -> System.out.println("[출력] " + s);
     *   - list.forEach(printer);
     *   - Function<String, Integer> chain = strLen.andThen(len -> len * 2);
     */

    // TODO: processWithFunction(Function<String, Integer> func, String input) 헬퍼 메소드를 작성하세요.
    static void processWithFunction(Function<String, Integer> func, String input) {
        // TODO: func.apply(input) 결과를 출력
    }

    // TODO: filterWithPredicate(Predicate<String> pred, String input) 헬퍼 메소드를 작성하세요.
    static void filterWithPredicate(Predicate<String> pred, String input) {
        // TODO: pred.test(input) 결과를 출력
    }

    // TODO: supplyGreeting(Supplier<String> supplier) 헬퍼 메소드를 작성하세요.
    static void supplyGreeting(Supplier<String> supplier) {
        // TODO: supplier.get() 결과를 출력
    }


    public static void main(String[] args) {

        System.out.println("=== 문제 1: 커스텀 함수형 인터페이스 ===");
        // TODO: Transformer<String> 람다로 문자열 대문자 변환


        // TODO: Converter 람다로 섭씨 → 화씨 변환


        // TODO: Validator<Integer> 람다로 양수 여부 검사


        System.out.println("\n=== 문제 2: Calculator 람다 구현 ===");
        // TODO: add, subtract, multiply, divide, modulo 람다 선언
        // TODO: operate() 메소드에 전달하여 결과 출력


        System.out.println("\n=== 문제 3: java.util.function 패키지 활용 ===");

        System.out.println("-- Function<String, Integer> --");
        // TODO: 문자열 길이를 반환하는 Function 람다 작성 및 사용


        System.out.println("-- Predicate<String> --");
        // TODO: 5글자 이상 여부를 검사하는 Predicate 람다 작성 및 사용
        // TODO: negate()를 사용하여 반전된 조건 출력


        System.out.println("-- Consumer<String> --");
        // TODO: [출력] 접두사 붙여 출력하는 Consumer 람다 작성
        // TODO: List.of("Java", "Python", "JavaScript")에 forEach 적용


        System.out.println("-- Supplier<String> --");
        // TODO: 랜덤 인사말을 반환하는 Supplier 람다 작성 및 사용


        System.out.println("-- Function.andThen() 체이닝 --");
        // TODO: 문자열 → 길이 → 길이 * 2 체인 구성 및 사용

    }
}
