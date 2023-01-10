package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired // 뒤에 new 없어도 자동으로 불러오도록
    private BoardService boardService;

    @GetMapping("/")
    @ResponseBody // return 값으로 표시한다
    public String main() {
        return "Hello Word";
    }

    @GetMapping("/write")
    public String boardWriteForm() {
        return "boardwrite";
    }


    @PostMapping("/board/writedo")
    public String boardWritePro(Board board) {
        boardService.write(board); // borarService 의 wirte 메서드 board 파라미터로 실행
        System.out.println(board.getTitle());
        return "";
    }
}
