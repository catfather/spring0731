package com.spring.springfileboard.entity;

import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "file_tb_31")
@Builder
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    public Long id;

    @Column(nullable = false)
    private String fileOldName; //db에 암호화 되어서 저장 되는 이름 -> 로컬 저장소에 저장(특정위치)

    @Column(nullable = false)
    private String fileNewName; //원래 이미지 이름 -> db 저장만

    //boardEntity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "board_id") //boardEntity -> board_id
    private BoardEntity boardEntity;


    //공통 -> baseEntity 공통 작업

    @Timestamp
    @Column(name = "createTime")
    private LocalDateTime createTime;

    @Timestamp
    @Column(name = "updateTime")
    private LocalDateTime updateTime;
}
