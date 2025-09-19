package com.LMS.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO {

    @NotBlank(message = "Book name cannot be blank")
    @Size(max = 50)
    private String name;

    @NotBlank(message = "Author name cannot be blank")
    @Size(max = 50)
    private String author;

    @NotBlank(message = "Category cannot be blank")
    @Size(max = 50)
    private String category;

    @NotBlank(message = "ISBN cannot be blank")
    @Size(min = 10, max = 13, message = "ISBN must be 10 or 13 characters")
    private String isbn;

    @NotNull(message = "Book copies cannot be null")
    @Min(value = 0, message = "Book copies cannot be negative")
    private Integer book_copies;
}
