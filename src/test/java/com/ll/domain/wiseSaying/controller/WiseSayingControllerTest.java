package com.ll.domain.wiseSaying.controller;

import com.ll.standard.util.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("종료");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("등록을 입력하면 내용과 작가를 입력받는다.")
    public void t2() {
       String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               """);
        assertThat(output).contains("명언 : ")
                .contains("작가 : ");
    }

    @Test
    @DisplayName("등록시 생성된 명언번호가 노출된다.")
    public void t3() {
        String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               """);
        assertThat(output).contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("등록할때 마다 생성되는 명언번호가 증가한다.")
    public void t4() {
        String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               등록
               현재를 사랑하라.
               작자미상
               """);
        assertThat(output).contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록을 입력하면 등록된 명언들이 출력된다.")
    public void t5() {
        String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               등록
               과거에 집착하지 마라.
               작자미상
               목록
               """);
        assertThat(output).contains("번호 / 작가 / 명언")
                .contains("2 / 작자미상 / 과거에 집착하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");
    }

    @Test
    @DisplayName("삭제를 입력하면 명언이 삭제된다.")
    public void t6() {
        String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               등록
               과거에 집착하지 마라.
               작자미상
               목록
               삭제?id=1
               """);
        assertThat(output).contains("1번 명언이 삭제되었습니다.");
    }

    @Test
    @DisplayName("삭제 명령어를 잘못 입력시 예외 처리")
    public void t7() {
        String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               등록
               과거에 집착하지 마라.
               작자미상
               목록
               삭제?id=asdf
               """);
        assertThat(output).contains("id= 뒤에 숫자를 입력하세요.");
    }
}
