/*
 * =====================================================
 * 파일명: P08_HashSet.java
 * 주제: HashSet - 중복을 허용하지 않는 집합 자료구조
 * =====================================================
 *
 * 【학습 목표】
 * 1. HashSet의 특성(중복 불허, 순서 없음)을 이해하고 기본 연산을 구현할 수 있다.
 * 2. HashSet을 활용하여 중복 데이터를 효과적으로 제거할 수 있다.
 * 3. 집합 연산(합집합, 교집합, 차집합)을 HashSet 메소드로 구현할 수 있다.
 *
 * 【핵심 개념】
 * - HashSet:
 *   · Set 인터페이스 구현, 내부적으로 HashMap을 사용
 *   · 중복 원소를 허용하지 않음 (equals와 hashCode로 중복 판단)
 *   · null 값 하나만 허용
 *   · 저장 순서를 보장하지 않음
 *   · 평균 O(1) 시간복잡도로 add, remove, contains 연산 가능
 *
 * - Set 인터페이스 주요 메소드:
 *   · add(E e)          : 원소 추가 (이미 있으면 false 반환, 추가 안 됨)
 *   · remove(Object o)  : 원소 삭제
 *   · contains(Object o): 원소 존재 여부 확인
 *   · size()            : 원소 개수 반환
 *   · isEmpty()         : 비어있는지 확인
 *   · iterator()        : 이터레이터 반환
 *   · toArray()         : 배열로 변환
 *
 * - 집합 연산 메소드:
 *   · addAll(Collection c)      : 합집합 (현재 Set에 c의 원소 모두 추가)
 *   · retainAll(Collection c)   : 교집합 (c에 없는 원소 모두 제거)
 *   · removeAll(Collection c)   : 차집합 (c에 있는 원소 모두 제거)
 *   · containsAll(Collection c) : 부분집합 여부 확인
 *
 * 주의: addAll, retainAll, removeAll은 원본 Set을 수정합니다.
 *      원본 보존이 필요하면 새 HashSet을 만들어 사용하세요.
 */

import java.util.*;

public class P08_HashSet {

    // =====================================================
    // 문제 1: HashSet 기본 연산
    // =====================================================
    /*
     * 【문제 1】 HashSet 기본 add, contains, remove, size 연산
     *
     * 설명:
     *   과일 이름을 저장하는 HashSet을 만들고 기본 연산을 수행하세요.
     *
     * 요구사항:
     *   1. HashSet 생성 후 아래 과일 추가:
     *      "사과", "바나나", "딸기", "포도", "수박"
     *   2. add() 반환값 테스트: "사과" 재추가 시 false 반환 확인
     *   3. "딸기"가 포함되어 있는지 contains()로 확인
     *   4. "키위"가 포함되어 있는지 확인
     *   5. "바나나" 삭제 후 크기 출력
     *   6. 전체 원소 향상된 for문으로 출력
     *   7. HashSet을 ArrayList로 변환하여 출력
     *
     * 예상 출력:
     *   초기 크기: 5
     *   "사과" 재추가 결과: false
     *   "딸기" 포함 여부: true
     *   "키위" 포함 여부: false
     *   "바나나" 삭제 후 크기: 4
     *   전체 원소 (순서 무관): 사과 딸기 포도 수박
     *   ArrayList 변환: [사과, 딸기, 포도, 수박] (순서 무관)
     *
     * 힌트:
     *   - add()는 추가 성공 시 true, 이미 존재하면 false를 반환합니다.
     *   - new ArrayList<>(set)으로 간단히 HashSet을 ArrayList로 변환합니다.
     */
    static void problem1_basicOperations() {
        System.out.println("=== 문제 1: HashSet 기본 연산 ===");

        // TODO: HashSet<String> 생성 및 과일 5개 추가

        // TODO: 초기 크기 출력

        // TODO: "사과" 재추가하여 반환값(false) 확인 및 출력

        // TODO: contains()로 "딸기", "키위" 존재 여부 출력

        // TODO: "바나나" 삭제 후 크기 출력

        // TODO: 향상된 for문으로 전체 원소 출력

        // TODO: new ArrayList<>(set)으로 변환하여 출력

        System.out.println();
    }

    // =====================================================
    // 문제 2: 중복 요소 자동 제거 활용
    // =====================================================
    /*
     * 【문제 2】 HashSet으로 중복 데이터 제거하기
     *
     * 설명:
     *   중복이 포함된 데이터에서 HashSet을 활용하여 고유 값만 추출하세요.
     *
     * 요구사항:
     *   [중복 제거 - 기본]
     *   1. 아래 중복이 있는 배열을 HashSet에 넣어 중복 제거:
     *      int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7}
     *   2. 중복 제거 전후 개수 비교 출력
     *   3. 중복된 값이 몇 종류인지 출력
     *
     *   [중복 제거 - 문자열]
     *   4. 아래 이름 목록에서 중복 제거:
     *      String[] names = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Diana", "Alice"}
     *   5. 고유 이름 목록 출력
     *
     *   [중복 확인]
     *   6. 주어진 배열에 중복이 있는지 확인하는 로직 작성
     *      (HashSet에 넣을 때 add가 false를 반환하면 중복)
     *
     * 예상 출력:
     *   원본 배열 크기: 14
     *   중복 제거 후 크기: 9
     *   중복된 값 종류 수: 5 (1, 3, 5, 9가 중복)
     *   고유 이름: [Alice, Bob, Charlie, Diana] (순서 무관)
     *   중복 여부: true
     *
     * 힌트:
     *   - Integer 배열은 Arrays.asList()로, int 배열은 직접 반복문으로 추가해야 합니다.
     *   - 원본 크기 - HashSet 크기 = 제거된 중복 수
     */
    static void problem2_deduplication() {
        System.out.println("=== 문제 2: 중복 요소 제거 ===");
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7};
        String[] names = {"Alice", "Bob", "Alice", "Charlie", "Bob", "Diana", "Alice"};

        // TODO: numbers 배열을 HashSet<Integer>에 추가 (반복문 사용)

        // TODO: 원본 배열 크기와 HashSet 크기 비교 출력

        // TODO: 중복된 값 종류 수 계산 및 출력

        // TODO: names 배열을 HashSet<String>에 추가

        // TODO: 고유 이름 목록 출력

        // TODO: 배열에 중복이 있는지 확인하는 로직 구현
        //       (add() 반환값이 false이면 중복 발견)

        System.out.println();
    }

    // =====================================================
    // 문제 3: 집합 연산 (합집합, 교집합, 차집합)
    // =====================================================
    /*
     * 【문제 3】 두 집합의 합집합, 교집합, 차집합 구하기
     *
     * 설명:
     *   두 반의 수강 과목 목록을 집합으로 표현하고,
     *   집합 연산으로 다양한 정보를 추출하세요.
     *
     * 데이터:
     *   A반 수강 과목: {"수학", "영어", "과학", "역사", "미술"}
     *   B반 수강 과목: {"영어", "음악", "과학", "체육", "미술"}
     *
     * 요구사항:
     *   1. 합집합 (A ∪ B): A반 또는 B반에서 수강하는 모든 과목 출력
     *   2. 교집합 (A ∩ B): 두 반 모두 수강하는 과목 출력
     *   3. 차집합 (A - B): A반만 수강하는 과목 출력
     *   4. 차집합 (B - A): B반만 수강하는 과목 출력
     *   5. 대칭 차집합 ((A-B) ∪ (B-A)): 한 반에서만 수강하는 과목 출력
     *   6. A반이 B반의 부분집합인지 확인 (containsAll)
     *
     * 예상 출력:
     *   A반: [수학, 영어, 과학, 역사, 미술]
     *   B반: [영어, 음악, 과학, 체육, 미술]
     *   합집합 (A ∪ B): [수학, 영어, 과학, 역사, 미술, 음악, 체육] (크기: 7)
     *   교집합 (A ∩ B): [영어, 과학, 미술] (크기: 3)
     *   차집합 (A - B): [수학, 역사] (A반만 수강)
     *   차집합 (B - A): [음악, 체육] (B반만 수강)
     *   대칭 차집합: [수학, 역사, 음악, 체육]
     *   A가 B의 부분집합: false
     *
     * 힌트:
     *   - 원본 Set이 변경되지 않도록 new HashSet<>(original)로 복사본을 만드세요.
     *   - 합집합: 복사본.addAll(다른 Set)
     *   - 교집합: 복사본.retainAll(다른 Set)
     *   - 차집합: 복사본.removeAll(다른 Set)
     */
    static void problem3_setOperations() {
        System.out.println("=== 문제 3: 집합 연산 ===");

        // TODO: A반 과목 HashSet 생성 및 초기화

        // TODO: B반 과목 HashSet 생성 및 초기화

        // TODO: A반, B반 각각 출력

        // TODO: 합집합 구하기 (원본 보존을 위해 복사본 사용, addAll)

        // TODO: 교집합 구하기 (원본 보존을 위해 복사본 사용, retainAll)

        // TODO: 차집합 A-B 구하기 (원본 보존을 위해 복사본 사용, removeAll)

        // TODO: 차집합 B-A 구하기

        // TODO: 대칭 차집합 구하기 ((A-B) ∪ (B-A) = addAll 활용)

        // TODO: containsAll로 A가 B의 부분집합인지 확인

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 (시그니처만 작성)
    // =====================================================

    /**
     * 주어진 배열에서 중복된 값들만 모아 반환합니다.
     * @param arr 검사할 정수 배열
     * @return 중복된 값의 Set
     */
    static Set<Integer> findDuplicates(int[] arr) {
        // TODO: 구현
        return null;
    }

    /**
     * 두 Set의 교집합 크기를 반환합니다.
     * 원본 Set은 변경하지 않습니다.
     * @param set1 첫 번째 집합
     * @param set2 두 번째 집합
     * @return 교집합 원소의 수
     */
    static int intersectionSize(Set<String> set1, Set<String> set2) {
        // TODO: 구현
        return 0;
    }

    /**
     * 리스트에서 중복을 제거하고 원래 순서를 유지한 결과를 반환합니다.
     * (힌트: LinkedHashSet 사용)
     * @param list 원본 리스트
     * @return 중복 제거된 리스트 (순서 유지)
     */
    static List<String> removeDuplicatesKeepOrder(List<String> list) {
        // TODO: LinkedHashSet으로 구현
        return null;
    }

    // =====================================================
    // main 메소드
    // =====================================================
    public static void main(String[] args) {
        problem1_basicOperations();
        problem2_deduplication();
        problem3_setOperations();
    }
}
