package com.api.log.LogRepository;

import com.api.log.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;


public interface FollowRepository extends JpaRepository<Follow, Integer> {
    @Query(value = "select followed_id from follow where user_id = ?1", nativeQuery = true)
    List<Integer> findMyFollowedId(Integer id);

    @Query(value = "delete from follow where followed_id = ?1",nativeQuery = true)
    @Modifying
    @Transactional
    void deleteByFollowed_id(Integer id);


}