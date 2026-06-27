/*
 * =====================================================
 * 파일명: P05_VarArgs.java
 * 주제: 가변 인자 (Variable Arguments, varargs)
 * =====================================================
 *
 * 【학습 목표】
 * 1. 가변 인자(varargs)의 문법과 동작 원리를 이해한다.
 * 2. 가변 인자와 일반 매개변수를 함께 사용하는 방법을 익힌다.
 * 3. 가변 인자를 활용하여 유연한 메소드를 설계하는 능력을 기른다.
 *
 * 【핵심 개념】
 * - 가변 인자(varargs): 개수가 정해지지 않은 매개변수를 표현하는 문법.
 *   선언 방법: 타입... 변수명 (예: int... numbers)
 *   특징:
 *     (1) 메소드 내부에서 배열처럼 사용 가능 (numbers.length, numbers[i])
 *     (2) 호출 시 인자를 0개 이상 자유롭게 전달 가능
 *     (3) 배열을 직접 전달할 수도 있음
 *     (4) 가변 인자는 반드시 매개변수 목록의 마지막에 위치해야 함
 *
 * - 가변 인자 사용 예:
 *   선언: static int sum(int... numbers) { ... }
 *   호출: sum()           → 인자 0개
 *         sum(1)          → 인자 1개
 *         sum(1, 2, 3)    → 인자 3개
 *         sum(1, 2, 3, 4, 5) → 인자 5개
 *         sum(new int[]{1, 2, 3}) → 배열 직접 전달
 *
 * - 주의사항:
 *   가변 인자는 내부적으로 배열로 처리됩니다.
 *   하나의 메소드에 가변 인자는 하나만 사용할 수 있습니다.
 *   가변 인자 매개변수는 항상 마지막에 위치해야 합니다.
 * =====================================================
 */

public class P05_VarArgs {

    // =========================================================
    // 문제 1: 가변 인자로 합계 계산
    // =========================================================
    /*
     * 【문제 설명】
     * int 타입의 가변 인자를 받아 모든 인자의 합계를 반환하는 메소드를 작성하세요.
     * 인자의 개수에 관계없이 호출 가능해야 합니다.
     *
     * 【예상 출력】
     *   sum() = 0
     *   sum(5) = 5
     *   sum(1, 2, 3) = 6
     *   sum(10, 20, 30, 40) = 100
     *   sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10) = 55
     *
     * 【힌트】
     * - static int sum(int... numbers) 로 선언하세요.
     * - numbers를 배열처럼 for문으로 순회하세요.
     * - numbers.length로 전달된 인자 개수를 확인할 수 있습니다.
     */
    static int sum(int... numbers) {
        // TODO: numbers 배열을 순회하며 모든 요소의 합계를 계산하여 반환
        int res = 0;
        for (int n : numbers){
            res += n;
        }
        return res; // 임시 반환값 (수정 필요)
    }

    // =========================================================
    // 문제 2: 가변 인자와 일반 인자 혼합
    // =========================================================
    /*
     * 【문제 설명】
     * 학생 이름(일반 인자)과 여러 과목 점수(가변 인자)를 받아
     * 학생의 이름, 점수 목록, 평균을 출력하는 메소드를 작성하세요.
     *
     * 규칙: 일반 인자는 앞에, 가변 인자는 반드시 마지막에 위치해야 합니다.
     *
     * 【예상 출력】
     * printStudentScore("홍길동", 90, 85, 92) 호출 시:
     *   학생: 홍길동
     *   점수: 90 85 92
     *   평균: 89.0
     *
     * printStudentScore("김자바", 100, 75, 88, 95) 호출 시:
     *   학생: 김자바
     *   점수: 100 75 88 95
     *   평균: 89.5
     *
     * 【힌트】
     * - static void printStudentScore(String name, int... scores)
     * - 점수는 공백으로 구분하여 출력 (for문 사용)
     * - 평균 = (점수 합계) / (점수 개수), double로 계산하세요.
     */
    static void printStudentScore(String name, int... scores) {
        // TODO: 학생 이름 출력
        System.out.println("학생: " + name);
        // TODO: 모든 점수를 공백으로 구분하여 출력
        System.out.print("점수: ");
        for (int s : scores){
            System.out.print(s + " ");
        }
        System.out.println();
        // TODO: 점수 합계 계산 후 평균 계산 및 출력
        double avg = ((double) sum(scores)/ scores.length);
        System.out.println("평균: " + avg);
    }

    // =========================================================
    // 문제 3: 가변 인자로 최대값 찾기
    // =========================================================
    /*
     * 【문제 설명】
     * int 타입의 가변 인자를 받아 가장 큰 값을 반환하는 메소드를 작성하세요.
     * 인자가 없는 경우 Integer.MIN_VALUE를 반환합니다.
     *
     * 【예상 출력】
     *   max(3, 1, 4, 1, 5, 9, 2, 6) = 9
     *   max(100, -50, 75, 200, 0) = 200
     *   max(42) = 42
     *   max() = -2147483648   (Integer.MIN_VALUE 출력)
     *
     * 【힌트】
     * - int maxVal = Integer.MIN_VALUE; 로 초기화하세요.
     * - for문으로 순회하며 현재 최대값과 비교 후 갱신하세요.
     * - 인자가 없으면 (numbers.length == 0) Integer.MIN_VALUE 반환.
     */
    static int max(int... numbers) {
        // TODO: numbers가 비어있으면 Integer.MIN_VALUE 반환
        if (numbers.length < 1) {
            return Integer.MIN_VALUE;
        }
        int res = Integer.MIN_VALUE;
        // TODO: for문으로 모든 요소를 순회하며 최대값을 찾아 반환
        for (int n : numbers){
            if (res < n){
                res = n;
            }
        }
        return res; // 임시 반환값 (수정 필요)
    }

    // =========================================================
    // 문제 4: String 가변 인자로 문장 이어붙이기
    // =========================================================
    /*
     * 【문제 설명】
     * 구분자(separator)와 여러 개의 문자열(String 가변 인자)을 받아
     * 구분자로 연결한 하나의 문자열을 반환하는 메소드를 작성하세요.
     * (Java의 String.join() 메소드와 유사)
     *
     * 【예상 출력】
     * join(", ", "사과", "바나나", "포도") → "사과, 바나나, 포도"
     * join(" - ", "Java", "Python", "C++", "JavaScript") → "Java - Python - C++ - JavaScript"
     * join("+", "1", "2", "3") → "1+2+3"
     * join(", ") → ""  (빈 문자열)
     * join(", ", "혼자") → "혼자"
     *
     * 【힌트】
     * - static String join(String separator, String... words)
     * - StringBuilder를 사용하면 효율적으로 문자열을 이어붙일 수 있습니다.
     * - 마지막 요소 뒤에는 구분자를 붙이지 않도록 주의하세요.
     * - for (int i = 0; i < words.length; i++) 형식의 인덱스 기반 for문 사용 권장.
     */
    static String join(String separator, String... words) {
        // TODO: words가 비어있으면 빈 문자열 "" 반환
        if(words.length<1){
            return "";
        }
        // TODO: StringBuilder로 각 단어를 구분자와 함께 이어붙이기
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<words.length; i++){
            sb.append(words[i]);
            if (i != words.length-1) sb.append(separator);
        }

        //       마지막 단어 뒤에는 구분자를 붙이지 않음
        // TODO: 최종 결합된 문자열 반환
        return sb.toString(); // 임시 반환값 (수정 필요)
    }

    public static void main(String[] args) {

        System.out.println("=== 문제 1: 가변 인자로 합계 계산 ===");
        // TODO: sum() 인자 없음, sum(5), sum(1,2,3), sum(10,20,30,40),
        //       sum(1,2,3,4,5,6,7,8,9,10) 각각 호출 후 결과 출력
        System.out.println("sum() = " + sum());
        System.out.println("sum(5) = " + sum(5));
        System.out.println("sum(1,2,3) = " + sum(1,2,3));
        System.out.println("sum(10,20,30,40) = " + sum(10,20,30,40));
        System.out.println("sum(1,2,3,4,5,6,7,8,9,10) = " + sum(1,2,3,4,5,6,7,8,9,10));


        System.out.println("\n=== 문제 2: 가변 인자와 일반 인자 혼합 ===");
        // TODO: printStudentScore("홍길동", 90, 85, 92) 호출
        //       printStudentScore("김자바", 100, 75, 88, 95) 호출
        System.out.println("printStudentScore(\"홍길동\", 90, 85, 92) 호출 시:");
        printStudentScore("홍길동", 90, 85, 92);
        System.out.println();

        System.out.println("printStudentScore(\"김자바\", 100, 75, 88, 95) 호출 시:");
        printStudentScore("김자바", 100, 75, 88, 95);

        System.out.println("\n=== 문제 3: 가변 인자로 최대값 찾기 ===");
        // TODO: max(3,1,4,1,5,9,2,6), max(100,-50,75,200,0),
        //       max(42), max() 각각 호출 후 결과 출력

        System.out.println("max(3, 1, 4, 1, 5, 9, 2, 6) = " + max(3, 1, 4, 1, 5, 9, 2, 6));
        System.out.println("max(100, -50, 75, 200, 0) = " + max(100, -50, 75, 200, 0));
        System.out.println("max(42) = " + max(42));
        System.out.println("max() = " + max());

        System.out.println("\n=== 문제 4: String 가변 인자로 문장 이어붙이기 ===");
        // TODO: join(", ", "사과", "바나나", "포도") 호출 후 결과 출력
        //       join(" - ", "Java", "Python", "C++", "JavaScript") 호출 후 결과 출력
        //       join("+", "1", "2", "3") 호출 후 결과 출력
        //       join(", ") 호출 후 결과 출력 (인자 없음)
        //       join(", ", "혼자") 호출 후 결과 출력
        System.out.println("join(\", \", \"사과\", \"바나나\", \"포도\") = -> " + join(", ", "사과", "바나나", "포도"));
        System.out.println("join(\" - \", \"Java\", \"Python\", \"C++\", \"JavaScript\") -> " + join(" - ", "Java", "Python", "C++", "JavaScript"));
        System.out.println("join(\"+\", \"1\", \"2\", \"3\") -> " + join("+", "1", "2", "3"));
        System.out.println("join(\", \") -> " + join(", "));
        System.out.println("join(\", \", \"혼자\") -> " + join(", ", "혼자"));
    }
}
