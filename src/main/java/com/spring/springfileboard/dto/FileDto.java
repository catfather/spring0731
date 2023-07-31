package com.spring.springfileboard.dto;

import com.spring.springfileboard.entity.BoardEntity;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {

    public Long id;


    private String fileOldName; //db에 암호화 되어서 저장 되는 이름 -> 로컬 저장소에 저장(특정위치)


    private String fileNewName; //원래 이미지 이름 -> db 저장만


    private BoardEntity boardEntity;


    //공통 -> baseEntity 공통 작업


    private LocalDateTime createTime;


    private LocalDateTime updateTime;
}
