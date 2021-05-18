/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @디렉토리 정보를 담고 있는 객체
 * @최상위폴더와 현재폴더 경로가 저장됨
 * @싱글톤 패턴
 *
 * @author 이상훈
 */
public class DirectoryManager implements Serializable, Cloneable {

    private static DirectoryManager directoryManager;
    private Folder root;
    private Folder now;

    public static DirectoryManager getDirectoryManager() {
        if (directoryManager == null) {
            directoryManager = new DirectoryManager();
        }
        return directoryManager;
    }

    public void setDirectoryManager(DirectoryManager _directoryManager) {
        directoryManager = _directoryManager;
    }

    public Folder getRoot() {
        if (root == null) {
            root = new Folder("root");
        }
        return root;
    }

    public void setRoot(Folder _root) {
        root = _root;
    }

    public Folder getNow() {
        return now;
    }

    public void setNow(Folder _now) {
        now = _now;
    }
}
