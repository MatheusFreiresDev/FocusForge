package com.FocusForge.Service;

import com.FocusForge.Controller.Request.CategoryRequest;
import com.FocusForge.Controller.Response.CategoryResponse;
import com.FocusForge.Entity.Category;
import com.FocusForge.Mappers.CategorMapper;
import com.FocusForge.Repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryResponse create(CategoryRequest request) {
        Category category = CategorMapper.toEntity(request);
        category = categoryRepository.save(category);
        return CategorMapper.toResponse(category);
    }

    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategorMapper::toResponse)
                .collect(Collectors.toList());
    }

    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        return CategorMapper.toResponse(category);
    }

    public CategoryResponse update(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        category.setName(request.name());
        category = categoryRepository.save(category);
        return CategorMapper.toResponse(category);
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria não encontrada");
        }
        categoryRepository.deleteById(id);
    }
}
