/*
 * ============================================================
 * 파일명: P04_NestedConditions.java
 * 주제: 중첩 조건문 심화 (Nested Conditional Statements)
 * ============================================================
 *
 * [ 학습 목표 ]
 * 1. 중첩 if 문을 활용하여 복수의 조건을 단계적으로 처리하는 로직을 구현할 수 있다.
 * 2. 여러 조건(산술 연산 결과, 논리 연산 등)을 조합하여 현실적인 문제를 해결할 수 있다.
 * 3. 복잡한 분기 구조에서 각 경우의 수를 빠짐없이 처리하는 방법을 익힌다.
 *
 * [ 핵심 개념 ]
 * - 중첩 if 문: if 문 안에 또 다른 if 문을 작성하는 구조.
 *   바깥 조건이 참일 때만 안쪽 조건을 검사한다.
 *   예)
 *   if (조건A) {
 *       if (조건B) {
 *           // 조건A와 조건B 모두 참일 때 실행
 *       } else {
 *           // 조건A는 참이지만 조건B는 거짓일 때 실행
 *       }
 *   }
 *
 * - 논리 연산자 복습:
 *   &&  : AND (두 조건 모두 참이어야 true)
 *   ||  : OR  (두 조건 중 하나라도 참이면 true)
 *   !   : NOT (조건을 반전)
 *
 * - 주의: 중첩이 깊어질수록 코드 가독성이 낮아진다.
 *   불필요한 중첩은 조건 합성(&&, ||)으로 대체하거나, 메소드로 분리하는 것이 좋다.
 *
 * [ 사용법 ]
 * 1. 각 문제의 메소드 안에 있는 // TODO: 주석을 찾는다.
 * 2. 해당 위치에 알맞은 코드를 작성한다.
 * 3. main() 메소드를 실행하여 출력 결과를 확인한다.
 * ============================================================
 */
public class P04_NestedConditions {

    // ============================================================
    // 문제 1: BMI 지수 계산 및 비만도 판정
    // ============================================================
    /*
     * 제목: 키와 몸무게로 BMI 계산 및 비만도 판정하기
     *
     * 설명:
     *   키(cm 단위, double)와 몸무게(kg 단위, double)를 입력받아
     *   BMI를 계산하고 비만도 판정 결과를 반환한다.
     *
     *   BMI 계산 공식:
     *     BMI = 몸무게(kg) / (키(m) * 키(m))
     *     * 주의: 키는 cm를 m로 변환 (예: 170cm -> 1.70m)
     *
     *   비만도 기준 (대한비만학회 기준):
     *     BMI < 18.5          : "저체중"
     *     18.5 <= BMI < 23.0  : "정상"
     *     23.0 <= BMI < 25.0  : "과체중"
     *     25.0 <= BMI < 30.0  : "비만"
     *     BMI >= 30.0         : "고도비만"
     *
     *   입력 유효성: 키 <= 0 또는 몸무게 <= 0이면 "유효하지 않은 입력"을 반환한다.
     *
     * 예상 출력:
     *   getBmiResult(170, 65) -> "정상 (BMI: 22.49)"  (소수점 2자리 반올림)
     *   getBmiResult(160, 80) -> "비만 (BMI: 31.25)"
     *   getBmiResult(0, 65)   -> "유효하지 않은 입력"
     *
     * 힌트:
     *   - 키를 미터로 변환: double heightM = heightCm / 100.0;
     *   - BMI 계산: double bmi = weight / (heightM * heightM);
     *   - 소수점 2자리 반올림: Math.round(bmi * 100) / 100.0
     *   - 중첩 if가 아닌 else if 체인으로 BMI 범위를 분기해도 된다.
     *   - 반환 형식 예: "정상 (BMI: 22.49)"
     *     -> String.format("정상 (BMI: %.2f)", bmi)  사용 가능
     */
    public static String getBmiResult(double heightCm, double weight) {
        // TODO: 키 또는 몸무게가 0 이하이면 "유효하지 않은 입력" 반환
        if (heightCm <= 0 || weight <= 0){
            return "유효하지 않은 입력";
        }
        // TODO: 키를 m 단위로 변환 (heightCm / 100.0)
        double heightM = (heightCm / 100.0);
        // TODO: BMI 계산
        double bmi = weight / (heightM * heightM);
        // TODO: BMI 범위에 따라 비만도 분류 후 결과 문자열 반환
        // 저체중 / 정상 / 과체중 / 비만 / 고도비만

        if (bmi < 18.5) {
            return "저체중";
        } else if (bmi < 23.0) {
            return "정상";
        } else if (bmi < 25.0) {
            return "과체중";
        } else if (bmi < 30.0) {
            return "비만";
        }

        return "고도비만"; // 이 줄을 수정하지 말고, 위 TODO를 채워 올바른 값을 반환하게 하세요.
    }

    // ============================================================
    // 문제 2: 숫자 다중 분류
    // ============================================================
    /*
     * 제목: 중첩 조건문으로 숫자 분류하기 (부호 + 짝홀 + 소수 여부)
     *
     * 설명:
     *   정수 하나를 입력받아 세 가지 관점에서 분류한 결과를 출력한다.
     *     1) 부호: 양수 / 음수 / 0
     *     2) 짝홀수 여부 (0은 짝수로 처리)
     *     3) 소수(Prime Number) 여부 (2 이상의 양수에 대해서만 판정)
     *
     * 예상 출력 (number = 7):
     *   [7 분류 결과]
     *   부호: 양수
     *   짝홀: 홀수
     *   소수: 소수
     *
     * 예상 출력 (number = -4):
     *   [-4 분류 결과]
     *   부호: 음수
     *   짝홀: 짝수
     *   소수: 해당 없음 (음수)
     *
     * 예상 출력 (number = 0):
     *   [0 분류 결과]
     *   부호: 0
     *   짝홀: 짝수
     *   소수: 해당 없음 (0 또는 1)
     *
     * 힌트:
     *   - 부호 판정: number > 0, number < 0, number == 0
     *   - 짝홀 판정: number % 2 == 0 이면 짝수
     *   - 소수 판정: 2 이상의 수에서 2부터 (수-1)까지 나누어 나머지가 0인 수가 없으면 소수
     *     (소수 판정은 아래 헬퍼 메소드 isPrime()을 완성하거나 직접 구현한다)
     *   - 소수 여부는 양수(2 이상)에 대해서만 판정하고, 그 외는 "해당 없음"을 출력한다.
     */
    public static void classifyNumber(int number) {
        System.out.println("[" + number + " 분류 결과]");

        // TODO: 부호 출력 ("부호: 양수" / "부호: 음수" / "부호: 0")
        System.out.println("부호: " + ((number<0) ? "음수" : (number == 0) ? "0" : "양수"));
        // TODO: 짝수/홀수 출력 ("짝홀: 짝수" / "짝홀: 홀수")
        System.out.println("짝홀: " + ((number%2 == 0) ? "짝수" : "홀수"));
        // TODO: 소수 여부 출력
        // number >= 2 이면 isPrime(number)를 호출하여 "소수: 소수" 또는 "소수: 소수 아님"
        // number < 2  이면 "소수: 해당 없음 (0 또는 1)" 또는 "소수: 해당 없음 (음수)"
        System.out.println("소수: " + ((number < 2) ? "해당 없음 (0 또는 1)" : (isPrime(number) ? "소수" : "소수 아님" )));
    }

    // ============================================================
    // 문제 3: 삼각형 종류 판별
    // ============================================================
    /*
     * 제목: 세 변의 길이로 삼각형 종류 판별하기
     *
     * 설명:
     *   세 변의 길이(a, b, c, 양의 정수)를 입력받아 삼각형의 종류를 반환한다.
     *   판별 순서:
     *     1) 삼각형 성립 조건 확인: 두 변의 합이 나머지 한 변보다 커야 함
     *        (a+b > c) && (b+c > a) && (a+c > b)
     *        성립하지 않으면 "삼각형 불가"를 반환한다.
     *     2) 삼각형 종류 판별 (성립하는 경우):
     *        - 세 변이 모두 같으면   : "정삼각형"
     *        - 두 변만 같으면        : "이등변삼각형"
     *        - a²+b²==c² 등 성립하면 : "직각삼각형"
     *          (세 쌍 모두 확인: a²+b²==c², b²+c²==a², a²+c²==b²)
     *        - 위 어느 것도 해당 안되면: "일반삼각형"
     *
     * 예상 출력:
     *   getTriangleType(5, 5, 5)  -> "정삼각형"
     *   getTriangleType(5, 5, 3)  -> "이등변삼각형"
     *   getTriangleType(3, 4, 5)  -> "직각삼각형"
     *   getTriangleType(3, 4, 6)  -> "일반삼각형"
     *   getTriangleType(1, 2, 10) -> "삼각형 불가"
     *
     * 힌트:
     *   - 삼각형 성립 조건을 먼저 if 문으로 확인한다.
     *   - 정삼각형 판정: a == b && b == c
     *   - 이등변삼각형 판정: a==b || b==c || a==c (정삼각형 제외 후 확인)
     *   - 직각삼각형 판정:
     *     (a*a + b*b == c*c) || (b*b + c*c == a*a) || (a*a + c*c == b*b)
     *   - 중첩 if-else 구조로 순서대로 판정한다.
     */
    public static String getTriangleType(int a, int b, int c) {
        // TODO: 삼각형 성립 조건 검사 (불가능하면 "삼각형 불가" 반환)
        if (!((a+b > c) && (b+c > a) && (a+c > b))) {
            return "삼각형 불가";
        }
        // TODO: 정삼각형 판정 (세 변이 모두 같은 경우)
        else if (a == b && b == c) {
            return "정삼각형";
        }
        // TODO: 이등변삼각형 판정 (두 변만 같은 경우)
        else if (a==b || b==c || a==c) {
            return "이등변삼각형";
        }
        // TODO: 직각삼각형 판정 (피타고라스 정리 적용)
        else if ((a*a + b*b == c*c) || (b*b + c*c == a*a) || (a*a + c*c == b*b)) {
            return "직각삼각형";
        }
        // TODO: 일반삼각형 반환 (위 조건에 해당하지 않는 경우)
        return "일반삼각형"; // 이 줄을 수정하지 말고, 위 TODO를 채워 올바른 값을 반환하게 하세요.
    }

    // ============================================================
    // 문제 4: 과제 평가 점수 계산 시스템
    // ============================================================
    /*
     * 제목: 해/달/별 개수 입력받아 과제 총점 계산하기
     *
     * 설명:
     *   학교 과제 평가 시스템에서 교사는 과제에 해, 달, 별 3가지 마크를 부여한다.
     *   각 마크별 점수와 규칙은 다음과 같다.
     *
     *   기본 점수:
     *     해(sun)  1개당 10점
     *     달(moon) 1개당 5점
     *     별(star) 1개당 1점
     *
     *   보너스 규칙 (중첩 조건으로 처리):
     *     - 해가 3개 이상이면 추가로 20점 보너스
     *     - 달이 5개 이상이면 추가로 10점 보너스
     *     - 해가 3개 이상 AND 달이 5개 이상이면 추가로 15점 보너스 (위 보너스와 별도 적용)
     *     - 총점(보너스 포함)이 100점을 초과하면 100점으로 제한 (최대 100점)
     *
     *   입력 유효성: sun, moon, star 중 하나라도 음수이면 -1을 반환한다.
     *
     * 예상 출력:
     *   calculateScore(3, 5, 2) -> 100  (30 + 25 + 2 + 20 + 10 + 15 = 102 -> 100으로 제한)
     *   calculateScore(1, 2, 3) -> 18   (10 + 10 + 3 = 23 -> 18 이 아니라 다시 계산하세요)
     *     * 재계산: sun=1(10점), moon=2(10점), star=3(3점) -> 기본 23점, 보너스 없음 -> 23점
     *   calculateScore(0, 0, 0) -> 0
     *   calculateScore(-1, 3, 2)-> -1  (유효하지 않은 입력)
     *
     * 힌트:
     *   - 먼저 입력 유효성 검사를 한다 (음수 여부).
     *   - 기본 점수를 먼저 계산한다: score = sun*10 + moon*5 + star*1
     *   - 보너스 조건을 중첩 if 또는 독립적인 if 문으로 처리한다.
     *     (해>=3 보너스, 달>=5 보너스, 해>=3 AND 달>=5 추가 보너스 모두 적용)
     *   - 마지막에 score > 100 이면 score = 100으로 설정한다.
     */
    public static int calculateScore(int sun, int moon, int star) {
        // TODO: 입력 유효성 검사 (sun, moon, star 중 하나라도 음수이면 -1 반환)
        if (sun < 0 || moon < 0 || star < 0){
            return -1;
        }
        // TODO: 기본 점수 계산 (sun * 10 + moon * 5 + star * 1)
        int score = (sun * 10 + moon * 5 + star * 1);

        // TODO: 해가 3개 이상이면 보너스 20점 추가
        if (sun >= 3) {score += 20;}
        // TODO: 달이 5개 이상이면 보너스 10점 추가
        if (moon >= 5) {score += 10;}
        // TODO: 해가 3개 이상 AND 달이 5개 이상이면 추가 보너스 15점 추가
        if (sun >= 3 && moon >= 5) {score += 15;}
        // TODO: 총점이 100 초과이면 100으로 제한
        score = (score > 100) ? 100 : score;

        return score;
    }

    // ============================================================
    // 헬퍼 메소드 (내용 직접 구현 불필요 - 시그니처만 참고)
    // ============================================================

    /**
     * 주어진 정수가 소수인지 확인한다.
     * 소수: 1과 자기 자신만을 약수로 갖는 1보다 큰 자연수.
     * @param n 확인할 양의 정수 (n >= 2 임을 가정)
     * @return 소수이면 true, 아니면 false
     */
    private static boolean isPrime(int n) {
        // TODO (선택): for 문으로 2부터 n-1까지 나누어 보아 약수가 없으면 true 반환

        for(int i=2; i<n; i++){
            if (n % i == 0) { return false;}
        }

        return true; /* 구현 생략 - 선택적으로 구현 */
    }

    /**
     * 삼각형 성립 조건을 확인한다.
     * @param a 첫 번째 변의 길이
     * @param b 두 번째 변의 길이
     * @param c 세 번째 변의 길이
     * @return 삼각형 성립 가능하면 true
     */
    private static boolean isValidTriangle(int a, int b, int c) { return false; /* 구현 생략 */ }

    /**
     * 주어진 세 변이 직각삼각형인지 확인한다.
     * @param a 첫 번째 변
     * @param b 두 번째 변
     * @param c 세 번째 변
     * @return 직각삼각형이면 true
     */
    private static boolean isRightTriangle(int a, int b, int c) { return false; /* 구현 생략 */ }

    // ============================================================
    // main 메소드 - 테스트 실행
    // ============================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: BMI 지수 및 비만도 판정 ===");
        System.out.println("키=170cm, 몸무게=65kg -> " + getBmiResult(170, 65));
        System.out.println("키=160cm, 몸무게=80kg -> " + getBmiResult(160, 80));
        System.out.println("키=175cm, 몸무게=50kg -> " + getBmiResult(175, 50));
        System.out.println("키=0cm,   몸무게=65kg -> " + getBmiResult(0, 65));

        System.out.println();
        System.out.println("=== 문제 2: 숫자 다중 분류 ===");
        classifyNumber(7);
        System.out.println();
        classifyNumber(-4);
        System.out.println();
        classifyNumber(0);
        System.out.println();
        classifyNumber(12);

        System.out.println();
        System.out.println("=== 문제 3: 삼각형 종류 판별 ===");
        System.out.println("(5, 5, 5)  -> " + getTriangleType(5, 5, 5));
        System.out.println("(5, 5, 3)  -> " + getTriangleType(5, 5, 3));
        System.out.println("(3, 4, 5)  -> " + getTriangleType(3, 4, 5));
        System.out.println("(3, 4, 6)  -> " + getTriangleType(3, 4, 6));
        System.out.println("(1, 2, 10) -> " + getTriangleType(1, 2, 10));

        System.out.println();
        System.out.println("=== 문제 4: 과제 평가 점수 계산 ===");
        System.out.println("해=3, 달=5, 별=2 -> " + calculateScore(3, 5, 2) + "점");
        System.out.println("해=1, 달=2, 별=3 -> " + calculateScore(1, 2, 3) + "점");
        System.out.println("해=0, 달=0, 별=0 -> " + calculateScore(0, 0, 0) + "점");
        System.out.println("해=3, 달=2, 별=1 -> " + calculateScore(3, 2, 1) + "점");
        System.out.println("해=-1, 달=3, 별=2 -> " + calculateScore(-1, 3, 2) + " (유효하지 않은 입력)");
    }
}
