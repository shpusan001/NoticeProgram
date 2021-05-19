/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

/**
 * @공지전송 커맨드의 팩토리 클래스
 * @팩토리 패턴
 *
 * @author 이상훈
 */
public class SendNoticeCommandFactory implements SendCommandFactory {

    @Override
    public SendCommand createSendCommad(String what) {
        SendCommand command = null;
        if (what == "SendNoticeCommand") {
            command = new SendNoticeCommand();
        }
        return command;
    }
}
