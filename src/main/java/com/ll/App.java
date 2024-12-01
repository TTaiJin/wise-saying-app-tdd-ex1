package com.ll;

import com.ll.domain.system.controller.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private SystemController systemController;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.systemController = new SystemController();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();

            if ("종료".equals(cmd)) {
                systemController.actionExit();
                break;
            } else if ("등록".equals(cmd)) {
                System.out.println("명언 : ");
                System.out.println("작가 : ");
            }
        }

    }
}
