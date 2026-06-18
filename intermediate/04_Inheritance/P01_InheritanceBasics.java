/**
 * ============================================================
 * 파일명: P01_InheritanceBasics.java
 * 주제: 상속 기본 (extends)
 * ============================================================
 *
 * [학습 목표]
 * 1. extends 키워드를 사용하여 부모-자식 클래스 관계를 만들 수 있다.
 * 2. 자식 클래스가 부모 클래스의 필드와 메소드를 물려받는 것을 확인할 수 있다.
 * 3. 자식 클래스에서 부모로부터 받은 것 외에 새로운 필드와 메소드를 추가할 수 있다.
 *
 * [핵심 개념]
 * - 상속(Inheritance): 기존 클래스(부모)를 기반으로 새 클래스(자식)를 만드는 것
 *   → 코드 재사용성이 높아지고, "is-a" 관계를 표현 (개는 동물이다)
 * - extends: 자바에서 상속을 나타내는 키워드
 *   → class 자식클래스 extends 부모클래스
 * - 부모 클래스(Super Class / Parent Class): 공통 속성과 행동을 가진 클래스
 * - 자식 클래스(Sub Class / Child Class): 부모를 상속받아 기능을 확장한 클래스
 * - 단일 상속: 자바는 클래스 다중 상속 불가 (하나의 부모만 extends 가능)
 * ============================================================
 */
public class P01_InheritanceBasics {

    public static void main(String[] args) {

        // ============================================================
        // 문제 1: Animal → Dog / Cat 상속 구조 만들기
        // ============================================================
        /*
         * [문제 설명]
         * Animal 클래스를 부모로 하는 Dog, Cat 자식 클래스를 작성하세요.
         *
         * [클래스 구조]
         * Animal
         *   - name (String)
         *   - sound (String)
         *   + makeSound() : "[name]이(가) [sound] 소리를 낸다." 출력
         *
         * Dog extends Animal
         *   - breed (String) : 품종 (추가 필드)
         *   + fetch()        : "[name]이(가) 공을 가져온다!" 출력 (추가 메소드)
         *
         * Cat extends Animal
         *   - indoor (boolean) : 실내 고양이 여부 (추가 필드)
         *   + purr()           : "[name]이(가) 그루밍을 한다." 출력 (추가 메소드)
         *
         * [예상 출력]
         * 바둑이이(가) 멍멍 소리를 낸다.
         * 바둑이이(가) 공을 가져온다!
         * 나비이(가) 야옹 소리를 낸다.
         * 나비이(가) 그루밍을 한다.
         */

        System.out.println("=== 문제 1: Animal 상속 구조 ===");

        Dog dog = new Dog();
        dog.name = "바둑이";
        dog.sound = "멍멍";
        dog.breed = "진돗개";
        dog.makeSound();    // 부모 메소드 사용
        dog.fetch();        // 자식 고유 메소드

        Cat cat = new Cat();
        cat.name = "나비";
        cat.sound = "야옹";
        cat.indoor = true;
        cat.makeSound();    // 부모 메소드 사용
        cat.purr();         // 자식 고유 메소드

        System.out.println();

        // ============================================================
        // 문제 2: 부모 필드와 메소드 상속 확인
        // ============================================================
        /*
         * [문제 설명]
         * Vehicle 클래스와 이를 상속하는 Bicycle 클래스를 이용해
         * 자식 클래스가 부모의 필드와 메소드를 그대로 사용할 수 있음을 확인하세요.
         *
         * [클래스 구조]
         * Vehicle
         *   - brand (String) : 브랜드
         *   - speed (int)    : 현재 속도
         *   + accelerate(int amount) : speed += amount, "속도: " + speed + "km/h" 출력
         *   + brake(int amount)      : speed -= amount (최솟값 0), 결과 출력
         *
         * Bicycle extends Vehicle
         *   (별도 필드/메소드 없이 부모 것만 사용)
         *
         * [예상 출력]
         * 속도: 20km/h
         * 속도: 35km/h
         * 속도: 15km/h
         *
         * [힌트]
         * Bicycle은 별도 코드 없이 Vehicle의 accelerate, brake를 그대로 호출
         */

        System.out.println("=== 문제 2: 부모 필드/메소드 상속 확인 ===");

        Bicycle bicycle = new Bicycle();
        bicycle.brand = "삼천리";
        bicycle.accelerate(20);    // 부모 메소드 호출
        bicycle.accelerate(15);    // 부모 메소드 호출
        bicycle.brake(20);         // 부모 메소드 호출
        System.out.println("브랜드: " + bicycle.brand);

        System.out.println();

        // ============================================================
        // 문제 3: 자식 클래스에서 새 필드/메소드 추가
        // ============================================================
        /*
         * [문제 설명]
         * Employee(직원) 클래스를 상속하는 Manager(관리자) 클래스를 만드세요.
         * Manager는 Employee의 기본 정보에 더해 팀원 관리 기능을 추가합니다.
         *
         * [클래스 구조]
         * Employee
         *   - name (String)
         *   - salary (int)
         *   + introduce() : "저는 [name]이고, 급여는 [salary]원입니다." 출력
         *
         * Manager extends Employee
         *   - department (String)  : 담당 부서 (추가 필드)
         *   - teamSize (int)       : 팀원 수 (추가 필드)
         *   + manageTeam()         : "[department] 부서 [teamSize]명 팀을 관리합니다." 출력
         *
         * [예상 출력]
         * 저는 김철수이고, 급여는 5000000원입니다.
         * 개발 부서 10명 팀을 관리합니다.
         *
         * [힌트]
         * Manager 클래스에 department, teamSize 필드와 manageTeam() 메소드를 추가
         */

        System.out.println("=== 문제 3: 자식 클래스에서 새 필드/메소드 추가 ===");

        Manager manager = new Manager();
        manager.name = "김철수";
        manager.salary = 5000000;
        manager.department = "개발";
        manager.teamSize = 10;
        manager.introduce();        // 부모 메소드
        manager.manageTeam();       // 자식 고유 메소드
    }
}

// ============================================================
// Animal 클래스 (문제 1 - 부모 클래스)
// ============================================================
class Animal {

    // TODO: name(String), sound(String) 필드를 선언하세요.

    /**
     * 동물 소리 출력
     */
    public void makeSound() {
        // TODO: "[name]이(가) [sound] 소리를 낸다." 형식으로 출력하세요.
    }
}

// ============================================================
// Dog 클래스 (문제 1 - Animal을 상속)
// ============================================================
class Dog extends Animal {

    // TODO: breed(String) 필드를 추가하세요.

    /**
     * 공 가져오기 동작
     */
    public void fetch() {
        // TODO: "[name]이(가) 공을 가져온다!" 출력하세요.
    }
}

// ============================================================
// Cat 클래스 (문제 1 - Animal을 상속)
// ============================================================
class Cat extends Animal {

    // TODO: indoor(boolean) 필드를 추가하세요.

    /**
     * 그루밍 동작
     */
    public void purr() {
        // TODO: "[name]이(가) 그루밍을 한다." 출력하세요.
    }
}

// ============================================================
// Vehicle 클래스 (문제 2 - 부모 클래스)
// ============================================================
class Vehicle {

    // TODO: brand(String), speed(int) 필드를 선언하세요.

    /**
     * 가속 메소드
     * @param amount 증가할 속도
     */
    public void accelerate(int amount) {
        // TODO: speed에 amount를 더하고 "속도: " + speed + "km/h" 출력
    }

    /**
     * 감속 메소드
     * @param amount 감소할 속도 (speed가 0 미만이 되지 않도록)
     */
    public void brake(int amount) {
        // TODO: speed에서 amount를 빼되 0 미만이 되지 않도록 처리 후 출력
        //       힌트: speed = Math.max(0, speed - amount);
    }
}

// ============================================================
// Bicycle 클래스 (문제 2 - Vehicle을 상속, 추가 코드 없음)
// ============================================================
class Bicycle extends Vehicle {
    // TODO: Vehicle을 상속하도록 선언만 하세요.
    //       별도 필드나 메소드 없이 부모 것을 그대로 사용합니다.
}

// ============================================================
// Employee 클래스 (문제 3 - 부모 클래스)
// ============================================================
class Employee {

    // TODO: name(String), salary(int) 필드를 선언하세요.

    /**
     * 자기소개 출력
     */
    public void introduce() {
        // TODO: "저는 [name]이고, 급여는 [salary]원입니다." 출력
    }
}

// ============================================================
// Manager 클래스 (문제 3 - Employee를 상속)
// ============================================================
class Manager extends Employee {

    // TODO: department(String), teamSize(int) 필드를 추가하세요.

    /**
     * 팀 관리 메소드
     */
    public void manageTeam() {
        // TODO: "[department] 부서 [teamSize]명 팀을 관리합니다." 출력
    }
}
