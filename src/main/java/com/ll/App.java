package com.ll;

import com.ll.domain.system.controller.SystemController;
import com.ll.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final SystemController systemController;
    private final WiseSayingController wiseSayingController;


    public App(Scanner scanner) {
        this.scanner = scanner;
        this.systemController = new SystemController();
        this.wiseSayingController = new WiseSayingController(scanner);
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.startsWith("삭제?id=")) {
                wiseSayingController.actionDelete(cmd);
            } else if (cmd.startsWith("수정?id=")) {
                wiseSayingController.actionModify(cmd);
            }
        }

    }
}
