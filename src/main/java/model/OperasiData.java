package model;

public interface OperasiData {
    void tambahData();
    void hapusData(int id);
    void updateData(int id, String namaBaru, double hargaBaru);
}