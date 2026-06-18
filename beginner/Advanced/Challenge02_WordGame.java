/**
 * ============================================================
 * 파일명: Challenge02_WordGame.java
 * 제  목: 단어 분석 및 게임 유틸리티
 * ============================================================
 *
 * [학습 목표]
 * 1. String 클래스의 다양한 메서드를 실전 문제에 적용할 수 있다.
 * 2. 중첩 반복문과 조건문을 조합하여 문자열 알고리즘을 구현할 수 있다.
 * 3. char 타입과 String 간 변환을 자유롭게 할 수 있다.
 * 4. 메서드를 설계하고 조합하여 간단한 텍스트 게임 기능을 구현할 수 있다.
 *
 * [핵심 개념]
 * - String 메서드: length(), charAt(), substring(), indexOf(), toLowerCase(), toUpperCase(),
 *                   replace(), trim(), split(), contains()
 * - char 연산: 문자 비교, 아스키 코드, 대소문자 구분
 * - StringBuilder: 반복적인 문자열 조합 시 효율적
 * - 중첩 반복문: 문자열 패턴 탐색
 * ============================================================
 */

public class Challenge02_WordGame {

    // ============================================================
    // [문제 1] 팰린드롬(회문) 판별
    // ============================================================

    /**
     * 주어진 문자열이 팰린드롬(앞뒤가 동일한 문자열)인지 판별하는 메서드를 작성하세요.
     * 대소문자를 무시하고, 공백은 제거하고 비교합니다.
     *
     * 예시:
     *   "level"   → true
     *   "A man a plan a canal Panama" → true  (공백 제거 후: "amanaplanacanalpanama")
     *   "hello"   → false
     *
     * 힌트:
     * - toLowerCase() + replace(" ", "") 로 전처리
     * - 앞에서부터와 뒤에서부터 한 글자씩 비교 (charAt 이용)
     */
    public static boolean isPalindrome(String str) {
        // TODO: 구현
        return false;
    }

    // ============================================================
    // [문제 2] 단어 내 모음/자음 개수 세기
    // ============================================================

    /**
     * 문자열에서 모음(a, e, i, o, u)의 개수를 반환하는 메서드를 작성하세요.
     * 대소문자를 구분하지 않습니다.
     *
     * 예시: "Hello World" → 3 (e, o, o)
     *
     * 힌트:
     * - toLowerCase() 로 소문자 변환 후 각 문자가 모음인지 확인
     */
    public static int countVowels(String str) {
        // TODO: 구현
        return 0;
    }

    /**
     * 문자열에서 자음의 개수를 반환하는 메서드를 작성하세요.
     * 공백과 숫자 등 알파벳이 아닌 문자는 제외합니다.
     *
     * 예시: "Hello World" → 7 (H, l, l, W, r, l, d)
     *
     * 힌트:
     * - Character.isLetter(ch) 로 알파벳 여부 확인
     * - 알파벳이면서 모음이 아니면 자음
     */
    public static int countConsonants(String str) {
        // TODO: 구현
        return 0;
    }

    // ============================================================
    // [문제 3] 단어 뒤집기
    // ============================================================

    /**
     * 문자열에서 각 단어의 순서를 유지하되, 각 단어 내 글자를 뒤집는 메서드를 작성하세요.
     *
     * 예시:
     *   "Hello World" → "olleH dlroW"
     *   "Java is fun" → "avaJ si nuf"
     *
     * 힌트:
     * - split(" ") 로 단어 분리
     * - StringBuilder 또는 charAt으로 각 단어를 뒤집기
     * - String.join(" ", ...) 또는 반복문으로 재조합
     */
    public static String reverseWords(String sentence) {
        // TODO: 구현
        return "";
    }

    // ============================================================
    // [문제 4] 가장 많이 등장하는 문자 찾기
    // ============================================================

    /**
     * 문자열에서 가장 많이 등장하는 알파벳 문자를 반환하는 메서드를 작성하세요.
     * 대소문자를 구분하지 않으며, 공백은 무시합니다.
     * 빈도가 같은 문자가 여럿이면 알파벳 순서상 앞선 문자를 반환합니다.
     *
     * 예시:
     *   "hello world" → 'l'  (l이 3번으로 가장 많음)
     *   "aabbcc"      → 'a'  (모두 2번, a가 알파벳 앞)
     *
     * 힌트:
     * - int[] count = new int[26]; 으로 각 알파벳 빈도 저장
     * - ch - 'a' 로 배열 인덱스 계산
     */
    public static char findMostFrequentChar(String str) {
        // TODO: 구현
        return ' ';
    }

    // ============================================================
    // [문제 5] 간단한 암호화 (Caesar Cipher)
    // ============================================================

    /**
     * 카이사르 암호로 문자열을 암호화하는 메서드를 작성하세요.
     * 알파벳 문자만 shift만큼 밀고, 나머지 문자(공백, 숫자 등)는 그대로 유지합니다.
     * 대소문자는 유지합니다.
     *
     * 예시 (shift = 3):
     *   "Hello World" → "Khoor Zruog"
     *   "xyz" → "abc"  (z 다음은 a로 순환)
     *
     * 힌트:
     * - 대문자: 'A' 기준, 소문자: 'a' 기준으로 offset 계산
     * - (ch - 'A' + shift) % 26 + 'A' 패턴 활용
     */
    public static String caesarEncrypt(String text, int shift) {
        // TODO: 구현
        return "";
    }

    /**
     * 카이사르 암호를 복호화하는 메서드를 작성하세요.
     *
     * 힌트: shift를 반대로 적용 (26 - shift) % 26
     */
    public static String caesarDecrypt(String text, int shift) {
        // TODO: 구현
        return "";
    }

    // ============================================================
    // 메인 메서드
    // ============================================================

    public static void main(String[] args) {

        System.out.println("=== 단어 분석 및 게임 유틸리티 ===\n");

        // [1] 팰린드롬 테스트
        System.out.println("=== 팰린드롬 판별 ===");
        // TODO: 다음 문자열들을 테스트하고 결과를 출력하세요.
        //   "level", "Java", "A man a plan a canal Panama", "racecar", "hello"
        // 예상 출력: "level" → 팰린드롬 O

        // [2] 모음/자음 개수
        System.out.println("\n=== 모음/자음 개수 ===");
        String testWord = "Hello Beautiful World";
        // TODO: testWord의 모음과 자음 개수를 출력하세요.
        //   예: 모음: 7개, 자음: 10개

        // [3] 단어 뒤집기
        System.out.println("\n=== 단어 뒤집기 ===");
        // TODO: "Java Programming is Fun" 의 각 단어를 뒤집어 출력하세요.

        // [4] 가장 많이 등장하는 문자
        System.out.println("\n=== 최다 등장 문자 ===");
        // TODO: "programming" 에서 가장 많이 등장하는 문자를 찾아 출력하세요.
        //   예: 최다 등장 문자: 'g' (2회)

        // [5] 카이사르 암호
        System.out.println("\n=== 카이사르 암호 ===");
        String original = "Hello World";
        int shift = 3;
        // TODO: original을 shift=3으로 암호화하고, 다시 복호화하여 원래 문자열이 나오는지 확인하세요.
        //   예상 출력:
        //   원문: Hello World
        //   암호문 (shift=3): Khoor Zruog
        //   복호문: Hello World

        // [추가 도전] 문자열이 아나그램(같은 문자 구성)인지 확인하는 메서드를 직접 작성해보세요.
        // isAnagram("listen", "silent") → true
        // isAnagram("hello", "world")  → false
    }
}
