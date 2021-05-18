/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @테마를 책임지는 매니저
 * @색을 저장하고, 외부에서 참조하는 방식
 * @싱글톤
 * @상태 패턴
 *
 * @author 이상훈
 */
public class ThemeManager {

    private static ThemeManager themeManager;
    private ThemeSwitch themeSwitch = new ThemeSwitch();
    public Color color = new Color(80, 80, 80);

    public static ThemeManager getThemeManager() {
        if (themeManager == null) {
            themeManager = new ThemeManager();
        }
        return themeManager;
    }

    public void toggleTheme() {
        themeSwitch.onSwitch();
    }
}
