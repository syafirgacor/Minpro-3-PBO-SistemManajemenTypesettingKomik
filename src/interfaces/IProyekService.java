/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import model.ProyekTypeset;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public interface IProyekService {
    void tambahProyek(ProyekTypeset proyek);
    ArrayList<ProyekTypeset> getAllProyek();
    boolean updateProyek(int index, Integer chapterBaru, String statusBaru);
    boolean hapusProyek(int index);
}