package com.api.log.LogRepository;

import com.api.log.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FollowRepository extends JpaRepository<Follow, Integer> {
    @Query(value = "select followed_id from follow where user_id = ?1", nativeQuery = true)
    List<Integer> findMyFollowedId(Integer id);
}