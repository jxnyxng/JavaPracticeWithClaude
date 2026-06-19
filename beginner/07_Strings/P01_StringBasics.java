/*
 * ========================================================
 * P01_StringBasics.java - 문자열 기본
 * ========================================================
 *
 * 【학습 목표】
 *  1. String 리터럴과 new String()의 차이를 이해하고
 *     == 연산자와 equals() 메소드의 차이를 설명할 수 있다.
 *  2. 문자열의 불변성(Immutability) 개념을 이해하고
 *     새 문자열이 생성되는 과정을 설명할 수 있다.
 *  3. 문자열 연결 방법(+, concat)과 null/빈 문자열 처리를
 *     안전하게 다룰 수 있다.
 *
 * 【핵심 개념 설명】
 *  - String Pool (문자열 풀):
 *      JVM은 문자열 리터럴을 힙 메모리의 특별한 영역(String Pool)에
 *      저장한다. 동일한 리터럴은 같은 객체를 재사용한다.
 *
 *  - == vs equals():
 *      ==  : 두 참조(reference)가 같은 객체를 가리키는지 비교 (주소 비교)
 *      equals() : 두 문자열의 내용(값)이 같은지 비교 (값 비교)
 *
 *  - 불변성(Immutability):
 *      String 객체는 한 번 생성되면 내용을 변경할 수 없다.
 *      문자열을 수정하면 기존 객체가 변경되는 것이 아니라
 *      새로운 String 객체가 생성된다.
 *
 *  - null vs 빈 문자열(""):
 *      null    : 참조 자체가 없음 (객체 없음)
 *      ""      : 객체는 존재하지만 내용이 없는 빈 문자열
 * ========================================================
 */
public class P01_StringBasics {

    public static void main(String[] args) {

        // ====================================================
        // 문제 1: String 리터럴 vs new String() - == vs equals
        // ====================================================
        /*
         * [문제 1] String 동등성 비교
         * -------------------------------------------------------
         * 설명:
         *   세 가지 방법으로 "hello" 문자열을 생성하고 == 와 equals()로
         *   비교한 결과를 출력하세요.
         *     - str1: 리터럴 방식  ("hello")
         *     - str2: 리터럴 방식  ("hello")
         *     - str3: new String() ("hello")
         *
         * 예상 출력:
         *   str1 == str2 : true    (같은 String Pool 객체)
         *   str1 == str3 : false   (str3는 힙에 새 객체 생성)
         *   str1.equals(str3) : true   (내용은 동일)
         *   str3.equals(str1) : true   (내용은 동일)
         *
         * 힌트:
         *   - 리터럴로 생성한 같은 값의 String은 String Pool에서
         *     동일한 객체를 참조한다.
         *   - new String()은 항상 힙에 새 객체를 생성한다.
         *   - 문자열 값 비교에는 항상 equals()를 사용하는 것이 좋다.
         */
        System.out.println("=== 문제 1: == vs equals() ===");

        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");

        // TODO: str1 == str2 결과를 출력하세요.

        // TODO: str1 == str3 결과를 출력하세요.

        // TODO: str1.equals(str3) 결과를 출력하세요.

        // TODO: str3.equals(str1) 결과를 출력하세요.

        System.out.println();

        // ====================================================
        // 문제 2: 문자열 불변성(Immutability) 이해
        // ====================================================
        /*
         * [문제 2] 문자열 불변성 확인
         * -------------------------------------------------------
         * 설명:
         *   아래 코드의 실행 결과를 예측하고, 왜 그런 결과가 나오는지
         *   주석으로 설명한 뒤 출력하세요.
         *     String original = "Java";
         *     String modified = original.toUpperCase();  // 새 객체 생성
         *     original에 " Programming"을 연결하는 코드 작성
         *
         *   original 변수가 바뀌었는지, 원래 "Java" 객체가 변했는지 확인.
         *
         * 예상 출력:
         *   original 변수 값: Java Programming
         *   modified 값: JAVA
         *   original == modified : false
         *
         * 힌트:
         *   - toUpperCase()는 원본을 바꾸지 않고 새 String을 반환한다.
         *   - original += " Programming" 은 original이 새 객체를 참조하게 만든다.
         *   - 기존 "Java" 객체는 변경되지 않는다 (불변성).
         */
        System.out.println("=== 문제 2: 문자열 불변성 ===");

        String original = "Java";
        String modified = original.toUpperCase();

        // TODO: original에 " Programming"을 연결하여 original 변수에 저장

        // TODO: original 변수 값 출력 ("Java Programming" 이어야 함)

        // TODO: modified 값 출력 ("JAVA" 이어야 함)

        // TODO: original == modified 결과 출력

        System.out.println();

        // ====================================================
        // 문제 3: 문자열 연결 (+, concat)
        // ====================================================
        /*
         * [문제 3] 다양한 문자열 연결 방법
         * -------------------------------------------------------
         * 설명:
         *   firstName = "길동", lastName = "홍" 을 이용해
         *   세 가지 방법으로 "홍길동"을 만들어 출력하세요.
         *     방법1: + 연산자 사용
         *     방법2: concat() 메소드 사용
         *     방법3: String.join() 또는 직접 이어붙이기
         *
         *   또한 숫자(int)와 문자열을 + 로 연결할 때의 주의사항을 확인하세요.
         *     예: "나이: " + 20 + 5   vs   "나이: " + (20 + 5)
         *
         * 예상 출력:
         *   방법1 (+): 홍길동
         *   방법2 (concat): 홍길동
         *   방법3 (join): 홍길동
         *   주의: 나이: 205
         *   올바름: 나이: 25
         *
         * 힌트:
         *   - + 연산자는 왼쪽에서 오른쪽으로 순서대로 처리된다.
         *   - concat()은 null을 허용하지 않는다 (NullPointerException 발생).
         *   - String.join(구분자, 문자열들)로 연결할 수 있다.
         */
        System.out.println("=== 문제 3: 문자열 연결 ===");

        String firstName = "길동";
        String lastName = "홍";

        // TODO: + 연산자로 성+이름을 연결하여 출력 ("방법1 (+): 홍길동")

        // TODO: concat() 메소드로 연결하여 출력 ("방법2 (concat): 홍길동")

        // TODO: String.join() 으로 연결하여 출력 ("방법3 (join): 홍길동")

        // TODO: "나이: " + 20 + 5 를 출력 (주의: 결과가 "205"임을 확인)

        // TODO: "나이: " + (20 + 5) 를 출력 (올바른 결과: "25")

        System.out.println();

        // ====================================================
        // 문제 4: null 체크와 빈 문자열 체크
        // ====================================================
        /*
         * [문제 4] 안전한 null 및 빈 문자열 처리
         * -------------------------------------------------------
         * 설명:
         *   아래 4가지 문자열에 대해 null 여부, 빈 문자열 여부,
         *   공백만 있는지 여부를 각각 출력하세요.
         *     s1 = null
         *     s2 = ""
         *     s3 = "   "   (공백만 있음)
         *     s4 = "hello"
         *
         *   isNullOrEmpty(String s) 헬퍼 메소드를 완성하여 사용하세요.
         *   isNullOrBlank(String s) 헬퍼 메소드를 완성하여 사용하세요.
         *
         * 예상 출력:
         *   s1(null):    isNullOrEmpty=true,  isNullOrBlank=true
         *   s2(""):      isNullOrEmpty=true,  isNullOrBlank=true
         *   s3("   "):   isNullOrEmpty=false, isNullOrBlank=true
         *   s4("hello"): isNullOrEmpty=false, isNullOrBlank=false
         *
         * 힌트:
         *   - null 체크는 반드시 str == null 로 먼저 해야 한다.
         *   - isEmpty()  : 문자열 길이가 0인지 확인 (공백은 false)
         *   - isBlank()  : 문자열이 비어있거나 공백만 있으면 true (Java 11+)
         *   - trim()     : 앞뒤 공백 제거 후 isEmpty()로 확인 (Java 8 이하 호환)
         */
        System.out.println("=== 문제 4: null 및 빈 문자열 체크 ===");

        String s1 = null;
        String s2 = "";
        String s3 = "   ";
        String s4 = "hello";

        // TODO: 각 문자열에 대해 isNullOrEmpty()와 isNullOrBlank() 결과를 출력하세요.
        // 출력 형식: "s1(null):    isNullOrEmpty=true,  isNullOrBlank=true"

    }

    // ====================================================
    // 헬퍼 메소드 (내용을 직접 구현하세요)
    // ====================================================

    /**
     * 문자열이 null이거나 빈 문자열("")인지 확인한다.
     * @param str 검사할 문자열
     * @return null이거나 빈 문자열이면 true, 그렇지 않으면 false
     */
    static boolean isNullOrEmpty(String str) {
        // TODO: null이거나 isEmpty()이면 true 반환
        return false;
    }

    /**
     * 문자열이 null이거나 공백만 포함하는지 확인한다.
     * @param str 검사할 문자열
     * @return null이거나 공백만 있으면 true, 그렇지 않으면 false
     */
    static boolean isNullOrBlank(String str) {
        // TODO: null이거나 trim().isEmpty()이면 true 반환
        //       (또는 Java 11+ isBlank() 사용)
        return false;
    }
}
