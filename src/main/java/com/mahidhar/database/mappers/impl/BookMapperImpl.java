package com.mahidhar.database.mappers.impl;

import com.mahidhar.database.domain.Entities.BookEntity;
import com.mahidhar.database.domain.dto.BookDto;
import com.mahidhar.database.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImpl implements Mapper<BookEntity, BookDto> {

    private final ModelMapper modelMapper;

    public BookMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }


    @Override
    public BookDto mapTo(BookEntity bookEntity) {
        return modelMapper.map(bookEntity,BookDto.class);
    }

    @Override
    public BookEntity mapFrom(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
}
