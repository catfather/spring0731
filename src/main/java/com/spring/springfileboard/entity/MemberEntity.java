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
@Table(name = "file_member_tb")
@Builder
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    public Long id;

    @Column(name = "member_name", length = 10, nullable = false)
    public String name;

    @Column(name = "member_email", length = 40, nullable = false)
    public String Email;

    @OneToMany(mappedBy = "memberEntity",
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE) //제약 조건 부모 삭제시 자식 삭제
    private List<BoardEntity> boardEntityList;

    //공통 -> baseEntity 공통 작업

    @Timestamp
    @Column(name = "createTime")
    private LocalDateTime createTime;

    @Timestamp
    @Column(name = "updateTime")
    private LocalDateTime updateTime;

    private static Object toEntity(Object dto) {

        return dto;
    }

}
