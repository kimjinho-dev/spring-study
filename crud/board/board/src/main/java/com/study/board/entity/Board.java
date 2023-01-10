package com.study.board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity // 엔티티 설정
@Data // 데이터 받도록 하는 어노테이션
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 해당 설정으로 board PK 오류 해결(이유는 잘 모름)
    private Integer id;
    private String title;
    private String content;

}
