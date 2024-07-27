package com.piotto.apiproduct.services;

import com.piotto.apiproduct.domain.Category;
import com.piotto.apiproduct.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category getCategory(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
