package com.hackathon.baram.service.like;

import com.hackathon.baram.domain.dto.LikeDto;
import com.hackathon.baram.domain.entity.PostEntity;
import com.hackathon.baram.domain.repository.LikeRepository;
import com.hackathon.baram.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostService postService;

    @Override
    @Transactional
    public void addLike(LikeDto likeDto) {

        PostEntity post = postService.findPostByIdx(likeDto.getIdx());
        existByAuthorAndPost(likeDto.getAuthor(), post);

        likeRepository.save(likeDto.toEntity(post));
    }

    private void existByAuthorAndPost(String uuid, PostEntity post) {
        if (likeRepository.existsByAuthorAndPost(uuid, post)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "이미 좋아요를 눌렀습니다");
        }
    }
}
