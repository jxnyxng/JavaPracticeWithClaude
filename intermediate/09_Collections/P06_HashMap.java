/*
 * =====================================================
 * 파일명: P06_HashMap.java
 * 주제: HashMap - 키-값 쌍으로 데이터를 저장하는 자료구조
 * =====================================================
 *
 * 【학습 목표】
 * 1. HashMap의 기본 동작 원리(해시 함수, 버킷)를 이해하고 CRUD 연산을 구현할 수 있다.
 * 2. keySet, values, entrySet을 활용하여 HashMap을 다양한 방식으로 순회할 수 있다.
 * 3. getOrDefault, putIfAbsent, computeIfAbsent 등 편의 메소드를 활용할 수 있다.
 *
 * 【핵심 개념】
 * - HashMap: 키(Key)와 값(Value)을 쌍으로 저장하는 자료구조
 *   · 키는 중복 불가, 값은 중복 허용
 *   · null 키 1개 허용, null 값 여러 개 허용
 *   · 저장 순서를 보장하지 않음 (순서가 필요하면 LinkedHashMap 사용)
 *   · 평균 O(1) 시간복잡도로 검색, 삽입, 삭제 가능
 *
 * - 주요 메소드:
 *   · put(K key, V value)       : 키-값 쌍 추가 (기존 키면 값 덮어씀)
 *   · get(Object key)           : 키에 해당하는 값 반환 (없으면 null)
 *   · containsKey(Object key)   : 키 존재 여부 확인
 *   · containsValue(Object val) : 값 존재 여부 확인
 *   · remove(Object key)        : 키-값 쌍 삭제
 *   · size()                    : 저장된 쌍의 개수 반환
 *   · keySet()                  : 모든 키를 Set으로 반환
 *   · values()                  : 모든 값을 Collection으로 반환
 *   · entrySet()                : 모든 키-값 쌍을 Set<Entry>로 반환
 *   · getOrDefault(key, default): 키가 없으면 기본값 반환
 *   · putIfAbsent(key, value)   : 키가 없을 때만 추가
 *   · computeIfAbsent(key, fn)  : 키가 없을 때 함수로 값 생성 후 추가
 */

import java.util.*;

public class P06_HashMap {

    // =====================================================
    // 문제 1: HashMap 기본 CRUD 연산
    // =====================================================
    /*
     * 【문제 1】 HashMap 기본 연산 실습
     *
     * 설명:
     *   학생 이름(String)과 점수(Integer)를 저장하는 HashMap을 생성하고
     *   기본 CRUD 연산을 수행하세요.
     *
     * 요구사항:
     *   1. HashMap 생성 후 아래 데이터를 추가하세요.
     *      - "Alice" -> 85, "Bob" -> 92, "Charlie" -> 78, "Diana" -> 95, "Eve" -> 88
     *   2. "Bob"의 점수를 출력하세요.
     *   3. "Frank"라는 키가 있는지 확인하세요.
     *   4. 점수 92가 존재하는지 확인하세요.
     *   5. "Charlie"를 삭제하고 크기를 출력하세요.
     *   6. "Alice"의 점수를 90으로 업데이트하세요.
     *
     * 예상 출력:
     *   Bob의 점수: 92
     *   Frank 키 존재: false
     *   점수 92 존재: true
     *   Charlie 삭제 후 크기: 4
     *   Alice 업데이트 후 점수: 90
     *
     * 힌트:
     *   - put()으로 추가할 때 이미 존재하는 키면 값이 덮어써집니다.
     *   - containsKey()와 containsValue()의 차이를 구분하세요.
     */
    static void problem1_basicCRUD() {
        System.out.println("=== 문제 1: HashMap 기본 CRUD 연산 ===");

        // TODO: HashMap<String, Integer> 생성

        // TODO: 5명의 학생 데이터 put()으로 추가

        // TODO: "Bob"의 점수 get()으로 출력

        // TODO: containsKey()로 "Frank" 존재 여부 확인 및 출력

        // TODO: containsValue()로 점수 92 존재 여부 확인 및 출력

        // TODO: remove()로 "Charlie" 삭제, size() 출력

        // TODO: put()으로 "Alice" 점수 90으로 업데이트, 출력

        System.out.println();
    }

    // =====================================================
    // 문제 2: HashMap 순회 방법 3가지
    // =====================================================
    /*
     * 【문제 2】 keySet, values, entrySet으로 순회
     *
     * 설명:
     *   아래 국가-수도 데이터를 HashMap에 저장하고,
     *   3가지 방법으로 순회하여 출력하세요.
     *
     * 데이터:
     *   "한국" -> "서울", "일본" -> "도쿄", "중국" -> "베이징",
     *   "미국" -> "워싱턴D.C.", "프랑스" -> "파리"
     *
     * 요구사항:
     *   1. keySet()으로 모든 키(국가명)만 출력
     *   2. values()로 모든 값(수도)만 출력
     *   3. entrySet()으로 "국가: 수도" 형식으로 출력
     *   4. entrySet()을 활용한 향상된 for문과 Iterator 각각 사용
     *
     * 예상 출력:
     *   [keySet 순회] 국가 목록:
     *   한국 일본 중국 미국 프랑스 (순서 무관)
     *   [values 순회] 수도 목록:
     *   서울 도쿄 베이징 워싱턴D.C. 파리 (순서 무관)
     *   [entrySet 순회] 국가-수도 목록:
     *   한국: 서울
     *   일본: 도쿄
     *   ... (순서 무관)
     *
     * 힌트:
     *   - Map.Entry<K, V> 타입으로 entrySet의 각 원소를 받습니다.
     *   - entry.getKey(), entry.getValue()로 키와 값을 각각 가져옵니다.
     */
    static void problem2_traversal() {
        System.out.println("=== 문제 2: HashMap 순회 방법 ===");

        // TODO: HashMap<String, String> 생성 및 국가-수도 데이터 추가

        // TODO: keySet()으로 모든 국가명 출력

        // TODO: values()로 모든 수도 출력

        // TODO: entrySet() + 향상된 for문으로 "국가: 수도" 출력

        // TODO: entrySet() + Iterator로 동일하게 출력 (보너스)

        System.out.println();
    }

    // =====================================================
    // 문제 3: 단어 빈도수 세기
    // =====================================================
    /*
     * 【문제 3】 문장에서 각 단어의 등장 횟수 세기
     *
     * 설명:
     *   주어진 문장을 단어 단위로 분리하여, 각 단어가 몇 번 등장하는지
     *   HashMap을 활용해 세어 출력하세요.
     *
     * 입력 문장:
     *   "apple banana apple cherry banana apple cherry cherry grape"
     *
     * 요구사항:
     *   1. 문장을 공백(" ")으로 split하여 단어 배열 생성
     *   2. 각 단어를 키로, 등장 횟수를 값으로 저장
     *   3. 단어별 빈도수 출력
     *   4. 가장 많이 등장한 단어를 찾아 출력
     *
     * 예상 출력:
     *   단어 빈도수:
     *   apple: 3
     *   banana: 2
     *   cherry: 3
     *   grape: 1
     *   가장 많이 등장한 단어: apple (또는 cherry) - 3회
     *
     * 힌트:
     *   - getOrDefault(word, 0) + 1 패턴으로 빈도수를 쉽게 증가시킬 수 있습니다.
     *   - 최대 빈도수를 구하려면 values()를 순회하며 최댓값을 찾으세요.
     */
    static void problem3_wordFrequency() {
        System.out.println("=== 문제 3: 단어 빈도수 세기 ===");
        String sentence = "apple banana apple cherry banana apple cherry cherry grape";

        // TODO: 문장을 공백으로 split하여 단어 배열 생성

        // TODO: HashMap<String, Integer> 생성

        // TODO: 반복문으로 단어 순회하며 빈도수 증가 (getOrDefault 활용)

        // TODO: 단어별 빈도수 출력

        // TODO: 가장 많이 등장한 단어와 빈도수 출력

        System.out.println();
    }

    // =====================================================
    // 문제 4: 편의 메소드 활용
    // =====================================================
    /*
     * 【문제 4】 getOrDefault, putIfAbsent, computeIfAbsent 활용
     *
     * 설명:
     *   Java 8에서 추가된 HashMap 편의 메소드들을 실습합니다.
     *   각 메소드의 동작 차이를 직접 확인하세요.
     *
     * 요구사항:
     *   [getOrDefault]
     *   1. 상품-가격 HashMap에 "노트북"->1200000, "마우스"->35000 추가
     *   2. "키보드" 가격을 getOrDefault로 조회 (기본값: -1)
     *   3. "노트북" 가격을 getOrDefault로 조회
     *
     *   [putIfAbsent]
     *   4. "마우스"->50000으로 putIfAbsent 시도 (기존 값 유지됨)
     *   5. "키보드"->75000으로 putIfAbsent 시도 (새로 추가됨)
     *   6. 결과 출력
     *
     *   [computeIfAbsent]
     *   7. 학생-과목목록 HashMap<String, List<String>> 생성
     *   8. computeIfAbsent로 "Alice"의 과목 목록이 없으면 새 ArrayList 생성 후 "수학" 추가
     *   9. 동일하게 "Alice"에 "영어" 추가, "Bob"에 "과학" 추가
     *   10. 결과 출력
     *
     * 예상 출력:
     *   키보드 가격 (기본값): -1
     *   노트북 가격: 1200000
     *   마우스 putIfAbsent 후: 35000 (변경 없음)
     *   키보드 putIfAbsent 후: 75000 (새로 추가)
     *   Alice의 과목: [수학, 영어]
     *   Bob의 과목: [과학]
     *
     * 힌트:
     *   - putIfAbsent는 키가 이미 존재하면 기존 값을 반환하고 변경하지 않습니다.
     *   - computeIfAbsent(key, k -> new ArrayList<>())처럼 람다로 기본값 생성 함수를 전달합니다.
     */
    static void problem4_convenienceMethods() {
        System.out.println("=== 문제 4: getOrDefault, putIfAbsent, computeIfAbsent ===");

        // TODO: 상품-가격 HashMap 생성 및 초기 데이터 추가

        // TODO: getOrDefault로 "키보드"(없는 키) 조회, 기본값 -1 출력

        // TODO: getOrDefault로 "노트북"(있는 키) 조회 출력

        // TODO: putIfAbsent로 "마우스"->50000 시도 후 결과 출력

        // TODO: putIfAbsent로 "키보드"->75000 시도 후 결과 출력

        // TODO: HashMap<String, List<String>> 생성

        // TODO: computeIfAbsent로 "Alice" 키 없으면 ArrayList 생성, "수학" 추가

        // TODO: 동일하게 "Alice"에 "영어", "Bob"에 "과학" 추가

        // TODO: 각 학생 과목 목록 출력

        System.out.println();
    }

    // =====================================================
    // 헬퍼 메소드 (시그니처만 작성)
    // =====================================================

    /**
     * 주어진 HashMap에서 값이 최대인 키를 반환합니다.
     * @param map 검색할 HashMap
     * @return 최대 값을 가진 키
     */
    static String findMaxKey(HashMap<String, Integer> map) {
        // TODO: 구현
        return null;
    }

    /**
     * 두 HashMap을 합쳐서 새로운 HashMap을 반환합니다.
     * 키가 중복될 경우 두 번째 맵의 값을 사용합니다.
     * @param map1 첫 번째 맵
     * @param map2 두 번째 맵
     * @return 합쳐진 새 HashMap
     */
    static HashMap<String, Integer> mergeMaps(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        // TODO: 구현
        return null;
    }

    // =====================================================
    // main 메소드
    // =====================================================
    public static void main(String[] args) {
        problem1_basicCRUD();
        problem2_traversal();
        problem3_wordFrequency();
        problem4_convenienceMethods();
    }
}
