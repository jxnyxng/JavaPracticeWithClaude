/**
 * ============================================================
 * 학습 목표:
 *   1. ArrayList의 기본 메소드(add, get, set, remove, size, contains)를 활용한다.
 *   2. for, for-each, Iterator 세 가지 방식으로 ArrayList를 순회한다.
 *   3. Collections 유틸리티 클래스와 배열 변환 방법을 익힌다.
 *
 * 핵심 개념:
 *   - ArrayList: 동적 배열 기반의 List 구현체. 인덱스 접근이 O(1)이지만
 *     중간 삽입/삭제는 O(n)이다.
 *   - Collections 클래스: 정렬, 역순, 탐색 등 컬렉션 공통 유틸리티 제공.
 *   - Arrays.asList(): 배열을 고정 크기 List로 변환.
 *   - new ArrayList<>(Arrays.asList(...)): 배열을 가변 ArrayList로 변환.
 * ============================================================
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class P01_ArrayList {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: ArrayList 기본 조작 =====");
        problem1_basicOperations();

        System.out.println("\n===== 문제 2: ArrayList 순회 =====");
        problem2_traversal();

        System.out.println("\n===== 문제 3: 정렬과 역순 =====");
        problem3_sortAndReverse();

        System.out.println("\n===== 문제 4: 배열 <-> ArrayList 변환 =====");
        problem4_conversionWithArray();
    }

    // ============================================================
    // 문제 1: ArrayList 기본 조작
    // ------------------------------------------------------------
    // 설명:
    //   ArrayList를 생성하고, 요소 추가/조회/수정/삭제 메소드를 연습한다.
    //
    // 예상 출력:
    //   초기 리스트: [사과, 바나나, 체리, 딸기, 포도]
    //   2번 인덱스 요소: 체리
    //   set 후: [사과, 바나나, 망고, 딸기, 포도]
    //   remove(1) 후: [사과, 망고, 딸기, 포도]
    //   크기: 4
    //   딸기 포함 여부: true
    //   수박 포함 여부: false
    //
    // 힌트:
    //   - add(값): 끝에 추가
    //   - get(인덱스): 요소 조회
    //   - set(인덱스, 값): 요소 수정
    //   - remove(인덱스): 인덱스로 삭제
    //   - size(): 크기 반환
    //   - contains(값): 포함 여부 확인
    // ============================================================
    static void problem1_basicOperations() {
        // TODO: ArrayList<String> 생성 후 "사과", "바나나", "체리", "딸기", "포도" 추가
        // TODO: 초기 리스트 출력
        // TODO: 인덱스 2의 요소 출력
        // TODO: 인덱스 2의 요소를 "망고"로 수정 후 출력
        // TODO: 인덱스 1의 요소 삭제 후 출력
        // TODO: 크기 출력
        // TODO: "딸기" 포함 여부 출력
        // TODO: "수박" 포함 여부 출력
    }

    // ============================================================
    // 문제 2: ArrayList 순회
    // ------------------------------------------------------------
    // 설명:
    //   동일한 ArrayList를 세 가지 방법으로 순회하며 모든 요소를 출력한다.
    //   각 방법의 출력 전에 방법 이름을 먼저 출력한다.
    //
    // 예상 출력:
    //   [일반 for 순회]
    //   0: 빨강
    //   1: 주황
    //   2: 노랑
    //   3: 초록
    //   4: 파랑
    //   [for-each 순회]
    //   빨강
    //   주황
    //   ...
    //   [Iterator 순회]
    //   빨강
    //   주황
    //   ...
    //
    // 힌트:
    //   - for (int i = 0; i < list.size(); i++): 일반 for
    //   - for (String item : list): for-each
    //   - list.iterator() 로 Iterator 획득, hasNext()/next() 사용
    // ============================================================
    static void problem2_traversal() {
        ArrayList<String> colors = new ArrayList<>(
                Arrays.asList("빨강", "주황", "노랑", "초록", "파랑"));

        // TODO: 일반 for로 인덱스와 함께 출력
        System.out.println("[일반 for 순회]");
        // TODO: 여기에 코드 작성

        // TODO: for-each로 출력
        System.out.println("[for-each 순회]");
        // TODO: 여기에 코드 작성

        // TODO: Iterator로 출력
        System.out.println("[Iterator 순회]");
        // TODO: 여기에 코드 작성
    }

    // ============================================================
    // 문제 3: 정렬과 역순
    // ------------------------------------------------------------
    // 설명:
    //   정수 ArrayList를 오름차순으로 정렬한 뒤, 다시 내림차순으로 뒤집는다.
    //
    // 예상 출력:
    //   원본: [5, 3, 8, 1, 9, 2, 7]
    //   오름차순 정렬: [1, 2, 3, 5, 7, 8, 9]
    //   내림차순(역순): [9, 8, 7, 5, 3, 2, 1]
    //
    // 힌트:
    //   - Collections.sort(list): 자연 순서(오름차순) 정렬
    //   - Collections.reverse(list): 리스트를 뒤집음
    // ============================================================
    static void problem3_sortAndReverse() {
        ArrayList<Integer> numbers = new ArrayList<>(
                Arrays.asList(5, 3, 8, 1, 9, 2, 7));

        System.out.println("원본: " + numbers);
        // TODO: Collections.sort()로 오름차순 정렬 후 출력
        // TODO: Collections.reverse()로 역순 후 출력
    }

    // ============================================================
    // 문제 4: 배열 <-> ArrayList 변환
    // ------------------------------------------------------------
    // 설명:
    //   String 배열을 ArrayList로 변환하고, ArrayList를 다시 배열로 변환한다.
    //   변환 결과를 각각 출력한다.
    //
    // 예상 출력:
    //   원본 배열: [봄, 여름, 가을, 겨울]
    //   ArrayList로 변환: [봄, 여름, 가을, 겨울]
    //   요소 추가 후 ArrayList: [봄, 여름, 가을, 겨울, 장마]
    //   다시 배열로 변환: [봄, 여름, 가을, 겨울, 장마]
    //
    // 힌트:
    //   - new ArrayList<>(Arrays.asList(배열)): 배열 -> ArrayList
    //   - list.toArray(new String[0]): ArrayList -> 배열
    //   - Arrays.toString(배열): 배열 출력
    // ============================================================
    static void problem4_conversionWithArray() {
        String[] seasons = {"봄", "여름", "가을", "겨울"};

        System.out.println("원본 배열: " + Arrays.toString(seasons));
        // TODO: 배열을 ArrayList로 변환 후 출력
        // TODO: ArrayList에 "장마" 추가 후 출력
        // TODO: ArrayList를 배열로 변환 후 출력
    }

    // ============================================================
    // 헬퍼 메소드 시그니처
    // ============================================================

    /** 리스트의 모든 짝수 인덱스 요소를 반환한다. */
    static ArrayList<String> getEvenIndexElements(ArrayList<String> list) {
        // TODO: 구현
        return null;
    }

    /** 리스트에서 중복 요소를 제거한 새 ArrayList를 반환한다. */
    static ArrayList<Integer> removeDuplicates(ArrayList<Integer> list) {
        // TODO: 구현
        return null;
    }
}
