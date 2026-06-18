/**
 * ============================================================
 * 학습 목표:
 *   1. PriorityQueue의 기본 동작(자연 순서 정렬)을 이해한다.
 *   2. Comparator를 사용하여 커스텀 우선순위를 정의한다.
 *   3. 객체 타입 PriorityQueue를 통해 실제 문제(성적 처리)를 해결한다.
 *
 * 핵심 개념:
 *   - PriorityQueue: 요소가 자연 순서(또는 Comparator 기준)에 따라
 *     자동 정렬되는 큐. poll()은 항상 가장 우선순위 높은 요소를 반환.
 *   - 기본 동작: 숫자는 오름차순(최솟값 우선), 문자열은 사전순.
 *   - Comparator.reverseOrder(): 내림차순 정렬.
 *   - 람다 Comparator: (a, b) -> b.field - a.field 형태로 커스텀 정렬.
 *   - 내부 구조: 최소 힙(Min-Heap) 기반. offer/poll 모두 O(log n).
 * ============================================================
 */

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P05_PriorityQueue {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: 기본 PriorityQueue (자연 순서) =====");
        problem1_naturalOrdering();

        System.out.println("\n===== 문제 2: Comparator로 커스텀 우선순위 =====");
        problem2_customComparator();

        System.out.println("\n===== 문제 3: 학생 성적 처리 =====");
        problem3_studentGradeProcessing();
    }

    // ============================================================
    // 문제 1: 기본 PriorityQueue (자연 순서)
    // ------------------------------------------------------------
    // 설명:
    //   정수형 PriorityQueue를 생성하고, 요소를 추가한 뒤 하나씩 poll하며
    //   자연 순서(오름차순)로 꺼내지는 것을 확인한다.
    //
    // 예상 출력:
    //   offer 후 pq (내부 힙 순서): [1, 3, 2, 7, 5, 8, 4]  ← 힙 구조라 출력 순서 다를 수 있음
    //   poll 순서 (오름차순):
    //   1 2 3 4 5 7 8
    //   pq 비어 있나요? true
    //
    // 힌트:
    //   - PriorityQueue<Integer> pq = new PriorityQueue<>()
    //   - offer(값) 또는 add(값): 추가
    //   - poll(): 가장 작은 값부터 꺼냄
    //   - peek(): 가장 작은 값 확인 (제거 안 함)
    //   - PriorityQueue를 그대로 출력하면 힙 내부 배열 순서 (정렬 순서 아님)
    // ============================================================
    static void problem1_naturalOrdering() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // TODO: 5, 1, 8, 3, 7, 2, 4를 순서대로 offer
        // TODO: offer 후 pq 출력 (힙 내부 순서)
        System.out.print("poll 순서 (오름차순):\n");
        // TODO: pq가 빌 때까지 poll()하며 값을 공백 구분으로 출력
        System.out.println();
        // TODO: pq 비어 있는지 출력
    }

    // ============================================================
    // 문제 2: Comparator로 커스텀 우선순위
    // ------------------------------------------------------------
    // 설명:
    //   [2-1] 내림차순 PriorityQueue: 가장 큰 수부터 꺼내지도록 설정.
    //   [2-2] 문자열 길이 오름차순 PriorityQueue: 짧은 문자열 먼저 꺼냄.
    //
    // 예상 출력:
    //   [2-1] 내림차순 poll:
    //   9 7 5 4 2 1
    //
    //   [2-2] 문자열 길이 오름차순 poll:
    //   cat apple banana strawberry
    //
    // 힌트:
    //   - 내림차순: new PriorityQueue<>(Collections.reverseOrder())
    //     또는 new PriorityQueue<>((a, b) -> b - a)
    //   - 문자열 길이 오름차순: new PriorityQueue<>(Comparator.comparingInt(String::length))
    //     또는 new PriorityQueue<>((a, b) -> a.length() - b.length())
    // ============================================================
    static void problem2_customComparator() {
        // 2-1: 내림차순 PriorityQueue
        // TODO: 내림차순 PriorityQueue 생성
        // TODO: 5, 1, 9, 2, 7, 4를 offer
        System.out.print("[2-1] 내림차순 poll:\n");
        // TODO: 빌 때까지 poll하며 출력
        System.out.println();

        System.out.println();

        // 2-2: 문자열 길이 기준 오름차순 PriorityQueue
        // TODO: 문자열 길이 오름차순 PriorityQueue 생성
        // TODO: "apple", "cat", "strawberry", "banana"를 offer
        System.out.print("[2-2] 문자열 길이 오름차순 poll:\n");
        // TODO: 빌 때까지 poll하며 출력
        System.out.println();
    }

    // ============================================================
    // 문제 3: 학생 성적 처리
    // ------------------------------------------------------------
    // 설명:
    //   Student 클래스 객체를 PriorityQueue에 담고, 점수가 높은 순서로
    //   순위를 매겨 출력한다.
    //   또한 상위 3명의 평균 점수를 계산하여 출력한다.
    //
    // 예상 출력:
    //   === 성적 순위 (높은 순) ===
    //   1위: 이영희 - 98점
    //   2위: 김철수 - 95점
    //   3위: 정하늘 - 88점
    //   4위: 박민준 - 75점
    //   5위: 최지아 - 62점
    //   상위 3명 평균: 93.67점
    //
    // 힌트:
    //   - 점수 내림차순: (a, b) -> b.score - a.score
    //   - 상위 3명 평균 계산 시 소수점 둘째 자리까지 출력: String.format("%.2f", avg)
    //   - poll()로 꺼낼 때마다 순위 증가
    // ============================================================
    static void problem3_studentGradeProcessing() {
        // TODO: 점수 내림차순 PriorityQueue<Student> 생성

        // 학생 데이터 추가
        // TODO: offer(new Student("김철수", 95))
        // TODO: offer(new Student("이영희", 98))
        // TODO: offer(new Student("박민준", 75))
        // TODO: offer(new Student("최지아", 62))
        // TODO: offer(new Student("정하늘", 88))

        System.out.println("=== 성적 순위 (높은 순) ===");
        // TODO: 빌 때까지 poll하며 "N위: 이름 - X점" 형식으로 출력

        // TODO: 상위 3명의 평균 점수를 계산하여 출력
        // (주의: poll() 후 pq가 비어 있으므로 미리 점수를 저장하거나 처음부터 다시 구성)
    }

    // ============================================================
    // 헬퍼 메소드 시그니처
    // ============================================================

    /**
     * 정수 배열에서 k번째로 작은 수를 반환한다.
     * PriorityQueue(최소 힙)를 활용한다.
     * @param nums 정수 배열
     * @param k    순위 (1-based)
     * @return k번째로 작은 수
     */
    static int findKthSmallest(int[] nums, int k) {
        // TODO: 구현
        return 0;
    }

    /**
     * 두 PriorityQueue를 하나로 합쳐 정렬된 상태의 PriorityQueue를 반환한다.
     * @param pq1 첫 번째 PriorityQueue
     * @param pq2 두 번째 PriorityQueue
     * @return 합쳐진 PriorityQueue
     */
    static PriorityQueue<Integer> mergePriorityQueues(
            PriorityQueue<Integer> pq1, PriorityQueue<Integer> pq2) {
        // TODO: 구현
        return null;
    }

    // ============================================================
    // 내부 클래스
    // ============================================================

    /** 학생 성적 처리에 사용되는 학생 클래스 */
    static class Student {
        String name;   // 학생 이름
        int score;     // 점수

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return name + "(" + score + "점)";
        }
    }
}
