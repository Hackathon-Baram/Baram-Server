package com.hackathon.baram.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx", unique = true, nullable = false)
    private Long idx;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PostEntity postEntity;

    public LikeEntity(String uuid, PostEntity postEntity) {
        this.uuid = uuid;
        this.postEntity = postEntity;
    }
}