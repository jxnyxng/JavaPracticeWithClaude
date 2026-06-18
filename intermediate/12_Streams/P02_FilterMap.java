/**
 * =====================================================================
 * 파일명: P02_FilterMap.java
 * 주제: filter와 map 중간 연산
 * =====================================================================
 *
 * 【학습목표】
 * 1. filter()를 사용하여 조건에 맞는 원소만 선택하는 중간 연산을 적용할 수 있다.
 * 2. map()을 사용하여 각 원소를 다른 형태로 변환하는 중간 연산을 적용할 수 있다.
 * 3. filter()와 map()을 조합하여 파이프라인을 구성할 수 있다.
 *
 * 【핵심개념】
 * - filter(Predicate<T>): 조건식(boolean 반환)을 인자로 받아,
 *   조건이 true인 원소만 통과시키는 중간 연산.
 *   예) .filter(n -> n % 2 == 0)  → 짝수만 통과
 *
 * - map(Function<T, R>): 각 원소를 변환 함수에 적용하여 새 원소를 만드는 중간 연산.
 *   원소의 타입이 바뀔 수 있다.
 *   예) .map(String::toUpperCase)  → 모두 대문자로 변환
 *       .map(n -> n * n)           → 제곱으로 변환
 *
 * - 파이프라인(Pipeline): 스트림 생성 → 중간 연산 연결 → 최종 연산 순서로 구성.
 *   중간 연산은 지연(lazy) 실행되므로 최종 연산 호출 전까지 실제 처리가 일어나지 않는다.
 * =====================================================================
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P02_FilterMap {

    // ----------------------------------------------------------------
    // 문제 1: filter로 조건에 맞는 원소 선택
    // ----------------------------------------------------------------
    /**
     * 【문제 1】 filter() 기본 사용
     *
     * 설명:
     *   정수 리스트 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]에서
     *   (1) 5보다 큰 수만 선택하여 출력하시오.
     *   (2) 홀수만 선택하여 출력하시오.
     *   각각 collect(Collectors.toList())로 리스트로 수집한 뒤 출력한다.
     *
     * 예상 출력:
     *   5보다 큰 수: [6, 7, 8, 9, 10]
     *   홀수 목록: [1, 3, 5, 7, 9]
     *
     * 힌트:
     *   .filter(n -> n > 5)
     *   .filter(n -> n % 2 != 0)
     *   .collect(Collectors.toList())
     */
    static void problem1() {
        System.out.println("=== 문제 1: filter() 기본 사용 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // TODO: 5보다 큰 수만 선택하여 리스트로 수집 후 출력 (형식: "5보다 큰 수: [...]")

        // TODO: 홀수만 선택하여 리스트로 수집 후 출력 (형식: "홀수 목록: [...]")

    }

    // ----------------------------------------------------------------
    // 문제 2: map으로 원소 변환
    // ----------------------------------------------------------------
    /**
     * 【문제 2】 map() 기본 사용
     *
     * 설명:
     *   문자열 리스트 ["hello", "world", "java", "stream"]에서
     *   (1) 모든 문자열을 대문자로 변환하여 출력하시오.
     *   (2) 모든 문자열의 길이(length)를 정수 리스트로 변환하여 출력하시오.
     *   각각 collect(Collectors.toList())로 수집한 뒤 출력한다.
     *
     * 예상 출력:
     *   대문자 변환: [HELLO, WORLD, JAVA, STREAM]
     *   문자열 길이: [5, 5, 4, 6]
     *
     * 힌트:
     *   .map(String::toUpperCase)
     *   .map(String::length)
     *   .collect(Collectors.toList())
     */
    static void problem2() {
        System.out.println("=== 문제 2: map() 기본 사용 ===");
        List<String> words = Arrays.asList("hello", "world", "java", "stream");

        // TODO: 대문자로 변환한 리스트 생성 후 출력 (형식: "대문자 변환: [...]")

        // TODO: 각 문자열 길이를 담은 정수 리스트 생성 후 출력 (형식: "문자열 길이: [...]")

    }

    // ----------------------------------------------------------------
    // 문제 3: filter + map 조합 (짝수만 선택해서 제곱)
    // ----------------------------------------------------------------
    /**
     * 【문제 3】 filter + map 파이프라인 조합
     *
     * 설명:
     *   정수 리스트 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]에서
     *   (1) 짝수만 선택(filter)한 뒤, 각 값을 제곱(map)하여 출력하시오.
     *   (2) 문자열 리스트 ["Apple", "Banana", "Apricot", "Cherry", "Avocado"]에서
     *       "A"로 시작하는 문자열만 선택(filter)한 뒤,
     *       소문자로 변환(map)하여 출력하시오.
     *   각각 collect(Collectors.toList())로 수집한 뒤 출력한다.
     *
     * 예상 출력:
     *   짝수의 제곱: [4, 16, 36, 64, 100]
     *   A로 시작하는 소문자: [apple, apricot, avocado]
     *
     * 힌트:
     *   .filter(n -> n % 2 == 0).map(n -> n * n)
     *   .filter(s -> s.startsWith("A")).map(String::toLowerCase)
     */
    static void problem3() {
        System.out.println("=== 문제 3: filter + map 조합 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> fruits = Arrays.asList("Apple", "Banana", "Apricot", "Cherry", "Avocado");

        // TODO: 짝수만 선택 후 제곱하여 리스트로 수집 후 출력 (형식: "짝수의 제곱: [...]")

        // TODO: "A"로 시작하는 문자열만 선택 후 소문자로 변환하여 출력
        //       (형식: "A로 시작하는 소문자: [...]")

    }

    // ----------------------------------------------------------------
    // 헬퍼 메소드
    // ----------------------------------------------------------------
    /** 조건에 맞는 정수만 반환 */
    static List<Integer> filterNumbers(List<Integer> list, java.util.function.Predicate<Integer> condition) { return null; }

    /** 문자열 리스트를 변환 함수에 따라 변환 후 반환 */
    static List<String> mapStrings(List<String> list, java.util.function.Function<String, String> mapper) { return null; }

    // ----------------------------------------------------------------
    // main 메소드
    // ----------------------------------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }
}
