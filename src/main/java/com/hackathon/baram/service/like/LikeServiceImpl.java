package com.hackathon.baram.service.like;

import com.hackathon.baram.domain.dto.LikeDto;
import com.hackathon.baram.domain.entity.LikeEntity;
import com.hackathon.baram.domain.entity.PostEntity;
import com.hackathon.baram.domain.repository.LikeRepository;
import com.hackathon.baram.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public void addLike(LikeDto likeDto) {

        PostEntity post = findPostByIdx(likeDto.getIdx());

        Optional<LikeEntity> like = likeRepository.findByAuthorAndPost(likeDto.getAuthor(), post);
        if (like.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "이미 좋아요를 눌렀습니다");
        }

        likeRepository.save(likeDto.toEntity(post));
    }

    private PostEntity findPostByIdx(Long idx) {
        return postRepository.findByIdx(idx)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "존재하지 않는 게시물"));
    }
}
