package id.ten.checkuniquecontraint.service.impl;

import id.ten.checkuniquecontraint.domain.Student;
import id.ten.checkuniquecontraint.repository.StudentRepository;
import id.ten.checkuniquecontraint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student save(Student std) {
        return repository.save(std);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
