package com.hackathon.baram.domain.repository;

import com.hackathon.baram.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    List<PostEntity> findAll();

    Optional<PostEntity> findByIdx(Long idx);
}
