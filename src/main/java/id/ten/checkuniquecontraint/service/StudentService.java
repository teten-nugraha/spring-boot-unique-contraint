package id.ten.checkuniquecontraint.service;

import id.ten.checkuniquecontraint.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> findById(int id);
    Optional<Student> findByEmail(String email);
    Student save(Student std);
    void deleteById(int id);
}
