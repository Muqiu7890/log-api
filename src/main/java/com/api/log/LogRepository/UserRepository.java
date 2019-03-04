
package com.api.log.LogRepository;

import com.api.log.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value="select * from user where id in(select followed_id from follow where user_id = ?1)",nativeQuery=true)
    List<User> findAllFollowedUserById(Integer id);

    @Query(value = "select * from user where id = ?1",nativeQuery = true)
    User findUserByFollowId(Integer id);
}