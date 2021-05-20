/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciever;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @공지를 load하는 매니저
 * @공지를 sql서버로 부터 받아오는 역할
 * @싱글톤 패턴
 *
 * @author 이상훈
 */
public class LoadNoticeManager {

    HashMap<String, NoticePack> noticesMap = new HashMap<String, NoticePack>();
    ArrayList<NoticePack> notices = new ArrayList<NoticePack>();

    private static LoadNoticeManager loadNoticeManager;

    public static LoadNoticeManager getLoadNoticeManager() {
        if (loadNoticeManager == null) {
            loadNoticeManager = new LoadNoticeManager();
        }
        return loadNoticeManager;
    }

    public void loadNotice(String _id) {
        noticesMap.clear();
        notices.clear();
        String query = String.format("SELECT date, id, title, content FROM Notices WHERE id='%s'", _id);
        ResultSet result = SqlController.getSqlController().sqlExcuteQuery(query);
        try {
            while (result.next()) {
                NoticePack notice = new NoticePack(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4)
                );
                notices.add(notice);
                noticesMap.put(notice.getTitle(), notice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SqlController.getSqlController().sqlClose();
        }
    }
}
