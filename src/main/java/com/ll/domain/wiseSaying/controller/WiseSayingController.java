package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;
import com.ll.domain.wiseSaying.service.WiseSayingService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class WiseSayingController {
    private final Scanner scanner;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner scanner) {
        this.scanner = scanner;
        this.wiseSayingService = new WiseSayingService();
    }

    public void actionAdd() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();

        WiseSaying wiseSaying = wiseSayingService.requireAdd(content,author);
        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }

    public void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("------------------");
        List<WiseSaying> wiseSayings = wiseSayingService.requireList();
        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.println(wiseSaying.getId() + " / " + wiseSaying.getAuthor() + " / " + wiseSaying.getContent());
        }
    }

    public void actionDelete(String cmd) {
        try {
            int deleteId = Integer.parseInt(cmd.substring(6));
            boolean removed = wiseSayingService.requireDelete(deleteId);
            if (!removed) {
                System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
            }
            System.out.println(deleteId + "번 명언이 삭제되었습니다.");
        } catch (NumberFormatException e) {
            System.out.println("id= 뒤에 숫자를 입력하세요.");
        }
    }

    public void actionModify(String cmd) {
        int modifyId = Integer.parseInt(cmd.substring(6));
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(modifyId);
        if (opWiseSaying.isEmpty()) {
            System.out.println(modifyId + "번 명언은 존재하지 않습니다.");
            return;
        }
        WiseSaying wiseSaying = opWiseSaying.get();
        System.out.println("명언(기존) : " + wiseSaying.getContent());
        System.out.print("명언 : ");
        String newContent = scanner.nextLine();

        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String newAuthor = scanner.nextLine();

        wiseSayingService.requireModify(wiseSaying, newContent, newAuthor);

    }
}
