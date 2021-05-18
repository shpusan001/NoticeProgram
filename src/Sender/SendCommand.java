/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.sql.Connection;
import java.sql.Statement;

/**
 * @전송명령 추상클래스
 * @커맨드 패턴
 *
 * @author 이상훈
 */
public abstract class SendCommand {

    protected SendNoticePack pack;

    public void setSendNoticePack(SendNoticePack _pack) {
        this.pack = _pack;
    }

    public abstract void excute();
}
