package com.spring.springfileboard.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file_board_tb")
@Builder
public class BoardEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    public Long id;

    @Column(length = 40, nullable = false)
    public String title;

    @Column(length = 40, nullable = false)
    public String content;

    @Column(length = 40, nullable = false)
    public String writer;

    public int hit;

    //파일
    @Column(length = 40, nullable = false)
    public int isFile;


    //memberEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "member_id") //memberEntity -> member_id
    private MemberEntity memberEntity;

    @OneToMany(mappedBy = "boardEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE) //제약 조건 부모 삭제시 자식 삭제
    private List<FileEntity> fileEntityList;


    //공통 -> baseEntity 공통 작업

    @Timestamp
    @Column(name = "createTime")
    private LocalDateTime createTime;

    @Timestamp
    @Column(name = "updateTime")
    private LocalDateTime updateTime;


}
