
package com.api.log.LogRepository;

import com.api.log.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value="select * from user where id in(select followed_id from follow where user_id = ?1)",nativeQuery=true)
    List<User> findAllFollowedUserById(Integer id);

    @Query(value = "select * from user where id = ?1",nativeQuery = true)
    User findUserByFollowId(Integer id);

    List<User> findByNameLike(String name);
}