package com.example.demo_serge;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    static final String URL = "jdbc:mysql://localhost:3306/home_work_38";
    static final String USER = "root";
    static final String PASS = "Cancel_77";

    static final String FIND_ALL_STUDENTS = "SELECT * FROM new_table";

    public List<Student> ReadStudentsInfo() {
        List<Student> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(FIND_ALL_STUDENTS);) {
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getInt("id_student"));
                    student.setName(rs.getString("name_student"));
                    student.setAge(rs.getInt("age_student"));
                    result.add(student);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void saveStudent(Student student) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            String ins_std = "INSERT INTO new_table (name_student, age_student) VALUES (\"" + student.getName() + "\", " + student.getAge() + ")";

            PreparedStatement ps = conn.prepareStatement(ins_std);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
