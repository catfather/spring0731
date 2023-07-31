package com.spring.springfileboard.dto;

import com.spring.springfileboard.entity.FileEntity;
import com.spring.springfileboard.entity.MemberEntity;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    public Long id;


    @NotBlank(message = "제목을 입력하세요!")
    @Size(min=5, max=100)
    public String title;

    @NotBlank(message = "내용을 입력하세요!")
    @Size(min=5, max=255)
    public String content;

    @NotBlank(message = "작성자를 입력하세요!")
    @Size(min=5, max=100)
    public String writer;

    public int hit;

    public int isFile;

    private MemberEntity memberEntity;

    private List<FileEntity> fileEntityList;


    //공통 -> baseEntity 공통 작업

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
