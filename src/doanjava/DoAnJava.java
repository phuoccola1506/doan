/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doanjava;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DoAnJava {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien[] danhSachSinhVien = null;
        int length;
        int[] thongKe = new int[4];
        boolean bool = true;
        
        do {
            menuGiaoVien();
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    danhSachSinhVien = nhapDSSV(sc);
                    break;
                }
                case 2: {
                    for (int i = 0; i < danhSachSinhVien.length; i++) {
                        xemTTSV(danhSachSinhVien, i);
                    }
                    break;
                }
                case 3: {
                    danhSachSinhVien = themMotSinhVien(danhSachSinhVien, sc);
                    xemTTSV(danhSachSinhVien, danhSachSinhVien.length - 1);
                    break;
                }
                case 4: {
                    timKiemSinhVien(danhSachSinhVien, sc);
                    break;
                }
                case 5: {
                    sapXepDSSV(danhSachSinhVien, sc);
                    for (int i = 0; i < danhSachSinhVien.length; i++) {
                        xemTTSV(danhSachSinhVien, i);
                    }
                    break;
                }
                case 6: {
                    thongKe = thongKe(danhSachSinhVien, sc);
                    thongKeDSSV(thongKe, sc);
                    break;
                }
                case 7: {
                    xuatThongTinRaFile(danhSachSinhVien);
                    break;
                }
                case 8: {
                    nhapThongTinTuFile();
                    for (int i = 0; i < danhSachSinhVien.length; i++) {
                        xemTTSV(danhSachSinhVien, i);
                    }
                    break;
                }
                case 0: {
                    System.out.println("Da thoat chuong trinh thanh cong.");
                    bool = false;
                    break;
                }
                default: {
                    System.out.println("Ban da nhap sai, vui long nhap lai.");
                    break;
                }
            }
            
        } while (bool == true);
    }
    
//    public static void menuMain() {
//        System.out.println("QUAN LI DIEM SINH VIEN");
//        System.out.println("Ban hien la: ");
//        System.out.println("1. Giao vien");
//        System.out.println("2. Sinh vien");
//        System.out.println("0. Thoat chuong trinh");
//        System.out.print("Moi ban chon: ");
//    }
    
    public static void menuGiaoVien() {
        System.out.println("QUAN LI DIEM SINH VIEN");
        System.out.println("Doi tuong: Giao vien");
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Xem danh sach sinh vien");
        System.out.println("3. Them mot sinh vien moi");
        System.out.println("4. Tim kiem mot sinh vien");
        System.out.println("5. Sap xep danh sach sinh vien");
        System.out.println("6. Thong ke danh sach sinh vien");
        System.out.println("7. Xuat thong tin ra file");
        System.out.println("8. Nhap thong tin tu file");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Hay chon chuc nang: ");
    }
    
//    public static void menuSinhVien() {
//        System.out.println("QUAN LI DIEM SINH VIEN");
//        System.out.println("Doi tuong: Sinh vien");
//        System.out.println("1. Xem danh sach sinh vien");
//        System.out.println("2. Tim kiem mot sinh vien");
//        System.out.println("3. Sap xep danh sach sinh vien");
//        System.out.println("4. Thong ke danh sach sinh vien");
//        System.out.print("Hay chon chuc nang: ");
//    }
    
    public static SinhVien[] nhapDSSV(Scanner sc) {
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

            sc.nextLine(); // Đọc bỏ ký tự xuống dòng sau khi nhập điểm thi

            danhSachSinhVien[i] = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);
        }
        
        return danhSachSinhVien;
    }
    
    public static void xemTTSV(SinhVien[] danhSachSinhVien, int i) {
        System.out.println();
        System.out.println("Thông tin sinh viên thứ " + (i + 1) + ":");
        System.out.println("Mã sinh viên: " + danhSachSinhVien[i].maSV);
        System.out.println("Họ tên: " + danhSachSinhVien[i].hoTen);
        System.out.println("Giới tính: " + danhSachSinhVien[i].gioiTinh);
        System.out.println("Tuổi: " + danhSachSinhVien[i].tuoi);
        System.out.printf("Điểm quá trình: %.1f\n", danhSachSinhVien[i].diemQuaTrinh);
        System.out.printf("Điểm thi: %.1f\n", danhSachSinhVien[i].diemThi);
        System.out.printf("Điểm trung bình: %.1f\n", danhSachSinhVien[i].diemTrungBinh);
        System.out.println("Xep loai: " + danhSachSinhVien[i].xepLoai);
        System.out.println();
    }
    
    public static SinhVien[] themMotSinhVien(SinhVien[] danhSachSinhVien, Scanner sc) {
        System.out.println("Them mot sinh vien moi");
        sc.nextLine();
        
        System.out.println("Nhap thong tin cho sinh vien thu " + (danhSachSinhVien.length + 1) + ":");

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

        sc.nextLine(); // Đọc bỏ ký tự xuống dòng sau khi nhập điểm thi

        SinhVien newSinhVien = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);
        
        //Tang kich thuoc mang
        SinhVien[] newDanhSachSinhVien = new SinhVien[danhSachSinhVien.length + 1];
        for (int i =0; i < danhSachSinhVien.length; i++) {
            newDanhSachSinhVien[i] = danhSachSinhVien[i];
        }
        newDanhSachSinhVien[danhSachSinhVien.length] = newSinhVien;
        
        System.out.println("Them mot sinh vien moi thanh cong!");
        
        return newDanhSachSinhVien;
    }
    
    public static void timKiemSinhVien(SinhVien[] danhSachSinhVien, Scanner sc) {
        System.out.println("Nhap ma sinh vien can tim: ");
        String maSVCanTim = sc.nextLine();
        sc.nextLine();
        
        boolean timKiem = false;
        String maSVKiemTra = "";
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            maSVKiemTra = danhSachSinhVien[i].hoTen;
            if (maSVKiemTra.equalsIgnoreCase(maSVCanTim)) {
                xemTTSV(danhSachSinhVien, i);
                timKiem = true;
            }
        }
        
        if (!timKiem) {
            System.out.println("Khong tim thay sinh vien co ma \"" + maSVCanTim + "\".");
        }
    }
    
    public static void sapXepDSSV(SinhVien[] danhSachSinhVien, Scanner sc) {
        SinhVien temp = null;
        
        for (int i = 0; i < danhSachSinhVien.length - 1; i++) {
            for (int j = 0; j < danhSachSinhVien.length - i - 1; j++) {
                if (danhSachSinhVien[j].diemTrungBinh < danhSachSinhVien[j+1].diemTrungBinh) {
                    temp = danhSachSinhVien[j];
                    danhSachSinhVien[j] = danhSachSinhVien[j+1];
                    danhSachSinhVien[j+1] = temp;
                }
            }
        }
    }
    
    public static void thongKeDSSV(int[] thongKe, Scanner sc) {
        System.out.println("Thong ke danh sach sinh vien");
        System.out.println("1. Theo xep loai");
        System.out.println("2. Theo diem trung binh");
        System.out.println("Hay chon chuc nang");
        
        int choiceTK = sc.nextInt();
        if (choiceTK == 1) {
            System.out.println("Thong ke DSSV theo xep loai");
            System.out.println("So luong sinh vien Gioi: " + thongKe[0]);
            System.out.println("So luong sinh vien Kha: " + thongKe[1]);
            System.out.println("So luong sinh vien TB: " + thongKe[2]);
            System.out.println("So luong sinh vien Yeu: " + thongKe[3]);
        }
        if (choiceTK == 2) {
            System.out.println("Thong ke DSSV theo diem trung binh");
            System.out.println("So luong sinh vien DTB >= 8: " + thongKe[0]);
            System.out.println("So luong sinh vien DTB >= 6,5: " + thongKe[1]);
            System.out.println("So luong sinh vien DTB >= 5: " + thongKe[2]);
            System.out.println("So luong sinh vien DTB < 5: " + thongKe[3]);
        }
    }
    
    public static int[] thongKe(SinhVien[] danhSachSinhVien, Scanner sc) {
        int soSVGioi = 0;
        int soSVKha = 0;
        int soSVTB = 0;
        int soSVYeu = 0;
        int[] thongKe = new int[4];
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            if (danhSachSinhVien[i].diemTrungBinh >= 8) {
                soSVGioi++;
            }
            else if (danhSachSinhVien[i].diemTrungBinh >= 6.5) {
                soSVKha++;
            }
            else if (danhSachSinhVien[i].diemTrungBinh >= 5) {
                soSVTB++;
            }
            else {
                soSVYeu++;
            }
        }
        
        thongKe[0] = soSVGioi;
        thongKe[1] = soSVKha;
        thongKe[2] = soSVTB;
        thongKe[3] = soSVYeu;
        return thongKe;
    }
    
    public static void xuatThongTinRaFile(SinhVien[] danhSachSinhVien) {
        try {
            FileWriter writer = new FileWriter("sinhvien.txt");
            for (SinhVien sv : danhSachSinhVien) {
//                String line = String.format("%s, %s, %S, %d, %.1f, %.1f\n", sv.maSV, sv.hoTen, sv.gioiTinh, sv.tuoi, 
//                        sv.diemQuaTrinh, sv.diemThi);
//                writer.write(line);
                writer.write("Ma sinh vien: " + sv.maSV + "\n");
                writer.write("Ho ten sinh vien: " + sv.hoTen + "\n");
                writer.write("Gioi tinh: " + sv.gioiTinh + "\n");
                writer.write("Tuoi: " + sv.tuoi + "\n");
                writer.write("Diem qua trinh: " + sv.diemQuaTrinh + "\n");
                writer.write("Diem thi: " + sv.diemThi + "\n");
                
            }
            writer.close();
            System.out.println("Xuat thong tin danh sach sinh vien ra file thanh cong.");
        } catch (IOException e) {
            System.out.println("Da xay ra loi khi xuat danh sach sinh vien ra file.");
            e.printStackTrace();
        }
    }
    
    public static void nhapThongTinTuFile() {
        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        String tenFile = "sinhvien.txt";
        
        try {
            File file = new File(tenFile);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String maSV = scanner.nextLine().replace("Ma sinh vien: ", "");
                String hoTen = scanner.nextLine().replace("Ho ten sinh vien: ", "");
                String gioiTinh = scanner.nextLine().replace("Gioi tinh: ", "");
                int tuoi = Integer.parseInt(scanner.nextLine().replace("Tuoi: ", ""));
                double diemQuaTrinh = Double.parseDouble(scanner.nextLine().replace("Diem qua trinh: ", ""));
                double diemThi = Double.parseDouble(scanner.nextLine().replace("Diem thi: ", ""));
                scanner.nextLine();
                
                SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);
                danhSachSinhVien.add(sv);
            }
            scanner.close();
            System.out.println("Nhap thong tin danh sach sinh vien tu file thanh cong.");
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + tenFile);
            e.printStackTrace();
        }
    }
}
