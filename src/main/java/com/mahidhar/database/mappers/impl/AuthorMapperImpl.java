package com.mahidhar.database.mappers.impl;

import com.mahidhar.database.domain.Entities.AuthorEntity;
import com.mahidhar.database.domain.dto.AuthorDto;
import com.mahidhar.database.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapperImpl implements Mapper<AuthorEntity, AuthorDto> {
    private final ModelMapper modelMapper;

    public AuthorMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }
    @Override
    public AuthorDto mapTo(AuthorEntity authorEntity) {
        return modelMapper.map(authorEntity,AuthorDto.class);
    }

    @Override
    public AuthorEntity mapFrom(AuthorDto authorDto) {
        return modelMapper.map(authorDto, AuthorEntity.class);
    }
}
