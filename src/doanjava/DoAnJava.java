/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doanjava;

import java.util.Scanner;

public class DoAnJava {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        do {
            menuMain();
            int choice = sc.nextInt();
            switch (choice) {
                case 0: {
                    bool = false;
                    break;
                }
                case 1: {
                    menuQLPhong();
                    break;
                }
                case 2: {
                    
                }
                case 3: {
                    
                }
                default: {
                    System.out.println("Ban da nhap sai, vui long nhap lai");
                    break;
                }
            }
        } while (bool == true);
    }
    
    public static void menuMain() {
        System.out.println("QUAN LI KHACH SAN");
        System.out.println("1. Quan li phong");
        System.out.println("2. Quan li khach hang");
        System.out.println("3. Quan li nhan vien");
        System.out.println("0. Thoat chuong trinh");
    }
    
    public static void menuQLPhong() {
        System.out.println("QUAN LI PHONG");
        System.out.println("1. Xem toan bo phong");
        System.out.println("2. Xem cac phong con trong");
    }
    
    public static void menuQLKhachHang() {
        System.out.println("QUAN LI KHACH HANG");
        System.out.println("1. Xem thong tin toan bo khach hang");
        System.out.println("2. Xem thong tin cac khach hang dang su dung dich vu");
    }
    
    public static void menuQLNhanVien() {
        System.out.println("QUAN LI NHAN VIEN");
        System.out.println("1. Xem thong tin toan bo nhan vien");
        System.out.println("2. Phan loai nhan vien");
        System.out.println("3. Danh gia nhan vien");
    }
    
}
