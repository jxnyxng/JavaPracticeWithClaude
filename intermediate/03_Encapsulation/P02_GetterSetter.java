/**
 * ============================================================
 * 파일명: P02_GetterSetter.java
 * 주제: getter/setter와 유효성 검사
 * ============================================================
 *
 * [학습 목표]
 * 1. getter/setter 메소드의 역할과 작성 규칙(getXxx / setXxx)을 이해할 수 있다.
 * 2. setter 내부에서 유효성 검사를 통해 잘못된 데이터 입력을 차단할 수 있다.
 * 3. 읽기 전용 필드(getter만)와 데이터 정제(trim, toLowerCase 등)를 구현할 수 있다.
 *
 * [핵심 개념]
 * - getter: private 필드의 값을 읽어주는 메소드. 형식: public 타입 getFieldName()
 * - setter: private 필드에 값을 저장하는 메소드. 형식: public void setFieldName(타입 값)
 * - 유효성 검사(Validation): setter 내부에서 값의 범위/형식을 검사하여 잘못된 데이터를 거절
 * - 읽기 전용 필드: setter를 제공하지 않으면 외부에서 값을 변경할 수 없음
 * - 데이터 정제(Sanitization): setter에서 값을 저장하기 전에 trim(), toLowerCase() 등으로 가공
 * ============================================================
 */
public class P02_GetterSetter {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: Person 클래스 — 나이·이름 유효성 검사
        // ============================================================
        /*
         * [문제 설명]
         * Person 클래스의 setter에서 아래 규칙을 검사하세요.
         *
         * [유효성 규칙]
         * - name: null이거나 빈 문자열(" "포함)이면 "이름은 공백일 수 없습니다." 출력 후 무시
         * - age : 0 미만이거나 150 초과이면 "나이는 0~150 사이여야 합니다." 출력 후 무시
         *
         * [예상 출력]
         * 이름은 공백일 수 없습니다.
         * 나이는 0~150 사이여야 합니다.
         * 나이는 0~150 사이여야 합니다.
         * 이름: 홍길동, 나이: 30
         *
         * [힌트]
         * - 문자열 공백 검사: name == null || name.trim().isEmpty()
         * - age 범위 검사: age < 0 || age > 150
         */

        System.out.println("=== 문제 1: Person 유효성 검사 ===");

        PersonGS person = new PersonGS();
        person.setName("   ");     // 공백 → 거절
        person.setAge(-1);         // 음수 → 거절
        person.setAge(200);        // 150 초과 → 거절
        person.setName("홍길동"); // 정상
        person.setAge(30);         // 정상
        System.out.println("이름: " + person.getName() + ", 나이: " + person.getAge());

        System.out.println();

        // ============================================================
        // 문제 2: Product 클래스 — 읽기 전용 필드
        // ============================================================
        /*
         * [문제 설명]
         * Product 클래스에는 productId(상품 코드)와 price(가격) 두 필드가 있습니다.
         * - productId: 생성자에서만 설정, 이후 변경 불가 (getter만 제공)
         * - price    : 외부에서 변경 가능 (getter + setter 제공), 단 0 이하이면 거절
         *
         * [예상 출력]
         * 상품 코드: P001, 가격: 15000
         * 변경된 가격: 20000
         * 잘못된 가격입니다. 0보다 커야 합니다.
         * 최종 가격: 20000
         *
         * [힌트]
         * - productId에는 setter를 작성하지 않으면 외부에서 수정 불가
         * - 생성자(constructor)에서 productId와 price를 초기화
         */

        System.out.println("=== 문제 2: 읽기 전용 필드 ===");

        ProductGS product = new ProductGS("P001", 15000);
        System.out.println("상품 코드: " + product.getProductId() + ", 가격: " + product.getPrice());
        product.setPrice(20000);
        System.out.println("변경된 가격: " + product.getPrice());
        product.setPrice(-100);    // 잘못된 가격 → 거절
        System.out.println("최종 가격: " + product.getPrice());

        System.out.println();

        // ============================================================
        // 문제 3: UserProfile 클래스 — setter에서 데이터 정제
        // ============================================================
        /*
         * [문제 설명]
         * 사용자 입력값은 종종 불필요한 공백이나 대소문자가 섞여 있습니다.
         * UserProfile 클래스의 setter에서 값을 저장하기 전에 정제(가공)하세요.
         *
         * [정제 규칙]
         * - setName(String name)  : 앞뒤 공백 제거 후 저장 (trim())
         * - setEmail(String email): 앞뒤 공백 제거 + 모두 소문자로 변환 후 저장
         * - setPhone(String phone): 숫자와 '-' 외의 문자는 모두 제거 후 저장
         *                           예) "010 1234 5678" → "0101234 5678" 아니라
         *                               숫자와 '-'만 남겨 "010-1234-5678" 형태로
         *                           힌트: replaceAll("[^0-9\\-]", "")
         *
         * [예상 출력]
         * 이름: 김자바
         * 이메일: user@example.com
         * 전화번호: 010-1234-5678
         *
         * [힌트]
         * - trim()        : 앞뒤 공백 제거
         * - toLowerCase() : 모두 소문자 변환
         * - replaceAll()  : 정규표현식으로 특정 문자 제거
         */

        System.out.println("=== 문제 3: setter 데이터 정제 ===");

        UserProfile user = new UserProfile();
        user.setName("  김자바  ");               // 앞뒤 공백 제거
        user.setEmail("  User@Example.COM  ");    // 소문자 변환 + 공백 제거
        user.setPhone("010 1234 5678");            // 숫자와 '-'만 남기기
        System.out.println("이름: " + user.getName());
        System.out.println("이메일: " + user.getEmail());
        System.out.println("전화번호: " + user.getPhone());
    }
}

// ============================================================
// Person 클래스 (문제 1)
// ============================================================
class PersonGS {

    // TODO: name(String), age(int) 필드를 private으로 선언하세요.

    /**
     * 이름 getter
     */
    public String getName() {
        // TODO: name을 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 이름 setter — null 또는 공백 문자열이면 거절
     */
    public void setName(String name) {
        // TODO: name이 null이거나 trim() 후 isEmpty()이면
        //       "이름은 공백일 수 없습니다."를 출력하고 return
        //       정상이면 this.name에 저장
    }

    /**
     * 나이 getter
     */
    public int getAge() {
        // TODO: age를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 나이 setter — 0~150 범위 외이면 거절
     */
    public void setAge(int age) {
        // TODO: age가 0 미만이거나 150 초과이면
        //       "나이는 0~150 사이여야 합니다."를 출력하고 return
        //       정상이면 this.age에 저장
    }
}

// ============================================================
// Product 클래스 (문제 2) — productId는 읽기 전용
// ============================================================
class ProductGS {

    // TODO: productId(String), price(int) 필드를 private으로 선언하세요.

    /**
     * 생성자 — productId와 price를 초기화
     * @param productId 상품 코드 (이후 변경 불가)
     * @param price     초기 가격
     */
    public ProductGS(String productId, int price) {
        // TODO: this.productId와 this.price를 초기화하세요.
    }

    /**
     * 상품 코드 getter (setter는 제공하지 않음 → 읽기 전용)
     */
    public String getProductId() {
        // TODO: productId를 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 가격 getter
     */
    public int getPrice() {
        // TODO: price를 반환하세요.
        return 0; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 가격 setter — 0 이하이면 거절
     */
    public void setPrice(int price) {
        // TODO: price가 0 이하이면 "잘못된 가격입니다. 0보다 커야 합니다."를 출력하고 return
        //       정상이면 this.price에 저장
    }
}

// ============================================================
// UserProfile 클래스 (문제 3) — setter에서 데이터 정제
// ============================================================
class UserProfile {

    // TODO: name(String), email(String), phone(String) 필드를 private으로 선언하세요.

    /**
     * 이름 getter
     */
    public String getName() {
        // TODO: name을 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 이름 setter — 앞뒤 공백 제거(trim) 후 저장
     */
    public void setName(String name) {
        // TODO: name.trim()으로 공백을 제거한 뒤 this.name에 저장하세요.
    }

    /**
     * 이메일 getter
     */
    public String getEmail() {
        // TODO: email을 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 이메일 setter — trim() 후 toLowerCase()로 저장
     */
    public void setEmail(String email) {
        // TODO: email을 trim()한 뒤 toLowerCase()로 변환하여 this.email에 저장하세요.
    }

    /**
     * 전화번호 getter
     */
    public String getPhone() {
        // TODO: phone을 반환하세요.
        return null; // 임시 반환값 — 완성 후 삭제
    }

    /**
     * 전화번호 setter — 숫자와 '-' 외의 문자 제거 후 저장
     */
    public void setPhone(String phone) {
        // TODO: phone.replaceAll("[^0-9\\-]", "")으로 숫자와 '-'만 남긴 뒤 저장하세요.
    }
}
