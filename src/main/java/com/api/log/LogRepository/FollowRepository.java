package com.api.log.LogRepository;

import com.api.log.entity.Follow;
import com.api.log.entity.Log;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowRepository extends JpaRepository <Follow, Integer>{
    @Query(value = "select * from log where user_id = ?1",nativeQuery=true)
    List<Log> getAllLogByUserId(Pageable pageable, Integer id);

}