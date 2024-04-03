/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doanjava;

import java.util.Scanner;

/**
 *
 * @author TGDD
 */
public class SinhVienDao {
    public  SinhVien[] nhapDSSV(Scanner sc) {
        System.out.println("======================================");
        System.out.println("Nhap so luong sinh vien: ");
        int n = sc.nextInt();
        sc.nextLine();
        SinhVien[] danhSachSinhVien = new SinhVien[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin cho sinh vien thu " + (i + 1) + ":");

            System.out.print("Ma sinh vien: ");
            String maSV = sc.nextLine();

            System.out.print("Ho ten: ");
            String hoTen = sc.nextLine();

            System.out.print("Gioi tinh: ");
            String gioiTinh = sc.nextLine();

            System.out.print("Tuoi: ");
            int tuoi = sc.nextInt();

            System.out.print("Diem qua trinh: ");
            double diemQuaTrinh = sc.nextDouble();

            System.out.print("Diem thi: ");
            double diemThi = sc.nextDouble();

            while (diemQuaTrinh < 0 || diemThi < 0) {
                System.out.println("Diem qua trinh va diem thi khong the nho hon 0");
                System.out.println("Nhap lai diem qua trinh va diem thi");
                System.out.print("Diem qua trinh: ");
                diemQuaTrinh = sc.nextDouble();

                System.out.print("Diem thi: ");
                diemThi = sc.nextDouble();
            }
            sc.nextLine();

            danhSachSinhVien[i] = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);
        }

        return danhSachSinhVien;
    }
}
