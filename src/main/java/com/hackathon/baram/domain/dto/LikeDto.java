package com.hackathon.baram.domain.dto;

import com.hackathon.baram.domain.entity.LikeEntity;
import com.hackathon.baram.domain.entity.PostEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LikeDto {

    @NotBlank(message = "author는 필수 입력값입니다")
    private String author;

    @NotNull(message = "idx는 필수 입력값입니다")
    private Long idx;

    public LikeEntity toEntity(PostEntity postEntity) {
        return LikeEntity.builder()
                .author(author)
                .postEntity(postEntity)
                .build();
    }
}
