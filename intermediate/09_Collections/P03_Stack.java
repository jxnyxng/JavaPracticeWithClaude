/**
 * ============================================================
 * 학습 목표:
 *   1. Stack 클래스의 기본 메소드(push, pop, peek, empty)를 활용한다.
 *   2. 스택의 LIFO(Last-In-First-Out) 특성을 괄호 유효성 검사에 적용한다.
 *   3. 스택을 활용한 후위 표기법(Postfix) 계산 로직을 구현한다.
 *
 * 핵심 개념:
 *   - Stack(스택): LIFO 구조. 가장 나중에 넣은 데이터가 먼저 나온다.
 *   - push(값): 스택 최상단에 요소 추가.
 *   - pop(): 최상단 요소 제거 후 반환.
 *   - peek(): 최상단 요소 조회 (제거 안 함).
 *   - empty(): 스택이 비어 있으면 true.
 *   - 후위 표기법: 연산자가 피연산자 뒤에 위치. 예) 3 4 + => 3 + 4 = 7
 *   - 참고: 실무에서는 Stack 대신 Deque(ArrayDeque) 사용을 권장.
 * ============================================================
 */

import java.util.Stack;

public class P03_Stack {

    public static void main(String[] args) {

        System.out.println("===== 문제 1: Stack 기본 조작 =====");
        problem1_basicOperations();

        System.out.println("\n===== 문제 2: 괄호 유효성 검사 =====");
        problem2_bracketValidation();

        System.out.println("\n===== 문제 3: 후위 표기법 계산 =====");
        problem3_postfixCalculation();

        System.out.println("\n===== 문제 4: 괄호 쌍 개수 세기 =====");
        problem4_countBracketPairs();
    }

    // ============================================================
    // 문제 1: Stack 기본 조작
    // ------------------------------------------------------------
    // 설명:
    //   Stack에 정수를 push하고 peek, pop, empty를 사용하여
    //   LIFO 동작 방식을 확인한다.
    //
    // 예상 출력:
    //   push 후 스택: [10, 20, 30, 40, 50]
    //   peek(): 50
    //   pop(): 50 | 스택: [10, 20, 30, 40]
    //   pop(): 40 | 스택: [10, 20, 30]
    //   empty(): false
    //   모두 pop 후 empty(): true
    //
    // 힌트:
    //   - Stack<Integer> stack = new Stack<>()
    //   - push(값), pop(), peek(), empty()
    //   - Stack은 toString()으로 전체 내용 출력 가능
    // ============================================================
    static void problem1_basicOperations() {
        Stack<Integer> stack = new Stack<>();

        // TODO: 10, 20, 30, 40, 50을 순서대로 push
        // TODO: push 후 스택 출력
        // TODO: peek() 결과 출력
        // TODO: pop() 두 번 수행, 매번 반환값과 스택 상태 출력
        // TODO: empty() 출력
        // TODO: 스택이 빌 때까지 pop 수행
        // TODO: 모두 pop 후 empty() 출력
    }

    // ============================================================
    // 문제 2: 괄호 유효성 검사
    // ------------------------------------------------------------
    // 설명:
    //   주어진 문자열에서 괄호({}, [], ())의 열기/닫기 쌍이
    //   올바르게 매칭되는지 검사한다.
    //   isValidBrackets() 메소드를 완성하고, 아래 테스트 케이스를 검증한다.
    //
    // 예상 출력:
    //   "{[()]}"  -> 유효: true
    //   "{[(])}"  -> 유효: false
    //   "((("     -> 유효: false
    //   ""        -> 유효: true
    //   "{[]()}"  -> 유효: true
    //
    // 힌트:
    //   - 여는 괄호({, [, ()를 만나면 push
    //   - 닫는 괄호(}, ], ))를 만나면 pop 후 쌍인지 확인
    //   - 스택이 비어 있는데 닫는 괄호가 나오면 false
    //   - 문자열 끝에 스택이 비어 있어야 true
    // ============================================================
    static void problem2_bracketValidation() {
        String[] testCases = {"{[()]}", "{[(])}", "(((", "", "{[]()"};
        for (String tc : testCases) {
            System.out.println("\"" + tc + "\" -> 유효: " + isValidBrackets(tc));
        }
    }

    /**
     * 괄호 유효성 검사 메소드.
     * @param s 검사할 문자열
     * @return 괄호가 유효하면 true, 아니면 false
     */
    static boolean isValidBrackets(String s) {
        Stack<Character> stack = new Stack<>();
        // TODO: s의 각 문자를 순회하며 괄호 유효성 검사 로직 구현
        // TODO: 여는 괄호는 push, 닫는 괄호는 pop 후 쌍 확인
        return false; // TODO: 올바른 반환값으로 수정
    }

    // ============================================================
    // 문제 3: 후위 표기법(Postfix) 계산
    // ------------------------------------------------------------
    // 설명:
    //   공백으로 구분된 후위 표기식 문자열을 받아 결과를 계산한다.
    //   evaluatePostfix() 메소드를 완성하고, 아래 테스트 케이스를 검증한다.
    //
    // 예상 출력:
    //   "3 4 +"      -> 결과: 7
    //   "5 1 2 + 4 * + 3 -" -> 결과: 14
    //   "2 3 * 4 +"  -> 결과: 10
    //
    // 힌트:
    //   - 토큰이 숫자이면 push
    //   - 토큰이 연산자(+, -, *, /)이면 피연산자 두 개를 pop 하여 계산 후 push
    //   - pop 순서 주의: 먼저 pop한 값이 오른쪽 피연산자
    //   - Integer.parseInt(token): 문자열을 정수로 변환
    //   - expression.split(" "): 공백 기준 분리
    // ============================================================
    static void problem3_postfixCalculation() {
        String[] expressions = {
            "3 4 +",
            "5 1 2 + 4 * + 3 -",
            "2 3 * 4 +"
        };
        for (String expr : expressions) {
            System.out.println("\"" + expr + "\" -> 결과: " + evaluatePostfix(expr));
        }
    }

    /**
     * 후위 표기식을 계산하여 결과를 반환한다.
     * @param expression 공백 구분 후위 표기식 문자열
     * @return 계산 결과
     */
    static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.split(" ");
        // TODO: 각 토큰을 순회하며 후위 표기법 계산 로직 구현
        return 0; // TODO: 올바른 반환값으로 수정
    }

    // ============================================================
    // 문제 4: 수식의 괄호 쌍 개수 세기
    // ------------------------------------------------------------
    // 설명:
    //   문자열에서 완전히 매칭된 괄호() 쌍의 개수를 반환한다.
    //   중첩 괄호도 각각 1쌍으로 센다.
    //
    // 예상 출력:
    //   "(()())"  -> 괄호 쌍 수: 3
    //   "((()))"  -> 괄호 쌍 수: 3
    //   "()()()"  -> 괄호 쌍 수: 3
    //   "(()"     -> 괄호 쌍 수: 1  (유효하지 않은 괄호 무시)
    //
    // 힌트:
    //   - '('를 만나면 push
    //   - ')'를 만나면 스택이 비어 있지 않을 때만 pop 하고 카운트 증가
    // ============================================================
    static void problem4_countBracketPairs() {
        String[] testCases = {"(()())", "((()))", "()()()", "(()"};
        for (String tc : testCases) {
            System.out.println("\"" + tc + "\" -> 괄호 쌍 수: " + countBracketPairs(tc));
        }
    }

    /**
     * 문자열에서 매칭된 괄호() 쌍의 개수를 반환한다.
     * @param s 검사할 문자열
     * @return 매칭된 쌍의 수
     */
    static int countBracketPairs(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        // TODO: 각 문자를 순회하며 쌍 개수 계산 로직 구현
        return count;
    }

    // ============================================================
    // 헬퍼 메소드 시그니처
    // ============================================================

    /** 스택을 사용하여 문자열을 역순으로 반환한다. */
    static String reverseString(String s) {
        // TODO: 구현
        return null;
    }

    /** 중위 표기식을 후위 표기식으로 변환한다 (연산자 우선순위 고려). */
    static String infixToPostfix(String expression) {
        // TODO: 구현
        return null;
    }
}
