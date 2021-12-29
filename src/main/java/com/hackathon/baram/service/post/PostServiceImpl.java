package com.hackathon.baram.service.post;

import com.hackathon.baram.domain.dto.PostDto;
import com.hackathon.baram.domain.entity.PostEntity;
import com.hackathon.baram.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public void createPost(PostDto postDto) {
        postRepository.save(postDto.toEntity());
    }

    @Override
    public List<PostEntity> getPosts() {

        return postRepository.findAll();
    }
}
