/**
 * ============================================================
 * 학습 목표:
 *   1. 열거형(Enum)을 정의하고 switch 문에서 활용할 수 있다.
 *   2. Enum의 기본 제공 메소드(ordinal, name, values, valueOf)를 사용할 수 있다.
 *   3. Enum 상수 비교 시 == 연산자를 사용할 수 있는 이유를 설명할 수 있다.
 *
 * 핵심 개념:
 *   - 열거형(Enum): 미리 정해진 상수 집합을 정의하는 특별한 클래스
 *     예) enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }
 *   - ordinal(): 열거형 상수의 선언 순서 (0부터 시작)
 *   - name(): 열거형 상수의 이름을 String으로 반환
 *   - values(): 모든 열거형 상수를 배열로 반환
 *   - valueOf(String): 문자열에 해당하는 열거형 상수를 반환
 *   - Enum과 ==: 각 상수가 JVM에서 유일한 인스턴스이므로 == 비교 가능
 *   - Enum은 암묵적으로 java.lang.Enum<E>를 상속함
 * ============================================================
 */
public class P01_EnumBasics {

    // =========================================================
    // 문제 1: Day 열거형 정의 및 switch 사용
    // ---------------------------------------------------------
    // 설명:
    //   요일을 나타내는 Day 열거형을 정의하고,
    //   주어진 Day에 따라 메시지를 출력하는 메소드 describDay()를 구현하세요.
    //   - 열거형 상수: MON, TUE, WED, THU, FRI, SAT, SUN
    //   - switch 문에서 열거형을 사용합니다.
    //   - 평일(MON~FRI)은 "평일입니다. 열심히 공부하세요!", 주말은 "주말입니다. 푹 쉬세요!" 출력
    //
    // 예상 출력:
    //   MON -> 평일입니다. 열심히 공부하세요!
    //   SAT -> 주말입니다. 푹 쉬세요!
    //   SUN -> 주말입니다. 푹 쉬세요!
    //   FRI -> 평일입니다. 열심히 공부하세요!
    //
    // 힌트:
    //   - enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }
    //   - switch (day) { case MON: case TUE: ... }
    // =========================================================

    // TODO: Day 열거형을 선언하세요 (MON, TUE, WED, THU, FRI, SAT, SUN).
    enum Day {
        // TODO: 7개의 요일 상수를 선언하세요.
    }

    // TODO: Day를 매개변수로 받아 평일/주말 메시지를 출력하는 메소드를 구현하세요.
    public static void describeDay(Day day) {
        // TODO: switch (day) 문을 사용하여 평일과 주말을 구분하여 출력하세요.
        //       평일: MON, TUE, WED, THU, FRI -> "평일입니다. 열심히 공부하세요!"
        //       주말: SAT, SUN -> "주말입니다. 푹 쉬세요!"
    }

    // =========================================================
    // 문제 2: ordinal(), name(), values(), valueOf()
    // ---------------------------------------------------------
    // 설명:
    //   Day 열거형의 기본 메소드들을 활용하는 메소드들을 구현하세요.
    //
    //   (a) printAllDays(): values()로 모든 요일을 순서대로 출력
    //       - 각 요일의 ordinal()과 name()을 함께 출력
    //
    //   (b) getDayByName(String name): valueOf()로 문자열에서 Day를 반환
    //       - 잘못된 이름이면 IllegalArgumentException을 잡아 null 반환
    //
    // 예상 출력:
    //   [모든 요일 출력]
    //   0: MON
    //   1: TUE
    //   2: WED
    //   3: THU
    //   4: FRI
    //   5: SAT
    //   6: SUN
    //
    //   [valueOf 테스트]
    //   "WED" -> WED (ordinal: 2)
    //   "HOLIDAY" -> null (잘못된 이름)
    //
    // 힌트:
    //   - Day[] days = Day.values();
    //   - day.ordinal(), day.name()
    //   - Day.valueOf("WED")
    //   - try-catch(IllegalArgumentException)
    // =========================================================
    public static void printAllDays() {
        // TODO: Day.values()로 모든 Day 상수를 가져와
        //       "[ordinal]: [name]" 형태로 출력하세요.
    }

    public static Day getDayByName(String name) {
        // TODO: Day.valueOf(name)을 시도하고,
        //       IllegalArgumentException 발생 시 null을 반환하세요.
        return null;
    }

    // =========================================================
    // 문제 3: 열거형 비교 (== 사용 가능한 이유)
    // ---------------------------------------------------------
    // 설명:
    //   열거형 상수를 ==로 비교할 수 있는 이유를 코드로 보여주고,
    //   equals()와 ==의 결과를 비교하는 메소드 compareEnums()를 구현하세요.
    //
    //   - Day.MON == Day.MON  → true
    //   - Day.MON == Day.TUE  → false
    //   - Day.MON.equals(Day.MON) → true
    //   - null 비교 시 ==는 false, equals()는 NullPointerException
    //
    //   설명 출력:
    //   "Enum 상수는 JVM에서 각 타입당 유일한 인스턴스이므로 == 비교가 안전합니다."
    //
    // 예상 출력:
    //   [Enum 비교]
    //   MON == MON: true
    //   MON == TUE: false
    //   MON.equals(MON): true
    //   MON.equals(TUE): false
    //   null과 == 비교: false (안전)
    //   Enum 상수는 JVM에서 각 타입당 유일한 인스턴스이므로 == 비교가 안전합니다.
    //
    // 힌트:
    //   - Day a = Day.MON; Day b = Day.MON; Day c = Day.TUE;
    //   - System.out.println(a == b); // true
    //   - Day nullDay = null; System.out.println(a == nullDay); // false (NPE 없음)
    // =========================================================
    public static void compareEnums() {
        // TODO: Day.MON을 두 변수에 대입하고 == 및 equals()로 비교하여 출력하세요.

        // TODO: Day.MON과 Day.TUE를 == 및 equals()로 비교하여 출력하세요.

        // TODO: null인 Day 변수와 == 비교 시 안전함을 보여주세요.

        // TODO: 설명 메시지를 출력하세요.
        System.out.println("Enum 상수는 JVM에서 각 타입당 유일한 인스턴스이므로 == 비교가 안전합니다.");
    }

    // =========================================================
    // 헬퍼 메소드 시그니처 (내용은 직접 구현하세요)
    // =========================================================

    /**
     * 주어진 Day가 주말인지 반환하는 헬퍼 메소드
     */
    public static boolean isWeekend(Day day) {
        // TODO: day가 SAT 또는 SUN이면 true, 아니면 false를 반환하세요.
        return false;
    }

    /**
     * 다음 요일을 반환하는 헬퍼 메소드
     */
    public static Day nextDay(Day day) {
        // TODO: day.ordinal()을 이용하여 다음 요일을 계산하여 반환하세요.
        //       SUN 다음은 MON (순환)
        return null;
    }

    // =========================================================
    // main 메소드 - 각 문제를 테스트하세요
    // =========================================================
    public static void main(String[] args) {

        // --- 문제 1 테스트 ---
        System.out.println("=== 문제 1: Day 열거형과 switch ===");
        // TODO: describeDay()를 Day.MON, Day.SAT, Day.SUN, Day.FRI로 호출하여 출력하세요.
        System.out.print("MON -> ");
        // TODO: describeDay(Day.MON) 호출
        System.out.print("SAT -> ");
        // TODO: describeDay(Day.SAT) 호출
        System.out.print("SUN -> ");
        // TODO: describeDay(Day.SUN) 호출
        System.out.print("FRI -> ");
        // TODO: describeDay(Day.FRI) 호출

        System.out.println();

        // --- 문제 2 테스트 ---
        System.out.println("=== 문제 2: ordinal(), name(), values(), valueOf() ===");
        System.out.println("[모든 요일 출력]");
        // TODO: printAllDays() 호출

        System.out.println();
        System.out.println("[valueOf 테스트]");
        // TODO: getDayByName("WED")의 결과를 출력하세요.
        Day wed = getDayByName("WED");
        System.out.println("\"WED\" -> " + wed + " (ordinal: " + (wed != null ? wed.ordinal() : "N/A") + ")");

        // TODO: getDayByName("HOLIDAY")의 결과를 출력하세요.
        Day invalid = getDayByName("HOLIDAY");
        System.out.println("\"HOLIDAY\" -> " + invalid + " (잘못된 이름)");

        System.out.println();

        // --- 문제 3 테스트 ---
        System.out.println("=== 문제 3: 열거형 비교 (==) ===");
        System.out.println("[Enum 비교]");
        // TODO: compareEnums() 호출
    }
}
