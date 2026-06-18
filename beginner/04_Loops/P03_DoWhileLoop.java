/*
 * =====================================================
 * 학습 목표
 * =====================================================
 * 1. do-while 반복문의 구조를 이해하고, 최소 1회 실행 특성을 활용할 수 있다.
 * 2. 사용자 입력 유효성 검사처럼 "일단 실행 후 조건 확인" 패턴에 do-while을 적용할 수 있다.
 * 3. while문과 do-while문의 차이점을 코드로 설명할 수 있다.
 *
 * =====================================================
 * 핵심 개념 설명
 * =====================================================
 * [do-while 반복문 기본 구조]
 *   do {
 *       // 반복 실행할 코드 (최소 1번은 반드시 실행됨)
 *   } while (조건식);  // <-- 세미콜론(;) 필수!
 *
 * [while vs do-while 핵심 차이]
 *   - while:    조건 먼저 검사 → 조건이 false면 한 번도 실행 안 됨
 *   - do-while: 일단 실행 → 조건 검사 → 조건이 false이면 종료
 *
 * [do-while이 적합한 상황]
 *   - 메뉴 선택 반복 (적어도 한 번은 메뉴를 보여줘야 함)
 *   - 입력 유효성 검사 (일단 입력받고 올바른지 확인)
 *   - 게임 루프 (한 번은 실행해야 하는 게임 로직)
 *
 * [주의사항]
 *   - do-while 끝의 while (조건식); 에서 세미콜론을 빠뜨리지 마세요.
 *   - Scanner 사용 시 import java.util.Scanner; 필요
 * =====================================================
 */

import java.util.Scanner;
import java.util.Random;

public class P03_DoWhileLoop {

    public static void main(String[] args) {

        System.out.println("========== 문제 1: 유효 범위 숫자 입력받기 ==========");
        problem1_validInput();

        System.out.println("\n========== 문제 2: 비밀번호 확인 (최대 3회) ==========");
        problem2_passwordCheck();

        System.out.println("\n========== 문제 3: 주사위 굴리기 ==========");
        problem3_rollDice();

        System.out.println("\n========== 문제 4: while vs do-while 차이점 ==========");
        problem4_whileVsDoWhile();
    }

    // =====================================================
    // 문제 1: 1~10 사이 숫자 입력받기 (유효성 검사)
    // =====================================================
    // 설명: 사용자로부터 1~10 사이의 정수를 입력받으세요.
    //       범위를 벗어난 숫자를 입력하면 다시 입력하도록 요청합니다.
    //       올바른 값이 입력될 때까지 반복합니다.
    //
    // 예상 출력 예시:
    //   1~10 사이의 숫자를 입력하세요: 15
    //   잘못된 입력입니다. 1~10 사이의 숫자를 다시 입력하세요: -3
    //   잘못된 입력입니다. 1~10 사이의 숫자를 다시 입력하세요: 7
    //   입력한 숫자: 7
    //
    // 힌트:
    //   - Scanner sc = new Scanner(System.in); 으로 입력 객체 생성
    //   - do-while 조건: 입력값이 유효 범위를 벗어나는 경우 (input < 1 || input > 10)
    //   - 첫 번째 입력과 재입력 메시지를 구분하려면 boolean 플래그 또는
    //     반복문 내에서 조건 분기를 사용하세요.
    // =====================================================
    static void problem1_validInput() {
        Scanner sc = new Scanner(System.in);
        int input = 0;

        // TODO: do-while 반복문으로 1~10 사이의 유효한 값이 입력될 때까지 반복하세요.
        //       처음 입력 시: "1~10 사이의 숫자를 입력하세요: "
        //       재입력 시:   "잘못된 입력입니다. 1~10 사이의 숫자를 다시 입력하세요: "

        System.out.println("입력한 숫자: " + input);
        sc.close();
    }

    // =====================================================
    // 문제 2: 비밀번호 확인 (최대 3회 시도)
    // =====================================================
    // 설명: 미리 설정된 비밀번호("java1234")와 입력값을 비교합니다.
    //       일치하면 성공 메시지를 출력하고 종료합니다.
    //       틀리면 남은 시도 횟수와 함께 재입력을 요청합니다.
    //       3회 모두 실패하면 잠금 메시지를 출력합니다.
    //
    // 예상 출력 예시 (3회 실패):
    //   비밀번호를 입력하세요 (남은 시도: 3): hello
    //   비밀번호가 틀렸습니다.
    //   비밀번호를 입력하세요 (남은 시도: 2): world
    //   비밀번호가 틀렸습니다.
    //   비밀번호를 입력하세요 (남은 시도: 1): abc
    //   비밀번호가 틀렸습니다.
    //   3회 모두 실패했습니다. 계정이 잠겼습니다.
    //
    // 힌트:
    //   - 정답 비밀번호: String correctPassword = "java1234";
    //   - 시도 횟수 카운터: int attempts = 0;
    //   - 최대 시도 횟수: final int MAX_ATTEMPTS = 3;
    //   - 문자열 비교: inputPassword.equals(correctPassword)
    //   - do-while 조건: 틀렸고 && 시도 횟수 < 최대 횟수
    // =====================================================
    static void problem2_passwordCheck() {
        Scanner sc = new Scanner(System.in);
        final String CORRECT_PASSWORD = "java1234";
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;
        boolean success = false;

        // TODO: do-while 반복문으로 비밀번호를 최대 3회까지 확인하세요.
        //       성공 시 success = true로 변경하고 루프를 탈출하세요.

        if (success) {
            System.out.println("비밀번호가 확인되었습니다. 환영합니다!");
        } else {
            System.out.println("3회 모두 실패했습니다. 계정이 잠겼습니다.");
        }
        sc.close();
    }

    // =====================================================
    // 문제 3: 주사위 굴리기 (6이 나올 때까지 반복)
    // =====================================================
    // 설명: 1~6 사이의 난수를 생성하여 주사위 결과를 출력합니다.
    //       6이 나올 때까지 계속 굴리고, 총 시도 횟수를 출력합니다.
    //
    // 예상 출력 예시:
    //   주사위 1번째 굴리기: 3
    //   주사위 2번째 굴리기: 1
    //   주사위 3번째 굴리기: 5
    //   주사위 4번째 굴리기: 6
    //   6이 나왔습니다! 총 4번 굴렸습니다.
    //
    // 힌트:
    //   - Random 객체 생성: Random rand = new Random();
    //   - 1~6 난수 생성: rand.nextInt(6) + 1
    //   - do-while 조건: result != 6
    //   - 시도 횟수 카운터를 반복문 내에서 증가
    // =====================================================
    static void problem3_rollDice() {
        Random rand = new Random();
        int result = 0;
        int count = 0;

        // TODO: do-while 반복문으로 주사위를 6이 나올 때까지 굴리세요.
        //       매 시도마다 "주사위 n번째 굴리기: 결과값" 형식으로 출력하세요.

        System.out.println("6이 나왔습니다! 총 " + count + "번 굴렸습니다.");
    }

    // =====================================================
    // 문제 4: while vs do-while 차이점 코드로 보여주기
    // =====================================================
    // 설명: 조건이 처음부터 false인 경우, while문과 do-while문의
    //       동작 차이를 코드로 직접 확인하세요.
    //
    // 예상 출력:
    //   --- while문 (조건: false) ---
    //   while 루프 내부는 실행되지 않았습니다.
    //
    //   --- do-while문 (조건: false) ---
    //   do-while 루프 내부가 실행되었습니다! (최소 1회 실행)
    //   do-while 루프가 종료되었습니다.
    //
    // 힌트:
    //   - boolean condition = false; 로 설정
    //   - while (condition) { ... } 로 while 테스트
    //   - do { ... } while (condition); 로 do-while 테스트
    //   - 실행 여부를 알리는 출력문을 각 블록 안에 작성
    // =====================================================
    static void problem4_whileVsDoWhile() {
        boolean condition = false; // 처음부터 false인 조건

        System.out.println("--- while문 (조건: false) ---");
        // TODO: while (condition) 으로 반복문을 작성하세요.
        //       내부에서 "while 루프 내부 실행됨"을 출력하는 코드 작성
        System.out.println("while 루프 내부는 실행되지 않았습니다.");

        System.out.println();
        System.out.println("--- do-while문 (조건: false) ---");
        // TODO: do { ... } while (condition); 으로 반복문을 작성하세요.
        //       내부에서 "do-while 루프 내부가 실행되었습니다! (최소 1회 실행)"을 출력

        System.out.println("do-while 루프가 종료되었습니다.");
    }
}
