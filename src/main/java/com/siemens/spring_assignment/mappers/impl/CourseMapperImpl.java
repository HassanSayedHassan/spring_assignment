package com.siemens.spring_assignment.mappers.impl;

import com.siemens.spring_assignment.domains.dtos.CourseDto;
import com.siemens.spring_assignment.domains.entities.CourseEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseMapperImpl implements Mapper<CourseEntity, CourseDto> {

    private final ModelMapper modelMapper;

    public CourseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDto toDto(CourseEntity CourseEntity) {
        return modelMapper.map(CourseEntity, CourseDto.class);
    }

    @Override
    public CourseEntity toEntity(CourseDto CourseDto) {
        return modelMapper.map(CourseDto, CourseEntity.class);
    }
}
