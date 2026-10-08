package controller;

import model.*;
import java.util.ArrayList;

public class CateringController implements OperasiData {
    private final ArrayList<MenuCatering> daftarMenu = new ArrayList<>();

    public CateringController() {
        // Dummy data awal
        daftarMenu.add(new MenuMakanan(1, "Ayam Goreng", 20000, "Sedang"));
        daftarMenu.add(new MenuMinuman(2, "Es Teh", 5000, "Jumbo"));
    }

    public ArrayList<MenuCatering> getDaftarMenu() {
        return daftarMenu;
    }

    public void tampilkanSemuaMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada menu yang tersimpan.");
            return;
        }
        for (MenuCatering menu : daftarMenu) {
            menu.tampilDetail();
        }
    }

    @Override
    public void tambahData(MenuCatering menu) {
        daftarMenu.add(menu);
    }

    @Override
    public void hapusData(int id) {
        boolean ditemukan = daftarMenu.removeIf(menu -> menu.getId() == id);
        if (ditemukan) {
            System.out.println("Data menu berhasil dihapus!");
        } else {
            System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
        }
    }

    @Override
    public void updateData(int id, String namaBaru, double hargaBaru) {
        for (MenuCatering menu : daftarMenu) {
            if (menu.getId() == id) {
                menu.setNama(namaBaru);
                menu.setHarga(hargaBaru);
                System.out.println("Data menu berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Menu dengan ID " + id + " tidak ditemukan.");
    }
}