package com.hackathon.baram.domain.dto;

import com.hackathon.baram.domain.entity.PostEntity;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class PostDto {

    @NotBlank(message = "content는 필수 입력값입니다")
    private String content;

    public PostEntity toEntity () {
        return PostEntity.builder()
                .content(content)
                .build();
    }
}
