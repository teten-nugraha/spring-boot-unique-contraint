package id.ten.checkuniquecontraint.validator;

import id.ten.checkuniquecontraint.domain.Student;
import id.ten.checkuniquecontraint.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private StudentRepository repository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        final Optional<Student> student = repository.findByEmail(email);
        if (student.isPresent()){
            return false;
        }
        return true;
    }
}
