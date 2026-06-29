/*
 * ========================================================
 * P02_StringMethods.java - String 주요 메소드
 * ========================================================
 *
 * 【학습 목표】
 *  1. String 클래스의 검색 관련 메소드(length, charAt, indexOf,
 *     contains 등)를 올바르게 사용할 수 있다.
 *  2. 문자열 변환 메소드(substring, replace, split, trim 등)를
 *     활용하여 문자열을 가공할 수 있다.
 *  3. 조건 검사 메소드(startsWith, endsWith, isEmpty, isBlank)를
 *     실무 상황에 맞게 활용할 수 있다.
 *
 * 【핵심 개념 설명】
 *  - 인덱스(Index):
 *      문자열의 각 문자 위치를 나타내는 번호. 0부터 시작.
 *      "Hello" → H(0), e(1), l(2), l(3), o(4)
 *
 *  - substring(begin, end):
 *      begin 인덱스부터 end-1 인덱스까지 추출.
 *      "Hello".substring(1, 4) → "ell"
 *
 *  - split(regex):
 *      정규식(regex) 기준으로 문자열을 나눠 배열로 반환.
 *      "a,b,c".split(",") → ["a", "b", "c"]
 *
 *  - trim() vs strip():
 *      trim()  : ASCII 공백(스페이스, 탭 등) 제거 (Java 초기)
 *      strip() : 유니코드 공백까지 포함하여 제거 (Java 11+, 권장)
 * ========================================================
 */
public class P02_StringMethods {

    public static void main(String[] args) {

        // ====================================================
        // 문제 1: length, charAt, indexOf, lastIndexOf, contains
        // ====================================================
        /*
         * [문제 1] 문자열 검색 메소드 활용
         * -------------------------------------------------------
         * 설명:
         *   sentence = "Java is the best programming language"
         *   위 문자열을 이용해 아래 항목을 출력하세요.
         *     1) 문자열 전체 길이
         *     2) 인덱스 5번 문자 (charAt)
         *     3) "best"가 시작하는 인덱스 (indexOf)
         *     4) 'a'가 마지막으로 등장하는 인덱스 (lastIndexOf)
         *     5) "programming"이 포함되어 있는지 여부 (contains)
         *
         * 예상 출력:
         *   문자열 길이: 37
         *   인덱스 5번 문자: s
         *   "best" 시작 인덱스: 12
         *   'a' 마지막 인덱스: 34
         *   "programming" 포함 여부: true
         *
         * 힌트:
         *   - length()는 메소드이므로 () 필수 (배열의 length는 필드라 () 없음).
         *   - indexOf()가 -1을 반환하면 찾지 못한 것이다.
         *   - lastIndexOf()는 오른쪽에서부터 검색한다.
         */
        System.out.println("=== 문제 1: 검색 메소드 ===");

        String sentence = "Java is the best programming language";

        // TODO: 문자열 길이 출력
        System.out.println("문자열 길이: " + sentence.length());
        // TODO: 인덱스 5번 문자 출력
        System.out.println("인덱스 5번 문자: " + sentence.charAt(5));
        // TODO: "best"가 시작하는 인덱스 출력
        System.out.println("\"best\" 시작 인덱스: " + sentence.indexOf("best"));
        // TODO: 'a'가 마지막으로 등장하는 인덱스 출력
        System.out.println("\"a\" 마지막 인덱스: " + sentence.lastIndexOf("a"));
        // TODO: "programming" 포함 여부 출력
        System.out.println("\"programming\" 포함 여부: " + sentence.contains("programming"));

        System.out.println();

        // ====================================================
        // 문제 2: substring, replace, replaceAll, split
        // ====================================================
        /*
         * [문제 2] 문자열 변환 메소드 활용
         * -------------------------------------------------------
         * 설명:
         *   text = "apple,banana,cherry,date"
         *   위 문자열을 이용해 아래 작업을 수행하고 출력하세요.
         *     1) 0~4 인덱스 추출 (substring) → "apple"
         *     2) "banana"를 "mango"로 교체 (replace)
         *     3) 모든 모음(a, e, i, o, u)을 "*"로 교체 (replaceAll + 정규식)
         *     4) ","로 분리하여 각 항목을 한 줄씩 출력 (split)
         *
         * 예상 출력:
         *   추출: apple
         *   교체: apple,mango,cherry,date
         *   모음 제거: *ppl*,b*n*n*,ch*rry,d*t*
         *   분리:
         *     apple
         *     banana
         *     cherry
         *     date
         *
         * 힌트:
         *   - substring(0, 5)는 인덱스 0~4까지 (5는 미포함).
         *   - replaceAll("[aeiou]", "*") 처럼 정규식 문자 클래스를 사용.
         *   - split() 결과는 String[] 배열이므로 for 반복문으로 출력.
         */
        System.out.println("=== 문제 2: 변환 메소드 ===");

        String text = "apple,banana,cherry,date";

        // TODO: 인덱스 0~4 추출하여 출력

        // TODO: "banana"를 "mango"로 교체하여 출력

        // TODO: 모든 모음을 "*"로 교체하여 출력

        // TODO: ","로 분리하여 각 항목을 한 줄씩 출력

        System.out.println();

        // ====================================================
        // 문제 3: toUpperCase, toLowerCase, trim, strip
        // ====================================================
        /*
         * [문제 3] 대소문자 변환 및 공백 처리
         * -------------------------------------------------------
         * 설명:
         *   raw = "  Hello World  "  (앞뒤에 공백 포함)
         *   위 문자열을 이용해 아래 작업을 수행하고 출력하세요.
         *     1) 모두 대문자로 변환 (toUpperCase)
         *     2) 모두 소문자로 변환 (toLowerCase)
         *     3) 앞뒤 공백 제거 (trim)
         *     4) 앞뒤 공백 제거 (strip) - Java 11+
         *     5) trim() 전후 길이 비교 출력
         *
         * 예상 출력:
         *   대문자: HELLO WORLD
         *   소문자: hello world
         *   trim 결과: 'Hello World'
         *   strip 결과: 'Hello World'
         *   원본 길이: 15, trim 후 길이: 11
         *
         * 힌트:
         *   - toUpperCase(), toLowerCase()는 원본을 변경하지 않는다.
         *   - trim()과 strip() 모두 앞뒤 공백을 제거하지만
         *     strip()이 유니코드 공백도 처리하므로 더 권장된다.
         *   - 결과 앞뒤에 작은따옴표를 붙여 공백 제거 여부를 확인.
         */
        System.out.println("=== 문제 3: 대소문자 및 공백 처리 ===");

        String raw = "  Hello World  ";

        // TODO: 대문자로 변환 후 출력 (공백 제거 없이)

        // TODO: 소문자로 변환 후 출력 (공백 제거 없이)

        // TODO: trim() 결과를 작은따옴표로 감싸 출력

        // TODO: strip() 결과를 작은따옴표로 감싸 출력

        // TODO: 원본 길이와 trim() 후 길이 비교 출력

        System.out.println();

        // ====================================================
        // 문제 4: startsWith, endsWith, isEmpty, isBlank
        // ====================================================
        /*
         * [문제 4] 조건 검사 메소드 활용
         * -------------------------------------------------------
         * 설명:
         *   파일명 목록을 검사하여 각 조건에 맞는 결과를 출력하세요.
         *     fileName1 = "report_2024.pdf"
         *     fileName2 = "README.md"
         *     fileName3 = ""
         *     fileName4 = "   "
         *
         *   검사할 조건:
         *     1) fileName1이 "report"로 시작하는지
         *     2) fileName1이 ".pdf"로 끝나는지
         *     3) fileName2가 ".java"로 끝나는지
         *     4) fileName3이 비어있는지 (isEmpty)
         *     5) fileName4가 공백만 있는지 (isBlank)
         *
         * 예상 출력:
         *   "report"로 시작: true
         *   ".pdf"로 끝남: true
         *   ".java"로 끝남: false
         *   fileName3 isEmpty: true
         *   fileName4 isBlank: true
         *
         * 힌트:
         *   - startsWith(), endsWith()는 대소문자를 구분한다.
         *   - isEmpty()는 길이가 0인 경우만 true.
         *   - isBlank()는 공백만 있어도 true (Java 11+).
         */
        System.out.println("=== 문제 4: 조건 검사 메소드 ===");

        String fileName1 = "report_2024.pdf";
        String fileName2 = "README.md";
        String fileName3 = "";
        String fileName4 = "   ";

        // TODO: fileName1이 "report"로 시작하는지 출력

        // TODO: fileName1이 ".pdf"로 끝나는지 출력

        // TODO: fileName2가 ".java"로 끝나는지 출력

        // TODO: fileName3이 isEmpty인지 출력

        // TODO: fileName4가 isBlank인지 출력

        System.out.println();

        // ====================================================
        // 문제 5: 이름에서 성과 이름 분리하기
        // ====================================================
        /*
         * [문제 5] 실전 응용 - 이름 파싱
         * -------------------------------------------------------
         * 설명:
         *   fullName = "홍 길동" (성과 이름이 공백으로 구분됨)
         *   위 문자열에서 성(lastName)과 이름(firstName)을 분리하여
         *   아래 형식으로 출력하세요.
         *
         *   또한 영문 이름도 처리하세요.
         *   engName = "John Michael Smith" (이름 중간이름 성)
         *     → 이름(firstName): John, 성(lastName): Smith
         *
         * 예상 출력:
         *   전체 이름: 홍 길동
         *   성: 홍
         *   이름: 길동
         *   ---
         *   전체 이름: John Michael Smith
         *   이름: John
         *   성: Smith
         *
         * 힌트:
         *   - split(" ")으로 공백 기준 분리.
         *   - 한국 이름: parts[0]=성, parts[1]=이름.
         *   - 영문 이름: parts[0]=이름, parts[마지막]=성.
         *   - 배열의 마지막 요소: parts[parts.length - 1]
         */
        System.out.println("=== 문제 5: 이름 분리 ===");

        String fullName = "홍 길동";
        String engName = "John Michael Smith";

        // TODO: fullName을 split으로 분리하여 성과 이름 출력

        // TODO: engName을 split으로 분리하여 이름(첫 번째)과 성(마지막) 출력

    }
}
