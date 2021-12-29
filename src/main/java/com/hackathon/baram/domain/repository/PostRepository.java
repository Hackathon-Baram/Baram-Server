package com.hackathon.baram.domain.repository;

import com.hackathon.baram.domain.entity.PostEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    
    List<PostEntity> findAll(Sort sort);

    PostEntity findByIdx(Long idx);
}
