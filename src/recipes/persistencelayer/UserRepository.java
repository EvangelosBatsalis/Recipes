package recipes.persistencelayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import recipes.businesslayer.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByEmail(String email);

    User findByEmail(String email);

    //query test but i prefer JPA Crud instead of JDBC:
//    @Query(value = "select id,name,roll_no from USER_INFO_TEST where rollNo = ?1", nativeQuery = true)
//    ArrayList<IUserProjection> findUserUsingRollNo(String rollNo);

}
