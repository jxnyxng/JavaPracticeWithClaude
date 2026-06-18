/**
 * 파일명: P02_AbstractTemplate.java
 * 주제: 템플릿 메소드 패턴 (Template Method Pattern)
 *
 * ========================================
 * 학습 목표
 * ========================================
 * 1. 템플릿 메소드 패턴의 구조를 이해하고, 공통 알고리즘 골격을 부모에 정의할 수 있다.
 * 2. 추상 메소드로 각 자식 클래스마다 다른 세부 구현을 강제할 수 있다.
 * 3. 후크(hook) 메소드를 활용하여 선택적으로 알고리즘 단계를 변경할 수 있다.
 *
 * ========================================
 * 핵심 개념 설명
 * ========================================
 * [템플릿 메소드 패턴 (Template Method Pattern)]
 *   - 디자인 패턴 중 행위(Behavioral) 패턴의 하나
 *   - 알고리즘의 골격(순서, 흐름)은 부모 클래스의 final 메소드에 정의
 *   - 세부 구현이 달라지는 단계만 추상 메소드로 선언하여 자식에서 구현
 *   - 코드 중복을 줄이고 알고리즘 구조를 한 곳에서 관리할 수 있다
 *
 * [알고리즘 골격 메소드]
 *   - 보통 final로 선언하여 자식이 순서를 바꾸지 못하게 한다
 *   - 여러 단계(메소드)를 순서대로 호출하는 형태
 *   - 예: void make() { boilWater(); brew(); pourInCup(); addCondiments(); }
 *
 * [후크 메소드 (Hook Method)]
 *   - 추상 메소드가 아닌 일반 메소드로, 기본 구현(보통 빈 구현 or 기본값)을 제공
 *   - 자식 클래스에서 선택적으로 오버라이딩하여 동작을 추가/변경할 수 있다
 *   - 오버라이딩하지 않아도 오류가 없다 (추상 메소드와의 차이)
 *   - 예: boolean customerWantsCondiments() { return true; } // 기본값: true
 */
public class P02_AbstractTemplate {

    // ============================================================
    // 문제 1: 커피/차 만들기 - 템플릿 메소드 패턴 기본
    // ============================================================

    /**
     * 음료 만들기 추상 클래스 (템플릿 메소드 패턴)
     * - 음료 제조의 공통 단계(물 끓이기, 컵에 따르기)는 여기에 구현
     * - 음료마다 다른 단계(우리기, 첨가물 추가)는 추상 메소드로 강제
     */
    abstract static class Beverage {

        /**
         * 템플릿 메소드: 음료 만들기 전체 과정 (알고리즘 골격)
         * final로 선언하여 자식 클래스가 순서를 변경하지 못하게 한다.
         * 1단계: 물 끓이기 (공통)
         * 2단계: 우리기 (자식마다 다름 - 추상 메소드)
         * 3단계: 컵에 따르기 (공통)
         * 4단계: 첨가물 추가 (자식마다 다름 - 추상 메소드)
         */
        final void makeBeverage() {
            boilWater();
            brew();
            pourInCup();
            addCondiments();
        }

        /** 공통 단계: 물 끓이기 */
        void boilWater() {
            System.out.println("  물을 100°C로 끓입니다.");
        }

        /** 공통 단계: 컵에 따르기 */
        void pourInCup() {
            System.out.println("  컵에 음료를 따릅니다.");
        }

        /**
         * 추상 메소드: 음료를 우린다.
         * 커피는 필터로 우리고, 차는 찻잎을 우린다.
         */
        abstract void brew();

        /**
         * 추상 메소드: 첨가물을 추가한다.
         * 커피는 설탕/우유, 차는 레몬을 추가한다.
         */
        abstract void addCondiments();
    }

    /** 커피 클래스 - Beverage의 추상 메소드 구현 */
    static class Coffee extends Beverage {

        @Override
        void brew() {
            // TODO: "커피를 필터로 우립니다." 출력
        }

        @Override
        void addCondiments() {
            // TODO: "설탕과 우유를 추가합니다." 출력
        }
    }

    /** 차 클래스 - Beverage의 추상 메소드 구현 */
    static class Tea extends Beverage {

        @Override
        void brew() {
            // TODO: "찻잎을 뜨거운 물에 우립니다." 출력
        }

        @Override
        void addCondiments() {
            // TODO: "레몬을 추가합니다." 출력
        }
    }

    /**
     * [문제 1] 커피와 차 만들기 - 템플릿 메소드 패턴 기본
     *
     * 설명:
     *   Coffee와 Tea 객체를 생성하고 makeBeverage()를 호출하여,
     *   공통 단계(물 끓이기, 컵에 따르기)와 다른 단계(우리기, 첨가물)를 비교하세요.
     *
     * 예상 출력:
     *   =====커피 만들기=====
     *   음료 제조를 시작합니다: Coffee
     *     물을 100°C로 끓입니다.
     *     커피를 필터로 우립니다.
     *     컵에 음료를 따릅니다.
     *     설탕과 우유를 추가합니다.
     *   Coffee 완성!
     *
     *   =====차 만들기=====
     *   음료 제조를 시작합니다: Tea
     *     물을 100°C로 끓입니다.
     *     찻잎을 뜨거운 물에 우립니다.
     *     컵에 음료를 따릅니다.
     *     레몬을 추가합니다.
     *   Tea 완성!
     *
     * 힌트:
     *   - new Coffee(), new Tea() 생성 후 makeBeverage() 호출
     *   - 공통 단계는 Beverage에서, 다른 단계는 각 자식에서 실행됨을 관찰
     */
    static void problem1() {
        System.out.println("=====커피 만들기=====");
        // TODO: Coffee 객체 생성
        System.out.println("음료 제조를 시작합니다: Coffee");
        // TODO: makeBeverage() 호출
        System.out.println("Coffee 완성!");

        System.out.println();

        System.out.println("=====차 만들기=====");
        // TODO: Tea 객체 생성
        System.out.println("음료 제조를 시작합니다: Tea");
        // TODO: makeBeverage() 호출
        System.out.println("Tea 완성!");
    }

    // ============================================================
    // 문제 2: 알고리즘 골격은 부모에, 세부 구현은 자식에
    // ============================================================

    /**
     * 데이터 처리 추상 클래스 (알고리즘 골격 패턴)
     * - 데이터 처리의 순서(읽기 → 처리 → 저장)는 항상 동일
     * - 각 단계의 구체적 구현은 자식 클래스에서 결정
     */
    abstract static class DataProcessor {
        String dataSource;

        DataProcessor(String dataSource) {
            this.dataSource = dataSource;
        }

        /**
         * 템플릿 메소드: 데이터 처리 전체 흐름
         * 순서: 읽기 → 검증 → 처리 → 저장 → 완료 보고
         */
        final void process() {
            System.out.println("[" + dataSource + "] 처리 시작");
            readData();
            if (isValid()) {
                processData();
                saveResult();
            } else {
                System.out.println("  데이터 검증 실패 - 처리 중단");
            }
            reportCompletion();
        }

        /** 추상 메소드: 데이터 읽기 */
        abstract void readData();

        /** 추상 메소드: 데이터 처리 */
        abstract void processData();

        /** 추상 메소드: 결과 저장 */
        abstract void saveResult();

        /**
         * 후크 메소드: 데이터 유효성 검증
         * 기본값은 true (유효함). 자식 클래스에서 선택적으로 오버라이딩 가능.
         */
        boolean isValid() {
            return true;
        }

        /** 공통 단계: 완료 보고 */
        void reportCompletion() {
            System.out.println("[" + dataSource + "] 처리 완료");
        }
    }

    /** CSV 파일 데이터 처리기 */
    static class CsvDataProcessor extends DataProcessor {

        CsvDataProcessor() {
            super("CSV 파일");
        }

        @Override
        void readData() {
            // TODO: "  CSV 파일에서 데이터를 읽습니다." 출력
        }

        @Override
        void processData() {
            // TODO: "  CSV 데이터를 파싱하고 변환합니다." 출력
        }

        @Override
        void saveResult() {
            // TODO: "  처리 결과를 데이터베이스에 저장합니다." 출력
        }
    }

    /** JSON API 데이터 처리기 */
    static class JsonApiProcessor extends DataProcessor {
        boolean hasApiKey;

        JsonApiProcessor(boolean hasApiKey) {
            super("JSON API");
            this.hasApiKey = hasApiKey;
        }

        @Override
        void readData() {
            // TODO: "  JSON API에서 데이터를 받아옵니다." 출력
        }

        @Override
        void processData() {
            // TODO: "  JSON 데이터를 파싱하고 분석합니다." 출력
        }

        @Override
        void saveResult() {
            // TODO: "  분석 결과를 캐시에 저장합니다." 출력
        }

        /**
         * 후크 메소드 오버라이딩: API 키가 있을 때만 유효
         * API 키가 없으면 처리를 중단한다.
         */
        @Override
        boolean isValid() {
            // TODO: hasApiKey 값에 따라 true/false 반환
            //       false일 경우 "  API 키가 없어 검증 실패" 출력 후 false 반환
            return false;
        }
    }

    /**
     * [문제 2] 알고리즘 골격 - 부모에서 흐름 제어, 자식에서 세부 구현
     *
     * 설명:
     *   CsvDataProcessor와 JsonApiProcessor를 생성하고 process()를 호출하여,
     *   알고리즘 흐름(순서)은 동일하지만 각 단계의 구현이 다름을 확인하세요.
     *   API 키 없이 생성한 JsonApiProcessor는 검증 단계에서 중단되어야 합니다.
     *
     * 예상 출력:
     *   =====알고리즘 골격 테스트=====
     *   [CSV 파일] 처리 시작
     *     CSV 파일에서 데이터를 읽습니다.
     *     CSV 데이터를 파싱하고 변환합니다.
     *     처리 결과를 데이터베이스에 저장합니다.
     *   [CSV 파일] 처리 완료
     *
     *   [JSON API] 처리 시작
     *     JSON API에서 데이터를 받아옵니다.
     *   API 키가 없어 검증 실패
     *   데이터 검증 실패 - 처리 중단
     *   [JSON API] 처리 완료
     *
     * 힌트:
     *   - new CsvDataProcessor().process()
     *   - new JsonApiProcessor(false).process()  // API 키 없음 → 검증 실패
     *   - new JsonApiProcessor(true).process()   // API 키 있음 → 정상 처리
     */
    static void problem2() {
        System.out.println("=====알고리즘 골격 테스트=====");
        // TODO: CsvDataProcessor 생성 후 process() 호출
        System.out.println();
        // TODO: JsonApiProcessor(false) 생성 후 process() 호출 (검증 실패 확인)
    }

    // ============================================================
    // 문제 3: 후크(Hook) 메소드 활용
    // ============================================================

    /**
     * 보고서 생성 추상 클래스 (후크 메소드 활용)
     * - 보고서 생성 단계는 항상 동일
     * - 표지/머리말/맺음말은 선택적으로 추가 가능 (후크 메소드)
     */
    abstract static class ReportGenerator {
        String reportTitle;

        ReportGenerator(String reportTitle) {
            this.reportTitle = reportTitle;
        }

        /**
         * 템플릿 메소드: 보고서 생성 흐름
         */
        final void generateReport() {
            System.out.println("=== 보고서 생성 시작: " + reportTitle + " ===");
            if (hasCoverPage()) {
                printCoverPage();
            }
            if (hasPreamble()) {
                printPreamble();
            }
            printBody();           // 본문 - 반드시 구현 (추상 메소드)
            if (hasConclusion()) {
                printConclusion();
            }
            System.out.println("=== 보고서 생성 완료 ===");
        }

        /** 추상 메소드: 보고서 본문 출력 (반드시 구현) */
        abstract void printBody();

        // --- 후크(Hook) 메소드들: 기본값 제공, 선택적 오버라이딩 ---

        /** 후크: 표지 포함 여부 (기본값: false) */
        boolean hasCoverPage() {
            return false;
        }

        /** 후크: 머리말 포함 여부 (기본값: false) */
        boolean hasPreamble() {
            return false;
        }

        /** 후크: 맺음말 포함 여부 (기본값: false) */
        boolean hasConclusion() {
            return false;
        }

        /** 표지 출력 (후크로 활성화 시 호출) */
        void printCoverPage() {
            System.out.println("  [표지] " + reportTitle);
        }

        /** 머리말 출력 (후크로 활성화 시 호출) */
        void printPreamble() {
            System.out.println("  [머리말] 본 보고서는 ...");
        }

        /** 맺음말 출력 (후크로 활성화 시 호출) */
        void printConclusion() {
            System.out.println("  [맺음말] 이상으로 보고서를 마칩니다.");
        }
    }

    /** 간단한 보고서: 본문만 포함 (후크 오버라이딩 없음) */
    static class SimpleReport extends ReportGenerator {

        SimpleReport(String title) {
            super(title);
        }

        @Override
        void printBody() {
            // TODO: "  [본문] 간단한 보고서 내용입니다." 출력
        }
        // 후크 메소드 오버라이딩 없음 → 표지/머리말/맺음말 생략
    }

    /** 공식 보고서: 표지, 머리말, 본문, 맺음말 모두 포함 */
    static class FormalReport extends ReportGenerator {

        FormalReport(String title) {
            super(title);
        }

        @Override
        void printBody() {
            // TODO: "  [본문] 공식 보고서의 상세 내용입니다." 출력
            // TODO: "  [본문] 분석 결과 및 권고사항 ..." 출력
        }

        /** 후크 오버라이딩: 표지 포함 */
        @Override
        boolean hasCoverPage() {
            // TODO: true 반환
            return false;
        }

        /** 후크 오버라이딩: 머리말 포함 */
        @Override
        boolean hasPreamble() {
            // TODO: true 반환
            return false;
        }

        /** 후크 오버라이딩: 맺음말 포함 */
        @Override
        boolean hasConclusion() {
            // TODO: true 반환
            return false;
        }
    }

    /**
     * [문제 3] 후크(Hook) 메소드 활용
     *
     * 설명:
     *   SimpleReport와 FormalReport를 생성하고 generateReport()를 호출하여,
     *   후크 메소드 오버라이딩 여부에 따라 보고서 구성이 달라지는 것을 확인하세요.
     *
     * 예상 출력:
     *   =====후크 메소드 테스트=====
     *   --- 간단한 보고서 ---
     *   === 보고서 생성 시작: 주간 업무 요약 ===
     *     [본문] 간단한 보고서 내용입니다.
     *   === 보고서 생성 완료 ===
     *
     *   --- 공식 보고서 ---
     *   === 보고서 생성 시작: 2026년 1분기 실적 ===
     *     [표지] 2026년 1분기 실적
     *     [머리말] 본 보고서는 ...
     *     [본문] 공식 보고서의 상세 내용입니다.
     *     [본문] 분석 결과 및 권고사항 ...
     *     [맺음말] 이상으로 보고서를 마칩니다.
     *   === 보고서 생성 완료 ===
     *
     * 힌트:
     *   - SimpleReport는 후크를 오버라이딩하지 않아 본문만 출력
     *   - FormalReport는 hasCoverPage/hasPreamble/hasConclusion을 true로 오버라이딩
     */
    static void problem3() {
        System.out.println("=====후크 메소드 테스트=====");

        System.out.println("--- 간단한 보고서 ---");
        // TODO: SimpleReport("주간 업무 요약") 생성 후 generateReport() 호출

        System.out.println();

        System.out.println("--- 공식 보고서 ---");
        // TODO: FormalReport("2026년 1분기 실적") 생성 후 generateReport() 호출
    }

    // ----------------------------------------
    // main 메소드
    // ----------------------------------------
    public static void main(String[] args) {
        problem1();
        System.out.println();
        problem2();
        System.out.println();
        problem3();
    }
}
