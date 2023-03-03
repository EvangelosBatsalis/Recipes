package recipes.businesslayer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Lombok annotations
@Data
@AllArgsConstructor
@NoArgsConstructor

//Spring-Entity annotations
@Entity
@Table(name = "RECIPE")
public class Recipe {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotBlank
    //@NonNull
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Column(name = "category")
    private String category;

    @Column(name = "date")
    private LocalDateTime date;

    @NotBlank
    @Column(name = "description")
    private String description;

    @ElementCollection
    @Size(min = 1)
    @CollectionTable(name = "INGREDIENTS", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredients")
    private List<String> ingredients = new ArrayList<>();

    @ElementCollection
    @Size(min = 1)
    @CollectionTable(name = "DIRECTIONS", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "directions")
    private List<String> directions = new ArrayList<>();

    //    @NotBlank
    @JsonIgnore
    @Column(name = "user_id")
    private int user_id;

//    @ElementCollection
//    @CollectionTable(name = "USER", joinColumns = @JoinColumn(name = "recipe_id"))
//    private List<User> userList = new ArrayList<>();

//    @JsonIgnore
//    //Cant use cascade.all because user in that case will be deleted with recipe
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "recipeid")
//    private User user;

}
