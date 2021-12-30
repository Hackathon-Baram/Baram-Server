package com.hackathon.baram.service.post;

import com.hackathon.baram.domain.dto.PostDto;
import com.hackathon.baram.domain.entity.PostEntity;
import com.hackathon.baram.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
    public PostEntity findPostByIdx(Long idx) {
        return postRepository.findByIdx(idx)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "존재하지 않는 게시물"));
    }

    @Override
    public List<PostEntity> getPosts() {

        return postRepository.findAll();
    }
}
