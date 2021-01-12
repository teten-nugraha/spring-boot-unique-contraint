package id.ten.checkuniquecontraint.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty(message = "First name is required")
    @NotNull(message = "first name not be null")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty(message = "Last name is required")
    @NotNull(message = "last name not be null")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    @NotEmpty(message = "email is required")
    @NotNull(message = "email not be null")
    private String email;

}
