package kr.couchcoding.onlinememodemo.service;


import kr.couchcoding.onlinememodemo.dto.MemoDTO;
import kr.couchcoding.onlinememodemo.entity.Category;
import kr.couchcoding.onlinememodemo.entity.Memo;
import kr.couchcoding.onlinememodemo.repository.CategoryRepository;
import kr.couchcoding.onlinememodemo.repository.MemoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MemoService {
    private MemoRepository memoRepository;
    private CategoryRepository categoryRepository;

    public Memo createMemo(MemoDTO memoDTO){
        Optional<Memo> memoOptional = memoRepository.findByName(memoDTO.getName());
        if (memoOptional.isPresent())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 메모입니다.");

        Category category = categoryRepository.getCategoriesById(memoDTO.getCategory_id());
        Memo memo = Memo.builder()
                .id(memoDTO.getId())
                .name(memoDTO.getName())
                .content(memoDTO.getContent())
                .category(category)
                .build();

        return memoRepository.save(memo);
    }

}
