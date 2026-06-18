/**
 * ============================================================
 * 학습 목표:
 *   1. 필드와 생성자를 가진 열거형을 정의하고 활용할 수 있다.
 *   2. 열거형 상수마다 고유한 데이터(질량, 반지름 등)를 부여할 수 있다.
 *   3. 추상 메소드를 가진 열거형으로 각 상수가 다른 동작을 구현하게 할 수 있다.
 *
 * 핵심 개념:
 *   - 열거형 생성자: private으로만 선언 가능 (외부에서 new 불가)
 *     예) MERCURY(3.303e+23, 2.4397e6) 와 같이 상수 선언 시 인자 전달
 *   - 열거형 필드: final로 선언하여 불변성 유지 권장
 *   - 열거형 메소드: 일반 클래스처럼 메소드를 선언하고 필드를 활용 가능
 *   - 추상 메소드: 각 열거형 상수가 서로 다른 구현을 제공해야 할 때 사용
 *     - abstract 메소드를 선언하면 각 상수 블록 { }에서 반드시 구현해야 함
 *   - enum은 내부적으로 java.lang.Enum을 상속하므로 다른 클래스 상속 불가
 * ============================================================
 */
public class P02_EnumWithFields {

    // =========================================================
    // 문제 1: Planet 열거형 (질량, 반지름 필드, 중력 계산 메소드)
    // ---------------------------------------------------------
    // 설명:
    //   태양계 행성들을 나타내는 Planet 열거형을 구현하세요.
    //   - 각 행성은 질량(mass, kg)과 반지름(radius, m)을 필드로 가집니다.
    //   - 중력 가속도(surfaceGravity())와 표면 무게(surfaceWeight()) 메소드를 포함합니다.
    //   - 만유인력 상수 G = 6.67300E-11 (static final로 선언)
    //   - 공식: surfaceGravity = G * mass / (radius * radius)
    //   - 공식: surfaceWeight(otherMass) = otherMass * surfaceGravity()
    //
    //   행성 데이터:
    //     MERCURY: mass = 3.303e+23,  radius = 2.4397e6
    //     VENUS:   mass = 4.869e+24,  radius = 6.0518e6
    //     EARTH:   mass = 5.976e+24,  radius = 6.37814e6
    //     MARS:    mass = 6.421e+23,  radius = 3.3972e6
    //
    // 예상 출력:
    //   지구에서 체중이 75.0kg인 사람의 각 행성 무게:
    //   MERCURY: 28.33 N
    //   VENUS: 67.87 N
    //   EARTH: 75.00 N
    //   MARS: 28.45 N
    //
    // 힌트:
    //   - enum Planet { MERCURY(3.303e+23, 2.4397e6), ... }
    //   - private final double mass; private final double radius;
    //   - Planet(double mass, double radius) { this.mass = mass; this.radius = radius; }
    // =========================================================

    // TODO: Planet 열거형을 선언하세요.
    enum Planet {
        // TODO: MERCURY, VENUS, EARTH, MARS 상수를 질량과 반지름 값으로 선언하세요.

        ;   // 상수 목록 끝에 세미콜론 필요 (필드/메소드가 있을 때)

        // TODO: 만유인력 상수 G를 static final double로 선언하세요. (G = 6.67300E-11)

        // TODO: mass (double)와 radius (double) 필드를 final로 선언하세요.

        // TODO: 생성자를 작성하세요 (mass, radius를 초기화).

        // TODO: surfaceGravity() 메소드를 작성하세요.
        //       반환 값: G * mass / (radius * radius)
        double surfaceGravity() {
            // TODO: 중력 가속도를 계산하여 반환하세요.
            return 0.0;
        }

        // TODO: surfaceWeight(double otherMass) 메소드를 작성하세요.
        //       반환 값: otherMass * surfaceGravity()
        double surfaceWeight(double otherMass) {
            // TODO: 표면 무게를 계산하여 반환하세요.
            return 0.0;
        }
    }

    // =========================================================
    // 문제 2: 생성자가 있는 열거형
    // ---------------------------------------------------------
    // 설명:
    //   음식 카테고리를 나타내는 FoodCategory 열거형을 구현하세요.
    //   - 각 카테고리는 한국어 설명(description)과 칼로리 범위(calorieRange) 필드를 가집니다.
    //   - getDescription()과 getCalorieRange() 메소드를 제공합니다.
    //   - 카테고리 정보를 출력하는 displayInfo() 메소드를 구현합니다.
    //
    //   카테고리 데이터:
    //     KOREAN:    description = "한식",   calorieRange = "300~600 kcal"
    //     CHINESE:   description = "중식",   calorieRange = "400~800 kcal"
    //     JAPANESE:  description = "일식",   calorieRange = "250~500 kcal"
    //     WESTERN:   description = "양식",   calorieRange = "500~1000 kcal"
    //     FAST_FOOD: description = "패스트푸드", calorieRange = "400~900 kcal"
    //
    // 예상 출력:
    //   [음식 카테고리 정보]
    //   한식 | 칼로리 범위: 300~600 kcal
    //   중식 | 칼로리 범위: 400~800 kcal
    //   일식 | 칼로리 범위: 250~500 kcal
    //   양식 | 칼로리 범위: 500~1000 kcal
    //   패스트푸드 | 칼로리 범위: 400~900 kcal
    //
    // 힌트:
    //   - enum FoodCategory { KOREAN("한식", "300~600 kcal"), ... }
    //   - private final String description; private final String calorieRange;
    //   - FoodCategory(String description, String calorieRange) { ... }
    // =========================================================

    // TODO: FoodCategory 열거형을 선언하세요.
    enum FoodCategory {
        // TODO: 5개의 카테고리 상수를 설명과 칼로리 범위로 선언하세요.

        ;   // 상수 목록 끝에 세미콜론 필요

        // TODO: description과 calorieRange 필드를 final로 선언하세요.

        // TODO: 생성자를 작성하세요.

        // TODO: getDescription() 메소드를 작성하세요.
        public String getDescription() {
            // TODO: description을 반환하세요.
            return null;
        }

        // TODO: getCalorieRange() 메소드를 작성하세요.
        public String getCalorieRange() {
            // TODO: calorieRange를 반환하세요.
            return null;
        }

        // TODO: displayInfo() 메소드를 작성하세요.
        //       출력 형태: "[description] | 칼로리 범위: [calorieRange]"
        public void displayInfo() {
            // TODO: 카테고리 정보를 출력하세요.
        }
    }

    // =========================================================
    // 문제 3: 추상 메소드를 가진 열거형 (각 상수가 다른 구현)
    // ---------------------------------------------------------
    // 설명:
    //   사칙연산을 나타내는 Operation 열거형을 구현하세요.
    //   - 추상 메소드 apply(double x, double y)를 선언합니다.
    //   - 각 상수(PLUS, MINUS, TIMES, DIVIDE)가 서로 다른 apply()를 구현합니다.
    //   - symbol 필드를 갖고 toString()을 오버라이드하여 기호를 반환합니다.
    //
    //   연산 데이터:
    //     PLUS("+"):   apply → x + y
    //     MINUS("-"):  apply → x - y
    //     TIMES("*"):  apply → x * y
    //     DIVIDE("/"): apply → x / y (y가 0이면 Double.NaN 반환)
    //
    // 예상 출력:
    //   [사칙연산 Enum]
    //   6.0 + 2.0 = 8.0
    //   6.0 - 2.0 = 4.0
    //   6.0 * 2.0 = 12.0
    //   6.0 / 2.0 = 3.0
    //   6.0 / 0.0 = NaN
    //
    // 힌트:
    //   - enum Operation {
    //       PLUS("+") {
    //           @Override public double apply(double x, double y) { return x + y; }
    //       },
    //       ...
    //       ;
    //       private final String symbol;
    //       Operation(String symbol) { this.symbol = symbol; }
    //       public abstract double apply(double x, double y);
    //     }
    // =========================================================

    // TODO: Operation 열거형을 선언하세요.
    enum Operation {
        // TODO: PLUS("+") 상수를 선언하고 apply()를 구현하세요 (x + y 반환).
        PLUS("+") {
            @Override
            public double apply(double x, double y) {
                // TODO: x + y를 반환하세요.
                return 0;
            }
        },
        // TODO: MINUS("-") 상수를 선언하고 apply()를 구현하세요 (x - y 반환).
        MINUS("-") {
            @Override
            public double apply(double x, double y) {
                // TODO: x - y를 반환하세요.
                return 0;
            }
        },
        // TODO: TIMES("*") 상수를 선언하고 apply()를 구현하세요 (x * y 반환).
        TIMES("*") {
            @Override
            public double apply(double x, double y) {
                // TODO: x * y를 반환하세요.
                return 0;
            }
        },
        // TODO: DIVIDE("/") 상수를 선언하고 apply()를 구현하세요 (y가 0이면 NaN, 아니면 x / y).
        DIVIDE("/") {
            @Override
            public double apply(double x, double y) {
                // TODO: y가 0이면 Double.NaN을 반환하고, 아니면 x / y를 반환하세요.
                return 0;
            }
        };

        // TODO: symbol 필드를 final String으로 선언하세요.

        // TODO: 생성자를 작성하세요 (symbol 초기화).
        Operation(String symbol) {
            // TODO: symbol을 초기화하세요.
        }

        // TODO: 추상 메소드 apply()를 선언하세요.
        public abstract double apply(double x, double y);

        // TODO: toString()을 오버라이드하여 symbol을 반환하세요.
        @Override
        public String toString() {
            // TODO: symbol을 반환하세요.
            return null;
        }
    }

    // =========================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // =========================================================

    /**
     * 가장 중력이 강한 Planet을 반환하는 헬퍼 메소드
     */
    public static Planet heaviestGravityPlanet() {
        // TODO: Planet.values()로 모든 행성을 순회하여 surfaceGravity()가 가장 큰 행성을 반환하세요.
        return null;
    }

    /**
     * 문자열 기호로 Operation을 찾는 헬퍼 메소드
     */
    public static Operation findBySymbol(String symbol) {
        // TODO: Operation.values()로 순회하며 symbol이 일치하는 Operation을 반환하세요.
        //       없으면 null을 반환하세요.
        return null;
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: Planet 열거형 ===");
        double earthWeight = 75.0;
        // TODO: earthWeight를 EARTH의 surfaceGravity()로 나누어 질량(mass)을 구하세요.
        //       질량 = earthWeight / EARTH.surfaceGravity()
        double mass = 0; // TODO: 올바른 식으로 교체하세요.

        System.out.println("지구에서 체중이 " + earthWeight + "kg인 사람의 각 행성 무게:");
        // TODO: Planet.values()로 모든 행성을 순회하며 각 행성에서의 무게를 출력하세요.
        //       형식: "[행성이름]: [surfaceWeight 결과를 소수점 2자리로] N"
        //       (String.format("%.2f", ...)  활용)

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: 생성자가 있는 열거형 FoodCategory ===");
        System.out.println("[음식 카테고리 정보]");
        // TODO: FoodCategory.values()로 모든 카테고리를 순회하며 displayInfo()를 호출하세요.

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 추상 메소드를 가진 열거형 Operation ===");
        System.out.println("[사칙연산 Enum]");
        double x = 6.0, y = 2.0;
        // TODO: Operation.values()로 모든 연산을 순회하며 apply(x, y)를 호출하고 결과를 출력하세요.
        //       형식: "[x] [symbol] [y] = [결과]"

        // TODO: DIVIDE 연산으로 x / 0.0을 계산하여 NaN 출력을 확인하세요.
        System.out.println(x + " / 0.0 = " /* TODO: Operation.DIVIDE.apply(x, 0.0) */);
    }
}
