package com.siemens.spring_assignment.mappers.impl;

import com.siemens.spring_assignment.domains.dtos.StudentDto;
import com.siemens.spring_assignment.domains.entities.StudentEntity;
import com.siemens.spring_assignment.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements Mapper<StudentEntity, StudentDto> {

    private final ModelMapper modelMapper;

    public StudentMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDto toDto(StudentEntity studentEntity) {
        return modelMapper.map(studentEntity, StudentDto.class);
    }

    @Override
    public StudentEntity toEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, StudentEntity.class);
    }
}
