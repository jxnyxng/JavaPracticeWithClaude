/*
 * =====================================================
 * 파일명: P10_CollectionsUtility.java
 * 주제: Collections 유틸리티 클래스와 불변 컬렉션
 * =====================================================
 *
 * 【학습 목표】
 * 1. java.util.Collections 유틸리티 클래스의 정렬/검색/수정 메소드를 활용할 수 있다.
 * 2. Collections.unmodifiableXxx()로 기존 컬렉션을 불변으로 감싸는 방법을 이해한다.
 * 3. Java 9+의 List.of, Map.of, Set.of로 간결하게 불변 컬렉션을 생성할 수 있다.
 *
 * 【핵심 개념】
 * - java.util.Collections (인스턴스 생성 없이 static 메소드로 사용):
 *   · 정렬/순서 변경:
 *     - sort(List)                    : 자연 순서로 정렬
 *     - sort(List, Comparator)        : Comparator 지정 정렬
 *     - reverse(List)                 : 리스트 역순으로 변경
 *     - shuffle(List)                 : 무작위 섞기
 *     - shuffle(List, Random)         : 시드 지정 무작위 섞기
 *     - swap(List, int i, int j)      : i번째와 j번째 원소 교환
 *     - rotate(List, int distance)    : 원소들을 distance만큼 우측 회전
 *   · 검색/통계:
 *     - min(Collection)               : 최솟값 반환
 *     - max(Collection)               : 최댓값 반환
 *     - min/max(Collection, Comparator): Comparator 기준 최솟값/최댓값
 *     - frequency(Collection, Object) : 특정 원소의 등장 횟수
 *     - disjoint(Collection, Collection): 두 컬렉션이 공통 원소가 없으면 true
 *     - binarySearch(List, key)       : 정렬된 리스트에서 이진 탐색
 *   · 채우기/복사:
 *     - fill(List, obj)               : 모든 원소를 동일한 값으로 채우기
 *     - nCopies(n, obj)               : 동일한 값 n개를 가진 불변 리스트 반환
 *     - copy(dest, src)               : src를 dest로 복사 (dest가 더 커야 함)
 *
 * - 불변 컬렉션 래퍼:
 *   · Collections.unmodifiableList(list)  : 읽기 전용 List 뷰 반환
 *   · Collections.unmodifiableMap(map)    : 읽기 전용 Map 뷰 반환
 *   · Collections.unmodifiableSet(set)    : 읽기 전용 Set 뷰 반환
 *   · 수정 시도 시 UnsupportedOperationException 발생
 *   · 원본 컬렉션이 변경되면 뷰도 변경됨 (진정한 불변이 아님)
 *
 * - Java 9+ 불변 팩토리 메소드 (진정한 불변):
 *   · List.of(e1, e2, ...)        : null 불허, 수정 불가 List
 *   · Set.of(e1, e2, ...)         : null 불허, 중복 불허, 수정 불가 Set
 *   · Map.of(k1,v1, k2,v2, ...)   : null 불허, 키 중복 불허, 수정 불가 Map (최대 10쌍)
 *   · Map.ofEntries(Map.entry(k,v), ...): 10쌍 초과 시 사용
 *   · List.copyOf(collection)     : 기존 컬렉션을 불변 복사본으로 생성
 */

import java.util.*;

public class P10_CollectionsUtility {

    // =====================================================
    // 문제 1: sort, reverse, shuffle, swap, rotate
    // =====================================================
    /*
     * 【문제 1】 Collections의 정렬 및 순서 변경 메소드
     *
     * 설명:
     *   ArrayList를 대상으로 Collections의 정렬/순서 변경 메소드를 실습하세요.
     *
     * 요구사항:
     *   1. 아래 리스트 생성: [5, 3, 8, 1, 9, 2, 7, 4, 6]
     *   2. Collections.sort()로 오름차순 정렬 후 출력
     *   3. Collections.reverse()로 역순 변경 후 출력
     *   4. Collections.sort(list, Comparator.reverseOrder())로 내림차순 정렬
     *   5. Collections.shuffle()로 무작위 섞기 후 출력
     *   6. Collections.swap(list, 0, list.size()-1)로 첫/마지막 교환 후 출력
     *   7. 다시 정렬 후 Collections.rotate(list, 3)으로 3칸 오른쪽 회전 후 출력
     *      예: [1,2,3,4,5,6,7,8,9] -> rotate(3) -> [7,8,9,1,2,3,4,5,6]
     *
     * 예상 출력:
     *   원본: [5, 3, 8, 1, 9, 2, 7, 4, 6]
     *   sort 후: [1, 2, 3, 4, 5, 6, 7, 8, 9]
     *   reverse 후: [9, 8, 7, 6, 5, 4, 3, 2, 1]
     *   내림차순 sort 후: [9, 8, 7, 6, 5, 4, 3, 2, 1]
     *   shuffle 후: [랜덤 순서]
     *   swap(0, 8) 후: [마지막원소, ..., 첫번째원소]
     *   rotate(3) 후: [7, 8, 9, 1, 2, 3, 4, 5, 6]
     *
     * 힌트:
     *   - Collections.sort()는 void를 반환하며 원본 리스트를 직접 수정합니다.
     *   - rotate의 distance가 양수면 오른쪽으로 회전합니다.
     */
    static void problem1_sortReverseShuffleSwap() {
        System.out.println("=== 문제 1: sort, reverse, shuffle, swap, rotate ===");

        // TODO: ArrayList<Integer> 생성 및 초기화 (Arrays.asList 활용)

        // TODO: 원본 출력

        // TODO: Collections.sort() 후 출력

        // TODO: Collections.reverse() 후 출력

        // TODO: Collections.sort(list, Comparator.reverseOrder()) 후 출력

        // TODO: Collections.shuffle() 후 출력

        // TODO: Collections.swap(list, 0, list.size()-1) 후 출력

        // TODO: 다시 정렬 후 Collections.rotate(list, 3) 후 출력

        System.out.println();
    }

    // =====================================================
    // 문제 2: min, max, frequency, disjoint, binarySearch
    // =====================================================
    /*
     * 【문제 2】 Collections의 검색 및 통계 메소드
     *
     * 설명:
     *   컬렉션에서 통계 정보를 추출하는 다양한 메소드를 실습하세요.
     *
     * 요구사항:
     *   [min, max]
     *   1. 점수 리스트: [78, 92, 65, 88, 71, 95, 83, 67, 90, 75]
     *   2. Collections.min()으로 최솟값 출력
     *   3. Collections.max()으로 최댓값 출력
     *   4. Comparator로 절댓값 기준 min/max (음수 포함 리스트 활용)
     *
     *   [frequency]
     *   5. 리스트: ["apple", "banana", "apple", "cherry", "banana", "apple"]
     *   6. "apple"의 등장 횟수 출력
     *   7. "grape"의 등장 횟수 출력
     *
     *   [disjoint]
     *   8. list1 = [1, 2, 3, 4, 5], list2 = [6, 7, 8], list3 = [4, 5, 6]
     *   9. disjoint(list1, list2): 공통 원소 없음 -> true 확인
     *   10. disjoint(list1, list3): 공통 원소 있음 -> false 확인
     *
     *   [binarySearch]
     *   11. 정렬된 리스트에서 binarySearch로 특정 원소 인덱스 찾기
     *       (주의: binarySearch 전에 반드시 sort 필요)
     *
     * 예상 출력:
     *   최솟값: 65
     *   최댓값: 95
     *   "apple" 빈도: 3
     *   "grape" 빈도: 0
     *   list1, list2 공통 원소 없음: true
     *   list1, list3 공통 원소 없음: false
     *   정렬된 리스트에서 88의 인덱스: 5
     *
     * 힌트:
     *   - binarySearch는 정렬된 리스트에서만 올바르게 동작합니다.
     *   - frequency가 0을 반환하면 해당 원소가 없다는 의미입니다.
     */
    static void problem2_minMaxFrequencyDisjoint() {
        System.out.println("=== 문제 2: min, max, frequency, disjoint ===");

        // TODO: 점수 리스트 생성 (Arrays.asList 활용)

        // TODO: Collections.min()으로 최솟값 출력

        // TODO: Collections.max()으로 최댓값 출력

        // TODO: 과일 이름 리스트 생성

        // TODO: Collections.frequency()로 "apple" 빈도수 출력

        // TODO: "grape" 빈도수 출력

        // TODO: list1, list2, list3 생성

        // TODO: Collections.disjoint(list1, list2) 출력 (true 예상)

        // TODO: Collections.disjoint(list1, list3) 출력 (false 예상)

        // TODO: 점수 리스트 정렬 후 Collections.binarySearch()로 88 위치 출력

        System.out.println();
    }

    // =====================================================
    // 문제 3: unmodifiableList로 불변 컬렉션 만들기
    // =====================================================
    /*
     * 【문제 3】 Collections.unmodifiableXxx()로 읽기 전용 컬렉션 생성
     *
     * 설명:
     *   가변 컬렉션을 불변 뷰로 감싸는 방법과 그 한계를 확인하세요.
     *
     * 요구사항:
     *   1. 가변 ArrayList 생성: ["읽기", "쓰기", "실행"]
     *   2. Collections.unmodifiableList()로 읽기 전용 리스트 생성
     *   3. 읽기 전용 리스트에서 get(), size(), contains() 등 읽기 연산 테스트
     *   4. 읽기 전용 리스트에 add() 시도 -> UnsupportedOperationException 확인
     *      (try-catch로 예외 처리)
     *   5. 원본 가변 리스트에 "삭제" 추가 -> 불변 뷰에도 반영됨 확인
     *      (unmodifiable은 진정한 불변이 아님!)
     *   6. 동일하게 Map, Set도 unmodifiable로 감싸서 테스트
     *
     * 예상 출력:
     *   읽기 전용 리스트: [읽기, 쓰기, 실행]
     *   get(0): 읽기
     *   size(): 3
     *   contains("쓰기"): true
     *   add() 시도 -> UnsupportedOperationException 발생!
     *   원본에 "삭제" 추가 후 읽기 전용 뷰: [읽기, 쓰기, 실행, 삭제]
     *   (뷰에도 반영됨 - 진정한 불변이 아닙니다)
     *
     * 힌트:
     *   - unmodifiableList는 내부적으로 원본 리스트의 참조를 유지합니다.
     *   - 따라서 원본이 바뀌면 unmodifiable 뷰도 바뀝니다.
     *   - 진정한 불변이 필요하면 List.of()나 List.copyOf()를 사용하세요.
     */
    static void problem3_unmodifiableCollections() {
        System.out.println("=== 문제 3: unmodifiableList로 불변 컬렉션 ===");

        // TODO: 가변 ArrayList 생성 및 초기화

        // TODO: Collections.unmodifiableList()로 읽기 전용 뷰 생성

        // TODO: get(), size(), contains() 등 읽기 연산 테스트 및 출력

        // TODO: try-catch로 add() 시도 및 UnsupportedOperationException 출력

        // TODO: 원본 리스트에 "삭제" 추가

        // TODO: 읽기 전용 뷰 재출력 (원본 변경이 반영됨 확인)

        // TODO: HashMap 생성 -> unmodifiableMap으로 감싸기 -> put() 시도 예외 확인

        // TODO: HashSet 생성 -> unmodifiableSet으로 감싸기 -> add() 시도 예외 확인

        System.out.println();
    }

    // =====================================================
    // 문제 4: Java 9+ 불변 팩토리 메소드
    // =====================================================
    /*
     * 【문제 4】 List.of, Map.of, Set.of (Java 9+ 불변 팩토리)
     *
     * 설명:
     *   Java 9에서 도입된 불변 컬렉션 팩토리 메소드를 실습하고,
     *   Collections.unmodifiableXxx()와의 차이점을 이해하세요.
     *
     * 요구사항:
     *   [List.of]
     *   1. List.of("월", "화", "수", "목", "금")으로 불변 리스트 생성
     *   2. 읽기 연산(get, size, contains) 테스트
     *   3. add() 시도 -> UnsupportedOperationException 확인
     *   4. null 추가 시도 -> NullPointerException 확인
     *
     *   [Set.of]
     *   5. Set.of(1, 2, 3, 4, 5)로 불변 집합 생성
     *   6. contains() 테스트
     *   7. 중복 원소로 Set.of(1, 2, 2) 시도 -> IllegalArgumentException 확인
     *
     *   [Map.of]
     *   8. Map.of("name", "홍길동", "age", "30", "city", "서울")으로 불변 맵 생성
     *   9. get(), containsKey() 테스트
     *   10. put() 시도 -> UnsupportedOperationException 확인
     *
     *   [List.copyOf]
     *   11. 기존 ArrayList를 List.copyOf()로 불변 복사본 생성
     *   12. 원본을 수정해도 복사본에 반영 안 됨 확인 (unmodifiable과의 차이!)
     *
     * 예상 출력:
     *   [List.of] 요일: [월, 화, 수, 목, 금]
     *   get(2): 수
     *   size(): 5
     *   add() 시도 -> UnsupportedOperationException!
     *   null 추가 시도 -> NullPointerException!
     *   [Set.of] 집합: [1, 2, 3, 4, 5] (순서 무관)
     *   contains(3): true
     *   중복 Set.of(1,2,2) -> IllegalArgumentException!
     *   [Map.of] 맵: {name=홍길동, age=30, city=서울}
     *   get("name"): 홍길동
     *   put() 시도 -> UnsupportedOperationException!
     *   [List.copyOf] 원본 수정 후 복사본 변화 없음: [A, B, C]
     *
     * 힌트:
     *   - List.of()는 null을 허용하지 않습니다. (NPE 발생)
     *   - Set.of()는 중복 원소를 허용하지 않습니다. (IAE 발생)
     *   - List.copyOf()는 원본과 독립적인 완전한 복사본을 만듭니다.
     *   - unmodifiableList는 원본의 뷰, List.copyOf()는 독립적인 복사본입니다.
     */
    static void problem4_immutableFactoryMethods() {
        System.out.println("=== 문제 4: List.of, Map.of, Set.of (Java 9+) ===");

        // TODO: List.of()로 요일 불변 리스트 생성

        // TODO: get(), size(), contains() 테스트 및 출력

        // TODO: try-catch로 add() 시도 -> UnsupportedOperationException 출력

        // TODO: try-catch로 null 추가 시도 -> NullPointerException 출력

        // TODO: Set.of()로 불변 집합 생성 및 contains() 테스트

        // TODO: try-catch로 Set.of(1, 2, 2) -> IllegalArgumentException 출력

        // TODO: Map.of()로 불변 맵 생성 및 get(), containsKey() 테스트

        // TODO: try-catch로 put() 시도 -> UnsupportedOperationException 출력

        // TODO: ArrayList 생성 후 List.copyOf()로 불변 복사본 생성

        // TODO: 원본 ArrayList에 원소 추가 후 복사본 출력 (변화 없음 확인)

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 (시그니처만 작성)
    // =====================================================

    /**
     * 주어진 리스트에서 두 번째로 큰 원소를 반환합니다.
     * Collections 메소드를 활용하세요.
     * @param list 검색할 정수 리스트
     * @return 두 번째로 큰 원소
     */
    static int secondMax(List<Integer> list) {
        // TODO: sort 후 두 번째 큰 값 반환 (또는 max 제거 후 다시 max)
        return 0;
    }

    /**
     * 리스트의 모든 원소를 주어진 값으로 채운 후 반환합니다.
     * Collections.fill()을 사용하세요.
     * @param size 리스트 크기
     * @param value 채울 값
     * @return 주어진 값으로 채워진 리스트
     */
    static List<String> createFilledList(int size, String value) {
        // TODO: new ArrayList<>(Collections.nCopies(size, null)) 또는 fill() 활용
        return null;
    }

    /**
     * 불변 리스트를 가변 리스트로 변환하여 반환합니다.
     * (List.of()나 unmodifiableList를 수정 가능한 리스트로 변환할 때 사용)
     * @param immutableList 불변 리스트
     * @return 수정 가능한 새 ArrayList
     */
    static List<String> toMutableList(List<String> immutableList) {
        // TODO: new ArrayList<>(immutableList)로 변환
        return null;
    }

    // =====================================================
    // main 메소드
    // =====================================================
    public static void main(String[] args) {
        problem1_sortReverseShuffleSwap();
        problem2_minMaxFrequencyDisjoint();
        problem3_unmodifiableCollections();
        problem4_immutableFactoryMethods();
    }
}
