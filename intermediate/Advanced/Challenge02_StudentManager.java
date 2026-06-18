/**
 * ============================================================
 * 파일명: Challenge02_StudentManager.java
 * 제  목: 학생 성적 관리 시스템
 * ============================================================
 *
 * [학습 목표]
 * 1. 제네릭(Generics)을 활용하여 재사용 가능한 클래스와 메서드를 설계할 수 있다.
 * 2. Lambda 표현식과 Comparator를 사용하여 유연한 정렬 기준을 적용할 수 있다.
 * 3. Stream API의 filter, map, sorted, collect, groupingBy 등을 조합하여
 *    복잡한 데이터 처리를 간결하게 구현할 수 있다.
 *
 * [핵심 개념 설명]
 * - 제네릭(Generics): 타입 파라미터를 사용하여 다양한 타입에 동작하는 클래스/메서드를 작성.
 *   예) Pair<K, V> 클래스는 어떤 타입이든 쌍으로 묶을 수 있다.
 *
 * - Lambda + Comparator: (a, b) -> a.getScore() - b.getScore() 형태로
 *   간결하게 정렬 기준을 정의한다.
 *
 * - Stream groupingBy: Collectors.groupingBy(Student::getGrade) 로
 *   등급별로 학생을 그룹화하여 Map<String, List<Student>> 형태로 수집한다.
 *
 * - Stream statistics: mapToInt(Student::getScore).average() 등
 *   IntStream의 통계 메서드를 활용한다.
 * ============================================================
 */

import java.util.*;
import java.util.stream.*;

// ============================================================
// 제네릭 유틸리티 클래스
// ============================================================

/**
 * [문제 0] 제네릭 Pair 클래스
 *
 * 두 값을 쌍으로 묶어 저장하는 제네릭 클래스를 완성하세요.
 * 예: Pair<String, Integer> → ("홍길동", 95)
 *
 * 힌트:
 * - 타입 파라미터 <K, V> 를 클래스 선언에 추가
 * - first, second 필드를 선언하고 생성자/getter 작성
 */
class Pair<K, V> {
    // TODO: 필드 선언 (first: K, second: V)

    // TODO: 생성자 작성

    // TODO: getFirst(), getSecond() getter 작성

    @Override
    public String toString() {
        // TODO: "(first, second)" 형식으로 반환
        return null;
    }
}

// ============================================================
// 학생 클래스
// ============================================================

/**
 * 학생 정보를 담는 클래스
 *
 * 필드:
 * - name    : 이름 (String)
 * - score   : 점수 (int, 0~100)
 * - subject : 수강 과목 (String)
 */
class Student {
    private String name;
    private int score;
    private String subject;

    public Student(String name, int score, String subject) {
        this.name = name;
        this.score = score;
        this.subject = subject;
    }

    public String getName()    { return name; }
    public int getScore()      { return score; }
    public String getSubject() { return subject; }

    /**
     * 점수에 따른 등급 반환
     * 90 이상 → "A", 80 이상 → "B", 70 이상 → "C", 60 이상 → "D", 미만 → "F"
     */
    public String getGrade() {
        // TODO: 구현
        return "";
    }

    @Override
    public String toString() {
        // TODO: "이름: 홍길동 | 과목: 수학 | 점수: 95 | 등급: A" 형식으로 반환
        return null;
    }
}

// ============================================================
// 제네릭 ResultBox 클래스
// ============================================================

/**
 * [문제 1] 제네릭 ResultBox<T>
 *
 * 어떤 타입의 값이든 저장하고, 조건 검사 메서드를 제공하는 제네릭 클래스를 완성하세요.
 *
 * 기능:
 * - getValue()           : 저장된 값 반환
 * - isEmpty()            : 값이 null이면 true
 * - getOrDefault(T def)  : 값이 null이면 def 반환, 아니면 저장된 값 반환
 *
 * 사용 예:
 *   ResultBox<Integer> box = new ResultBox<>(42);
 *   box.getValue()          → 42
 *   box.isEmpty()           → false
 *   box.getOrDefault(0)     → 42
 *
 *   ResultBox<String> empty = new ResultBox<>(null);
 *   empty.isEmpty()         → true
 *   empty.getOrDefault("없음") → "없음"
 */
class ResultBox<T> {
    // TODO: 필드 선언

    // TODO: 생성자 작성

    public T getValue() {
        // TODO: 구현
        return null;
    }

    public boolean isEmpty() {
        // TODO: 구현
        return false;
    }

    public T getOrDefault(T defaultValue) {
        // TODO: 구현
        return null;
    }
}

// ============================================================
// 학생 관리 클래스
// ============================================================

/**
 * [문제 2] StudentManager - Stream + Lambda 기반 학생 관리
 *
 * 학생 목록을 관리하고 다양한 조회/분석 기능을 제공하는 클래스를 완성하세요.
 */
class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    /** 학생 추가 */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * 전체 학생 평균 점수를 반환하세요. (Stream + mapToInt + average 사용)
     *
     * 힌트: students.stream().mapToInt(Student::getScore).average().orElse(0)
     */
    public double getAverageScore() {
        // TODO: 구현
        return 0;
    }

    /**
     * 점수가 가장 높은 학생을 반환하세요. (Stream + max 사용)
     * 학생이 없으면 null 반환.
     *
     * 힌트: students.stream().max(Comparator.comparingInt(Student::getScore))
     */
    public Student getTopStudent() {
        // TODO: 구현
        return null;
    }

    /**
     * 점수 기준 내림차순으로 정렬된 학생 목록을 반환하세요. (Stream + sorted + Lambda 사용)
     *
     * 힌트: .sorted((a, b) -> b.getScore() - a.getScore())
     */
    public List<Student> getSortedByScoreDesc() {
        // TODO: 구현
        return null;
    }

    /**
     * 특정 과목의 학생만 필터링하여 반환하세요. (Stream + filter 사용)
     *
     * 힌트: .filter(s -> s.getSubject().equals(subject))
     */
    public List<Student> filterBySubject(String subject) {
        // TODO: 구현
        return null;
    }

    /**
     * 기준 점수 이상인 학생들의 이름 목록을 반환하세요. (Stream + filter + map + collect 사용)
     *
     * 예: minScore = 80 → ["홍길동", "이영희", ...]
     *
     * 힌트: .filter(...).map(Student::getName).collect(Collectors.toList())
     */
    public List<String> getNamesAboveScore(int minScore) {
        // TODO: 구현
        return null;
    }

    /**
     * 등급별로 학생을 그룹화하여 반환하세요. (Collectors.groupingBy 사용)
     *
     * 반환: Map<String, List<Student>>  예: {"A": [...], "B": [...]}
     *
     * 힌트: .collect(Collectors.groupingBy(Student::getGrade))
     */
    public Map<String, List<Student>> groupByGrade() {
        // TODO: 구현
        return null;
    }

    /**
     * 과목별 평균 점수를 계산하여 반환하세요.
     * (Collectors.groupingBy + Collectors.averagingInt 사용)
     *
     * 반환: Map<String, Double>  예: {"수학": 85.5, "영어": 78.2}
     *
     * 힌트:
     * students.stream().collect(
     *     Collectors.groupingBy(Student::getSubject,
     *         Collectors.averagingInt(Student::getScore))
     * )
     */
    public Map<String, Double> getAverageBySubject() {
        // TODO: 구현
        return null;
    }

    /**
     * 점수 상위 N명의 학생 목록을 반환하세요. (Stream + sorted + limit 사용)
     */
    public List<Student> getTopN(int n) {
        // TODO: 구현
        return null;
    }

    /** 전체 학생 목록 출력 */
    public void printAll() {
        students.forEach(System.out::println);
    }
}

// ============================================================
// 메인 클래스 (테스트)
// ============================================================

public class Challenge02_StudentManager {

    public static void main(String[] args) {

        System.out.println("=== 학생 성적 관리 시스템 테스트 ===\n");

        // 학생 데이터 준비
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("홍길동", 92, "수학"));
        manager.addStudent(new Student("김철수", 78, "영어"));
        manager.addStudent(new Student("이영희", 85, "수학"));
        manager.addStudent(new Student("박민준", 63, "과학"));
        manager.addStudent(new Student("최수연", 95, "영어"));
        manager.addStudent(new Student("정다은", 71, "수학"));
        manager.addStudent(new Student("강지훈", 88, "과학"));
        manager.addStudent(new Student("윤서연", 55, "영어"));

        // [1] 전체 목록 출력
        System.out.println("=== 전체 학생 목록 ===");
        manager.printAll();

        // [2] 평균 점수
        // TODO: 전체 평균 점수를 출력하세요.
        //       예: "전체 평균: 78.4점"

        // [3] 최고 점수 학생
        // TODO: getTopStudent() 를 호출하여 출력하세요.
        //       예: "최고 점수 학생: 이름: 최수연 | 과목: 영어 | 점수: 95 | 등급: A"

        // [4] 점수 내림차순 정렬
        System.out.println("\n=== 점수 높은 순 ===");
        // TODO: getSortedByScoreDesc() 를 호출하여 순위와 함께 출력하세요.
        //       예: "1위. 이름: 최수연 | ..."

        // [5] 과목별 필터링
        System.out.println("\n=== 수학 과목 학생 ===");
        // TODO: filterBySubject("수학") 결과를 출력하세요.

        // [6] 80점 이상 학생 이름
        System.out.println("\n=== 80점 이상 학생 이름 ===");
        // TODO: getNamesAboveScore(80) 결과를 출력하세요.
        //       예: [홍길동, 이영희, 최수연, 강지훈]

        // [7] 등급별 그룹
        System.out.println("\n=== 등급별 학생 ===");
        // TODO: groupByGrade() 결과를 순회하며 등급과 학생 수를 출력하세요.
        //       예: A등급 (2명): 홍길동, 최수연

        // [8] 과목별 평균
        System.out.println("\n=== 과목별 평균 점수 ===");
        // TODO: getAverageBySubject() 결과를 출력하세요.
        //       예: 수학: 82.7점 | 영어: 76.0점 | 과학: 75.5점

        // [9] 상위 3명
        System.out.println("\n=== 상위 3명 ===");
        // TODO: getTopN(3) 결과를 출력하세요.

        // [10] 제네릭 클래스 테스트
        System.out.println("\n=== 제네릭 클래스 테스트 ===");
        // TODO: Pair<String, Integer> 를 사용하여 (이름, 점수) 쌍을 만들고 출력하세요.
        // TODO: ResultBox<Integer> 를 사용하여 값이 있을 때와 null일 때를 테스트하세요.
    }
}
