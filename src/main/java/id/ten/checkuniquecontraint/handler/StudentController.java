package id.ten.checkuniquecontraint.handler;

import id.ten.checkuniquecontraint.domain.Student;
import id.ten.checkuniquecontraint.exception.StudentNotFoundException;
import id.ten.checkuniquecontraint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class StudentController {

    @Autowired
    private StudentService studentservice;

    @GetMapping(value="/students")
    public List<Student> getAllStudents(){
        return studentservice.getAllStudents();
    }
    @GetMapping(value="/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) int id) {
        Student std = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }
    @PostMapping(value="/students")
    public Student addStudent(@Valid @RequestBody Student std) {
        return studentservice.save(std);
    }
    @PutMapping(value="/students/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student newstd) {
        Student stdu = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        stdu.setFirstName(newstd.getFirstName());
        stdu.setLastName(newstd.getLastName());
        stdu.setEmail(newstd.getEmail());
        return studentservice.save(stdu);
    }
    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) int id) {
        Student std = studentservice.findById(id)
                .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        studentservice.deleteById(std.getId());
        return "Student with ID :"+id+" is deleted";
    }
}
