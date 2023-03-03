package recipes.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "email")
    @Email(regexp = ".+@.+\\..+", message = "email syntax is not correct")
    private String email;

    @Size(min = 8, message = "Password does not meet the requirements")
    @NotBlank
    @Column(name = "password")
    private String password;

//    @OneToMany(mappedBy = "recipeid",cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private List<Recipe> recipeList;
}
