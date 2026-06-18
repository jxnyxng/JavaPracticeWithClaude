/*
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. break 키워드로 반복문을 즉시 종료하는 방법을 이해하고 활용할 수 있다.
 * 2. continue 키워드로 현재 반복만 건너뛰고 다음 반복으로 진행하는 방법을 활용할 수 있다.
 * 3. 라벨(label)을 사용하여 중첩 반복문에서 원하는 레벨의 루프를 제어할 수 있다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [break 키워드]
 *   - 현재 반복문(for, while, do-while, switch)을 즉시 종료
 *   - 조건이 충족되면 더 이상 반복할 필요 없을 때 사용
 *   - 중첩 루프에서는 가장 안쪽 루프만 종료됨
 *   예) 배열에서 특정 값을 찾으면 더 이상 탐색할 필요 없음
 *
 * [continue 키워드]
 *   - 현재 반복의 나머지 코드를 건너뛰고 다음 반복으로 이동
 *   - 특정 조건의 원소를 처리에서 제외할 때 사용
 *   - for문: 증감식으로 이동 / while문: 조건식으로 이동
 *   예) 짝수만 처리하고 홀수는 건너뛰기
 *
 * [라벨(label) break / continue]
 *   - 중첩 루프에서 특정 루프를 대상으로 break/continue 적용
 *   - 라벨 문법: 라벨명: for (...) { ... break 라벨명; }
 *   - 라벨명은 관례적으로 대문자 사용 (OUTER, INNER 등)
 *   예) 중첩 루프에서 특정 조건 발견 시 외부 루프까지 한 번에 탈출
 * =====================================================
 */

public class P05_BreakContinue {

    public static void main(String[] args) {

        System.out.println("========== 문제 1: 배열에서 특정 값 찾기 (break) ==========");
        int[] data = {15, 42, 7, 83, 56, 29, 61, 34};
        int target = 56;
        problem1_findWithBreak(data, target);

        System.out.println("\n========== 문제 2: 3의 배수 건너뛰며 합산 (continue) ==========");
        int limit = 20;
        problem2_skipMultiplesOf3(limit);

        System.out.println("\n========== 문제 3: 라벨 break로 중첩 루프 탈출 ==========");
        int targetRow = 3;
        int targetCol = 4;
        problem3_labeledBreak(targetRow, targetCol);

        System.out.println("\n========== 문제 4: 소수(Prime Number) 찾기 ==========");
        int searchLimit = 50;
        problem4_findPrimes(searchLimit);
    }

    // =====================================================
    // 문제 1: 배열에서 특정 값 찾으면 break로 중단
    // =====================================================
    // 설명: 정수 배열에서 target 값을 선형 탐색합니다.
    //       값을 찾으면 인덱스를 출력하고 break로 탐색을 중단하세요.
    //       값이 없으면 "찾지 못했습니다."를 출력하세요.
    //
    // 예상 출력 (data에서 56 탐색 시):
    //   인덱스 0: 15 확인 중...
    //   인덱스 1: 42 확인 중...
    //   인덱스 2: 7 확인 중...
    //   인덱스 3: 83 확인 중...
    //   인덱스 4: 56 확인 중...
    //   56을(를) 인덱스 4에서 찾았습니다!
    //
    // 힌트:
    //   - for 반복문으로 배열의 각 원소 접근
    //   - if (data[i] == target) 조건 충족 시 break
    //   - 찾았는지 여부를 boolean found 변수로 관리
    //   - 반복문 종료 후 found 값으로 결과 분기
    // =====================================================
    static void problem1_findWithBreak(int[] data, int target) {
        boolean found = false;
        int foundIndex = -1;

        // TODO: for 반복문으로 data 배열을 순회하면서
        //       "인덱스 n: 값 확인 중..." 출력 후
        //       target과 일치하면 found = true, foundIndex = i 저장하고 break

        if (found) {
            System.out.println(target + "을(를) 인덱스 " + foundIndex + "에서 찾았습니다!");
        } else {
            System.out.println(target + "을(를) 찾지 못했습니다.");
        }
    }

    // =====================================================
    // 문제 2: continue로 3의 배수 건너뛰며 합산
    // =====================================================
    // 설명: 1부터 limit까지의 숫자 중 3의 배수를 제외한 수의 합계를 구하세요.
    //       3의 배수를 만나면 continue로 해당 수를 건너뜁니다.
    //
    // 예상 출력 (limit = 20일 때):
    //   건너뜀: 3
    //   건너뜀: 6
    //   건너뜀: 9
    //   건너뜀: 12
    //   건너뜀: 15
    //   건너뜀: 18
    //   3의 배수 제외 합계 (1~20): 147
    //
    // 힌트:
    //   - for 반복문: 1부터 limit까지
    //   - 3의 배수 판별: i % 3 == 0
    //   - 조건 충족 시 "건너뜀: n" 출력 후 continue
    //   - continue 아래 코드: sum += i (3의 배수가 아닌 경우만 실행됨)
    // =====================================================
    static void problem2_skipMultiplesOf3(int limit) {
        int sum = 0;

        // TODO: for 반복문으로 1~limit 순회하며
        //       3의 배수는 "건너뜀: n" 출력 후 continue,
        //       나머지는 sum에 누적합산하세요.

        System.out.println("3의 배수 제외 합계 (1~" + limit + "): " + sum);
    }

    // =====================================================
    // 문제 3: 라벨 break로 중첩 루프 탈출
    // =====================================================
    // 설명: 5x5 격자를 순회하다가 특정 위치(targetRow, targetCol)를
    //       발견하면 라벨 break로 중첩 루프 전체를 탈출하세요.
    //
    // 예상 출력 (targetRow=3, targetCol=4 일 때):
    //   탐색 중: [1][1]
    //   탐색 중: [1][2]
    //   ...
    //   탐색 중: [3][4]
    //   목표 위치 [3][4] 발견! 탐색 종료.
    //
    // 힌트:
    //   - 외부 루프 앞에 라벨 선언: OUTER: for (int i = 1; ...)
    //   - 내부 루프에서 목표 발견 시: break OUTER;
    //   - 라벨 break는 지정된 루프 전체를 종료함
    //   - 라벨명은 대문자 관례 (OUTER, SEARCH 등)
    // =====================================================
    static void problem3_labeledBreak(int targetRow, int targetCol) {

        // TODO: 5x5 격자를 순회하는 중첩 for문을 작성하세요.
        //       OUTER: 라벨을 외부 루프에 붙이고,
        //       [i][j] == [targetRow][targetCol] 조건 충족 시
        //       "목표 위치 [n][n] 발견! 탐색 종료." 출력 후 break OUTER

    }

    // =====================================================
    // 문제 4: 소수(Prime Number) 찾기 (break 활용)
    // =====================================================
    // 설명: 2부터 searchLimit까지 소수를 모두 찾아 출력하세요.
    //       소수 판별 시 나누어지는 약수를 찾으면 break로 즉시 중단합니다.
    //       (소수: 1과 자기 자신만을 약수로 가지는 수)
    //
    // 예상 출력 (searchLimit = 50일 때):
    //   2 이하 50까지의 소수:
    //   2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
    //   소수 개수: 15
    //
    // 힌트:
    //   - 외부 루프: 2부터 searchLimit까지 각 숫자 n을 검사
    //   - 소수 판별 내부 루프: 2부터 n-1까지 (또는 최적화: √n까지)
    //     - n을 j로 나누어 나머지가 0이면 소수 아님 → break
    //   - boolean isPrime 변수로 소수 여부 관리
    //   - 소수 카운터 변수로 개수 집계
    //   - 최적화 방법: j <= Math.sqrt(n) 또는 j * j <= n 조건 사용
    // =====================================================
    static void problem4_findPrimes(int searchLimit) {
        int primeCount = 0;

        System.out.println("2 이상 " + searchLimit + " 이하의 소수:");

        // TODO: 외부 for문으로 2~searchLimit의 각 수 n을 순회하세요.
        //       내부 for문으로 2~(n-1) 범위에서 약수를 탐색합니다.
        //       약수 발견 시 break로 내부 루프를 탈출하고 isPrime = false로 설정.
        //       소수이면 출력하고 primeCount를 증가시키세요.

        System.out.println();
        System.out.println("소수 개수: " + primeCount);
    }
}
