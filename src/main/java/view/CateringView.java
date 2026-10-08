package view;

import controller.CateringController;
import model.*;
import java.util.Scanner;

public class CateringView {
    private CateringController controller = new CateringController();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int pilih = 0;
        while (pilih != 6) {
            System.out.println("\n=== SISTEM MANAJEMEN CATERING (MVC) ===");
            System.out.println("1. Lihat Semua Menu");
            System.out.println("2. Tambah Makanan");
            System.out.println("3. Tambah Minuman");
            System.out.println("4. Hapus Menu");
            System.out.println("5. Update Menu");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilih = scanner.nextInt();
            scanner.nextLine();

            switch (pilih) {
                case 1:
                    if (controller.getDaftarMenu().isEmpty()) {
                        System.out.println("Belum ada data menu.");
                    } else {
                        for (MenuCatering m : controller.getDaftarMenu()) {
                            m.tampilDetail();
                        }
                    }
                    break;
                case 2:
                    System.out.print("ID: "); int idM = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nama: "); String namaM = scanner.nextLine();
                    System.out.print("Harga: "); double hargaM = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Tingkat Pedas: "); String pedas = scanner.nextLine();
                    controller.tambahMenu(new MenuMakanan(idM, namaM, hargaM, pedas));
                    break;
                case 3:
                    System.out.print("ID: "); int idMin = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nama: "); String namaMin = scanner.nextLine();
                    System.out.print("Harga: "); double hargaMin = scanner.nextDouble(); scanner.nextLine();
                    System.out.print("Ukuran: "); String ukuran = scanner.nextLine();
                    controller.tambahMenu(new MenuMinuman(idMin, namaMin, hargaMin, ukuran));
                    break;
                case 4:
                    System.out.print("Masukkan ID yang dihapus: ");
                    int idHapus = scanner.nextInt();
                    controller.hapusData(idHapus);
                    break;
                case 5:
                    System.out.print("Masukkan ID menu yang ingin diupdate: ");
                    int idUpdate = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Masukkan Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    System.out.print("Masukkan Harga Baru: ");
                    double hargaBaru = scanner.nextDouble(); scanner.nextLine();
                    controller.updateData(idUpdate, namaBaru, hargaBaru);
                    break;
                case 6:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}