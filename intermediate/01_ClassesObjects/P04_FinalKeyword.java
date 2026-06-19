/*
 * =====================================================
 * 파일명: P04_FinalKeyword.java
 * 주제: final 키워드 (The final Keyword)
 * =====================================================
 *
 * [학습목표]
 * 1. final 키워드를 변수, 메소드, 클래스에 적용할 때 각각 어떤 제약이 생기는지 설명한다.
 * 2. final 필드를 활용하여 상수(constant)를 정의하고 올바르게 사용한다.
 * 3. 불변(Immutable) 클래스를 설계하는 원칙을 이해하고 직접 구현한다.
 *
 * [핵심개념]
 * - final 변수: 한 번 초기화하면 값을 변경할 수 없다. 상수 선언에 사용 (관례상 대문자_스네이크케이스).
 * - final 메소드: 하위 클래스에서 오버라이딩(재정의)할 수 없다.
 * - final 클래스: 상속(extends)할 수 없다. 대표 예시: java.lang.String, java.lang.Integer.
 * - 불변 클래스(Immutable Class): 한 번 생성된 후 상태가 절대 변하지 않는 클래스.
 *   모든 필드를 private final로 선언하고, setter를 제공하지 않으며, 생성자로만 초기화한다.
 * =====================================================
 */
public class P04_FinalKeyword {

    // ================================================================
    // 문제 1: final 필드 (상수 필드) 사용
    // ================================================================
    /*
     * [문제 1] final 필드로 상수 정의하기
     * -------------------------------------------------
     * 설명:
     *   Constants 클래스에 프로그램 전체에서 사용할 상수들을 정의합니다.
     *   final 변수는 선언 시 초기화하거나 생성자에서 단 한 번만 초기화할 수 있습니다.
     *
     * 요구사항:
     *   - Constants 클래스에 다음 상수 정의 (모두 static final):
     *       MAX_SCORE = 100         → 최대 점수
     *       MIN_SCORE = 0           → 최소 점수
     *       APP_NAME = "자바 학습"   → 앱 이름
     *       PI = 3.14159265358979   → 원주율
     *       PASSING_GRADE = 60      → 합격 기준 점수
     *   - Circle 클래스: final double radius 필드 (생성자에서 초기화)
     *       메소드: double getArea() → Constants.PI 이용
     *       메소드: double getCircumference() → 2 * Constants.PI * radius
     *   - main()에서 상수 출력 및 Circle 객체로 넓이/둘레 계산
     *
     * 예상 출력:
     *   === 앱 상수 ===
     *   앱 이름: 자바 학습
     *   최대 점수: 100, 최소 점수: 0
     *   합격 기준: 60점 이상
     *
     *   === 원 계산 (반지름: 7.0) ===
     *   넓이: 153.93804...
     *   둘레: 43.98229...
     *
     *   [컴파일 에러 확인] 다음 코드는 컴파일 에러 발생:
     *   // Constants.MAX_SCORE = 200;  ← final 변수는 재할당 불가!
     *
     * 힌트:
     *   - 상수 선언: static final int MAX_SCORE = 100;
     *   - final 인스턴스 필드는 생성자에서 초기화: this.radius = r;
     *   - final 변수에 재할당 시도 시 컴파일 타임 오류 발생
     */

    // TODO: Constants 클래스를 파일 하단에 선언하세요
    // TODO: Circle 클래스를 파일 하단에 선언하세요


    // ================================================================
    // 문제 2: final 메소드 (오버라이딩 불가)
    // ================================================================
    /*
     * [문제 2] final 메소드로 오버라이딩 방지하기
     * -------------------------------------------------
     * 설명:
     *   부모 클래스의 메소드에 final을 붙이면 자식 클래스에서 재정의할 수 없습니다.
     *   보안상 중요하거나 핵심 알고리즘을 보호할 때 사용합니다.
     *
     * 요구사항:
     *   - Animal 클래스:
     *       String name 필드
     *       생성자: Animal(String name)
     *       final void breathe() → "[이름]은(는) 숨을 쉽니다." 출력 (오버라이딩 불가)
     *       void makeSound() → "[이름]이(가) 소리를 냅니다." 출력 (오버라이딩 가능)
     *   - Dog 클래스 (Animal 상속):
     *       생성자: Dog(String name)
     *       makeSound() 오버라이딩 → "[이름]이(가) 왈왈! 합니다." 출력
     *       // breathe() 오버라이딩 시도 시 컴파일 에러 발생 (주석으로 설명 추가)
     *   - main()에서 Dog 객체 생성 후 breathe()와 makeSound() 호출
     *
     * 예상 출력:
     *   강아지 객체 테스트:
     *   멍멍이은(는) 숨을 쉽니다.    ← Animal의 final 메소드 (변경 불가)
     *   멍멍이이(가) 왈왈! 합니다.   ← Dog에서 오버라이딩된 메소드
     *
     * 힌트:
     *   - final 메소드 선언: final void breathe() { ... }
     *   - 자식 클래스에서 final 메소드 오버라이딩 시 컴파일 에러
     *   - 상속: class Dog extends Animal { ... }
     *   - super(name) 으로 부모 생성자 호출
     */

    // TODO: Animal 클래스를 파일 하단에 선언하세요
    // TODO: Dog 클래스 (Animal 상속)를 파일 하단에 선언하세요


    // ================================================================
    // 문제 3: final 클래스 (상속 불가)
    // ================================================================
    /*
     * [문제 3] final 클래스로 상속 차단하기
     * -------------------------------------------------
     * 설명:
     *   클래스에 final을 붙이면 어떤 클래스도 이 클래스를 상속할 수 없습니다.
     *   Java의 String, Integer, Double 등이 final 클래스입니다.
     *   보안과 불변성 보장을 위해 사용합니다.
     *
     * 요구사항:
     *   - final class SecureId 선언:
     *       private final String id 필드
     *       생성자: SecureId(String id)
     *       String getId() → id 반환
     *       String toString() → "SecureId[" + id + "]" 반환
     *   - main()에서 SecureId 객체 생성 후 사용
     *   - 코드 주석으로 다음을 설명:
     *     (1) String이 final 클래스인 이유 (불변성 보장)
     *     (2) final 클래스를 상속하려 하면 어떤 에러가 발생하는지
     *     (3) final 클래스 사용 시 장점 (보안, 최적화)
     *
     * 예상 출력:
     *   SecureId 생성: SecureId[USER-2024-001]
     *   ID 값: USER-2024-001
     *
     *   === final 클래스 설명 ===
     *   (아래 코드는 컴파일 에러 발생)
     *   // class HackedId extends SecureId { }  ← 컴파일 에러!
     *
     * 힌트:
     *   - final 클래스 선언: final class SecureId { ... }
     *   - extends 하려 하면 "cannot inherit from final class" 에러
     *   - String이 final인 이유: 문자열 불변성이 보안과 해시 동작에 필수적
     */

    // TODO: SecureId final 클래스를 파일 하단에 선언하세요


    // ================================================================
    // 문제 4: 불변 클래스 설계 (ImmutablePoint)
    // ================================================================
    /*
     * [문제 4] 불변(Immutable) 클래스 ImmutablePoint 구현
     * -------------------------------------------------
     * 설명:
     *   불변 클래스는 한 번 생성된 후 상태가 절대 변하지 않는 클래스입니다.
     *   스레드 안전(thread-safe)하며, 예측 가능한 동작을 보장합니다.
     *   Java의 String, Integer 등이 대표적인 불변 클래스입니다.
     *
     * 불변 클래스 설계 규칙:
     *   1. 클래스를 final로 선언 (상속 차단)
     *   2. 모든 필드를 private final로 선언
     *   3. 생성자에서만 필드 초기화
     *   4. setter 메소드 제공 금지
     *   5. getter 메소드만 제공
     *   6. 상태 변경이 필요한 경우 새 객체를 생성하여 반환
     *
     * 요구사항:
     *   - final class ImmutablePoint:
     *       private final int x, y 필드
     *       생성자: ImmutablePoint(int x, int y)
     *       int getX(), int getY() → getter 메소드
     *       ImmutablePoint translate(int dx, int dy) → 이동된 새 ImmutablePoint 반환 (원본 불변)
     *       ImmutablePoint scale(int factor) → 확대된 새 ImmutablePoint 반환
     *       String toString() → "(x, y)" 형식으로 반환
     *       double distanceTo(ImmutablePoint other) → 두 점 사이 거리 반환
     *   - main()에서:
     *     (1) p1 = new ImmutablePoint(3, 4) 생성
     *     (2) p2 = p1.translate(2, 3) → 새 객체, p1은 변화 없음
     *     (3) p3 = p1.scale(2) → 새 객체
     *     (4) p1, p2, p3 출력 및 p1-p2 거리 출력
     *
     * 예상 출력:
     *   원본 p1: (3, 4)
     *   p1.translate(2, 3) → p2: (5, 7)
     *   p1은 변하지 않음: (3, 4)  ← 불변!
     *   p1.scale(2) → p3: (6, 8)
     *   p1은 변하지 않음: (3, 4)  ← 불변!
     *   p1과 p2 사이 거리: 3.605551275...
     *
     * 힌트:
     *   - translate()는 return new ImmutablePoint(x + dx, y + dy); 처럼 새 객체 반환
     *   - 거리 계산: Math.sqrt(dx*dx + dy*dy)
     *   - this를 변경하지 않고 새 객체를 반환하는 것이 핵심
     */

    // TODO: ImmutablePoint final 클래스를 파일 하단에 선언하세요


    // ================================================================
    // main 메소드 - 여기서 모든 문제를 테스트하세요
    // ================================================================
    public static void main(String[] args) {

        System.out.println("========== 문제 1: final 필드 (상수) ==========");
        // TODO: Constants의 상수 출력
        // TODO: Circle 객체 생성 후 넓이와 둘레 출력
        // TODO: 주석으로 final 변수 재할당 시도 시 에러 발생함을 표시

        System.out.println("\n========== 문제 2: final 메소드 ==========");
        // TODO: Dog 객체 생성 후 breathe()와 makeSound() 호출
        // TODO: 주석으로 breathe() 오버라이딩 시도 시 에러 발생함을 표시

        System.out.println("\n========== 문제 3: final 클래스 ==========");
        // TODO: SecureId 객체 생성 후 출력
        // TODO: 주석으로 SecureId 상속 시도 시 에러 발생함을 표시
        // TODO: final 클래스의 장점을 주석으로 설명

        System.out.println("\n========== 문제 4: 불변 클래스 ImmutablePoint ==========");
        // TODO: ImmutablePoint p1 생성 및 출력
        // TODO: translate() 호출하여 p2 생성, p1이 변하지 않음을 확인
        // TODO: scale() 호출하여 p3 생성, p1이 변하지 않음을 확인
        // TODO: p1과 p2 사이 거리 출력
    }
}

// ================================================================
// 헬퍼 클래스 선언 영역
// ================================================================

// TODO: 문제 1 - Constants 클래스 선언 (모든 필드 static final)
class Constants {
    // TODO: 상수 필드 선언 (MAX_SCORE, MIN_SCORE, APP_NAME, PI, PASSING_GRADE)
}

// TODO: 문제 1 - FinalCircle 클래스 선언
class FinalCircle {
    // TODO: private final double radius 필드 선언

    // TODO: 생성자 FinalCircle(double radius) 작성
    FinalCircle(double radius) {
        // TODO: final 필드 초기화
    }

    // TODO: getArea() 메소드 작성 (Constants.PI 사용)
    double getArea() {
        // TODO
        return 0.0;
    }

    // TODO: getCircumference() 메소드 작성 (Constants.PI 사용)
    double getCircumference() {
        // TODO
        return 0.0;
    }
}

// TODO: 문제 2 - FinalAnimal 클래스 선언
class FinalAnimal {
    // TODO: String name 필드 선언

    // TODO: 생성자 FinalAnimal(String name) 작성
    FinalAnimal(String name) {
        // TODO
    }

    // TODO: final 메소드 breathe() 작성
    final void breathe() {
        // TODO: "[이름]은(는) 숨을 쉽니다." 출력
    }

    // TODO: 일반 메소드 makeSound() 작성 (오버라이딩 가능)
    void makeSound() {
        // TODO: "[이름]이(가) 소리를 냅니다." 출력
    }
}

// TODO: 문제 2 - FinalDog 클래스 선언 (FinalAnimal 상속)
class FinalDog extends FinalAnimal {
    // TODO: 생성자 FinalDog(String name) 작성 (super() 호출)
    FinalDog(String name) {
        super(name); // TODO: 추가 초기화가 있으면 여기에 작성
    }

    // TODO: makeSound() 오버라이딩 → "왈왈!" 소리 출력
    @Override
    void makeSound() {
        // TODO
    }

    // 아래 코드를 주석 해제하면 컴파일 에러 발생 (final 메소드 오버라이딩 불가)
    // @Override
    // void breathe() { }  ← 컴파일 에러: cannot override the final method from FinalAnimal
}

// TODO: 문제 3 - SecureId final 클래스 선언
final class SecureId {
    // TODO: private final String id 필드 선언

    // TODO: 생성자 SecureId(String id) 작성
    SecureId(String id) {
        // TODO
    }

    // TODO: getId() getter 작성
    String getId() {
        // TODO
        return null;
    }

    // TODO: toString() 오버라이딩 작성
    @Override
    public String toString() {
        // TODO: "SecureId[" + id + "]" 형식으로 반환
        return null;
    }
}

// 아래 코드를 주석 해제하면 컴파일 에러 발생 (final 클래스 상속 불가)
// class HackedId extends SecureId { }  ← 컴파일 에러: cannot inherit from final SecureId

// TODO: 문제 4 - ImmutablePoint final 클래스 선언
final class ImmutablePoint {
    // TODO: private final int x, y 필드 선언

    // TODO: 생성자 ImmutablePoint(int x, int y) 작성
    ImmutablePoint(int x, int y) {
        // TODO: final 필드 초기화
    }

    // TODO: getX() getter 작성
    int getX() {
        // TODO
        return 0;
    }

    // TODO: getY() getter 작성
    int getY() {
        // TODO
        return 0;
    }

    // TODO: translate() 메소드 작성 (새 ImmutablePoint 반환, 원본 불변 유지)
    ImmutablePoint translate(int dx, int dy) {
        // TODO: return new ImmutablePoint(x + dx, y + dy);
        return null;
    }

    // TODO: scale() 메소드 작성 (새 ImmutablePoint 반환, 원본 불변 유지)
    ImmutablePoint scale(int factor) {
        // TODO: return new ImmutablePoint(x * factor, y * factor);
        return null;
    }

    // TODO: distanceTo() 메소드 작성 (Math.sqrt 사용)
    double distanceTo(ImmutablePoint other) {
        // TODO: 두 점 사이 거리 계산 후 반환
        return 0.0;
    }

    // TODO: toString() 오버라이딩 작성
    @Override
    public String toString() {
        // TODO: "(x, y)" 형식으로 반환
        return null;
    }
}
