/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.awt.Color;
import java.util.Iterator;

/**
 * @테마 상태 클래스 구체화
 * @상태 패턴
 *
 * @author 이상훈
 */
public interface ThemeState {

    public void toggle(ThemeSwitch themeSwitch);
}

class WhiteTheme implements ThemeState {

    @Override
    public void toggle(ThemeSwitch themeSwitch) {
        ThemeManager.getThemeManager().color = new Color(235, 235, 235);
        themeSwitch.setState(new BlackTheme());
    }
}

class BlackTheme implements ThemeState {

    @Override
    public void toggle(ThemeSwitch themeSwitch) {
        ThemeManager.getThemeManager().color = new Color(80, 80, 80);
        themeSwitch.setState(new WhiteTheme());
    }
}
