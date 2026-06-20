/*
 * ============================================================
 * 파일명: P04_Constants.java
 * 주제: 상수 (final 키워드)
 * ============================================================
 *
 * [학습목표]
 * 1. final 키워드를 사용하여 상수를 선언하고 활용할 수 있다.
 * 2. 상수를 활용하여 프로그램 설정값을 명확하게 표현할 수 있다.
 * 3. 상수를 이용한 단위 변환 프로그램을 작성할 수 있다.
 *
 * [핵심개념]
 * - 상수(Constant): 한 번 값이 정해지면 변경할 수 없는 변수
 * - final 키워드: 변수 앞에 final을 붙이면 최초 초기화 이후 값 변경 불가
 * - 명명 규칙: 상수는 관례적으로 모두 대문자와 언더스코어(_)로 작성 (예: MAX_VALUE)
 * - 클래스 상수: static final로 선언하면 객체 생성 없이 클래스명.상수명으로 접근 가능
 * - 상수 사용 이유:
 *   1. 매직 넘버(Magic Number) 방지 - 숫자 대신 의미 있는 이름 사용
 *   2. 코드 가독성 향상
 *   3. 값 변경 시 한 곳만 수정하면 됨 (유지보수 용이)
 * ============================================================
 */
public class P04_Constants {

    // ============================================================
    // 클래스 상수 선언 영역 (static final)
    // ============================================================

    // TODO: static final double 상수 PI를 선언하고 3.141592653589793으로 초기화하세요.
    static final double PI = 3.141592653589793;
    // TODO: static final int 상수 MAX_USERS를 선언하고 100으로 초기화하세요.
    static final int MAX_USERS = 100;
    // TODO: static final String 상수 APP_VERSION을 선언하고 "1.0.0"으로 초기화하세요.
    static final String APP_VERSION = "1.0.0";
    // TODO: static final String 상수 APP_NAME을 선언하고 "자바 연습 프로그램"으로 초기화하세요.
    static final String APP_NAME = "자바 연습 프로그램";
    // TODO: static final double 상수 KM_TO_MILE을 선언하고 0.621371로 초기화하세요.
    //       (1킬로미터 = 0.621371마일)
    static final double KM_TO_MILE = 0.621371;
    // TODO: static final double 상수 MILE_TO_KM을 선언하고 1.60934로 초기화하세요.
    //       (1마일 = 1.60934킬로미터)
    static final double MILE_TO_KM = 1.60934;
    // TODO: static final double 상수 KG_TO_POUND을 선언하고 2.20462로 초기화하세요.
    //       (1킬로그램 = 2.20462파운드)
    static final double KG_TO_POUND = 2.20462;

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: final로 PI를 사용한 원의 넓이 계산
        // ============================================================
        /*
         * [문제 설명]
         * 위에 선언한 상수 PI를 사용하여 반지름이 주어진 원의 넓이와 둘레를 계산하고 출력하시오.
         * 원의 넓이 = PI * 반지름 * 반지름
         * 원의 둘레 = 2 * PI * 반지름
         *
         * [예상 출력]
         * ===== 문제 1: 원의 넓이와 둘레 계산 =====
         * 반지름: 5.0
         * PI 값: 3.141592653589793
         * 원의 넓이: 78.53981633974483
         * 원의 둘레: 31.41592653589793
         *
         * [힌트]
         * - 상수 PI는 이미 클래스 상단에 선언되어 있습니다.
         * - double형 변수 radius를 선언하고 5.0으로 초기화하세요.
         * - 넓이 공식: area = PI * radius * radius
         * - 둘레 공식: circumference = 2 * PI * radius
         */
        System.out.println("===== 문제 1: 원의 넓이와 둘레 계산 =====");

        // TODO: double형 변수 radius를 선언하고 5.0으로 초기화하세요.
        double radius = 5.0;
        // TODO: double형 변수 area에 원의 넓이를 계산하여 저장하세요. (PI * radius * radius)
        double area = PI * radius * radius;
        // TODO: double형 변수 circumference에 원의 둘레를 계산하여 저장하세요. (2 * PI * radius)
        double circumference = 2 * PI * radius;
        // TODO: 반지름, PI 값, 원의 넓이, 원의 둘레를 출력하세요.
        System.out.println("반지름: " + radius);
        System.out.println("PI 값: " + PI);
        System.out.println("원의 넓이: " + area);
        System.out.println("원의 둘레: " + circumference);

        // ============================================================
        // 문제 2: final로 프로그램 설정값 정의
        // ============================================================
        /*
         * [문제 설명]
         * 위에 선언한 클래스 상수들(MAX_USERS, APP_VERSION, APP_NAME)을 사용하여
         * 프로그램 정보와 설정값을 출력하시오.
         *
         * [예상 출력]
         * ===== 문제 2: 프로그램 설정값 =====
         * 프로그램 이름: 자바 연습 프로그램
         * 버전: 1.0.0
         * 최대 사용자 수: 100명
         * 현재 사용자 수: 42명
         * 추가 가능 인원: 58명
         *
         * [힌트]
         * - 상수는 변경할 수 없으므로 현재 사용자 수는 일반 변수로 선언합니다.
         * - 추가 가능 인원 = MAX_USERS - 현재 사용자 수
         */
        System.out.println("\n===== 문제 2: 프로그램 설정값 =====");

        // TODO: int형 일반 변수 currentUsers를 선언하고 42로 초기화하세요. (현재 사용자 수)
        int currentUsers = 42;
        // TODO: APP_NAME, APP_VERSION, MAX_USERS를 사용하여 프로그램 정보를 출력하세요.
        System.out.println("프로그램 이름: " + APP_NAME);
        System.out.println("버전: " + APP_VERSION);
        System.out.println("최대 사용자 수: " + MAX_USERS + "명");
        // TODO: currentUsers와 MAX_USERS를 사용하여 추가 가능 인원을 계산하고 출력하세요.
        int canAdd = MAX_USERS - currentUsers;
        System.out.println("현재 사용자 수: " + currentUsers + "명");
        System.out.println("추가 가능 인원: " + canAdd + "명");

        // ============================================================
        // 문제 3: final 변수 값 변경 시도 (컴파일 오류 설명)
        // ============================================================
        /*
         * [문제 설명]
         * final로 선언된 지역 상수에 값을 재대입하면 어떻게 되는지 확인하시오.
         * 오류가 발생하는 코드는 주석 처리하고, 오류 원인을 주석으로 설명하시오.
         *
         * [예상 출력]
         * ===== 문제 3: final 변수 변경 시도 =====
         * 지역 상수 MAX_SPEED: 120
         * (아래 코드를 주석 해제하면 컴파일 오류 발생)
         *
         * [힌트]
         * - final 변수는 초기화 이후 절대 값을 변경할 수 없습니다.
         * - 컴파일 오류 메시지: "cannot assign a value to final variable MAX_SPEED"
         * - final 변수를 변경하려면 final 키워드를 제거해야 합니다.
         */
        System.out.println("\n===== 문제 3: final 변수 변경 시도 =====");

        // TODO: final int 지역 상수 MAX_SPEED를 선언하고 120으로 초기화하세요.
        final int MAX_SPEED = 120;
        // TODO: MAX_SPEED 값을 출력하세요.
        System.out.println("지역 상수 MAX_SPEED: " + MAX_SPEED);
        // 아래 코드는 컴파일 오류가 발생합니다. 주석을 해제하지 마세요.
        // MAX_SPEED = 150; // 컴파일 오류: final 변수에는 값을 재대입할 수 없습니다.
        //                  // 오류 메시지: cannot assign a value to final variable MAX_SPEED

        System.out.println("(아래 코드를 주석 해제하면 컴파일 오류 발생)");
        System.out.println("// MAX_SPEED = 150; <-- final 변수는 값 변경 불가");


        // ============================================================
        // 문제 4: 상수를 활용한 단위 변환기
        // ============================================================
        /*
         * [문제 설명]
         * 위에 선언한 변환 상수들(KM_TO_MILE, MILE_TO_KM, KG_TO_POUND)을 사용하여
         * 사용자가 입력한 값을 다른 단위로 변환하여 출력하시오.
         *
         * [예상 출력]
         * ===== 문제 4: 단위 변환기 =====
         * [거리 변환]
         * 100.0 km = 62.1371 mile
         * 62.1371 mile = 100.00... km
         *
         * [무게 변환]
         * 70.0 kg = 154.3234 pound
         *
         * [힌트]
         * - double형 변수에 변환할 값을 저장하고 상수를 곱하면 됩니다.
         * - km → mile: 거리(km) * KM_TO_MILE
         * - mile → km: 거리(mile) * MILE_TO_KM
         * - kg → pound: 무게(kg) * KG_TO_POUND
         * - printf("%.4f", value) 로 소수점 4자리까지 출력할 수 있습니다.
         */
        System.out.println("\n===== 문제 4: 단위 변환기 =====");
        System.out.println("[거리 변환]");

        // TODO: double형 변수 distanceKm을 선언하고 100.0으로 초기화하세요.
        double distanceKm = 100.0;
        // TODO: double형 변수 distanceMile에 km를 mile로 변환한 결과를 저장하세요.
        //       (distanceKm * KM_TO_MILE)
        double distanceMile = distanceKm * KM_TO_MILE;
        // TODO: distanceKm과 distanceMile을 출력하세요.
        //       예: "100.0 km = 62.1371 mile"
        System.out.printf("%.1f km = %.4f mile%n", distanceKm, distanceMile);
        // TODO: distanceMile을 다시 km로 역변환하여 출력하세요.
        //       (distanceMile * MILE_TO_KM)
        distanceKm = distanceMile * MILE_TO_KM;
        System.out.printf("%.4f mile = %.1f km%n", distanceMile, distanceKm);

        System.out.println("\n[무게 변환]");

        // TODO: double형 변수 weightKg을 선언하고 70.0으로 초기화하세요.
        double weightKg = 70.0;
        // TODO: double형 변수 weightPound에 kg를 pound로 변환한 결과를 저장하세요.
        //       (weightKg * KG_TO_POUND)
        double weightPound = weightKg * KG_TO_POUND;
        // TODO: weightKg와 weightPound를 출력하세요.
        //       예: "70.0 kg = 154.3234 pound"
        System.out.println(weightKg + " kg = " + weightPound + " pound");
    } // main 메소드 끝


    // ============================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // ============================================================

    /**
     * km를 mile로 변환하는 메소드
     * @param km 킬로미터 값
     * @return 마일로 변환된 값
     */
    static double kmToMile(double km) {
        // TODO: km * KM_TO_MILE 값을 반환하세요.
        return km * KM_TO_MILE; // 임시 반환값 (구현 후 삭제)
    }

    /**
     * mile을 km로 변환하는 메소드
     * @param mile 마일 값
     * @return 킬로미터로 변환된 값
     */
    static double mileToKm(double mile) {
        // TODO: mile * MILE_TO_KM 값을 반환하세요.
        return mile * MILE_TO_KM; // 임시 반환값 (구현 후 삭제)
    }

    /**
     * kg를 pound로 변환하는 메소드
     * @param kg 킬로그램 값
     * @return 파운드로 변환된 값
     */
    static double kgToPound(double kg) {
        // TODO: kg * KG_TO_POUND 값을 반환하세요.
        return kg * KG_TO_POUND; // 임시 반환값 (구현 후 삭제)
    }

} // P04_Constants 클래스 끝
