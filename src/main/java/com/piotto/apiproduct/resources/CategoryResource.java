package com.piotto.apiproduct.resources;

import com.piotto.apiproduct.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping
    public List<Category> list() {
        Category cat1 = new Category(1, "Category 1");
        Category cat2 = new Category(2, "Category 2");

        List<Category> categories = new ArrayList<>();
        categories.add(cat1);
        categories.add(cat2);

        return categories;
    }
}
