package entity;

public class QuanLy {
    private GiangVien giangVien;
    private GiangVienMonHoc giangVienMonHoc[];

    public QuanLy(GiangVien giangVien, GiangVienMonHoc[] giangVienMonHoc) {
        this.giangVien = giangVien;
        this.giangVienMonHoc = giangVienMonHoc;
    }

    public QuanLy() {
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }
    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }
    public GiangVienMonHoc[] getGiangVienMonHoc() {
        return giangVienMonHoc;
    }
    public void setGiangVienMonHoc(GiangVienMonHoc[] giangVienMonHoc) {
        this.giangVienMonHoc = giangVienMonHoc;
    }
}
