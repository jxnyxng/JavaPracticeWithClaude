/*
 * =====================================================
 * 파일명: P03_StaticMembers.java
 * 주제: static 멤버 (Static Members)
 * =====================================================
 *
 * [학습목표]
 * 1. static 키워드의 의미를 이해하고, 클래스 수준 멤버와 인스턴스 수준 멤버의 차이를 설명한다.
 * 2. static 변수와 메소드를 활용하여 유틸리티 클래스 및 공유 상태를 구현한다.
 * 3. 싱글톤(Singleton) 패턴을 static을 이용하여 구현하고 그 원리를 이해한다.
 *
 * [핵심개념]
 * - static 변수: 클래스에 하나만 존재하며 모든 인스턴스가 공유한다. 클래스 로딩 시 메모리에 할당된다.
 * - static 메소드: 객체 생성 없이 클래스명.메소드명()으로 호출 가능하다. this 사용 불가.
 * - 인스턴스 멤버: 객체마다 별도로 존재한다. static 메소드 내에서 직접 접근 불가.
 * - 싱글톤 패턴: static을 이용해 클래스의 인스턴스를 오직 하나만 생성하도록 보장하는 디자인 패턴.
 * =====================================================
 */
public class P03_StaticMembers {

    // ================================================================
    // 문제 1: static 카운터로 객체 생성 수 추적
    // ================================================================
    /*
     * [문제 1] static 변수로 생성된 객체 수 추적하기
     * -------------------------------------------------
     * 설명:
     *   Robot 클래스에 static 카운터를 추가하여,
     *   지금까지 생성된 Robot 객체의 수를 추적합니다.
     *   객체가 생성될 때마다 카운터가 자동으로 증가해야 합니다.
     *
     * 요구사항:
     *   - Robot 클래스 필드:
     *       static int totalCount  → 생성된 총 로봇 수 (클래스 공유)
     *       int id                 → 각 로봇 고유 번호
     *       String name            → 로봇 이름
     *   - 생성자: totalCount를 1 증가시키고, id = totalCount 로 설정
     *   - static 메소드: static int getTotalCount() → totalCount 반환
     *   - 인스턴스 메소드: void introduce() → id와 name 출력
     *   - main()에서 Robot 객체 4개 생성 후 각 객체 introduce() 및 총 수 출력
     *
     * 예상 출력:
     *   Robot 생성 중...
     *   [로봇 #1] 이름: 알파
     *   [로봇 #2] 이름: 베타
     *   [로봇 #3] 이름: 감마
     *   [로봇 #4] 이름: 델타
     *   현재까지 생성된 로봇 수: 4
     *
     * 힌트:
     *   - static 변수는 모든 객체가 공유하므로 카운터로 활용 가능
     *   - 생성자(constructor)에서 static 변수에 접근하여 증가
     *   - 클래스명으로 접근: Robot.getTotalCount()
     */

    // TODO: Robot 클래스를 파일 하단에 선언하세요


    // ================================================================
    // 문제 2: static 유틸리티 메소드
    // ================================================================
    /*
     * [문제 2] Math 클래스처럼 static 유틸리티 메소드 만들기
     * -------------------------------------------------
     * 설명:
     *   Java의 Math 클래스처럼, 객체 생성 없이 바로 사용할 수 있는
     *   유틸리티 메소드들을 가진 MathUtils 클래스를 만듭니다.
     *
     * 요구사항:
     *   MathUtils 클래스에 다음 static 메소드 구현:
     *   - static int square(int n)         → n의 제곱 반환
     *   - static double circleArea(double r) → 원의 넓이 반환 (π * r * r)
     *   - static int max(int a, int b)      → 두 수 중 큰 값 반환
     *   - static int factorial(int n)       → n! 반환 (반복문 사용)
     *   - static boolean isPrime(int n)     → n이 소수이면 true 반환
     *   - main()에서 각 메소드를 MathUtils.메소드명()으로 호출하여 결과 출력
     *
     * 예상 출력:
     *   square(7) = 49
     *   circleArea(5.0) = 78.53981633974483
     *   max(12, 37) = 37
     *   factorial(6) = 720
     *   isPrime(17) = true
     *   isPrime(20) = false
     *
     * 힌트:
     *   - static 메소드는 객체 없이 호출: MathUtils.square(7)
     *   - Math.PI 상수 활용 가능
     *   - factorial은 반복문(for)을 이용하여 구현
     *   - 소수 판별: 2부터 √n까지 나누어 떨어지는 수가 없으면 소수
     */

    // TODO: MathUtils 클래스를 파일 하단에 선언하세요


    // ================================================================
    // 문제 3: static vs 인스턴스 멤버 차이
    // ================================================================
    /*
     * [문제 3] static 멤버와 인스턴스 멤버의 차이 실험
     * -------------------------------------------------
     * 설명:
     *   School 클래스를 이용하여 static 멤버(학교명)는 모든 객체가 공유하고,
     *   인스턴스 멤버(학생명, 학번)는 각 객체마다 별도임을 확인합니다.
     *
     * 요구사항:
     *   - School 클래스:
     *       static String schoolName  → 학교 이름 (초기값: "자바 대학교")
     *       String studentName        → 학생 이름 (인스턴스마다 다름)
     *       int studentId             → 학번 (인스턴스마다 다름)
     *   - 메소드: void printCard() → 학교명, 학생명, 학번 출력
     *   - main()에서:
     *     (1) School 객체 3개 생성, 각각 다른 studentName, studentId 할당
     *     (2) 모든 객체의 printCard() 출력
     *     (3) School.schoolName = "코딩 대학교" 로 변경
     *     (4) 다시 모든 객체의 printCard() 출력 → 3개 모두 학교명이 바뀜
     *
     * 예상 출력:
     *   [변경 전]
     *   자바 대학교 - 김철수 (20230001)
     *   자바 대학교 - 이영희 (20230002)
     *   자바 대학교 - 박지민 (20230003)
     *   [학교명 변경 후]
     *   코딩 대학교 - 김철수 (20230001)
     *   코딩 대학교 - 이영희 (20230002)
     *   코딩 대학교 - 박지민 (20230003)
     *
     * 힌트:
     *   - static 변수를 변경하면 해당 클래스의 모든 인스턴스에 즉시 반영
     *   - static 메소드 내에서 인스턴스 변수(studentName)에 직접 접근 불가
     */

    // TODO: School 클래스를 파일 하단에 선언하세요


    // ================================================================
    // 문제 4: 싱글톤 패턴 구현
    // ================================================================
    /*
     * [문제 4] static을 이용한 싱글톤 패턴 구현
     * -------------------------------------------------
     * 설명:
     *   싱글톤(Singleton) 패턴은 클래스의 인스턴스가 프로그램 전체에서
     *   오직 하나만 존재하도록 보장하는 디자인 패턴입니다.
     *   데이터베이스 연결, 설정 관리자 등에 자주 사용됩니다.
     *
     * 요구사항:
     *   - AppConfig 클래스 (싱글톤):
     *       private static AppConfig instance  → 유일한 인스턴스 저장
     *       private String appName             → 앱 이름
     *       private String version             → 버전
     *       private AppConfig()                → private 생성자 (외부 생성 차단)
     *       static AppConfig getInstance()     → 인스턴스 반환 (없으면 생성, 있으면 기존 반환)
     *       void showConfig()                  → 설정 정보 출력
     *   - main()에서:
     *     (1) AppConfig config1 = AppConfig.getInstance()
     *     (2) AppConfig config2 = AppConfig.getInstance()
     *     (3) config1 == config2 출력 → true (같은 객체)
     *     (4) config1.showConfig() 출력
     *
     * 예상 출력:
     *   config1 == config2 : true  ← 동일한 인스턴스
     *   === 앱 설정 ===
     *   앱 이름: 자바 학습 앱
     *   버전: 1.0.0
     *
     * 힌트:
     *   - 생성자를 private으로 선언하면 외부에서 new AppConfig() 불가
     *   - getInstance() 내에서 instance == null 이면 new AppConfig() 호출
     *   - instance != null 이면 기존 instance 반환
     *   - 이 방식을 "Lazy Initialization" 이라고 함
     */

    // TODO: AppConfig 클래스를 파일 하단에 선언하세요


    // ================================================================
    // main 메소드 - 여기서 모든 문제를 테스트하세요
    // ================================================================
    public static void main(String[] args) {

        System.out.println("========== 문제 1: static 카운터 ==========");
        // TODO: Robot 객체 4개 생성 후 introduce() 호출, 총 카운터 출력

        System.out.println("\n========== 문제 2: static 유틸리티 메소드 ==========");
        // TODO: MathUtils의 각 메소드를 호출하여 결과 출력

        System.out.println("\n========== 문제 3: static vs 인스턴스 멤버 ==========");
        // TODO: School 객체 3개 생성 → 출력 → 학교명 변경 → 다시 출력

        System.out.println("\n========== 문제 4: 싱글톤 패턴 ==========");
        // TODO: AppConfig 인스턴스 2개 획득 후 동일성 비교 및 설정 출력
    }
}

// ================================================================
// 헬퍼 클래스 선언 영역
// ================================================================

// TODO: 문제 1 - Robot 클래스 선언
class Robot {
    // TODO: static 카운터 필드와 인스턴스 필드 선언

    // TODO: 생성자 작성 (totalCount 증가, id 설정)
    Robot(String name) {
        // TODO
    }

    // TODO: static 메소드 getTotalCount() 작성
    static int getTotalCount() {
        // TODO
        return 0;
    }

    // TODO: introduce() 메소드 작성
    void introduce() {
        // TODO
    }
}

// TODO: 문제 2 - MathUtils 클래스 선언
class MathUtils {
    // TODO: square() 메소드 작성
    static int square(int n) {
        // TODO
        return 0;
    }

    // TODO: circleArea() 메소드 작성
    static double circleArea(double r) {
        // TODO
        return 0.0;
    }

    // TODO: max() 메소드 작성
    static int max(int a, int b) {
        // TODO
        return 0;
    }

    // TODO: factorial() 메소드 작성
    static int factorial(int n) {
        // TODO
        return 0;
    }

    // TODO: isPrime() 메소드 작성
    static boolean isPrime(int n) {
        // TODO
        return false;
    }
}

// TODO: 문제 3 - School 클래스 선언
class School {
    // TODO: static 필드 schoolName과 인스턴스 필드 선언

    // TODO: printCard() 메소드 작성
    void printCard() {
        // TODO
    }
}

// TODO: 문제 4 - AppConfig 싱글톤 클래스 선언
class AppConfig {
    // TODO: private static instance 필드 선언
    // TODO: private 인스턴스 필드 (appName, version) 선언

    // TODO: private 생성자 작성 (appName, version 초기값 설정)
    private AppConfig() {
        // TODO
    }

    // TODO: getInstance() 정적 메소드 작성 (Lazy Initialization)
    static AppConfig getInstance() {
        // TODO
        return null;
    }

    // TODO: showConfig() 메소드 작성
    void showConfig() {
        // TODO
    }
}
