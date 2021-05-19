/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @디렉토리 시스템을 구현한 클래스
 * @컴포지드 패턴
 *
 * @author 이상훈
 */
public interface DirectorySystem {

    public boolean isContentUser(String idName);

    public String getIdName();

    public Folder getFolder();

    public void sendNotice(String title, String notice);

    public DirectorySystem getParent();

    public void setParent(DirectorySystem _parent);

    public ArrayList<DirectorySystem> getIncludeds();

    public HashMap<String, DirectorySystem> getIncludedsMap();

    public void remove();
}

class User implements DirectorySystem, Serializable {

    private DirectorySystem parent = null;
    private String id;
    private String name;
    private String idName;

    public User(String _id, String _name) {
        id = _id;
        name = _name;
        idName = _id + "#" + _name;
    }

    @Override
    public String getIdName() {
        return idName;
    }

    @Override
    public boolean isContentUser(String idName) {
        if (idName.equals(this.idName)) {
        } else if (idName.split("#")[0].equals(this.id)) {
            return true;
        }
        return false;
    }

    @Override
    public void sendNotice(String title, String notice) {
        SendCommand command = new SendNoticeCommandFactory().createSendCommad("SendNoticeCommand");
        command.setSendNoticePack(new SendNoticePack(id, title, notice));
        SendManager.getSendManager().addSendCommand(command);
    }

    @Override
    public ArrayList<DirectorySystem> getIncludeds() {
        return null;
    }

    @Override
    public DirectorySystem getParent() {
        return parent;
    }

    @Override

    public void setParent(DirectorySystem _parent) {
        parent = _parent;
    }

    @Override
    public void remove() {
        parent.getIncludeds().remove(this);
        parent.getIncludedsMap().remove(this.getIdName());
    }

    @Override
    public Folder getFolder() {
        return null;
    }

    @Override
    public HashMap<String, DirectorySystem> getIncludedsMap() {
        return null;

    }
}

class Folder implements DirectorySystem, Serializable {

    private DirectorySystem parent = null;
    private String name;
    private ArrayList<DirectorySystem> includeds = new ArrayList<DirectorySystem>();
    private HashMap<String, DirectorySystem> includedsMap = new HashMap<String, DirectorySystem>();

    public Folder(String _name) {
        name = _name + "/";
    }

    public int add(DirectorySystem directorySystem) {
        // id overlap test

        //folder overlap test and add directory things
        if (!includedsMap.containsKey(directorySystem.getIdName())) {

            //set in hashmap for Folder
            includedsMap.put(directorySystem.getIdName(), directorySystem);

            //set in folder's arraylist
            directorySystem.setParent(this);
            includeds.add(directorySystem);
        } else {
            return 1;
        }
        return 0;
    }

    public ArrayList<String> getElementIdNames() {
        ArrayList<String> elementIdNames = new ArrayList<String>();
        for (DirectorySystem included : includeds) {
            elementIdNames.add(included.getIdName());
        }
        return elementIdNames;
    }

    public String getPath() {
        ArrayList<String> pathes = new ArrayList<String>();
        StringBuilder pathesBuilder = new StringBuilder();
        DirectorySystem temp = this;
        Iterator<String> pathesIterator = null;

        while (temp.getParent() != null) {
            pathes.add(temp.getIdName()); // path paint
            temp = temp.getParent();
        }

        Collections.reverse(pathes); // reverse
        pathesIterator = pathes.iterator();

        while (pathesIterator.hasNext()) {
            pathesBuilder.append(" " + pathesIterator.next());
        }

        return pathesBuilder.toString();
    }

    public HashMap<String, DirectorySystem> getHashMap() {
        return includedsMap;
    }

    @Override
    public String getIdName() {
        return name;
    }

    @Override
    public boolean isContentUser(String idName) {
        for (DirectorySystem included : includeds) {
            if (included.isContentUser(idName) == true) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void sendNotice(String title, String notice) {
        for (DirectorySystem included : includeds) {
            included.sendNotice(title, notice);
        }
    }

    @Override
    public ArrayList<DirectorySystem> getIncludeds() {
        return includeds;
    }

    @Override
    public DirectorySystem getParent() {
        return parent;
    }

    @Override
    public void setParent(DirectorySystem _parent) {
        parent = _parent;
    }

    @Override
    public void remove() {
        ArrayList<DirectorySystem> tempList = new ArrayList<DirectorySystem>();
        for (DirectorySystem included : includeds) {
            tempList.add(included);
        }
        tempList.forEach(e -> {
            e.remove();
        });

        parent.getIncludedsMap().remove(this.getIdName());
        parent.getIncludeds().remove(this);
    }

    @Override
    public Folder getFolder() {
        return this;
    }

    @Override
    public HashMap<String, DirectorySystem> getIncludedsMap() {
        return includedsMap;
    }
}
