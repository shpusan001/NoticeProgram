/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reciever;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @SQL 연결 및 명령 책임지는 클래스
 * @싱글톤 패턴
 * @퍼사드 패턴
 *
 * @author 이상훈
 */
public class SqlController {

    private static SqlController sqlController;
    private Connection conn = null;
    private Statement stmt = null;

    public static SqlController getSqlController() {
        if (sqlController == null) {
            sqlController = new SqlController();
        }
        return sqlController;
    }

    public boolean sqlConnect() {
        try {
            //1. 드라이버 로딩 : mysql 드라이버 로딩
            Class.forName("com.mysql.cj.jdbc.Driver");
            //드라이버들이 읽히기만 하면 자동 객체가 생성되고 DriverManager에 등록된다.

            //2. mysql과 연결시키기
            String url = "jdbc:mysql://101.101.211.178/JProj_msgProgram_db?useSSL=false";

            conn = DriverManager.getConnection(url, "root", "9760hm");
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Failed because of not loading driver");
            JOptionPane.showMessageDialog(null, "Cannot Load DB Driver", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FaildConnection", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            System.out.println("error : " + e);
            return false;
        }
    }

    public void sqlClose() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sqlExcute(String query) {
        sqlConnect();
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlClose();
    }

    public int sqlExcuteUpdate(String query) {
        sqlConnect();
        int count = 0;
        try {
            stmt = conn.createStatement();
            count = stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlClose();
        return count;
    }

    public ResultSet sqlExcuteQuery(String query) {
        sqlConnect();
        ResultSet result = null;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
