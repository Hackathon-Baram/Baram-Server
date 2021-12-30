package com.hackathon.baram.domain.repository;

import com.hackathon.baram.domain.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    List<PostEntity> findAll();

    Optional<PostEntity> findByIdx(Long idx);
}
