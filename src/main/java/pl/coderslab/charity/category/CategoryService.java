package pl.coderslab.charity.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    private final CategoryRepository categoryRepository;
}
