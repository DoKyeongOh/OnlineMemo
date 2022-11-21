package kr.couchcoding.onlinememodemo.controller;

import kr.couchcoding.onlinememodemo.dto.MemoDTO;
import kr.couchcoding.onlinememodemo.entity.Memo;
import kr.couchcoding.onlinememodemo.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memos")
@AllArgsConstructor
public class MemoController {

    private MemoService memoService;

    @PostMapping("")
    public Memo createMemo(@RequestBody MemoDTO memoDTO){
        return memoService.createMemo(memoDTO);
    }

}
