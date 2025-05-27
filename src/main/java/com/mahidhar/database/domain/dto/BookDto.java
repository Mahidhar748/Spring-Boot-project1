package com.mahidhar.database.domain.dto;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDto {
    private String sibn;
    private String title;

    private AuthorDto author;

}
