package com.hackathon.baram.domain.repository;

import com.hackathon.baram.domain.entity.LikeEntity;
import com.hackathon.baram.domain.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    Optional<LikeEntity> findByAuthorAndPost(String uuid, PostEntity post);
}
