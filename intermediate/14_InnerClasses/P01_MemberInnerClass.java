/**
 * ================================================================
 * 파일명: P01_MemberInnerClass.java
 * 주제: 멤버 내부 클래스 (Member Inner Class)
 * ================================================================
 *
 * 【학습 목표】
 * 1. 외부 클래스 내부에 멤버 내부 클래스를 정의하는 방법을 이해한다.
 * 2. 내부 클래스에서 외부 클래스의 멤버(필드, 메소드)에 접근하는 방법을 익힌다.
 * 3. 내부 클래스의 인스턴스를 생성하는 다양한 방법을 습득한다.
 *
 * 【핵심 개념】
 * - 멤버 내부 클래스: 외부 클래스의 멤버로 선언된 클래스
 * - 내부 클래스는 외부 클래스의 모든 멤버(private 포함)에 접근 가능
 * - 내부 클래스 인스턴스 생성: 외부클래스인스턴스.new 내부클래스()
 * - 내부 클래스에서 외부 클래스 참조: 외부클래스명.this
 * - 내부 클래스는 static 멤버를 가질 수 없음 (static 변수 제외)
 * ================================================================
 */
public class P01_MemberInnerClass {

    // ================================================================
    // 문제 1: 외부 클래스 안에 내부 클래스 정의하기
    // ================================================================
    /**
     * 【문제 1】 자동차와 엔진 - 멤버 내부 클래스 정의
     *
     * 설명:
     *   Car 외부 클래스와 그 내부에 Engine 멤버 내부 클래스를 정의하세요.
     *   Car는 브랜드(brand)와 모델(model) 정보를 가집니다.
     *   Engine은 마력(horsepower)과 연료타입(fuelType) 정보를 가집니다.
     *   Engine은 자신의 정보를 출력하는 displayInfo() 메소드를 가집니다.
     *
     * 예상 출력:
     *   Car: Tesla Model3
     *   Engine Info: 350마력, 전기
     *
     * 힌트:
     *   - 외부 클래스 안에 class 키워드로 내부 클래스를 선언합니다.
     *   - 내부 클래스는 외부 클래스와 별도의 .class 파일로 컴파일됩니다.
     *     (파일명: 외부클래스$내부클래스.class)
     */
    static class Car {
        private String brand;
        private String model;

        // TODO: Car 생성자 작성 (brand, model 매개변수)

        // TODO: Car 정보를 출력하는 displayCarInfo() 메소드 작성

        // TODO: Engine 멤버 내부 클래스를 Car 클래스 내부에 정의
        //       - int horsepower 필드
        //       - String fuelType 필드
        //       - Engine 생성자 (horsepower, fuelType 매개변수)
        //       - displayInfo() 메소드: "Engine Info: X마력, Y" 형식으로 출력
        class Engine {
            // TODO: 필드 선언

            // TODO: 생성자 작성

            // TODO: displayInfo() 메소드 작성
        }
    }

    // ================================================================
    // 문제 2: 내부 클래스에서 외부 클래스 멤버 접근
    // ================================================================
    /**
     * 【문제 2】 계좌와 이자계산기 - 외부 클래스 멤버 접근
     *
     * 설명:
     *   BankAccount 외부 클래스와 내부 클래스 InterestCalculator를 정의하세요.
     *   BankAccount는 계좌번호(accountNumber)와 잔액(balance)을 가집니다.
     *   InterestCalculator는 외부 클래스의 balance에 직접 접근하여
     *   연이율(annualRate)에 따른 월 이자를 계산하고 반환합니다.
     *   calculateMonthlyInterest() 메소드는 balance * annualRate / 12 를 반환합니다.
     *   displayAccountWithInterest() 메소드는 계좌 정보와 월 이자를 출력합니다.
     *
     * 예상 출력:
     *   계좌번호: 123-456-789
     *   잔액: 1,000,000원
     *   월 이자 (연 3.5%): 2916.67원
     *
     * 힌트:
     *   - 내부 클래스에서 외부 클래스의 private 필드에도 직접 접근 가능합니다.
     *   - 외부 클래스 참조: BankAccount.this.balance
     *   - String.format("%.2f", value)로 소수점 2자리 표현 가능합니다.
     */
    static class BankAccount {
        private String accountNumber;
        private double balance;

        // TODO: BankAccount 생성자 작성

        // TODO: InterestCalculator 내부 클래스 정의
        //       - double annualRate 필드
        //       - 생성자 (annualRate 매개변수)
        //       - calculateMonthlyInterest() 메소드: 외부 클래스의 balance에 접근하여 계산
        //       - displayAccountWithInterest() 메소드: 계좌번호, 잔액, 월 이자 출력
        class InterestCalculator {
            // TODO: 필드 선언

            // TODO: 생성자 작성

            // TODO: calculateMonthlyInterest() 메소드 작성

            // TODO: displayAccountWithInterest() 메소드 작성
        }
    }

    // ================================================================
    // 문제 3: 내부 클래스 인스턴스 생성 방법
    // ================================================================
    /**
     * 【문제 3】 컴퓨터와 CPU - 내부 클래스 인스턴스 생성
     *
     * 설명:
     *   Computer 외부 클래스와 CPU 멤버 내부 클래스를 정의하세요.
     *   Computer는 제조사(manufacturer)와 시리얼번호(serialNumber)를 가집니다.
     *   CPU는 코어수(cores)와 클럭속도(clockSpeed, GHz)를 가집니다.
     *
     *   main 메소드에서 다음 두 가지 방식으로 CPU 인스턴스를 생성하세요:
     *   방식 1: Computer 인스턴스를 먼저 생성 후 내부 클래스 인스턴스 생성
     *            Computer comp = new Computer("Samsung", "SN-001");
     *            Computer.CPU cpu1 = comp.new CPU(8, 3.5);
     *   방식 2: Computer 클래스에 getCPU() 팩토리 메소드를 만들어서 생성
     *            Computer.CPU cpu2 = comp.getCPU(4, 2.8);
     *
     * 예상 출력:
     *   [방식 1] 직접 생성:
     *   컴퓨터: Samsung (SN-001)
     *   CPU: 8코어, 3.5GHz
     *
     *   [방식 2] 팩토리 메소드:
     *   컴퓨터: Samsung (SN-001)
     *   CPU: 4코어, 2.8GHz
     *
     * 힌트:
     *   - 내부 클래스 인스턴스 생성 문법: 외부클래스참조.new 내부클래스()
     *   - 외부 클래스 없이는 내부 클래스 인스턴스를 단독으로 생성할 수 없습니다.
     *   - getCPU() 메소드는 내부 클래스 타입을 반환합니다: public CPU getCPU(...)
     */
    static class Computer {
        private String manufacturer;
        private String serialNumber;

        // TODO: Computer 생성자 작성

        // TODO: CPU 내부 클래스 정의
        //       - int cores 필드
        //       - double clockSpeed 필드
        //       - CPU 생성자 작성
        //       - displayCPUInfo() 메소드: "CPU: X코어, XGHz" 형식으로 출력
        class CPU {
            // TODO: 필드 선언

            // TODO: 생성자 작성

            // TODO: displayCPUInfo() 메소드 작성
        }

        // TODO: getCPU() 팩토리 메소드 작성
        //       Computer 정보를 출력하고 새 CPU 인스턴스를 반환

        // TODO: displayComputerInfo() 메소드 작성
    }

    // ================================================================
    // 메인 메소드: 모든 문제 테스트
    // ================================================================
    public static void main(String[] args) {

        System.out.println("=== 문제 1: 외부 클래스 안에 내부 클래스 정의 ===");
        // TODO: Car 인스턴스 생성 (Tesla, Model3)
        // TODO: Car.Engine 인스턴스 생성 (350마력, 전기)
        // TODO: car.displayCarInfo() 호출
        // TODO: engine.displayInfo() 호출

        System.out.println("\n=== 문제 2: 내부 클래스에서 외부 클래스 멤버 접근 ===");
        // TODO: BankAccount 인스턴스 생성 (계좌번호: "123-456-789", 잔액: 1000000)
        // TODO: BankAccount.InterestCalculator 인스턴스 생성 (연이율: 0.035)
        // TODO: calculator.displayAccountWithInterest() 호출

        System.out.println("\n=== 문제 3: 내부 클래스 인스턴스 생성 방법 ===");
        // TODO: Computer 인스턴스 생성
        // TODO: 방식 1로 CPU 인스턴스 생성 및 출력
        // TODO: 방식 2로 getCPU() 통해 CPU 인스턴스 생성 및 출력
    }
}
