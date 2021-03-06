package com.api.log.LogRepository;

import com.api.log.entity.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LogRepository extends JpaRepository<Log, Integer> {
    @Query(value = "select * from log where user_id = ?1",nativeQuery=true)
    Page<Log> findAllLogByUserId(Pageable pageable, Integer id);

    @Query(value = "select * from log where user_id = ?1",nativeQuery = true)
    List<Log> findLogByFollowId(Integer id);

    @Query(value = "select * from log where exc = ?1", nativeQuery = true)
    Page<Log> getAllId(Integer id,Pageable pageable);

}

