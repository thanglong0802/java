package logichandle;

import entity.GiangVien;
import entity.GiangVienMonHoc;
import entity.MonHoc;

import java.util.Scanner;

public class ChucNang {
    public static GiangVien GIANG_VIEN[] = new GiangVien[50];
    public static MonHoc MON_HOC[] = new MonHoc[50];
    public static GiangVienMonHoc GIANG_VIEN_MON_HOC[] = new GiangVienMonHoc[50];
    public static Scanner SCANNER = new Scanner(System.in);
    public static int INDEX = 0;

    public static void nhapGiangVien() {
        System.out.print("Nhập số lượng giảng viên mới muốn thêm: ");
        int newTeacherNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newTeacherNumber; i++) {
            System.out.println("Nhập thông tin cho giảng viên thứ " + (i + 1));
            GiangVien giangVien = new GiangVien();
            giangVien.nhapThongTin();
            luuGiangVien(giangVien);
        }
    }

    public static void luuGiangVien(GiangVien giangVien) {
        for (int j = 0; j < GIANG_VIEN.length; j++) {
            if (GIANG_VIEN[j] == null) {
                GIANG_VIEN[j] = giangVien;
                break;
            }
        }
    }

    public static void inGiangVien(GiangVien[] giangViens) {
        for (int i = 0; i < giangViens.length; i++) {
            if (giangViens[i] == null) {
                continue;
            }
            System.out.println(giangViens[i]);
        }
    }

    public static void nhapMonHoc() {
        System.out.print("Nhập số lượng môn học mới muốn thêm: ");
        int newSubjectNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newSubjectNumber; i++) {
            System.out.println("Nhập thông tin cho môn học thứ " + (i + 1));
            MonHoc monHoc = new MonHoc();
            monHoc.nhapThongTin();
            luuMonHoc(monHoc);
        }
    }

    public static void luuMonHoc(MonHoc monHoc) {
        for (int j = 0; j < MON_HOC.length; j++) {
            if (MON_HOC[j] == null) {
                MON_HOC[j] = monHoc;
                break;
            }
        }
    }

    public static void inMonHoc(MonHoc[] monHocs) {
        for (int i = 0; i < monHocs.length; i++) {
            if (monHocs[i] == null) {
                continue;
            }
            System.out.println(monHocs[i]);
        }
    }

    public static boolean kiemTraDLGV() {
        for (int i = 0; i < GIANG_VIEN.length; i++) {
            if (GIANG_VIEN[i] != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean kiemTraDLMH() {
        for (int i = 0; i < MON_HOC.length; i++) {
            if (MON_HOC[i] != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean kiemTraDLQL() {
        for (int i = 0; i < GIANG_VIEN_MON_HOC.length; i++) {
            if (GIANG_VIEN_MON_HOC[i] != null) {
                return true;
            }
        }
        return false;
    }

    public static void kiemTraGVMH() {
        if (!(kiemTraDLGV() && kiemTraDLMH())) {
            System.out.println("Chưa có dữ liệu!");
            return;
        }

        do {
            System.out.print("Tiếp tục nhập? (y/n): ");
            String check = new Scanner(System.in).nextLine();
            if (check.equalsIgnoreCase("n")) {
                break;
            }

            GiangVien teacher = pushTeacher();

            System.out.print("Nhập số lượng môn học mà giảng viên này dạy: ");
            int subjectQuantity = new Scanner(System.in).nextInt();
            for (int i = 0; i < subjectQuantity; i++) {
                MonHoc subject = pushSubject(i);
                if (!isTeachingExist(teacher.getId(), subject.getId())) {
                    System.out.print("Nhập số lượng lớp học của môn học này: ");
                    do {
                        int classesQuantity = new Scanner(System.in).nextInt();
                        if (classesQuantity > 0 && classesQuantity < 3) {
                            if (totalLessonsOfTeacher(teacher) + subject.getTongSoTiet() * classesQuantity < 20) {
                                GiangVienMonHoc teaching = new GiangVienMonHoc();
                                teaching.setMonHoc(subject);
                                teaching.setGiangVien(teacher);
                                teaching.setSoLuongLop(classesQuantity);
                                saveTeaching(teaching);
                                break;
                            } else {
                                System.out.println("Tổng số tiết giảng dạy của một giảng viên không được lớn hơn 20");
                                break;
                            }
                        } else
                            System.out.print("Số lớp cho mỗi môn là số nguyên dương và không lớn hơn 3. Vui lòng nhập lại: ");

                    } while (true);

                } else {
                    System.out.println("Kê khai này đã tồn tại");
                    i--;
                }
            }

            System.out.println("=========================================");

        } while (true);

    }

    public static void saveTeaching(GiangVienMonHoc teaching) {
        for (int i = 0; i < GIANG_VIEN_MON_HOC.length; i++) {
            if (GIANG_VIEN_MON_HOC[i] == null) {
                GIANG_VIEN_MON_HOC[i] = teaching;
                return;
            }
        }
    }

    public static GiangVien pushTeacher() {
        System.out.print("Nhập mã giảng viên: ");
        int idTeacher;
        GiangVien teacher = new GiangVien();

        do {
            idTeacher = new Scanner(System.in).nextInt();
            teacher = searchTeacherById(idTeacher);
            if (teacher != null) {
                break;
            }
            System.out.print("Không tồn tại giảng viên có ID là " + idTeacher + ", vui lòng nhập lại: ");
        } while (true);

        return teacher;
    }

    public static MonHoc pushSubject(int index) {
        System.out.print("Nhập mã môn học thứ " + (index + 1) + ": ");
        int idSubject;
        MonHoc subject = new MonHoc();

        do {
            idSubject = new Scanner(System.in).nextInt();
            subject = searchSubjectById(idSubject);
            if (subject != null) {
                break;
            }
            System.out.print("Không tồn tại môn học có ID là " + idSubject + ", vui lòng nhập lại: ");
        } while (true);

        return subject;
    }

    public static GiangVien searchTeacherById(int idTeacher) {
        for (int i = 0; i < GIANG_VIEN.length; i++) {
            GiangVien teacher = GIANG_VIEN[i];
            if (teacher != null && teacher.getId() == idTeacher) {
                return teacher;
            }
        }
        return null;
    }

    public static MonHoc searchSubjectById(int idSubject) {
        for (int i = 0; i < MON_HOC.length; i++) {
            MonHoc subject = MON_HOC[i];
            if (subject != null && subject.getId() == idSubject) {
                return subject;
            }
        }
        return null;
    }

    public static boolean isTeachingExist(int idTeacher, int idSubject) {
        if(!kiemTraDLQL()) return false;
        for(int i=0; i < GIANG_VIEN_MON_HOC.length; i++) {
            if(GIANG_VIEN_MON_HOC[i] != null) {
                if(GIANG_VIEN_MON_HOC[i].getGiangVien().getId() == idTeacher &&
                        GIANG_VIEN_MON_HOC[i].getMonHoc().getId() == idSubject) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int totalLessonsOfTeacher(GiangVien teacher) {
        int sum = 0;
        if(!kiemTraDLQL()) return 0;
        for(int i=0; i < GIANG_VIEN_MON_HOC.length; i++) {
            if(GIANG_VIEN_MON_HOC[i] != null) {
                if(GIANG_VIEN_MON_HOC[i].getGiangVien().getId() == teacher.getId() ) {
                    sum += (GIANG_VIEN_MON_HOC[i].getMonHoc().getTongSoTiet() * GIANG_VIEN_MON_HOC[i].getSoLuongLop());
                }
            }
        }
        return sum;
    }

    public static void showTeaching(GiangVienMonHoc[] teaching) {
        for (int i = 0; i < teaching.length; i++) {
            if (teaching[i] == null) {
                continue;
            }
            System.out.println(teaching[i]);
        }
    }

    public static void showSortTeaching() {
        if(!kiemTraDLQL()) {
            System.out.println("Chưa có dữ liệu về danh sách mượn để thao tác, vui lòng nhập danh sách mượn trước đã!");
            return;
        }

        System.out.println("---Sắp xếp danh sách theo---");
        System.out.println("1. Theo tên giảng viên");
        System.out.println("2. Theo số tiết giảng dạy mỗi môn giảm dần");
        System.out.println("--------------------------------------");
        System.out.print("Xin mời nhập lựa chọn của bạn: ");

        int functionChoice = -1;
        do {
            functionChoice = new Scanner(System.in).nextInt();
            if (functionChoice >= 1 && functionChoice <= 2) {
                break;
            }
            System.out.print("Chức năng được chọn không hợp lệ, vui lòng chọn lại: ");
        } while (functionChoice > 2 || functionChoice < 1);

        switch (functionChoice) {
            case 1: sortByTeacherName(); break;
            case 2: sortBySubjectClasses(); break;
        }


        showTeaching(GIANG_VIEN_MON_HOC);

    }

    public static void sortByTeacherName() {
        for(int i=0; i < GIANG_VIEN_MON_HOC.length - 1; i++) {
            for(int j= i+1; j < GIANG_VIEN_MON_HOC.length; j++) {
                if(GIANG_VIEN_MON_HOC[i] != null && GIANG_VIEN_MON_HOC[j] != null && GIANG_VIEN_MON_HOC[i].getGiangVien().getTenGV().compareTo(
                        GIANG_VIEN_MON_HOC[j].getGiangVien().getTenGV()) > 0) {
                    GiangVienMonHoc tmp = GIANG_VIEN_MON_HOC[i];
                    GIANG_VIEN_MON_HOC[i] = GIANG_VIEN_MON_HOC[j];
                    GIANG_VIEN_MON_HOC[j] = tmp;
                }
            }
        }
    }

    public static void sortBySubjectClasses() {
        for(int i=0; i < GIANG_VIEN_MON_HOC.length - 1; i++) {
            for(int j= i+1; j < GIANG_VIEN_MON_HOC.length; j++) {
                if(GIANG_VIEN_MON_HOC[i] != null && GIANG_VIEN_MON_HOC[j] != null) {
                    int lesson1 = GIANG_VIEN_MON_HOC[i].getMonHoc().getTongSoTiet() * GIANG_VIEN_MON_HOC[i].getSoLuongLop();
                    int lesson2 = GIANG_VIEN_MON_HOC[j].getMonHoc().getTongSoTiet() * GIANG_VIEN_MON_HOC[j].getSoLuongLop();

                    if(lesson1 < lesson2) {
                        GiangVienMonHoc tmp = GIANG_VIEN_MON_HOC[i];
                        GIANG_VIEN_MON_HOC[i] = GIANG_VIEN_MON_HOC[j];
                        GIANG_VIEN_MON_HOC[j] = tmp;
                    }
                }
            }
        }
    }

    public static void showSalary() {
        for (int i = 0; i < GIANG_VIEN.length; i++) {
            if (GIANG_VIEN[i] != null) {
                System.out.println("Giảng viên id là " + GIANG_VIEN[i].getId() + " có lương: "+ calculateSalary(GIANG_VIEN[i]));
            }
        }
    }

    public static int calculateSalary(GiangVien teacher) {
        int salary = 0;

        for(int i=0; i<GIANG_VIEN_MON_HOC.length; i++) {
            if(GIANG_VIEN_MON_HOC[i] != null) {
                if(GIANG_VIEN_MON_HOC[i].getGiangVien().getId() == teacher.getId()) {
                    MonHoc teachSubject = GIANG_VIEN_MON_HOC[i].getMonHoc();
                    salary += (
                            ( (teachSubject.getTongSoTiet() -  teachSubject.getSoTietLyThuyet()) * 0.7 +
                                    teachSubject.getSoTietLyThuyet() ) * teachSubject.getKinhPhi()
                                    * GIANG_VIEN_MON_HOC[i].getSoLuongLop());
                }
            }
        }

        return salary;
    }

}
