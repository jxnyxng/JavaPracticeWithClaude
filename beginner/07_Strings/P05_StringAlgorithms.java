/*
 * ========================================================
 * P05_StringAlgorithms.java - 문자열 알고리즘
 * ========================================================
 *
 * 【학습 목표】
 *  1. 문자열 순회(loop)와 charAt()을 활용하여 팰린드롬 판별,
 *     빈도수 계산 등의 알고리즘을 직접 구현할 수 있다.
 *  2. 배열 또는 HashMap을 이용해 문자 빈도수를 세고,
 *     두 문자열이 아나그램인지 확인할 수 있다.
 *  3. 중복 제거 알고리즘을 구현하여 문자열 처리 능력을 키운다.
 *
 * 【핵심 개념 설명】
 *  - 팰린드롬(Palindrome, 회문):
 *      앞에서 읽어도 뒤에서 읽어도 같은 문자열.
 *      예: "racecar", "level", "madam", "a"
 *      알고리즘: 양끝 포인터를 좁히며 비교하거나, 뒤집어서 비교.
 *
 *  - 문자 빈도수(Frequency Count):
 *      int[] freq = new int[26]; // 알파벳 26개
 *      freq[ch - 'a']++ 로 각 문자의 등장 횟수를 센다.
 *
 *  - 아나그램(Anagram):
 *      두 문자열을 구성하는 문자와 개수가 동일한 경우.
 *      예: "listen" 과 "silent", "earth" 와 "heart"
 *      알고리즘: 두 문자열을 정렬하여 비교하거나, 빈도수 배열 비교.
 *
 *  - 중복 문자 제거:
 *      문자열을 순회하며 이미 등장한 문자는 결과에서 제외.
 *      indexOf() 또는 contains()로 이미 포함 여부 확인.
 * ========================================================
 */

import java.util.Arrays;

public class P05_StringAlgorithms {

    public static void main(String[] args) {

        // ====================================================
        // 문제 1: 팰린드롬(회문) 판별
        // ====================================================
        /*
         * [문제 1] 팰린드롬 판별기 구현
         * -------------------------------------------------------
         * 설명:
         *   isPalindrome(String s) 메소드를 두 가지 방법으로 구현하고,
         *   아래 테스트 케이스를 출력하세요.
         *
         *   방법1 (양끝 포인터): left/right 포인터로 문자 비교
         *   방법2 (뒤집기):      StringBuilder.reverse()로 비교
         *
         *   테스트 케이스:
         *     "racecar"  → true
         *     "hello"    → false
         *     "A man a plan a canal Panama" (공백/대소문자 무시) → true
         *     "level"    → true
         *     ""         → true  (빈 문자열은 팰린드롬)
         *
         * 예상 출력:
         *   "racecar" : true
         *   "hello" : false
         *   "A man..." (정규화 후) : true
         *   "level" : true
         *   "" : true
         *
         * 힌트:
         *   - 대소문자/공백 무시: s.toLowerCase().replaceAll("[^a-z0-9]", "")
         *   - 양끝 포인터: int left=0, right=s.length()-1; while(left<right)
         *   - charAt(left) != charAt(right) 이면 false 반환.
         */
        System.out.println("=== 문제 1: 팰린드롬 판별 ===");

        String[] palindromeTests = {
            "racecar",
            "hello",
            "A man a plan a canal Panama",
            "level",
            ""
        };

        // TODO: 각 테스트 케이스에 대해 isPalindrome() 결과를 출력하세요.
        //       "A man..." 은 정규화(소문자 변환 + 영숫자만 추출) 후 전달.

        System.out.println();

        // ====================================================
        // 문제 2: 문자 빈도수 세기
        // ====================================================
        /*
         * [문제 2] 알파벳 빈도수 계산
         * -------------------------------------------------------
         * 설명:
         *   countFrequency(String s) 메소드를 구현하고,
         *   "programming" 에서 각 문자가 몇 번 등장하는지 출력하세요.
         *   등장 횟수가 0인 문자는 출력하지 마세요.
         *
         *   또한 가장 많이 등장하는 문자와 그 횟수도 출력하세요.
         *
         * 예상 출력:
         *   문자 빈도수 ("programming"):
         *   a: 1
         *   g: 2
         *   i: 1
         *   m: 2
         *   n: 1
         *   o: 1
         *   p: 1
         *   r: 2
         *   가장 많은 문자: g (2회) [또는 m, r 중 하나]
         *
         * 힌트:
         *   - int[] freq = new int[26]; 선언.
         *   - 소문자로 변환 후 처리: s.toLowerCase().
         *   - 문자 → 인덱스 변환: ch - 'a' (a=0, b=1, ..., z=25).
         *   - 영문자만 처리: Character.isLetter(ch) 로 확인.
         *   - 빈도수 배열을 순회하며 0이 아닌 항목만 출력.
         */
        System.out.println("=== 문제 2: 문자 빈도수 ===");

        String freqTarget = "programming";

        // TODO: countFrequency() 메소드를 호출하여 빈도수 배열 받기

        // TODO: 빈도수가 0이 아닌 문자와 횟수 출력

        // TODO: 가장 많이 등장한 문자 찾아 출력

        System.out.println();

        // ====================================================
        // 문제 3: 아나그램 확인
        // ====================================================
        /*
         * [문제 3] 두 문자열이 아나그램인지 확인
         * -------------------------------------------------------
         * 설명:
         *   isAnagram(String s1, String s2) 메소드를 구현하고,
         *   아래 쌍들이 아나그램인지 출력하세요.
         *
         *   테스트 케이스:
         *     ("listen", "silent")  → true
         *     ("earth",  "heart")   → true
         *     ("hello",  "world")   → false
         *     ("Astronomer", "Moon starer") → true  (공백/대소문자 무시)
         *     ("abc",    "ab")      → false
         *
         * 예상 출력:
         *   listen / silent : true
         *   earth / heart : true
         *   hello / world : false
         *   Astronomer / Moon starer : true
         *   abc / ab : false
         *
         * 힌트:
         *   방법1 (정렬 비교):
         *     - s를 char[] 배열로 변환 → Arrays.sort() → 다시 String으로 변환.
         *     - 두 정렬된 문자열이 같으면 아나그램.
         *   방법2 (빈도수 비교):
         *     - 두 문자열의 빈도수 배열을 만들어 Arrays.equals()로 비교.
         *   - 비교 전: 소문자 변환 + 공백 제거 (replaceAll("\\s","")).
         */
        System.out.println("=== 문제 3: 아나그램 확인 ===");

        String[][] anagramPairs = {
            {"listen",     "silent"},
            {"earth",      "heart"},
            {"hello",      "world"},
            {"Astronomer", "Moon starer"},
            {"abc",        "ab"}
        };

        // TODO: 각 쌍에 대해 isAnagram() 결과를 출력하세요.

        System.out.println();

        // ====================================================
        // 문제 4: 문자열에서 중복 문자 제거
        // ====================================================
        /*
         * [문제 4] 첫 등장 순서를 유지하며 중복 제거
         * -------------------------------------------------------
         * 설명:
         *   removeDuplicates(String s) 메소드를 구현하고,
         *   아래 문자열에서 중복 문자를 제거하세요.
         *   단, 문자가 처음 등장하는 순서는 유지해야 합니다.
         *
         *   테스트 케이스:
         *     "programming"  → "progamin"
         *     "mississippi"  → "misp"
         *     "abcabc"       → "abc"
         *     "aabbcc"       → "abc"
         *     "hello world"  → "helo wrd"
         *
         * 예상 출력:
         *   "programming" → "progamin"
         *   "mississippi" → "misp"
         *   "abcabc" → "abc"
         *   "aabbcc" → "abc"
         *   "hello world" → "helo wrd"
         *
         * 힌트:
         *   방법1 (StringBuilder 사용):
         *     - StringBuilder result 선언.
         *     - 각 문자를 순회: result.indexOf(String.valueOf(ch)) == -1 이면 추가.
         *   방법2 (LinkedHashSet 사용):
         *     - LinkedHashSet은 삽입 순서를 유지하며 중복을 허용하지 않음.
         *     - 단, 이 문제에서는 StringBuilder 방식으로 구현 권장.
         */
        System.out.println("=== 문제 4: 중복 문자 제거 ===");

        String[] dupTests = {
            "programming",
            "mississippi",
            "abcabc",
            "aabbcc",
            "hello world"
        };

        // TODO: 각 테스트 케이스에 대해 removeDuplicates() 결과를 출력하세요.
        // 출력 형식: '"programming" → "progamin"'

    }

    // ====================================================
    // 헬퍼 메소드 (내용을 직접 구현하세요)
    // ====================================================

    /**
     * 주어진 문자열이 팰린드롬인지 판별한다.
     * 양끝 포인터(two-pointer) 방식으로 구현하세요.
     *
     * @param s 검사할 문자열 (이미 정규화된 상태여야 함)
     * @return 팰린드롬이면 true, 아니면 false
     */
    static boolean isPalindrome(String s) {
        // TODO: left=0, right=s.length()-1 포인터를 사용하여
        //       양끝에서 좁히며 비교. 불일치 시 false 반환.
    }

    /**
     * 문자열에서 각 알파벳의 등장 횟수를 센다.
     * 대소문자는 구분하지 않으며, 영문자만 처리한다.
     *
     * @param s 대상 문자열
     * @return 크기 26인 int 배열 (index 0 = 'a', index 25 = 'z')
     */
    static int[] countFrequency(String s) {
        // TODO: int[26] 배열 생성.
        //       s를 소문자로 변환 후 순회.
        //       영문자인 경우 freq[ch - 'a']++ 증가.
        //       배열 반환.
    }

    /**
     * 두 문자열이 아나그램인지 확인한다.
     * 공백과 대소문자는 무시한다.
     *
     * @param s1 첫 번째 문자열
     * @param s2 두 번째 문자열
     * @return 아나그램이면 true, 아니면 false
     */
    static boolean isAnagram(String s1, String s2) {
        // TODO: 두 문자열을 소문자로 변환하고 공백 제거.
        //       길이가 다르면 즉시 false 반환.
        //       각 문자열의 char[]을 정렬하여 Arrays.equals()로 비교.
    }

    /**
     * 문자열에서 중복 문자를 제거하고 첫 등장 순서를 유지하여 반환한다.
     *
     * @param s 입력 문자열
     * @return 중복이 제거된 문자열
     */
    static String removeDuplicates(String s) {
        // TODO: StringBuilder result 선언.
        //       s의 각 문자를 순회.
        //       result에 해당 문자가 없으면 append.
        //       result.toString() 반환.
    }
}
