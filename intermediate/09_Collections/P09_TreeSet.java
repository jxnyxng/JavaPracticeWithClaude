/*
 * =====================================================
 * 파일명: P09_TreeSet.java
 * 주제: TreeSet - 정렬된 집합 자료구조
 * =====================================================
 *
 * 【학습 목표】
 * 1. TreeSet이 원소를 자동으로 정렬하는 원리를 이해하고 활용할 수 있다.
 * 2. TreeSet의 탐색 메소드(first, last, higher, lower, floor, ceiling)를 정확히 사용할 수 있다.
 * 3. TreeSet의 범위 조회 메소드(subSet, headSet, tailSet)를 활용하여 부분 집합을 추출할 수 있다.
 *
 * 【핵심 개념】
 * - TreeSet:
 *   · NavigableSet 인터페이스 구현, 내부적으로 TreeMap 사용 (Red-Black Tree)
 *   · 원소를 자연 순서(Comparable) 또는 지정 Comparator로 자동 정렬
 *   · 중복 원소 불허 (Set의 특성 유지)
 *   · 검색/삽입/삭제 시간복잡도: O(log n)
 *   · null 원소 허용 안 함 (NullPointerException 발생)
 *
 * - TreeSet 탐색 메소드:
 *   · first()           : 가장 작은 원소 반환
 *   · last()            : 가장 큰 원소 반환
 *   · floor(e)          : e 이하인 가장 큰 원소 반환 (e 포함)
 *   · ceiling(e)        : e 이상인 가장 작은 원소 반환 (e 포함)
 *   · lower(e)          : e 미만인 가장 큰 원소 반환 (e 미포함)
 *   · higher(e)         : e 초과인 가장 작은 원소 반환 (e 미포함)
 *   · pollFirst()       : 가장 작은 원소 꺼내고 삭제
 *   · pollLast()        : 가장 큰 원소 꺼내고 삭제
 *
 * - TreeSet 범위 조회 메소드:
 *   · subSet(from, to)              : [from, to) 범위 원소 반환
 *   · subSet(from, fromInclusive, to, toInclusive): 경계 포함 여부 지정
 *   · headSet(to)                   : to 미만인 원소들 반환
 *   · headSet(to, inclusive)        : inclusive=true면 to 포함
 *   · tailSet(from)                 : from 이상인 원소들 반환
 *   · tailSet(from, inclusive)      : inclusive=false면 from 미포함
 *   · descendingSet()               : 역순으로 정렬된 뷰 반환
 *
 * - floor vs lower, ceiling vs higher 차이:
 *   · floor(5): 5 이하 (5, 4, 3, ...)  |  lower(5): 5 미만 (4, 3, ...)
 *   · ceiling(5): 5 이상 (5, 6, 7, ...) | higher(5): 5 초과 (6, 7, ...)
 */

import java.util.*;

public class P09_TreeSet {

    // =====================================================
    // 문제 1: TreeSet 자동 정렬 확인
    // =====================================================
    /*
     * 【문제 1】 TreeSet의 자동 정렬 특성 실습
     *
     * 설명:
     *   무작위 순서로 데이터를 삽입해도 TreeSet이 자동으로 정렬함을 확인하고,
     *   다양한 타입으로 정렬을 실습하세요.
     *
     * 요구사항:
     *   [정수 정렬]
     *   1. TreeSet<Integer>에 다음을 무작위 순서로 추가:
     *      50, 20, 80, 10, 60, 30, 90, 40, 70
     *   2. 추가 후 전체 출력 (자동으로 오름차순 정렬됨)
     *   3. 중복 추가 테스트: 50을 재추가하여 false 반환 확인
     *
     *   [문자열 정렬]
     *   4. TreeSet<String>에 다음을 무작위 순서로 추가:
     *      "banana", "apple", "cherry", "date", "elderberry"
     *   5. 추가 후 전체 출력 (알파벳순 자동 정렬됨)
     *
     *   [역순 정렬]
     *   6. Comparator.reverseOrder()를 사용하여 역순 TreeSet 생성
     *   7. 동일한 정수 데이터를 역순 TreeSet에 추가 후 출력
     *
     * 예상 출력:
     *   [정수 TreeSet] 자동 오름차순 정렬:
     *   [10, 20, 30, 40, 50, 60, 70, 80, 90]
     *   50 재추가 결과: false
     *   [문자열 TreeSet] 알파벳순 정렬:
     *   [apple, banana, cherry, date, elderberry]
     *   [역순 TreeSet] 내림차순 정렬:
     *   [90, 80, 70, 60, 50, 40, 30, 20, 10]
     *
     * 힌트:
     *   - TreeSet은 add 순서와 관계없이 항상 정렬된 상태를 유지합니다.
     *   - new TreeSet<>(Comparator.reverseOrder())로 역순 TreeSet을 생성합니다.
     */
    static void problem1_autoSorting() {
        System.out.println("=== 문제 1: TreeSet 자동 정렬 ===");

        // TODO: TreeSet<Integer> 생성

        // TODO: 정수 9개 무작위 순서로 add

        // TODO: 전체 출력 (자동 정렬됨)

        // TODO: 50 재추가 후 반환값 출력

        // TODO: TreeSet<String> 생성 및 과일 이름 5개 추가

        // TODO: 전체 출력 (알파벳순 정렬됨)

        // TODO: Comparator.reverseOrder()로 역순 TreeSet 생성 및 동일 정수 추가

        // TODO: 역순 TreeSet 출력

        System.out.println();
    }

    // =====================================================
    // 문제 2: TreeSet 탐색 메소드
    // =====================================================
    /*
     * 【문제 2】 first, last, higher, lower, floor, ceiling 사용
     *
     * 설명:
     *   경매 시스템을 TreeSet으로 구현하고, 입찰가 탐색 기능을 구현하세요.
     *
     * 데이터 (입찰가 목록):
     *   {100, 250, 180, 320, 150, 400, 270, 90, 350}
     *
     * 요구사항:
     *   1. 전체 입찰가 정렬하여 출력
     *   2. first()로 최저 입찰가 출력
     *   3. last()로 최고 입찰가 출력
     *   4. floor(200): 200 이하인 가장 높은 입찰가 출력
     *   5. ceiling(200): 200 이상인 가장 낮은 입찰가 출력
     *   6. lower(250): 250 미만인 가장 높은 입찰가 출력
     *   7. higher(250): 250 초과인 가장 낮은 입찰가 출력
     *   8. floor(80): 80 이하 입찰가 없을 때 null 반환 확인
     *   9. pollFirst()로 최저 입찰가를 꺼내고, 크기 변화 확인
     *
     * 예상 출력:
     *   전체 입찰가: [90, 100, 150, 180, 250, 270, 320, 350, 400]
     *   최저 입찰가 (first): 90
     *   최고 입찰가 (last): 400
     *   200 이하 최고가 (floor): 180
     *   200 이상 최저가 (ceiling): 250
     *   250 미만 최고가 (lower): 180
     *   250 초과 최저가 (higher): 270
     *   80 이하 입찰가 (floor): null
     *   pollFirst 후 최저가: 90, 남은 크기: 8
     *
     * 힌트:
     *   - floor, ceiling, lower, higher는 해당 원소가 없으면 null을 반환합니다.
     *   - pollFirst/pollLast는 원소를 꺼내면서 TreeSet에서 삭제합니다.
     */
    static void problem2_navigationMethods() {
        System.out.println("=== 문제 2: TreeSet 탐색 메소드 ===");

        // TODO: TreeSet<Integer> 생성 및 입찰가 데이터 추가

        // TODO: 전체 입찰가 출력

        // TODO: first()로 최저 입찰가 출력

        // TODO: last()로 최고 입찰가 출력

        // TODO: floor(200) 출력

        // TODO: ceiling(200) 출력

        // TODO: lower(250) 출력

        // TODO: higher(250) 출력

        // TODO: floor(80) 출력 (null 확인)

        // TODO: pollFirst()로 최저가 꺼내고 크기 변화 확인

        System.out.println();
    }

    // =====================================================
    // 문제 3: TreeSet 범위 조회
    // =====================================================
    /*
     * 【문제 3】 subSet, headSet, tailSet으로 범위 조회
     *
     * 설명:
     *   학생 점수 목록을 TreeSet으로 관리하고,
     *   다양한 범위 조회로 등급별 학생 수를 계산하세요.
     *
     * 데이터 (점수 목록):
     *   {55, 62, 71, 78, 83, 88, 91, 95, 98, 45, 67, 74, 80, 86, 93}
     *
     * 요구사항:
     *   1. 전체 점수 정렬하여 출력
     *   2. headSet(60): 60점 미만인 점수들 출력 (F 등급)
     *   3. subSet(60, 70): [60, 70) 범위 점수들 출력 (D 등급)
     *   4. subSet(70, 80): [70, 80) 범위 점수들 출력 (C 등급)
     *   5. subSet(80, 90): [80, 90) 범위 점수들 출력 (B 등급)
     *   6. tailSet(90): 90점 이상인 점수들 출력 (A 등급)
     *   7. subSet(70, true, 90, true): [70, 90] 범위 (경계 포함)
     *   8. descendingSet()으로 내림차순 출력
     *
     * 예상 출력:
     *   전체 점수: [45, 55, 62, 67, 71, 74, 78, 80, 83, 86, 88, 91, 93, 95, 98]
     *   F 등급 (60 미만): [45, 55] - 2명
     *   D 등급 [60,70): [62, 67] - 2명
     *   C 등급 [70,80): [71, 74, 78] - 3명
     *   B 등급 [80,90): [80, 83, 86, 88] - 4명
     *   A 등급 (90 이상): [91, 93, 95, 98] - 4명
     *   [70,90] 포함: [71, 74, 78, 80, 83, 86, 88]
     *   내림차순: [98, 95, 93, 91, 88, ...]
     *
     * 힌트:
     *   - subSet, headSet, tailSet은 원본 TreeSet의 뷰(view)를 반환합니다.
     *     원본이 변경되면 뷰도 변경됩니다.
     *   - subSet(from, fromInclusive, to, toInclusive): 경계 포함 여부 직접 지정
     *   - descendingSet()은 역순 NavigableSet 뷰를 반환합니다.
     */
    static void problem3_rangeQuery() {
        System.out.println("=== 문제 3: TreeSet 범위 조회 ===");

        // TODO: TreeSet<Integer> 생성 및 점수 데이터 추가

        // TODO: 전체 점수 출력

        // TODO: headSet(60)으로 F 등급 (60 미만) 출력

        // TODO: subSet(60, 70)으로 D 등급 [60, 70) 출력

        // TODO: subSet(70, 80)으로 C 등급 [70, 80) 출력

        // TODO: subSet(80, 90)으로 B 등급 [80, 90) 출력

        // TODO: tailSet(90)으로 A 등급 (90 이상) 출력

        // TODO: subSet(70, true, 90, true)로 [70, 90] (경계 포함) 출력

        // TODO: descendingSet()으로 내림차순 출력

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 (시그니처만 작성)
    // =====================================================

    /**
     * 정수 배열을 입력받아 중앙값(median)을 반환합니다.
     * TreeSet을 활용하여 정렬된 상태에서 중앙값을 찾습니다.
     * @param numbers 정수 배열 (중복 없음 가정)
     * @return 중앙값
     */
    static int findMedian(int[] numbers) {
        // TODO: TreeSet에 넣고 크기의 절반 위치 원소 반환
        return 0;
    }

    /**
     * 두 TreeSet 중 공통 원소를 TreeSet으로 반환합니다.
     * @param set1 첫 번째 TreeSet
     * @param set2 두 번째 TreeSet
     * @return 공통 원소 TreeSet (정렬 유지)
     */
    static TreeSet<Integer> intersection(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        // TODO: 구현
        return null;
    }

    /**
     * TreeSet에서 k번째로 작은 원소를 반환합니다. (1-indexed)
     * @param set 검색할 TreeSet
     * @param k 순위 (1부터 시작)
     * @return k번째로 작은 원소
     */
    static int kthSmallest(TreeSet<Integer> set, int k) {
        // TODO: iterator 또는 stream으로 k번째 원소 반환
        return 0;
    }

    // =====================================================
    // main 메소드
    // =====================================================
    public static void main(String[] args) {
        problem1_autoSorting();
        problem2_navigationMethods();
        problem3_rangeQuery();
    }
}
