/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.util.ArrayList;

/**
 * @공지전송 명령 클래스
 * @커맨드 패턴
 *
 * @author 이상훈
 */
public class SendNoticeCommand extends SendCommand {

    @Override
    public void excute() {
        ArrayList<String> sendingUserList = SendManager.getSendManager().getSendingUserList();
        //SendManager의 sendingUserList를 참조 해서 중복 방지 
        if (!sendingUserList.contains(pack.getId())) {
            sendingUserList.add(pack.getId());
            SqlController.getSqlController().sqlExcute(pack.makeQuery()); // sql 서버로 데이터 삽입 // 메시지 전송
        }
    }
}
