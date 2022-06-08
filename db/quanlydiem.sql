/* I. CREATE TABLES */

-- faculty (Khoa trong trường)
create table faculty (
	id number primary key,
	name nvarchar2(30) not null
);

-- subject (Môn học)
create table subject(
	id number primary key,
	name nvarchar2(100) not null,
	lesson_quantity number(2,0) not null -- tổng số tiết học
);

-- student (Sinh viên)
create table student (
	id number primary key,
	name nvarchar2(30) not null,
	gender nvarchar2(10) not null, -- giới tính
	birthday date not null,
	hometown nvarchar2(100) not null, -- quê quán
	scholarship number, -- học bổng
	faculty_id number not null constraint faculty_id references faculty(id) -- mã khoa
);

-- exam management (Bảng điểm)
create table exam_management(
	id number primary key,
	student_id number not null constraint student_id references student(id),
	subject_id number not null constraint subject_id references subject(id),
	number_of_exam_taking number not null, -- số lần thi (thi trên 1 lần được gọi là thi lại) 
	mark number(4,2) not null -- điểm
);


/*================================================*/

/* II. INSERT SAMPLE DATA */

-- subject
insert into subject (id, name, lesson_quantity) values (1, n'Cơ sở dữ liệu', 45);
insert into subject values (2, n'Trí tuệ nhân tạo', 45);
insert into subject values (3, n'Truyền tin', 45);
insert into subject values (4, n'Đồ họa', 60);
insert into subject values (5, n'Văn phạm', 45);

-- faculty
insert into faculty values (1, n'Anh - Văn');
insert into faculty values (2, n'Tin học');
insert into faculty values (3, n'Triết học');
insert into faculty values (4, n'Vật lý');

-- student
insert into student values (1, n'Nguyễn Thị Hải', n'Nữ', to_date('19900223', 'YYYYMMDD'), 'Hà Nội', 130000, 2);
insert into student values (2, n'Trần Văn Chính', n'Nam', to_date('19921224', 'YYYYMMDD'), 'Bình Định', 150000, 4);
insert into student values (3, n'Lê Thu Yến', n'Nữ', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 150000, 2);
insert into student values (4, n'Lê Hải Yến', n'Nữ', to_date('19900221', 'YYYYMMDD'), 'TP HCM', 170000, 2);
insert into student values (5, n'Trần Anh Tuấn', n'Nam', to_date('19901220', 'YYYYMMDD'), 'Hà Nội', 180000, 1);
insert into student values (6, n'Trần Thanh Mai', n'Nữ', to_date('19910812', 'YYYYMMDD'), 'Hải Phòng', null, 3);
insert into student values (7, n'Trần Thị Thu Thủy', n'Nữ', to_date('19910102', 'YYYYMMDD'), 'Hải Phòng', 10000, 1);

-- exam_management
insert into exam_management values (1, 1, 1, 1, 3);
insert into exam_management values (2, 1, 1, 2, 6);
insert into exam_management values (3, 1, 2, 2, 6);
insert into exam_management values (4, 1, 3, 1, 5);
insert into exam_management values (5, 2, 1, 1, 4.5);
insert into exam_management values (6, 2, 1, 2, 7);
insert into exam_management values (7, 2, 3, 1, 10);
insert into exam_management values (8, 2, 5, 1, 9);
insert into exam_management values (9, 3, 1, 1, 2);
insert into exam_management values (10, 3, 1, 2, 5);
insert into exam_management values (11, 3, 3, 1, 2.5);
insert into exam_management values (12, 3, 3, 2, 4);
insert into exam_management values (13, 4, 5, 2, 10);
insert into exam_management values (14, 5, 1, 1, 7);
insert into exam_management values (15, 5, 3, 1, 2.5);
insert into exam_management values (16, 5, 3, 2, 5);
insert into exam_management values (17, 6, 2, 1, 6);
insert into exam_management values (18, 6, 4, 1, 10);


/*================================================*/

/* III. QUERY */

 /********* A. BASIC QUERY *********/

-- 1. Liệt kê danh sách sinh viên sắp xếp theo thứ tự:
--      a. id tăng dần
--      b. giới tính
--      c. ngày sinh TĂNG DẦN và học bổng GIẢM DẦN
SELECT * FROM STUDENT s ORDER BY s.id;
SELECT * FROM STUDENT s ORDER BY s.gender;
SELECT * FROM STUDENT s ORDER BY s.birthday ASC, s.scholarship DESC;

-- 2. Môn học có tên bắt đầu bằng chữ 'T'
SELECT * FROM SUBJECT WHERE name LIKE 'T%';
-- 3. Sinh viên có chữ cái cuối cùng trong tên là 'i'
SELECT * FROM STUDENT WHERE name LIKE '%i';
-- 4. Những khoa có ký tự thứ hai của tên khoa có chứa chữ 'n'
SELECT * FROM FACULTY WHERE name LIKE '_n%';
-- 5. Sinh viên trong tên có từ 'Thị'
SELECT * FROM STUDENT WHERE name LIKE '%Thị%';
-- 6. Sinh viên có ký tự đầu tiên của tên nằm trong khoảng từ 'a' đến 'm', sắp xếp theo họ tên sinh viên
SELECT * FROM STUDENT WHERE name LIKE '[a-m]%' ORDER BY name;
-- 7. Sinh viên có học bổng lớn hơn 100000, sắp xếp theo mã khoa giảm dần
SELECT * FROM STUDENT WHERE scholarship > 100000 ORDER BY faculty_id DESC;
-- 8. Sinh viên có học bổng từ 150000 trở lên và sinh ở Hà Nội
SELECT * FROM STUDENT WHERE scholarship >= 150000 AND hometown = 'Hà Nội';
-- 9. Những sinh viên có ngày sinh từ ngày 01/01/1991 đến ngày 05/06/1992
SELECT * FROM STUDENT WHERE birthday >= TO_DATE('01/01/1991') AND birthday <= TO_DATE('05/06/1992');
-- 10. Những sinh viên có học bổng từ 80000 đến 150000
SELECT * FROM STUDENT WHERE scholarship BETWEEN 80000 AND 150000;
-- 11. Những môn học có số tiết lớn hơn 30 và nhỏ hơn 45
SELECT * FROM SUBJECT WHERE lesson_quantity > 30 AND lesson_quantity < 45;


-------------------------------------------------------------------

/********* B. CALCULATION QUERY *********/

-- 1. Cho biết thông tin về mức học bổng của các sinh viên, gồm: Mã sinh viên, Giới tính, Mã 
		-- khoa, Mức học bổng. Trong đó, mức học bổng sẽ hiển thị là “Học bổng cao” nếu giá trị 
		-- của học bổng lớn hơn 500,000 và ngược lại hiển thị là “Mức trung bình”.
        
-- 2. Tính tổng số sinh viên của toàn trường
SELECT COUNT(*) "tổng số sinh viên" FROM STUDENT;
-- 3. Tính tổng số sinh viên nam và tổng số sinh viên nữ.
SELECT * FROM (SELECT COUNT(*) "tổng nam" FROM STUDENT WHERE gender = 'Nam'),
                (SELECT COUNT(*) "tổng nữ" FROM STUDENT WHERE gender = 'Nữ');
-- 4. Tính tổng số sinh viên từng khoa
SELECT COUNT(*) "tổng" FROM STUDENT GROUP BY faculty_id;
-- 5. Tính tổng số sinh viên của từng môn học
select subject.name, count(exam_management.student_id) from exam_management, subject where subject.id = exam_management.subject_id group by subject.name;

-- 6. Tính số lượng môn học mà sinh viên đã học
SELECT student_id, COUNT(subject_id) 
FROM exam_management 
GROUP BY student_id;
-- 7. Tổng số học bổng của mỗi khoa	
SELECT faculty.name, COUNT(student.scholarship)
FROM faculty, student
WHERE faculty.id = student.faculty_id
GROUP BY faculty.name;
-- 8. Cho biết học bổng cao nhất của mỗi khoa
SELECT faculty.name, MAX(student.scholarship)
FROM faculty, student
WHERE faculty.id = student.id
GROUP BY faculty.name;
-- 9. Cho biết tổng số sinh viên nam và tổng số sinh viên nữ của mỗi khoa
SELECT faculty.name, gender, COUNT(student.id) soSV
FROM student, faculty
WHERE faculty.id = student.faculty_id AND gender = 'Nam'
GROUP BY faculty.name, gender
UNION
SELECT faculty.name, gender, COUNT(student.id) soSV
FROM student, faculty
WHERE faculty.id = student.faculty_id AND gender = 'N?'
GROUP BY faculty.name, gender;
-- 10. Cho biết số lượng sinh viên theo từng độ tuổi
SELECT student.birthday, COUNT(student.id) AS soSV
FROM student
GROUP BY student.birthday;
-- 11. Cho biết những nơi nào có ít nhất 2 sinh viên đang theo học tại trường
SELECT student.hometown, COUNT(student.id) as total 
FROM student 
GROUP BY hometown 
HAVING COUNT(student.id) >= 2;
-- 12. Cho biết những sinh viên thi lại ít nhất 2 lần
SELECT student.name,  COUNT(exam_management.number_of_exam_taking) AS soLanThiLai
FROM student, exam_management
WHERE exam_management.student_id = student.id
GROUP BY student.name
HAVING COUNT(exam_management.number_of_exam_taking) >= 2;
-- 13. Cho biết những sinh viên nam có điểm trung bình lần 1 trên 7.0 
SELECT student.name, AVG(exam_management.mark)
FROM student, exam_management
WHERE student.gender = 'Nam' AND student.id = exam_management.student_id AND exam_management.number_of_exam_taking = 1
GROUP BY student.name
HAVING AVG(exam_management.mark) > 7;
-- 14. Cho biết danh sách các sinh viên rớt ít nhất 2 môn ở lần thi 1 (rớt môn là điểm thi của môn không quá 4 điểm)
SELECT student.name 
FROM student, exam_management
WHERE exam_management.number_of_exam_taking = 1 and exam_management.mark <= 4 and student.id = exam_management.student_id 
GROUP BY student.name;
-- 15. Cho biết danh sách những khoa có nhiều hơn 2 sinh viên nam
SELECT faculty.name
FROM faculty, student
WHERE student.gender = 'Nam' AND student.faculty_id = faculty.id
GROUP BY faculty.name
HAVING COUNT(student.gender) > 2;
-- 16. Cho biết những khoa có 2 sinh viên đạt học bổng từ 200000 đến 300000
SELECT faculty.name
FROM faculty, student
WHERE faculty.id = student.faculty_id AND student.scholarship BETWEEN 20000 AND 30000
GROUP BY faculty.name
HAVING COUNT(student.id)= 2;
-- 17. Cho biết sinh viên nào có học bổng cao nhất
SELECT student.name, MAX(student.scholarship) AS hocBongCaoNhat
FROM student
WHERE student.scholarship = (SELECT MAX(student.scholarship) FROM student)
GROUP BY student.name;

-------------------------------------------------------------------

/********* C. DATE/TIME QUERY *********/

-- 1. Sinh viên có nơi sinh ở Hà Nội và sinh vào tháng 02
SELECT * FROM STUDENT WHERE hometown = 'Hà Nội' AND extract(month from birthday)= '02';
-- 2. Sinh viên có tuổi lớn hơn 20
SELECT *
FROM STUDENT
WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, BIRTHDAY) / 12) > 20;
-- 3. Sinh viên sinh vào mùa xuân năm 1990
SELECT student.name
FROM student
WHERE TO_CHAR(student.birthday,'MM')IN('01', '02', '03') AND TO_CHAR(student.birthday, 'YYYY') = '1990';

-------------------------------------------------------------------

/********* D. JOIN QUERY *********/

-- 1. Danh sách các sinh viên của khoa ANH VĂN và khoa VẬT LÝ
SELECT * 
FROM student
INNER JOIN faculty ON student.faculty_id = faculty.id
WHERE faculty.name ='Anh - Văn' OR faculty.name ='Vật lý';
-- 2. Những sinh viên nam của khoa ANH VĂN và khoa TIN HỌC
SELECT student.name, faculty.name
FROM student
JOIN faculty 
ON student.faculty_id = faculty.id
AND student.gender = 'Nam';
-- 3. Cho biết sinh viên nào có điểm thi lần 1 môn cơ sở dữ liệu cao nhất
SELECT student.name, exam_management.mark 
FROM exam_management
JOIN student 
ON student.id = exam_management.student_id
WHERE number_of_exam_taking = 1 AND subject_id = 1
AND mark= (SELECT max(mark) FROM exam_management
WHERE number_of_exam_taking = 1 AND subject_id = 1);
-- 4. Cho biết sinh viên khoa anh văn có tuổi lớn nhất.
SELECT student.name, faculty.name, current_year - to_number(to_char(student.birthday, 'YYYY')) AS age
FROM faculty , student, (select to_number(to_char(sysdate, 'YYYY')) current_year from dual)
WHERE faculty.name = 'Anh - Văn' AND student.faculty_id = faculty.id
AND  current_year - to_number(to_char(student.birthday, 'YYYY')) =(SELECT MAX(current_year - to_number(to_char(student.birthday, 'YYYY')))from student);
-- 5. Cho biết khoa nào có đông sinh viên nhất
SELECT faculty.name, COUNT(student.id) 
FROM  student 
INNER JOIN faculty
ON faculty.id = student.faculty_id 
GROUP BY faculty.name 
HAVING COUNT(student.faculty_id)>= ALL(SELECT COUNT(student.id) FROM student GROUP BY student.faculty_id);
-- 6. Cho biết khoa nào có đông nữ nhất
SELECT faculty.name, COUNT(student.id) 
FROM  student 
INNER JOIN faculty
ON faculty.id = student.faculty_id
AND student.gender = 'Nữ'
GROUP BY faculty.name 
HAVING COUNT(student.faculty_id)>= ALL(SELECT COUNT(student.id) FROM student WHERE student.gender = 'Nữ' GROUP BY student.faculty_id);
-- 7. Cho biết những sinh viên đạt điểm cao nhất trong từng môn
SELECT student.name , MAX(mark) 
FROM student
INNER JOIN exam_management
ON  exam_management.student_id = student.id
GROUP BY student.name;
-- 8. Cho biết những khoa không có sinh viên học
SELECT faculty.name, COUNT(student.id) 
FROM faculty
JOIN student 
ON faculty.id = student.faculty_id
GROUP BY faculty.name 
HAVING COUNT(student.id) = 0;
-- 9. Cho biết sinh viên chưa thi môn cơ sở dữ liệu
SELECT student.name, COUNT(subject_id) 
FROM exam_management
JOIN student 
ON exam_management.student_id = student.id
WHERE NOT exam_management.subject_id = 1
GROUP BY student.name;
-- 10. Cho biết sinh viên nào không thi lần 1 mà có dự thi lần 2
SELECT * FROM exam_management;
SELECT student.name
FROM exam_management
JOIN student 
ON student.id = exam_management.student_id
WHERE number_of_exam_taking = 2 AND NOT EXISTS (SELECT id , student_id, subject_id, exam_management.number_of_exam_taking , mark
FROM exam_management WHERE number_of_exam_taking = 1 AND student.id = exam_management.student_id);