package com.blog.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Integer categoryId;

    @NotEmpty(message = "Title is required!")
    private String categoryTitle;

    @NotEmpty(message = "Description is required!")
    @Size(min = 4,message = "Description min 4 character!")
    private String categoryDescription;
}
