/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.awt.Color;

/**
 * @실행시 최초실행
 *
 * @author 이상훈
 */
public class Init {

    public void init() throws InterruptedException {
        DirectoryManager.getDirectoryManager().setNow(DirectoryManager.getDirectoryManager().getRoot()); // 루트폴더로 현재폴더 설정
        new AdministratorPage();//관리자페이지 객체 생성
        ThemeManager.getThemeManager();//테마매니저 객체 생성
        AdministratorPage.administratorPage.run(); //관리자페이지 띄움
    }
}
