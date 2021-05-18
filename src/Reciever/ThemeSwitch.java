/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciever;

/**
 * @테마 상태를 저장하고 토글 할 수 있는 스위치
 * @상태 패턴
 *
 * @author 이상훈
 */
public class ThemeSwitch {

    private ThemeState themestate = new WhiteTheme();

    public void setState(ThemeState _themestate) {
        themestate = _themestate;
    }

    public void onSwitch() {
        themestate.toggle(this);
    }
}
