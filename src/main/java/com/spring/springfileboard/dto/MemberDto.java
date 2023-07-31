package com.spring.springfileboard.dto;

import com.spring.springfileboard.entity.BoardEntity;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDto {


    public Long id;

    @NotBlank(message = "이름을 입력하세요!")
    public String name;
    
    @Email(message = "이메일 형식 오류 입니다")
    public String Email;

    private List<BoardEntity> boardEntityList;


    //공통 -> baseEntity 공통 작업

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
