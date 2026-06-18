/**
 * ============================================================
 * 파일명: Challenge03_ShoppingCart.java
 * 제  목: 쇼핑몰 주문 관리 시스템
 * ============================================================
 *
 * [학습 목표]
 * 1. Enum을 활용하여 도메인 상수와 비즈니스 로직을 함께 표현할 수 있다.
 * 2. 내부 클래스(Inner Class)를 사용하여 관련 개념을 논리적으로 묶을 수 있다.
 * 3. 인터페이스와 람다를 조합하여 할인 정책을 유연하게 교체할 수 있다.
 * 4. Stream API로 장바구니 내 데이터를 집계하고 필터링할 수 있다.
 *
 * [핵심 개념 설명]
 * - Enum: 상수 집합에 필드/메서드를 추가하여 타입 안전한 도메인 모델로 활용.
 *   예) Category.ELECTRONICS.getDiscountRate() 처럼 카테고리별 할인율 관리.
 *
 * - 내부 클래스(Inner Class): ShoppingCart 안에 CartItem을 정의하면
 *   두 클래스의 관계가 명확해지고 캡슐화가 강화된다.
 *
 * - 함수형 인터페이스 + Lambda: DiscountPolicy 인터페이스를 람다로 구현하면
 *   할인 정책을 런타임에 교체하거나 조합할 수 있다.
 *
 * - Stream 집계: mapToDouble(...).sum(), reduce(), collect(groupingBy) 등
 *   장바구니 합계/통계 계산에 활용한다.
 * ============================================================
 */

import java.util.*;
import java.util.stream.*;

// ============================================================
// [문제 1] Category Enum
// ============================================================

/**
 * 상품 카테고리를 나타내는 Enum을 완성하세요.
 *
 * 카테고리 목록과 기본 할인율:
 *   ELECTRONICS   → 전자기기,   할인율 10%
 *   CLOTHING      → 의류,       할인율 20%
 *   FOOD          → 식품,       할인율 5%
 *   BOOKS         → 도서,       할인율 15%
 *   SPORTS        → 스포츠용품, 할인율 12%
 *
 * 필드:
 * - displayName   : 한글 카테고리명 (String)
 * - discountRate  : 기본 할인율 (double, 0.0~1.0)
 *
 * 메서드:
 * - getDisplayName()  : 카테고리 한글명 반환
 * - getDiscountRate() : 할인율 반환
 * - apply(double price): price * (1 - discountRate) 로 할인 적용 후 가격 반환
 *
 * 예: Category.ELECTRONICS.apply(100000) → 90000.0
 */
enum Category {
    // TODO: 각 상수 선언 (displayName, discountRate 포함)

    ;   // 세미콜론 위치 유지

    // TODO: 필드 선언

    // TODO: 생성자 작성 (enum 생성자는 private)

    // TODO: getter 및 apply() 메서드 작성
}

// ============================================================
// [문제 2] OrderStatus Enum
// ============================================================

/**
 * 주문 상태를 나타내는 Enum을 완성하세요.
 *
 * 상태 목록:
 *   PENDING    → "결제 대기"
 *   PAID       → "결제 완료"
 *   SHIPPING   → "배송 중"
 *   DELIVERED  → "배송 완료"
 *   CANCELLED  → "취소됨"
 *
 * 메서드:
 * - getLabel()    : 한글 상태명 반환
 * - canCancel()   : PENDING 또는 PAID 상태일 때만 true (취소 가능)
 * - next()        : 다음 상태 반환
 *                   PENDING → PAID → SHIPPING → DELIVERED
 *                   CANCELLED / DELIVERED 는 더 이상 다음 없음 (자기 자신 반환)
 *
 * 힌트: values() 와 ordinal() 을 활용하거나, switch로 구현
 */
enum OrderStatus {
    // TODO: 상수 선언

    ;

    // TODO: 필드 및 생성자

    public String getLabel() {
        // TODO: 구현
        return "";
    }

    public boolean canCancel() {
        // TODO: PENDING 또는 PAID 일 때만 true
        return false;
    }

    public OrderStatus next() {
        // TODO: 구현
        return this;
    }
}

// ============================================================
// [문제 3] DiscountPolicy 함수형 인터페이스
// ============================================================

/**
 * 할인 정책을 표현하는 함수형 인터페이스를 완성하세요.
 *
 * 추상 메서드:
 *   double apply(double originalPrice) — 할인 적용 후 최종 가격 반환
 *
 * default 메서드:
 *   andThen(DiscountPolicy other) — 두 정책을 순서대로 적용하는 합성 정책 반환
 *     예: policy1.andThen(policy2) → price에 policy1 적용 후, 그 결과에 policy2 적용
 *
 * static 팩토리 메서드:
 *   percentage(double rate)   — rate% 할인 정책 (예: 0.1 → 10% 할인)
 *   fixedAmount(double amount)— 고정 금액 할인 (최소 0원)
 *   noDiscount()              — 할인 없음 (price 그대로 반환)
 */
@FunctionalInterface
interface DiscountPolicy {
    double apply(double originalPrice);

    default DiscountPolicy andThen(DiscountPolicy other) {
        // TODO: 구현 — this를 먼저 적용하고, 그 결과를 other에 전달
        return null;
    }

    static DiscountPolicy percentage(double rate) {
        // TODO: 구현
        return null;
    }

    static DiscountPolicy fixedAmount(double amount) {
        // TODO: 구현 (결과가 음수면 0 반환)
        return null;
    }

    static DiscountPolicy noDiscount() {
        // TODO: 구현
        return null;
    }
}

// ============================================================
// [문제 4] Product 클래스
// ============================================================

/**
 * 상품을 나타내는 클래스를 완성하세요.
 *
 * 필드:
 * - id       : 상품 ID (String)
 * - name     : 상품명 (String)
 * - price    : 원가 (double)
 * - category : 카테고리 (Category)
 *
 * 메서드:
 * - 생성자, getter
 * - getDiscountedPrice()  : Category의 기본 할인율 적용 가격 반환
 * - getDiscountedPrice(DiscountPolicy policy) : 전달된 정책으로 할인 적용 가격 반환
 */
class Product {
    // TODO: 필드 선언

    // TODO: 생성자 작성

    // TODO: getter 작성

    public double getDiscountedPrice() {
        // TODO: category.apply(price) 반환
        return 0;
    }

    public double getDiscountedPrice(DiscountPolicy policy) {
        // TODO: policy.apply(price) 반환
        return 0;
    }

    @Override
    public String toString() {
        // TODO: "[전자기기] 노트북 | 원가: 1,200,000원 | 할인가: 1,080,000원" 형식
        return null;
    }
}

// ============================================================
// [문제 5] ShoppingCart 클래스 (내부 클래스 CartItem 포함)
// ============================================================

/**
 * 장바구니 클래스를 완성하세요.
 *
 * 내부 클래스 CartItem:
 *   - product  : Product
 *   - quantity : 수량 (int)
 *   - getSubtotal() : 할인 적용 가격 × 수량
 *
 * ShoppingCart 기능:
 *   - addItem(Product, int quantity)  : 장바구니에 상품 추가
 *   - removeItem(String productId)   : 상품 ID로 제거
 *   - getTotalPrice()                 : 모든 CartItem의 소계 합계 (Stream 사용)
 *   - getTotalPrice(DiscountPolicy)   : 추가 정책 적용 후 합계
 *   - getItemCount()                  : 장바구니 내 총 상품 수량 합계
 *   - getItemsByCategory(Category)    : 특정 카테고리 상품만 필터링
 *   - printCart()                     : 장바구니 내용 출력
 */
class ShoppingCart {

    /**
     * 내부 클래스: 장바구니 항목 (상품 + 수량)
     */
    class CartItem {
        // TODO: 필드 (product, quantity)

        // TODO: 생성자

        // TODO: getter

        public double getSubtotal() {
            // TODO: product.getDiscountedPrice() * quantity
            return 0;
        }

        @Override
        public String toString() {
            // TODO: "노트북 x2 | 할인가: 1,080,000원 | 소계: 2,160,000원" 형식
            return null;
        }
    }

    // TODO: CartItem 목록 필드 (List<CartItem>)

    // TODO: 생성자

    public void addItem(Product product, int quantity) {
        // TODO: 이미 같은 product.getId()가 있으면 수량을 더하고,
        //       없으면 새 CartItem 추가
    }

    public void removeItem(String productId) {
        // TODO: productId에 해당하는 CartItem 제거
        //       힌트: removeIf(item -> item.getProduct().getId().equals(productId))
    }

    public double getTotalPrice() {
        // TODO: Stream으로 모든 CartItem의 getSubtotal() 합계 반환
        return 0;
    }

    public double getTotalPrice(DiscountPolicy additionalPolicy) {
        // TODO: getTotalPrice() 결과에 additionalPolicy 적용
        return 0;
    }

    public int getItemCount() {
        // TODO: 모든 CartItem의 quantity 합산 (mapToInt + sum)
        return 0;
    }

    public List<CartItem> getItemsByCategory(Category category) {
        // TODO: Stream filter로 해당 카테고리 항목만 반환
        return null;
    }

    public void printCart() {
        // TODO: 장바구니 내 항목 출력 후 합계 출력
        //   예:
        //   ===== 장바구니 =====
        //   1. 노트북 x1 | 할인가: 1,080,000원 | 소계: 1,080,000원
        //   2. 자바 교재 x2 | 할인가: 25,500원 | 소계: 51,000원
        //   총 2가지 (3개) | 합계: 1,131,000원
    }
}

// ============================================================
// [문제 6] Order 클래스
// ============================================================

/**
 * 주문을 나타내는 클래스를 완성하세요.
 *
 * 필드:
 * - orderId     : 주문 번호 (String)
 * - cart        : 장바구니 (ShoppingCart)
 * - status      : 주문 상태 (OrderStatus, 초기값 PENDING)
 * - totalAmount : 최종 결제 금액 (double)
 *
 * 메서드:
 * - pay()      : PENDING → PAID 로 상태 변경
 * - ship()     : PAID → SHIPPING 으로 상태 변경
 * - deliver()  : SHIPPING → DELIVERED 로 상태 변경
 * - cancel()   : canCancel()이 true면 CANCELLED로, 아니면 예외 발생
 * - getStatus(): 현재 상태 반환
 * - printOrder(): 주문 정보 출력
 *
 * 힌트: 각 상태 전환 전에 현재 상태가 올바른지 확인하세요.
 *   pay()는 PENDING 상태일 때만 가능, 아니면 IllegalStateException
 */
class Order {
    // TODO: 필드 선언

    public Order(String orderId, ShoppingCart cart) {
        // TODO: 구현 (totalAmount = cart.getTotalPrice())
    }

    public void pay() {
        // TODO: 구현
    }

    public void ship() {
        // TODO: 구현
    }

    public void deliver() {
        // TODO: 구현
    }

    public void cancel() {
        // TODO: 구현
    }

    public OrderStatus getStatus() {
        // TODO: 구현
        return null;
    }

    public void printOrder() {
        // TODO: 주문번호, 상태, 결제금액 출력
        //   예:
        //   ===== 주문 정보 =====
        //   주문번호: ORD-001
        //   주문상태: 결제 완료
        //   결제금액: 1,131,000원
    }
}

// ============================================================
// 메인 클래스 (테스트)
// ============================================================

public class Challenge03_ShoppingCart {

    public static void main(String[] args) {

        System.out.println("=== 쇼핑몰 주문 관리 시스템 테스트 ===\n");

        // 상품 준비
        Product laptop    = new Product("P001", "노트북",       1_200_000, Category.ELECTRONICS);
        Product tShirt    = new Product("P002", "티셔츠",           30_000, Category.CLOTHING);
        Product javaBook  = new Product("P003", "자바 교재",         30_000, Category.BOOKS);
        Product sneakers  = new Product("P004", "운동화",           80_000, Category.SPORTS);
        Product ramen     = new Product("P005", "라면 (20개입)",      8_000, Category.FOOD);

        // [1] 상품 할인가 확인
        System.out.println("=== 상품별 할인가 ===");
        // TODO: 각 상품의 toString() 또는 getDiscountedPrice()를 출력하세요.

        // [2] DiscountPolicy 테스트
        System.out.println("\n=== 할인 정책 테스트 ===");
        DiscountPolicy tenPercent = DiscountPolicy.percentage(0.10);
        DiscountPolicy minus5000  = DiscountPolicy.fixedAmount(5000);
        DiscountPolicy combined   = tenPercent.andThen(minus5000);
        // TODO: laptop에 세 가지 정책을 각각 적용한 가격을 출력하세요.
        //   예:
        //   10% 할인: 1,080,000원
        //   5,000원 할인: 1,195,000원
        //   복합(10% 후 5,000원 추가): 1,075,000원

        // [3] 장바구니 담기
        System.out.println("\n=== 장바구니 ===");
        ShoppingCart cart = new ShoppingCart();
        // TODO: 아래 상품을 장바구니에 담으세요.
        //   laptop x1, tShirt x2, javaBook x3, sneakers x1, ramen x2
        // TODO: cart.printCart() 호출

        // [4] 카테고리 필터링
        System.out.println("\n=== 도서 카테고리 상품 ===");
        // TODO: getItemsByCategory(Category.BOOKS) 결과를 출력하세요.

        // [5] 장바구니 추가 할인 적용
        System.out.println("\n=== 추가 10% 할인 적용 합계 ===");
        // TODO: cart.getTotalPrice(DiscountPolicy.percentage(0.10)) 결과를 출력하세요.

        // [6] 주문 생성 및 상태 전환
        System.out.println("\n=== 주문 처리 ===");
        Order order = new Order("ORD-001", cart);
        order.printOrder();

        // TODO: pay() → ship() → deliver() 순서로 상태를 전환하고 각 단계에서 printOrder() 출력

        // [7] 취소 불가 테스트
        System.out.println("\n=== 취소 시도 (배송 완료 후) ===");
        // TODO: order.cancel() 을 시도하고 IllegalStateException을 catch하여 메시지를 출력하세요.

        // [8] OrderStatus Enum 테스트
        System.out.println("\n=== OrderStatus 전환 순서 ===");
        // TODO: PENDING 부터 next()를 반복 호출하여 전환 순서를 출력하세요.
        //   예: 결제 대기 → 결제 완료 → 배송 중 → 배송 완료
    }
}
