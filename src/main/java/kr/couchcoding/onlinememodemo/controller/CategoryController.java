package kr.couchcoding.onlinememodemo.controller;

import kr.couchcoding.onlinememodemo.dto.CategoryDTO;
import kr.couchcoding.onlinememodemo.entity.Category;
import kr.couchcoding.onlinememodemo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @GetMapping("")
    public Page<Category> getCategories(Pageable pageable, @RequestParam String keyword){
        return categoryService.getCategories(pageable, keyword);
    }

    @PostMapping("")
    public Category categoryDTO(@RequestBody CategoryDTO categoryDTO){
        return categoryService.createCategory(categoryDTO);
    }

}
