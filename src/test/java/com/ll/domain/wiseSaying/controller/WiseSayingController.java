package com.ll.domain.wiseSaying.controller;

import com.ll.standard.util.AppTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingController {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("종료");

        assertThat(output).contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) 등록")
    public void t2() {
       String output = AppTest.run("""
               등록
               현재를 사랑하라.
               작자미상
               """.stripIndent().trim());
        assertThat(output).contains("명언 : ")
                .contains("작가 : ");
    }
}
