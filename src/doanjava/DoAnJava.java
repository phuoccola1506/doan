/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doanjava;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class DoAnJava {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien[] danhSachSinhVien = null;
        int a;
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
                    xemDSSV(danhSachSinhVien);
                    break;
                }
                case 3: {
                    danhSachSinhVien = themMotSinhVien(danhSachSinhVien, sc);
                    xemDSSV(danhSachSinhVien);
                    break;
                }
                case 4: {
                    a = timKiemSinhVien(danhSachSinhVien, sc);
                    suaDiemSinhVien(danhSachSinhVien, sc, a);
                    break;
                }
                case 5: {
                    a = timKiemSinhVien(danhSachSinhVien, sc);
                    danhSachSinhVien = xoaMotSinhVien(danhSachSinhVien, sc, a);
                    break;
                }
                case 6: {
                    sapXepDSSV(danhSachSinhVien, sc);
                    xemDSSV(danhSachSinhVien);
                    break;
                }
                case 7: {
                    thongKe = thongKe(danhSachSinhVien, sc);
                    thongKeDSSV(thongKe, sc);
                    break;
                }
                case 8: {
                    xuatThongTinRaFile(danhSachSinhVien);
                    break;
                }
                case 9: {
                    danhSachSinhVien = nhapThongTinTuFile();
                    if (danhSachSinhVien != null) {
                        xemDSSV(danhSachSinhVien);
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

    public static void menuGiaoVien() {
        System.out.println("QUAN LI DIEM SINH VIEN");
        System.out.println("Doi tuong: Giao vien");
        System.out.println("1. Nhap thong tin sinh vien");
        System.out.println("2. Xem danh sach sinh vien");
        System.out.println("3. Them mot sinh vien moi");
        System.out.println("4. Sua diem mot sinh vien");
        System.out.println("5. Xoa mot sinh vien");
        System.out.println("6. Sap xep danh sach sinh vien");
        System.out.println("7. Thong ke danh sach sinh vien");
        System.out.println("8. Xuat thong tin ra file");
        System.out.println("9. Nhap thong tin tu file");
        System.out.println("0. Thoat chuong trinh");
        System.out.print("Hay chon chuc nang: ");
    }

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

            if (diemQuaTrinh < 0 || diemThi < 0) {
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

    public static void xemDSSV(SinhVien[] danhSachSinhVien) {
        System.out.println("+========================================================================================+");
        System.out.println("|                                   DANH SACH SINH VIEN                                  |");
        System.out.println("+========================================================================================+");
        System.out.printf("|%7s|%25s|%5s|%4s|%10s|%10s|%10s|%10s|\n",
                "MaSV", "Ho va ten", "GT", "Tuoi", "DiemQT", "DiemThi", "DiemTB", "XepLoai");
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            System.out.printf("|%7s|%25s|%5s|%4d|%10.1f|%10.1f|%10.1f|%10s|\n",
                    danhSachSinhVien[i].maSV,
                    danhSachSinhVien[i].hoTen,
                    danhSachSinhVien[i].gioiTinh,
                    danhSachSinhVien[i].tuoi,
                    danhSachSinhVien[i].diemQuaTrinh,
                    danhSachSinhVien[i].diemThi,
                    danhSachSinhVien[i].diemTrungBinh,
                    danhSachSinhVien[i].xepLoai);
        }
        System.out.println("+========================================================================================+");
    }

    public static void xemTTSV(SinhVien[] danhSachSinhVien, int i) {
        System.out.println("+========================================================================================+");
        System.out.println("|                                   BANG DIEM SINH VIEN                                  |");
        System.out.println("+========================================================================================+");
        System.out.printf("|%7s|%25s|%5s|%4s|%10s|%10s|%10s|%10s|\n",
                "MaSV", "Ho va ten", "GT", "Tuoi", "DiemQT", "DiemThi", "DiemTB", "XepLoai");
        System.out.printf("|%7s|%25s|%5s|%4d|%10.1f|%10.1f|%10.1f|%10s|\n",
                danhSachSinhVien[i].maSV,
                danhSachSinhVien[i].hoTen,
                danhSachSinhVien[i].gioiTinh,
                danhSachSinhVien[i].tuoi,
                danhSachSinhVien[i].diemQuaTrinh,
                danhSachSinhVien[i].diemThi,
                danhSachSinhVien[i].diemTrungBinh,
                danhSachSinhVien[i].xepLoai);
        System.out.println("+========================================================================================+");
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

        if (diemQuaTrinh < 0 || diemThi < 0) {
            System.out.println("Diem qua trinh va diem thi khong the nho hon 0");
            System.out.println("Nhap lai diem qua trinh va diem thi");
            System.out.print("Diem qua trinh: ");
            diemQuaTrinh = sc.nextDouble();

            System.out.print("Diem thi: ");
            diemThi = sc.nextDouble();
        }
        sc.nextLine(); // Đọc bỏ ký tự xuống dòng sau khi nhập điểm thi

        SinhVien newSinhVien = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);

        //Tang kich thuoc mang
        SinhVien[] newDanhSachSinhVien = new SinhVien[danhSachSinhVien.length + 1];
        for (int i = 0; i < danhSachSinhVien.length; i++) {
            newDanhSachSinhVien[i] = danhSachSinhVien[i];
        }
        newDanhSachSinhVien[danhSachSinhVien.length] = newSinhVien;

        System.out.println("Them mot sinh vien moi thanh cong!");

        return newDanhSachSinhVien;
    }

    public static int timKiemSinhVien(SinhVien[] danhSachSinhVien, Scanner sc) {
        sc.nextLine();
        System.out.println("Nhap ma sinh vien can tim: ");
        String maSVCanTim = sc.nextLine();

        int daTimThay = 0;
        boolean timKiem = false;
        for (int i = 0; i < (danhSachSinhVien.length); i++) {
            String maSVKiemTra = danhSachSinhVien[i].maSV;
            if (maSVKiemTra.equalsIgnoreCase(maSVCanTim)) {
                daTimThay = i;
                xemTTSV(danhSachSinhVien, daTimThay);
                timKiem = true;
            }
        }

        if (!timKiem) {
            System.out.println("Khong tim thay sinh vien co ma \"" + maSVCanTim + "\".");
        }

        return daTimThay;
    }

    public static void suaDiemSinhVien(SinhVien[] danhSachSinhVien, Scanner sc, int a) {
        System.out.println("Nhap diem qua trinh moi");
        danhSachSinhVien[a].diemQuaTrinh = sc.nextFloat();
        System.out.println("Nhap diem thi moi");
        danhSachSinhVien[a].diemThi = sc.nextFloat();
        System.out.println("Sua diem cho sinh vien thanh cong.");
    }

    public static SinhVien[] xoaMotSinhVien(SinhVien[] danhSachSinhVien, Scanner sc, int a) {
        SinhVien[] newDanhSachSinhVien = new SinhVien[danhSachSinhVien.length - 1];
        for (int i = a; i < danhSachSinhVien.length - 1; i++) {
            danhSachSinhVien[i] = danhSachSinhVien[i + 1];
        }
        for (int i = 0; i < newDanhSachSinhVien.length; i++) {
            newDanhSachSinhVien[i] = danhSachSinhVien[i];
        }

        return newDanhSachSinhVien;
    }

    public static void sapXepDSSV(SinhVien[] danhSachSinhVien, Scanner sc) {
        SinhVien temp = null;

        for (int i = 0; i < danhSachSinhVien.length - 1; i++) {
            for (int j = 0; j < danhSachSinhVien.length - i - 1; j++) {
                if (danhSachSinhVien[j].diemTrungBinh < danhSachSinhVien[j + 1].diemTrungBinh) {
                    temp = danhSachSinhVien[j];
                    danhSachSinhVien[j] = danhSachSinhVien[j + 1];
                    danhSachSinhVien[j + 1] = temp;
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
            } else if (danhSachSinhVien[i].diemTrungBinh >= 6.5) {
                soSVKha++;
            } else if (danhSachSinhVien[i].diemTrungBinh >= 5) {
                soSVTB++;
            } else {
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

    public static SinhVien[] nhapThongTinTuFile() {
        ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();
        String tenFile = "sinhvien.txt";

        try {
            File file = new File(tenFile);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(": ");

                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key) {
                        case "Ma sinh vien":
                            String maSV = value;
                            String hoTen = scanner.nextLine().split(": ")[1].trim();
                            String gioiTinh = scanner.nextLine().split(": ")[1].trim();
                            int tuoi = Integer.parseInt(scanner.nextLine().split(": ")[1].trim());
                            double diemQuaTrinh = Double.parseDouble(scanner.nextLine().split(": ")[1].trim());
                            double diemThi = Double.parseDouble(scanner.nextLine().split(": ")[1].trim());

                            SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, tuoi, diemQuaTrinh, diemThi);
                            danhSachSinhVien.add(sv);
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Dòng không đúng định dạng: " + line);
                }
            }
            scanner.close();
            System.out.println("Nhập thông tin danh sách sinh viên từ file thành công.");
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file: " + tenFile);
            e.printStackTrace();
        }

        return danhSachSinhVien.toArray(new SinhVien[0]);
    }
}
