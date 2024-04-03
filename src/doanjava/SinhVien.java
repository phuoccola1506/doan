/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doanjava;

/**
 *
 * @author TGDD
 */
public class SinhVien {
    public String maSV;
    public String hoTen;
    public String gioiTinh;
    public int tuoi;
    public double diemQuaTrinh;
    public double diemThi;
    public double diemTrungBinh;
    public String xepLoai;

    public SinhVien(String maSV, String hoTen, String gioiTinh, int tuoi, double diemQuaTrinh, double diemThi) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemThi = diemThi;
        this.diemTrungBinh = (diemQuaTrinh * 0.4f) + (diemThi * 0.6f);
        if (diemTrungBinh >= 8) {
            xepLoai = "A - Gioi";
        }
        else if (diemTrungBinh >= 6.5) {
            xepLoai = "B - Kha";
        }
        else if (diemTrungBinh >= 5) {
            xepLoai = "C - TB";
        }
        else {
            xepLoai = "D - Yeu";
        }
    }
    
}
