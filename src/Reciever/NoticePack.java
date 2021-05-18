/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciever;

/**
 * @공지 구조체
 *
 * @author 이상훈
 */
public class NoticePack {

    private String date;
    private String id;
    private String title;
    private String content;

    public NoticePack(String _date, String _id, String _title, String _content) {
        date = _date;
        id = _id;
        title = _title;
        content = _content;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
