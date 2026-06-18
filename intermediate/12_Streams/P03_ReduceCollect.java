/**
 * =====================================================================
 * 파일명: P03_ReduceCollect.java
 * 주제: reduce와 collect 최종 연산
 * =====================================================================
 *
 * 【학습목표】
 * 1. reduce()를 사용하여 스트림의 모든 원소를 하나의 값으로 누적 계산할 수 있다.
 * 2. collect()와 Collectors 팩토리 메소드(toList, toSet, toMap)로 결과를 수집할 수 있다.
 * 3. Collectors.joining(), Collectors.groupingBy()로 문자열 결합과 그룹핑을 수행할 수 있다.
 *
 * 【핵심개념】
 * - reduce(identity, BinaryOperator<T>):
 *   초기값(identity)부터 시작하여 누산기(accumulator) 함수를 반복 적용해 단일 결과를 생성.
 *   예) .reduce(0, Integer::sum)  → 모든 원소 합산
 *       .reduce(1, (a, b) -> a * b)  → 모든 원소 곱셈
 *
 * - collect(Collector): 스트림 원소를 컬렉션이나 다른 자료구조로 모을 때 사용하는 최종 연산.
 *   Collectors.toList()    → List로 수집
 *   Collectors.toSet()     → Set으로 수집 (중복 제거)
 *   Collectors.toMap(k, v) → Map으로 수집
 *
 * - Collectors.joining(delimiter, prefix, suffix):
 *   문자열 스트림의 원소를 구분자로 연결하여 하나의 String으로 반환.
 *
 * - Collectors.groupingBy(classifier):
 *   분류 함수(classifier)의 반환값을 키로, 해당 원소들의 List를 값으로 하는 Map을 생성.
 * =====================================================================
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class P03_ReduceCollect {

    // ----------------------------------------------------------------
    // 문제 1: reduce로 합계, 곱, 최대값 계산
    // ----------------------------------------------------------------
    /**
     * 【문제 1】 reduce() 기본 활용
     *
     * 설명:
     *   정수 리스트 [1, 2, 3, 4, 5]를 이용하여
     *   (1) reduce()로 모든 원소의 합계를 계산하여 출력하시오.
     *   (2) reduce()로 모든 원소의 곱을 계산하여 출력하시오.
     *   (3) reduce()로 최대값을 계산하여 출력하시오.
     *       (identity 없이 Optional 반환 형태로 구현)
     *
     * 예상 출력:
     *   합계: 15
     *   곱: 120
     *   최대값: 5
     *
     * 힌트:
     *   .reduce(0, Integer::sum)
     *   .reduce(1, (a, b) -> a * b)
     *   .reduce(Integer::max)  → Optional<Integer> 반환
     *   optResult.ifPresent(v -> System.out.println("최대값: " + v));
     */
    static void problem1() {
        System.out.println("=== 문제 1: reduce() 합계 / 곱 / 최대값 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // TODO: reduce로 합계 계산 후 출력 (형식: "합계: X")

        // TODO: reduce로 곱 계산 후 출력 (형식: "곱: X")

        // TODO: reduce로 최대값 계산 후 출력 (형식: "최대값: X")

    }

    // ----------------------------------------------------------------
    // 문제 2: collect(Collectors.toList/toSet/toMap)
    // ----------------------------------------------------------------
    /**
     * 【문제 2】 collect()로 다양한 컬렉션에 수집
     *
     * 설명:
     *   문자열 리스트 ["Java", "Python", "Java", "C++", "Python", "Go"]를 이용하여
     *   (1) Collectors.toList()로 수집하여 출력하시오.
     *   (2) Collectors.toSet()으로 수집하여 중복이 제거된 결과를 출력하시오.
     *       (Set은 순서 보장 안 됨)
     *   (3) 문자열 리스트 ["apple", "banana", "cherry"]를 이용해
     *       Collectors.toMap()으로 {문자열 → 문자열길이} 형태의 Map을 만들어 출력하시오.
     *
     * 예상 출력 (예시):
     *   toList: [Java, Python, Java, C++, Python, Go]
     *   toSet (중복 제거): [Java, Go, C++, Python]  ← 순서 다를 수 있음
     *   toMap: {apple=5, banana=6, cherry=6}
     *
     * 힌트:
     *   .collect(Collectors.toList())
     *   .collect(Collectors.toSet())
     *   .collect(Collectors.toMap(s -> s, String::length))
     */
    static void problem2() {
        System.out.println("=== 문제 2: collect() toList / toSet / toMap ===");
        List<String> langs = Arrays.asList("Java", "Python", "Java", "C++", "Python", "Go");
        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        // TODO: toList()로 수집 후 출력 (형식: "toList: [...]")

        // TODO: toSet()으로 수집 후 출력 (형식: "toSet (중복 제거): {...}")

        // TODO: fruits를 toMap()으로 {문자열 → 길이} Map 생성 후 출력 (형식: "toMap: {...}")

    }

    // ----------------------------------------------------------------
    // 문제 3: Collectors.joining, Collectors.groupingBy
    // ----------------------------------------------------------------
    /**
     * 【문제 3】 joining과 groupingBy 활용
     *
     * 설명:
     *   (1) 문자열 리스트 ["Java", "Python", "C++", "Kotlin"]을
     *       Collectors.joining(", ", "[", "]")로 연결하여 출력하시오.
     *
     *   (2) 문자열 리스트 ["apple", "banana", "avocado", "blueberry", "cherry"]를
     *       첫 글자(charAt(0))를 기준으로 groupingBy하여
     *       {첫 글자 → 해당 문자열 리스트} 형태의 Map을 출력하시오.
     *
     * 예상 출력:
     *   joining: [Java, Python, C++, Kotlin]
     *   groupingBy 첫 글자:
     *   {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
     *   ← 실제 출력 순서는 Map 구현에 따라 다를 수 있음
     *
     * 힌트:
     *   .collect(Collectors.joining(", ", "[", "]"))
     *   .collect(Collectors.groupingBy(s -> s.charAt(0)))
     *   Map<Character, List<String>> grouped = ...
     */
    static void problem3() {
        System.out.println("=== 문제 3: joining / groupingBy ===");
        List<String> languages = Arrays.asList("Java", "Python", "C++", "Kotlin");
        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry");

        // TODO: joining으로 ", " 구분자, "[" prefix, "]" suffix 적용 후 출력
        //       (형식: "joining: [Java, Python, C++, Kotlin]")

        // TODO: 첫 글자 기준으로 groupingBy 후 Map 출력
        //       (형식: "groupingBy 첫 글자:")
        //       다음 줄에 Map 내용 출력

    }

    // ----------------------------------------------------------------
    // 헬퍼 메소드
    // ----------------------------------------------------------------
    /** 정수 리스트를 받아 합계를 반환 */
    static int sumList(List<Integer> list) { return 0; }

    /** 정수 리스트를 받아 최대값을 Optional로 반환 */
    static Optional<Integer> maxList(List<Integer> list) { return Optional.empty(); }

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
