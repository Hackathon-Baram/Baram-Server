package com.hackathon.baram.domain.repository;

import com.hackathon.baram.domain.entity.PostEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @EntityGraph(attributePaths = "likes")
    @Query("select likes from PostEntity likes")
    List<PostEntity> findAll(Sort sort);

    PostEntity findByIdx(Long idx);
}
