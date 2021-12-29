package com.hackathon.baram.service.post;

import com.hackathon.baram.domain.dto.PostDto;
import com.hackathon.baram.domain.entity.PostEntity;

import java.util.List;

public interface PostService {

    void createPost(PostDto postDto);

    PostEntity findPostByIdx(Long idx);

    List<PostEntity> getPosts();
}
