package kr.couchcoding.onlinememodemo.controller;

import kr.couchcoding.onlinememodemo.dto.CategoryDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PostMapping("")
    public CategoryDTO categoryDTO(@RequestBody CategoryDTO categoryDTO){
        return categoryDTO;
    }

}
