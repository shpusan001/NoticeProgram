/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.text.SimpleDateFormat;

/**
 * @공지 메시지 구조체
 *
 * @author 이상훈
 */
public class SendNoticePack {

    private String id;
    private String title;
    private String notice;

    public SendNoticePack(String _id, String _title, String _notice) {
        id = _id;
        title = _title;
        notice = _notice;
    }

    public String getId() {
        return id;
    }

    public void makeQuery() {
        SimpleDateFormat currentTimeFormat = new SimpleDateFormat("yyyyMMdd");
        String date = currentTimeFormat.format(System.currentTimeMillis());
        String qeury = String.format("INSERT INTO Notices (date, id, title, content) VALUES ('%s', '%s', '%s', '%s');\n", date, id, title, notice);
        SqlController.getSqlController().sqlExcute(qeury); // sql 서버로 데이터 삽입
    }
}
