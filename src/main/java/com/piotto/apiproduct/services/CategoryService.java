package com.piotto.apiproduct.services;

import com.piotto.apiproduct.domain.Category;
import com.piotto.apiproduct.repositories.CategoryRepository;
import com.piotto.apiproduct.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category getCategory(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Category.class.getName()
        ));
    }
}
