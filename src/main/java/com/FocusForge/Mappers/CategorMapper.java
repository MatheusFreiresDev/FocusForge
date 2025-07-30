package com.FocusForge.Mappers;

import com.FocusForge.Controller.Request.CategoryRequest;
import com.FocusForge.Controller.Response.CategoryResponse;
import com.FocusForge.Entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategorMapper {

    public static Category toEntity(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        return category;
    }

    public static CategoryResponse toResponse(Category category) {
        return CategoryResponse.builder()
                .name(category.getName())
                .build();
    }
}
