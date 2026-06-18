/*
 * =====================================================
 * 파일명: P07_LinkedHashMap.java
 * 주제: LinkedHashMap과 TreeMap - 순서가 있는 Map 구현체
 * =====================================================
 *
 * 【학습 목표】
 * 1. LinkedHashMap이 삽입 순서를 유지하는 원리를 이해하고 활용할 수 있다.
 * 2. TreeMap이 키를 자동 정렬하는 원리를 이해하고 활용할 수 있다.
 * 3. TreeMap의 범위 조회 메소드(headMap, tailMap, subMap 등)를 활용할 수 있다.
 *
 * 【핵심 개념】
 * - LinkedHashMap:
 *   · HashMap을 상속하며, 내부적으로 이중 연결 리스트를 추가로 유지
 *   · 삽입 순서(insertion order) 또는 접근 순서(access order)를 보장
 *   · 생성자: new LinkedHashMap<>(initialCapacity, loadFactor, accessOrder)
 *     - accessOrder = true이면 가장 최근 접근한 항목이 뒤로 이동 (LRU 캐시 구현에 활용)
 *   · 일반 HashMap보다 약간 더 많은 메모리 사용
 *
 * - TreeMap:
 *   · NavigableMap 인터페이스 구현, 내부적으로 Red-Black Tree 사용
 *   · 키가 자연 순서(Comparable) 또는 지정한 Comparator 순서로 자동 정렬
 *   · 검색/삽입/삭제 시간복잡도: O(log n) (HashMap의 O(1)보다 느림)
 *   · 범위 검색, 정렬된 순회가 필요할 때 유용
 *
 * - TreeMap 주요 탐색 메소드:
 *   · firstKey() / lastKey()         : 가장 작은/큰 키 반환
 *   · floorKey(k) / ceilingKey(k)    : k 이하/이상인 가장 가까운 키
 *   · lowerKey(k) / higherKey(k)     : k 미만/초과인 가장 가까운 키
 *   · headMap(toKey)                 : toKey 미만인 부분 맵 반환
 *   · tailMap(fromKey)               : fromKey 이상인 부분 맵 반환
 *   · subMap(fromKey, toKey)         : [fromKey, toKey) 범위 부분 맵 반환
 */

import java.util.*;

public class P07_LinkedHashMap {

    // =====================================================
    // 문제 1: LinkedHashMap으로 삽입 순서 유지 확인
    // =====================================================
    /*
     * 【문제 1】 LinkedHashMap vs HashMap 순서 비교
     *
     * 설명:
     *   같은 데이터를 HashMap과 LinkedHashMap에 각각 저장하고,
     *   출력 순서의 차이를 직접 확인하세요.
     *
     * 데이터 (삽입 순서):
     *   "바나나" -> 3, "사과" -> 1, "딸기" -> 5, "포도" -> 2, "망고" -> 4
     *
     * 요구사항:
     *   1. HashMap에 위 순서대로 데이터를 삽입 후 전체 출력
     *   2. LinkedHashMap에 같은 순서로 삽입 후 전체 출력
     *   3. 두 결과를 비교하는 메시지 출력
     *   4. LinkedHashMap에서 "딸기" 삭제 후 재출력 (순서 유지 확인)
     *
     * 예상 출력:
     *   [HashMap] 출력 순서 (랜덤):
     *   사과=1, 포도=2, 바나나=3, ... (순서 불규칙)
     *   [LinkedHashMap] 출력 순서 (삽입 순서 유지):
     *   바나나=3, 사과=1, 딸기=5, 포도=2, 망고=4
     *   삽입 순서 유지: true
     *   딸기 삭제 후: 바나나=3, 사과=1, 포도=2, 망고=4
     *
     * 힌트:
     *   - LinkedHashMap은 HashMap과 동일한 방법으로 생성/사용합니다.
     *   - entrySet()으로 순회하면 순서 차이를 명확히 볼 수 있습니다.
     */
    static void problem1_linkedHashMapOrder() {
        System.out.println("=== 문제 1: LinkedHashMap 삽입 순서 유지 ===");

        // TODO: HashMap<String, Integer> 생성 및 데이터 삽입

        // TODO: LinkedHashMap<String, Integer> 생성 및 동일 데이터 삽입

        // TODO: HashMap 전체 출력

        // TODO: LinkedHashMap 전체 출력

        // TODO: 두 결과 비교 메시지 출력

        // TODO: LinkedHashMap에서 "딸기" 삭제 후 재출력

        System.out.println();
    }

    // =====================================================
    // 문제 2: TreeMap으로 키 자동 정렬
    // =====================================================
    /*
     * 【문제 2】 TreeMap의 자동 정렬 활용
     *
     * 설명:
     *   TreeMap을 사용하여 데이터가 자동으로 정렬되는 특성을 확인하고,
     *   역순 정렬도 구현해보세요.
     *
     * 데이터:
     *   점수표: "Charlie"->85, "Alice"->92, "Eve"->78, "Bob"->95, "Diana"->88
     *
     * 요구사항:
     *   1. TreeMap에 데이터 삽입 후 전체 출력 (알파벳 오름차순 정렬됨)
     *   2. Collections.reverseOrder()를 Comparator로 전달하여 역순 TreeMap 생성
     *   3. 역순 TreeMap에 같은 데이터 삽입 후 출력 (알파벳 내림차순)
     *   4. 정렬된 TreeMap에서 firstKey()와 lastKey() 출력
     *
     * 예상 출력:
     *   [TreeMap] 알파벳 오름차순:
     *   Alice=92, Bob=95, Charlie=85, Diana=88, Eve=78
     *   [역순 TreeMap] 알파벳 내림차순:
     *   Eve=78, Diana=88, Charlie=85, Bob=95, Alice=92
     *   첫 번째 키: Alice
     *   마지막 키: Eve
     *
     * 힌트:
     *   - new TreeMap<>(Collections.reverseOrder())로 역순 TreeMap을 생성합니다.
     *   - TreeMap은 Comparable을 구현한 키(String, Integer 등)를 자동 정렬합니다.
     */
    static void problem2_treemapSorting() {
        System.out.println("=== 문제 2: TreeMap 자동 정렬 ===");

        // TODO: TreeMap<String, Integer> 생성 및 데이터 삽입

        // TODO: TreeMap 전체 출력 (알파벳 오름차순)

        // TODO: Collections.reverseOrder()로 역순 TreeMap 생성 및 동일 데이터 삽입

        // TODO: 역순 TreeMap 전체 출력

        // TODO: 오름차순 TreeMap의 firstKey()와 lastKey() 출력

        System.out.println();
    }

    // =====================================================
    // 문제 3: TreeMap 범위 조회 메소드
    // =====================================================
    /*
     * 【문제 3】 TreeMap의 firstKey, lastKey, headMap, tailMap, subMap
     *
     * 설명:
     *   성적 관리 시스템을 TreeMap으로 구현하고,
     *   다양한 범위 조회 메소드를 활용하세요.
     *
     * 데이터 (점수 -> 등급):
     *   60->"D", 70->"C", 75->"C+", 80->"B", 85->"B+", 90->"A", 95->"A+", 100->"A+"
     *
     * 요구사항:
     *   1. 전체 데이터 출력
     *   2. firstKey()로 최저 점수, lastKey()로 최고 점수 출력
     *   3. headMap(80)으로 80점 미만인 점수들만 출력
     *   4. tailMap(85)으로 85점 이상인 점수들만 출력
     *   5. subMap(70, 90)으로 [70, 90) 범위 점수들 출력
     *   6. floorKey(82)로 82 이하인 가장 가까운 키 출력
     *   7. ceilingKey(82)로 82 이상인 가장 가까운 키 출력
     *
     * 예상 출력:
     *   전체 성적 맵: {60=D, 70=C, 75=C+, 80=B, 85=B+, 90=A, 95=A+, 100=A+}
     *   최저 점수: 60 (D)
     *   최고 점수: 100 (A+)
     *   80 미만 (headMap): {60=D, 70=C, 75=C+}
     *   85 이상 (tailMap): {85=B+, 90=A, 95=A+, 100=A+}
     *   70~89 (subMap): {70=C, 75=C+, 80=B, 85=B+}
     *   82 이하 최근접: 80
     *   82 이상 최근접: 85
     *
     * 힌트:
     *   - headMap(toKey): toKey 미만 (exclusive)
     *   - tailMap(fromKey): fromKey 이상 (inclusive)
     *   - subMap(from, to): from 이상, to 미만 [from, to)
     *   - headMap(toKey, true)처럼 두 번째 인자로 경계 포함 여부 지정 가능
     */
    static void problem3_treemapRangeQuery() {
        System.out.println("=== 문제 3: TreeMap 범위 조회 ===");

        // TODO: TreeMap<Integer, String> 생성 및 점수-등급 데이터 삽입

        // TODO: 전체 데이터 출력

        // TODO: firstKey()로 최저 점수와 등급 출력

        // TODO: lastKey()로 최고 점수와 등급 출력

        // TODO: headMap(80)으로 80 미만 점수들 출력

        // TODO: tailMap(85)으로 85 이상 점수들 출력

        // TODO: subMap(70, 90)으로 [70, 90) 범위 출력

        // TODO: floorKey(82) 출력

        // TODO: ceilingKey(82) 출력

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 (시그니처만 작성)
    // =====================================================

    /**
     * LinkedHashMap을 이용해 LRU(최근 미사용) 캐시를 구현합니다.
     * 캐시 용량이 초과되면 가장 오래 전에 접근한 항목을 제거합니다.
     * @param capacity 캐시 최대 용량
     * @return LRU 캐시로 동작하는 LinkedHashMap
     */
    static LinkedHashMap<Integer, String> createLRUCache(int capacity) {
        // TODO: accessOrder=true로 LinkedHashMap 생성, removeEldestEntry 오버라이드
        return null;
    }

    /**
     * TreeMap에서 주어진 값(value)을 가진 모든 키를 반환합니다.
     * @param map 검색할 TreeMap
     * @param targetValue 찾을 값
     * @return 해당 값을 가진 키들의 리스트
     */
    static List<Integer> findKeysByValue(TreeMap<Integer, String> map, String targetValue) {
        // TODO: 구현
        return null;
    }

    // =====================================================
    // main 메소드
    // =====================================================
    public static void main(String[] args) {
        problem1_linkedHashMapOrder();
        problem2_treemapSorting();
        problem3_treemapRangeQuery();
    }
}
