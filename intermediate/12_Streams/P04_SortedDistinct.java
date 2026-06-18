/**
 * =====================================================================
 * 파일명: P04_SortedDistinct.java
 * 주제: sorted, distinct, limit, skip
 * =====================================================================
 *
 * 【학습목표】
 * 1. sorted()로 자연 순서 및 Comparator를 이용한 사용자 정의 정렬을 적용할 수 있다.
 * 2. distinct()로 스트림에서 중복 원소를 제거할 수 있다.
 * 3. limit()과 skip()을 조합하여 페이징(paging) 처리를 구현할 수 있다.
 *
 * 【핵심개념】
 * - sorted(): 스트림 원소를 자연 순서(Comparable 기준)로 정렬하는 중간 연산.
 * - sorted(Comparator<T>): Comparator를 지정하여 사용자 정의 기준으로 정렬.
 *   예) .sorted(Comparator.reverseOrder())       → 역순 정렬
 *       .sorted(Comparator.comparingInt(String::length)) → 문자열 길이 오름차순
 *
 * - distinct(): equals()와 hashCode()를 기준으로 중복 원소를 제거하는 중간 연산.
 *
 * - limit(n): 스트림에서 앞에서부터 최대 n개의 원소만 처리하도록 자르는 중간 연산.
 * - skip(n): 스트림 앞에서부터 n개 원소를 건너뛰는 중간 연산.
 *   페이징 공식:
 *   page 번호(0-based)에서: .skip(pageNumber * pageSize).limit(pageSize)
 * =====================================================================
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P04_SortedDistinct {

    // ----------------------------------------------------------------
    // 문제 1: sorted (자연 순서, Comparator)
    // ----------------------------------------------------------------
    /**
     * 【문제 1】 sorted() 정렬 활용
     *
     * 설명:
     *   (1) 정수 리스트 [5, 3, 8, 1, 9, 2, 7, 4, 6]을
     *       sorted()로 오름차순 정렬하여 출력하시오.
     *   (2) 같은 리스트를 sorted(Comparator.reverseOrder())로 내림차순 정렬하여 출력하시오.
     *   (3) 문자열 리스트 ["banana", "apple", "kiwi", "fig", "cherry"]를
     *       문자열 길이 기준 오름차순으로 정렬하여 출력하시오.
     *       (길이가 같으면 사전 순서로 정렬)
     *
     * 예상 출력:
     *   오름차순: [1, 2, 3, 4, 5, 6, 7, 8, 9]
     *   내림차순: [9, 8, 7, 6, 5, 4, 3, 2, 1]
     *   길이순 정렬: [fig, kiwi, apple, banana, cherry]
     *
     * 힌트:
     *   .sorted()
     *   .sorted(Comparator.reverseOrder())
     *   .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
     */
    static void problem1() {
        System.out.println("=== 문제 1: sorted() 정렬 ===");
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 9, 2, 7, 4, 6);
        List<String> fruits = Arrays.asList("banana", "apple", "kiwi", "fig", "cherry");

        // TODO: 오름차순 정렬 후 출력 (형식: "오름차순: [...]")

        // TODO: 내림차순 정렬 후 출력 (형식: "내림차순: [...]")

        // TODO: 문자열 길이 기준 오름차순 정렬 후 출력 (형식: "길이순 정렬: [...]")

    }

    // ----------------------------------------------------------------
    // 문제 2: distinct로 중복 제거
    // ----------------------------------------------------------------
    /**
     * 【문제 2】 distinct() 중복 제거
     *
     * 설명:
     *   (1) 정수 리스트 [1, 2, 2, 3, 3, 3, 4, 4, 5]에서
     *       distinct()로 중복을 제거한 뒤 출력하시오.
     *   (2) 문자열 리스트 ["Java", "Python", "Java", "C++", "Python", "Go", "Go"]에서
     *       distinct()로 중복을 제거하고 sorted()로 정렬하여 출력하시오.
     *
     * 예상 출력:
     *   중복 제거 (정수): [1, 2, 3, 4, 5]
     *   중복 제거 후 정렬 (문자열): [C++, Go, Java, Python]
     *
     * 힌트:
     *   .distinct()
     *   .distinct().sorted()
     *   .collect(Collectors.toList())
     */
    static void problem2() {
        System.out.println("=== 문제 2: distinct() 중복 제거 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 5);
        List<String> languages = Arrays.asList("Java", "Python", "Java", "C++", "Python", "Go", "Go");

        // TODO: 정수 리스트 중복 제거 후 출력 (형식: "중복 제거 (정수): [...]")

        // TODO: 문자열 리스트 중복 제거 + 정렬 후 출력 (형식: "중복 제거 후 정렬 (문자열): [...]")

    }

    // ----------------------------------------------------------------
    // 문제 3: limit과 skip으로 페이징 처리
    // ----------------------------------------------------------------
    /**
     * 【문제 3】 limit()과 skip()으로 페이징 구현
     *
     * 설명:
     *   정수 리스트 [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]을 이용하여
     *   페이지 크기(pageSize)를 3으로 설정하고 다음을 수행하시오.
     *   (1) limit(3)으로 첫 3개 원소만 출력하시오.
     *   (2) skip(3)으로 앞 3개를 건너뛴 뒤 나머지를 출력하시오.
     *   (3) 0-based 페이지 번호를 이용해 다음 세 페이지를 각각 출력하시오.
     *       - 0페이지: [1, 2, 3]
     *       - 1페이지: [4, 5, 6]
     *       - 2페이지: [7, 8, 9]
     *       - 3페이지: [10]  ← 마지막 페이지(원소 부족해도 정상 동작)
     *
     * 예상 출력:
     *   처음 3개 (limit): [1, 2, 3]
     *   앞 3개 건너뜀 (skip): [4, 5, 6, 7, 8, 9, 10]
     *   0페이지: [1, 2, 3]
     *   1페이지: [4, 5, 6]
     *   2페이지: [7, 8, 9]
     *   3페이지: [10]
     *
     * 힌트:
     *   .limit(pageSize)
     *   .skip(3)
     *   .skip((long) pageNumber * pageSize).limit(pageSize)
     */
    static void problem3() {
        System.out.println("=== 문제 3: limit() / skip() 페이징 ===");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int pageSize = 3;

        // TODO: limit(3)으로 처음 3개 출력 (형식: "처음 3개 (limit): [...]")

        // TODO: skip(3)으로 앞 3개 건너뜀 후 출력 (형식: "앞 3개 건너뜀 (skip): [...]")

        // TODO: 0페이지부터 3페이지까지 각각 페이징 출력
        //       (형식: "X페이지: [...]")
        for (int pageNumber = 0; pageNumber <= 3; pageNumber++) {
            // TODO: skip(pageNumber * pageSize).limit(pageSize)로 해당 페이지 원소 수집 후 출력
        }

    }

    // ----------------------------------------------------------------
    // 헬퍼 메소드
    // ----------------------------------------------------------------
    /** 페이지 번호와 크기를 받아 해당 페이지의 원소 리스트를 반환 */
    static List<Integer> getPage(List<Integer> list, int pageNumber, int pageSize) { return null; }

    /** 리스트를 특정 Comparator 기준으로 정렬하여 반환 */
    static <T> List<T> sortedList(List<T> list, Comparator<T> comparator) { return null; }

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
