/**
 * ============================================================
 * 학습 목표:
 *   1. LinkedList의 앞/뒤 삽입·삭제 메소드를 사용한다.
 *   2. ArrayList와 LinkedList의 성능 특성 차이를 이해한다.
 *   3. LinkedList를 Deque(양방향 큐)로 활용한다.
 *
 * 핵심 개념:
 *   - LinkedList: 이중 연결 리스트 기반 구현체.
 *     앞/뒤 삽입·삭제가 O(1)이지만, 인덱스 접근은 O(n)이다.
 *   - ArrayList vs LinkedList:
 *       * 랜덤 접근(get): ArrayList O(1) vs LinkedList O(n)
 *       * 앞/중간 삽입: ArrayList O(n) vs LinkedList O(1) (노드 참조 있을 때)
 *       * 메모리: ArrayList가 더 효율적 (포인터 오버헤드 없음)
 *   - Deque: 양방향에서 삽입/삭제가 가능한 자료구조 (Double-Ended Queue).
 * ============================================================
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class P02_LinkedList {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: LinkedList 기본 조작 =====");
        problem1_basicOperations();

        System.out.println("\n===== 문제 2: ArrayList vs LinkedList 비교 =====");
        problem2_comparisonWithArrayList();

        System.out.println("\n===== 문제 3: LinkedList를 Deque로 사용 =====");
        problem3_useAsDeque();
    }

    // ============================================================
    // 문제 1: LinkedList 기본 조작
    // ------------------------------------------------------------
    // 설명:
    //   LinkedList를 생성하고 앞/뒤 삽입·삭제를 수행한다.
    //   각 연산 후 리스트 상태를 출력한다.
    //
    // 예상 출력:
    //   초기 리스트: [B, C, D]
    //   addFirst("A") 후: [A, B, C, D]
    //   addLast("E") 후: [A, B, C, D, E]
    //   removeFirst() 결과: A | 리스트: [B, C, D, E]
    //   removeLast() 결과: E | 리스트: [B, C, D]
    //   peekFirst(): B
    //   peekLast(): D
    //
    // 힌트:
    //   - addFirst(값): 앞에 추가
    //   - addLast(값): 뒤에 추가
    //   - removeFirst(): 앞 요소 제거 후 반환
    //   - removeLast(): 뒤 요소 제거 후 반환
    //   - peekFirst(): 앞 요소 조회 (제거 안 함)
    //   - peekLast(): 뒤 요소 조회 (제거 안 함)
    // ============================================================
    static void problem1_basicOperations() {
        LinkedList<String> list = new LinkedList<>();
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("초기 리스트: " + list);
        // TODO: addFirst("A") 수행 후 출력
        // TODO: addLast("E") 수행 후 출력
        // TODO: removeFirst() 수행, 반환값과 리스트 출력
        // TODO: removeLast() 수행, 반환값과 리스트 출력
        // TODO: peekFirst() 출력
        // TODO: peekLast() 출력
    }

    // ============================================================
    // 문제 2: ArrayList vs LinkedList 특성 비교
    // ------------------------------------------------------------
    // 설명:
    //   각각 10,000개의 요소를 가진 ArrayList와 LinkedList를 만들고,
    //   '맨 앞에 삽입' 연산 1,000번의 소요 시간을 측정·비교한다.
    //   결과 아래에 왜 차이가 나는지 주석으로 설명한다.
    //
    // 예상 출력 (예시, 실행 환경마다 다름):
    //   ArrayList 앞 삽입 1000회: XX ms
    //   LinkedList 앞 삽입 1000회: X ms
    //   -- LinkedList가 앞 삽입에 더 빠른 이유: (주석 참조)
    //
    // 힌트:
    //   - System.currentTimeMillis()로 시작/종료 시간 측정
    //   - ArrayList.add(0, 값): 맨 앞에 삽입 -> 기존 요소 전체 이동 필요
    //   - LinkedList.addFirst(값): 헤드 포인터만 변경하면 됨
    //
    // ArrayList가 느린 이유 (주석):
    //   배열 기반이므로 인덱스 0에 삽입 시 기존 모든 요소를 한 칸씩 뒤로
    //   이동시켜야 한다. 즉 O(n) 복잡도가 발생한다.
    //
    // LinkedList가 빠른 이유 (주석):
    //   노드의 포인터만 교체하면 되므로 O(1) 복잡도로 처리된다.
    // ============================================================
    static void problem2_comparisonWithArrayList() {
        int initialSize = 10_000;
        int insertCount = 1_000;

        // 초기 데이터 채우기
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < initialSize; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // TODO: ArrayList 맨 앞 삽입 insertCount회 수행 및 시간 측정
        // TODO: LinkedList 맨 앞 삽입 insertCount회 수행 및 시간 측정
        // TODO: 두 결과 출력 및 비교 메시지 출력
    }

    // ============================================================
    // 문제 3: LinkedList를 Deque로 사용
    // ------------------------------------------------------------
    // 설명:
    //   LinkedList를 Deque 인터페이스로 참조하여 양방향 큐를 구현한다.
    //   앞/뒤 모두에서 삽입과 삭제를 수행하고 결과를 출력한다.
    //
    // 예상 출력:
    //   요소 추가 후 덱: [앞2, 앞1, 중간, 뒤1, 뒤2]
    //   앞에서 꺼내기: 앞2 | 남은 덱: [앞1, 중간, 뒤1, 뒤2]
    //   뒤에서 꺼내기: 뒤2 | 남은 덱: [앞1, 중간, 뒤1]
    //   앞 확인(제거 안 함): 앞1
    //   뒤 확인(제거 안 함): 뒤1
    //
    // 힌트:
    //   - Deque<String> deque = new LinkedList<>()
    //   - offerFirst(값): 앞에 추가
    //   - offerLast(값): 뒤에 추가
    //   - pollFirst(): 앞에서 제거 후 반환
    //   - pollLast(): 뒤에서 제거 후 반환
    //   - peekFirst(): 앞 확인
    //   - peekLast(): 뒤 확인
    // ============================================================
    static void problem3_useAsDeque() {
        // TODO: Deque<String> 타입으로 LinkedList 생성
        // TODO: offerFirst로 "앞1", "앞2" 추가 (순서 주의)
        // TODO: offerLast로 "뒤1", "뒤2" 추가
        // TODO: 중간에 "중간" 추가 (offerFirst 후 offerLast 순으로 추가하여 순서 맞추기)
        // TODO: 전체 덱 출력
        // TODO: pollFirst() 수행 후 결과와 남은 덱 출력
        // TODO: pollLast() 수행 후 결과와 남은 덱 출력
        // TODO: peekFirst(), peekLast() 출력
    }

    // ============================================================
    // 헬퍼 메소드 시그니처
    // ============================================================

    /** LinkedList를 스택처럼 사용하여 요소를 역순으로 담은 새 LinkedList를 반환한다. */
    static LinkedList<String> reverseWithStack(LinkedList<String> list) {
        // TODO: 구현
        return null;
    }

    /** 두 LinkedList를 교대로 병합한 새 LinkedList를 반환한다. */
    static LinkedList<Integer> mergeTwoLists(LinkedList<Integer> a, LinkedList<Integer> b) {
        // TODO: 구현
        return null;
    }
}
