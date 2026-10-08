/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import model.*;
import interfaces.IProyekService;

/**
 *
 * @author user
 */
public class ProyekController implements IProyekService {
    private final ArrayList<ProyekTypeset> daftarProyek = new ArrayList<>();

    public ProyekController() {
        Komik komik1 = new Komik("K01", "Solo Leveling", "Action");
        Typesetter ts1 = new TypesetterTetap("TS01", "Ahzami", 3500000);
        daftarProyek.add(new ProyekTypeset("PRJ01", komik1, ts1, 100, "Dalam Pengerjaan"));
    }

    @Override
    public void tambahProyek(ProyekTypeset proyek) {
        daftarProyek.add(proyek);
    }

    @Override
    public ArrayList<ProyekTypeset> getAllProyek() {
        return daftarProyek;
    }

    @Override
    public boolean updateProyek(int index, Integer chapterBaru, String statusBaru) {
        if (index >= 0 && index < daftarProyek.size()) {
            ProyekTypeset p = daftarProyek.get(index);
            if (chapterBaru != null) {
                p.setChapter(chapterBaru);
            }
            if (statusBaru != null && !statusBaru.trim().isEmpty()) {
                p.setStatus(statusBaru);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean hapusProyek(int index) {
        if (index >= 0 && index < daftarProyek.size()) {
            daftarProyek.remove(index);
            return true;
        }
        return false;
    }
}