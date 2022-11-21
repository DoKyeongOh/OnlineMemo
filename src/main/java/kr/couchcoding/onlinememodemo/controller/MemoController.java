package kr.couchcoding.onlinememodemo.controller;

import kr.couchcoding.onlinememodemo.dto.MemoDTO;
import kr.couchcoding.onlinememodemo.entity.Memo;
import kr.couchcoding.onlinememodemo.service.MemoService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memos")
@AllArgsConstructor
public class MemoController {

    private MemoService memoService;

    @GetMapping("")
    public Page<Memo> getMemos(@RequestParam(required = false) String keyword, Pageable pageable) {
        return memoService.getMemos(pageable, keyword);
    }

    @GetMapping("/{id}")
    public Memo getMemo(@PathVariable Long id) {
        return memoService.getMemo(id);
    }

    @PostMapping("")
    public Memo createMemo(@RequestBody MemoDTO memoDTO){
        return memoService.createMemo(memoDTO);
    }

    @PutMapping("")
    public Memo modifyMemo(@RequestBody MemoDTO memoDTO){
        return memoService.modifyMemo(memoDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteMemo(@PathVariable Long id){
        memoService.deleteMemo(id);
        return "success";
    }

}
