/*
 * ============================================================
 * 파일명: P02_ComparisonOperators.java
 * 주제: 비교 연산자 (==, !=, >, <, >=, <=)
 * ============================================================
 *
 * [학습목표]
 * 1. 비교 연산자의 종류와 각각의 동작 방식을 이해한다.
 * 2. 비교 연산자의 결과는 항상 boolean(true/false)임을 인지한다.
 * 3. 기본형(primitive) 비교에서의 == 와 참조형(String 등)에서의 == 차이를 이해한다.
 *
 * [핵심개념]
 * - 비교 연산자: 두 값을 비교하여 boolean 결과를 반환
 *     ==  : 두 값이 같으면 true
 *     !=  : 두 값이 다르면 true
 *     >   : 왼쪽이 크면 true
 *     <   : 왼쪽이 작으면 true
 *     >=  : 왼쪽이 크거나 같으면 true
 *     <=  : 왼쪽이 작거나 같으면 true
 * - 기본형(int, double 등)의 == : 값(value) 자체를 비교
 * - 참조형(String 등)의 == : 메모리 주소(참조)를 비교
 *     → String 내용 비교는 반드시 .equals() 메소드를 사용해야 함
 * - 비교 결과는 boolean 변수에 저장 가능
 *     예) boolean isEqual = (a == b);
 * ============================================================
 */

import java.util.Scanner;

public class P02_ComparisonOperators {

    public static void main(String[] args) {
        System.out.println("=== 비교 연산자 연습 ===\n");

        problem1();
        problem2();
        problem3();
        problem4();
    }

    // ============================================================
    // 문제 1: 두 정수 비교 결과를 boolean 변수에 저장 후 출력
    // ============================================================
    /*
     * [문제 설명]
     * 두 정수를 입력받아 6가지 비교 연산자(==, !=, >, <, >=, <=)의
     * 결과를 각각 boolean 변수에 저장하고 출력하세요.
     *
     * [예상 출력 예시]
     * 첫 번째 수: 5
     * 두 번째 수: 3
     * 5 == 3 : false
     * 5 != 3 : true
     * 5 >  3 : true
     * 5 <  3 : false
     * 5 >= 3 : true
     * 5 <= 3 : false
     *
     * [힌트]
     * - boolean isEqual = (a == b);
     * - System.out.printf("%d == %d : %b%n", a, b, isEqual);
     */
    static void problem1() {
        System.out.println("--- 문제1: 두 정수 비교 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 두 정수를 입력받으세요 (변수명 예: a, b)
        System.out.print("첫 번째 수: ");
        int a = sc.nextInt();
        System.out.print("두 번째 수: ");
        int b = sc.nextInt();

        // TODO: == 비교 결과를 boolean 변수에 저장하세요
        boolean isEqual = a == b;
        // TODO: != 비교 결과를 boolean 변수에 저장하세요
        boolean isNotEqual = a != b;
        // TODO: >  비교 결과를 boolean 변수에 저장하세요
        boolean isBigger = a > b;
        // TODO: <  비교 결과를 boolean 변수에 저장하세요
        boolean isSmaller = a < b;
        // TODO: >= 비교 결과를 boolean 변수에 저장하세요
        boolean isEqualBigger = a >= b;
        // TODO: <= 비교 결과를 boolean 변수에 저장하세요
        boolean isEqualSmaller = a <= b;

        // TODO: 6가지 비교 결과를 모두 출력하세요
        // 5 == 3 : false
        System.out.println(a + " == " + b + " : " + isEqual);
        System.out.println(a + " != " + b + " : " + isNotEqual);
        System.out.println(a + " > " + b + " : " + isBigger);
        System.out.println(a + " < " + b + " : " + isSmaller);
        System.out.println(a + " >= " + b + " : " + isEqualBigger);
        System.out.println(a + " <= " + b + " : " + isEqualSmaller);

        System.out.println();
    }

    // ============================================================
    // 문제 2: 세 수 중 가장 큰 수 찾기 (비교 연산자만 사용)
    // ============================================================
    /*
     * [문제 설명]
     * 세 정수를 입력받아 그 중 가장 큰 수를 찾아 출력하세요.
     * Math.max() 사용 금지 — 비교 연산자(>)만 사용하세요.
     * 헬퍼 메소드 findMax(int a, int b, int c)를 완성하세요.
     *
     * [예상 출력 예시]
     * 첫 번째 수: 7
     * 두 번째 수: 3
     * 세 번째 수: 9
     * 세 수: 7, 3, 9
     * 가장 큰 수: 9
     *
     * [힌트]
     * - int max = a;
     * - if (b > max) max = b;
     * - if (c > max) max = c;
     */
    static void problem2() {
        System.out.println("--- 문제2: 세 수 중 최댓값 찾기 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 세 정수를 입력받으세요
        System.out.print("첫 번째 수: ");
        int a = sc.nextInt();
        System.out.print("두 번째 수: ");
        int b = sc.nextInt();
        System.out.print("세 번째 수: ");
        int c = sc.nextInt();

        // TODO: findMax 헬퍼 메소드를 호출하여 최댓값을 구하세요
        int foundMax = findMax(a, b, c);
        // TODO: 입력한 세 수와 최댓값을 출력하세요
        System.out.println("세 수: " + a + ", " + b + ", " + c);
        System.out.println("가장 큰 수: " + foundMax);

        System.out.println();
    }

    // ============================================================
    // 문제 3: 학점 기준 비교 (점수가 특정 범위에 해당하는지 확인)
    // ============================================================
    /*
     * [문제 설명]
     * 0~100 사이의 점수를 입력받아 해당 점수가 각 학점 범위에 해당하는지
     * boolean 비교 결과와 함께 출력하세요.
     *
     * 학점 기준:
     *   A: 90 이상 100 이하
     *   B: 80 이상 90 미만
     *   C: 70 이상 80 미만
     *   D: 60 이상 70 미만
     *   F: 60 미만
     *
     * [예상 출력 예시]
     * 점수 입력 (0~100): 85
     * 입력 점수: 85점
     * A학점(90~100) 해당 여부: false
     * B학점(80~89) 해당 여부: true   ← 85 >= 80 && 85 < 90
     * C학점(70~79) 해당 여부: false
     * D학점(60~69) 해당 여부: false
     * F학점(60미만) 해당 여부: false
     * 최종 학점: B
     *
     * [힌트]
     * - 범위 비교: (score >= 90) && (score <= 100)
     * - 각 학점 여부를 boolean 변수에 저장하세요
     * - 헬퍼 메소드 getGrade(int score)를 활용하세요
     */
    static void problem3() {
        System.out.println("--- 문제3: 학점 범위 비교 ---");

        Scanner sc = new Scanner(System.in);

        // TODO: 0~100 사이 점수를 입력받으세요
        System.out.print("점수 입력 (0~100): ");
        int a = sc.nextInt();
        System.out.println("입력 점수: " + a + "점");
        // TODO: 각 학점 범위에 해당하는지 boolean 변수에 저장하세요
         boolean isA = (a >= 90) && (a <= 100);
         boolean isB = (a >= 80) && (a < 90);
         boolean isC = (a >= 70) && (a < 80);
         boolean isD = (a >= 60) && (a < 70);
         boolean isF = (a < 60);

        // TODO: 각 학점 여부를 출력하세요
        System.out.println("A학점(90~100) 해당 여부: " + isA);
        System.out.println("B학점(80~89) 해당 여부: " + isB);
        System.out.println("C학점(70~80) 해당 여부: " + isC);
        System.out.println("D학점(60~70) 해당 여부: " + isD);
        System.out.println("F학점(60미만) 해당 여부: " + isF);

        // TODO: getGrade 헬퍼 메소드로 최종 학점을 구하고 출력하세요
        System.out.println("최종 학점: " + getGrade(a));

        System.out.println();
    }

    // ============================================================
    // 문제 4: String 비교 (== vs equals 차이 확인)
    // ============================================================
    /*
     * [문제 설명]
     * String 비교에서 == 연산자와 .equals() 메소드의 차이를 실험으로 확인하세요.
     *
     * 실험 A: 리터럴 문자열 비교
     *   String s1 = "hello";
     *   String s2 = "hello";
     *   → == 와 equals() 비교 결과가 어떻게 다른가?
     *
     * 실험 B: new 키워드로 생성한 문자열 비교
     *   String s3 = new String("hello");
     *   String s4 = new String("hello");
     *   → == 와 equals() 비교 결과가 어떻게 다른가?
     *
     * 실험 C: 리터럴과 new 객체 비교
     *   String s5 = "hello";
     *   String s6 = new String("hello");
     *   → == 와 equals() 비교 결과가 어떻게 다른가?
     *
     * [예상 출력 예시]
     * [실험 A - 리터럴 vs 리터럴]
     * s1 == s2   : true   ← 같은 String Pool 주소 참조
     * s1.equals(s2): true
     *
     * [실험 B - new vs new]
     * s3 == s4   : false  ← 서로 다른 힙 메모리 주소
     * s3.equals(s4): true
     *
     * [실험 C - 리터럴 vs new]
     * s5 == s6   : false  ← 리터럴(Pool)과 힙(new)은 주소 다름
     * s5.equals(s6): true
     *
     * [힌트]
     * - == : 두 참조변수가 같은 객체를 가리키는지(주소 비교)
     * - .equals() : 문자열 내용(값)이 같은지 비교
     * - 자바 String Pool: 리터럴 문자열은 풀에서 재사용
     * - new String(): 항상 힙에 새 객체 생성
     *
     * [주석 필수 포함 내용]
     * // == 는 참조(주소)를 비교합니다.
     * // .equals()는 문자열의 내용(값)을 비교합니다.
     * // 실무에서 String 내용 비교 시 반드시 .equals()를 사용하세요!
     */
    static void problem4() {
        System.out.println("--- 문제4: String 비교 (== vs equals) ---");

        // 실험 A: 리터럴 문자열 비교
        System.out.println("[실험 A - 리터럴 vs 리터럴]");
        String s1 = "hello";
        String s2 = "hello";
        // == 는 참조(주소)를 비교합니다.
        // .equals()는 문자열의 내용(값)을 비교합니다.
        // TODO: s1 == s2 결과를 출력하세요
        System.out.println("s1 == s2   : " + (s1 == s2));
        // TODO: s1.equals(s2) 결과를 출력하세요
        System.out.println("s1.equals(s2): " + (s1.equals(s2)));
        System.out.println();

        // 실험 B: new 키워드로 생성한 문자열 비교
        System.out.println("[실험 B - new String vs new String]");
        String s3 = new String("hello");
        String s4 = new String("hello");
        // new String()은 항상 힙 메모리에 새 객체를 생성합니다.
        // 따라서 s3와 s4는 내용이 같아도 서로 다른 주소를 가집니다.
        // TODO: s3 == s4 결과를 출력하세요
        System.out.println("s3 == s4   : " + (s3 == s4));
        // TODO: s3.equals(s4) 결과를 출력하세요
        System.out.println("s3.equals(s4): " + (s3.equals(s4)));
        System.out.println();

        // 실험 C: 리터럴과 new 객체 비교
        System.out.println("[실험 C - 리터럴 vs new String]");
        String s5 = "hello";
        String s6 = new String("hello");
        // 실무에서 String 내용 비교 시 반드시 .equals()를 사용하세요!
        // TODO: s5 == s6 결과를 출력하세요
        System.out.println("s5 == s6   : " + (s5 == s6));
        // TODO: s5.equals(s6) 결과를 출력하세요
        System.out.println("s5.equals(s6): " + (s5.equals(s6)));
        System.out.println();
    }

    // ============================================================
    // 헬퍼 메소드 시그니처 (내용을 직접 구현하세요)
    // ============================================================

    /**
     * 세 정수 중 가장 큰 값을 반환합니다.
     * @param a 첫 번째 정수
     * @param b 두 번째 정수
     * @param c 세 번째 정수
     * @return 세 수 중 최댓값
     */
    static int findMax(int a, int b, int c) {
        // TODO: 비교 연산자(>)만 사용하여 최댓값을 찾아 반환하세요
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }

    /**
     * 점수에 해당하는 학점 문자를 반환합니다.
     * @param score 0~100 사이의 점수
     * @return 학점 문자 ("A", "B", "C", "D", "F")
     */
    static String getGrade(int score) {
        // TODO: 비교 연산자를 사용하여 학점을 계산하고 반환하세요
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";

        // TODO: 올바른 학점 문자를 반환하도록 수정하세요
    }
}
