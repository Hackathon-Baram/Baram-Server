package com.hackathon.baram.domain.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LikeDto {

    @NotBlank(message = "author는 필수 입력값입니다")
    private String author;

    @NotBlank(message = "idx는 필수 입력값입니다")
    private Long idx;
}
