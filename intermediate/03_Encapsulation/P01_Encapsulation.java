/**
 * ============================================================
 * 파일명: P01_Encapsulation.java
 * 주제: 캡슐화 (Encapsulation)
 * ============================================================
 *
 * [학습 목표]
 * 1. 캡슐화의 개념과 필요성을 이해하고 private 접근 제어자를 활용할 수 있다.
 * 2. 접근 제어자 4가지(public, protected, default, private)의 차이를 설명할 수 있다.
 * 3. 캡슐화 적용 전후 코드를 비교하여 데이터 보호의 중요성을 이해할 수 있다.
 *
 * [핵심 개념]
 * - 캡슐화(Encapsulation): 객체의 데이터(필드)를 외부에서 직접 접근하지 못하도록
 *   숨기고, 메소드를 통해서만 접근하도록 제한하는 객체지향 원칙
 * - 접근 제어자(Access Modifier): 클래스, 필드, 메소드에 대한 접근 범위를 지정
 *   - public    : 어디서든 접근 가능
 *   - protected : 같은 패키지 + 자식 클래스에서 접근 가능
 *   - default   : 같은 패키지에서만 접근 가능 (아무것도 안 쓸 때)
 *   - private   : 같은 클래스 내에서만 접근 가능
 * - 데이터 은닉(Data Hiding): 잘못된 값이 들어오지 못하도록 유효성 검사와 함께 사용
 * ============================================================
 */
public class P01_Encapsulation {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: BankAccount 클래스 - 잘못된 입금/출금 차단
        // ============================================================
        /*
         * [문제 설명]
         * 은행 계좌를 나타내는 BankAccount 클래스를 완성하세요.
         * balance(잔액) 필드는 private으로 선언하고,
         * 입금(deposit)과 출금(withdraw) 메소드에서 잘못된 금액을 차단해야 합니다.
         *
         * [요구사항]
         * - balance 필드: private, 초기값 0
         * - deposit(int amount): 금액이 0 이하면 "잘못된 입금액입니다." 출력 후 무시
         * - withdraw(int amount): 금액이 0 이하거나 잔액보다 크면 거절
         * - getBalance(): 잔액 반환
         *
         * [예상 출력]
         * 입금 완료. 현재 잔액: 10000
         * 출금 완료. 현재 잔액: 7000
         * 잔액이 부족합니다. 현재 잔액: 7000
         * 잘못된 입금액입니다.
         */

        System.out.println("=== 문제 1: BankAccount 캡슐화 ===");

        BankAccount account = new BankAccount();
        account.deposit(10000);         // 정상 입금
        account.withdraw(3000);         // 정상 출금
        account.withdraw(99999);        // 잔액 부족 → 거절
        account.deposit(-500);          // 잘못된 금액 → 거절

        System.out.println();

        // ============================================================
        // 문제 2: 접근 제어자 4가지 비교
        // ============================================================
        /*
         * [문제 설명]
         * AccessDemo 클래스에는 4가지 접근 제어자로 선언된 필드가 있습니다.
         * main 메소드에서 각 필드에 접근해보고, 접근 가능 여부를 확인하세요.
         *
         * [요구사항]
         * - publicField    : public    → 어디서든 접근 가능
         * - protectedField : protected → 같은 패키지/자식 클래스 접근 가능
         * - defaultField   : (없음)    → 같은 패키지만 접근 가능
         * - privateField   : private   → 클래스 내부만 접근 가능
         *
         * [예상 출력]
         * public 필드 값: PUBLIC_VALUE
         * protected 필드 값: PROTECTED_VALUE
         * default 필드 값: DEFAULT_VALUE
         * private 필드는 외부에서 직접 접근 불가 → getter 사용: PRIVATE_VALUE
         */

        System.out.println("=== 문제 2: 접근 제어자 4가지 비교 ===");

        AccessDemo demo = new AccessDemo();
        // TODO: 각 필드에 접근하거나 getter 메소드를 호출하여 값을 출력하세요.
        //       단, privateField는 직접 접근 불가이므로 getPrivateField()를 사용하세요.

        System.out.println();

        // ============================================================
        // 문제 3: 캡슐화 전/후 비교
        // ============================================================
        /*
         * [문제 설명]
         * 캡슐화를 적용하지 않은 PersonBad 클래스와
         * 캡슐화를 적용한 PersonGood 클래스를 비교하세요.
         *
         * [요구사항]
         * PersonBad  - age 필드가 public → 외부에서 -999 같은 이상한 값 대입 가능
         * PersonGood - age 필드가 private → setAge()에서 0~150 범위 검증
         *
         * [예상 출력]
         * [캡슐화 전] 나이: -999  ← 이상한 값이 그대로 저장됨
         * [캡슐화 후] 유효하지 않은 나이입니다: -999
         * [캡슐화 후] 나이: 25
         */

        System.out.println("=== 문제 3: 캡슐화 전/후 비교 ===");

        // 캡슐화 전 (나쁜 예시)
        PersonBad bad = new PersonBad();
        bad.age = -999;             // 아무 제한 없이 이상한 값 대입 가능
        System.out.println("[캡슐화 전] 나이: " + bad.age);

        // 캡슐화 후 (좋은 예시)
        PersonGood good = new PersonGood();
        good.setAge(-999);          // 유효성 검사로 거절
        good.setAge(25);            // 정상 값
        System.out.println("[캡슐화 후] 나이: " + good.getAge());
    }
}

// ============================================================
// BankAccount 클래스 (문제 1)
// ============================================================
class BankAccount {

    // TODO: balance 필드를 private int로 선언하세요. 초기값은 0.

    /**
     * 입금 메소드
     * @param amount 입금할 금액 (0 이하면 거절)
     */
    public void deposit(int amount) {
        // TODO: amount가 0 이하이면 "잘못된 입금액입니다."를 출력하고 return하세요.
        //       정상이면 balance에 더하고 "입금 완료. 현재 잔액: " + balance 출력
    }

    /**
     * 출금 메소드
     * @param amount 출금할 금액 (0 이하이거나 잔액 초과 시 거절)
     */
    public void withdraw(int amount) {
        // TODO: amount가 0 이하이면 "잘못된 출금액입니다." 출력 후 return
        //       amount가 balance보다 크면 "잔액이 부족합니다. 현재 잔액: " + balance 출력 후 return
        //       정상이면 balance에서 빼고 "출금 완료. 현재 잔액: " + balance 출력
    }

    /**
     * 잔액 조회 (읽기 전용 getter)
     */
    public int getBalance() {
        // TODO: balance를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }
}

// ============================================================
// AccessDemo 클래스 (문제 2)
// ============================================================
class AccessDemo {

    // TODO: 아래 4가지 접근 제어자로 필드를 선언하세요.
    //       각각 문자열 값("PUBLIC_VALUE", "PROTECTED_VALUE", "DEFAULT_VALUE", "PRIVATE_VALUE")을 초기값으로 설정

    // public    필드: publicField
    // protected 필드: protectedField
    // default   필드: defaultField (접근 제어자 키워드 없음)
    // private   필드: privateField

    /**
     * privateField 조회용 getter
     */
    public String getPrivateField() {
        // TODO: privateField를 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }
}

// ============================================================
// PersonBad 클래스 — 캡슐화 적용 전 (문제 3)
// ============================================================
class PersonBad {
    // 캡슐화 전: 필드가 public이라 아무 제한 없이 접근 가능 (나쁜 예시)
    public int age;
}

// ============================================================
// PersonGood 클래스 — 캡슐화 적용 후 (문제 3)
// ============================================================
class PersonGood {

    // TODO: age 필드를 private int로 선언하세요.

    /**
     * 나이 setter — 0 이상 150 이하만 허용
     */
    public void setAge(int age) {
        // TODO: age가 0 미만이거나 150 초과이면
        //       "유효하지 않은 나이입니다: " + age 를 출력하고 return
        //       정상 범위이면 this.age에 저장
    }

    /**
     * 나이 getter
     */
    public int getAge() {
        // TODO: age를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }
}
