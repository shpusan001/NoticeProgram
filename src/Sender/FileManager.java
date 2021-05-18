/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sender;

import java.io.*;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 * @현재 디렉토리정보를 직렬화 해서 저장 ./Saves폴더에 저장
 * @싱글톤 패턴
 *
 * @author 이상훈
 */
public class FileManager {

    private static FileManager fileManager;

    public static FileManager getFileManager() {
        if (fileManager == null) {
            fileManager = new FileManager();
        }
        return fileManager;
    }

    public void saveDirectory() {
        try {
            FileOutputStream fs = new FileOutputStream(new File("Saves/SaveFile.ser"));
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(DirectoryManager.getDirectoryManager());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "File Not Found", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDirectory() {
        try {
            FileInputStream fs = new FileInputStream(new File("Saves/SaveFile.ser"));
            ObjectInputStream os = new ObjectInputStream(fs);

            Object object_LoadedDirectory = os.readObject();
            DirectoryManager loadedDirectory = (DirectoryManager) object_LoadedDirectory;

            os.close();

            DirectoryManager.getDirectoryManager().setDirectoryManager(loadedDirectory);
            AdministratorPage.administratorPage.showDirectory();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
