/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

/**
 * 전송 커맨드의 추상팩토리 클래스
 *
 * @팩토리 패턴
 *
 * @author 이상훈
 */
public interface SendCommandFactory {

    public SendCommand createSendCommad(String what);
}
