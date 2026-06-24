# 자바 초급/중급 부트캠프 준비 연습 문제집

자바 프로그래밍 부트캠프 입과를 앞두고 핵심 개념을 체계적으로 복습하고 연습할 수 있도록 구성된 문제집입니다.
초급(beginner)과 중급(intermediate) 두 단계로 나뉘어 있으며, 각 주제별로 TODO 주석이 포함된 연습 파일을 제공합니다.

---

## 💾 문제집 다운로드 방법 (Fork & Clone)

이 문제집은 정답이 채워지지 않은 깨끗한 원본 상태인 **`template` 브랜치**를 제공합니다. 아래 방법 중 편한 방식을 선택하여 문제를 다운로드하세요.

### 방법 1. Git 명령어로 깨끗한 문제만 가져오기 (권장)

터미널을 열고 아래 명령어를 입력하면 풀이 이력이 없는 깨끗한 `template` 브랜치만 깔끔하게 다운로드(Clone)할 수 있습니다.

```bash
git clone -b template --single-branch https://github.com/YOUR_GITHUB_ID/YOUR_REPOSITORY_NAME.git

```

*(주의: `YOUR_GITHUB_ID`와 `YOUR_REPOSITORY_NAME` 부분은 본인의 저장소 주소에 맞게 변경해 주세요.)*

### 방법 2. GitHub 웹에서 압축 파일(ZIP)로 다운로드

Git 명령어가 익숙하지 않다면 웹 페이지에서 바로 다운로드할 수 있습니다.

1. 본 저장소 상단의 브랜치 선택 드롭다운(기본 `main`)을 클릭합니다.
2. **`template`** 브랜치를 선택합니다.
3. 우측의 초록색 **`Code`** 버튼을 누른 후 `Download ZIP`을 클릭합니다.
4. 다운로드된 압축 파일을 해제하고 IDE(IntelliJ 등)에서 열어 사용합니다.

---

## 학습 목표

* 자바의 기초 문법과 핵심 개념을 체계적으로 복습한다.
* 객체 지향 프로그래밍(OOP)의 원칙을 이해하고 실제 코드로 구현한다.
* 부트캠프 과정에서 요구되는 코딩 역량을 사전에 갖춘다.
* 스스로 TODO 주석을 채우며 능동적인 학습 습관을 기른다.

---

## 폴더 구조

```
JavaProject/
├── README.md
├── beginner/               # 초급 과정 (자바 기초 문법)
│   ├── 01_Variables/
│   ├── 02_Operators/
│   ├── 03_ControlFlow/
│   ├── 04_Loops/
│   ├── 05_Arrays/
│   ├── 06_Methods/
│   ├── 07_Strings/
│   ├── 08_Math/
│   ├── 09_TypeCasting/
│   ├── 10_Scanner/
│   └── Advanced/
└── intermediate/           # 중급 과정 (객체 지향 프로그래밍)
    ├── 01_ClassesObjects/
    ├── 02_Constructors/
    ├── 03_Encapsulation/
    ├── 04_Inheritance/
    ├── 05_Polymorphism/
    ├── 06_AbstractClasses/
    ├── 07_Interfaces/
    ├── 08_Exceptions/
    ├── 09_Collections/
    ├── 10_Generics/
    ├── 11_Lambda/
    ├── 12_Streams/
    ├── 13_Enum/
    ├── 14_InnerClasses/
    ├── 15_FileIO/
    └── Advanced/

```

---

## 각 폴더별 주제 목록

### beginner (초급)

| 번호 | 폴더명 | 주제 |
| --- | --- | --- |
| 01 | Variables | 변수 선언 및 자료형 (int, double, char, boolean, String 등) |
| 02 | Operators | 산술, 비교, 논리, 대입 연산자 |
| 03 | ControlFlow | if/else, switch 조건문 |
| 04 | Loops | for, while, do-while 반복문 |
| 05 | Arrays | 1차원/2차원 배열 선언 및 활용 |
| 06 | Methods | 메서드 정의, 매개변수, 반환값, 오버로딩 |
| 07 | Strings | String 클래스 주요 메서드 활용 |
| 08 | Math | Math 클래스 활용 (abs, max, min, pow, sqrt 등) |
| 09 | TypeCasting | 자동 형변환 및 강제 형변환 |
| 10 | Scanner | 사용자 입력 처리 (Scanner 클래스) |
| - | Advanced | 초급 심화 종합 문제 |

### intermediate (중급)

| 번호 | 폴더명 | 주제 |
| --- | --- | --- |
| 01 | ClassesObjects | 클래스 설계 및 객체 생성 |
| 02 | Constructors | 생성자, 기본 생성자, 생성자 오버로딩 |
| 03 | Encapsulation | 캡슐화, 접근 제한자, getter/setter |
| 04 | Inheritance | 상속, super 키워드, 메서드 오버라이딩 |
| 05 | Polymorphism | 다형성, 업캐스팅, 다운캐스팅 |
| 06 | AbstractClasses | 추상 클래스 및 추상 메서드 |
| 07 | Interfaces | 인터페이스 정의 및 구현, 다중 구현 |
| 08 | Exceptions | 예외 처리 (try-catch-finally, throws, 사용자 정의 예외) |
| 09 | Collections | List, Set, Map 컬렉션 프레임워크 |
| 10 | Generics | 제네릭 클래스 및 메서드 |
| 11 | Lambda | 람다 표현식, 함수형 인터페이스 |
| 12 | Streams | Stream API를 이용한 데이터 처리 |
| 13 | Enum | 열거형(enum) 선언 및 활용 |
| 14 | InnerClasses | 내부 클래스, 익명 클래스 |
| 15 | FileIO | 파일 입출력 (File, BufferedReader, BufferedWriter) |
| - | Advanced | 중급 심화 종합 문제 |

---

## 학습 순서 권장사항

1. **beginner 전체 완료 후 intermediate 진행**을 권장합니다.
2. 각 주제는 번호 순서대로 학습하세요. 이후 주제들이 이전 개념을 기반으로 구성되어 있습니다.
3. 하루 1~2개 폴더를 목표로 꾸준히 진행하세요.
4. 각 파일을 풀고 나서 직접 응용 예제를 추가로 작성해 보세요.
5. Advanced 폴더는 해당 단계의 전체 개념을 복습한 후 마지막에 도전하세요.

### 권장 학습 일정 (예시)

| 기간 | 학습 내용 |
| --- | --- |
| 1~3일차 | beginner 01~05 (변수, 연산자, 조건문, 반복문, 배열) |
| 4~5일차 | beginner 06~10 (메서드, 문자열, Math, 형변환, Scanner) |
| 6일차 | beginner Advanced |
| 7~10일차 | intermediate 01~07 (클래스, 생성자, 캡슐화, 상속, 다형성, 추상 클래스, 인터페이스) |
| 11~13일차 | intermediate 08~12 (예외처리, 컬렉션, 제네릭, 람다, 스트림) |
| 14~15일차 | intermediate 13~15 + Advanced (열거형, 내부 클래스, 파일IO, 심화) |

---

## 파일 형식 및 TODO 주석 작성 방법

각 연습 파일은 아래와 같은 형식으로 구성되어 있습니다.

```java
public class Example {
    public static void main(String[] args) {
        // TODO: 변수를 선언하고 값을 출력하세요.

        // TODO: 두 수를 더한 결과를 반환하는 메서드를 작성하세요.
    }
}

```

### 작성 방법

1. `// TODO:` 주석을 찾아 해당 위치에 코드를 작성합니다.
2. TODO 주석은 삭제하거나 그대로 두어도 무방합니다.
3. 작성 후 반드시 컴파일 및 실행하여 결과를 확인하세요.
4. 기대 출력값이 주석으로 명시된 경우, 실행 결과와 비교해 보세요.

```java
// 작성 전
// TODO: 1부터 10까지의 합을 구하세요.

// 작성 후
int sum = 0;
for (int i = 1; i <= 10; i++) {
    sum += i;
}
System.out.println("합계: " + sum); // 합계: 55

```

---

## 주의사항

* **직접 작성하는 것이 중요합니다.** 정답을 검색하기 전에 스스로 충분히 고민하세요.
* 컴파일 오류가 발생하면 오류 메시지를 꼼꼼히 읽고 원인을 파악하세요.
* 한 파일에 여러 TODO가 있는 경우, 위에서부터 순서대로 작성하세요.
* 코드 작성 후 다양한 입력값으로 테스트하여 엣지 케이스도 확인하세요.
* 이해가 되지 않는 개념은 넘어가지 말고 반드시 복습 후 진행하세요.
* 각 파일은 독립적으로 실행 가능하게 구성되어 있습니다. IDE(IntelliJ, Eclipse 등)에서 개별 실행하세요.

---

*본 문제집은 자바 부트캠프 입과 준비를 위해 제작되었습니다. 꾸준한 학습으로 실력을 쌓아가세요.*
