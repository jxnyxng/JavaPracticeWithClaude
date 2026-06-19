/**
 * =====================================================================
 * Challenge01_BankSystem.java - 은행 계좌 관리 시스템
 * =====================================================================
 *
 * [학습 목표]
 * 1. 상속(Inheritance)과 다형성(Polymorphism)을 활용하여 계좌 클래스 계층 구조를 설계할 수 있다.
 * 2. 커스텀 예외(Custom Exception)를 정의하고 예외 상황을 적절히 처리할 수 있다.
 * 3. HashMap과 ArrayList를 이용하여 계좌 및 거래 내역을 효율적으로 관리할 수 있다.
 *
 * [핵심 개념 설명]
 * - 상속(Inheritance): 부모 클래스의 필드와 메소드를 자식 클래스가 물려받는 OOP 핵심 개념
 *   예) SavingsAccount extends Account → Account의 기능을 모두 사용 가능
 *
 * - 다형성(Polymorphism): 부모 타입 참조 변수로 자식 객체를 다루는 개념
 *   예) Account acc = new SavingsAccount(...); → acc.calculateInterest() 호출 시 자식 메소드 실행
 *
 * - 커스텀 예외(Custom Exception): Exception 또는 RuntimeException을 상속하여 도메인 특화 예외 정의
 *   예) InsufficientFundsException → 잔액 부족 시 발생
 *
 * - HashMap<K, V>: 키-값 쌍으로 데이터를 저장하는 자료구조. 계좌번호(String)로 Account 객체를 O(1)에 조회
 *
 * - ArrayList<E>: 동적 배열 기반 리스트. 거래 내역을 순서대로 저장
 * =====================================================================
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// =====================================================================
// 커스텀 예외 클래스
// =====================================================================

/**
 * 잔액 부족 예외 - 출금 또는 송금 시 잔액이 요청 금액보다 적을 때 발생
 */
class InsufficientFundsException extends Exception {

    // TODO: 생성자 1 - 기본 메시지 ("잔액이 부족합니다.")
    public InsufficientFundsException() {
        // TODO: super() 로 부모 생성자 호출
    }

    // TODO: 생성자 2 - 현재 잔액과 요청 금액을 포함한 상세 메시지
    public InsufficientFundsException(double balance, double amount) {
        // TODO: "잔액 부족: 현재 잔액 {balance}원, 요청 금액 {amount}원" 형식의 메시지 전달
    }
}

/**
 * 계좌 미존재 예외 - 존재하지 않는 계좌번호로 조회/송금 시도 시 발생
 */
class AccountNotFoundException extends Exception {

    // TODO: 계좌번호를 포함한 메시지로 예외를 생성하는 생성자 작성
    public AccountNotFoundException(String accountNumber) {
        // TODO: "{accountNumber} 계좌를 찾을 수 없습니다." 형식의 메시지 전달
    }
}

// =====================================================================
// 거래 내역 클래스
// =====================================================================

/**
 * Transaction - 단일 거래 내역을 나타내는 클래스
 * 거래 유형(입금/출금/이자/수수료/송금), 금액, 거래 후 잔액, 메모를 저장
 */
class Transaction {
    private String type;      // 거래 유형: "입금", "출금", "이자", "수수료", "송금"
    private double amount;    // 거래 금액
    private double balance;   // 거래 후 잔액
    private String memo;      // 거래 메모
    private String timestamp; // 거래 시각 (간단히 문자열로 표현)

    // TODO: 생성자 작성 (type, amount, balance, memo 초기화, timestamp는 현재 시간 문자열)
    public Transaction(String type, double amount, double balance, String memo) {
        // TODO: 필드 초기화
    }

    // TODO: toString() 오버라이드 - "[거래유형] 금액: {amount}원 | 잔액: {balance}원 | 메모: {memo}" 형식
    @Override
    public String toString() {
        // TODO: 구현
        return "";
    }

    // TODO: 각 필드의 getter 메소드 작성
    public String getType() { return type; }
    public double getAmount() { return amount; }
    public double getBalance() { return balance; }
    public String getMemo() { return memo; }
}

// =====================================================================
// 계좌 추상 클래스 (부모 클래스)
// =====================================================================

/**
 * Account - 모든 계좌 유형의 공통 기반이 되는 추상 클래스
 *
 * 공통 필드: 계좌번호, 예금주명, 잔액, 이자율
 * 추상 메소드: calculateInterest() - 자식 클래스마다 이자/수수료 계산 방식이 다름
 */
abstract class Account {
    protected String accountNumber;        // 계좌번호 (예: "ACC-001")
    protected String ownerName;            // 예금주명
    protected double balance;             // 현재 잔액
    protected double interestRate;        // 이자율 (예: 0.03 = 3%)
    protected List<Transaction> history;  // 거래 내역 목록

    // TODO: 생성자 작성 (accountNumber, ownerName, initialBalance, interestRate 초기화)
    //       history는 새 ArrayList로 초기화
    public Account(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        // TODO: 필드 초기화
    }

    /**
     * 문제 1: 입금 메소드 구현
     * -----------------------------------------
     * [상세 설명]
     * 지정된 금액을 계좌 잔액에 추가합니다.
     * 입금 후 거래 내역(Transaction)을 history에 추가해야 합니다.
     *
     * [조건]
     * - amount가 0 이하이면 IllegalArgumentException 발생 ("입금액은 0보다 커야 합니다.")
     * - 정상 입금 시 balance 증가, Transaction("입금", amount, balance, "입금") 기록
     *
     * [예상 출력]
     * account.deposit(50000);
     * → 잔액: 150000.0원 (초기 잔액 100000원 가정)
     *
     * [힌트]
     * - balance += amount 로 잔액 증가
     * - history.add(new Transaction(...)) 으로 내역 기록
     */
    public void deposit(double amount) {
        // TODO: amount 유효성 검사 (0 이하 시 IllegalArgumentException)
        // TODO: balance에 amount 추가
        // TODO: 거래 내역 기록
    }

    /**
     * 문제 2: 출금 메소드 구현
     * -----------------------------------------
     * [상세 설명]
     * 지정된 금액을 계좌 잔액에서 차감합니다.
     * 잔액이 부족하면 InsufficientFundsException을 발생시켜야 합니다.
     *
     * [조건]
     * - amount가 0 이하이면 IllegalArgumentException 발생
     * - balance < amount 이면 InsufficientFundsException(balance, amount) 발생
     * - 정상 출금 시 balance 감소, Transaction("출금", amount, balance, "출금") 기록
     *
     * [예상 출력]
     * account.withdraw(30000);
     * → 잔액: 70000.0원
     *
     * account.withdraw(200000); // 잔액 부족
     * → InsufficientFundsException: 잔액 부족: 현재 잔액 70000.0원, 요청 금액 200000.0원
     *
     * [힌트]
     * - throws InsufficientFundsException 선언 필요
     * - balance < amount 조건 확인 후 예외 발생
     */
    public void withdraw(double amount) throws InsufficientFundsException {
        // TODO: amount 유효성 검사
        // TODO: 잔액 부족 검사 및 예외 발생
        // TODO: balance에서 amount 차감
        // TODO: 거래 내역 기록
    }

    /**
     * 추상 메소드: 이자/수수료 계산 및 적용
     * - SavingsAccount: 잔액 × 이자율만큼 이자 입금
     * - CheckingAccount: 고정 수수료를 잔액에서 차감
     */
    public abstract void calculateInterest() throws InsufficientFundsException;

    /**
     * 거래 내역 전체 출력
     */
    public void printHistory() {
        // TODO: history가 비어있으면 "거래 내역이 없습니다." 출력
        // TODO: 각 Transaction의 toString()을 출력
    }

    // TODO: getter 메소드 작성 (accountNumber, ownerName, balance, interestRate, history)
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }
    public double getInterestRate() { return interestRate; }
    public List<Transaction> getHistory() { return history; }

    // TODO: toString() 오버라이드 - 계좌번호, 예금주, 잔액 정보 출력
    @Override
    public String toString() {
        // TODO: "[계좌: {accountNumber}] 예금주: {ownerName} | 잔액: {balance}원" 형식
        return "";
    }
}

// =====================================================================
// 저축 계좌 (자식 클래스 1)
// =====================================================================

/**
 * SavingsAccount - 이자가 적용되는 저축 계좌
 *
 * 이자 계산: balance × interestRate 만큼 잔액 증가
 * 예) 잔액 1,000,000원, 이자율 3% → 이자 30,000원 입금
 */
class SavingsAccount extends Account {

    // TODO: 생성자 작성 - 부모 생성자 호출 (super(...))
    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance, interestRate); // TODO: 추가 초기화 필요 시 작성
    }

    /**
     * 문제 3: 저축 계좌 이자 계산 구현
     * -----------------------------------------
     * [상세 설명]
     * 현재 잔액에 이자율을 곱한 금액만큼 이자를 적용합니다.
     * 이자는 잔액에 직접 추가되며, 거래 내역에 "이자" 유형으로 기록됩니다.
     *
     * [예상 출력]
     * SavingsAccount acc = new SavingsAccount("ACC-001", "홍길동", 1000000, 0.03);
     * acc.calculateInterest();
     * → 이자 적용: 30000.0원 | 새 잔액: 1030000.0원
     *
     * [힌트]
     * - interest = balance * interestRate 계산
     * - balance += interest
     * - history에 Transaction("이자", interest, balance, "이자 적용") 기록
     */
    @Override
    public void calculateInterest() throws InsufficientFundsException {
        // TODO: 이자 금액 계산
        // TODO: 잔액에 이자 추가
        // TODO: 거래 내역 기록
        // TODO: 이자 적용 메시지 출력
    }

    @Override
    public String toString() {
        // TODO: 부모 toString() + " [저축 계좌] 이자율: {interestRate*100}%" 형식
        return "";
    }
}

// =====================================================================
// 당좌 계좌 (자식 클래스 2)
// =====================================================================

/**
 * CheckingAccount - 수수료가 부과되는 당좌 계좌 (체크 계좌)
 *
 * 수수료 계산: 매월 고정 수수료(monthlyFee) 차감
 * 잔액 < 수수료 시 InsufficientFundsException 발생
 */
class CheckingAccount extends Account {
    private double monthlyFee; // 월 수수료 금액

    // TODO: 생성자 작성 - 부모 생성자 호출 + monthlyFee 초기화
    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double interestRate, double monthlyFee) {
        super(accountNumber, ownerName, initialBalance, interestRate); // TODO: 아래에 this.monthlyFee = monthlyFee; 작성
    }

    /**
     * 문제 4: 당좌 계좌 수수료 계산 구현
     * -----------------------------------------
     * [상세 설명]
     * 월 수수료를 잔액에서 차감합니다.
     * 잔액이 수수료보다 적으면 InsufficientFundsException을 발생시킵니다.
     *
     * [예상 출력]
     * CheckingAccount acc = new CheckingAccount("ACC-002", "김철수", 500000, 0.01, 5000);
     * acc.calculateInterest();
     * → 수수료 차감: 5000.0원 | 새 잔액: 495000.0원
     *
     * [힌트]
     * - balance < monthlyFee 이면 InsufficientFundsException 발생
     * - balance -= monthlyFee
     * - history에 Transaction("수수료", monthlyFee, balance, "월 수수료 차감") 기록
     */
    @Override
    public void calculateInterest() throws InsufficientFundsException {
        // TODO: 잔액 < 수수료 검사
        // TODO: 수수료 차감
        // TODO: 거래 내역 기록
        // TODO: 수수료 차감 메시지 출력
    }

    public double getMonthlyFee() { return monthlyFee; }

    @Override
    public String toString() {
        // TODO: 부모 toString() + " [당좌 계좌] 월 수수료: {monthlyFee}원" 형식
        return "";
    }
}

// =====================================================================
// 은행 관리 클래스
// =====================================================================

/**
 * Bank - 모든 계좌를 HashMap으로 관리하는 은행 클래스
 *
 * 계좌번호(String) → Account 객체 매핑으로 O(1) 조회 가능
 */
class Bank {
    private String bankName;                        // 은행명
    private Map<String, Account> accounts;          // 계좌번호 → 계좌 객체 맵

    // TODO: 생성자 작성 (bankName 초기화, accounts는 새 HashMap)
    public Bank(String bankName) {
        // TODO: 필드 초기화
    }

    /**
     * 문제 5: 계좌 개설 및 조회 구현
     * -----------------------------------------
     * [상세 설명 - 계좌 개설]
     * 새 계좌를 HashMap에 추가합니다.
     * 이미 존재하는 계좌번호이면 예외를 발생시킵니다.
     *
     * [상세 설명 - 계좌 조회]
     * 계좌번호로 계좌를 검색합니다.
     * 존재하지 않으면 AccountNotFoundException을 발생시킵니다.
     *
     * [예상 출력 - 개설]
     * bank.openAccount(new SavingsAccount("ACC-001", "홍길동", 100000, 0.03));
     * → 계좌 개설 완료: ACC-001 (홍길동)
     *
     * [예상 출력 - 조회]
     * Account acc = bank.findAccount("ACC-001");
     * → [계좌: ACC-001] 예금주: 홍길동 | 잔액: 100000.0원 [저축 계좌] 이자율: 3.0%
     *
     * [힌트 - 개설]
     * - accounts.containsKey(account.getAccountNumber()) 로 중복 확인
     * - accounts.put(계좌번호, 계좌객체)
     *
     * [힌트 - 조회]
     * - accounts.get(accountNumber) 로 조회
     * - null 이면 AccountNotFoundException 발생
     */
    public void openAccount(Account account) {
        // TODO: 중복 계좌번호 검사
        // TODO: accounts에 계좌 추가
        // TODO: 개설 완료 메시지 출력
    }

    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        // TODO: accounts에서 계좌 조회
        // TODO: 없으면 AccountNotFoundException 발생
        // TODO: 찾은 계좌 반환
        return null;
    }

    /**
     * 문제 6: 계좌 간 송금 구현
     * -----------------------------------------
     * [상세 설명]
     * fromAccountNumber 계좌에서 toAccountNumber 계좌로 amount를 송금합니다.
     * 두 계좌 모두 존재해야 하며, 출금 계좌의 잔액이 충분해야 합니다.
     *
     * [처리 순서]
     * 1. 두 계좌 모두 findAccount()로 조회 (없으면 AccountNotFoundException)
     * 2. 출금 계좌에서 withdraw(amount) (잔액 부족 시 InsufficientFundsException)
     * 3. 입금 계좌에 deposit(amount)
     * 4. 각 계좌의 거래 내역에 송금 메모 기록
     *
     * [예상 출력]
     * bank.transfer("ACC-001", "ACC-002", 50000);
     * → 송금 완료: ACC-001 → ACC-002, 금액: 50000.0원
     *
     * [힌트]
     * - try-catch로 AccountNotFoundException, InsufficientFundsException 처리
     * - 출금 후 거래 내역 메모를 "ACC-002로 송금"으로 기록
     * - 입금 후 거래 내역 메모를 "ACC-001에서 수신"으로 기록
     */
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException {
        // TODO: 두 계좌 조회
        // TODO: 출금 처리
        // TODO: 입금 처리
        // TODO: 송금 완료 메시지 출력
    }

    /**
     * 전체 계좌 목록 출력
     */
    public void printAllAccounts() {
        // TODO: accounts가 비어있으면 "등록된 계좌가 없습니다." 출력
        // TODO: accounts.values()를 순회하며 각 계좌의 toString() 출력
    }

    /**
     * 특정 계좌 거래 내역 출력 (헬퍼 메소드)
     */
    public void printAccountHistory(String accountNumber) throws AccountNotFoundException {
        // 시그니처만 작성 - 내용 없음
    }

    /**
     * 은행 전체 총 잔액 합계 반환 (헬퍼 메소드)
     */
    public double getTotalBalance() {
        // 시그니처만 작성 - 내용 없음
        return 0;
    }

    public String getBankName() { return bankName; }
    public Map<String, Account> getAccounts() { return accounts; }
}

// =====================================================================
// 메인 클래스 - 실행 및 테스트
// =====================================================================

/**
 * Challenge01_BankSystem - 은행 계좌 관리 시스템 메인 클래스
 */
public class Challenge01_BankSystem {

    public static void main(String[] args) {
        System.out.println("===== 은행 계좌 관리 시스템 =====\n");

        // TODO: Bank 객체 생성 ("한국은행")

        // TODO: SavingsAccount 2개, CheckingAccount 1개 생성 및 openAccount()로 개설
        //       예) ACC-001: 홍길동, 잔액 1000000, 이자율 0.03
        //           ACC-002: 김철수, 잔액 500000, 이자율 0.03
        //           ACC-003: 이영희, 잔액 200000, 이자율 0.01, 수수료 5000

        // TODO: 전체 계좌 목록 출력 (printAllAccounts())

        System.out.println("\n--- 입출금 테스트 ---");
        // TODO: ACC-001에 50000 입금
        // TODO: ACC-001에서 30000 출금
        // TODO: ACC-001의 현재 잔액 출력
        // TODO: 잔액 부족 예외 테스트 (매우 큰 금액 출금 시도, try-catch로 처리)

        System.out.println("\n--- 이자/수수료 계산 테스트 ---");
        // TODO: ACC-001 (SavingsAccount) calculateInterest() 호출
        // TODO: ACC-003 (CheckingAccount) calculateInterest() 호출

        System.out.println("\n--- 송금 테스트 ---");
        // TODO: ACC-001 → ACC-002로 100000 송금
        // TODO: 송금 후 두 계좌의 잔액 출력
        // TODO: 존재하지 않는 계좌로 송금 시도 (AccountNotFoundException 처리)

        System.out.println("\n--- 거래 내역 조회 ---");
        // TODO: ACC-001의 거래 내역 출력 (printAccountHistory())

        System.out.println("\n--- 은행 전체 총 잔액 ---");
        // TODO: getTotalBalance() 결과 출력
    }
}
