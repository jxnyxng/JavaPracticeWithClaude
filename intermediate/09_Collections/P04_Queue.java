/**
 * ============================================================
 * 학습 목표:
 *   1. ArrayDeque를 Queue로 사용하여 FIFO 동작을 구현한다.
 *   2. 실생활 예제(은행 대기열)를 통해 Queue의 활용법을 익힌다.
 *   3. Deque를 양방향으로 활용하는 방법을 습득한다.
 *
 * 핵심 개념:
 *   - Queue: FIFO(First-In-First-Out) 구조. 먼저 들어온 데이터가 먼저 나간다.
 *   - ArrayDeque: 배열 기반의 Deque 구현체. Queue와 Stack 모두에 활용 가능.
 *     (LinkedList보다 메모리 효율이 좋아 실무에서 권장)
 *   - offer(값): 큐 끝에 추가. 실패 시 false 반환 (add는 예외 던짐).
 *   - poll(): 큐 앞에서 제거 후 반환. 비어 있으면 null (remove는 예외 던짐).
 *   - peek(): 큐 앞 요소 조회. 비어 있으면 null.
 *   - Deque: 양쪽 끝에서 삽입/삭제 가능한 자료구조.
 * ============================================================
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class P04_Queue {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: ArrayDeque로 Queue 구현 =====");
        problem1_basicQueueOperations();

        System.out.println("\n===== 문제 2: 은행 대기열 시뮬레이션 =====");
        problem2_bankQueueSimulation();

        System.out.println("\n===== 문제 3: Deque 양방향 처리 =====");
        problem3_dequeOperations();
    }

    // ============================================================
    // 문제 1: ArrayDeque로 Queue 구현
    // ------------------------------------------------------------
    // 설명:
    //   ArrayDeque를 Queue 인터페이스로 참조하여 기본 Queue 동작을 수행한다.
    //
    // 예상 출력:
    //   offer 후 큐: [작업1, 작업2, 작업3, 작업4, 작업5]
    //   peek(): 작업1
    //   poll(): 작업1 | 남은 큐: [작업2, 작업3, 작업4, 작업5]
    //   poll(): 작업2 | 남은 큐: [작업3, 작업4, 작업5]
    //   큐 비어 있나요? false
    //   큐 크기: 3
    //
    // 힌트:
    //   - Queue<String> queue = new ArrayDeque<>()
    //   - offer(값): 뒤에 추가
    //   - peek(): 앞 요소 확인 (제거 안 함)
    //   - poll(): 앞 요소 제거 후 반환
    //   - isEmpty(): 비어 있는지 확인
    //   - size(): 크기
    // ============================================================
    static void problem1_basicQueueOperations() {
        Queue<String> queue = new ArrayDeque<>();

        // TODO: "작업1" ~ "작업5" offer
        // TODO: offer 후 큐 출력
        // TODO: peek() 출력
        // TODO: poll() 두 번 수행, 매번 반환값과 남은 큐 출력
        // TODO: isEmpty() 출력
        // TODO: size() 출력
    }

    // ============================================================
    // 문제 2: 은행 대기열 시뮬레이션
    // ------------------------------------------------------------
    // 설명:
    //   고객 이름과 업무 시간을 가진 Customer 클래스를 활용하여
    //   은행 창구 대기열을 시뮬레이션한다.
    //   고객이 순서대로 처리되며, 총 처리 시간도 출력한다.
    //
    // 예상 출력:
    //   === 은행 대기열 시뮬레이션 시작 ===
    //   대기 인원: 5명
    //   처리 중: 김철수 (예상 소요: 3분)
    //   처리 중: 이영희 (예상 소요: 5분)
    //   처리 중: 박민준 (예상 소요: 2분)
    //   처리 중: 최지아 (예상 소요: 7분)
    //   처리 중: 정하늘 (예상 소요: 4분)
    //   === 모든 고객 처리 완료. 총 소요 시간: 21분 ===
    //
    // 힌트:
    //   - Customer 내부 클래스를 활용
    //   - Queue에서 poll()로 한 명씩 처리
    //   - 처리할 때마다 소요 시간 누적
    // ============================================================
    static void problem2_bankQueueSimulation() {
        Queue<Customer> bankQueue = new ArrayDeque<>();

        // 고객 5명 대기열에 추가
        bankQueue.offer(new Customer("김철수", 3));
        bankQueue.offer(new Customer("이영희", 5));
        bankQueue.offer(new Customer("박민준", 2));
        bankQueue.offer(new Customer("최지아", 7));
        bankQueue.offer(new Customer("정하늘", 4));

        System.out.println("=== 은행 대기열 시뮬레이션 시작 ===");
        System.out.println("대기 인원: " + bankQueue.size() + "명");

        int totalTime = 0;
        // TODO: bankQueue가 빌 때까지 poll()로 고객을 처리
        // TODO: 각 고객 처리 시 "처리 중: 이름 (예상 소요: N분)" 출력
        // TODO: totalTime에 각 고객 업무 시간 누적
        // TODO: 완료 메시지와 총 소요 시간 출력
    }

    // ============================================================
    // 문제 3: Deque 양방향 처리
    // ------------------------------------------------------------
    // 설명:
    //   Deque를 사용하여 앞/뒤 양방향에서 삽입·삭제를 수행하고,
    //   회문(앞뒤가 같은 단어) 판별에 Deque를 활용한다.
    //
    // [3-1 양방향 삽입/삭제]
    // 예상 출력:
    //   초기 덱: [C, D, E]
    //   앞에 B, A 추가 후: [A, B, C, D, E]
    //   뒤에 F, G 추가 후: [A, B, C, D, E, F, G]
    //   앞에서 제거: A | 덱: [B, C, D, E, F, G]
    //   뒤에서 제거: G | 덱: [B, C, D, E, F]
    //
    // [3-2 회문 판별]
    // 예상 출력:
    //   "racecar" -> 회문: true
    //   "hello"   -> 회문: false
    //   "madam"   -> 회문: true
    //   "java"    -> 회문: false
    //
    // 힌트:
    //   - Deque<Character>에 문자열의 각 문자를 offer
    //   - 앞/뒤 문자를 동시에 poll하며 비교
    //   - 홀수 길이 단어는 마지막 하나가 남아도 회문
    // ============================================================
    static void problem3_dequeOperations() {
        // 3-1: 양방향 삽입/삭제
        Deque<String> deque = new ArrayDeque<>();
        deque.offer("C");
        deque.offer("D");
        deque.offer("E");

        System.out.println("초기 덱: " + deque);
        // TODO: offerFirst로 "B", "A" 추가 후 출력
        // TODO: offerLast로 "F", "G" 추가 후 출력
        // TODO: pollFirst() 수행 후 결과와 덱 출력
        // TODO: pollLast() 수행 후 결과와 덱 출력

        System.out.println();

        // 3-2: 회문 판별
        String[] words = {"racecar", "hello", "madam", "java"};
        for (String word : words) {
            System.out.println("\"" + word + "\" -> 회문: " + isPalindrome(word));
        }
    }

    /**
     * Deque를 사용하여 주어진 단어가 회문인지 판별한다.
     * @param word 검사할 단어
     * @return 회문이면 true
     */
    static boolean isPalindrome(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        // TODO: word의 각 문자를 deque에 offer
        // TODO: deque 크기가 1 이하가 될 때까지 앞/뒤 문자 비교
        return false; // TODO: 올바른 반환값으로 수정
    }

    // ============================================================
    // 헬퍼 메소드 시그니처
    // ============================================================

    /** 두 큐를 합쳐 하나의 큐로 반환한다 (첫 번째 큐의 요소가 앞에 위치). */
    static Queue<String> mergeQueues(Queue<String> q1, Queue<String> q2) {
        // TODO: 구현
        return null;
    }

    /** 큐의 요소를 역순으로 담은 새 큐를 반환한다. */
    static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // TODO: 구현
        return null;
    }

    // ============================================================
    // 내부 클래스
    // ============================================================

    /** 은행 대기열 시뮬레이션에 사용되는 고객 클래스 */
    static class Customer {
        String name;       // 고객 이름
        int serviceTime;   // 업무 처리 소요 시간 (분)

        Customer(String name, int serviceTime) {
            this.name = name;
            this.serviceTime = serviceTime;
        }

        @Override
        public String toString() {
            return name + "(" + serviceTime + "분)";
        }
    }
}
