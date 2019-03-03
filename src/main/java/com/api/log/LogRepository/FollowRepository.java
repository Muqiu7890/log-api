package com.api.log.LogRepository;

import com.api.log.entity.Follow;
import com.api.log.entity.Log;
import com.api.log.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FollowRepository extends JpaRepository<Follow, Integer> {
    @Query(value = "select followed_id from follow where user_id = ?1", nativeQuery = true)
    List<Integer> getMyFollowedId(Integer id);

//    @Query(value = "select * from log where user_id = ?1",nativeQuery = true)
//    List<Log> getLogByFollowId(Integer id);

//    @Query(value = "select * from user where id = ?1",nativeQuery = true)
//    List<User> getUserByFollowId(Integer id);
}