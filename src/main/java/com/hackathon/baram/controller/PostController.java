package com.hackathon.baram.controller;

import com.hackathon.baram.domain.dto.PostDto;
import com.hackathon.baram.domain.entity.PostEntity;
import com.hackathon.baram.domain.response.Response;
import com.hackathon.baram.domain.response.ResponseData;
import com.hackathon.baram.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping(value = "")
    public Response create(@RequestBody PostDto postDto) {
        postService.createPost(postDto);

        return new Response(HttpStatus.OK, "성공");
    }

    @GetMapping(value = "")
    public ResponseData<List<PostEntity>> get() {
        List<PostEntity> list = postService.getPosts();

        return new ResponseData<>(HttpStatus.OK, "성공", list);
    }

    @GetMapping(value = "/uuid")
    public ResponseData<String> uuid() {
        String uuid = UUID.randomUUID().toString();

        return new ResponseData<>(HttpStatus.OK, "성공", uuid);
    }
}
