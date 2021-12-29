/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @메시지 전송을 담당하는 클래스 메시지 전송시, 스레드를 만들어서 메시지 전송 작업을 위임
 * @싱글톤 패턴
 *
 * @author 이상훈
 */
public class SendManager {

    private static SendManager sendManager;
    private Thread sendThread;
    private ArrayList<SendCommand> SendNoticeCommands = new ArrayList<SendCommand>(); // 메시지 전송 명령들
    private ArrayList<String> sendingUserList = new ArrayList<String>(); // 메시지 전송대상인 유저들  (메시지 중복 전송을 막기 위해 사용)
    private StringBuilder qeurySum = new StringBuilder();

    public static SendManager getSendManager() {
        if (sendManager == null) {
            sendManager = new SendManager();
        }
        return sendManager;
    }

    public StringBuilder getQuerySum() {
        return qeurySum;
    }

    public ArrayList<String> getSendingUserList() {
        return sendingUserList;
    }

    public void addSendCommand(SendCommand sendCommand) {
        SendNoticeCommands.add(sendCommand);
    }

    public void sendThreadStart() {
        sendThread = new Thread(new sendThreadRunning(), "sendThread");
        sendThread.start();
    }

    public class sendThreadRunning implements Runnable {

        public void run() {
            if (!SendNoticeCommands.isEmpty()) {
                for (SendCommand sendCommand : SendNoticeCommands) {
                    sendCommand.excute();
                }
                SqlController.getSqlController().sqlExcute(qeurySum.toString());
                qeurySum.setLength(0);
                sendingUserList.clear();
                SendNoticeCommands.clear(); // clear
                JOptionPane.showMessageDialog(null, "Message delivery complete");
            }
        }
    }
}
