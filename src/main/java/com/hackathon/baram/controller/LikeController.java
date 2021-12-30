package com.hackathon.baram.controller;

import com.hackathon.baram.domain.dto.LikeDto;
import com.hackathon.baram.domain.response.Response;
import com.hackathon.baram.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
@CrossOrigin(value = "*")
public class LikeController {

    private final LikeService likeService;

    @PostMapping("")
    public Response add(@Valid @RequestBody LikeDto likeDto) {
        likeService.addLike(likeDto);

        return new Response(HttpStatus.OK, "성공");
    }
}
