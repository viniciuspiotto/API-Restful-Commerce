package com.piotto.apiproduct.resources;

import com.piotto.apiproduct.domain.Category;
import com.piotto.apiproduct.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService categoryService;

    public CategoryResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> list(@PathVariable Integer id) {
        Category obj = categoryService.getCategory(id);
        return ResponseEntity.ok().body(obj);
    }
}
